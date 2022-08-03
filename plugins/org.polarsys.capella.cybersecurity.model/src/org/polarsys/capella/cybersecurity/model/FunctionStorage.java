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

package org.polarsys.capella.cybersecurity.model;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Function Storage</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#getExchangedItems <em>Exchanged Items</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#isDataStorage <em>Data Storage</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#isRemanentData <em>Remanent Data</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionStorage()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='
 *        http://www.polarsys.org/capella/core/fa/6.0.0#//AbstractFunction'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping='
 *        platform:/plugin/org.polarsys.capella.core.data.gen/model/FunctionalAnalysis.ecore#//AbstractFunction'"
 * @generated
 */

public interface FunctionStorage extends NamedElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Exchanged Items</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.core.data.information.ExchangeItem}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exchanged Items</em>' reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exchanged Items</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionStorage_ExchangedItems()
   * @model
   * @generated
   */

  EList<ExchangeItem> getExchangedItems();

  /**
   * Returns the value of the '<em><b>Data Storage</b></em>' attribute.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Storage</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Storage</em>' attribute.
   * @see #setDataStorage(boolean)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionStorage_DataStorage()
   * @model
   * @generated
   */

  boolean isDataStorage();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#isDataStorage <em>Data Storage</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Storage</em>' attribute.
   * @see #isDataStorage()
   * @generated
   */

  void setDataStorage(boolean value);

  /**
   * Returns the value of the '<em><b>Remanent Data</b></em>' attribute.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Remanent Data</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Remanent Data</em>' attribute.
   * @see #setRemanentData(boolean)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionStorage_RemanentData()
   * @model
   * @generated
   */

  boolean isRemanentData();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#isRemanentData <em>Remanent Data</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Remanent Data</em>' attribute.
   * @see #isRemanentData()
   * @generated
   */

  void setRemanentData(boolean value);

} // FunctionStorage
