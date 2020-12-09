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

package org.polarsys.capella.cybersecurity.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.capella.common.data.modellingcore.impl.ModelElementImpl;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Security Needs</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getAvailability <em>Availability</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getTraceability <em>Traceability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecurityNeedsImpl extends ModelElementImpl implements SecurityNeeds {

  /**
   * The cached value of the '{@link #getConfidentiality() <em>Confidentiality</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfidentiality()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral confidentiality;

  /**
   * The cached value of the '{@link #getIntegrity() <em>Integrity</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getIntegrity()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral integrity;

  /**
   * The cached value of the '{@link #getAvailability() <em>Availability</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getAvailability()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral availability;

  /**
   * The cached value of the '{@link #getTraceability() <em>Traceability</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getTraceability()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral traceability;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SecurityNeedsImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.SECURITY_NEEDS;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getConfidentiality() {

    if (confidentiality != null && confidentiality.eIsProxy()) {
      InternalEObject oldConfidentiality = (InternalEObject) confidentiality;
      confidentiality = (EnumerationPropertyLiteral) eResolveProxy(oldConfidentiality);
      if (confidentiality != oldConfidentiality) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY, oldConfidentiality, confidentiality));
      }
    }
    return confidentiality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetConfidentiality() {

    return confidentiality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setConfidentiality(EnumerationPropertyLiteral newConfidentiality) {

    EnumerationPropertyLiteral oldConfidentiality = confidentiality;
    confidentiality = newConfidentiality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
          oldConfidentiality, confidentiality));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getIntegrity() {

    if (integrity != null && integrity.eIsProxy()) {
      InternalEObject oldIntegrity = (InternalEObject) integrity;
      integrity = (EnumerationPropertyLiteral) eResolveProxy(oldIntegrity);
      if (integrity != oldIntegrity) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.SECURITY_NEEDS__INTEGRITY,
              oldIntegrity, integrity));
      }
    }
    return integrity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetIntegrity() {

    return integrity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setIntegrity(EnumerationPropertyLiteral newIntegrity) {

    EnumerationPropertyLiteral oldIntegrity = integrity;
    integrity = newIntegrity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__INTEGRITY,
          oldIntegrity, integrity));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getAvailability() {

    if (availability != null && availability.eIsProxy()) {
      InternalEObject oldAvailability = (InternalEObject) availability;
      availability = (EnumerationPropertyLiteral) eResolveProxy(oldAvailability);
      if (availability != oldAvailability) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
              oldAvailability, availability));
      }
    }
    return availability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetAvailability() {

    return availability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setAvailability(EnumerationPropertyLiteral newAvailability) {

    EnumerationPropertyLiteral oldAvailability = availability;
    availability = newAvailability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
          oldAvailability, availability));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getTraceability() {

    if (traceability != null && traceability.eIsProxy()) {
      InternalEObject oldTraceability = (InternalEObject) traceability;
      traceability = (EnumerationPropertyLiteral) eResolveProxy(oldTraceability);
      if (traceability != oldTraceability) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
              oldTraceability, traceability));
      }
    }
    return traceability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetTraceability() {

    return traceability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setTraceability(EnumerationPropertyLiteral newTraceability) {

    EnumerationPropertyLiteral oldTraceability = traceability;
    traceability = newTraceability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
          oldTraceability, traceability));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      if (resolve)
        return getConfidentiality();
      return basicGetConfidentiality();
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      if (resolve)
        return getIntegrity();
      return basicGetIntegrity();
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      if (resolve)
        return getAvailability();
      return basicGetAvailability();
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      if (resolve)
        return getTraceability();
      return basicGetTraceability();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      setConfidentiality((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      setIntegrity((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      setAvailability((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      setTraceability((EnumerationPropertyLiteral) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      setConfidentiality((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      setIntegrity((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      setAvailability((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      setTraceability((EnumerationPropertyLiteral) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      return confidentiality != null;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      return integrity != null;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      return availability != null;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      return traceability != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (confidentiality: "); //$NON-NLS-1$
    result.append(confidentiality);
    result.append(", integrity: "); //$NON-NLS-1$
    result.append(integrity);
    result.append(", availability: "); //$NON-NLS-1$
    result.append(availability);
    result.append(", traceability: "); //$NON-NLS-1$
    result.append(traceability);
    result.append(')');
    return result.toString();
  }

} // SecurityNeedsImpl