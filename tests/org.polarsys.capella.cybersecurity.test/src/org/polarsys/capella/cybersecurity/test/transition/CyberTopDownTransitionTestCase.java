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
package org.polarsys.capella.cybersecurity.test.transition;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.test.transition.ju.TopDownTransitionTestCase;

public abstract class CyberTopDownTransitionTestCase extends TopDownTransitionTestCase {
  BlockArchitecture oaArch;
  BlockArchitecture saArch;
  BlockArchitecture laArch;
  BlockArchitecture paArch;
  CybersecurityPkg oaPkg;
  CybersecurityPkg saPkg;
  CybersecurityPkg laPkg;
  CybersecurityPkg paPkg;
  Project project;
  CybersecurityServices services;

  protected void init() {
    Session session = getSession(getRequiredTestModels().get(0));
    project = SessionHelper.getCapellaProject(session);
    services = new CybersecurityServices();
    oaArch = BlockArchitectureExt.getBlockArchitecture(Type.OA, project);
    saArch = BlockArchitectureExt.getBlockArchitecture(Type.SA, project);
    laArch = BlockArchitectureExt.getBlockArchitecture(Type.LA, project);
    paArch = BlockArchitectureExt.getBlockArchitecture(Type.PA, project);
    
    oaPkg = services.getDefaultCyberSecurityPackage(oaArch, true);
    saPkg = services.getDefaultCyberSecurityPackage(saArch, true);
    laPkg = services.getDefaultCyberSecurityPackage(laArch, true);
    paPkg = services.getDefaultCyberSecurityPackage(paArch, true);
  }

  abstract protected void doTest();

  @Override
  public void performTest() throws Exception {
    init();
    doTest();

  }

  public void performThreatTransition(Collection<? extends EObject> elements) {
    executeCommand(
        CyberTransitionCommandHelper.getInstance().getThreatTransitionCommand(elements, new NullProgressMonitor()));
  }

  public void performPrimaryAssetTransition(Collection<? extends EObject> elements) {
    executeCommand(CyberTransitionCommandHelper.getInstance().getPrimaryAssetTransitionCommand(elements,
        new NullProgressMonitor()));
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }
}
