/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.model.helpers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.model.helpers.HelperNotFoundException;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage;

/**
 * @generated
 */
public class PrimaryAssetStorageHelper {

  private static final PrimaryAssetStorageHelper instance = new PrimaryAssetStorageHelper();

  /**
   * @generated
   */
  public static PrimaryAssetStorageHelper getInstance() {
    return instance;
  }

  /**
   * @generated
   */
  public Object doSwitch(PrimaryAssetStorage object, EStructuralFeature feature) {
    // handle derivated feature

    // delegate to parent helper
    return org.polarsys.capella.common.data.helpers.modellingcore.delegates.ModelElementHelper.getInstance()
        .doSwitch(object, feature);

  }

}