/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.model.helpers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.model.helpers.HelperNotFoundException;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

/**
 * @generated
 */
public class ThreatSourceUseHelper {

  private static final ThreatSourceUseHelper instance = new ThreatSourceUseHelper();

  /**
   * @generated
   */
  public static ThreatSourceUseHelper getInstance() {
    return instance;
  }

  /**
   * @generated
   */
  public Object doSwitch(ThreatSourceUse object, EStructuralFeature feature) {
    // handle derivated feature

    // delegate to parent helper
    return org.polarsys.capella.core.data.helpers.capellacore.delegates.RelationshipHelper.getInstance()
        .doSwitch(object, feature);

  }

}