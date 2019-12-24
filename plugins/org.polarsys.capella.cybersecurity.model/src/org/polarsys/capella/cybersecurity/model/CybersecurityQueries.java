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

package org.polarsys.capella.cybersecurity.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.AbstractFunctionalBlock;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.model.helpers.ComponentExchangeExt;
import org.polarsys.capella.core.model.helpers.ComponentExt;
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
    AbstractFunction sf = (AbstractFunction) fe.getSourceFunctionOutputPort().eContainer();
    AbstractFunction tf = (AbstractFunction) fe.getTargetFunctionInputPort().eContainer();
    return isTrusted(sf) ^ isTrusted(tf);
  }

  public static boolean isTrustBoundary(ComponentExchange ce) {
    Component source = ComponentExchangeExt.getSourceComponent(ce);
    Component target = ComponentExchangeExt.getTargetComponent(ce);
    return isTrusted(source) ^ isTrusted(target);
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
    AbstractFunction sf = (AbstractFunction) fe.getSourceFunctionOutputPort().eContainer();
    AbstractFunction tf = (AbstractFunction) fe.getTargetFunctionInputPort().eContainer();
    if (isTrusted(sf)) {
      result.addAll(sf.getAllocationBlocks());
    }
    if (isTrusted(tf)) {
      result.addAll(tf.getAllocationBlocks());
    }
    return result.stream();
  }

  public static Stream<FunctionalPrimaryAsset> getFunctionalPrimaryAssets(Component c) {
    return c.getAllocatedFunctions().stream().flatMap(af -> getFunctionalPrimaryAssets(af)).distinct();
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
        : IntStream.of(sn.getConfidentiality(), sn.getIntegrity(), sn.getTraceability(), sn.getAvailability()).max()
            .getAsInt();
  }

  public static int getConfidentiality(SecurityNeeds sn) {
    return sn == null ? 0 : sn.getConfidentiality();
  }

  public static int getIntegrity(SecurityNeeds sn) {
    return sn == null ? 0 : sn.getIntegrity();
  }

  public static int getAvailability(SecurityNeeds sn) {
    return sn == null ? 0 : sn.getAvailability();
  }

  public static int getTraceability(SecurityNeeds sn) {
    return sn == null ? 0 : sn.getTraceability();
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
        getAllocatingFunctionalExchanges(ei)
            .flatMap(fe -> Stream.of((AbstractFunction) fe.getSourceFunctionOutputPort().eContainer(),
                (AbstractFunction) fe.getTargetFunctionInputPort().eContainer()))
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
      return new ArrayList<>(((FunctionalPrimaryAsset) object).getFunctions());
    }
  }

  public static class FunctionalPrimaryAsset__FunctionalExchanges implements IQuery {
    @Override
    public List<Object> compute(Object object) {
      return ((FunctionalPrimaryAsset) object).getFunctions().stream()
          .flatMap(af -> Stream.concat(af.getIncoming().stream(), af.getOutgoing().stream())).distinct()
          .collect(Collectors.toList());
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
      Stream<SecurityNeeds> fsn = getFunctionalPrimaryAssets(((Component) object))
          .flatMap(fpa -> fpa.getFunctions().stream()).flatMap(af -> af.getOwnedExtensions().stream())
          .filter(SecurityNeeds.class::isInstance).map(SecurityNeeds.class::cast);
      Stream<SecurityNeeds> isn = getInformationPrimaryAssets(((Component) object))
          .flatMap(ipa -> ipa.getExchangeItems().stream()).flatMap(ei -> ei.getOwnedExtensions().stream())
          .filter(SecurityNeeds.class::isInstance).map(SecurityNeeds.class::cast);
      SecurityNeeds max = Stream.concat(fsn, isn).reduce(CybersecurityFactory.eINSTANCE.createSecurityNeeds(),
          CybersecurityQueries::reduceSecurityNeeds);
      return Arrays.asList("Confidentiality: " + max.getConfidentiality(), //$NON-NLS-1$
          "Integrity: " + max.getIntegrity(), //$NON-NLS-1$
          "Availability: " + max.getAvailability(), //$NON-NLS-1$
          "Traceability: " + max.getTraceability()); //$NON-NLS-1$
    }

  }

  public static SecurityNeeds reduceSecurityNeeds(SecurityNeeds result, SecurityNeeds a) {
    result.setAvailability(Math.max(result.getAvailability(), a.getAvailability()));
    result.setConfidentiality(Math.max(result.getConfidentiality(), a.getConfidentiality()));
    result.setIntegrity(Math.max(result.getIntegrity(), a.getIntegrity()));
    result.setTraceability((Math.max(result.getTraceability(), a.getTraceability())));
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

}
