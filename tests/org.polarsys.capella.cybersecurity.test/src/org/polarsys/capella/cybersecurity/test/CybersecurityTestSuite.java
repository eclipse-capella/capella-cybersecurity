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

import org.polarsys.capella.cybersecurity.test.activityExplorer.CyberActivityExplorerTestSuite;
import org.polarsys.capella.cybersecurity.test.config.CybersecurityConfigurationTestSuite;
import org.polarsys.capella.cybersecurity.test.diagram.CyberDagramStatus;
import org.polarsys.capella.cybersecurity.test.diagram.CyberLABDiagramTest;
import org.polarsys.capella.cybersecurity.test.diagram.CyberOABDiagramTest;
import org.polarsys.capella.cybersecurity.test.diagram.CyberPABDiagramTest;
import org.polarsys.capella.cybersecurity.test.diagram.CyberSABDiagramTest;
import org.polarsys.capella.cybersecurity.test.diagram.ThreatDiagramTest;
import org.polarsys.capella.cybersecurity.test.move.CybersecurityMoveTestSuite;
import org.polarsys.capella.cybersecurity.test.odesign.CyberODesignTestSuite;
import org.polarsys.capella.cybersecurity.test.properties.CybersecurityPropertiesTestSuite;
import org.polarsys.capella.cybersecurity.test.queries.AbstractCapabilitiesRealizedTest;
import org.polarsys.capella.cybersecurity.test.queries.EnterprisePrimaryAsset_PrimaryAssetsTest;
import org.polarsys.capella.cybersecurity.test.queries.FunctionPrimaryAssetsRealizedTest;
import org.polarsys.capella.cybersecurity.test.queries.FunctionStorageExchangeItemsTest;
import org.polarsys.capella.cybersecurity.test.queries.InformationPrimaryAssetsExchangeItemsTest;
import org.polarsys.capella.cybersecurity.test.queries.InformationPrimaryAssetsRealizedTest;
import org.polarsys.capella.cybersecurity.test.queries.ThreatSourceUsed;
import org.polarsys.capella.cybersecurity.test.queries.ThreatsRealizedTest;
import org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon.CY_DCONRulesTestSuite;
import org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcov.CY_DCOVRulesTestSuite;
import org.polarsys.capella.cybersecurity.test.semantic.queries.CybersecuritySemanticQueriesTestSuite;
import org.polarsys.capella.cybersecurity.test.transition.CybersecurityTransitionTestSuite;

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
    addTest(new CyberLABDiagramTest());
    addTest(new CyberOABDiagramTest());
    addTest(new CyberSABDiagramTest());
    addTest(new CybersecurityTransitionTestSuite());
    
    addTest(new FunctionStorageExchangeItemsTest());
    addTest(new InformationPrimaryAssetsExchangeItemsTest());
    addTest(new ThreatsRealizedTest());
    addTest(new ThreatSourceUsed());
    addTest(new EnterprisePrimaryAsset_PrimaryAssetsTest());
    addTest(new FunctionPrimaryAssetsRealizedTest());
    addTest(new InformationPrimaryAssetsRealizedTest());
    addTest(new AbstractCapabilitiesRealizedTest());
    
    addTest(new CybersecurityConfigurationTestSuite());
    addTest(new CyberActivityExplorerTestSuite());
    
    addTest(new CybersecuritySemanticQueriesTestSuite());

    addTest(new CyberODesignTestSuite());
    
    addTest(new CybersecurityPropertiesTestSuite());
    
    addTest(new CyberDagramStatus());
    
    // todo - in Capella 6.0, uncomment
    // addTest(new CybersecurityMoveTestSuite());
  }

  public static Test suite() {
    return new CybersecurityTestSuite();
  }

}
