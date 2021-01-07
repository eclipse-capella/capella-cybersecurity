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

import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.activator.CybersecurityModelActivator;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.kitalpha.ad.services.manager.ViewpointActivationException;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.viewpoint.predicate.exceptions.EvaluationException;

public class CybersecurityDefaultConfigTest extends CybersecurityConfigProject {

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    
    Project project = SessionHelper.getCapellaProject(session);
    
    // there is no Cybersecurity Configuration before activating the Cybersecurity Viewpoint
    assertNull(CybersecurityQueries.getCybersecurityConfiguration(project));
    
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);  
    
    // Cybersecurity Configuration is created on activating the Cybersecurity Viewpoint
    CybersecurityConfiguration cyberConfig = CybersecurityQueries.getCybersecurityConfiguration(project);
    assertNotNull(cyberConfig);
    
    // check the default configuration for SecurityNeeds
    checkSecurityNeedsType(CybersecurityQueries.getConfidentialityPropertyType(project), CybersecurityModelActivator.CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD);
    checkSecurityNeedsType(CybersecurityQueries.getIntegrityPropertyType(project), CybersecurityModelActivator.CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD);
    checkSecurityNeedsType(CybersecurityQueries.getAvailabilityPropertyType(project), CybersecurityModelActivator.CYBERSECURITY_CFG_SECURITY_AVAILABILITY_KEYWORD);
    checkSecurityNeedsType(CybersecurityQueries.getTraceabilityPropertyType(project), CybersecurityModelActivator.CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD);
    
    // check the default configuration for Threats (kinds)
    checkThreatKindsType(CybersecurityQueries.getThreatKindPropertyType(project), CybersecurityModelActivator.CYBERSECURITY_CFG_THREAT_KIND_KEYWORD);
    
    // update the SecurityNeeds configuration
    updateType(CybersecurityQueries.getConfidentialityPropertyType(project), 5, project);
    updateType(CybersecurityQueries.getAvailabilityPropertyType(project), 5, project);
    updateType(CybersecurityQueries.getThreatKindPropertyType(project), 7, project);
    
    // deactivate/reactivate the Cybersecurity Viewpoint, check the config is present after reactivate
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(TransactionUtil.getEditingDomain(project));
    tedHelper.executeCommand(() -> {
      try {
        manager.desactivate(CybersecurityAnalysisConstants.VIEWPOINT_ID);
        manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID); 
        assertNotNull(CybersecurityQueries.getCybersecurityConfiguration(project));
      } catch (ViewpointActivationException e) {
        e.printStackTrace();
      } catch (EvaluationException e) {
        e.printStackTrace();
      }
    });
  }
  
  protected void checkSecurityNeedsType(EnumerationPropertyType type, String typeName) {
    assertNotNull(type);
    assertEquals(type.getName(), typeName);
    
    assertTrue(type.getOwnedLiterals().size() == 4);
    
    int index = 0;
    for(EnumerationPropertyLiteral literal : type.getOwnedLiterals()) {
      assertTrue(Integer.valueOf(literal.getName()) == index++);
    }
  }
  
  protected void checkThreatKindsType(EnumerationPropertyType type, String typeName) {
    assertNotNull(type);
    assertEquals(type.getName(), typeName);
    
    assertTrue(type.getOwnedLiterals().size() == 6);
    
    int index = 0;
    for(EnumerationPropertyLiteral literal : type.getOwnedLiterals()) {
      assertEquals(literal.getName(), threatKinds[index++]);
    }
  }
  
  protected void updateType(EnumerationPropertyType type, int no, Project project) {
    addLiteralType(type, project, "A1");
    addLiteralType(type, project, "A2");
    removeLiteralType(type, project, 0);
    assertTrue(type.getOwnedLiterals().size() == no);
  }
}

