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
package org.polarsys.capella.cybersecurity.test.queries;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.cybersecurity.business.queries.Threat_RealizedThreats;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

public class ThreatsRealizedTest extends CybersecurityQueriesTest {
  Threat oaThreat;
  Threat saThreat;

  protected void init() {
    super.init();
    oaThreat = CybersecurityFactory.eINSTANCE.createThreat();
    saThreat = CybersecurityFactory.eINSTANCE.createThreat();
    
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        CybersecurityPkg oaPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(oaArch, true);
        oaPkg.getOwnedThreats().add(oaThreat);
        CybersecurityPkg saPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(saArch, true);
        saPkg.getOwnedThreats().add(saThreat);
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
  }
  
  @Override
  protected void doTest() {
    List<EObject> elements = new Threat_RealizedThreats().getAvailableElements(saThreat);
    assertTrue(elements.contains(oaThreat));
    assertFalse(elements.contains(saThreat));
  }
}
