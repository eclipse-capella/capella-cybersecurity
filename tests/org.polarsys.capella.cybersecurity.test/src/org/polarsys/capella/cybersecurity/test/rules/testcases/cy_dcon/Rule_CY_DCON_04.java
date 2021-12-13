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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;
import org.polarsys.capella.test.diagram.common.ju.context.XABDiagram;

/**
 * 
 * Test on CY_DCON_01 - Verifies that the SecurityNeeds of a Functional Exchange are at least as high as each of its
 * allocated Exchange Items.
 *
 */
public class Rule_CY_DCON_04 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCON_04"; //$NON-NLS-1$

  protected XABDiagram diagram;
  CybersecurityServices service = new CybersecurityServices();
  ThreatSourceUse threatSourceUse;
  TrustBoundaryStorage trustBoundaryStorage;
  SystemComponent actor1;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    actor1 = ComponentExt.createSystemActor();
    SystemComponent actor2 = ComponentExt.createSystemActor();
    SystemAnalysis architecture = skeleton.getSystemAnalysis();
    EList<SystemComponent> systemComponents = architecture.getOwnedSystemComponentPkg().getOwnedSystemComponents();
    systemComponents.add(actor1);
    systemComponents.add(actor2);

    actor1.setActor(true);
    actor2.setActor(true);

    threatSourceUse = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    threatSourceUse.setUsed(actor1);
    trustBoundaryStorage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
    trustBoundaryStorage.setThreatSource(true);
    actor1.getOwnedExtensions().add(trustBoundaryStorage);
    actor1.getOwnedExtensions().add(threatSourceUse);
  }

  @Override
  public void test() throws Exception {
    ok(threatSourceUse, RULE);

    executeCommand(() -> {
      trustBoundaryStorage.setThreatSource(false);
      trustBoundaryStorage.setTrusted(true);
      actor1.getOwnedExtensions().add(trustBoundaryStorage);
    });
    ko(threatSourceUse, RULE);

  }

}
