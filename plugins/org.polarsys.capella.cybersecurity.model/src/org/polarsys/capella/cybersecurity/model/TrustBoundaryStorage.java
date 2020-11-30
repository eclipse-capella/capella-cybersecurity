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
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Trust Boundary Storage</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isThreatSource <em>Threat Source</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getThreatSourceProfile <em>Threat Source Profile</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isTrusted <em>Trusted</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getRationale <em>Rationale</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getTrustBoundaryStorage()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement=' http://www.polarsys.org/capella/core/cs/5.0.0#//Component'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//Component\r\n'"
 * @generated
 */

public interface TrustBoundaryStorage extends ModelElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Threat Source</b></em>' attribute.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Threat Source</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threat Source</em>' attribute.
   * @see #setThreatSource(boolean)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getTrustBoundaryStorage_ThreatSource()
   * @model
   * @generated
   */

  boolean isThreatSource();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isThreatSource <em>Threat Source</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Threat Source</em>' attribute.
   * @see #isThreatSource()
   * @generated
   */

  void setThreatSource(boolean value);

  /**
   * Returns the value of the '<em><b>Threat Source Profile</b></em>' attribute.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Threat Source Profile</em>' attribute isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threat Source Profile</em>' attribute.
   * @see #setThreatSourceProfile(int)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getTrustBoundaryStorage_ThreatSourceProfile()
   * @model
   * @generated
   */

  int getThreatSourceProfile();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getThreatSourceProfile <em>Threat Source Profile</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Threat Source Profile</em>' attribute.
   * @see #getThreatSourceProfile()
   * @generated
   */

  void setThreatSourceProfile(int value);

  /**
   * Returns the value of the '<em><b>Trusted</b></em>' attribute.
   * The default value is <code>"true"</code>.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trusted</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trusted</em>' attribute.
   * @see #setTrusted(boolean)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getTrustBoundaryStorage_Trusted()
   * @model default="true"
   * @generated
   */

  boolean isTrusted();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isTrusted <em>Trusted</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Trusted</em>' attribute.
   * @see #isTrusted()
   * @generated
   */

  void setTrusted(boolean value);

  /**
   * Returns the value of the '<em><b>Rationale</b></em>' attribute.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rationale</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rationale</em>' attribute.
   * @see #setRationale(String)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getTrustBoundaryStorage_Rationale()
   * @model
   * @generated
   */

  String getRationale();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getRationale <em>Rationale</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Rationale</em>' attribute.
   * @see #getRationale()
   * @generated
   */

  void setRationale(String value);

} // TrustBoundaryStorage
