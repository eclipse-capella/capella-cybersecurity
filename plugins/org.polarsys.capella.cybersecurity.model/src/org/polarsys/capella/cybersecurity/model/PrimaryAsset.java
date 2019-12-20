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
import org.polarsys.capella.core.data.capellacore.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Primary Asset</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedThreatApplications <em>Owned Threat Applications</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedMembers <em>Owned Members</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAsset()
 * @model abstract="true"
 * @generated
 */

public interface PrimaryAsset extends NamedElement {

  /**
   * Returns the value of the '<em><b>Owned Threat Applications</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.ThreatApplication}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Threat Applications</em>' containment reference list isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Threat Applications</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getPrimaryAsset_OwnedThreatApplications()
   * @model containment="true"
   * @generated
   */

  EList<ThreatApplication> getOwnedThreatApplications();

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

} // PrimaryAsset
