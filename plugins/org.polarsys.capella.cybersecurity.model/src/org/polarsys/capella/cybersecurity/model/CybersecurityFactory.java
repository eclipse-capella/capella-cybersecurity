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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage
 * @generated
 */
public interface CybersecurityFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  CybersecurityFactory eINSTANCE = org.polarsys.capella.cybersecurity.model.impl.CybersecurityFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Pkg</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Pkg</em>'.
   * @generated
   */
  CybersecurityPkg createCybersecurityPkg();

  /**
   * Returns a new object of class '<em>Threat</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Threat</em>'.
   * @generated
   */
  Threat createThreat();

  /**
   * Returns a new object of class '<em>Threat Involvement</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Threat Involvement</em>'.
   * @generated
   */
  ThreatInvolvement createThreatInvolvement();

  /**
   * Returns a new object of class '<em>Function Storage</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Function Storage</em>'.
   * @generated
   */
  FunctionStorage createFunctionStorage();

  /**
   * Returns a new object of class '<em>Threat Application</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Threat Application</em>'.
   * @generated
   */
  ThreatApplication createThreatApplication();

  /**
   * Returns a new object of class '<em>Primary Asset Storage</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Asset Storage</em>'.
   * @generated
   */
  PrimaryAssetStorage createPrimaryAssetStorage();

  /**
   * Returns a new object of class '<em>Security Needs</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Security Needs</em>'.
   * @generated
   */
  SecurityNeeds createSecurityNeeds();

  /**
   * Returns a new object of class '<em>Trust Boundary Storage</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Trust Boundary Storage</em>'.
   * @generated
   */
  TrustBoundaryStorage createTrustBoundaryStorage();

  /**
   * Returns a new object of class '<em>Functional Primary Asset</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Functional Primary Asset</em>'.
   * @generated
   */
  FunctionalPrimaryAsset createFunctionalPrimaryAsset();

  /**
   * Returns a new object of class '<em>Information Primary Asset</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Information Primary Asset</em>'.
   * @generated
   */
  InformationPrimaryAsset createInformationPrimaryAsset();

  /**
   * Returns a new object of class '<em>Primary Asset Member</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Asset Member</em>'.
   * @generated
   */
  PrimaryAssetMember createPrimaryAssetMember();

  /**
   * Returns a new object of class '<em>Configuration</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Configuration</em>'.
   * @generated
   */
  CybersecurityConfiguration createCybersecurityConfiguration();

  /**
   * Returns a new object of class '<em>Enterprise Primary Asset</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Enterprise Primary Asset</em>'.
   * @generated
   */
  EnterprisePrimaryAsset createEnterprisePrimaryAsset();

  /**
   * Returns a new object of class '<em>Threat Source Use</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Threat Source Use</em>'.
   * @generated
   */
  ThreatSourceUse createThreatSourceUse();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CybersecurityPackage getCybersecurityPackage();

} // CybersecurityFactory
