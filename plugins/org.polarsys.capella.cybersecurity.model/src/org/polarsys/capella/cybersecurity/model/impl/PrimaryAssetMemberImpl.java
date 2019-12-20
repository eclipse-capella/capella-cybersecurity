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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellacore.impl.RelationshipImpl;
import org.polarsys.capella.common.data.modellingcore.impl.ModelElementImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primary Asset Member</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetMemberImpl#getAsset <em>Asset</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetMemberImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimaryAssetMemberImpl extends RelationshipImpl implements PrimaryAssetMember {

  /**
   * The cached value of the '{@link #getMember() <em>Member</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getMember()
   * @generated
   * @ordered
   */
  protected ModelElement member;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryAssetMemberImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public PrimaryAsset getAsset() {

    PrimaryAsset asset = basicGetAsset();
    return asset != null && asset.eIsProxy() ? (PrimaryAsset) eResolveProxy((InternalEObject) asset) : asset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  public PrimaryAsset basicGetAsset() {

    EObject container = eContainer();
    if (container instanceof PrimaryAsset) {
      return (PrimaryAsset) container;
    }
    return null;

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public ModelElement getMember() {

    if (member != null && member.eIsProxy()) {
      InternalEObject oldMember = (InternalEObject) member;
      member = (ModelElement) eResolveProxy(oldMember);
      if (member != oldMember) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.PRIMARY_ASSET_MEMBER__MEMBER,
              oldMember, member));
      }
    }
    return member;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  public ModelElement basicGetMember() {

    return member;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setMember(ModelElement newMember) {

    ModelElement oldMember = member;
    member = newMember;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.PRIMARY_ASSET_MEMBER__MEMBER,
          oldMember, member));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER__ASSET:
      if (resolve)
        return getAsset();
      return basicGetAsset();
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER__MEMBER:
      if (resolve)
        return getMember();
      return basicGetMember();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER__MEMBER:
      setMember((ModelElement) newValue);
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
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER__MEMBER:
      setMember((ModelElement) null);
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
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER__ASSET:
      return basicGetAsset() != null;
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER__MEMBER:
      return member != null;
    }
    return super.eIsSet(featureID);
  }

} // PrimaryAssetMemberImpl