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

import org.polarsys.capella.core.data.capellacore.Relationship;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Threat Application</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatApplication#getThreatObj <em>Threat</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatApplication#getAsset <em>Asset</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatApplication()
 * @model
 * @generated
 */

public interface ThreatApplication extends Relationship, ElementExtension {

  /**
   * Returns the value of the '<em><b>Asset</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asset</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asset</em>' reference.
   * @see #setAsset(PrimaryAsset)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatApplication_Asset()
   * @model
   * @generated
   */

  PrimaryAsset getAsset();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.ThreatApplication#getAsset <em>Asset</em>}' reference.
  
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Asset</em>' reference.
   * @see #getAsset()
   * @generated
   */

  void setAsset(PrimaryAsset value);

  /**
   * Returns the value of the '<em><b>Threat Obj</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threat Obj</em>' reference.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatApplication_ThreatObj()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  Threat getThreatObj();

} // ThreatApplication
