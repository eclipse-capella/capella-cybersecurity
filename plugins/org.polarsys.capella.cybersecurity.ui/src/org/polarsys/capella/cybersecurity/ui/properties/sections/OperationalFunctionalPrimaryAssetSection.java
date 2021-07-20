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
package org.polarsys.capella.cybersecurity.ui.properties.sections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;

public class OperationalFunctionalPrimaryAssetSection extends FunctionalPrimaryAssetSection {
  public OperationalFunctionalPrimaryAssetSection() {
    super(false);
  }
  
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof FunctionalPrimaryAsset && !isRealizedArchitecture(eObjectToTest);
  }
}
