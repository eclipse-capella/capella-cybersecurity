
package org.polarsys.capella.cybersecurity.model.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EList<PrimaryAsset> getPrimaryAssets() {

    // TODO: implement this method to return the 'Primary Assets' reference list
    // Ensure that you remove @generated or mark it @generated NOT
    // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
    // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
    throw new UnsupportedOperationException();

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