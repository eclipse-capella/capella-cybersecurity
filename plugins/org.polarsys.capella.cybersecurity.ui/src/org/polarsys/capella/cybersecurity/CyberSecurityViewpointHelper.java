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

package org.polarsys.capella.cybersecurity;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class CyberSecurityViewpointHelper {

  /**
   * The unique ID of the viewpoint
   */
  public static final String VIEWPOINT_ID = "org.polarsys.capella.cybersecurity";

  /**
   * @return true is the cyber security viewpoint is active, false otherwise
   */
  public static boolean isViewpointActive(EObject element) {
    try {
      return (element != null)
          ? ViewpointManager.getInstance(element).isReferenced(VIEWPOINT_ID)
              && !ViewpointManager.getInstance(element).isInactive(VIEWPOINT_ID)
          : false;
    } catch (IllegalArgumentException ex) {
      // Element is invalid, silent failure
    }
    return false;
  }
}
