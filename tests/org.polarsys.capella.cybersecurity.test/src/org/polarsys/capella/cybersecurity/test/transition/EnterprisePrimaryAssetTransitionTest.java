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

import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

public class EnterprisePrimaryAssetTransitionTest extends PrimaryAssetTransitionTest {
  PrimaryAsset fpa;
  PrimaryAsset ipa;
  PrimaryAsset fpaSub;
  PrimaryAsset ipaSub;
  CybersecurityPkg subPkg;

  @Override
  protected PrimaryAsset createPrimaryAsset() {
    return CybersecurityFactory.eINSTANCE.createEnterprisePrimaryAsset();
  }

  @Override
  protected void checkPAMMembersTransitioned(Type level) {
    switch (level) {
    case SA:
      checkOnLevel(saPkg);
      break;
    case LA:
      checkOnLevel(laPkg);
      break;
    case PA:
      checkOnLevel(paPkg);
      break;
    default:
      break;
    }
  }

  private void checkOnLevel(CybersecurityPkg pkg) {
    fpa = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(fpa.getId(), pkg);
    ipa = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(ipa.getId(), pkg);
    subPkg = (CybersecurityPkg) mustBeTransitionedDirecltyContainedBy(subPkg.getId(), pkg);
    fpaSub = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(fpaSub.getId(), subPkg);
    ipaSub = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(ipaSub.getId(), subPkg);
  }

  @Override
  protected void addPAMMembers() {
    subPkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
    oaPkg.getOwnedCybersecurityPkgs().add(subPkg);

    fpaSub = services.createFunctionalPrimaryAssetInPkg(subPkg);
    ipaSub = services.createInformationPrimaryAssetInPkg(subPkg);
    fpa = services.createFunctionalPrimaryAssetInPkg(oaPkg);
    ipa = services.createInformationPrimaryAssetInPkg(oaPkg);

    PrimaryAssetMember pam1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    pam1.setMember(fpa);
    PrimaryAssetMember pam2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    pam2.setMember(ipa);
    PrimaryAssetMember pam3 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    pam3.setMember(fpaSub);
    PrimaryAssetMember pam4 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    pam4.setMember(ipaSub);

    primaryAssetMembers.add(pam1);
    primaryAssetMembers.add(pam2);
    primaryAssetMembers.add(pam3);
    primaryAssetMembers.add(pam4);
  }

}
