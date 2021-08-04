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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.polarsys.capella.common.model.helpers.IHelper;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Functional Primary Asset</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl#getFunctionalChains <em>Functional Chains</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl#getRealizedPrimaryAssets <em>Realized Primary Assets</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl#getRealizingPrimaryAssets <em>Realizing Primary Assets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionalPrimaryAssetImpl extends PrimaryAssetImpl implements FunctionalPrimaryAsset {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FunctionalPrimaryAssetImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  public EList<AbstractFunction> getFunctions() {
    Collection<AbstractFunction> result = new ArrayList<>();
    for (PrimaryAssetMember pam : getOwnedMembers()) {
      if (pam.getMember() instanceof AbstractFunction) {
        result.add((AbstractFunction) pam.getMember());
      }
    }
    Object[] data = result.toArray();
    return new EcoreEList.UnmodifiableEList<AbstractFunction>(this,
        CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS, data.length, data);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  @Override
  public EList<FunctionalChain> getFunctionalChains() {
    Collection<FunctionalChain> result = new ArrayList<>();
    for (PrimaryAssetMember pam : getOwnedMembers()) {
      if (pam.getMember() instanceof FunctionalChain) {
        result.add((FunctionalChain) pam.getMember());
      }
    }
    Object[] data = result.toArray();
    return new EcoreEList.UnmodifiableEList<FunctionalChain>(this,
        CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS, data.length, data);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */

  @Override
  public EList<FunctionalPrimaryAsset> getRealizedPrimaryAssets() {
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
    EAnnotation annotation = CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS
        .getEAnnotation(org.polarsys.capella.common.model.helpers.IModelConstants.HELPER_ANNOTATION_SOURCE);
    result = helper.getValue(this, CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS, annotation);

    try {
      @SuppressWarnings("unchecked")
      Collection<Component> resultAsList = (Collection<Component>) result;
      return new EcoreEList.UnmodifiableEList<FunctionalPrimaryAsset>(this, CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS,
          resultAsList.size(), resultAsList.toArray());
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
  public EList<FunctionalPrimaryAsset> getRealizingPrimaryAssets() {
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
    EAnnotation annotation = CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS
        .getEAnnotation(org.polarsys.capella.common.model.helpers.IModelConstants.HELPER_ANNOTATION_SOURCE);
    result = helper.getValue(this, CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS, annotation);

    try {
      @SuppressWarnings("unchecked")
      Collection<Component> resultAsList = (Collection<Component>) result;
      return new EcoreEList.UnmodifiableEList<FunctionalPrimaryAsset>(this, CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS,
          resultAsList.size(), resultAsList.toArray());
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
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS:
      return getFunctions();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS:
      return getFunctionalChains();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS:
      return getRealizedPrimaryAssets();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS:
      return getRealizingPrimaryAssets();
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
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS:
      return !getFunctions().isEmpty();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS:
      return !getFunctionalChains().isEmpty();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS:
      return !getRealizedPrimaryAssets().isEmpty();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS:
      return !getRealizingPrimaryAssets().isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // FunctionalPrimaryAssetImpl