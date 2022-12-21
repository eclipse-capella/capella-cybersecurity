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
import org.polarsys.capella.core.data.interaction.InteractionFactory;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.interaction.ScenarioKind;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.Threat;

public abstract class ScenarioTransitionTest extends CyberTopDownTransitionTestCase {

  Scenario interfaceScenario;
  Scenario exchangeScenario;
  Scenario functionScenario;

  Threat threat;

  CybersecurityPkg currentPkg;
  CybersecurityPkg nextPkg;

  @Override
  protected void init() {
    super.init();
    threat = CybersecurityFactory.eINSTANCE.createThreat();
    currentPkg = getCurrentPackage();
    nextPkg = getNextPkg();
    currentPkg.getOwnedThreats().add(threat);
    initScenarios();
  }

  protected abstract CybersecurityPkg getCurrentPackage();

  protected abstract CybersecurityPkg getNextPkg();

  protected void initScenarios() {
    interfaceScenario = createScenario(ScenarioKind.INTERFACE);
    exchangeScenario = createScenario(ScenarioKind.DATA_FLOW);
    functionScenario = createScenario(ScenarioKind.FUNCTIONAL);

    // add scenarios to threat
    EList<Scenario> threatScenarios = threat.getOwnedScenarios();
    threatScenarios.add(interfaceScenario);
    threatScenarios.add(exchangeScenario);
    threatScenarios.add(functionScenario);
  }

  protected Scenario createScenario(ScenarioKind kind) {
    Scenario scenario = InteractionFactory.eINSTANCE.createScenario();
    scenario.setKind(kind);
    return scenario;
  }

  @Override
  protected void doTest() {
    performIStoISTransition(getObjects(interfaceScenario.getId()));
    EObject threat2 = mustBeTransitioned(threat.getId(), nextPkg);
    mustBeTransitioned(interfaceScenario.getId(), threat2);

    performEStoISTransition(getObjects(exchangeScenario.getId()));
    mustBeTransitioned(exchangeScenario.getId(), threat);

    performEStoESTransition(getObjects(exchangeScenario.getId()));
    mustBeMultiTransitioned(exchangeScenario.getId(), 2);

    performESFtoESBTransition(getObjects(exchangeScenario.getId()));
    mustBeMultiTransitioned(exchangeScenario.getId(), 3);

    performFStoFSTransition(getObjects(functionScenario.getId()));
    mustBeTransitioned(functionScenario.getId(), threat2);

    performFStoESTransition(getObjects(functionScenario.getId()));
    mustBeMultiTransitioned(functionScenario.getId(), 2);
  }

}
