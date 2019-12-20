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

import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellacore.Relationship;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Primary Asset Member</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getAsset <em>Asset</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAssetMember()
 * @model
 * @generated
 */

public interface PrimaryAssetMember extends Relationship {

  /**
   * Returns the value of the '<em><b>Asset</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asset</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asset</em>' reference.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAssetMember_Asset()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  PrimaryAsset getAsset();

  /**
   * Returns the value of the '<em><b>Member</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Member</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Member</em>' reference.
   * @see #setMember(ModelElement)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAssetMember_Member()
   * @model
   * @generated
   */

  ModelElement getMember();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getMember <em>Member</em>}' reference.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Member</em>' reference.
   * @see #getMember()
   * @generated
   */

  void setMember(ModelElement value);

} // PrimaryAssetMember
