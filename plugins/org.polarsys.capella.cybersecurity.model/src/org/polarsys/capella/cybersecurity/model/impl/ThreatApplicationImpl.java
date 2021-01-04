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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.capella.core.data.capellacore.impl.RelationshipImpl;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.common.data.modellingcore.impl.ModelElementImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Threat Application</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatApplicationImpl#getThreat <em>Threat</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatApplicationImpl#getAsset <em>Asset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatApplicationImpl extends RelationshipImpl implements ThreatApplication {

  /**
   * The cached value of the '{@link #getThreat() <em>Threat</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getThreat()
   * @generated
   * @ordered
   */
  protected Threat threat;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ThreatApplicationImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.THREAT_APPLICATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public Threat getThreat() {

    if (threat != null && threat.eIsProxy()) {
      InternalEObject oldThreat = (InternalEObject) threat;
      threat = (Threat) eResolveProxy(oldThreat);
      if (threat != oldThreat) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.THREAT_APPLICATION__THREAT,
              oldThreat, threat));
      }
    }
    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  public Threat basicGetThreat() {

    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setThreat(Threat newThreat) {

    Threat oldThreat = threat;
    threat = newThreat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT_APPLICATION__THREAT, oldThreat,
          threat));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public PrimaryAsset getAsset() {

    PrimaryAsset asset = basicGetAsset();
    return asset != null && asset.eIsProxy() ? (PrimaryAsset) eResolveProxy((InternalEObject) asset) : asset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  public PrimaryAsset basicGetAsset() {

    EObject container = eContainer();
    if (container instanceof PrimaryAsset) {
      return (PrimaryAsset) container;
    }
    return null;

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.THREAT_APPLICATION__THREAT:
      if (resolve)
        return getThreat();
      return basicGetThreat();
    case CybersecurityPackage.THREAT_APPLICATION__ASSET:
      if (resolve)
        return getAsset();
      return basicGetAsset();
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
    case CybersecurityPackage.THREAT_APPLICATION__THREAT:
      setThreat((Threat) newValue);
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
    case CybersecurityPackage.THREAT_APPLICATION__THREAT:
      setThreat((Threat) null);
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
    case CybersecurityPackage.THREAT_APPLICATION__THREAT:
      return threat != null;
    case CybersecurityPackage.THREAT_APPLICATION__ASSET:
      return basicGetAsset() != null;
    }
    return super.eIsSet(featureID);
  }

} // ThreatApplicationImpl