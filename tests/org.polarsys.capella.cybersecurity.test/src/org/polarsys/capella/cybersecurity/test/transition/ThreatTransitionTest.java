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
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;

public class ThreatTransitionTest extends CyberTopDownTransitionTestCase {
  Threat threat;
  Threat threat2;
  SecurityNeeds securityNeeds;
  PrimaryAsset enterprisePrimaryAsset;
  PrimaryAsset functionalPrimaryAsset;
  PrimaryAsset informationPrimaryAsset;
  ThreatApplication threatApplicationEPA;
  ThreatApplication threatApplicationFPA;
  ThreatApplication threatApplicationIPA;
  Entity actor;
  ThreatInvolvement threatInvolvement;

  @Override
  protected void init() {
    super.init();
    // create threat
    threat = CybersecurityFactory.eINSTANCE.createThreat();
    threat2 = CybersecurityFactory.eINSTANCE.createThreat();
    actor = OaFactory.eINSTANCE.createEntity();
    enterprisePrimaryAsset = CybersecurityFactory.eINSTANCE.createEnterprisePrimaryAsset();
    functionalPrimaryAsset = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    informationPrimaryAsset = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    
    threatApplicationEPA = CybersecurityFactory.eINSTANCE.createThreatApplication();
    threatApplicationFPA = CybersecurityFactory.eINSTANCE.createThreatApplication();
    threatApplicationIPA = CybersecurityFactory.eINSTANCE.createThreatApplication();

    threatInvolvement = CybersecurityFactory.eINSTANCE.createThreatInvolvement();

    // set threat kind and level to some values to be able to check they get properly transitioned
    EnumerationPropertyType threatKindType = CybersecurityQueries.getThreatKindPropertyType(project);
    CybersecurityQueries.setThreatKindFromIndex(threat, 1, threatKindType);
    threat.setLevel(2);
    // create security needs with some values and add it to the pa
    securityNeeds = CybersecurityFactory.eINSTANCE.createSecurityNeeds();
    CybersecurityQueries.setConfidentialityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getConfidentialityPropertyType(project));
    CybersecurityQueries.setIntegrityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getIntegrityPropertyType(project));
    CybersecurityQueries.setTraceabilityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getTraceabilityPropertyType(project));
    CybersecurityQueries.setAvailabilityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getAvailabilityPropertyType(project));
    threat.getOwnedExtensions().add(securityNeeds);

    // add the threat on the operational level
    oaPkg.getOwnedThreats().add(threat);
    oaPkg.getOwnedThreats().add(threat2);
    
    oaPkg.getOwnedPrimaryAssets().add(enterprisePrimaryAsset);
    oaPkg.getOwnedPrimaryAssets().add(functionalPrimaryAsset);
    oaPkg.getOwnedPrimaryAssets().add(informationPrimaryAsset);
    
    // add the actor to the entity pkg
    ((OperationalAnalysis) oaArch).getOwnedEntityPkg().getOwnedEntities().add(actor);

    // set the PAs to the threat applications
    threatApplicationEPA.setAsset(enterprisePrimaryAsset);
    threatApplicationFPA.setAsset(functionalPrimaryAsset);
    threatApplicationIPA.setAsset(informationPrimaryAsset);
    
    // set the actor to the threat involvement
    threatInvolvement.setComponent(actor);

    threat.getOwnedThreatApplications().add(threatApplicationEPA);
    threat.getOwnedThreatApplications().add(threatApplicationFPA);
    threat.getOwnedThreatApplications().add(threatApplicationIPA);
    
    threat.getOwnedThreatInvolvements().add(threatInvolvement);
  }

  @Override
  public void doTest() {
    // transition the threat downwards through each level and check if the threat kind and level remain the same
    performThreatTransition(getObjects(threat.getId()));
    Threat systemThreat = (Threat) mustBeTransitioned(threat.getId(), saPkg);
    assertEquals(threat.getKind(), systemThreat.getKind());
    assertEquals(threat.getLevel(), systemThreat.getLevel());
    assertFalse(threat.getIncomingTraces().isEmpty());
    // check that security needs has been transitioned and also retained its values
    SecurityNeeds transitionedSecurityNeeds = (SecurityNeeds) mustBeTransitionedDirecltyContainedBy(
        securityNeeds.getId(), systemThreat);
    checkSecurityNeedsProperlyTransitioned(transitionedSecurityNeeds);
    
    // check that the threat applications and the PAs they points to have been transitioned
    PrimaryAsset systemEPA = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(enterprisePrimaryAsset.getId(),
        saPkg);
    PrimaryAsset systemFPA = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(functionalPrimaryAsset.getId(),
        saPkg);
    PrimaryAsset systemIPA = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(informationPrimaryAsset.getId(),
        saPkg);

    ThreatApplication systemThreatApplicationEPA = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        threatApplicationEPA.getId(), systemThreat);
    ThreatApplication systemThreatApplicationFPA = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        threatApplicationFPA.getId(), systemThreat);
    ThreatApplication systemThreatApplicationIPA = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        threatApplicationIPA.getId(), systemThreat);

    // check that the threat involvement and the actor have been transitioned
    ThreatInvolvement transitionedThreatInvolvement = (ThreatInvolvement) mustBeTransitionedDirecltyContainedBy(
        threatInvolvement.getId(),
        systemThreat);

    Component transitionedActor = (Component) mustBeTransitionedDirecltyContainedBy(actor.getId(),
        BlockArchitectureExt.getComponentPkg(saArch, false));

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
    transitionedSecurityNeeds = (SecurityNeeds) mustBeTransitionedDirecltyContainedBy(transitionedSecurityNeeds.getId(),
        logicalThreat);
    checkSecurityNeedsProperlyTransitioned(transitionedSecurityNeeds);

    PrimaryAsset logicalEPA = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(systemEPA.getId(), laPkg);
    PrimaryAsset logicalFPA = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(systemFPA.getId(), laPkg);
    PrimaryAsset logicalIPA = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(systemIPA.getId(), laPkg);

    ThreatApplication logicalThreatApplicationEPA = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        systemThreatApplicationEPA.getId(), logicalThreat);
    ThreatApplication logicalThreatApplicationFPA = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        systemThreatApplicationFPA.getId(), logicalThreat);
    ThreatApplication logicalThreatApplicationIPA = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        systemThreatApplicationIPA.getId(), logicalThreat);

    transitionedThreatInvolvement = (ThreatInvolvement) mustBeTransitionedDirecltyContainedBy(
        transitionedThreatInvolvement.getId(), logicalThreat);

    transitionedActor = (Component) mustBeTransitionedDirecltyContainedBy(transitionedActor.getId(),
        BlockArchitectureExt.getComponentPkg(laArch, false));

    performThreatTransition(getObjects(logicalThreat.getId()));
    Threat physicalThreat = (Threat) mustBeTransitioned(logicalThreat.getId(), paPkg);
    assertEquals(threat.getKind(), physicalThreat.getKind());
    assertEquals(threat.getLevel(), physicalThreat.getLevel());
    transitionedSecurityNeeds = (SecurityNeeds) mustBeTransitionedDirecltyContainedBy(transitionedSecurityNeeds.getId(),
        physicalThreat);
    checkSecurityNeedsProperlyTransitioned(transitionedSecurityNeeds);

    mustBeTransitionedDirecltyContainedBy(logicalEPA.getId(), paPkg);
    mustBeTransitionedDirecltyContainedBy(logicalFPA.getId(), paPkg);
    mustBeTransitionedDirecltyContainedBy(logicalIPA.getId(), paPkg);

    mustBeTransitionedDirecltyContainedBy(logicalThreatApplicationEPA.getId(), physicalThreat);
    mustBeTransitionedDirecltyContainedBy(logicalThreatApplicationFPA.getId(), physicalThreat);
    mustBeTransitionedDirecltyContainedBy(logicalThreatApplicationIPA.getId(), physicalThreat);
    
    mustBeTransitionedDirecltyContainedBy(transitionedThreatInvolvement.getId(), physicalThreat);

    mustBeTransitionedDirecltyContainedBy(transitionedActor.getId(),
        BlockArchitectureExt.getComponentPkg(paArch, false));
  }

  private void checkSecurityNeedsProperlyTransitioned(SecurityNeeds transitionedSecurityNeeds) {
    assertEquals(securityNeeds.getConfidentialityValue(), transitionedSecurityNeeds.getConfidentialityValue());
    assertEquals(securityNeeds.getIntegrityValue(), transitionedSecurityNeeds.getIntegrityValue());
    assertEquals(securityNeeds.getTraceabilityValue(), transitionedSecurityNeeds.getTraceabilityValue());
    assertEquals(securityNeeds.getAvailabilityValue(), transitionedSecurityNeeds.getAvailabilityValue());
  }

}
