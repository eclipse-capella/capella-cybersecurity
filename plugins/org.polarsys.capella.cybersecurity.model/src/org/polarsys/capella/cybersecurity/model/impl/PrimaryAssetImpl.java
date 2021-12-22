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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.common.model.helpers.IHelper;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primary Asset</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getOwnedMembers <em>Owned Members</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getRealizedPrimaryAssets <em>Realized Primary Assets</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getRealizingPrimaryAssets <em>Realizing Primary Assets</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PrimaryAssetImpl extends NamedElementImpl implements PrimaryAsset {

  /**
   * The cached value of the '{@link #getOwnedMembers() <em>Owned Members</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedMembers()
   * @generated
   * @ordered
   */
  protected EList<PrimaryAssetMember> ownedMembers;

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
  public EList<PrimaryAssetMember> getOwnedMembers() {

    if (ownedMembers == null) {
      ownedMembers = new EObjectContainmentEList<PrimaryAssetMember>(PrimaryAssetMember.class, this,
          CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS);
    }
    return ownedMembers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */

  @Override
  public EList<PrimaryAsset> getRealizedPrimaryAssets() {
    Object result = null;
    // Helper that can get value for current feature.
    IHelper helper = null;
    // If current object is adaptable, ask it to get its IHelper.
    if (this instanceof IAdaptable) {
      helper = (IHelper) ((IAdaptable) this).getAdapter(IHelper.class);
    }
    if (null == helper) {
      // No helper found yet.
      // Ask the platform to get the adapter 'IHelper.class' for current object.
      IAdapterManager adapterManager = Platform.getAdapterManager();
      helper = (IHelper) adapterManager.getAdapter(this, IHelper.class);
    }
    if (null == helper) {
      EPackage package_l = eClass().getEPackage();
      // Get the root package of the owner package.
      EPackage rootPackage = org.polarsys.capella.common.mdsofa.common.helper.EcoreHelper.getRootPackage(package_l);
      throw new org.polarsys.capella.common.model.helpers.HelperNotFoundException(
          "No helper retrieved for nsURI " + rootPackage.getNsURI()); //$NON-NLS-1$
    }
    // A helper is found, let's use it. 
    EAnnotation annotation = CybersecurityPackage.Literals.PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS
        .getEAnnotation(org.polarsys.capella.common.model.helpers.IModelConstants.HELPER_ANNOTATION_SOURCE);
    result = helper.getValue(this, CybersecurityPackage.Literals.PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS, annotation);

    try {
      @SuppressWarnings("unchecked")
      Collection<Component> resultAsList = (Collection<Component>) result;
      return new EcoreEList.UnmodifiableEList<PrimaryAsset>(this,
          CybersecurityPackage.Literals.PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS, resultAsList.size(),
          resultAsList.toArray());
    } catch (ClassCastException exception) {
      exception.printStackTrace();
      return org.eclipse.emf.common.util.ECollections.emptyEList();
    }

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */

  @Override
  public EList<PrimaryAsset> getRealizingPrimaryAssets() {
    Object result = null;
    // Helper that can get value for current feature.
    IHelper helper = null;
    // If current object is adaptable, ask it to get its IHelper.
    if (this instanceof IAdaptable) {
      helper = (IHelper) ((IAdaptable) this).getAdapter(IHelper.class);
    }
    if (null == helper) {
      // No helper found yet.
      // Ask the platform to get the adapter 'IHelper.class' for current object.
      IAdapterManager adapterManager = Platform.getAdapterManager();
      helper = (IHelper) adapterManager.getAdapter(this, IHelper.class);
    }
    if (null == helper) {
      EPackage package_l = eClass().getEPackage();
      // Get the root package of the owner package.
      EPackage rootPackage = org.polarsys.capella.common.mdsofa.common.helper.EcoreHelper.getRootPackage(package_l);
      throw new org.polarsys.capella.common.model.helpers.HelperNotFoundException(
          "No helper retrieved for nsURI " + rootPackage.getNsURI()); //$NON-NLS-1$
    }
    // A helper is found, let's use it. 
    EAnnotation annotation = CybersecurityPackage.Literals.PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS
        .getEAnnotation(org.polarsys.capella.common.model.helpers.IModelConstants.HELPER_ANNOTATION_SOURCE);
    result = helper.getValue(this, CybersecurityPackage.Literals.PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS, annotation);

    try {
      @SuppressWarnings("unchecked")
      Collection<Component> resultAsList = (Collection<Component>) result;
      return new EcoreEList.UnmodifiableEList<PrimaryAsset>(this,
          CybersecurityPackage.Literals.PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS, resultAsList.size(),
          resultAsList.toArray());
    } catch (ClassCastException exception) {
      exception.printStackTrace();
      return org.eclipse.emf.common.util.ECollections.emptyEList();
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
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
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return getOwnedMembers();
    case CybersecurityPackage.PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS:
      return getRealizedPrimaryAssets();
    case CybersecurityPackage.PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS:
      return getRealizingPrimaryAssets();
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
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return ownedMembers != null && !ownedMembers.isEmpty();
    case CybersecurityPackage.PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS:
      return !getRealizedPrimaryAssets().isEmpty();
    case CybersecurityPackage.PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS:
      return !getRealizingPrimaryAssets().isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // PrimaryAssetImpl