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
   * The default value of the '{@link #getThreatSourceProfile() <em>Threat Source Profile</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getThreatSourceProfile()
   * @generated
   * @ordered
   */
  protected static final int THREAT_SOURCE_PROFILE_EDEFAULT = 0;

  /**
   * The default value of the '{@link #isTrusted() <em>Trusted</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #isTrusted()
   * @generated NOT
   * @ordered
   */
  public static final boolean TRUSTED_EDEFAULT = true;

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

    return (Boolean) eDynamicGet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  public void setThreatSource(boolean newThreatSource) {
    eDynamicSet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE, newThreatSource);
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

    return (Integer) eDynamicGet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setThreatSourceProfile(int newThreatSourceProfile) {

    eDynamicSet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE, newThreatSourceProfile);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public boolean isTrusted() {

    return (Boolean) eDynamicGet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__TRUSTED, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setTrusted(boolean newTrusted) {

    eDynamicSet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__TRUSTED, newTrusted);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public String getRationale() {

    return (String) eDynamicGet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__RATIONALE, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setRationale(String newRationale) {

    eDynamicSet(CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__RATIONALE, newRationale);
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
      return isThreatSource() != THREAT_SOURCE_EDEFAULT;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE:
      return getThreatSourceProfile() != THREAT_SOURCE_PROFILE_EDEFAULT;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED:
      return isTrusted() != TRUSTED_EDEFAULT;
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE:
      return RATIONALE_EDEFAULT == null ? getRationale() != null : !RATIONALE_EDEFAULT.equals(getRationale());
    }
    return super.eIsSet(featureID);
  }

} // TrustBoundaryStorageImpl