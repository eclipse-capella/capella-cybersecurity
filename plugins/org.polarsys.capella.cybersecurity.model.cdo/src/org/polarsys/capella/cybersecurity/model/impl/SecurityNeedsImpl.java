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

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.common.data.modellingcore.impl.ModelElementImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Security Needs</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getConfidentiality
 * <em>Confidentiality</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getIntegrity <em>Integrity</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getAvailability
 * <em>Availability</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl#getTraceability
 * <em>Traceability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecurityNeedsImpl extends ModelElementImpl implements SecurityNeeds {

  /**
   * The default value of the '{@link #getConfidentiality() <em>Confidentiality</em>}' attribute. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @see #getConfidentiality()
   * @generated
   * @ordered
   */
  protected static final int CONFIDENTIALITY_EDEFAULT = 0;

  /**
   * The default value of the '{@link #getIntegrity() <em>Integrity</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getIntegrity()
   * @generated
   * @ordered
   */
  protected static final int INTEGRITY_EDEFAULT = 0;

  /**
   * The default value of the '{@link #getAvailability() <em>Availability</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getAvailability()
   * @generated
   * @ordered
   */
  protected static final int AVAILABILITY_EDEFAULT = 0;

  /**
   * The default value of the '{@link #getTraceability() <em>Traceability</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getTraceability()
   * @generated
   * @ordered
   */
  protected static final int TRACEABILITY_EDEFAULT = 0;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected SecurityNeedsImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.SECURITY_NEEDS;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getConfidentiality() {

    return (Integer) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setConfidentiality(int newConfidentiality) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, newConfidentiality);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getIntegrity() {

    return (Integer) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setIntegrity(int newIntegrity) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__INTEGRITY, CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY,
        newIntegrity);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getAvailability() {

    return (Integer) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setAvailability(int newAvailability) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, newAvailability);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getTraceability() {

    return (Integer) eDynamicGet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setTraceability(int newTraceability) {

    eDynamicSet(CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, newTraceability);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      return getConfidentiality();
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      return getIntegrity();
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      return getAvailability();
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      return getTraceability();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      setConfidentiality((Integer) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      setIntegrity((Integer) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      setAvailability((Integer) newValue);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      setTraceability((Integer) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      setConfidentiality(CONFIDENTIALITY_EDEFAULT);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      setIntegrity(INTEGRITY_EDEFAULT);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      setAvailability(AVAILABILITY_EDEFAULT);
      return;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      setTraceability(TRACEABILITY_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
      return getConfidentiality() != CONFIDENTIALITY_EDEFAULT;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      return getIntegrity() != INTEGRITY_EDEFAULT;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      return getAvailability() != AVAILABILITY_EDEFAULT;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      return getTraceability() != TRACEABILITY_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

} // SecurityNeedsImpl