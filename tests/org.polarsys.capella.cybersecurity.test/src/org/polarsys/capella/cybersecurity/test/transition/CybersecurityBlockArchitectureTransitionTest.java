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
