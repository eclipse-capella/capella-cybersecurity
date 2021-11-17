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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.cybersecurity.business.queries.EnterprisePrimaryAsset_PrimaryAssetsAtSameLvl;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

public class EnterprisePrimaryAssetAssetsAtSameLvl extends CybersecurityQueriesTest {

  private void executeTestQueryOnArh(BlockArchitecture arh) {
    EnterprisePrimaryAsset epa = CybersecurityFactory.eINSTANCE.createEnterprisePrimaryAsset();
    InformationPrimaryAsset ipa = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    FunctionalPrimaryAsset fpa = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();

    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        CybersecurityPkg cyberPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(arh, true);
        cyberPkg.getOwnedPrimaryAssets().add(epa);
        cyberPkg.getOwnedPrimaryAssets().add(ipa);
        cyberPkg.getOwnedPrimaryAssets().add(fpa);
      }
    };

    TransactionHelper.getExecutionManager(project).execute(cmd);
    List<EObject> elements = new EnterprisePrimaryAsset_PrimaryAssetsAtSameLvl().getAvailableElements(epa);
    List<EObject> expectedElements = new ArrayList<>();
    expectedElements.add(ipa);
    expectedElements.add(fpa);
    Assert.assertEquals(expectedElements, elements);

  }

  @Override
  protected void doTest() {
    executeTestQueryOnArh(laArch);
    executeTestQueryOnArh(saArch);
    executeTestQueryOnArh(paArch);

  }
}
