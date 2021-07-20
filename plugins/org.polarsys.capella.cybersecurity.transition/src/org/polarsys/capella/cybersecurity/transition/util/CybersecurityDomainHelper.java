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

import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.polarsys.capella.core.transition.system.domain.CapellaTransitionDomainHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

public class CybersecurityDomainHelper extends CapellaTransitionDomainHelper {
  @Override
  protected Set<EPackage> getEPackages() {
    Set<EPackage> ePackages = super.getEPackages();
    ePackages.add(CybersecurityPackage.eINSTANCE);
    return ePackages;
  }

  /**
   * @see org.polarsys.capella.core.transition.system.domain.CapellaTransitionDomainHelper#isDomainFor(Object)
   */
  @Override
  public boolean isDomainFor(Object object) {
    return true;
  }
}