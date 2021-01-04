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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.test.diagram.common.ju.step.tools.InsertRemoveTool;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class ThreatDiagramTest extends EmptyProject {

  @Override
  protected void undoAllChanges() {
    //don't undo anything
    //https://bugs.polarsys.org/show_bug.cgi?id=2686
  }

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);  

    ThreatDiagram td = ThreatDiagram.createDiagram(context, PA__PHYSICAL_SYSTEM);
    DNode threat = td.createThreat();

    DNode ipa = td.createFunctionalPrimaryAsset();
    DNode fpa = td.createInformationPrimaryAsset();

    DNode actor = td.createActor();

    td.createThreatApplication(threat, ipa);
    td.createThreatApplication(threat, fpa);
    td.createThreatInvolvement(threat, actor);

    ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
    IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel() + "/diagram.png")); //$NON-NLS-1$ //$NON-NLS-2$
    DialectUIManager.INSTANCE.export(td.getDiagram(), session, dest, format, new NullProgressMonitor());
  }

}

