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