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

import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Security Needs</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentialityValue <em>Confidentiality Value</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrityValue <em>Integrity Value</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailabilityValue <em>Availability Value</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceabilityValue <em>Traceability Value</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='http://www.polarsys.org/capella/common/behavior/5.0.0#//AbstractEvent http://www.polarsys.org/capella/cybersecurity/1.0#//PrimaryAsset'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.common.data.behavior.gen/model/Behavior.ecore#//AbstractEvent platform:/plugin/org.polarsys.capella.cybersecurity.model/models/Cybersecurity.ecore#//PrimaryAsset'"
 * @generated
 */

public interface SecurityNeeds extends NamedElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Confidentiality Value</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Confidentiality Value</em>' reference.
   * @see #setConfidentialityValue(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_ConfidentialityValue()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getConfidentialityValue();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentialityValue <em>Confidentiality Value</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Confidentiality Value</em>' reference.
   * @see #getConfidentialityValue()
   * @generated
   */

  void setConfidentialityValue(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Integrity Value</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integrity Value</em>' reference.
   * @see #setIntegrityValue(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_IntegrityValue()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getIntegrityValue();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrityValue <em>Integrity Value</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integrity Value</em>' reference.
   * @see #getIntegrityValue()
   * @generated
   */

  void setIntegrityValue(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Availability Value</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Availability Value</em>' reference.
   * @see #setAvailabilityValue(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_AvailabilityValue()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getAvailabilityValue();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailabilityValue <em>Availability Value</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Availability Value</em>' reference.
   * @see #getAvailabilityValue()
   * @generated
   */

  void setAvailabilityValue(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Traceability Value</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Traceability Value</em>' reference.
   * @see #setTraceabilityValue(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getSecurityNeeds_TraceabilityValue()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getTraceabilityValue();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceabilityValue <em>Traceability Value</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Traceability Value</em>' reference.
   * @see #getTraceabilityValue()
   * @generated
   */

  void setTraceabilityValue(EnumerationPropertyLiteral value);

} // SecurityNeeds
