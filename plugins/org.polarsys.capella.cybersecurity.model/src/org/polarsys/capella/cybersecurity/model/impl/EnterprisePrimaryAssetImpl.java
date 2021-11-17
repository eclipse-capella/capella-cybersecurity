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

import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

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
   * The cached value of the '{@link #getPrimaryAssets() <em>Primary Assets</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryAssets()
   * @generated
   * @ordered
   */
  protected EList<PrimaryAsset> primaryAssets;

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
   * @generated
   */

  @Override
  public EList<PrimaryAsset> getPrimaryAssets() {

    if (primaryAssets == null) {
      primaryAssets = new EObjectResolvingEList<PrimaryAsset>(PrimaryAsset.class, this,
          CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS);
    }
    return primaryAssets;
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS:
      getPrimaryAssets().clear();
      getPrimaryAssets().addAll((Collection<? extends PrimaryAsset>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS:
      getPrimaryAssets().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS:
      return primaryAssets != null && !primaryAssets.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // EnterprisePrimaryAssetImpl