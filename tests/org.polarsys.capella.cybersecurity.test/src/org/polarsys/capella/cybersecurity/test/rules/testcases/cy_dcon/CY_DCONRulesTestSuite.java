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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 * Test on CY_DCON Rules
 *
 */
public class CY_DCONRulesTestSuite extends TestSuite {

  public CY_DCONRulesTestSuite() {
    super("CY_DCONRulesTestSuite"); //$NON-NLS-1$
    addTest(new Rule_CY_DCON_01_OA());
    addTest(new Rule_CY_DCON_01_SA());
    addTest(new Rule_CY_DCON_01_LA());
    addTest(new Rule_CY_DCON_01_PA());
    addTest(new Rule_CY_DCON_02_OA());
    addTest(new Rule_CY_DCON_02_SA());
    addTest(new Rule_CY_DCON_02_LA());
    addTest(new Rule_CY_DCON_02_PA());
    addTest(new Rule_CY_DCON_03_Asset());
    addTest(new Rule_CY_DCON_03_Threat());
  }

  public static Test suite() {
    return new CY_DCONRulesTestSuite();
  }

}
