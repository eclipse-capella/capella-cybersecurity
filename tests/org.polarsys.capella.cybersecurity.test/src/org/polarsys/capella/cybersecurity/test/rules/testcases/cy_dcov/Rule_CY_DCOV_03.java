/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcov;

import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.ComponentTemplate1;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCOV_03 - Verifies that a Threat threatens at least one asset.
 *
 */
public class Rule_CY_DCOV_03 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCOV_03"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  Threat threat;
  FunctionalPrimaryAsset fpa;
  String architecture;

  public Rule_CY_DCOV_03(String arch) {
    super();
    architecture = arch;
  }

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = createComponentTemplate(skeleton, architecture);
    threat = service.createThreat(t.component, project);
    fpa = service.createFunctionalPrimaryAsset(t.component);
  }

  @Override
  public void test() throws Exception {
    ko(threat, RULE);
    executeCommand(() -> {
      service.createThreatApplication(threat, fpa);
    });
    ok(threat, RULE);
  }

}
