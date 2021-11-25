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
package org.polarsys.capella.cybersecurity.ui.move;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.model.helpers.move.MoveHelper;
import org.polarsys.capella.cybersecurity.CyberSecurityViewpointHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;

public class CybersecurityMoveHelper extends MoveHelper {

  @Override
  public IStatus checkSemanticRules(List<EObject> selectedElements, EObject targetObject) {
    for (EObject elem : selectedElements) {
      if (elem.eClass().getEPackage() == CybersecurityPackage.eINSTANCE) {
        if (!areInSameLayer((ModelElement) elem, (ModelElement) targetObject)) {
          return new Status(IStatus.INFO, CyberSecurityViewpointHelper.VIEWPOINT_ID,
              "Cannot move to other architecture.");
        }

        // a CybersecurityPkg can be moved only to a CybersecurityPkg
        if (elem instanceof CybersecurityPkg && !(targetObject instanceof CybersecurityPkg)) {
          return new Status(IStatus.INFO, CyberSecurityViewpointHelper.VIEWPOINT_ID,
              "Target is not a CybersecurityPkg.");
        }
      }
      // cannot move/copy-paste CybersecurityConfiguration
      if (elem instanceof CybersecurityConfiguration) {
        return new Status(IStatus.INFO, CyberSecurityViewpointHelper.VIEWPOINT_ID,
            "Cannot move CybersecurityConfiguration.");
      }
    }

    return Status.OK_STATUS;
  }

  @Override
  public IStatus checkEMFRules(List<EObject> selectedModelElements, EObject targetElement) {
    return null;
  }

}