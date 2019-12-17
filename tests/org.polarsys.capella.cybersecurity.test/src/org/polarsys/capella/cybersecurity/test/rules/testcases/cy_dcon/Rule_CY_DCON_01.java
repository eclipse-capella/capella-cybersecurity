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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCON_01 - Verifies that the SecurityNeeds of a Functional Exchange are at least as high as each of its
 * allocated Exchange Items.
 *
 */
public class Rule_CY_DCON_01 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCON_01"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  FunctionalExchange fe;
  ExchangeItem ei1;
  ExchangeItem ei2;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ei1 = InformationFactory.eINSTANCE.createExchangeItem();
    ei2 = InformationFactory.eINSTANCE.createExchangeItem();
    skeleton.getPhysicalArchitecture().getOwnedDataPkg().getOwnedExchangeItems().add(ei1);
    skeleton.getPhysicalArchitecture().getOwnedDataPkg().getOwnedExchangeItems().add(ei2);
    fe = FaFactory.eINSTANCE.createFunctionalExchange();
    skeleton.getPhysicalArchitecture().getContainedPhysicalFunctionPkg().getOwnedPhysicalFunctions().get(0)
        .getOwnedFunctionalExchanges().add(fe);
    fe.getExchangedItems().add(ei1);
    fe.getExchangedItems().add(ei2);
  }

  @Override
  public void test() throws Exception {
    ok(fe, RULE);
    executeCommand(() -> {
      service.setConfidentiality(ei1, 2);
      service.setIntegrity(ei2, 3);
    });
    ko(fe, RULE);
    executeCommand(() -> {
      service.setConfidentiality(fe, 2);
      service.setIntegrity(fe, 3);
    });
    ok(fe, RULE);
    executeCommand(() -> {
      service.setAvailability(ei1, 1);
      service.setTraceability(ei2, 2);
    });
    ko(fe, RULE);
    executeCommand(() -> {
      service.setAvailability(fe, 5);
      service.setTraceability(fe, 5);
    });
    ok(fe, RULE);
  }

}
