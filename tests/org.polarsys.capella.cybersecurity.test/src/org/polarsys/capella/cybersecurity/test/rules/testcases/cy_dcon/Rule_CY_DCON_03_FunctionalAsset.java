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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class Rule_CY_DCON_03_FunctionalAsset extends Abstract_Rule_CY_DCON_03<PrimaryAsset> {

  @Override
  protected void setRule() {
    super.RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCON_03";
    
  }

  @Override
  protected PrimaryAsset createElement() {
    return CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
  }

  @Override
  protected EList<PrimaryAsset> getElementsFromCybersecurityPkg(CybersecurityPkg cybersecurityPkg) {
    return cybersecurityPkg.getOwnedPrimaryAssets();
  }
  
}
