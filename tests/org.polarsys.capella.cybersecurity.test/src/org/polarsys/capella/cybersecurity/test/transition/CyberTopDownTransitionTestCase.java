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
  Session session;

  protected void init() {
    session = getSession(getRequiredTestModels().get(0));
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
    performCybersecurityTransition(elements);
  }

  public void performPrimaryAssetTransition(Collection<? extends EObject> elements) {
    performCybersecurityTransition(elements);
  }
  
  public void performCybersecurityTransition(Collection<? extends EObject> elements) {
    executeCommand(CyberTransitionCommandHelper.getInstance().getCybersecurityTransitionCommand(elements,
        new NullProgressMonitor()));
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }
}
