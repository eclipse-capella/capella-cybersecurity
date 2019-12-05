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
package org.polarsys.capella.cybersecurity.test.rules;

import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.ComponentTemplate1;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

public class Threat__noAsset extends DynamicValidationTest {

  private static final String RULE = "org.polarsys.capella.cybersecurity.validation.threat__noAsset"; //$NON-NLS-1$

  CybersecurityServices service = new CybersecurityServices();
  Threat threat;
  FunctionalPrimaryAsset fpa;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton) {
    ComponentTemplate1 t = new ComponentTemplate1(skeleton, this);
    threat = service.createThreat(t.component);
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
