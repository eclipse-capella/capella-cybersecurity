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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.core.data.capellacommon.TransfoLink;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;

/**
 * @generated
 */
public class FunctionalPrimaryAssetHelper {

  private static final FunctionalPrimaryAssetHelper instance = new FunctionalPrimaryAssetHelper();

  /**
   * @generated
   */
  public static FunctionalPrimaryAssetHelper getInstance() {
    return instance;
  }

  /**
   * @generated NOT
   */
  public Object doSwitch(FunctionalPrimaryAsset object, EStructuralFeature feature) {
    // handle derivated feature
    
    if (feature.equals(CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS)) {
      return getRealizedPrimaryAssets(object);
    } else if (feature.equals(CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS)) {
      return getRealizingPrimaryAssets(object);
    }

    // delegate to parent helper
    return org.polarsys.capella.core.data.helpers.capellacore.delegates.NamedElementHelper.getInstance()
        .doSwitch(object, feature);

  }
  
  /**
   * @generated NOT
   */
  protected List<FunctionalPrimaryAsset> getRealizedPrimaryAssets(FunctionalPrimaryAsset element) {
    List<FunctionalPrimaryAsset> ret = new ArrayList<>();
    for ( AbstractTrace obj : element.getOutgoingTraces()) {
      if(obj instanceof TransfoLink) {
        TransfoLink link = (TransfoLink) obj;
        if(link.getTarget() instanceof FunctionalPrimaryAsset) {
          ret.add((FunctionalPrimaryAsset) link.getTarget());
        }
      }
    }
    return ret;
  }

  /**
   * @generated NOT
   */
  protected List<FunctionalPrimaryAsset> getRealizingPrimaryAssets(FunctionalPrimaryAsset element) {
    List<FunctionalPrimaryAsset> ret = new ArrayList<>();
    for ( AbstractTrace obj : element.getIncomingTraces()) {
      if(obj instanceof TransfoLink) {
        TransfoLink link = (TransfoLink) obj;
        if(link.getSource() instanceof FunctionalPrimaryAsset) {
          ret.add((FunctionalPrimaryAsset) link.getSource());
        }
      }
    }
    return ret;
  }

}