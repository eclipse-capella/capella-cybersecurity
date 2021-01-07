/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.config;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DNode;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.diagram.ThreatDiagram;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class ThreatKindConfigTest extends CybersecurityConfigProject {

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);
    
    Project project = SessionHelper.getCapellaProject(session);
    
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);  
    
    // Cybersecurity Configuration is created on activating the Cybersecurity Viewpoint
    CybersecurityConfiguration cyberConfig = CybersecurityQueries.getCybersecurityConfiguration(project);
    assertNotNull(cyberConfig);
    
    ThreatDiagram td = ThreatDiagram.createDiagram(context, PA__PHYSICAL_SYSTEM);
    DNode threat = td.createThreat();
    
    EnumerationPropertyType threatKindType = CybersecurityQueries.getThreatKindPropertyType(project);
    CybersecurityServices service = new CybersecurityServices();

    Threat threatElement = (Threat) threat.getTarget();
    EnumerationPropertyLiteral kindDefault = threatElement.getKind();
    assertEquals(kindDefault.getName(), threatKinds[0]); //Eavesdropping
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(" + threatKinds[0].toUpperCase() +")");
    
    // change the threat kind of threatElement
    updateThreatKind(threatElement, threatKindType.getOwnedLiterals().get(1), project);
    assertEquals(threatElement.getKind().getName(), threatKinds[1]); // Denial of service
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(" + threatKinds[1].toUpperCase() +")");
    
    removeLiteralType(threatKindType, project, 0);
    assertEquals(threatElement.getKind().getName(), threatKinds[1]); // Denial of service
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(" + threatKinds[1].toUpperCase() +")");
    
    removeLiteralType(threatKindType, project, 0);
    assertNull(threatElement.getKind());
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(UNDEFINED)");
    
    assertTrue(threatKindType.getOwnedLiterals().size() == 4);
    
    updateThreatKind(threatElement, threatKindType.getOwnedLiterals().get(2), project);
    assertEquals(threatElement.getKind().getName(), threatKinds[4]); // Intrusion
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(" + threatKinds[4].toUpperCase() +")");
    
    removeAllLiteralTypes(threatKindType, project);
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(UNDEFINED)");
    
    removePropertyType(threatKindType, project);
    assertEquals(service.getThreatLabel(threatElement), threatElement.getName() + "\n(UNDEFINED)");
  }
}

