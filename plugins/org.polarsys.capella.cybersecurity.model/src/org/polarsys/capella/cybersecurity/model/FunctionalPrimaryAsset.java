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
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalChain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Functional Primary Asset</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctionalChains <em>Functional Chains</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getRealizedPrimaryAssets <em>Realized Primary Assets</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getRealizingPrimaryAssets <em>Realizing Primary Assets</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset()
 * @model
 * @generated
 */

public interface FunctionalPrimaryAsset extends PrimaryAsset {

  /**
   * Returns the value of the '<em><b>Functions</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.core.data.fa.AbstractFunction}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functions</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset_Functions()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  EList<AbstractFunction> getFunctions();

  /**
   * Returns the value of the '<em><b>Functional Chains</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.core.data.fa.FunctionalChain}.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functional Chains</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset_FunctionalChains()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  EList<FunctionalChain> getFunctionalChains();

  /**
   * Returns the value of the '<em><b>Realized Primary Assets</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset}.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realized Primary Assets</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset_RealizedPrimaryAssets()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived"
   *        annotation="http://www.polarsys.org/capella/semantic"
   * @generated
   */

  EList<FunctionalPrimaryAsset> getRealizedPrimaryAssets();

  /**
   * Returns the value of the '<em><b>Realizing Primary Assets</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset}.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realizing Primary Assets</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset_RealizingPrimaryAssets()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived"
   *        annotation="http://www.polarsys.org/capella/semantic"
   * @generated
   */

  EList<FunctionalPrimaryAsset> getRealizingPrimaryAssets();

} // FunctionalPrimaryAsset
