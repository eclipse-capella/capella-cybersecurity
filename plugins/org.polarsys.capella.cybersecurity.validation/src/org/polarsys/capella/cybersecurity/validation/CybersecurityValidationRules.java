package org.polarsys.capella.cybersecurity.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.validation.rule.AbstractValidationRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class CybersecurityValidationRules extends AbstractValidationRule {

  public static final String PREFIX = "org.polarsys.capella.cybersecurity.validation."; //$NON-NLS-1$

  /**
   * A threat source component must be involved in a Threat
   */
  public IStatus threatSource__noThreat(IValidationContext ctx) {
    Component c = (Component) ctx.getTarget();
    if (CybersecurityQueries.isThreatSource(c) && !CybersecurityQueries.getInvolvingThreats(c).findAny().isPresent()) {
      return ctx.createFailureStatus(c);
    }
    return ctx.createSuccessStatus();
  }

  /**
   * A threat must involve a Threat Source or an Actor
   */
  public IStatus threat__noThreatSourceOrActor(IValidationContext ctx) {
    Threat t = (Threat) ctx.getTarget();
    if (!CybersecurityQueries.getInvolvedComponents(t).findAny().isPresent()) {
      return ctx.createFailureStatus(t);
    }
    return ctx.createSuccessStatus();
  }

  /**
   * A Threat must threaten an asset
   */
  public IStatus threat__noAsset(IValidationContext ctx) {
    Threat t = (Threat) ctx.getTarget();
    if (!CybersecurityQueries.getThreatenedPrimaryAssets(t).findAny().isPresent()) {
      return ctx.createFailureStatus(t);
    }
    return ctx.createSuccessStatus();
  }

  /**
   * A PrimaryAsset must be threatened by a Threat
   */
  public IStatus asset__noThreat(IValidationContext ctx) {
    PrimaryAsset pa = (PrimaryAsset) ctx.getTarget();
    if (!CybersecurityQueries.getThreatsOf(pa).findAny().isPresent()) {
      return ctx.createFailureStatus(pa);
    }
    return ctx.createSuccessStatus();
  }

  /**
   * The exchange items on an InformationPrimaryAsset must be allocated somewhere
   */
  public IStatus ip_asset__notHandled(IValidationContext ctx) {
    InformationPrimaryAsset ipa = (InformationPrimaryAsset) ctx.getTarget();
    for (ExchangeItem ei : ipa.getExchangeItems()) {
      boolean handled = 
          CybersecurityQueries.getAllocatingFunctionalExchanges(ei).findAny().isPresent()
          || CybersecurityQueries.getAllocatingFunctions(ei).findAny().isPresent();
      if (!handled) {
        return ctx.createFailureStatus(ipa);
      }
    }
    return ctx.createSuccessStatus();
  }

  /**
   * The SecurityNeeds of a FunctionalExchange must be at least as high as those of each
   * of its allocated ExchangeItems.
   */
  public IStatus fe__securityNeedsConsistency(IValidationContext ctx) {
    return securityNeedsConsistency(ctx, e->((FunctionalExchange)e).getExchangedItems());
  }
  
  /**
   * The SecurityNeeds of a ComponentExchange must be at least as high as those of each
   * of its allocated Functional Exchanges.
   */
  public IStatus ce__securityNeedsConsistency(IValidationContext ctx) {
    return securityNeedsConsistency(ctx, e->((ComponentExchange)e).getAllocatedFunctionalExchanges());
  }

  private IStatus securityNeedsConsistency(IValidationContext ctx, Function<ExtensibleElement, Collection<? extends ExtensibleElement>> relation) {
    SecurityNeeds testSN = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) ctx.getTarget());
    if (testSN == null) {
      testSN = CybersecurityFactory.eINSTANCE.createSecurityNeeds();
    }
    SecurityNeeds refSN = relation.apply((ExtensibleElement) ctx.getTarget())
        .stream()
        .map(CybersecurityQueries::getSecurityNeeds)
        .filter(Objects::nonNull)
        .reduce(CybersecurityFactory.eINSTANCE.createSecurityNeeds(), CybersecurityQueries::reduceSecurityNeeds);
    if (testSN.getConfidentiality() < refSN.getConfidentiality()
        || testSN.getTraceability() < refSN.getTraceability()
        || testSN.getAvailability() < refSN.getAvailability()
        || testSN.getIntegrity() < refSN.getIntegrity()) {
      return ctx.createFailureStatus(ctx.getTarget());
    }
    return ctx.createSuccessStatus();
  }
  
  @Override
  public IStatus validate(IValidationContext ctx) {
    String constraint = ctx.getCurrentConstraintId();
    if (constraint.startsWith(PREFIX)) {
      constraint = constraint.substring(PREFIX.length());
      try {
        Method m = getClass().getMethod(constraint, IValidationContext.class);
        return (IStatus) m.invoke(this, ctx);
      } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        throw new RuntimeException(e); // validation framework will then skip this rule for later invocations
      }
    }
    throw new IllegalArgumentException("Rule not handled: " + ctx.getCurrentConstraintId()); //$NON-NLS-1$
  }

}
