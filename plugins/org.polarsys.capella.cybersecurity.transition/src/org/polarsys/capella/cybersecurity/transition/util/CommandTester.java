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
import org.eclipse.core.expressions.PropertyTester;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.ui.actions.ModelAdaptation;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;

public class CommandTester extends PropertyTester {

  @Override
  public boolean test(Object object, String propertyName, Object[] params, Object testedValue) {
    if (propertyName.equals("transitionMode")) { //$NON-NLS-1$
      ModelElement element = ModelAdaptation.adaptToCapella(object);

      if ((element != null) && (testedValue instanceof String) && testedValue.equals("transitionCybersecurity")) {
        BlockArchitecture blockArchitecture = BlockArchitectureExt.getRootBlockArchitecture(element);
        if (BlockArchitectureExt.getBlockArchitectureType(blockArchitecture) != Type.PA
            && BlockArchitectureExt.getBlockArchitectureType(blockArchitecture) != Type.EPBS)
         return CybersecurityTransitionHelper.getService().isThreatTransitionAvailable(element) ||
             CybersecurityTransitionHelper.getService().isPrimaryAssetTransitionAvailable(element);
      }
    }

    return false;
  }
}
