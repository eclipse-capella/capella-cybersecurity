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

import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

/*
 * Here we test the transition of threat involvement and trust boundary storage associated with an operational entity.
 */
public class CyberActorTransitionTest extends CyberTopDownTransitionTestCase {
  private final static String OPERATIONAL_ENTITY = "89336d07-e5d3-4846-9ed1-0ac0189462b9";

  Threat threat;
  ThreatInvolvement threatInvolvement;
  TrustBoundaryStorage trustBoundaryStorage;
  Entity operationalActor;

  @Override
  protected void init() {
    super.init();
    threat = CybersecurityFactory.eINSTANCE.createThreat();
    threatInvolvement = CybersecurityFactory.eINSTANCE.createThreatInvolvement();
    trustBoundaryStorage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
    operationalActor = ((Entity) getObject(OPERATIONAL_ENTITY)).getSubEntities().get(0);

    trustBoundaryStorage.setThreatSource(true);
    trustBoundaryStorage.setThreatSourceProfile(3);
    // set the threat to the threat involvement and add it and the trust boundary as extensions to the actor
    threatInvolvement.setThreat(threat);
    operationalActor.getOwnedExtensions().add(threatInvolvement);
    operationalActor.getOwnedExtensions().add(trustBoundaryStorage);

    // add the threat on the operational level
    oaPkg.getOwnedThreats().add(threat);
  }

  @Override
  public void doTest() {
    // transition the entity as actor downwards through each level and check and check if the threat, threat involvement
    // and trust boundary storage get properly transitioned
    performOE2ActorTransition(getObjects(operationalActor.getId()));
    SystemComponent systemActor = (SystemComponent) mustBeTransitionedDirecltyContainedBy(operationalActor.getId(),
        BlockArchitectureExt.getComponentPkg(saArch, false));
    Threat systemThreat = (Threat) mustBeTransitionedDirecltyContainedBy(threat.getId(), saPkg);
    ThreatInvolvement systemThreatInv = (ThreatInvolvement) mustBeTransitionedDirecltyContainedBy(
        threatInvolvement.getId(), systemActor);
    TrustBoundaryStorage transitionedTrustBoundStorage = (TrustBoundaryStorage) mustBeTransitionedDirecltyContainedBy(
        trustBoundaryStorage.getId(), systemActor);
    checkTrustBoundaryStorageProperlyTransitioned(transitionedTrustBoundStorage);

    performActorTransition(getObjects(systemActor.getId()));
    LogicalComponent logicalActor = (LogicalComponent) mustBeTransitionedDirecltyContainedBy(systemActor.getId(),
        BlockArchitectureExt.getComponentPkg(laArch, false));
    Threat logicalThreat = (Threat) mustBeTransitionedDirecltyContainedBy(systemThreat.getId(), laPkg);
    ThreatInvolvement logicalThreatInv = (ThreatInvolvement) mustBeTransitionedDirecltyContainedBy(
        systemThreatInv.getId(), logicalActor);
    transitionedTrustBoundStorage = (TrustBoundaryStorage) mustBeTransitionedDirecltyContainedBy(
        transitionedTrustBoundStorage.getId(),
        logicalActor);
    checkTrustBoundaryStorageProperlyTransitioned(transitionedTrustBoundStorage);

    performActorTransition(getObjects(logicalActor.getId()));
    PhysicalComponent physicalActor = (PhysicalComponent) mustBeTransitionedDirecltyContainedBy(logicalActor.getId(),
        BlockArchitectureExt.getComponentPkg(paArch, false));
    mustBeTransitionedDirecltyContainedBy(logicalThreat.getId(), paPkg);
    mustBeTransitionedDirecltyContainedBy(logicalThreatInv.getId(), physicalActor);
    mustBeTransitionedDirecltyContainedBy(transitionedTrustBoundStorage.getId(), physicalActor);
    checkTrustBoundaryStorageProperlyTransitioned(transitionedTrustBoundStorage);
  }

  private void checkTrustBoundaryStorageProperlyTransitioned(TrustBoundaryStorage transitionedTrustBoundStorage) {
    assertEquals(trustBoundaryStorage.getThreatSourceProfile(), transitionedTrustBoundStorage.getThreatSourceProfile());
    assertEquals(trustBoundaryStorage.isThreatSource(), transitionedTrustBoundStorage.isThreatSource());
    assertEquals(trustBoundaryStorage.isTrusted(), transitionedTrustBoundStorage.isTrusted());
    assertEquals(trustBoundaryStorage.getDescription(), transitionedTrustBoundStorage.getDescription());
  }

}
