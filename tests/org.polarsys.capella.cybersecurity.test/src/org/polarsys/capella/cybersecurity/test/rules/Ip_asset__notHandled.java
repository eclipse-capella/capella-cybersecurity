/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.test.rules;

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

public class Ip_asset__notHandled extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.ip_asset__notHandled"; //$NON-NLS-1$

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
