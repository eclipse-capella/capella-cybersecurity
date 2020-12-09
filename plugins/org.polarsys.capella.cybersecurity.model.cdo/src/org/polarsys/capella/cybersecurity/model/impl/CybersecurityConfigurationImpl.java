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
package org.polarsys.capella.cybersecurity.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;

import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl#getTraceability <em>Traceability</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl#getAvailability <em>Availability</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl#getThreatKind <em>Threat Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CybersecurityConfigurationImpl extends NamedElementImpl implements CybersecurityConfiguration {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CybersecurityConfigurationImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getConfidentiality() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetConfidentiality() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setConfidentiality(EnumerationPropertyType newConfidentiality) {

    eDynamicSet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY, newConfidentiality);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getIntegrity() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__INTEGRITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetIntegrity() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__INTEGRITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setIntegrity(EnumerationPropertyType newIntegrity) {

    eDynamicSet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__INTEGRITY, newIntegrity);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getTraceability() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__TRACEABILITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetTraceability() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__TRACEABILITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setTraceability(EnumerationPropertyType newTraceability) {

    eDynamicSet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__TRACEABILITY, newTraceability);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getAvailability() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__AVAILABILITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetAvailability() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__AVAILABILITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setAvailability(EnumerationPropertyType newAvailability) {

    eDynamicSet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__AVAILABILITY, newAvailability);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getThreatKind() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__THREAT_KIND, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetThreatKind() {

    return (EnumerationPropertyType) eDynamicGet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__THREAT_KIND, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setThreatKind(EnumerationPropertyType newThreatKind) {

    eDynamicSet(CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND,
        CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION__THREAT_KIND, newThreatKind);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY:
      if (resolve)
        return getConfidentiality();
      return basicGetConfidentiality();
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY:
      if (resolve)
        return getIntegrity();
      return basicGetIntegrity();
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY:
      if (resolve)
        return getTraceability();
      return basicGetTraceability();
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY:
      if (resolve)
        return getAvailability();
      return basicGetAvailability();
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND:
      if (resolve)
        return getThreatKind();
      return basicGetThreatKind();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY:
      setConfidentiality((EnumerationPropertyType) newValue);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY:
      setIntegrity((EnumerationPropertyType) newValue);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY:
      setTraceability((EnumerationPropertyType) newValue);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY:
      setAvailability((EnumerationPropertyType) newValue);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND:
      setThreatKind((EnumerationPropertyType) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY:
      setConfidentiality((EnumerationPropertyType) null);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY:
      setIntegrity((EnumerationPropertyType) null);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY:
      setTraceability((EnumerationPropertyType) null);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY:
      setAvailability((EnumerationPropertyType) null);
      return;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND:
      setThreatKind((EnumerationPropertyType) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY:
      return basicGetConfidentiality() != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY:
      return basicGetIntegrity() != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY:
      return basicGetTraceability() != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY:
      return basicGetAvailability() != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND:
      return basicGetThreatKind() != null;
    }
    return super.eIsSet(featureID);
  }

} //CybersecurityConfigurationImpl