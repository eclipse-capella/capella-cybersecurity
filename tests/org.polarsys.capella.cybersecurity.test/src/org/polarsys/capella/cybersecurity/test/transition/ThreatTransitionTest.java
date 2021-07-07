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
package org.polarsys.capella.cybersecurity.test.transition;

import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;

public class ThreatTransitionTest extends CyberTopDownTransitionTestCase {
  Threat threat;

  @Override
  protected void init() {
    super.init();
    // create threat
    threat = CybersecurityFactory.eINSTANCE.createThreat();

    // set threat kind and level to some values to be able to check they get properly transitioned
    EnumerationPropertyType threatKindType = CybersecurityQueries.getThreatKindPropertyType(project);
    CybersecurityQueries.setThreatKindFromIndex(threat, 1, threatKindType);
    threat.setLevel(2);

    // add the threat on the operational level
    oaPkg.getOwnedThreats().add(threat);
  }

  @Override
  public void doTest() {
    // transition the threat downwards through each level and check if the threat kind and level remain the same
    performThreatTransition(getObjects(threat.getId()));
    Threat systemThreat = (Threat) mustBeTransitioned(threat.getId(), saPkg);
    assertEquals(threat.getKind(), systemThreat.getKind());
    assertEquals(threat.getLevel(), systemThreat.getLevel());

    performThreatTransition(getObjects(systemThreat.getId()));
    Threat logicalThreat = (Threat) mustBeTransitioned(systemThreat.getId(), laPkg);
    assertEquals(threat.getKind(), logicalThreat.getKind());
    assertEquals(threat.getLevel(), logicalThreat.getLevel());

    performThreatTransition(getObjects(logicalThreat.getId()));
    Threat physicalThreat = (Threat) mustBeTransitioned(logicalThreat.getId(), paPkg);
    assertEquals(threat.getKind(), physicalThreat.getKind());
    assertEquals(threat.getLevel(), physicalThreat.getLevel());
  }
}
