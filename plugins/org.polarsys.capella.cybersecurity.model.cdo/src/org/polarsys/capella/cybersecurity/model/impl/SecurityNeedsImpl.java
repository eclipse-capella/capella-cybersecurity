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

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetConfidentialityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setConfidentialityValue(EnumerationPropertyLiteral newConfidentialityValue) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, newConfidentialityValue);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getIntegrityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetIntegrityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setIntegrityValue(EnumerationPropertyLiteral newIntegrityValue) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE, newIntegrityValue);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getAvailabilityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetAvailabilityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setAvailabilityValue(EnumerationPropertyLiteral newAvailabilityValue) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE, newAvailabilityValue);

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getTraceabilityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetTraceabilityValue() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setTraceabilityValue(EnumerationPropertyLiteral newTraceabilityValue) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE, newTraceabilityValue);

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
      return basicGetConfidentialityValue() != null;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY_VALUE:
      return basicGetIntegrityValue() != null;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY_VALUE:
      return basicGetAvailabilityValue() != null;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY_VALUE:
      return basicGetTraceabilityValue() != null;
    }
    return super.eIsSet(featureID);
  }

} // SecurityNeedsImpl