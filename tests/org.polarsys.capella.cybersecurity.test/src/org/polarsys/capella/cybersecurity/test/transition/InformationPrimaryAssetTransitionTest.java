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
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.transition.system.topdown.preferences.PreferenceHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

public class InformationPrimaryAssetTransitionTest extends PrimaryAssetTransitionTest {

  @Override
  protected PrimaryAsset createPrimaryAsset() {
    return CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
  }

  @Override
  protected void checkPAMMembersTransitioned(Type level) {
    PreferenceHelper.getInstance().transitionExchangeItemWhileInterfaceTransition();
    switch (level) {
    case SA:
      exchangeItem = (ExchangeItem) mustBeTransitionedDirecltyContainedBy(exchangeItem.getId(),
          BlockArchitectureExt.getInterfacePkg(saArch, false));
      break;
    case LA:
      exchangeItem = (ExchangeItem) mustBeTransitionedDirecltyContainedBy(exchangeItem.getId(),
          BlockArchitectureExt.getInterfacePkg(laArch, false));
      break;
    case PA:
      mustBeTransitionedDirecltyContainedBy(exchangeItem.getId(),
          BlockArchitectureExt.getInterfacePkg(paArch, false).getOwnedInterfacePkgs().get(0));
      break;
    default:
      break;
    }
  }

  @Override
  protected void addPAMMembers() {
    PrimaryAssetMember pam = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    pam.setMember(exchangeItem);
    primaryAssetMembers.add(pam);
  }
}
