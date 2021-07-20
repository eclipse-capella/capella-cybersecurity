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

import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.transition.system.topdown.constants.ITopDownConstants;
import org.polarsys.capella.core.transition.system.topdown.preferences.PreferenceHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;

public abstract class PrimaryAssetTransitionTest extends CyberTopDownTransitionTestCase {
  PrimaryAsset primaryAsset;
  PrimaryAsset primaryAsset2;
  SecurityNeeds securityNeeds;
  PrimaryAssetMember primaryAssetMember;
  Threat threat;
  ThreatApplication threatApplication;
  ExchangeItem exchangeItem;

  protected abstract PrimaryAsset createPrimaryAsset();

  protected abstract void addPAMMember();

  protected abstract void checkPAMMemberTransitioned(Type level);

  @Override
  protected void init() {
    super.init();
    primaryAsset = createPrimaryAsset();
    primaryAsset2 = createPrimaryAsset();
    primaryAssetMember = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    threat = CybersecurityFactory.eINSTANCE.createThreat();
    threatApplication = CybersecurityFactory.eINSTANCE.createThreatApplication();
    exchangeItem = InformationFactory.eINSTANCE.createExchangeItem();
    // create security needs with some values and add it to the pa; also add the threat application
    securityNeeds = CybersecurityFactory.eINSTANCE.createSecurityNeeds();
    CybersecurityQueries.setConfidentialityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getConfidentialityPropertyType(project));
    CybersecurityQueries.setIntegrityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getIntegrityPropertyType(project));
    CybersecurityQueries.setTraceabilityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getTraceabilityPropertyType(project));
    CybersecurityQueries.setAvailabilityFromIndex(securityNeeds, 1,
        CybersecurityQueries.getAvailabilityPropertyType(project));
    primaryAsset.getOwnedExtensions().add(securityNeeds);
    primaryAsset.getOwnedExtensions().add(threatApplication);

    // set the threat to the threat application
    threatApplication.setThreat(threat);

    // add the member depending on the pa type to the primary asset member
    addPAMMember();
    
    // add the pa member to the pa
    primaryAsset.getOwnedMembers().add(primaryAssetMember);

    // add the pa and threat on the operational level
    oaPkg.getOwnedPrimaryAssets().add(primaryAsset);
    oaPkg.getOwnedPrimaryAssets().add(primaryAsset2);
    oaPkg.getOwnedThreats().add(threat);

    // add the exchange item in the interface package
    BlockArchitectureExt.getInterfacePkg(oaArch, false).getOwnedExchangeItems().add(exchangeItem);
  }

  @Override
  protected void doTest() {
    // activate the option in preferences that exchange item should be transitioned
    PreferenceHelper.getInstance().setBooleanValue(ITopDownConstants.OPTIONS_TRANSITION__EXCHANGE_ITEM, true);

    // transition the pa downwards through each level
    performPrimaryAssetTransition(getObjects(primaryAsset.getId()));
    PrimaryAsset systemPa = (PrimaryAsset) mustBeTransitioned(primaryAsset.getId(), saPkg);
    // check that security needs has been transitioned and also retained its values
    // SecurityNeeds transitionedSecurityNeeds = (SecurityNeeds) systemPa.getOwnedExtensions().get(0);
    SecurityNeeds transitionedSecurityNeeds = (SecurityNeeds) mustBeTransitionedDirecltyContainedBy(
        securityNeeds.getId(), systemPa);
    checkSecurityNeedsProperlyTransitioned(transitionedSecurityNeeds);
    // check that the primary asset member has been transitioned as well as the member it points to
    PrimaryAssetMember systemPam = (PrimaryAssetMember) mustBeTransitionedDirecltyContainedBy(
        primaryAssetMember.getId(), systemPa);
    checkPAMMemberTransitioned(Type.SA);
    // check that the threat application and the threat it points to has been transitioned
    ThreatApplication systemThreatApplication = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        threatApplication.getId(), systemPa);
    Threat systemThreat = (Threat) mustBeTransitionedDirecltyContainedBy(threat.getId(), saPkg);
    // check that primaryAsset2 is not transitioned
    assertTrue(primaryAsset2.getIncomingTraces().isEmpty());

    performPrimaryAssetTransition(getObjects(systemPa.getId()));
    PrimaryAsset logicalPa = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(systemPa.getId(), laPkg);
    transitionedSecurityNeeds = (SecurityNeeds) mustBeTransitionedDirecltyContainedBy(transitionedSecurityNeeds.getId(),
        logicalPa);
    checkSecurityNeedsProperlyTransitioned(transitionedSecurityNeeds);
    PrimaryAssetMember logicalPam = (PrimaryAssetMember) mustBeTransitionedDirecltyContainedBy(systemPam.getId(),
        logicalPa);
    checkPAMMemberTransitioned(Type.LA);
    ThreatApplication logicalThreatApplication = (ThreatApplication) mustBeTransitionedDirecltyContainedBy(
        systemThreatApplication.getId(), logicalPa);
    Threat logicalThreat = (Threat) mustBeTransitionedDirecltyContainedBy(systemThreat.getId(), laPkg);

    performPrimaryAssetTransition(getObjects(logicalPa.getId()));
    PrimaryAsset physicalPa = (PrimaryAsset) mustBeTransitionedDirecltyContainedBy(logicalPa.getId(), paPkg);
    transitionedSecurityNeeds = (SecurityNeeds) mustBeTransitionedDirecltyContainedBy(transitionedSecurityNeeds.getId(),
        physicalPa);
    checkSecurityNeedsProperlyTransitioned(transitionedSecurityNeeds);
    mustBeTransitionedDirecltyContainedBy(logicalPam.getId(), physicalPa);
    checkPAMMemberTransitioned(Type.PA);
    mustBeTransitionedDirecltyContainedBy(logicalThreatApplication.getId(), physicalPa);
    mustBeTransitionedDirecltyContainedBy(logicalThreat.getId(), paPkg);
  }

  private void checkSecurityNeedsProperlyTransitioned(SecurityNeeds transitionedSecurityNeeds) {
    assertEquals(securityNeeds.getConfidentialityValue(), transitionedSecurityNeeds.getConfidentialityValue());
    assertEquals(securityNeeds.getIntegrityValue(), transitionedSecurityNeeds.getIntegrityValue());
    assertEquals(securityNeeds.getTraceabilityValue(), transitionedSecurityNeeds.getTraceabilityValue());
    assertEquals(securityNeeds.getAvailabilityValue(), transitionedSecurityNeeds.getAvailabilityValue());
  }
}
