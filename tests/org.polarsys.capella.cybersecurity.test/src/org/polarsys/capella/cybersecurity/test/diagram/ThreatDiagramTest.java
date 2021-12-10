/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class ThreatDiagramTest extends EmptyProject {
  Session session;
  SessionContext context;
  protected Threat threatSub;
  protected FunctionalPrimaryAsset fpaSub;
  protected InformationPrimaryAsset ipaSub;
  CybersecurityServices services;
  protected EnterprisePrimaryAsset epaSub;
  protected TransactionalEditingDomainHelper tedHelper;
    
  @Override
  protected void undoAllChanges() {
    //don't undo anything
    //https://bugs.polarsys.org/show_bug.cgi?id=2686
  }

  @Override
  public void test() throws Exception {
    session = getSession(getRequiredTestModel());
    context = new SessionContext(session);
    tedHelper = new TransactionalEditingDomainHelper(session.getTransactionalEditingDomain());
    
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);
    
    services = new CybersecurityServices();

    testOnOA(OA__OPERATIONAL_CONTEXT);
    testOnContext(SA__SYSTEM_CONTEXT);
    testOnContext(SA__SYSTEM_CONTEXT);
    testOnContext(SA__SYSTEM);
    testOnContext(LA__LOGICAL_SYSTEM);
    testOnContext(LA__LOGICAL_CONTEXT);
    testOnContext(PA__PHYSICAL_CONTEXT);
    testOnContext(PA__PHYSICAL_SYSTEM);
  }
  
  protected void testOnContext(String containerId) throws Exception {
    ThreatDiagram td = ThreatDiagram.createDiagram(context, containerId);
    DNode threat = td.createThreat();

    DNode fpa = td.createFunctionalPrimaryAsset();
    DNode ipa = td.createInformationPrimaryAsset();
    DNode epa = td.createEnterprisePrimaryAsset();
    
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(context.getSemanticElement(containerId));
    CybersecurityPkg cyberPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(architecture, false);
    assertNotNull(cyberPkg);
    EList<PrimaryAsset> primaryAssets = cyberPkg.getOwnedPrimaryAssets();
    assertTrue(primaryAssets.contains(ipa.getTarget()));
    assertTrue(primaryAssets.contains(fpa.getTarget()));
    assertTrue(primaryAssets.contains(epa.getTarget()));
    
    DNode actor = td.createActor();
    DNode threatSource = td.createActor();

    td.createThreatApplication(threat, ipa);
    td.createThreatApplication(threat, fpa);
    td.createThreatApplication(threat, epa);
    td.createThreatInvolvement(threat, actor);
    
    // create another sub CybersecurtyPkg that contains a Threat, and add the Threat in diagram
    CybersecurityPkg rootCyberPkg = new CybersecurityServices().getRootCibersecurityPkg(architecture);
    assertEquals(rootCyberPkg, cyberPkg);
    long threatsCount = services.getAllCurrentLevelThreats(threat.getTarget()).stream().count();
    long fpaCount = services.getAllCurrentLevelInformationPrimaryAssets(fpa.getTarget()).stream().count();
    long ipaCount = services.getAllCurrentLevelFunctionalPrimaryAssets(ipa.getTarget()).stream().count();
    long epaCount = services.getAllCurrentLevelFunctionalPrimaryAssets(epa.getTarget()).stream().count();
    
    executeCommand(() -> {
      CybersecurityPkg subPkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
      rootCyberPkg.getOwnedCybersecurityPkgs().add(subPkg);

      threatSub = services.createThreatInPkg(subPkg);
      subPkg.getOwnedThreats().add(threatSub);

      fpaSub = services.createFunctionalPrimaryAssetInPkg(subPkg);
      subPkg.getOwnedPrimaryAssets().add(fpaSub);

      ipaSub = services.createInformationPrimaryAssetInPkg(subPkg);
      subPkg.getOwnedPrimaryAssets().add(ipaSub);

      epaSub = services.createEnterprisePrimaryAssetInPkg(subPkg);
      subPkg.getOwnedPrimaryAssets().add(epaSub);

      td.setThreatSource((CapellaElement) threatSource.getTarget());
    });
    
    td.dndThreat(td, threatSub);
    td.dndFunctionalPrimaryAsset(td, fpaSub);
    td.dndInformationPrimaryAsset(td, ipaSub);
    td.dndEnterprisePrimaryAsset(td, epaSub);
    
    td.createThreatSourceUse(threatSource, actor);
    
    assertEquals(services.getAllCurrentLevelThreats(threatSub).stream().count(), threatsCount + 1);
    assertEquals(services.getAllCurrentLevelFunctionalPrimaryAssets(fpaSub).stream().count(), fpaCount + 1);
    assertEquals(services.getAllCurrentLevelInformationPrimaryAssets(ipaSub).stream().count(), ipaCount + 1);
    assertEquals(services.getAllCurrentLevelEnterprisePrimaryAssets(epaSub).stream().count(), epaCount + 1);
    
    ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
    IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel() + "/diagram.png")); //$NON-NLS-1$ //$NON-NLS-2$
    DialectUIManager.INSTANCE.export(td.getDiagram(), session, dest, format, new NullProgressMonitor());
  }  
  
  protected void testOnOA(String containerId) throws Exception {
    ThreatDiagram td = ThreatDiagram.createDiagram(context, containerId);
    DNode threat = td.createThreat();

    DNode ipa = td.createFunctionalPrimaryAsset();
    DNode fpa = td.createInformationPrimaryAsset();
    DNode epa = td.createEnterprisePrimaryAsset();
    
    DNode actor = td.createOperationalActor();
    DNode threatSource = td.createOperationalActor();
    executeCommand(() -> td.setThreatSource((CapellaElement) threatSource.getTarget()));
    
    td.createThreatSourceUse(threatSource, actor);

    td.createThreatApplication(threat, ipa);
    td.createThreatApplication(threat, fpa);
    td.createThreatApplication(threat, epa);
    td.createThreatInvolvement(threat, actor);
    
    // create another TDB in an Actor
    Entity eActor = (Entity) actor.getTarget();
    ThreatDiagram tdActor = ThreatDiagram.createDiagram(context, eActor.getId());
    tdActor.createOperationalActor();
    tdActor.createOperationalEntity();
    tdActor.createThreat();
  }
  
  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }
}

