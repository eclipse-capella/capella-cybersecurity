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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.common.data.modellingcore.impl.ModelElementImpl;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Function Storage</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl#getExchangedItems <em>Exchanged
 * Items</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl#isDataStorage <em>Data
 * Storage</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl#isRemanentData <em>Remanent
 * Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionStorageImpl extends NamedElementImpl implements FunctionStorage {

  /**
   * The default value of the '{@link #isDataStorage() <em>Data Storage</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #isDataStorage()
   * @generated
   * @ordered
   */
  protected static final boolean DATA_STORAGE_EDEFAULT = false;

  /**
   * The default value of the '{@link #isRemanentData() <em>Remanent Data</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #isRemanentData()
   * @generated
   * @ordered
   */
  protected static final boolean REMANENT_DATA_EDEFAULT = false;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FunctionStorageImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.FUNCTION_STORAGE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @SuppressWarnings("unchecked")
  @Override
  public EList<ExchangeItem> getExchangedItems() {

    return (EList<ExchangeItem>) eDynamicGet(CybersecurityPackage.FUNCTION_STORAGE__EXCHANGED_ITEMS,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public boolean isDataStorage() {

    return (Boolean) eDynamicGet(CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__DATA_STORAGE, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setDataStorage(boolean newDataStorage) {

    eDynamicSet(CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__DATA_STORAGE, newDataStorage);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public boolean isRemanentData() {

    return (Boolean) eDynamicGet(CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__REMANENT_DATA, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setRemanentData(boolean newRemanentData) {

    eDynamicSet(CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__REMANENT_DATA, newRemanentData);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.FUNCTION_STORAGE__EXCHANGED_ITEMS:
      return getExchangedItems();
    case CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE:
      return isDataStorage();
    case CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA:
      return isRemanentData();
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
    case CybersecurityPackage.FUNCTION_STORAGE__EXCHANGED_ITEMS:
      getExchangedItems().clear();
      getExchangedItems().addAll((Collection<? extends ExchangeItem>) newValue);
      return;
    case CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE:
      setDataStorage((Boolean) newValue);
      return;
    case CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA:
      setRemanentData((Boolean) newValue);
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
    case CybersecurityPackage.FUNCTION_STORAGE__EXCHANGED_ITEMS:
      getExchangedItems().clear();
      return;
    case CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE:
      setDataStorage(DATA_STORAGE_EDEFAULT);
      return;
    case CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA:
      setRemanentData(REMANENT_DATA_EDEFAULT);
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
    case CybersecurityPackage.FUNCTION_STORAGE__EXCHANGED_ITEMS:
      return !getExchangedItems().isEmpty();
    case CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE:
      return isDataStorage() != DATA_STORAGE_EDEFAULT;
    case CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA:
      return isRemanentData() != REMANENT_DATA_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

} // FunctionStorageImpl