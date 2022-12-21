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
