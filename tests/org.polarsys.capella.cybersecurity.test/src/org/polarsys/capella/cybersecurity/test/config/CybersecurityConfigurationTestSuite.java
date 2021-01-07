/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.config;

import junit.framework.Test;
import junit.framework.TestSuite;
/**
 * 
 * Test on Cybersecurity Configuration (of Threat Kinds and Security Needs types)
 *
 */
public class CybersecurityConfigurationTestSuite extends TestSuite {

    public CybersecurityConfigurationTestSuite() {
      super("CybersecurityConfigurationTestSuite"); //$NON-NLS-1$
      addTest(new CybersecurityDefaultConfigTest());
      addTest(new ThreatKindConfigTest());
      addTest(new SecurityNeedsConfigTest());
    }

    public static Test suite() {
      return new CybersecurityConfigurationTestSuite();
    }
  
}
