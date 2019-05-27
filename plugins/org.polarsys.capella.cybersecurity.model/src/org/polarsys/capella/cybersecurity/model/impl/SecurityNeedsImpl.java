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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
   * The cached value of the '{@link #getConfidentiality() <em>Confidentiality</em>}' attribute. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getConfidentiality()
   * @generated
   * @ordered
   */
  protected int confidentiality = CONFIDENTIALITY_EDEFAULT;

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
   * The cached value of the '{@link #getIntegrity() <em>Integrity</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getIntegrity()
   * @generated
   * @ordered
   */
  protected int integrity = INTEGRITY_EDEFAULT;

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
   * The cached value of the '{@link #getAvailability() <em>Availability</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getAvailability()
   * @generated
   * @ordered
   */
  protected int availability = AVAILABILITY_EDEFAULT;

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
   * The cached value of the '{@link #getTraceability() <em>Traceability</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getTraceability()
   * @generated
   * @ordered
   */
  protected int traceability = TRACEABILITY_EDEFAULT;

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

    return confidentiality;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setConfidentiality(int newConfidentiality) {

    int oldConfidentiality = confidentiality;
    confidentiality = newConfidentiality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY,
          oldConfidentiality, confidentiality));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getIntegrity() {

    return integrity;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setIntegrity(int newIntegrity) {

    int oldIntegrity = integrity;
    integrity = newIntegrity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__INTEGRITY,
          oldIntegrity, integrity));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getAvailability() {

    return availability;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setAvailability(int newAvailability) {

    int oldAvailability = availability;
    availability = newAvailability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY,
          oldAvailability, availability));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getTraceability() {

    return traceability;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setTraceability(int newTraceability) {

    int oldTraceability = traceability;
    traceability = newTraceability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY,
          oldTraceability, traceability));

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
      return confidentiality != CONFIDENTIALITY_EDEFAULT;
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
      return integrity != INTEGRITY_EDEFAULT;
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
      return availability != AVAILABILITY_EDEFAULT;
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
      return traceability != TRACEABILITY_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
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