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

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.interaction.AbstractCapability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Threat</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.Threat#getAddressedBy <em>Addressed By</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.Threat#getKind <em>Kind</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.Threat#getLevel <em>Level</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.Threat#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.Threat#getRealizedThreats <em>Realized Threats</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.Threat#getRealizingThreats <em>Realizing Threats</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat()
 * @model
 * @generated
 */

public interface Threat extends AbstractCapability {

  /**
   * Returns the value of the '<em><b>Addressed By</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.core.data.cs.Component}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Addressed By</em>' reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Addressed By</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat_AddressedBy()
   * @model
   * @generated
   */

  EList<Component> getAddressedBy();

  /**
   * Returns the value of the '<em><b>Kind</b></em>' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' reference.
   * @see #setKind(EnumerationPropertyLiteral)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat_Kind()
   * @model
   * @generated
   */

  EnumerationPropertyLiteral getKind();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.Threat#getKind <em>Kind</em>}' reference.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' reference.
   * @see #getKind()
   * @generated
   */

  void setKind(EnumerationPropertyLiteral value);

  /**
   * Returns the value of the '<em><b>Level</b></em>' attribute.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Level</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level</em>' attribute.
   * @see #setLevel(int)
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat_Level()
   * @model
   * @generated
   */

  int getLevel();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.Threat#getLevel <em>Level</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Level</em>' attribute.
   * @see #getLevel()
   * @generated
   */

  void setLevel(int value);

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
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat_Rationale()
   * @model
   * @generated
   */

  String getRationale();

  /**
   * Sets the value of the '{@link org.polarsys.capella.cybersecurity.model.Threat#getRationale <em>Rationale</em>}' attribute.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Rationale</em>' attribute.
   * @see #getRationale()
   * @generated
   */

  void setRationale(String value);

  /**
   * Returns the value of the '<em><b>Realized Threats</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.Threat}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.cybersecurity.model.Threat#getRealizingThreats <em>Realizing Threats</em>}'.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realized Threats</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat_RealizedThreats()
   * @see org.polarsys.capella.cybersecurity.model.Threat#getRealizingThreats
   * @model opposite="realizingThreats" transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived viatra.variant='patternbody' viatra.expression='Threat.outgoingTraces(self, acr);\nAbstractCapabilityRealization.realizedCapability(acr, target);'"
   *        annotation="http://www.polarsys.org/capella/semantic"
   *        annotation="http://www.polarsys.org/capella/MNoE/CapellaLike/Mapping UML/SysML\040semantic\040equivalences='keyword::none' explanation='Derived and transient' constraints='none'"
   * @generated
   */

  EList<Threat> getRealizedThreats();

  /**
   * Returns the value of the '<em><b>Realizing Threats</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.Threat}.
   * It is bidirectional and its opposite is '{@link org.polarsys.capella.cybersecurity.model.Threat#getRealizedThreats <em>Realized Threats</em>}'.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realizing Threats</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreat_RealizingThreats()
   * @see org.polarsys.capella.cybersecurity.model.Threat#getRealizedThreats
   * @model opposite="realizedThreats" transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived viatra.variant='patternbody' viatra.expression='Threat.incomingTraces(self, acr);\nAbstractCapabilityRealization.realizingCapability(acr, target);'"
   *        annotation="http://www.polarsys.org/capella/semantic excludefrom='xmlpivot'"
   *        annotation="http://www.polarsys.org/capella/MNoE/CapellaLike/Mapping UML/SysML\040semantic\040equivalences='keyword::none' explanation='Derived and transient' constraints='none'"
   * @generated
   */

  EList<Threat> getRealizingThreats();

} // Threat
