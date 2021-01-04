/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcov;

import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.ComponentTemplate1;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCOV_05 - Verifies that all Exchange Items of an Information Primary Asset are used at least once by a
 * Function or Functional Exchange.
 *
 */
public class Rule_CY_DCOV_05 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCOV_05"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  InformationPrimaryAsset ipa;
  ExchangeItem ei1;
  AbstractFunction af;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = new ComponentTemplate1(skeleton, this);
    ipa = service.createInformationPrimaryAsset(t.component);
    ei1 = InformationFactory.eINSTANCE.createExchangeItem();
    skeleton.getPhysicalArchitecture().getOwnedDataPkg().getOwnedExchangeItems().add(ei1);
    PrimaryAssetMember pam = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    pam.setMember(ei1);
    ipa.getOwnedMembers().add(pam);
    af = t.pf1;
  }

  @Override
  public void test() throws Exception {
    ko(ipa, RULE);
    executeCommand(() -> {
      FunctionStorage fs = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      fs.getExchangedItems().add(ei1);
      af.getOwnedExtensions().add(fs);
    });
    ok(ipa, RULE);
  }

}
