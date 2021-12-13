/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.cybersecurity.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.cs.PhysicalLink;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.AbstractFunctionalBlock;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.ComponentExchangeExt;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class CybersecurityQueries {
  public static SecurityNeeds getSecurityNeeds(ExtensibleElement e) {
    for (ElementExtension ee : e.getOwnedExtensions()) {
      if (ee instanceof SecurityNeeds) {
        return (SecurityNeeds) ee;
      }
    }
    return null;
  }

  public static Stream<PrimaryAsset> getThreatenedPrimaryAssets(Threat threat) {
    return EObjectExt.getReferencers(threat, CybersecurityPackage.Literals.THREAT_APPLICATION__THREAT).stream()
        .map(s -> ((ThreatApplication) s).getAsset());
  }

  public static Stream<AbstractFunctionalBlock> getThreatenedComponents(Threat threat) {
    return getThreatenedPrimaryAssets(threat).flatMap(pa -> pa.getOwnedMembers().stream()).flatMap(pam -> {
      if (pam.getMember() instanceof AbstractFunction) {
        return ((AbstractFunction) pam.getMember()).getAllocationBlocks().stream();
      }
      // fixme, how to do this for exchange items..?
      return Stream.<AbstractFunctionalBlock> empty();
    });
  }

  public static Stream<Component> getInvolvedComponents(Threat threat) {
    return EObjectExt.getReferencers(threat, CybersecurityPackage.Literals.THREAT_INVOLVEMENT__THREAT).stream()
        .map(s -> ((ThreatInvolvement) s).getComponent());
  }

  public static Stream<Component> getInvolvedThreatSources(Threat threat) {
    return getInvolvedComponents(threat).filter(c -> isThreatSource(c));
  }

  public static Stream<Component> getInvolvedActors(Threat threat) {
    return getInvolvedComponents(threat).filter(c -> !isThreatSource(c));
  }

  public static Stream<Component> getInvolvedActors(PrimaryAsset asset) {
    return asset.getOwnedThreatApplications().stream().map(ThreatApplication::getThreat).filter(Objects::nonNull)
        .flatMap(CybersecurityQueries::getInvolvedActors);
  }

  public static Stream<Component> getInvolvedThreatSources(PrimaryAsset asset) {
    return asset.getOwnedThreatApplications().stream().map(ThreatApplication::getThreat).filter(Objects::nonNull)
        .flatMap(CybersecurityQueries::getInvolvedThreatSources);
  }

  public static boolean isThreatSource(Component c) {
    for (ElementExtension e : c.getOwnedExtensions()) {
      if (e instanceof TrustBoundaryStorage) {
        return ((TrustBoundaryStorage) e).isThreatSource();
      }
    }
    return false;
  }

  public static boolean isTrusted(Component c) {
    if (c != null) {
      for (ElementExtension e : c.getOwnedExtensions()) {
        if (e instanceof TrustBoundaryStorage) {
          return ((TrustBoundaryStorage) e).isTrusted();
        }
      }
    }
    return TrustBoundaryStorageImpl.TRUSTED_EDEFAULT;
  }

  public static boolean isTrustBoundary(FunctionalExchange fe) {
    AbstractFunction sf = getSourceFunction(fe);
    AbstractFunction tf = getTargetFunction(fe);
    return isTrusted(sf) ^ isTrusted(tf);
  }

  public static boolean isTrustBoundary(ComponentExchange ce) {
    Component source = ComponentExchangeExt.getSourceComponent(ce);
    Component target = ComponentExchangeExt.getTargetComponent(ce);
    boolean areTrustedAllocatedFE = areTrustBoundaryFE(ce.getAllocatedFunctionalExchanges());
    return areTrustedAllocatedFE || (isTrusted(source) ^ isTrusted(target));
  }

  public static boolean isTrustBoundary(PhysicalLink pl) {
    EObject source = pl.getSourcePhysicalPort().eContainer();
    EObject target = pl.getTargetPhysicalPort().eContainer();
    if (!(source instanceof Component) || !(target instanceof Component))
      return false;
    boolean areTrustedAllocatedCE = areTrustBoundaryCE(pl.getAllocatedComponentExchanges());
    return areTrustedAllocatedCE || (isTrusted((Component) source) ^ isTrusted((Component) target));
  }

  public static boolean areTrustBoundaryFE(EList<FunctionalExchange> allocatedFE) {
    for (FunctionalExchange fe : allocatedFE) {
      if (isTrustBoundary(fe))
        return true;
    }
    return false;
  }

  public static boolean areTrustBoundaryCE(EList<ComponentExchange> allocatedCE) {
    for (ComponentExchange ce : allocatedCE) {
      if (isTrustBoundary(ce))
        return true;
    }
    return false;
  }

  public static Stream<Threat> getThreatsOf(PrimaryAsset pe) {
    return pe.getOwnedThreatApplications().stream().map(s -> ((ThreatApplication) s).getThreat()).distinct();
  }

  /**
   * An abstract function is trusted if it is allocated on a component that is trusted
   * 
   * @param f
   * @return
   */
  public static boolean isTrusted(AbstractFunction f) {
    for (AbstractFunctionalBlock b : f.getAllocationBlocks()) {
      TrustBoundaryStorage tbs = getTrustBoundaryStorage(b);
      if (tbs != null) {
        return tbs.isTrusted();
      }
    }
    return TrustBoundaryStorageImpl.TRUSTED_EDEFAULT;
  }

  public static boolean isTrusted(ExtensibleElement e) {
    TrustBoundaryStorage tbs = getTrustBoundaryStorage(e);
    if (tbs != null) {
      return tbs.isTrusted();
    }
    return TrustBoundaryStorageImpl.TRUSTED_EDEFAULT;
  }

  public static TrustBoundaryStorage getTrustBoundaryStorage(ExtensibleElement element) {
    if (element instanceof Part) {
      element = ((Part) element).getType();
    }
    if (element != null) {
      for (ElementExtension ext : element.getOwnedExtensions()) {
        if (ext instanceof TrustBoundaryStorage) {
          return (TrustBoundaryStorage) ext;
        }
      }
    }
    return null;
  }

  //
  // All threats targeted by a threat involvment link of c
  //
  public static Stream<Threat> getInvolvingThreats(Component c) {
    return c.getOwnedExtensions().stream().filter(ThreatInvolvement.class::isInstance)
        .map(x -> ((ThreatInvolvement) x).getThreat());
  }

  public static Stream<AbstractFunctionalBlock> getSupportingComponents(FunctionalPrimaryAsset fpa) {
    return fpa.getFunctions().stream().flatMap(af -> af.getAllocationBlocks().stream());
  }

  /**
   * Returns the exchange items of the function storage under the given function. In cybersecurity, a function has
   * exchange items directly allocated via such an extension object.
   * 
   * @param function
   * @return
   */
  public static Stream<ExchangeItem> getExchangeItems(AbstractFunction function) {
    for (ExtensibleElement e : function.getOwnedExtensions()) {
      if (e instanceof FunctionStorage) {
        return ((FunctionStorage) e).getExchangedItems().stream();
      }
    }
    return Stream.empty();
  }

  public static Stream<FunctionalPrimaryAsset> getFunctionalPrimaryAssets(AbstractFunction af) {
    return EObjectExt.getReferencers(af, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER).stream()
        .map(s -> (FunctionalPrimaryAsset) ((PrimaryAssetMember) s).getAsset());
  }
  
  public static Stream<FunctionalPrimaryAsset> getFunctionalPrimaryAssets(FunctionalChain fc) {
    return EObjectExt.getReferencers(fc, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER).stream()
        .map(s -> (FunctionalPrimaryAsset) ((PrimaryAssetMember) s).getAsset());
  }

  public static Stream<InformationPrimaryAsset> getInformationPrimaryAssets(ExchangeItem ei) {
    return EObjectExt.getReferencers(ei, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER).stream()
        .map(s -> (InformationPrimaryAsset) ((PrimaryAssetMember) s).getAsset());
  }

  public static Stream<InformationPrimaryAsset> getInformationPrimaryAssets(AbstractFunction af) {
    return getExchangeItems(af).flatMap(ei -> getInformationPrimaryAssets(ei)).distinct();
  }

  public static Stream<InformationPrimaryAsset> getInformationPrimaryAssets(FunctionalExchange fe) {
    return fe.getExchangedItems().stream().flatMap(ei -> getInformationPrimaryAssets(ei));
  }

  public static Stream<AbstractFunctionalBlock> getTrustBoundaryBlocks(FunctionalExchange fe) {
    List<AbstractFunctionalBlock> result = new ArrayList<>();
    AbstractFunction sf = getSourceFunction(fe);
    AbstractFunction tf = getTargetFunction(fe);
    if (isTrusted(sf)) {
      result.addAll(sf.getAllocationBlocks());
    }
    if (isTrusted(tf)) {
      result.addAll(tf.getAllocationBlocks());
    }
    return result.stream();
  }
  
  public static AbstractFunction getSourceFunction(FunctionalExchange fe) {
    if (BlockArchitectureExt.getRootBlockArchitecture(fe) instanceof OperationalAnalysis)
      return (AbstractFunction) fe.getSource();
    return (AbstractFunction) fe.getSourceFunctionOutputPort().eContainer();
  }
  
  public static AbstractFunction getTargetFunction(FunctionalExchange fe) {
    if (BlockArchitectureExt.getRootBlockArchitecture(fe) instanceof OperationalAnalysis)
      return (AbstractFunction) fe.getTarget();
    return (AbstractFunction) fe.getTargetFunctionInputPort().eContainer();
  }
  
  public static Stream<FunctionalPrimaryAsset> getFunctionalPrimaryAssets(Component c) {
    return c.getAllocatedFunctions().stream().flatMap(af -> getFunctionalPrimaryAssets(af)).distinct();
  }
  
  public static Stream<FunctionalPrimaryAsset> getComputedFunctionalPrimaryAssets(AbstractFunction af) {
    return af.getInvolvingFunctionalChains().stream().flatMap(fc -> getFunctionalPrimaryAssets(fc)).distinct();
  }
  
  public static Stream<FunctionalPrimaryAsset> getComputedFunctionalPrimaryAssets(FunctionalExchange fe) {
    List<FunctionalPrimaryAsset> result = fe.getInvolvingFunctionalChains().stream()
        .flatMap(fc -> getFunctionalPrimaryAssets(fc)).distinct().collect(Collectors.toList());
    result.addAll(getFunctionalPrimaryAssets(getTargetFunction(fe)).collect(Collectors.toList()));
    result.addAll(getFunctionalPrimaryAssets(getSourceFunction(fe)).collect(Collectors.toList()));
    return result.stream().distinct();
  }

  public static Stream<InformationPrimaryAsset> getInformationPrimaryAssets(Component c) {
    return c.getAllocatedFunctions().stream().flatMap(af -> getExchangeItems(af))
        .flatMap(ei -> getInformationPrimaryAssets(ei)).distinct();
  }

  public static Stream<Threat> getThreateningThreats(Component c) {
    return Stream.concat(getFunctionalPrimaryAssets(c).flatMap(fpa -> getThreatsOf(fpa)),
        getInformationPrimaryAssets(c).flatMap(ipa -> getThreatsOf(ipa))).distinct();
  }

  public static int getMaxSecurityNeedsValue(SecurityNeeds sn) {
    return sn == null ? 0
        : IntStream.of(getConfidentialityIndex(sn), getIntegrityIndex(sn),
            getTraceabilityIndex(sn), getAvailabilityIndex(sn)).max()
            .getAsInt();
  }

  /*
   * the default security need level is the one on the first position in the literal (index 0)
   */
  public static String getDefaultSecurityNeedValue(EnumerationPropertyType type) {
    EnumerationPropertyLiteral literal = getLiteralOnIndex(type, 0);
    return literal != null ? literal.getName() : null;
  }  
  
  /*
   * get the value of the stored confidentiality security need;
   * if confidentiality is not set, return as default value, the value on index 0 in the configuration type of confidentiality.
   */
  public static String getConfidentialityValue(SecurityNeeds sn, Project project) {
    return sn != null && sn.getConfidentialityValue() != null
        ? sn.getConfidentialityValue().getName()
        : getDefaultSecurityNeedValue(getConfidentialityPropertyType(project));
  }
  
  public static String getIntegrityValue(SecurityNeeds sn, Project project) {
    return sn != null && sn.getIntegrityValue() != null ? sn.getIntegrityValue().getName()
      : getDefaultSecurityNeedValue(getIntegrityPropertyType(project));
  }
  
  public static String getTraceabilityValue(SecurityNeeds sn, Project project) {
    return sn != null && sn.getTraceabilityValue() != null ? sn.getTraceabilityValue().getName()
        : getDefaultSecurityNeedValue(getTraceabilityPropertyType(project));
  }
  
  public static String getAvailabilityValue(SecurityNeeds sn, Project project) {
    return sn != null && sn.getAvailabilityValue() != null ? sn.getAvailabilityValue().getName()
        : getDefaultSecurityNeedValue(getAvailabilityPropertyType(project));
  }
  
  public static int getConfidentialityIndex(SecurityNeeds sn) {
    return sn == null || sn.getConfidentialityValue() == null ? 0 : getIndexOfLiteral(sn.getConfidentialityValue());
  }

  public static int getIntegrityIndex(SecurityNeeds sn) {
    return sn == null || sn.getIntegrityValue() == null ? 0 : getIndexOfLiteral(sn.getIntegrityValue());
  }

  public static int getAvailabilityIndex(SecurityNeeds sn) {
    return sn == null || sn.getAvailabilityValue() == null ? 0 : getIndexOfLiteral(sn.getAvailabilityValue());
  }

  public static int getTraceabilityIndex(SecurityNeeds sn) {
    return sn == null || sn.getTraceabilityValue() == null  ? 0 : getIndexOfLiteral(sn.getTraceabilityValue());
  }
  
  public static void setConfidentialityFromIndex(SecurityNeeds sn, int index, EnumerationPropertyType type) {
    if (type != null && sn != null) {
      EnumerationPropertyLiteral newValue = getLiteralOnIndex(type, index);
      if(newValue != null)
        sn.setConfidentialityValue(newValue);
    }
  }

  public static void setIntegrityFromIndex(SecurityNeeds sn, int index, EnumerationPropertyType type) {
    if (type != null && sn != null) {
      EnumerationPropertyLiteral newValue = getLiteralOnIndex(type, index);
      if(newValue != null)
        sn.setIntegrityValue(newValue);
    }
  }

  public static void setAvailabilityFromIndex(SecurityNeeds sn, int index, EnumerationPropertyType type) {
    if (type != null && sn != null) {
      EnumerationPropertyLiteral newValue = getLiteralOnIndex(type, index);
      if(newValue != null)
        sn.setAvailabilityValue(newValue);
    }
  }

  public static void setTraceabilityFromIndex(SecurityNeeds sn, int index, EnumerationPropertyType type) {
    if (type != null && sn != null) {
      EnumerationPropertyLiteral newValue = getLiteralOnIndex(type, index);
      if(newValue != null)
        sn.setTraceabilityValue(newValue);
    }
  }
  

  public static void setThreatKindFromIndex(Threat threat, int index, EnumerationPropertyType type) {
    if (type != null && threat != null) {
      EnumerationPropertyLiteral newValue = getLiteralOnIndex(type, index);
      if(newValue != null)
        threat.setKind(newValue);
    }
  }
  
  private static int getIndexOfLiteral(EnumerationPropertyLiteral property) {
    EnumerationPropertyType type = (EnumerationPropertyType) property.eContainer();
    return  type == null ? 0 : type.getOwnedLiterals().indexOf(property);
  }
  
  private static EnumerationPropertyLiteral getLiteralOnIndex(EnumerationPropertyType type, int index) {
    return  index >= 0 && type != null && index < type.getOwnedLiterals().size() ? type.getOwnedLiterals().get(index) : null;
  }

  public static Stream<FunctionalExchange> getAllocatingFunctionalExchanges(ExchangeItem ei) {
    return EObjectExt.getReferencers(ei, FaPackage.Literals.FUNCTIONAL_EXCHANGE__EXCHANGED_ITEMS).stream()
        .map(s -> ((FunctionalExchange) s));
  }

  public static Stream<AbstractFunction> getAllocatingFunctions(ExchangeItem ei) {
    return EObjectExt.getReferencers(ei, CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS).stream()
        .map(s -> ((AbstractFunction) s.eContainer()));
  }

  public static Stream<AbstractFunctionalBlock> getSupportingComponents(InformationPrimaryAsset pa) {
    return pa.getExchangeItems().stream().flatMap(ei -> getSupportingComponents(ei)).distinct();
  }

  public static Stream<AbstractFunctionalBlock> getSupportingComponents(ExchangeItem ei) {
    return Stream.concat(getAllocatingFunctions(ei).flatMap(af -> af.getAllocationBlocks().stream()),
        getAllocatingFunctionalExchanges(ei).flatMap(fe -> Stream.of(getSourceFunction(fe), getTargetFunction(fe)))
            .flatMap(af -> af.getAllocationBlocks().stream()))
        .distinct();
  }

  public static Stream<AbstractFunctionalBlock> getSupportingComponents(FunctionalExchange fe) {
    return fe.getExchangedItems().stream().flatMap(ei -> getSupportingComponents(ei)).distinct();
  }

  public static Stream<ExchangeItem> getExchangeItems(ComponentExchange ce) {
    return ce.getAllocatedFunctionalExchanges().stream().flatMap(fe -> fe.getExchangedItems().stream()).distinct();
  }

  //
  // All the primary assets threatened by threat
  //
  public static class Threat__ThreatenedPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getThreatenedPrimaryAssets((Threat) object).collect(Collectors.toList());
    }
  }

  //
  // All the involved actors of a threat that are also marked as threat source
  //
  public static class Threat__InvolvedThreatSources implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInvolvedThreatSources((Threat) object).collect(Collectors.toList());
    }
  }

  public static class Threat__InvolvedActors implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInvolvedActors((Threat) object).collect(Collectors.toList());
    }
  }

  public static class Threat__ThreatenedComponents implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getThreatenedComponents((Threat) object).collect(Collectors.toList());
    }
  }

  public static class Component__InvolvingThreats implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInvolvingThreats((Component) object).collect(Collectors.toList());
    }
  }

  public static class ThreatSource__ThreatenedComponents implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInvolvingThreats((Component) object).flatMap(t -> getThreatenedComponents(t)).distinct()
          .collect(Collectors.toList());
    }
  }

  public static class Component__TrustBoundaries implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      Component c = (Component) object;
      Stream<ComponentExchange> tbCEs = ComponentExt.getAllRelatedComponentExchange(c).stream()
          .filter(ce -> isTrustBoundary(ce));
      Stream<FunctionalExchange> tbFEs = ComponentExt.getRelatedFunctionalExchanges(c).stream()
          .filter(fe -> isTrustBoundary(fe));

      // FIX.. above doesn't return functional exchanges on component itself..
      Stream<FunctionalExchange> ownTBFEs = c.getAllocatedFunctions().stream()
          .flatMap(af -> Stream.concat(af.getIncoming().stream(), af.getOutgoing().stream())).distinct()
          .filter(FunctionalExchange.class::isInstance).map(FunctionalExchange.class::cast)
          .filter(fe -> isTrustBoundary(fe));
      return Stream.concat(tbCEs, Stream.concat(tbFEs, ownTBFEs)).collect(Collectors.toList());
    }
  }

  public static class PrimaryAsset__Threats implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getThreatsOf((PrimaryAsset) object).collect(Collectors.toList());
    }
  }

  public static class InformationPrimaryAsset__ExchangeItems implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return new ArrayList<>(((InformationPrimaryAsset) object).getExchangeItems());
    }
  }
  
  public static class FunctionalPrimaryAsset__Functions implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (showCategory(object)) {
        return new ArrayList<>(((FunctionalPrimaryAsset) object).getFunctions());
      }
      return new ArrayList<>();
    }

    public boolean showCategory(Object object) {
      return !(BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis);
    }
  }
 
  public static class FunctionalPrimaryAsset__OperationalActivities extends FunctionalPrimaryAsset__Functions {
    @Override
    public boolean showCategory(Object object) {
      return BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis;
    }
  }
  
  public static class FunctionalPrimaryAsset__FunctionalChains implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (showCategory(object)) {
        return new ArrayList<>(((FunctionalPrimaryAsset) object).getFunctionalChains());
      }
      return new ArrayList<>();
    }
    
    public boolean showCategory(Object object) {
      return !(BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis);
    }
  }

  public static class FunctionalPrimaryAsset__OperationalProcesses extends FunctionalPrimaryAsset__FunctionalChains {
    @Override
    public boolean showCategory(Object object) {
      return BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis;
    }
  }
  

  public static class FunctionalPrimaryAsset__FunctionalExchanges implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (showCategory(object)) {
        return ((FunctionalPrimaryAsset) object).getFunctions().stream()
            .flatMap(af -> Stream.concat(af.getIncoming().stream(), af.getOutgoing().stream())).distinct()
            .collect(Collectors.toList());
      }
      return new ArrayList<>();
    }
    
    public boolean showCategory(Object object) {
      return !(BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis);
    }
  }

  public static class FunctionalPrimaryAsset__Interactions extends FunctionalPrimaryAsset__FunctionalExchanges {
    @Override
    public boolean showCategory(Object object) {
      return BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis;
    }
  }

  public static class FunctionalPrimaryAsset__SupportingComponents implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getSupportingComponents((FunctionalPrimaryAsset) object).collect(Collectors.toList());
    }
  }

  public static class InformationPrimaryAsset__SupportingComponents implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getSupportingComponents((InformationPrimaryAsset) object).collect(Collectors.toList());
    }
  }
  
  public static class EnterprisePrimaryAsset__PrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      List<Object> result = new ArrayList<>();
      if (object instanceof EnterprisePrimaryAsset) {
        result.addAll(((EnterprisePrimaryAsset) object).getPrimaryAssets());
      }
      return result;
    }
  }

  public static class AbstractFunction__ExchangeItems implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getExchangeItems((AbstractFunction) object).collect(Collectors.toList());
    }
  }

  public static class AbstractFunction__FunctionalPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getFunctionalPrimaryAssets((AbstractFunction) object).collect(Collectors.toList());
    }
  }
  
  public static class AbstractFunction__ComputedFunctionalPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (showCategory(object)) {
        return getComputedFunctionalPrimaryAssets((AbstractFunction) object).collect(Collectors.toList());
      }
      return new ArrayList<>();
    }

    public boolean showCategory(Object object) {
      return !(BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis);
    }
  }

  public static class Activity__ComputedOperationalPrimaryAssets
      extends AbstractFunction__ComputedFunctionalPrimaryAssets {
    @Override
    public boolean showCategory(Object object) {
      return BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis;
    }
  }

  public static class FunctionalExchange__ComputedFunctionalPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (showCategory(object)) {
        return getComputedFunctionalPrimaryAssets((FunctionalExchange) object).collect(Collectors.toList());
      }
      return new ArrayList<>();
    }

    public boolean showCategory(Object object) {
      return !(BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis);
    }
  }

  public static class Interaction__ComputedOperationalPrimaryAssets
      extends FunctionalExchange__ComputedFunctionalPrimaryAssets {
    @Override
    public boolean showCategory(Object object) {
      return BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis;
    }
  }
  

  public static class FunctionalChain__FunctionalPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (showCategory(object)) {
        return getFunctionalPrimaryAssets((FunctionalChain) object).collect(Collectors.toList());
      }
      return new ArrayList<>();
    }

    public boolean showCategory(Object object) {
      return !(BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis);
    }
  }

  public static class OperationalProcess__FunctionalPrimaryAssets extends FunctionalChain__FunctionalPrimaryAssets {
    @Override
    public boolean showCategory(Object object) {
      return BlockArchitectureExt.getRootBlockArchitecture((EObject) object) instanceof OperationalAnalysis;
    }
  }

  public static class AbstractFunction__InformationPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInformationPrimaryAssets((AbstractFunction) object).collect(Collectors.toList());
    }
  }

  public static class FunctionalExchange__InformationPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInformationPrimaryAssets((FunctionalExchange) object).collect(Collectors.toList());
    }
  }

  public static class FunctionalExchange__TrustBoundaries implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getTrustBoundaryBlocks((FunctionalExchange) object).collect(Collectors.toList());
    }
  }

  public static class FunctionalExchange__SupportingComponents implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getSupportingComponents((FunctionalExchange) object).collect(Collectors.toList());
    }
  }

  public static class ExchangeItem__PrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInformationPrimaryAssets((ExchangeItem) object).collect(Collectors.toList());
    }
  }

  public static class ExchangeItem__SupportingComponents implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getSupportingComponents((ExchangeItem) object).collect(Collectors.toList());
    }
  }

  public static class Component__SupportedFunctionalPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getFunctionalPrimaryAssets((Component) object).collect(Collectors.toList());
    }
  }

  public static class Component__SupportedInformationPrimaryAssets implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getInformationPrimaryAssets((Component) object).collect(Collectors.toList());
    }
  }

  public static class Component__ThreateningThreats implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getThreateningThreats((Component) object).collect(Collectors.toList());
    }
  }

  public static class Component__ThreateningThreatSources implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getThreateningThreats((Component) object).flatMap(t -> getInvolvedThreatSources(t))
          .collect(Collectors.toList());
    }
  }

  public static class Component__MaxCIAT implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      if (object instanceof Component && !((Component) object).getAllocatedFunctions().isEmpty()) {
        Component component = (Component) object;
        // for allocated functions
        Stream<SecurityNeeds> fsn = component.getAllocatedFunctions().stream()
            .flatMap(af -> af.getOwnedExtensions().stream()).filter(SecurityNeeds.class::isInstance)
            .map(SecurityNeeds.class::cast);

        // for exchange items
        Stream<SecurityNeeds> esn = component.getAllocatedFunctions().stream().flatMap(fct -> getExchangeItems(fct))
            .flatMap(af -> af.getOwnedExtensions().stream()).filter(SecurityNeeds.class::isInstance)
            .map(SecurityNeeds.class::cast);

        SecurityNeeds max = Stream.concat(fsn, esn).reduce(CybersecurityFactory.eINSTANCE.createSecurityNeeds(),
            CybersecurityQueries::reduceSecurityNeeds);
        
        Session session = SessionManager.INSTANCE.getSession(component);
        Project project = SessionHelper.getCapellaProject(session);
        
        return Arrays.asList("Confidentiality: " + getConfidentialityValue(max, project), //$NON-NLS-1$
            "Integrity: " + getIntegrityValue(max, project), //$NON-NLS-1$
            "Availability: " + getAvailabilityValue(max, project), //$NON-NLS-1$
            "Traceability: " + getTraceabilityValue(max, project)); //$NON-NLS-1$
      }
      return new ArrayList<>();
    }
  }
  
  public static SecurityNeeds reduceSecurityNeeds(SecurityNeeds result, SecurityNeeds a) {
    EnumerationPropertyType typeA = getAvailabilityPropertyType(a) != null ? getAvailabilityPropertyType(a) : getAvailabilityPropertyType(result);
    EnumerationPropertyType typeC = getConfidentialityPropertyType(a) != null ? getConfidentialityPropertyType(a) : getConfidentialityPropertyType(result);
    EnumerationPropertyType typeI = getIntegrityPropertyType(a) != null ? getIntegrityPropertyType(a) : getIntegrityPropertyType(result);
    EnumerationPropertyType typeT = getTraceabilityPropertyType(a) != null ? getTraceabilityPropertyType(a) : getTraceabilityPropertyType(result);
    
    setAvailabilityFromIndex(result, Math.max(getAvailabilityIndex(result), getAvailabilityIndex(a)), typeA);
    setConfidentialityFromIndex(result, Math.max(getConfidentialityIndex(result), getConfidentialityIndex(a)), typeC);
    setIntegrityFromIndex(result, Math.max(getIntegrityIndex(result), getIntegrityIndex(a)), typeI);
    setTraceabilityFromIndex(result, Math.max(getTraceabilityIndex(result), getTraceabilityIndex(a)), typeT);
    return result;
  }

  public static class ComponentExchange__InformationPrimaryAsset implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return ((ComponentExchange) object).getAllocatedFunctionalExchanges().stream()
          .flatMap(fe -> getInformationPrimaryAssets(fe)).collect(Collectors.toList());
    }
  }

  public static class ComponentExchange__TrustBoundary implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return Collections.singletonList(isTrustBoundary((ComponentExchange) object));
    }
  }

  public static class ComponentExchange__ExchangeItems implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return getExchangeItems((ComponentExchange) object).collect(Collectors.toList());
    }
  }

  public static CybersecurityConfiguration getCybersecurityConfiguration(Project project) {
    if (project != null) {
      Optional<ElementExtension> result = project.getOwnedExtensions().stream()
          .filter(x -> x instanceof CybersecurityConfiguration).findFirst();
      if (result.isPresent()) {
        return (CybersecurityConfiguration) result.get();
      }
    }
    return null;
  }
  
  /*
   * type is deduced from SecurityNeeds sn
   */
  public static EnumerationPropertyType getConfidentialityPropertyType(SecurityNeeds sn) {
    return sn.getConfidentialityValue() != null && (sn.getConfidentialityValue().eContainer() instanceof EnumerationPropertyType) ?
        (EnumerationPropertyType) sn.getConfidentialityValue().eContainer() : null;
  }
  
  public static EnumerationPropertyType getIntegrityPropertyType(SecurityNeeds sn) {
    return sn.getIntegrityValue() != null && (sn.getIntegrityValue().eContainer() instanceof EnumerationPropertyType) ?
        (EnumerationPropertyType) sn.getIntegrityValue().eContainer() : null;
  }
  
  public static EnumerationPropertyType getTraceabilityPropertyType(SecurityNeeds sn) {
    return sn.getTraceabilityValue() != null && (sn.getTraceabilityValue().eContainer() instanceof EnumerationPropertyType) ?
        (EnumerationPropertyType) sn.getTraceabilityValue().eContainer() : null;
  }
  
  public static EnumerationPropertyType getAvailabilityPropertyType(SecurityNeeds sn) {
    return sn.getAvailabilityValue() != null && (sn.getAvailabilityValue().eContainer() instanceof EnumerationPropertyType) ?
        (EnumerationPropertyType) sn.getAvailabilityValue().eContainer() : null;
  }
  
  public static EnumerationPropertyType getConfidentialityPropertyType(Project project) {
    CybersecurityConfiguration config = getCybersecurityConfiguration(project);
    if (config != null) {
      return config.getConfidentiality();
    }
    return null;
  }
  
  public static EnumerationPropertyType getIntegrityPropertyType(Project project) {
    CybersecurityConfiguration config = getCybersecurityConfiguration(project);
    if (config != null) {
      return config.getIntegrity();
    }
    return null;
  }
  
  public static EnumerationPropertyType getTraceabilityPropertyType(Project project) {
    CybersecurityConfiguration config = getCybersecurityConfiguration(project);
    if (config != null) {
      return config.getTraceability();
    }
    return null;
  }
  
  public static EnumerationPropertyType getAvailabilityPropertyType(Project project) {
    CybersecurityConfiguration config = getCybersecurityConfiguration(project);
    if (config != null) {
      return config.getAvailability();
    }
    return null;
  }
  
  public static EnumerationPropertyType getThreatKindPropertyType(Project project) {
    CybersecurityConfiguration config = getCybersecurityConfiguration(project);
    if (config != null) {
      return config.getThreatKind();
    }
    return null;
  }
  
  public static int getConfidentialitySize(Project project) {
    EnumerationPropertyType type = getConfidentialityPropertyType(project);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }

  public static int getIntegritySize(Project project) {
    EnumerationPropertyType type = getIntegrityPropertyType(project);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }

  public static int getAvailabilitySize(Project project) {
    EnumerationPropertyType type = getAvailabilityPropertyType(project);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }

  public static int getTraceabilitySize(Project project) {
    EnumerationPropertyType type = getTraceabilityPropertyType(project);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }
}
