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

import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.Threat;

public class CybersecurityPkgTransitionTest extends CyberTopDownTransitionTestCase {
  Threat threat1;
  Threat threat2;
  Threat threat3;
  Threat threat4;
  PrimaryAsset primaryAsset1;
  PrimaryAsset primaryAsset2;
  PrimaryAsset primaryAsset3;
  PrimaryAsset primaryAsset4;
  CybersecurityPkg cybersecPkg1;
  CybersecurityPkg cybersecPkg2;
  PrimaryAssetMember primaryAssetMember;
  ExchangeItem exchangeItem;

  @Override
  protected void init() {
    super.init();
    // create threat
    threat1 = CybersecurityFactory.eINSTANCE.createThreat();
    threat2 = CybersecurityFactory.eINSTANCE.createThreat();
    threat3 = CybersecurityFactory.eINSTANCE.createThreat();
    threat4 = CybersecurityFactory.eINSTANCE.createThreat();
    primaryAsset1 = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    primaryAsset2 = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    primaryAsset3 = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    primaryAsset4 = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    primaryAssetMember = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    exchangeItem = InformationFactory.eINSTANCE.createExchangeItem();
    primaryAssetMember.setMember(exchangeItem);
    primaryAsset2.getOwnedMembers().add(primaryAssetMember);

    // create 2 levels of nesting within the default cyber pkg, and a threat/pa within each new cyber pkg
    cybersecPkg1 = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
    cybersecPkg2 = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
    cybersecPkg1.getOwnedThreats().add(threat3);
    cybersecPkg1.getOwnedPrimaryAssets().add(primaryAsset3);
    cybersecPkg2.getOwnedThreats().add(threat4);
    cybersecPkg2.getOwnedPrimaryAssets().add(primaryAsset4);

    // add the threat on the operational level
    oaPkg.getOwnedThreats().add(threat1);
    oaPkg.getOwnedThreats().add(threat2);
    oaPkg.getOwnedPrimaryAssets().add(primaryAsset1);
    oaPkg.getOwnedPrimaryAssets().add(primaryAsset2);
    oaPkg.getOwnedCybersecurityPkgs().add(cybersecPkg1);
    cybersecPkg1.getOwnedCybersecurityPkgs().add(cybersecPkg2);
  }

  @Override
  public void doTest() {
    // transition the threat downwards through each level and check if the threat kind and level remain the same
    performThreatTransition(getObjects(oaPkg.getId()));
    checkTransitions(saPkg);

    performCybersecurityTransition(getObjects(saPkg.getId()));
    checkTransitions(laPkg);

    performThreatTransition(getObjects(laPkg.getId()));
    checkTransitions(paPkg);
  }
  
  protected void checkTransitions(CybersecurityPkg pkg) {
    threat1 = (Threat) mustBeTransitioned(threat1.getId(), pkg);
    threat2 = (Threat) mustBeTransitioned(threat2.getId(), pkg);
    primaryAsset1 = (PrimaryAsset) mustBeTransitioned(primaryAsset1.getId(), pkg);
    primaryAsset2 = (PrimaryAsset) mustBeTransitioned(primaryAsset2.getId(), pkg);
    
    // check if elements nested deeper in the cyber pkgs have been transitioned
    cybersecPkg1 = (CybersecurityPkg) mustBeTransitioned(cybersecPkg1.getId(), pkg);
    cybersecPkg2 = (CybersecurityPkg) mustBeTransitioned(cybersecPkg2.getId(), cybersecPkg1);
    threat3 = (Threat) mustBeTransitioned(threat3.getId(), cybersecPkg1);
    threat4 = (Threat) mustBeTransitioned(threat4.getId(), cybersecPkg2);
    primaryAsset3 = (PrimaryAsset) mustBeTransitioned(primaryAsset3.getId(), cybersecPkg1);
    primaryAsset4 = (PrimaryAsset) mustBeTransitioned(primaryAsset4.getId(), cybersecPkg2);

    BlockArchitecture blockArchitecture = BlockArchitectureExt.getRootBlockArchitecture(pkg);
    long noPkg = blockArchitecture.getOwnedExtensions().stream().filter(CybersecurityPkg.class::isInstance).count();
    // only one CybersecurityPackage shall be transitioned
    assertTrue(noPkg == 1);
  }
}
