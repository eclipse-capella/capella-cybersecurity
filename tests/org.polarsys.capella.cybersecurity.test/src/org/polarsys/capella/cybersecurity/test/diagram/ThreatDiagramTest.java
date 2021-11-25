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
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class ThreatDiagramTest extends EmptyProject {
  Session session;
  SessionContext context;
    
  @Override
  protected void undoAllChanges() {
    //don't undo anything
    //https://bugs.polarsys.org/show_bug.cgi?id=2686
  }

  @Override
  public void test() throws Exception {
    session = getSession(getRequiredTestModel());
    context = new SessionContext(session);
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);  

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
    
    DNode actor = td.createActor();

    td.createThreatApplication(threat, ipa);
    td.createThreatApplication(threat, fpa);
    td.createThreatApplication(threat, epa);
    td.createThreatInvolvement(threat, actor);

    ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
    IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel() + "/diagram.png")); //$NON-NLS-1$ //$NON-NLS-2$
    DialectUIManager.INSTANCE.export(td.getDiagram(), session, dest, format, new NullProgressMonitor());
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(context.getSemanticElement(containerId));
    CybersecurityPkg cyberPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(architecture, false);
    assertNotNull(cyberPkg);
    
    EList<PrimaryAsset> primaryAssets = cyberPkg.getOwnedPrimaryAssets();
    
    InformationPrimaryAsset infPA = (InformationPrimaryAsset) ipa.getTarget();
    FunctionalPrimaryAsset funcPA = (FunctionalPrimaryAsset) fpa.getTarget();
    EnterprisePrimaryAsset entPA = (EnterprisePrimaryAsset) epa.getTarget();
    
    assertTrue(primaryAssets.contains(infPA));
    assertTrue(primaryAssets.contains(funcPA));
    assertTrue(primaryAssets.contains(entPA));
    
    assertTrue(!infPA.getOwnedThreatApplications().isEmpty());
    assertTrue(!funcPA.getOwnedThreatApplications().isEmpty());
    assertTrue(!entPA.getOwnedThreatApplications().isEmpty());
  }  
  
  protected void testOnOA(String containerId) throws Exception {
    ThreatDiagram td = ThreatDiagram.createDiagram(context, containerId);
    DNode threat = td.createThreat();

    DNode ipa = td.createFunctionalPrimaryAsset();
    DNode fpa = td.createInformationPrimaryAsset();
    DNode epa = td.createEnterprisePrimaryAsset();
    
    DNode actor = td.createOperationalActor();

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
}

