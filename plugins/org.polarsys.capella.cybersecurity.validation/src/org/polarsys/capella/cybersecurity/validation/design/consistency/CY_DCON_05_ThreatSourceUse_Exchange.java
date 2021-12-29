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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.helpers.cs.services.PhysicalLinkExt;
import org.polarsys.capella.core.data.helpers.fa.services.FunctionExt;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.ComponentExchangeExt;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.model.helpers.FunctionalExchangeExt;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

public class CY_DCON_05_ThreatSourceUse_Exchange extends AbstractModelConstraint {
  private final String CE_OTHER = "Component Exchange";
  private final String CE_OA = "Communication Mean";
  private final String FE_OTHER = "Functional Exchange";
  private final String FE_OA = "Interaction";
  
  @Override
  public IStatus validate(IValidationContext ctx) {
    ThreatSourceUse threatSourceUse = (ThreatSourceUse) ctx.getTarget();
    Component source = threatSourceUse.getThreatSource();
    BlockArchitecture bla = BlockArchitectureExt.getRootBlockArchitecture(source);
    Component usedActor = threatSourceUse.getUsed();
    List<Component> sourceComponents = ComponentExt.getAllSubUsedAndDeployedComponents(source);
    sourceComponents.add(source);
    List<Component> targetComponents = ComponentExt.getAllSubUsedAndDeployedComponents(usedActor);
    targetComponents.add(usedActor);
    for (Component componentSource : sourceComponents) {
      for (Component componentTarget : targetComponents) {
        if (existsRelationBetweenThem(componentSource, componentTarget)) {
          return ctx.createSuccessStatus();
        }
      }
    }
    if (bla instanceof OperationalAnalysis) {
      return ctx.createFailureStatus(threatSourceUse, NamingHelper.getTitleLabel(threatSourceUse), CE_OA, FE_OA);
    }
    return ctx.createFailureStatus(threatSourceUse, NamingHelper.getTitleLabel(threatSourceUse), CE_OTHER, FE_OTHER);
  }

  private boolean existsRelationBetweenThem(Component comp1, Component comp2) {
    return existsCEBetweenComponents(comp1, comp2) || existsFEBetweenComponents(comp1, comp2)
        || existsPLBetweenComponents(comp1, comp2);
  }

  private boolean existsFEBetweenComponents(Component comp1, Component comp2) {
    BlockArchitecture bla = BlockArchitectureExt.getRootBlockArchitecture(comp1);
    EList<AbstractFunction> usedActorFunctions = comp1.getAllocatedFunctions();
    for (AbstractFunction function : comp2.getAllocatedFunctions()) {
      for (FunctionalExchange fe : FunctionExt.getAllExchanges(function)) {
        EObject source;
        EObject target;
        if (bla instanceof OperationalAnalysis) {
          source = FunctionalExchangeExt.getSourceFunction(fe);
          target = FunctionalExchangeExt.getTargetFunction(fe);
        } else {
          source = fe.getSource().eContainer();
          target = fe.getSource().eContainer();
        }
        if (usedActorFunctions.contains(source) || usedActorFunctions.contains(target))
          return true;
      }
    }
    return false;
  }

  private boolean existsPLBetweenComponents(Component comp1, Component comp2) {
    BlockArchitecture bla = BlockArchitectureExt.getRootBlockArchitecture(comp1);
    Set<EObject> componentsInvolvedInPLs = PhysicalLinkExt.getAllRelatedPhysicalLinks(comp1).stream().flatMap(x -> {
      EObject source;
      EObject target;
      if (bla instanceof OperationalAnalysis) {
        source = PhysicalLinkExt.getSourceComponent(x);
        target = PhysicalLinkExt.getTargetComponent(x);
      } else {
        source = x.getSourcePhysicalPort().eContainer();
        target = x.getTargetPhysicalPort().eContainer();
      }
      return Stream.of(source, target);
    }).collect(Collectors.toSet());
    if (componentsInvolvedInPLs.contains(comp2)) {
      return true;
    }
    return false;
  }

  private boolean existsCEBetweenComponents(Component comp1, Component comp2) {
    BlockArchitecture bla = BlockArchitectureExt.getRootBlockArchitecture(comp1);
    Set<EObject> componentsInvolvedInCEs = ComponentExt.getAllRelatedComponentExchange(comp1).stream().flatMap(x -> {
      EObject source;
      EObject target;
      if (bla instanceof OperationalAnalysis) {
        source = ComponentExchangeExt.getSourceComponent(x);
        target = ComponentExchangeExt.getTargetComponent(x);
      } else {
        source = x.getSource().eContainer();
        target = x.getTarget().eContainer();
      }
      return Stream.of(source, target);
    }).collect(Collectors.toSet());
    if (componentsInvolvedInCEs.contains(comp2)) {
      return true;
    }
    return false;
  }
}
