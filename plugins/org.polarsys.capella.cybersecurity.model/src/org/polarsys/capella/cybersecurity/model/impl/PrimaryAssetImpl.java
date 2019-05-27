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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primary Asset</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getOwnedSecurityNeeds <em>Owned Security
 * Needs</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getOwnedThreatApplications <em>Owned Threat
 * Applications</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl#getOwnedMembers <em>Owned
 * Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PrimaryAssetImpl extends NamedElementImpl implements PrimaryAsset {

  /**
   * The cached value of the '{@link #getOwnedSecurityNeeds() <em>Owned Security Needs</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOwnedSecurityNeeds()
   * @generated
   * @ordered
   */
  protected SecurityNeeds ownedSecurityNeeds;

  /**
   * The cached value of the '{@link #getOwnedThreatApplications() <em>Owned Threat Applications</em>}' containment
   * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOwnedThreatApplications()
   * @generated
   * @ordered
   */
  protected EList<ThreatApplication> ownedThreatApplications;

  /**
   * The cached value of the '{@link #getOwnedMembers() <em>Owned Members</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getOwnedMembers()
   * @generated
   * @ordered
   */
  protected EList<PrimaryAssetMember> ownedMembers;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PrimaryAssetImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.PRIMARY_ASSET;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public SecurityNeeds getOwnedSecurityNeeds() {

    return ownedSecurityNeeds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public NotificationChain basicSetOwnedSecurityNeeds(SecurityNeeds newOwnedSecurityNeeds, NotificationChain msgs) {

    SecurityNeeds oldOwnedSecurityNeeds = ownedSecurityNeeds;
    ownedSecurityNeeds = newOwnedSecurityNeeds;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS, oldOwnedSecurityNeeds, newOwnedSecurityNeeds);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }

    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setOwnedSecurityNeeds(SecurityNeeds newOwnedSecurityNeeds) {

    if (newOwnedSecurityNeeds != ownedSecurityNeeds) {
      NotificationChain msgs = null;
      if (ownedSecurityNeeds != null)
        msgs = ((InternalEObject) ownedSecurityNeeds).eInverseRemove(this,
            EOPPOSITE_FEATURE_BASE - CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS, null, msgs);
      if (newOwnedSecurityNeeds != null)
        msgs = ((InternalEObject) newOwnedSecurityNeeds).eInverseAdd(this,
            EOPPOSITE_FEATURE_BASE - CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS, null, msgs);
      msgs = basicSetOwnedSecurityNeeds(newOwnedSecurityNeeds, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS,
          newOwnedSecurityNeeds, newOwnedSecurityNeeds));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public EList<ThreatApplication> getOwnedThreatApplications() {

    if (ownedThreatApplications == null) {
      ownedThreatApplications = new EObjectContainmentEList<ThreatApplication>(ThreatApplication.class, this,
          CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS);
    }
    return ownedThreatApplications;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public EList<PrimaryAssetMember> getOwnedMembers() {

    if (ownedMembers == null) {
      ownedMembers = new EObjectContainmentEList<PrimaryAssetMember>(PrimaryAssetMember.class, this,
          CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS);
    }
    return ownedMembers;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS:
      return basicSetOwnedSecurityNeeds(null, msgs);
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      return ((InternalEList<?>) getOwnedThreatApplications()).basicRemove(otherEnd, msgs);
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return ((InternalEList<?>) getOwnedMembers()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS:
      return getOwnedSecurityNeeds();
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      return getOwnedThreatApplications();
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return getOwnedMembers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS:
      setOwnedSecurityNeeds((SecurityNeeds) newValue);
      return;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      getOwnedThreatApplications().clear();
      getOwnedThreatApplications().addAll((Collection<? extends ThreatApplication>) newValue);
      return;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      getOwnedMembers().clear();
      getOwnedMembers().addAll((Collection<? extends PrimaryAssetMember>) newValue);
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
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS:
      setOwnedSecurityNeeds((SecurityNeeds) null);
      return;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      getOwnedThreatApplications().clear();
      return;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      getOwnedMembers().clear();
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
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_SECURITY_NEEDS:
      return ownedSecurityNeeds != null;
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS:
      return ownedThreatApplications != null && !ownedThreatApplications.isEmpty();
    case CybersecurityPackage.PRIMARY_ASSET__OWNED_MEMBERS:
      return ownedMembers != null && !ownedMembers.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // PrimaryAssetImpl