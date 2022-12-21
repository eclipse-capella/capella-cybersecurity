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

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.test.framework.api.OracleDefinition;
import org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRulePartialTestCase;

/**
 * 
 * Test on CY_DCON_06 - Multiple Element Extension Storages data for a Capella Element.
 *
 */
public class Rule_CY_DCON_06 extends ValidationRulePartialTestCase {
  public static final String SF1 = "5d057c04-bfb0-4c0a-820b-04ad3bf1f077";
  public static final String SF2 = "1327772f-ec77-46a9-b338-7d30182866f3";
  public static final String SF3 = "ecc21e39-fddb-4834-8efe-486bc3bf8694";
  public static final String SA2 = "c92fceb1-5112-489f-9215-28af60a620e2";
  public static final String SA3 = "aee97fc1-449b-4aeb-8986-f214f28414c6";

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase#getTargetedEClass()
   * @generated
   */
  protected EClass getTargetedEClass() {
    return CapellacorePackage.Literals.NAMED_ELEMENT;
  }

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase#getRuleID()
   * @generated
   */
  protected String getRuleID() {
    return "org.polarsys.capella.cybersecurity.validation.CY_DCON_06";
  }

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRulePartialTestCase#getScopeDefinition()
   * @generated
   */
  protected List<String> getScopeDefinition() {
    return Arrays.asList(new String[] {
        SF1, SF2, SF3, SA2, SA3});
  }

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase#getOracleDefinitions()
   * @generated
   */
  protected List<OracleDefinition> getOracleDefinitions() {
    return Arrays.asList(new OracleDefinition[] { new OracleDefinition(SF1, 1),
        new OracleDefinition(SF2, 0),
        new OracleDefinition(SF3, 1),
        new OracleDefinition(SA2, 1),
        new OracleDefinition(SA3, 0)});
  }

  @Override
  protected String getRequiredTestModel() {
    return "CybersecurityModel";
  }
}
