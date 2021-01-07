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
package org.polarsys.capella.cybersecurity.test;

import org.polarsys.capella.cybersecurity.test.config.CybersecurityConfigurationTestSuite;
import org.polarsys.capella.cybersecurity.test.diagram.CyberPABDiagramTest;
import org.polarsys.capella.cybersecurity.test.diagram.ThreatDiagramTest;
import org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon.CY_DCONRulesTestSuite;
import org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcov.CY_DCOVRulesTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 * Cybersecurity Test
 *
 */
public class CybersecurityTestSuite extends TestSuite {

  public CybersecurityTestSuite() {
    super("CybersecurityTestSuite"); //$NON-NLS-1$
    addTest(new PluginCustomizationTest());
    
    addTest(new CY_DCOVRulesTestSuite());
    addTest(new CY_DCONRulesTestSuite());

    addTest(new ThreatDiagramTest());
    addTest(new CyberPABDiagramTest());
    
    addTest(new CybersecurityConfigurationTestSuite());
  }

  public static Test suite() {
    return new CybersecurityTestSuite();
  }

}
