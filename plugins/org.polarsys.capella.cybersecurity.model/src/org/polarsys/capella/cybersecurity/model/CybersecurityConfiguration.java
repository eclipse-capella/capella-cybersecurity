/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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

import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellacore.NamedElement;

import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getTraceability <em>Traceability</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getAvailability <em>Availability</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getThreatKind <em>Threat Kind</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityConfiguration()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='http://www.polarsys.org/capella/core/modeller/7.0.0#//Project'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//BlockArchitecture'"
 * @generated
 */

public interface CybersecurityConfiguration extends NamedElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Confidentiality</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Confidentiality</em>' reference.
   * @see #setConfidentiality(EnumerationPropertyType)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityConfiguration_Confidentiality()
   * @model
   * @generated
   */

  EnumerationPropertyType getConfidentiality();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getConfidentiality <em>Confidentiality</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Confidentiality</em>' reference.
   * @see #getConfidentiality()
   * @generated
   */

  void setConfidentiality(EnumerationPropertyType value);

  /**
   * Returns the value of the '<em><b>Integrity</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integrity</em>' reference.
   * @see #setIntegrity(EnumerationPropertyType)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityConfiguration_Integrity()
   * @model
   * @generated
   */

  EnumerationPropertyType getIntegrity();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getIntegrity <em>Integrity</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integrity</em>' reference.
   * @see #getIntegrity()
   * @generated
   */

  void setIntegrity(EnumerationPropertyType value);

  /**
   * Returns the value of the '<em><b>Traceability</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Traceability</em>' reference.
   * @see #setTraceability(EnumerationPropertyType)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityConfiguration_Traceability()
   * @model
   * @generated
   */

  EnumerationPropertyType getTraceability();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getTraceability <em>Traceability</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Traceability</em>' reference.
   * @see #getTraceability()
   * @generated
   */

  void setTraceability(EnumerationPropertyType value);

  /**
   * Returns the value of the '<em><b>Availability</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Availability</em>' reference.
   * @see #setAvailability(EnumerationPropertyType)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityConfiguration_Availability()
   * @model
   * @generated
   */

  EnumerationPropertyType getAvailability();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getAvailability <em>Availability</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Availability</em>' reference.
   * @see #getAvailability()
   * @generated
   */

  void setAvailability(EnumerationPropertyType value);

  /**
   * Returns the value of the '<em><b>Threat Kind</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threat Kind</em>' reference.
   * @see #setThreatKind(EnumerationPropertyType)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityConfiguration_ThreatKind()
   * @model
   * @generated
   */

  EnumerationPropertyType getThreatKind();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getThreatKind <em>Threat Kind</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Threat Kind</em>' reference.
   * @see #getThreatKind()
   * @generated
   */

  void setThreatKind(EnumerationPropertyType value);

} // CybersecurityConfiguration
