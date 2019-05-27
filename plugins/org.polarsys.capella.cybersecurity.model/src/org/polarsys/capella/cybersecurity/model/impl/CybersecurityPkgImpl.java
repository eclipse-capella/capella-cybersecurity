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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
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
   * The cached value of the '{@link #getOwnedThreats() <em>Owned Threats</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOwnedThreats()
   * @generated
   * @ordered
   */
  protected EList<Threat> ownedThreats;

  /**
   * The cached value of the '{@link #getOwnedCybersecurityPkgs() <em>Owned Cybersecurity Pkgs</em>}' containment
   * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOwnedCybersecurityPkgs()
   * @generated
   * @ordered
   */
  protected EList<CybersecurityPkg> ownedCybersecurityPkgs;

  /**
   * The cached value of the '{@link #getOwnedPrimaryAssets() <em>Owned Primary Assets</em>}' containment reference
   * list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOwnedPrimaryAssets()
   * @generated
   * @ordered
   */
  protected EList<PrimaryAsset> ownedPrimaryAssets;

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

  public EList<Threat> getOwnedThreats() {

    if (ownedThreats == null) {
      ownedThreats = new EObjectContainmentEList<Threat>(Threat.class, this,
          CybersecurityPackage.CYBERSECURITY_PKG__OWNED_THREATS);
    }
    return ownedThreats;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public EList<CybersecurityPkg> getOwnedCybersecurityPkgs() {

    if (ownedCybersecurityPkgs == null) {
      ownedCybersecurityPkgs = new EObjectContainmentEList<CybersecurityPkg>(CybersecurityPkg.class, this,
          CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS);
    }
    return ownedCybersecurityPkgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public EList<PrimaryAsset> getOwnedPrimaryAssets() {

    if (ownedPrimaryAssets == null) {
      ownedPrimaryAssets = new EObjectContainmentEList<PrimaryAsset>(PrimaryAsset.class, this,
          CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS);
    }
    return ownedPrimaryAssets;
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
      return ownedThreats != null && !ownedThreats.isEmpty();
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS:
      return ownedCybersecurityPkgs != null && !ownedCybersecurityPkgs.isEmpty();
    case CybersecurityPackage.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS:
      return ownedPrimaryAssets != null && !ownedPrimaryAssets.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // CybersecurityPkgImpl