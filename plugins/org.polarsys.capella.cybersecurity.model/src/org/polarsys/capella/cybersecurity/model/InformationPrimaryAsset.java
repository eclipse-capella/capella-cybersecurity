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

package org.polarsys.capella.cybersecurity.model;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.core.data.information.ExchangeItem;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Information Primary Asset</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset#getExchangeItems <em>Exchange
 * Items</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getInformationPrimaryAsset()
 * @model
 * @generated
 */

public interface InformationPrimaryAsset extends PrimaryAsset {

  /**
   * Returns the value of the '<em><b>Exchange Items</b></em>' reference list. The list contents are of type
   * {@link org.polarsys.capella.core.data.information.ExchangeItem}.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exchange Items</em>' reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Exchange Items</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getInformationPrimaryAsset_ExchangeItems()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  EList<ExchangeItem> getExchangeItems();

} // InformationPrimaryAsset
