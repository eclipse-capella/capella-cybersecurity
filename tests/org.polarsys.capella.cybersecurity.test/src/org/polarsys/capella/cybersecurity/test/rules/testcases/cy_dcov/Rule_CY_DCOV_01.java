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

import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.ComponentTemplate1;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCOV_01 - Verifies that a Threat Source is involved by at least one Threat.
 *
 */
public class Rule_CY_DCOV_01 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCOV_01"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  Component threatSource;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = new ComponentTemplate1(skeleton, this);
    threatSource = t.component;
  }

  @Override
  public void test() throws Exception {
    assertNotNull(threatSource);
    ok(threatSource, RULE);
    TrustBoundaryStorage storage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
    executeCommand(() -> {
      threatSource.getOwnedExtensions().add(storage);
    });
    ok(threatSource, RULE);
    executeCommand(() -> storage.setThreatSource(true));
    ko(threatSource, RULE);
    executeCommand(() -> {
      Threat threat = service.createThreat(threatSource);
      service.createThreatInvolvement(threat, threatSource);
    });
    ok(threatSource, RULE);
  }

}
