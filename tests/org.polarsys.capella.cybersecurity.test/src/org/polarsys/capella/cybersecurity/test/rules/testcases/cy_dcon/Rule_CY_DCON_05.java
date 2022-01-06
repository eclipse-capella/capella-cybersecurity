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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.common.data.activity.ActivityEdge;
import org.polarsys.capella.common.lib.IdGenerator;
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.cs.PhysicalLink;
import org.polarsys.capella.core.data.cs.PhysicalPort;
import org.polarsys.capella.core.data.ctx.CtxFactory;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.ctx.SystemComponentPkg;
import org.polarsys.capella.core.data.ctx.SystemFunction;
import org.polarsys.capella.core.data.ctx.impl.SystemFunctionImpl;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentFunctionalAllocation;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionInputPort;
import org.polarsys.capella.core.data.fa.FunctionOutputPort;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.core.sirius.analysis.CsServices;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;
import org.polarsys.capella.test.diagram.common.ju.context.XABDiagram;

/**
 * 
 * Test on CY_DCON_01 - Verifies that the SecurityNeeds of a Functional Exchange are at least as high as each of its
 * allocated Exchange Items.
 *
 */
public class Rule_CY_DCON_05 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCON_05"; //$NON-NLS-1$

  protected XABDiagram diagram;
  CybersecurityServices service = new CybersecurityServices();
  ThreatSourceUse threatSourceUse;
  ThreatSourceUse threatSourceUseSuper;
  ThreatSourceUse threatSourceUse2;
  SystemComponent actor1;
  SystemComponent actor1Parent;
  SystemComponent actor2Parent;
  SystemComponent actor2;
  SystemComponentPkg componentPkg;
  SystemAnalysis architecture;
  ComponentExchange ce;
  PhysicalLink pl;
  EList<SystemComponent> systemComponents;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    actor1Parent = ComponentExt.createSystemComponent();
    actor2Parent = ComponentExt.createSystemComponent();
    architecture = skeleton.getSystemAnalysis();
    ComponentExt.getAllSubUsedAndDeployedComponents(actor1Parent);
    componentPkg = architecture.getOwnedSystemComponentPkg();
    systemComponents = architecture.getOwnedSystemComponentPkg().getOwnedSystemComponents();
    systemComponents.add(actor1Parent);
    systemComponents.add(actor2Parent);

    threatSourceUse = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    threatSourceUseSuper = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    threatSourceUseSuper.setUsed(actor2Parent);
    actor1Parent.getOwnedExtensions().add(threatSourceUseSuper);
    
    actor1 = ComponentExt.createSystemActor();
    actor2 = ComponentExt.createSystemActor();
    threatSourceUse.setUsed(actor2);
    actor1.getOwnedExtensions().add(threatSourceUse);
    
    addSubComponent(actor1Parent, actor1);
    addSubComponent(actor2Parent, actor2);

  }
  
  private void addSubComponent(SystemComponent parent, SystemComponent subComponent) {
    parent.getOwnedSystemComponents().add(subComponent);
    new CsServices().createRepresentingPartIfNone(subComponent);
  }

  @Override
  public void test() throws Exception {
    ko(threatSourceUse, RULE);

    executeCommand(() -> {
      ce = FaFactory.eINSTANCE.createComponentExchange();
      ComponentPort cp1 = FaFactory.eINSTANCE.createComponentPort();
      ComponentPort cp2 = FaFactory.eINSTANCE.createComponentPort();
      actor1.getOwnedFeatures().add(cp1);
      actor2.getOwnedFeatures().add(cp2);
      ce.setSource(cp1);
      ce.setTarget(cp2);
      componentPkg.getOwnedComponentExchanges().add(ce);
    });

    ok(threatSourceUse, RULE);
    ok(threatSourceUseSuper, RULE);

    executeCommand(() -> {
      componentPkg.getOwnedComponentExchanges().remove(ce);
      pl = CsFactory.eINSTANCE.createPhysicalLink();
      PhysicalPort pp1 = CsFactory.eINSTANCE.createPhysicalPort();
      PhysicalPort pp2 = CsFactory.eINSTANCE.createPhysicalPort();
      actor1.getOwnedFeatures().add(pp1);
      actor2.getOwnedFeatures().add(pp2);
      pl.getLinkEnds().add(pp1);
      pl.getLinkEnds().add(pp2);
      componentPkg.getOwnedPhysicalLinks().add(pl);
    });
    ok(threatSourceUse, RULE);
    ok(threatSourceUseSuper, RULE);

    executeCommand(() -> {

      componentPkg.getOwnedPhysicalLinks().remove(pl);

      FunctionalExchange fe = FaFactory.eINSTANCE.createFunctionalExchange();

      SystemFunction function1 = CtxFactory.eINSTANCE.createSystemFunction();

      function1.setId(IdGenerator.createId());

      SystemFunction function2 = new SystemFunctionImpl() {
        @Override
        public EList<ActivityEdge> getIncoming() {
          EList<ActivityEdge> list = new BasicEList<>();
          list.add(fe);
          return list;
        }
      };

      FunctionInputPort fip = FaFactory.eINSTANCE.createFunctionInputPort();
      FunctionOutputPort fop = FaFactory.eINSTANCE.createFunctionOutputPort();

      fe.setTarget(fip);
      fe.setSource(fop);

      function1.getOutputs().add(fop);
      function2.getInputs().add(fip);

      function1.getOwnedFunctionalExchanges().add(fe);

      ComponentFunctionalAllocation cfa1 = FaFactory.eINSTANCE.createComponentFunctionalAllocation();
      cfa1.setTargetElement(function1);
      cfa1.setSourceElement(actor1);
      actor1.getOwnedFunctionalAllocation().add(cfa1);

      ComponentFunctionalAllocation cfa2 = FaFactory.eINSTANCE.createComponentFunctionalAllocation();
      cfa2.setTargetElement(function2);
      cfa2.setSourceElement(actor2);
      actor2.getOwnedFunctionalAllocation().add(cfa2);
    });
    ok(threatSourceUse, RULE);
    ok(threatSourceUseSuper, RULE);

  }

}
