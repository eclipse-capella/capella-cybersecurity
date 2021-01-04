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

package org.polarsys.capella.cybersecurity.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primary Asset</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getOwnedThreatApplications <em>Owned Threat Applications</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getOwnedMembers <em>Owned Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PrimaryAssetImpl extends NamedElementImpl implements PrimaryAsset {

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryAssetImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.PRIMARY_ASSET;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @SuppressWarnings("unchecked")
  @Override
  public EList<ThreatApplication> getOwnedThreatApplications() {

    return (EList<ThreatApplication>) eDynamicGet(CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS,
        CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @SuppressWarnings("unchecked")
  @Override
  public EList<PrimaryAssetMember> getOwnedMembers() {

    return (EList<PrimaryAssetMember>) eDynamicGet(CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS,
        CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      return ((InternalEList<?>) getOwnedThreatApplications()).basicRemove(otherEnd, msgs);
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return ((InternalEList<?>) getOwnedMembers()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      return getOwnedThreatApplications();
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return getOwnedMembers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      getOwnedThreatApplications().clear();
      getOwnedThreatApplications().addAll((Collection<? extends ThreatApplication>) newValue);
      return;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      getOwnedMembers().clear();
      getOwnedMembers().addAll((Collection<? extends PrimaryAssetMember>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      getOwnedThreatApplications().clear();
      return;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      getOwnedMembers().clear();
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
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      return !getOwnedThreatApplications().isEmpty();
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return !getOwnedMembers().isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // PrimaryAssetImpl