package org.polarsys.capella.cybersecurity.model.helpers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.model.helpers.HelperNotFoundException;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;

/**
 * @generated
 */
public class EnterprisePrimaryAssetHelper {

  private static final EnterprisePrimaryAssetHelper instance = new EnterprisePrimaryAssetHelper();

  /**
   * @generated
   */
  public static EnterprisePrimaryAssetHelper getInstance() {
    return instance;
  }

  /**
   * @generated
   */
  public Object doSwitch(EnterprisePrimaryAsset object, EStructuralFeature feature) {
    // handle derivated feature

    // delegate to parent helper
    return org.polarsys.capella.core.data.helpers.capellacore.delegates.NamedElementHelper.getInstance()
        .doSwitch(object, feature);

  }

}