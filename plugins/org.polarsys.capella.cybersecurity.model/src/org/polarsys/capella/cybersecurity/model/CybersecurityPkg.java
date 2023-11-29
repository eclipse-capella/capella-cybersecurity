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
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pkg</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedThreats <em>Owned Threats</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedPrimaryAssets <em>Owned Primary Assets</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedCybersecurityPkgs <em>Owned Cybersecurity Pkgs</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityPkg()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement=' http://www.polarsys.org/capella/core/cs/7.0.0#//BlockArchitecture'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//BlockArchitecture'"
 * @generated
 */

public interface CybersecurityPkg extends NamedElement, ElementExtension {

  /**
   * Returns the value of the '<em><b>Owned Threats</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.Threat}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Threats</em>' containment reference list isn't clear, there really should be more
   * of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Threats</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityPkg_OwnedThreats()
   * @model containment="true"
   * @generated
   */

  EList<Threat> getOwnedThreats();

  /**
   * Returns the value of the '<em><b>Owned Cybersecurity Pkgs</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Cybersecurity Pkgs</em>' containment reference list isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Cybersecurity Pkgs</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityPkg_OwnedCybersecurityPkgs()
   * @model containment="true"
   * @generated
   */

  EList<CybersecurityPkg> getOwnedCybersecurityPkgs();

  /**
   * Returns the value of the '<em><b>Owned Primary Assets</b></em>' containment reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.PrimaryAsset}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Primary Assets</em>' containment reference list isn't clear, there really should
   * be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Primary Assets</em>' containment reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getCybersecurityPkg_OwnedPrimaryAssets()
   * @model containment="true"
   * @generated
   */

  EList<PrimaryAsset> getOwnedPrimaryAssets();

} // CybersecurityPkg
