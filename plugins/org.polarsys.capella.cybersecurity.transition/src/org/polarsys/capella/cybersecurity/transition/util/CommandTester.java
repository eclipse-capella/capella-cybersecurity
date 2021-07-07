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
