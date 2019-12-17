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

import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.ComponentTemplate1;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

/**
 * 
 * Test on CY_DCOV_02 - Verifies that a threat involves at least one Actor/Threat Source.
 *
 */
public class Rule_CY_DCOV_02 extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCOV_02"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  Threat threat;
  Component actor;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = new ComponentTemplate1(skeleton, this);
    threat = service.createThreat(t.component);
    actor = t.component;
    actor.setActor(true);
  }

  @Override
  public void test() throws Exception {
    ko(threat, RULE);
    executeCommand(() -> {
      service.createThreatInvolvement(threat, actor);
    });
    ok(threat, RULE);
  }

}
