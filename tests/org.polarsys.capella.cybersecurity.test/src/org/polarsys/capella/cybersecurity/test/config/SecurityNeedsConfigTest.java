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
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.sirius.analysis.ExtensibleElementExt;
import org.polarsys.capella.cybersecurity.test.diagram.ThreatDiagram;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class SecurityNeedsConfigTest extends CybersecurityConfigProject {

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);

    Project project = SessionHelper.getCapellaProject(session);

    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);

    ThreatDiagram td = ThreatDiagram.createDiagram(context, PA__PHYSICAL_SYSTEM);
    DNode fpa = td.createFunctionalPrimaryAsset();
    DNode ipa = td.createInformationPrimaryAsset();

    test(fpa, project);
    test(ipa, project);
  }

  private void test(DNode asset, Project project) {
    CybersecurityConfiguration cyberConfig = CybersecurityQueries.getCybersecurityConfiguration(project);
    assertNotNull(cyberConfig);

    EnumerationPropertyType confidentialityType = CybersecurityQueries.getConfidentialityPropertyType(project);
    CybersecurityServices service = new CybersecurityServices();

    PrimaryAsset paElement = (PrimaryAsset) asset.getTarget();
    SecurityNeeds sn = ExtensibleElementExt.getExtension(paElement, SecurityNeeds.class);
    assertNull(sn);

    // create a sn
    sn = createSecurityNeeds(project, paElement);

    // default index is 0 (unset)
    assertTrue(CybersecurityQueries.getConfidentialityIndex(sn) == 0);

    // change the confidentiality literal
    updateConfidentialityValue(sn, confidentialityType.getOwnedLiterals().get(1), project);
    assertEquals(sn.getConfidentialityValue(), confidentialityType.getOwnedLiterals().get(1));

    removeLiteralType(confidentialityType, project, 0);
    assertEquals(sn.getConfidentialityValue(), confidentialityType.getOwnedLiterals().get(0));

    removeLiteralType(confidentialityType, project, 0);
    assertTrue(CybersecurityQueries.getConfidentialityIndex(sn) == 0);
  }
}
