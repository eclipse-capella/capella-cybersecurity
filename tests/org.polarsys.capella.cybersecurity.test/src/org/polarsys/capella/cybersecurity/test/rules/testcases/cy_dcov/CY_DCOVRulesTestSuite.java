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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcov;

import junit.framework.Test;
import junit.framework.TestSuite;
/**
 * 
 * Test on CY_DCOV Rules
 *
 */
public class CY_DCOVRulesTestSuite extends TestSuite {

    public CY_DCOVRulesTestSuite() {
      super("CY_DCOVRulesTestSuite"); //$NON-NLS-1$
      addTest(new Rule_CY_DCOV_01());
      addTest(new Rule_CY_DCOV_02());
      addTest(new Rule_CY_DCOV_03());
      addTest(new Rule_CY_DCOV_04());
      addTest(new Rule_CY_DCOV_05());
      
    }

    public static Test suite() {
      return new CY_DCOVRulesTestSuite();
    }
  
}
