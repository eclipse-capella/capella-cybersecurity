/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.massactions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnprovider.AbstractMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;

public class PrimaryAssetColumns extends AbstractMAColumnProvider {

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> commonPossibleFeatures,
      Collection<EObject> data) {

    if (data.stream().filter(e -> !(e instanceof PrimaryAsset)).findAny().isPresent()) {
      return Collections.emptyList();
    }

    return Arrays.asList(
        new PrimaryAssetType(),
        new ThreatKind(),
        new ThreatLevel(),
        new Rationale(),
        new ThreatSourceProfile(),
        new Confidentiality(),
        new Integrity(),
        new Availability(),
        new Traceability(),
        new RealizedBy(),
        new Component()
        );
  }
  
  static class PrimaryAssetType extends AbstractCybersecurityColumn {
    public PrimaryAssetType() {
      id = getClass().getCanonicalName();
      label = Messages.PrimaryAssetColumns_Label_Type;
      name = Messages.PrimaryAssetColumns_Name_Type;
    }
    @Override
    public Object getDataValue(EObject rowObject) {
      if (rowObject.eClass() == CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET) {
        return Messages.PrimaryAssetColumns_PrimaryAssetType_functional;
      }
      if (rowObject.eClass() == CybersecurityPackage.Literals.INFORMATION_PRIMARY_ASSET) {
        return Messages.PrimaryAssetColumns_PrimaryAssetType_information;
      }
      return rowObject.eClass().getName();
    }
  }

  // displays the threat kinds, even if multiple different kinds threaten the asset
  static class ThreatKind extends AbstractCybersecurityColumn {
    public ThreatKind() {
      id = getClass().getCanonicalName();
      label = Messages.PrimaryAssetColumns_Label_ThreatKind;
      name = Messages.PrimaryAssetColumns_Name_ThreatKind;
    }
    @Override
    public Object getDataValue(EObject rowObject) {
      return CybersecurityQueries
        .getThreatsOf(((PrimaryAsset) rowObject))
        .map(t -> t.getThreatKind() == null ? "null" : t.getThreatKind().getLiteral()) //$NON-NLS-1$
        .distinct()
        .collect(Collectors.joining("/")); //$NON-NLS-1$
    }
  }

  //displays the max level of all threats to the asset
   static class ThreatLevel extends AbstractCybersecurityColumn {
     public ThreatLevel() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_MaxThreatLevel;
       name = Messages.PrimaryAssetColumns_Name_MaxThreatLevel;
     }
     @Override
     public Object getDataValue(EObject rowObject) {
       return CybersecurityQueries
         .getThreatsOf(((PrimaryAsset) rowObject))
         .map(t -> t.getLevel())
         .reduce(Math::max).orElse(0);
     }
   }

   //displays the rationales of threats threatening the asset
   static class Rationale extends AbstractCybersecurityColumn {
     public Rationale() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_Rationale;
       name = Messages.PrimaryAssetColumns_Name_Rationale;
     }
     @Override
     public Object getDataValue(EObject rowObject) {
       return CybersecurityQueries
         .getThreatsOf(((PrimaryAsset) rowObject))
         .map(t -> t.getRationale())
         .filter(r -> r != null && !r.isEmpty())
         .collect(Collectors.joining("/")); //$NON-NLS-1$
     }
   }

   // display the max threat source profile of all threat sources of all threats of the asset
   public static class ThreatSourceProfile extends AbstractCybersecurityColumn {
     public ThreatSourceProfile() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_MaxThreatSourceProfile;
       name = Messages.PrimaryAssetColumns_Name_MaxThreatSourceProfile;
     }
     @Override
     public Object getDataValue(EObject rowObject) {
       return CybersecurityQueries.getThreatsOf((PrimaryAsset)rowObject)
           .flatMap(CybersecurityQueries::getInvolvedThreatSources)
           .flatMap(c -> c.getOwnedExtensions().stream())
           .filter(TrustBoundaryStorage.class::isInstance)
           .map(e -> (((TrustBoundaryStorage)e).getThreatSourceProfile()))
           .reduce(Math::max).orElse(0);
     }
   }
   
   public static class Confidentiality extends AbstractCybersecurityColumn {
     public Confidentiality() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Name_Confidentiality;
       name = Messages.PrimaryAssetColumns_Label_Confidentiality;
     }
    @Override
    public Object getDataValue(EObject rowObject) {
      SecurityNeeds sn = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) rowObject);
      if (sn != null) {
        return sn.getConfidentiality();
      }
      return null;
    }
   }
   
   public static class Integrity extends AbstractCybersecurityColumn {
     public Integrity() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_Integrity;
       name = Messages.PrimaryAssetColumns_Name_Integrity;
     }
     @Override
     public Object getDataValue(EObject rowObject) {
       SecurityNeeds sn = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) rowObject);
       if (sn != null) {
         return sn.getIntegrity();
       }
       return null;
     }
    }

   public static class Availability extends AbstractCybersecurityColumn {
     public Availability() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_Availability;
       name = Messages.PrimaryAssetColumns_Name_Availability;
     }
     @Override
     public Object getDataValue(EObject rowObject) {
       SecurityNeeds sn = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) rowObject);
       if (sn != null) {
         return sn.getAvailability();
       }
       return null;
     }
    }

   public static class Traceability extends AbstractCybersecurityColumn {
     public Traceability() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_Traceability;
       name = Messages.PrimaryAssetColumns_Name_Traceability;
     }
     @Override
     public Object getDataValue(EObject rowObject) {
       SecurityNeeds sn = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) rowObject);
       if (sn != null) {
         return sn.getTraceability();
       }
       return null;
     }
    }

   public static class RealizedBy extends AbstractCybersecurityColumn {
     public RealizedBy() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_RealizedBy;
       name = Messages.PrimaryAssetColumns_Name_RealizedBy;
     }

    @Override
    public Object getDataValue(EObject rowObject) {
      if (rowObject instanceof InformationPrimaryAsset) {
        return (((InformationPrimaryAsset)rowObject).getExchangeItems());
      }
      if (rowObject instanceof FunctionalPrimaryAsset) {
        return (((FunctionalPrimaryAsset)rowObject).getFunctions());
      }
      return null;
    }
   }

   public static class Component extends AbstractCybersecurityColumn {
     public Component() {
       id = getClass().getCanonicalName();
       label = Messages.PrimaryAssetColumns_Label_Component;
       name = Messages.PrimaryAssetColumns_Name_Component;
     }
    @Override
    public Object getDataValue(EObject rowObject) {
      if (rowObject instanceof InformationPrimaryAsset) {
        return CybersecurityQueries.getSupportingComponents((InformationPrimaryAsset) rowObject)
            .collect(Collectors.toList());
      }
      if (rowObject instanceof FunctionalPrimaryAsset) {
        return CybersecurityQueries.getSupportingComponents((FunctionalPrimaryAsset) rowObject)
            .collect(Collectors.toList());
      }
      return null;
    }
   }

}
