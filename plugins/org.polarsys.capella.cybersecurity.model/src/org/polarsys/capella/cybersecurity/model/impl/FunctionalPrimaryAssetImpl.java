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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
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
 * </ul>
 *
 * @generated
 */
public class FunctionalPrimaryAssetImpl extends PrimaryAssetImpl implements FunctionalPrimaryAsset {
  /**
   * The cached value of the '{@link #getFunctionalChains() <em>Functional Chains</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionalChains()
   * @generated
   * @ordered
   */
  protected EList<FunctionalChain> functionalChains;

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
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS:
      getFunctionalChains().clear();
      getFunctionalChains().addAll((Collection<? extends FunctionalChain>) newValue);
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
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS:
      getFunctionalChains().clear();
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
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS:
      return !getFunctions().isEmpty();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS:
      return functionalChains != null && !functionalChains.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // FunctionalPrimaryAssetImpl