/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcov;

import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.ComponentTemplate1;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCOV_04 - Verifies that a Primary Asset is threatened by at least one Threat.
 *
 */
public class Rule_CY_DCOV_04 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCOV_04"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  Threat threat;
  FunctionalPrimaryAsset fpa;
  InformationPrimaryAsset ipa;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = new ComponentTemplate1(skeleton, this);
    threat = service.createThreat(t.component);
    fpa = service.createFunctionalPrimaryAsset(t.component);
    ipa = service.createInformationPrimaryAsset(t.component);
  }

  @Override
  public void test() throws Exception {
    ko(fpa, RULE);
    ko(ipa, RULE);
    executeCommand(() -> {
      service.createThreatApplication(threat, fpa);
      service.createThreatApplication(threat, ipa);
    });
    ok(fpa, RULE);
    ok(ipa, RULE);
  }
}
