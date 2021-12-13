/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.validation.design.consistency;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.helpers.cs.services.PhysicalLinkExt;
import org.polarsys.capella.core.data.helpers.fa.services.FunctionExt;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

public class CY_DCON_05_ThreatSourceUse_Exchange extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    ThreatSourceUse threatSourceUse = (ThreatSourceUse) ctx.getTarget();
    Component source = threatSourceUse.getThreatSource();
    Component usedActor = threatSourceUse.getUsed();

    Set<EObject> componentsInvolvedInCEs = ComponentExt.getAllRelatedComponentExchange(source).stream()
        .flatMap(x -> Stream.of(x.getTarget().eContainer(), x.getSource().eContainer())).collect(Collectors.toSet());
    if (componentsInvolvedInCEs.contains(threatSourceUse.getUsed())) {
      return ctx.createSuccessStatus();
    }

    Set<EObject> componentsInvolvedInPLs = PhysicalLinkExt.getAllRelatedPhysicalLinks(source).stream()
        .flatMap(x -> Stream.of(x.getTargetPhysicalPort().eContainer(), x.getSourcePhysicalPort().eContainer()))
        .collect(Collectors.toSet());
    if (componentsInvolvedInPLs.contains(usedActor)) {
      return ctx.createSuccessStatus();
    }

    EList<AbstractFunction> usedActorFunctions = usedActor.getAllocatedFunctions();
    for (AbstractFunction function : source.getAllocatedFunctions()) {
      for (FunctionalExchange fe : FunctionExt.getAllExchanges(function)) {
        if (usedActorFunctions.contains(fe.getSource().eContainer())
            || usedActorFunctions.contains(fe.getTarget().eContainer()))
          return ctx.createSuccessStatus();
      }
    }

    return ctx.createFailureStatus(threatSourceUse, NamingHelper.getTitleLabel(threatSourceUse));
  }
}
