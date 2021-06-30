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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.polarsys.capella.core.data.cs.ComponentPkg;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;

public class Rule_CY_DCON_02_OA extends Rule_CY_DCON_02{

  @Override
  protected AbstractFunction getFunction(CapellaModelSkeleton skeleton) {
    return skeleton.getOperationalAnalysis().getContainedOperationalActivityPkg().getOwnedOperationalActivities().get(0);
  }

  @Override
  protected ComponentPkg getComponentPkg(CapellaModelSkeleton skeleton) {
    return  skeleton.getOperationalAnalysis().getOwnedEntityPkg();
  }

}