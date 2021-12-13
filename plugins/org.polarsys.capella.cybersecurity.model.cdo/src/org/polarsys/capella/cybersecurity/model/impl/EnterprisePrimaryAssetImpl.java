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
package org.polarsys.capella.cybersecurity.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EcoreEList;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Enterprise Primary Asset</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.EnterprisePrimaryAssetImpl#getPrimaryAssets <em>Primary Assets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnterprisePrimaryAssetImpl extends PrimaryAssetImpl implements EnterprisePrimaryAsset {

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected EnterprisePrimaryAssetImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.ENTERPRISE_PRIMARY_ASSET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */

  @Override
  public EList<PrimaryAsset> getPrimaryAssets() {
    Collection<PrimaryAsset> result = new ArrayList<>();
    for (PrimaryAssetMember pam : getOwnedMembers()) {
      if (pam.getMember() instanceof PrimaryAsset) {
        result.add((PrimaryAsset) pam.getMember());
      }
    }
    Object[] data = result.toArray();
    return new EcoreEList.UnmodifiableEList<>(this,
        CybersecurityPackage.Literals.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS, data.length, data);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS:
      return getPrimaryAssets();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS:
      return !getPrimaryAssets().isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // EnterprisePrimaryAssetImpl