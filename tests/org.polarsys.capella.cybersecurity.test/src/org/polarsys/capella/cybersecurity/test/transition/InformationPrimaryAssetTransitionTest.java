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
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.transition.system.topdown.preferences.PreferenceHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class InformationPrimaryAssetTransitionTest extends PrimaryAssetTransitionTest {

  @Override
  protected PrimaryAsset createPrimaryAsset() {
    return CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
  }

  @Override
  protected void checkPAMMemberTransitioned(Type level) {
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
    }
  }

  @Override
  protected void addPAMMember() {
    primaryAssetMember.setMember(exchangeItem);
  }
}
