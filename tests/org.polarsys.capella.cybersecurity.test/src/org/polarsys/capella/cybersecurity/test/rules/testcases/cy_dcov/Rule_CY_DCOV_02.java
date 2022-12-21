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
  String architecture;

  public Rule_CY_DCOV_02(String arch) {
    super();
    architecture = arch;
  }

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = createComponentTemplate(skeleton, architecture);
    threat = service.createThreat(t.component, project);
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
