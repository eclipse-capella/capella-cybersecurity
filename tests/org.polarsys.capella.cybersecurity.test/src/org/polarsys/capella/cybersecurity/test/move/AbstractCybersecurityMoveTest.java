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
package org.polarsys.capella.cybersecurity.test.move;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.model.helpers.move.MoveHelper;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.GuiActions;

public abstract class AbstractCybersecurityMoveTest extends BasicTestCase {
  protected Project project;
  protected BlockArchitecture oaArch;
  protected BlockArchitecture saArch;
  protected BlockArchitecture laArch;
  protected BlockArchitecture paArch;
  protected CybersecurityPkg oaPkg;
  protected CybersecurityPkg saPkg;
  protected CybersecurityPkg laPkg;
  protected CybersecurityPkg paPkg;
  protected SessionContext context;

  protected Threat threatSASub;
  protected FunctionalPrimaryAsset fpaSASub;
  protected CybersecurityPkg subSAPkg;
  protected CybersecurityPkg subSAPkg1;
  protected Threat threatSASub1;

  public static final String THREAT1_SA = "100b227c-6b62-4875-aded-7eeaddf8cba9";
  public static final String FPA1_SA = "Id c9e3c8d2-5c36-4832-81bd-b836dea7e63b";
  public static final String CYBERSECURITY_CONFIGURATION = "b2ddab1d-4f42-41f3-b1e7-27d6e8408786";
  protected CybersecurityServices services;
  protected TransactionalEditingDomain ted;

  protected void init() {
    Session session = getSession(getRequiredTestModels().get(0));
    ted = session.getTransactionalEditingDomain();
    context = new SessionContext(session);
    project = SessionHelper.getCapellaProject(session);
    services = new CybersecurityServices();
    oaArch = BlockArchitectureExt.getBlockArchitecture(Type.OA, project);
    saArch = BlockArchitectureExt.getBlockArchitecture(Type.SA, project);
    laArch = BlockArchitectureExt.getBlockArchitecture(Type.LA, project);
    paArch = BlockArchitectureExt.getBlockArchitecture(Type.PA, project);

    oaPkg = services.getRootCibersecurityPkg(oaArch);
    saPkg = services.getRootCibersecurityPkg(saArch);
    laPkg = services.getRootCibersecurityPkg(laArch);
    paPkg = services.getRootCibersecurityPkg(paArch);

    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        subSAPkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
        saPkg.getOwnedCybersecurityPkgs().add(subSAPkg);
        subSAPkg1 = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
        subSAPkg.getOwnedCybersecurityPkgs().add(subSAPkg1);

        threatSASub = services.createThreatInPkg(subSAPkg);
        subSAPkg.getOwnedThreats().add(threatSASub);
        threatSASub1 = services.createThreatInPkg(subSAPkg1);
        subSAPkg1.getOwnedThreats().add(threatSASub1);

        fpaSASub = services.createFunctionalPrimaryAssetInPkg(subSAPkg);
        subSAPkg.getOwnedPrimaryAssets().add(fpaSASub);
      }
    };

    TransactionHelper.getExecutionManager(session).execute(cmd);
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Collections.singletonList("CybersecurityModel");
  }

  protected void checkMoveDisabled(EObject current, EObject newTarget, String rule) {
    assertTrue("Move shall be disabled: " + rule,
        !MoveHelper.getInstance().checkSemanticRules(Arrays.asList(current), newTarget).isOK());
  }

  void checkMoveAllowed(EObject current, EObject newTarget, String rule) {
    assertTrue("Move shall be allowed: " + rule,
        MoveHelper.getInstance().checkSemanticRules(Arrays.asList(current), newTarget).isOK());
  }

  protected void checkCopyDisabled(EObject current, EObject newTarget, String rule) {
    try {
      GuiActions.copyElement(" ", current);
      assertTrue("Copy shall be disabled: " + rule, !GuiActions.canPasteElement(" ", newTarget));

      System.out.println();
    } catch (Exception e) {
      assertTrue(e.getMessage(), false);
    }
  }
}
