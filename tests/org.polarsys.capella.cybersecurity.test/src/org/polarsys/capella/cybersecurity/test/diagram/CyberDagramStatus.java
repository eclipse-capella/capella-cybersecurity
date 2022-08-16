/*******************************************************************************
 * Copyright (c) 2022 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.diagram;

import java.util.Arrays;
import java.util.List;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionStatus;
import org.junit.Assert;
import org.polarsys.capella.core.libraries.model.CapellaModel;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.test.diagram.common.ju.wrapper.utils.DiagramHelper;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.EObjectHelper;
import org.polarsys.capella.test.framework.helpers.SessionHelper;

public class CyberDagramStatus extends BasicTestCase {
  private static final String projectTestName = "CybersecurityModel";
  private static final String diagramName = "[PAB] Structure Test Dirty";
  private static final String PA_ID = "c7bd438d-76f0-4c37-a4f6-de3a82fa6550";
  
  @Override
  public void test() throws Exception {
    Session session = getSession(projectTestName);
    SessionContext context = new SessionContext(session);
    CapellaModel model = getTestModel(getRequiredTestModels().get(0));
    
    CyberPABDiagram diagram = CyberPABDiagram.openDiagram(context, diagramName);
    
    // Let's check the state of the diagram, shall not be dirty
    Assert.assertTrue("Session is dirty", SessionStatus.SYNC.equals(session.getStatus()));
    
    boolean ret = DiagramHelper.refreshDiagram(diagram.getDiagram());
    Assert.assertTrue("Failed to refresh diagram", ret);

    // Shall not be dirty after refresh
    Assert.assertTrue("Session is dirty", SessionStatus.SYNC.equals(session.getStatus()));
    
    // insert a Primary asset that involves the FC in diagram
    PrimaryAsset pa = (PrimaryAsset) EObjectHelper.getObject(model, PA_ID);
    diagram.insertPrimaryAsset(pa);
    // check that diagram is dirty
    Assert.assertTrue("Session is dirty", SessionStatus.DIRTY.equals(session.getStatus()));
    
    SessionHelper.saveSession(getSession(projectTestName));
    DiagramHelper.refreshDiagram(diagram.getDiagram());
    // Shall not be dirty
    Assert.assertTrue("Session is dirty", SessionStatus.SYNC.equals(session.getStatus()));
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(projectTestName);
  }
  
}
