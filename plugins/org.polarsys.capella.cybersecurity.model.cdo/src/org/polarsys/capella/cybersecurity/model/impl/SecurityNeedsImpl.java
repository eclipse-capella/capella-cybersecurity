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

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetConfidentiality() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setConfidentiality(EnumerationPropertyLiteral newConfidentiality) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, newConfidentiality);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getIntegrity() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetIntegrity() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setIntegrity(EnumerationPropertyLiteral newIntegrity) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY, CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY,
        newIntegrity);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getAvailability() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetAvailability() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setAvailability(EnumerationPropertyLiteral newAvailability) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, newAvailability);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getTraceability() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetTraceability() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setTraceability(EnumerationPropertyLiteral newTraceability) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, newTraceability);

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
      return basicGetConfidentiality() != null;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      return basicGetIntegrity() != null;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      return basicGetAvailability() != null;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      return basicGetTraceability() != null;
    }
    return super.eIsSet(featureID);
  }

} // SecurityNeedsImpl