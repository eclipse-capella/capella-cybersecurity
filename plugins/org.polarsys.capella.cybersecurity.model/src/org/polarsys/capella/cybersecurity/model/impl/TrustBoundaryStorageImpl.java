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
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Trust Boundary Storage</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl#isThreatSource <em>Threat
 * Source</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl#getThreatSourceProfile <em>Threat
 * Source Profile</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl#isTrusted <em>Trusted</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl#getRationale
 * <em>Rationale</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrustBoundaryStorageImpl extends ModelElementImpl implements TrustBoundaryStorage {

  /**
   * The default value of the '{@link #isThreatSource() <em>Threat Source</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #isThreatSource()
   * @generated
   * @ordered
   */
  protected static final boolean THREAT_SOURCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isThreatSource() <em>Threat Source</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #isThreatSource()
   * @generated
   * @ordered
   */
  protected boolean threatSource = THREAT_SOURCE_EDEFAULT;

  /**
   * The default value of the '{@link #getThreatSourceProfile() <em>Threat Source Profile</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getThreatSourceProfile()
   * @generated
   * @ordered
   */
  protected static final int THREAT_SOURCE_PROFILE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getThreatSourceProfile() <em>Threat Source Profile</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getThreatSourceProfile()
   * @generated
   * @ordered
   */
  protected int threatSourceProfile = THREAT_SOURCE_PROFILE_EDEFAULT;

  /**
   * The default value of the '{@link #isTrusted() <em>Trusted</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #isTrusted()
   * @generated
   * @ordered
   */
  protected static final boolean TRUSTED_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isTrusted() <em>Trusted</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #isTrusted()
   * @generated
   * @ordered
   */
  protected boolean trusted = TRUSTED_EDEFAULT;

  /**
   * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected static final String RATIONALE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected String rationale = RATIONALE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected TrustBoundaryStorageImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public boolean isThreatSource() {

    return threatSource;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  public void setThreatSource(boolean newThreatSource) {

    boolean oldThreatSource = threatSource;
    threatSource = newThreatSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE,
          oldThreatSource, threatSource));

    if (newThreatSource) {
      setTrusted(false);
    }

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getThreatSourceProfile() {

    return threatSourceProfile;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setThreatSourceProfile(int newThreatSourceProfile) {

    int oldThreatSourceProfile = threatSourceProfile;
    threatSourceProfile = newThreatSourceProfile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE, oldThreatSourceProfile,
          threatSourceProfile));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public boolean isTrusted() {

    return trusted;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setTrusted(boolean newTrusted) {

    boolean oldTrusted = trusted;
    trusted = newTrusted;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED,
          oldTrusted, trusted));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public String getRationale() {

    return rationale;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setRationale(String newRationale) {

    String oldRationale = rationale;
    rationale = newRationale;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE,
          oldRationale, rationale));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE:
      return isThreatSource();
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE:
      return getThreatSourceProfile();
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED:
      return isTrusted();
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE:
      return getRationale();
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
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE:
      setThreatSource((Boolean) newValue);
      return;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE:
      setThreatSourceProfile((Integer) newValue);
      return;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED:
      setTrusted((Boolean) newValue);
      return;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE:
      setRationale((String) newValue);
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
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE:
      setThreatSource(THREAT_SOURCE_EDEFAULT);
      return;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE:
      setThreatSourceProfile(THREAT_SOURCE_PROFILE_EDEFAULT);
      return;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED:
      setTrusted(TRUSTED_EDEFAULT);
      return;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE:
      setRationale(RATIONALE_EDEFAULT);
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
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE:
      return threatSource != THREAT_SOURCE_EDEFAULT;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE:
      return threatSourceProfile != THREAT_SOURCE_PROFILE_EDEFAULT;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED:
      return trusted != TRUSTED_EDEFAULT;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE:
      return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
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
    result.append(" (threatSource: "); //$NON-NLS-1$
    result.append(threatSource);
    result.append(", threatSourceProfile: "); //$NON-NLS-1$
    result.append(threatSourceProfile);
    result.append(", trusted: "); //$NON-NLS-1$
    result.append(trusted);
    result.append(", rationale: "); //$NON-NLS-1$
    result.append(rationale);
    result.append(')');
    return result.toString();
  }

} // TrustBoundaryStorageImpl