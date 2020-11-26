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
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Security Needs</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailability <em>Availability</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceability <em>Traceability</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='http://www.polarsys.org/capella/common/behavior/5.0.0#//AbstractEvent http://www.polarsys.org/capella/cybersecurity/1.0#//PrimaryAsset'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.common.data.behavior.gen/model/Behavior.ecore#//AbstractEvent platform:/plugin/org.polarsys.capella.cybersecurity.model/models/Cybersecurity.ecore#//PrimaryAsset'"
 * @generated
 */

public interface SecurityNeeds extends ModelElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Confidentiality</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Confidentiality</em>' attribute isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Confidentiality</em>' reference.
   * @see #setConfidentiality(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Confidentiality()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getConfidentiality();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentiality <em>Confidentiality</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Confidentiality</em>' reference.
   * @see #getConfidentiality()
   * @generated
   */

  void setConfidentiality(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Integrity</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integrity</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integrity</em>' reference.
   * @see #setIntegrity(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Integrity()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getIntegrity();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrity <em>Integrity</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integrity</em>' reference.
   * @see #getIntegrity()
   * @generated
   */

  void setIntegrity(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Availability</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Availability</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Availability</em>' reference.
   * @see #setAvailability(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Availability()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getAvailability();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailability <em>Availability</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Availability</em>' reference.
   * @see #getAvailability()
   * @generated
   */

  void setAvailability(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Traceability</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Traceability</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Traceability</em>' reference.
   * @see #setTraceability(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_Traceability()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getTraceability();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceability <em>Traceability</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Traceability</em>' reference.
   * @see #getTraceability()
   * @generated
   */

  void setTraceability(EnumerationPropertyLiteral value);

} // SecurityNeeds
