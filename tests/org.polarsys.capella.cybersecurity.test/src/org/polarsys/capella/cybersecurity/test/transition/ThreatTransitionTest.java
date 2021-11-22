/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.transition;

import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;

public class ThreatTransitionTest extends CyberTopDownTransitionTestCase {
  Threat threat;
  Threat threat2;

  @Override
  protected void init() {
    super.init();
    // create threat
    threat = CybersecurityFactory.eINSTANCE.createThreat();
    threat2 = CybersecurityFactory.eINSTANCE.createThreat();

    // set threat kind and level to some values to be able to check they get properly transitioned
    EnumerationPropertyType threatKindType = CybersecurityQueries.getThreatKindPropertyType(project);
    CybersecurityQueries.setThreatKindFromIndex(threat, 1, threatKindType);
    threat.setLevel(2);

    // add the threat on the operational level
    oaPkg.getOwnedThreats().add(threat);
    oaPkg.getOwnedThreats().add(threat2);
  }

  @Override
  public void doTest() {
    // transition the threat downwards through each level and check if the threat kind and level remain the same
    performThreatTransition(getObjects(threat.getId()));
    Threat systemThreat = (Threat) mustBeTransitioned(threat.getId(), saPkg);
    assertEquals(threat.getKind(), systemThreat.getKind());
    assertEquals(threat.getLevel(), systemThreat.getLevel());
    assertFalse(threat.getIncomingTraces().isEmpty());
    // check that threat2 is not transitioned
    assertTrue(threat2.getIncomingTraces().isEmpty());
    
    // transition again an already transitioned threat
    int count = ((CybersecurityPkg)systemThreat.eContainer()).getOwnedThreats().size();
    performThreatTransition(getObjects(threat.getId()));
    assertTrue(threat.getRealizingThreats().size() == 1);
    assertTrue(((CybersecurityPkg)systemThreat.eContainer()).getOwnedThreats().size() == count);

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
