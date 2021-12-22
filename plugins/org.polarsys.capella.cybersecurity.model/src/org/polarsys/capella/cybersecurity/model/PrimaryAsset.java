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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Primary Asset</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedMembers <em>Owned Members</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getRealizedPrimaryAssets <em>Realized Primary Assets</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getRealizingPrimaryAssets <em>Realizing Primary Assets</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAsset()
 * @model abstract="true"
 * @generated
 */

public interface PrimaryAsset extends NamedElement {

  /**
   * Returns the value of the '<em><b>Owned Members</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Members</em>' containment reference list isn't clear, there really should be more
   * of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Members</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAsset_OwnedMembers()
   * @model containment="true"
   * @generated
   */

  EList<PrimaryAssetMember> getOwnedMembers();

  /**
   * Returns the value of the '<em><b>Realized Primary Assets</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.PrimaryAsset}.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realized Primary Assets</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAsset_RealizedPrimaryAssets()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived"
   *        annotation="http://www.polarsys.org/capella/semantic"
   * @generated
   */

  EList<PrimaryAsset> getRealizedPrimaryAssets();

  /**
   * Returns the value of the '<em><b>Realizing Primary Assets</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.PrimaryAsset}.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realizing Primary Assets</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAsset_RealizingPrimaryAssets()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived"
   *        annotation="http://www.polarsys.org/capella/semantic"
   * @generated
   */

  EList<PrimaryAsset> getRealizingPrimaryAssets();

} // PrimaryAsset
