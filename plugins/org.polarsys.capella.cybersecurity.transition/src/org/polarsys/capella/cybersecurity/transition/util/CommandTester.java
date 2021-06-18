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

public class CommandTester extends PropertyTester {

  @Override
  public boolean test(Object object, String propertyName, Object[] params, Object testedValue) {
    if (propertyName.equals("transitionMode")) { //$NON-NLS-1$
      ModelElement element = ModelAdaptation.adaptToCapella(object);

      if ((element != null) && (testedValue instanceof String) && testedValue.equals("transitionCybersecurity")) {
         return CybersecurityTransitionHelper.getService().isThreatTransitionAvailable(element);
      }
    }

    return false;
  }
}
