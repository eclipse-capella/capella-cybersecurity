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
package org.polarsys.capella.cybersecurity.validation.util;

import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class CyberValidationHelper {

  /*
   * Returns the title label of a primary asset.
   */
  public static String getPATitleLabel(PrimaryAsset pa) {
    return pa instanceof FunctionalPrimaryAsset
        && BlockArchitectureExt.getRootBlockArchitecture(pa) instanceof OperationalAnalysis
            ?
            "(Operational Activity Primary Asset) "
            : NamingHelper.getTitleLabel(pa);
  }
}
