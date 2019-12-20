/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.emde.model.edit.provider.helpers.EMDEHelper;

public class CommonHelpers {

  public static boolean canBeExtendedBy(EObject parent, EClass extensionClass) {
    Collection<EClass> extendedElements = EMDEHelper.getExtendedElement(new BasicDiagnostic(), extensionClass);
    for (EClass extendedElement : extendedElements) {
      if (extendedElement.isInstance(parent)) {
        return true;
      }
    }
    return false;
  }

  public static boolean isViewpointActive(EObject modelElement, String viewpointId) {
    return ViewpointManager.getInstance(modelElement).isUsed(viewpointId)
        && !ViewpointManager.getInstance(modelElement).isFiltered(viewpointId);
  }

}
