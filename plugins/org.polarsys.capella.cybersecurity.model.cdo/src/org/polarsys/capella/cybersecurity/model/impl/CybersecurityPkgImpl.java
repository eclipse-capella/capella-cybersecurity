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

package org.polarsys.capella.cybersecurity.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pkg</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl#getOwnedThreats <em>Owned
 * Threats</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl#getOwnedCybersecurityPkgs <em>Owned
 * Cybersecurity Pkgs</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl#getOwnedPrimaryAssets <em>Owned Primary
 * Assets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CybersecurityPkgImpl extends NamedElementImpl implements CybersecurityPkg {

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected CybersecurityPkgImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.CYBERSECURITY_PKG;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  @SuppressWarnings("unchecked")
  public EList<Threat> getOwnedThreats() {

    return (EList<Threat>) eDynamicGet(CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS,
        CybersecurityPackage.Literals.CYBERSECURITY_PKG__OWNED_THREATS, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  @SuppressWarnings("unchecked")
  public EList<CybersecurityPkg> getOwnedCybersecurityPkgs() {

    return (EList<CybersecurityPkg>) eDynamicGet(CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS,
        CybersecurityPackage.Literals.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  @SuppressWarnings("unchecked")
  public EList<PrimaryAsset> getOwnedPrimaryAssets() {

    return (EList<PrimaryAsset>) eDynamicGet(CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS,
        CybersecurityPackage.Literals.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS:
      return ((InternalEList<?>) getOwnedThreats()).basicRemove(otherEnd, msgs);
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS:
      return ((InternalEList<?>) getOwnedCybersecurityPkgs()).basicRemove(otherEnd, msgs);
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS:
      return ((InternalEList<?>) getOwnedPrimaryAssets()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS:
      return getOwnedThreats();
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS:
      return getOwnedCybersecurityPkgs();
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS:
      return getOwnedPrimaryAssets();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS:
      getOwnedThreats().clear();
      getOwnedThreats().addAll((Collection<? extends Threat>) newValue);
      return;
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS:
      getOwnedCybersecurityPkgs().clear();
      getOwnedCybersecurityPkgs().addAll((Collection<? extends CybersecurityPkg>) newValue);
      return;
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS:
      getOwnedPrimaryAssets().clear();
      getOwnedPrimaryAssets().addAll((Collection<? extends PrimaryAsset>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS:
      getOwnedThreats().clear();
      return;
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS:
      getOwnedCybersecurityPkgs().clear();
      return;
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS:
      getOwnedPrimaryAssets().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS:
      return !getOwnedThreats().isEmpty();
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS:
      return !getOwnedCybersecurityPkgs().isEmpty();
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS:
      return !getOwnedPrimaryAssets().isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // CybersecurityPkgImpl