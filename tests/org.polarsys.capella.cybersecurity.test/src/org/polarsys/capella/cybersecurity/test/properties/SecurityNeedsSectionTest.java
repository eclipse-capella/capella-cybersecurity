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
package org.polarsys.capella.cybersecurity.test.properties;

import java.util.HashMap;

import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.capella.cybersecurity.ui.CybersecurityUIActivator;
import org.polarsys.capella.cybersecurity.ui.properties.sections.SecurityNeedsSection;
import org.polarsys.capella.test.diagram.common.ju.context.XABDiagram;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointActivationException;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.viewpoint.predicate.exceptions.EvaluationException;

public class SecurityNeedsSectionTest extends EmptyProject {

  protected TransactionalEditingDomainHelper tedHelper;
  
  protected FunctionalPrimaryAsset fpa;
  protected InformationPrimaryAsset ipa;
  protected EnterprisePrimaryAsset epa;
  protected Threat threat;
  
  protected HashMap<String, String> diagramElements;
  protected SessionContext context;
  protected Session session;
  protected XABDiagram diagram;
  protected CybersecurityServices services;
  
  
  @Override
  protected void undoAllChanges() {
    //don't undo anything
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    session = getSession(getRequiredTestModel());
    context = new SessionContext(session);
    tedHelper = new TransactionalEditingDomainHelper(session.getTransactionalEditingDomain());
    services = new CybersecurityServices();
  }
  
  @Override
  public void test() throws RollbackException, InterruptedException, ViewpointActivationException, EvaluationException {
    executeCommand(() -> {
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(SA__SYSTEM));
      ipa = services.createInformationPrimaryAsset(context.getSemanticElement(SA__SYSTEM));
      epa = services.createEnterprisePrimaryAsset(context.getSemanticElement(SA__SYSTEM));
      threat = services.createThreat(context.getSemanticElement(SA__SYSTEM));
    });
    
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityUIActivator.VIEWPOINT_ID);
    
    AbstractSection section = new SecurityNeedsSection();
    assertTrue(section.select(fpa));
    assertTrue(section.select(ipa));
    assertTrue(section.select(epa));
    assertTrue(section.select(threat));
  }
  
  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }

}
