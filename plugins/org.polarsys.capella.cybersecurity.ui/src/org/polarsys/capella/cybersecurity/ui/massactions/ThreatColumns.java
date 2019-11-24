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
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnprovider.AbstractMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;

public class ThreatColumns extends AbstractMAColumnProvider {

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> commonPossibleFeatures,
      Collection<EObject> data) {

    if (data.stream().filter(e -> !(e instanceof Threat)).findAny().isPresent()) {
      return Collections.emptyList();
    }

    return Arrays.asList(
        new InvolvedActors(),
        new Trusted(),
        new ThreatSourceProfile()
        );
  }

  static class InvolvedActors extends AbstractCybersecurityColumn {
    public InvolvedActors() {
      id = getClass().getCanonicalName();
      label = Messages.ThreatColumns_Label_InvolvedActors;
      name = Messages.ThreatColumns_Name_InvolvedActors;
    }
    @Override
    public Object getDataValue(EObject rowObject) {
      return 
          Stream.concat(
              CybersecurityQueries.getInvolvedActors((Threat)rowObject),
              CybersecurityQueries.getInvolvedThreatSources((Threat) rowObject))
          .collect(Collectors.toList());
    }
  }


  static class Trusted extends AbstractCybersecurityColumn {
    public Trusted() {
      id = getClass().getCanonicalName();
      label = Messages.ThreatColumns_Label_Trusted;
      name = Messages.ThreatColumns_Name_Trusted;
    }
    @Override
    public Object getDataValue(EObject rowObject) {
      String result = null;
      boolean hasAnyActors =
          Stream.concat(
          CybersecurityQueries.getInvolvedActors((Threat) rowObject),
          CybersecurityQueries.getInvolvedThreatSources((Threat) rowObject))
          .findAny().isPresent();
      
      if (hasAnyActors) {
          result = Stream.concat(
            CybersecurityQueries.getInvolvedActors((Threat) rowObject),
            CybersecurityQueries.getInvolvedThreatSources((Threat) rowObject))
         .filter(c -> CybersecurityQueries.isThreatSource(c))
         .findAny().isPresent() ? Messages.ThreatColumns_Trusted_no : Messages.ThreatColumns_Trusted_yes;
      }
      return result;
    }
  }

  static class ThreatSourceProfile extends AbstractCybersecurityColumn {
    public ThreatSourceProfile() {
      id = getClass().getCanonicalName();
      label = Messages.ThreatColumns_Label_ThreatSourceProfile;
      name = Messages.ThreatColumns_Name_ThreatSourceProfile;
    }
    @Override
    public Object getDataValue(EObject rowObject) {
      return CybersecurityQueries.getInvolvedThreatSources((Threat)rowObject)
          .flatMap(c -> c.getOwnedExtensions().stream())
          .filter(TrustBoundaryStorage.class::isInstance)
          .map(e -> (((TrustBoundaryStorage)e).getThreatSourceProfile()))
          .reduce(Math::max).orElse(0);
    }
  }
  
}
