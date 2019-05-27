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
import org.polarsys.capella.core.data.cs.AbstractActor;
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
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getThreat <em>Threat</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatInvolvement()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='
 *        http://www.polarsys.org/capella/core/cs/1.4.0#//AbstractActor'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping='
 *        platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//AbstractActor'"
 * @generated
 */

public interface ThreatInvolvement extends ModelElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Actor</b></em>' reference.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Actor</em>' reference.
   * @see #setActor(AbstractActor)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatInvolvement_Actor()
   * @model
   * @generated
   */

  AbstractActor getActor();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getActor <em>Actor</em>}'
   * reference.
   * 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Actor</em>' reference.
   * @see #getActor()
   * @generated
   */

  void setActor(AbstractActor value);

  /**
   * Returns the value of the '<em><b>Threat</b></em>' reference.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Threat</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Threat</em>' reference.
   * @see #setThreat(Threat)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatInvolvement_Threat()
   * @model
   * @generated
   */

  Threat getThreat();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getThreat
   * <em>Threat</em>}' reference.
   * 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Threat</em>' reference.
   * @see #getThreat()
   * @generated
   */

  void setThreat(Threat value);

} // ThreatInvolvement
