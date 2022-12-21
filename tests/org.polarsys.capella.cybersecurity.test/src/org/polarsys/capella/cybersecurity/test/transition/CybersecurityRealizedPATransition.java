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
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class CybersecurityRealizedPATransition extends CyberTopDownTransitionTestCase {

  private final static String IPA = "1a04c73c-a81d-4ae6-ade3-80537e032b50";
  private final static String FPA = "37e60d49-7838-435f-8b59-7c3c2b35fa6c";
  private final static String CYBER_PACKAGE_LOGICAL = "46c4c194-2d0b-4d23-b112-2cff1abc0a77";

  @Override
  protected void doTest() {
    CybersecurityPkg cyberPkgLogical = getObject(CYBER_PACKAGE_LOGICAL);
    EList<PrimaryAsset> pasBeforeTransition = cyberPkgLogical.getOwnedPrimaryAssets();
    performPrimaryAssetTransition(getObjects(IPA));
    performPrimaryAssetTransition(getObjects(FPA));

    // must be transitioned because it's already realized by a FPA
    mustBeTransitioned(IPA);
    // must be transitioned because it's already realized by an IPA
    mustBeTransitioned(FPA);

    // but the PAs at Logical Level should be the same as before
    assertEquals(pasBeforeTransition, cyberPkgLogical.getOwnedPrimaryAssets());
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

}
