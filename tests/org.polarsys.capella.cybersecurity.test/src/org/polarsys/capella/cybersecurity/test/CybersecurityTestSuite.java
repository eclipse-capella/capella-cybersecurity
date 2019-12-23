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
package org.polarsys.capella.cybersecurity.test;

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
    addTest(new CY_DCOVRulesTestSuite());
    addTest(new CY_DCONRulesTestSuite());

    addTest(new ThreatDiagramTest());
    addTest(new CyberPABDiagramTest());
  }

  public static Test suite() {
    return new CybersecurityTestSuite();
  }

}
