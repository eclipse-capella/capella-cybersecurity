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

import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.Threat;

public class CybersecurityBlockArchitectureTransitionTest extends CybersecurityPkgTransitionTest {
  Threat threat1;
  Threat threat2;
  PrimaryAsset primaryAsset1;
  PrimaryAsset primaryAsset2;
  PrimaryAssetMember primaryAssetMember;
  ExchangeItem exchangeItem;

  @Override
  public void doTest() {
    // transition the threat downwards through each level and check if the threat kind and level remain the same
    performThreatTransition(getObjects(oaArch.getId()));
    checkTransitions(saPkg);

    performCybersecurityTransition(getObjects(saArch.getId()));
    checkTransitions(laPkg);

    performThreatTransition(getObjects(laArch.getId()));
    checkTransitions(paPkg);
  }
}
