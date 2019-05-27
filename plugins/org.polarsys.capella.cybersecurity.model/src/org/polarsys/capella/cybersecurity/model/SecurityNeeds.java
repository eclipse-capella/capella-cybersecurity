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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Security Needs</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentiality <em>Confidentiality</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrity <em>Integrity</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailability <em>Availability</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceability <em>Traceability</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='
 *        http://www.polarsys.org/capella/common/behavior/1.4.0#//AbstractEvent'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping='
 *        platform:/plugin/org.polarsys.capella.common.data.behavior.gen/model/Behavior.ecore#//AbstractEvent'"
 * @generated
 */

public interface SecurityNeeds extends ModelElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Confidentiality</b></em>' attribute.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Confidentiality</em>' attribute isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Confidentiality</em>' attribute.
   * @see #setConfidentiality(int)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Confidentiality()
   * @model
   * @generated
   */

  int getConfidentiality();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentiality
   * <em>Confidentiality</em>}' attribute.
   * 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Confidentiality</em>' attribute.
   * @see #getConfidentiality()
   * @generated
   */

  void setConfidentiality(int value);

  /**
   * Returns the value of the '<em><b>Integrity</b></em>' attribute.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integrity</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Integrity</em>' attribute.
   * @see #setIntegrity(int)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Integrity()
   * @model
   * @generated
   */

  int getIntegrity();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrity
   * <em>Integrity</em>}' attribute.
   * 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Integrity</em>' attribute.
   * @see #getIntegrity()
   * @generated
   */

  void setIntegrity(int value);

  /**
   * Returns the value of the '<em><b>Availability</b></em>' attribute.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Availability</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Availability</em>' attribute.
   * @see #setAvailability(int)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Availability()
   * @model
   * @generated
   */

  int getAvailability();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailability
   * <em>Availability</em>}' attribute.
   * 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Availability</em>' attribute.
   * @see #getAvailability()
   * @generated
   */

  void setAvailability(int value);

  /**
   * Returns the value of the '<em><b>Traceability</b></em>' attribute.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Traceability</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Traceability</em>' attribute.
   * @see #setTraceability(int)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Traceability()
   * @model
   * @generated
   */

  int getTraceability();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceability
   * <em>Traceability</em>}' attribute.
   * 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Traceability</em>' attribute.
   * @see #getTraceability()
   * @generated
   */

  void setTraceability(int value);

} // SecurityNeeds
