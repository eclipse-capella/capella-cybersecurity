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

import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.Allocators;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCON_02 - Verifies that the SecurityNeeds of a ComponentExchange are at least as high as each of its
 * allocated Functional Exchanges.
 *
 */
public class Rule_CY_DCON_02 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCON_02"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  ComponentExchange ce;
  FunctionalExchange fe1;
  FunctionalExchange fe2;

  private FunctionalExchange createFE() {
    FunctionalExchange res = FaFactory.eINSTANCE.createFunctionalExchange();
    skeleton.getPhysicalArchitecture().getContainedPhysicalFunctionPkg().getOwnedPhysicalFunctions().get(0)
        .getOwnedFunctionalExchanges().add(res);
    return res;
  }

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ce = FaFactory.eINSTANCE.createComponentExchange();
    skeleton.getPhysicalArchitecture().getOwnedPhysicalComponentPkg().getOwnedComponentExchanges().add(ce);
    fe1 = createFE();
    fe2 = createFE();
    Allocators.allocate(fe1, fe2).on(ce);
  }

  @Override
  public void test() throws Exception {
    ok(ce, RULE);
    executeCommand(() -> {
      service.setConfidentiality(fe1, 2, typeConfidentiality);
      service.setIntegrity(fe2, 3, typeIntegrity);
    });
    ko(ce, RULE);
    executeCommand(() -> {
      service.setConfidentiality(ce, 2, typeConfidentiality);
      service.setIntegrity(ce, 3, typeIntegrity);
    });
    ok(ce, RULE);
    executeCommand(() -> {
      service.setAvailability(fe1, 1, typeAvailability);
      service.setTraceability(fe2, 2, typeTraceability);
    });
    ko(ce, RULE);
    executeCommand(() -> {
      service.setAvailability(ce, 5, typeAvailability);
      service.setTraceability(ce, 5, typeTraceability);
    });
    ok(ce, RULE);
  }

}
