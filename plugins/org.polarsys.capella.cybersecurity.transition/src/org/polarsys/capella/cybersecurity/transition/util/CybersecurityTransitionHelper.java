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
