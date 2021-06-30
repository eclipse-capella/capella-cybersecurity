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

import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;

public class Rule_CY_DCON_01_LA extends Rule_CY_DCON_01{

  @Override
  protected BlockArchitecture getArchitecture(CapellaModelSkeleton skeleton) {
    return skeleton.getLogicalArchitecture();
  }

  @Override
  protected AbstractFunction getFunction(BlockArchitecture architecture) {
    return ((LogicalArchitecture) architecture).getContainedLogicalFunctionPkg().getOwnedLogicalFunctions().get(0);
  }

}
