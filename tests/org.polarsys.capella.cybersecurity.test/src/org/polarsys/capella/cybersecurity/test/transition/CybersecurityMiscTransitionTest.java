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

import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

public class CybersecurityMiscTransitionTest extends CyberTopDownTransitionTestCase {
  Threat threat1;
  Threat threat2;
  Threat threat3;
  PrimaryAsset pa1;
  PrimaryAsset pa2;
  PrimaryAsset pa3;

  @Override
  protected void init() {
    Session session = getSession(getRequiredTestModels().get(0));
    project = SessionHelper.getCapellaProject(session);
    services = new CybersecurityServices();
    oaArch = BlockArchitectureExt.getBlockArchitecture(Type.OA, project);
    saArch = BlockArchitectureExt.getBlockArchitecture(Type.SA, project);
    laArch = BlockArchitectureExt.getBlockArchitecture(Type.LA, project);
    paArch = BlockArchitectureExt.getBlockArchitecture(Type.PA, project);
    
    oaPkg = services.getDefaultCyberSecurityPackage(oaArch, true);

    // create threats
    threat1 = CybersecurityFactory.eINSTANCE.createThreat();
    threat2 = CybersecurityFactory.eINSTANCE.createThreat();
    threat3 = CybersecurityFactory.eINSTANCE.createThreat();

    // create primary assets
    pa1 = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    pa2 = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    pa3 = CybersecurityFactory.eINSTANCE.createEnterprisePrimaryAsset();

    // add the threat on the operational level
    oaPkg.getOwnedThreats().add(threat1);
    oaPkg.getOwnedThreats().add(threat2);
    oaPkg.getOwnedThreats().add(threat3);
    oaPkg.getOwnedPrimaryAssets().add(pa1);
    oaPkg.getOwnedPrimaryAssets().add(pa2);
    oaPkg.getOwnedPrimaryAssets().add(pa3);
  }

  @Override
  public void doTest() {
    saPkg = testContext(oaPkg);
    laPkg = testContext(saPkg);
    paPkg = testContext(laPkg);
  }
  
  // return next level CybersecurityPkg
  protected CybersecurityPkg testContext(CybersecurityPkg pkgSrc) {
    assertNotNull(pkgSrc);
    
    // keep the ids, as we overwrite the objects
    String pa1Id = pa1.getId();
    String pa2Id = pa2.getId();
    String pa3Id = pa3.getId();
    String threat1Id = threat1.getId();
    String threat2Id = threat2.getId();
    String threat3Id = threat3.getId();

    // transition pa1 and check that only the PA is transitioned (not the threat)
    performPrimaryAssetTransition(getObjects(pa1Id));
    pa1 = (PrimaryAsset) mustBeTransitioned(pa1Id);
    shouldNotBeTransitioned(threat1Id);
    shouldNotBeTransitioned(threat2Id);
    shouldNotBeTransitioned(pa2Id);
    
    //check that pkg to which is transitioned is created
    BlockArchitecture ba = BlockArchitectureExt.getRootBlockArchitecture(pa1);
    CybersecurityPkg pkgDest = new CybersecurityServices().getRootCibersecurityPkg(ba);
    assertNotNull("Cybersecurity package not created!", pkgDest);
    
    int countThreats = pkgDest.getOwnedThreats().size();
    int countPAs = pkgDest.getOwnedPrimaryAssets().size();

    // transition the threat
    performThreatTransition(getObjects(threat1Id));
    mustBeTransitioned(threat1Id, pkgDest);
    shouldNotBeTransitioned(threat2Id);
    shouldNotBeTransitioned(pa2Id);
    
    // modify threat1 and transition again
    threat1.setLevel(2);
    performThreatTransition(getObjects(threat1Id));
    threat1 = (Threat) mustBeTransitioned(threat1Id, pkgDest);
    assertEquals(threat1.getLevel(), 2);
    
    // multiselect
    performCybersecurityTransition(getObjects(pa1Id, threat1Id, threat2Id));
    threat2 = (Threat) mustBeTransitioned(threat2Id, pkgDest);
    // check that threat1, pa1 are not transitioned again
    assertEquals(pkgDest.getOwnedThreats().size(), countThreats + 2);
    assertEquals(pkgDest.getOwnedPrimaryAssets().size(), countPAs);

    // transition the package
    performCybersecurityTransition(getObjects(pkgSrc.getId()));
    threat3 = (Threat) mustBeTransitioned(threat3Id, pkgDest);
    pa2 = (PrimaryAsset) mustBeTransitioned(pa2Id, pkgDest);
    pa3 = (PrimaryAsset) mustBeTransitioned(pa3Id, pkgDest);
    
    return pkgDest;
  }
}
