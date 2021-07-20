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

import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;

public class Rule_CY_DCON_01_SA extends Rule_CY_DCON_01{

  @Override
  protected BlockArchitecture getArchitecture(CapellaModelSkeleton skeleton) {
    return skeleton.getSystemAnalysis();
  }

  @Override
  protected AbstractFunction getFunction(BlockArchitecture architecture) {
    return ((SystemAnalysis) architecture).getContainedSystemFunctionPkg().getOwnedSystemFunctions().get(0);
  }

}
