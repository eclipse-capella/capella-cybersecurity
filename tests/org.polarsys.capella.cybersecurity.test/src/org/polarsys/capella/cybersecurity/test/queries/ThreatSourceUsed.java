/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.ctx.CtxFactory;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.business.queries.ThreatSourceUse_Actors;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.test.common.BasicDynamicModelTest;
import org.polarsys.capella.cybersecurity.ui.semantic.browser.ThreatSourceThatUse;

public class ThreatSourceUsed extends BasicDynamicModelTest {
  SystemComponent saComponent1;
  SystemComponent saComponent2;
  SystemComponent saComponent3;
  SystemAnalysis sa;
  IProject capellaProject;


  @Override
  protected void initModel(CapellaModelSkeleton skeleton2) {
    saComponent1 = CtxFactory.eINSTANCE.createSystemComponent("Actor1");
    saComponent1.setActor(true);
    saComponent2 = CtxFactory.eINSTANCE.createSystemComponent("Actor 2");
    saComponent2.setActor(true);
    saComponent3 = CtxFactory.eINSTANCE.createSystemComponent("Actor 3");
    saComponent3.setActor(false);
    sa = skeleton2.getSystemAnalysis();

    
    
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        sa.getOwnedSystemComponentPkg().getOwnedSystemComponents().add(saComponent1);
        sa.getOwnedSystemComponentPkg().getOwnedSystemComponents().add(saComponent2);
        sa.getOwnedSystemComponentPkg().getOwnedSystemComponents().add(saComponent3);


      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
    
  }

  @Override
  public void test() throws Exception {
    ThreatSourceUse_Actors query =  new ThreatSourceUse_Actors();
    ThreatSourceThatUse query2 = new ThreatSourceThatUse();
    List<EObject> elements = query.getAvailableElements(saComponent1);
    List<EObject> expectedElements = new ArrayList<>();
    expectedElements.add(saComponent2);
    assertTrue(elements.equals(expectedElements));
    ThreatSourceUse tsu = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    tsu.setUsed(saComponent2);
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        saComponent1.getOwnedExtensions().add(tsu);

      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
    List<EObject> usedActors = query.getCurrentElements(saComponent1, false);
    List<EObject> expectedUsedActors = new ArrayList<>();
    expectedUsedActors.add(saComponent2);
    assertTrue(usedActors.equals(expectedUsedActors));
    List<Object> usedBy = query2.compute(saComponent2);
    List<Object> expectedUsedBy = new ArrayList<>();
    expectedUsedBy.add(saComponent1);
    assertTrue(usedBy.equals(expectedUsedBy));
    assertTrue(query.getAvailableElements(saComponent1).size() == 0);
    
  }
}
