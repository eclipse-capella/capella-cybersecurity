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
    addTest(new Rule_CY_DCON_01());
    addTest(new Rule_CY_DCON_02());

  }

  public static Test suite() {
    return new CY_DCONRulesTestSuite();
  }

}
