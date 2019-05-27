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

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Threat Pkg</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatPkg#getOwnedThreats <em>Owned Threats</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.ThreatPkg#getOwnedThreatPkgs <em>Owned Threat Pkgs</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatPkg()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement='
 *        http://www.polarsys.org/capella/core/cs/1.3.0#//BlockArchitecture'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping='
 *        platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//BlockArchitecture'"
 * @generated
 */

public interface ThreatPkg extends NamedElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Owned Threats</b></em>' containment reference list. The list contents are of type
   * {@link org.polarsys.capella.cybersecurity.model.Threat}.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Threats</em>' containment reference list isn't clear, there really should be more
   * of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Owned Threats</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatPkg_OwnedThreats()
   * @model containment="true"
   * @generated
   */

  EList<Threat> getOwnedThreats();

  /**
   * Returns the value of the '<em><b>Owned Threat Pkgs</b></em>' containment reference list. The list contents are of
   * type {@link org.polarsys.capella.cybersecurity.model.ThreatPkg}.
   * 
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Threat Pkgs</em>' containment reference list isn't clear, there really should be
   * more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Owned Threat Pkgs</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatPkg_OwnedThreatPkgs()
   * @model containment="true"
   * @generated
   */

  EList<ThreatPkg> getOwnedThreatPkgs();

} // ThreatPkg
