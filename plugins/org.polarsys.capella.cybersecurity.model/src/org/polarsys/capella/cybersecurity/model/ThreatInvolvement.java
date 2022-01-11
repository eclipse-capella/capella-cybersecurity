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
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Threat Involvement</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getActor <em>Actor</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getThreatObj <em>Threat</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatInvolvement()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='
 *        http://www.polarsys.org/capella/core/cs/5.0.0#//Component'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping='
 *        platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//AbstractActor'"
 * @generated
 */

public interface ThreatInvolvement extends Relationship, ElementExtension {

  /**
   * Returns the value of the '<em><b>Threat Obj</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threat Obj</em>' reference.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatInvolvement_ThreatObj()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  Threat getThreatObj();

  /**
   * Returns the value of the '<em><b>Component</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component</em>' reference.
   * @see #setComponent(Component)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatInvolvement_Component()
   * @model
   * @generated
   */
  Component getComponent();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getComponent <em>Component</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' reference.
   * @see #getComponent()
   * @generated
   */

  void setComponent(Component value);

} // ThreatInvolvement
