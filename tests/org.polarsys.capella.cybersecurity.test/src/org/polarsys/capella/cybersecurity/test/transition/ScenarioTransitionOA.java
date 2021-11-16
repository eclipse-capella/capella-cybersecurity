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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.ScenarioKind;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;

public class ScenarioTransitionOA extends ScenarioTransitionTest {

  @Override
  protected CybersecurityPkg getCurrentPackage() {
    return oaPkg;
  }

  @Override
  protected CybersecurityPkg getNextPkg() {
    return saPkg;
  }

  protected void doTest() {
    performIStoISTransition(getObjects(interfaceScenario.getId()));
    EObject threat2 = mustBeTransitioned(threat.getId(), nextPkg);
    mustBeTransitioned(interfaceScenario.getId(), threat2);

    performEStoESTransition(getObjects(exchangeScenario.getId()));
    mustBeTransitioned(exchangeScenario.getId(), threat2);
  }

  @Override
  protected void initScenarios() {
    interfaceScenario = createScenario(ScenarioKind.INTERFACE);
    exchangeScenario = createScenario(ScenarioKind.DATA_FLOW);

    EList<Scenario> threatScenarios = threat.getOwnedScenarios();
    threatScenarios.add(interfaceScenario);
    threatScenarios.add(exchangeScenario);
  }

}
