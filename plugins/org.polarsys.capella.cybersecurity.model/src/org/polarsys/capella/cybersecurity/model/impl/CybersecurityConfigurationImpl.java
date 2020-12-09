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
   * The cached value of the '{@link #getConfidentiality() <em>Confidentiality</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfidentiality()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyType confidentiality;
  /**
   * The cached value of the '{@link #getIntegrity() <em>Integrity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegrity()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyType integrity;
  /**
   * The cached value of the '{@link #getTraceability() <em>Traceability</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceability()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyType traceability;
  /**
   * The cached value of the '{@link #getAvailability() <em>Availability</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAvailability()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyType availability;
  /**
   * The cached value of the '{@link #getThreatKind() <em>Threat Kind</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThreatKind()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyType threatKind;

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

    if (confidentiality != null && confidentiality.eIsProxy()) {
      InternalEObject oldConfidentiality = (InternalEObject) confidentiality;
      confidentiality = (EnumerationPropertyType) eResolveProxy(oldConfidentiality);
      if (confidentiality != oldConfidentiality) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY, oldConfidentiality, confidentiality));
      }
    }
    return confidentiality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetConfidentiality() {

    return confidentiality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setConfidentiality(EnumerationPropertyType newConfidentiality) {

    EnumerationPropertyType oldConfidentiality = confidentiality;
    confidentiality = newConfidentiality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          CybersecurityPackage.CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY, oldConfidentiality, confidentiality));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getIntegrity() {

    if (integrity != null && integrity.eIsProxy()) {
      InternalEObject oldIntegrity = (InternalEObject) integrity;
      integrity = (EnumerationPropertyType) eResolveProxy(oldIntegrity);
      if (integrity != oldIntegrity) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY, oldIntegrity, integrity));
      }
    }
    return integrity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetIntegrity() {

    return integrity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setIntegrity(EnumerationPropertyType newIntegrity) {

    EnumerationPropertyType oldIntegrity = integrity;
    integrity = newIntegrity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY,
          oldIntegrity, integrity));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getTraceability() {

    if (traceability != null && traceability.eIsProxy()) {
      InternalEObject oldTraceability = (InternalEObject) traceability;
      traceability = (EnumerationPropertyType) eResolveProxy(oldTraceability);
      if (traceability != oldTraceability) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY, oldTraceability, traceability));
      }
    }
    return traceability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetTraceability() {

    return traceability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setTraceability(EnumerationPropertyType newTraceability) {

    EnumerationPropertyType oldTraceability = traceability;
    traceability = newTraceability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY, oldTraceability, traceability));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getAvailability() {

    if (availability != null && availability.eIsProxy()) {
      InternalEObject oldAvailability = (InternalEObject) availability;
      availability = (EnumerationPropertyType) eResolveProxy(oldAvailability);
      if (availability != oldAvailability) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY, oldAvailability, availability));
      }
    }
    return availability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetAvailability() {

    return availability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setAvailability(EnumerationPropertyType newAvailability) {

    EnumerationPropertyType oldAvailability = availability;
    availability = newAvailability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY, oldAvailability, availability));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyType getThreatKind() {

    if (threatKind != null && threatKind.eIsProxy()) {
      InternalEObject oldThreatKind = (InternalEObject) threatKind;
      threatKind = (EnumerationPropertyType) eResolveProxy(oldThreatKind);
      if (threatKind != oldThreatKind) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND, oldThreatKind, threatKind));
      }
    }
    return threatKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyType basicGetThreatKind() {

    return threatKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setThreatKind(EnumerationPropertyType newThreatKind) {

    EnumerationPropertyType oldThreatKind = threatKind;
    threatKind = newThreatKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND, oldThreatKind, threatKind));

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
      return confidentiality != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__INTEGRITY:
      return integrity != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__TRACEABILITY:
      return traceability != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__AVAILABILITY:
      return availability != null;
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION__THREAT_KIND:
      return threatKind != null;
    }
    return super.eIsSet(featureID);
  }

} //CybersecurityConfigurationImpl