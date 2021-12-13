/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enterprise Primary Asset</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset#getPrimaryAssets <em>Primary Assets</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getEnterprisePrimaryAsset()
 * @model
 * @generated
 */

public interface EnterprisePrimaryAsset extends PrimaryAsset {

  /**
   * Returns the value of the '<em><b>Primary Assets</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.PrimaryAsset}.
  
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Assets</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getEnterprisePrimaryAsset_PrimaryAssets()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  EList<PrimaryAsset> getPrimaryAssets();

} // EnterprisePrimaryAsset
