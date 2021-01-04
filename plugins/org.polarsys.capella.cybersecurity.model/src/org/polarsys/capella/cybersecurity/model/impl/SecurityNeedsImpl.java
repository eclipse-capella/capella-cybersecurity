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
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getConfidentialityValue <em>Confidentiality Value</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getIntegrityValue <em>Integrity Value</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getAvailabilityValue <em>Availability Value</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getTraceabilityValue <em>Traceability Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecurityNeedsImpl extends ModelElementImpl implements SecurityNeeds {

  /**
   * The cached value of the '{@link #getConfidentialityValue() <em>Confidentiality Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfidentialityValue()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral confidentialityValue;

  /**
   * The cached value of the '{@link #getIntegrityValue() <em>Integrity Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegrityValue()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral integrityValue;

  /**
   * The cached value of the '{@link #getAvailabilityValue() <em>Availability Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAvailabilityValue()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral availabilityValue;

  /**
   * The cached value of the '{@link #getTraceabilityValue() <em>Traceability Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTraceabilityValue()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral traceabilityValue;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getConfidentialityValue() {

    if (confidentialityValue != null && confidentialityValue.eIsProxy()) {
      InternalEObject oldConfidentialityValue = (InternalEObject) confidentialityValue;
      confidentialityValue = (EnumerationPropertyLiteral) eResolveProxy(oldConfidentialityValue);
      if (confidentialityValue != oldConfidentialityValue) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, oldConfidentialityValue,
              confidentialityValue));
      }
    }
    return confidentialityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetConfidentialityValue() {

    return confidentialityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setConfidentialityValue(EnumerationPropertyLiteral newConfidentialityValue) {

    EnumerationPropertyLiteral oldConfidentialityValue = confidentialityValue;
    confidentialityValue = newConfidentialityValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE,
          oldConfidentialityValue, confidentialityValue));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getIntegrityValue() {

    if (integrityValue != null && integrityValue.eIsProxy()) {
      InternalEObject oldIntegrityValue = (InternalEObject) integrityValue;
      integrityValue = (EnumerationPropertyLiteral) eResolveProxy(oldIntegrityValue);
      if (integrityValue != oldIntegrityValue) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE, oldIntegrityValue, integrityValue));
      }
    }
    return integrityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetIntegrityValue() {

    return integrityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setIntegrityValue(EnumerationPropertyLiteral newIntegrityValue) {

    EnumerationPropertyLiteral oldIntegrityValue = integrityValue;
    integrityValue = newIntegrityValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE,
          oldIntegrityValue, integrityValue));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getAvailabilityValue() {

    if (availabilityValue != null && availabilityValue.eIsProxy()) {
      InternalEObject oldAvailabilityValue = (InternalEObject) availabilityValue;
      availabilityValue = (EnumerationPropertyLiteral) eResolveProxy(oldAvailabilityValue);
      if (availabilityValue != oldAvailabilityValue) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE, oldAvailabilityValue, availabilityValue));
      }
    }
    return availabilityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetAvailabilityValue() {

    return availabilityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setAvailabilityValue(EnumerationPropertyLiteral newAvailabilityValue) {

    EnumerationPropertyLiteral oldAvailabilityValue = availabilityValue;
    availabilityValue = newAvailabilityValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE,
          oldAvailabilityValue, availabilityValue));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getTraceabilityValue() {

    if (traceabilityValue != null && traceabilityValue.eIsProxy()) {
      InternalEObject oldTraceabilityValue = (InternalEObject) traceabilityValue;
      traceabilityValue = (EnumerationPropertyLiteral) eResolveProxy(oldTraceabilityValue);
      if (traceabilityValue != oldTraceabilityValue) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE, oldTraceabilityValue, traceabilityValue));
      }
    }
    return traceabilityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetTraceabilityValue() {

    return traceabilityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setTraceabilityValue(EnumerationPropertyLiteral newTraceabilityValue) {

    EnumerationPropertyLiteral oldTraceabilityValue = traceabilityValue;
    traceabilityValue = newTraceabilityValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE,
          oldTraceabilityValue, traceabilityValue));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE:
      if (resolve)
        return getConfidentialityValue();
      return basicGetConfidentialityValue();
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE:
      if (resolve)
        return getIntegrityValue();
      return basicGetIntegrityValue();
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE:
      if (resolve)
        return getAvailabilityValue();
      return basicGetAvailabilityValue();
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE:
      if (resolve)
        return getTraceabilityValue();
      return basicGetTraceabilityValue();
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
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE:
      setConfidentialityValue((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE:
      setIntegrityValue((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE:
      setAvailabilityValue((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE:
      setTraceabilityValue((EnumerationPropertyLiteral) newValue);
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
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE:
      setConfidentialityValue((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE:
      setIntegrityValue((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE:
      setAvailabilityValue((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE:
      setTraceabilityValue((EnumerationPropertyLiteral) null);
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
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE:
      return confidentialityValue != null;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE:
      return integrityValue != null;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE:
      return availabilityValue != null;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE:
      return traceabilityValue != null;
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
    result.append(confidentialityValue);
    result.append(", integrity: "); //$NON-NLS-1$
    result.append(integrityValue);
    result.append(", availability: "); //$NON-NLS-1$
    result.append(availabilityValue);
    result.append(", traceability: "); //$NON-NLS-1$
    result.append(traceabilityValue);
    result.append(')');
    return result.toString();
  }

} // SecurityNeedsImpl