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

import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

/*
 * Here we test the transition of threat involvement and trust boundary storage associated with an operational entity.
 */
public class CyberActorTransitionTest extends CyberTopDownTransitionTestCase {
  private final static String OPERATIONAL_ENTITY = "89336d07-e5d3-4846-9ed1-0ac0189462b9";

  ThreatSourceUse threatUse;
  TrustBoundaryStorage trustBoundaryStorage;
  Entity usedActor;
  Entity operationalActor;

  @Override
  protected void init() {
    super.init();
    usedActor = OaFactory.eINSTANCE.createEntity();
    threatUse = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    trustBoundaryStorage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
    operationalActor = ((Entity) getObject(OPERATIONAL_ENTITY)).getSubEntities().get(0);

    trustBoundaryStorage.setThreatSource(true);
    trustBoundaryStorage.setThreatSourceProfile(3);
    threatUse.setUsed(usedActor);
    operationalActor.getOwnedExtensions().add(threatUse);
    operationalActor.getOwnedExtensions().add(trustBoundaryStorage);
  }

  @Override
  public void doTest() {
    // transition the entity as actor downwards through each level and check and check if the threat, threat involvement
    // and trust boundary storage get properly transitioned
    performOE2ActorTransition(getObjects(operationalActor.getId()));
    SystemComponent systemActor = (SystemComponent) mustBeTransitionedDirecltyContainedBy(operationalActor.getId(),
        BlockArchitectureExt.getComponentPkg(saArch, false));
    ThreatSourceUse systemThreatUse = (ThreatSourceUse) mustBeTransitionedDirecltyContainedBy(threatUse.getId(), systemActor);
    TrustBoundaryStorage transitionedTrustBoundStorage = (TrustBoundaryStorage) mustBeTransitionedDirecltyContainedBy(
        trustBoundaryStorage.getId(), systemActor);
    checkTrustBoundaryStorageProperlyTransitioned(transitionedTrustBoundStorage);

    performActorTransition(getObjects(systemActor.getId()));
    LogicalComponent logicalActor = (LogicalComponent) mustBeTransitionedDirecltyContainedBy(systemActor.getId(),
        BlockArchitectureExt.getComponentPkg(laArch, false));
    ThreatSourceUse logicalThreatUse = (ThreatSourceUse) mustBeTransitionedDirecltyContainedBy(systemThreatUse.getId(), logicalActor);
    transitionedTrustBoundStorage = (TrustBoundaryStorage) mustBeTransitionedDirecltyContainedBy(
        transitionedTrustBoundStorage.getId(),
        logicalActor);
    checkTrustBoundaryStorageProperlyTransitioned(transitionedTrustBoundStorage);

    performActorTransition(getObjects(logicalActor.getId()));
    PhysicalComponent physicalActor = (PhysicalComponent) mustBeTransitionedDirecltyContainedBy(logicalActor.getId(),
        BlockArchitectureExt.getComponentPkg(paArch, false));
    mustBeTransitionedDirecltyContainedBy(logicalThreatUse.getId(), physicalActor);
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
