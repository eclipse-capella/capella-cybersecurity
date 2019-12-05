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
import org.polarsys.capella.cybersecurity.test.rules.Asset__noThreat;
import org.polarsys.capella.cybersecurity.test.rules.Ce__securityNeedsConsistency;
import org.polarsys.capella.cybersecurity.test.rules.Fe__securityNeedsConsistency;
import org.polarsys.capella.cybersecurity.test.rules.Ip_asset__notHandled;
import org.polarsys.capella.cybersecurity.test.rules.ThreatSource__noThreat;
import org.polarsys.capella.cybersecurity.test.rules.Threat__noAsset;
import org.polarsys.capella.cybersecurity.test.rules.Threat__noThreatSourceOrActor;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CybersecurityTestSuite extends TestSuite {

    public CybersecurityTestSuite() {
      super("CybersecurityTestSuite"); //$NON-NLS-1$
      addTest(new Asset__noThreat());
      addTest(new Ce__securityNeedsConsistency());
      addTest(new Fe__securityNeedsConsistency());
      addTest(new Ip_asset__notHandled());
      addTest(new Threat__noAsset());
      addTest(new Threat__noThreatSourceOrActor());
      addTest(new ThreatSource__noThreat());

      addTest(new ThreatDiagramTest());
      addTest(new CyberPABDiagramTest());
    }

    public static Test suite() {
      return new CybersecurityTestSuite();
    }
  
}
