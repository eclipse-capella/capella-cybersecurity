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
package org.polarsys.capella.cybersecurity.transition.util;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.projection.common.TransitionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;

public class CybersecurityTransitionHelper extends TransitionHelper {

  /** A shared instance. */
  private static CybersecurityTransitionHelper service;

  /**
   * returns a shared instance of this services.
   * 
   * @return a shared instance of this services.
   */
  public static CybersecurityTransitionHelper getService() {
    if (service == null) {
      service = new CybersecurityTransitionHelper();
    }
    return service;
  }

  public boolean isThreatTransitionAvailable(EObject element) {
    return (element instanceof CybersecurityPkg)
        || (element instanceof Threat) || (element instanceof BlockArchitecture);
  }

  public boolean isPrimaryAssetTransitionAvailable(EObject element) {
    return (element instanceof CybersecurityPkg) || (element instanceof PrimaryAsset)
        || (element instanceof BlockArchitecture);
  }
}
