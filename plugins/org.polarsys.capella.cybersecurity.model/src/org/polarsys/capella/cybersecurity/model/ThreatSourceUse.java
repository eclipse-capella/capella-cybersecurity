/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.model;

import org.polarsys.capella.core.data.capellacore.Relationship;

import org.polarsys.capella.core.data.cs.Component;

import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Threat Source Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getThreatSource <em>Threat Source</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getUsed <em>Used</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatSourceUse()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement=' http://www.polarsys.org/capella/core/cs/5.0.0#//Component'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//AbstractActor'"
 * @generated
 */

public interface ThreatSourceUse extends Relationship, ElementExtension {

  /**
   * Returns the value of the '<em><b>Threat Source</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threat Source</em>' reference.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatSourceUse_ThreatSource()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  Component getThreatSource();

  /**
   * Returns the value of the '<em><b>Used</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Used</em>' reference.
   * @see #setUsed(Component)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatSourceUse_Used()
   * @model
   * @generated
   */

  Component getUsed();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getUsed <em>Used</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Used</em>' reference.
   * @see #getUsed()
   * @generated
   */

  void setUsed(Component value);

} // ThreatSourceUse
