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
   * The cached value of the '{@link #getExchangedItems() <em>Exchanged Items</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExchangedItems()
   * @generated
   * @ordered
   */
  protected EList<ExchangeItem> exchangedItems;

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
   * The cached value of the '{@link #isDataStorage() <em>Data Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataStorage()
   * @generated
   * @ordered
   */
  protected boolean dataStorage = DATA_STORAGE_EDEFAULT;

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
   * The cached value of the '{@link #isRemanentData() <em>Remanent Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRemanentData()
   * @generated
   * @ordered
   */
  protected boolean remanentData = REMANENT_DATA_EDEFAULT;

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

    if (exchangedItems == null) {
      exchangedItems = new EObjectResolvingEList<ExchangeItem>(ExchangeItem.class, this,
          CybersecurityPackage.FUNCTION_STORAGE__EXCHANGED_ITEMS);
    }
    return exchangedItems;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public boolean isDataStorage() {

    return dataStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setDataStorage(boolean newDataStorage) {

    boolean oldDataStorage = dataStorage;
    dataStorage = newDataStorage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE,
          oldDataStorage, dataStorage));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public boolean isRemanentData() {

    return remanentData;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setRemanentData(boolean newRemanentData) {

    boolean oldRemanentData = remanentData;
    remanentData = newRemanentData;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA,
          oldRemanentData, remanentData));

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
      return exchangedItems != null && !exchangedItems.isEmpty();
    case CybersecurityPackage.FUNCTION_STORAGE__DATA_STORAGE:
      return dataStorage != DATA_STORAGE_EDEFAULT;
    case CybersecurityPackage.FUNCTION_STORAGE__REMANENT_DATA:
      return remanentData != REMANENT_DATA_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (dataStorage: "); //$NON-NLS-1$
    result.append(dataStorage);
    result.append(", remanentData: "); //$NON-NLS-1$
    result.append(remanentData);
    result.append(')');
    return result.toString();
  }

} // FunctionStorageImpl