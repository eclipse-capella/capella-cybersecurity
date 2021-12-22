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

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.polarsys.capella.common.model.helpers.IHelper;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.interaction.impl.AbstractCapabilityImpl;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Threat</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getAddressedBy <em>Addressed By</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getRealizedThreats <em>Realized Threats</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getRealizingThreats <em>Realizing Threats</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getOwnedThreatApplications <em>Owned Threat Applications</em>}</li>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getOwnedThreatInvolvements <em>Owned Threat Involvements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatImpl extends AbstractCapabilityImpl implements Threat {

  /**
   * The cached value of the '{@link #getAddressedBy() <em>Addressed By</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAddressedBy()
   * @generated
   * @ordered
   */
  protected EList<Component> addressedBy;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected EnumerationPropertyLiteral kind;

  /**
   * The default value of the '{@link #getLevel() <em>Level</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected static final int LEVEL_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected int level = LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected static final String RATIONALE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected String rationale = RATIONALE_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedThreatApplications() <em>Owned Threat Applications</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedThreatApplications()
   * @generated
   * @ordered
   */
  protected EList<ThreatApplication> ownedThreatApplications;

  /**
   * The cached value of the '{@link #getOwnedThreatInvolvements() <em>Owned Threat Involvements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedThreatInvolvements()
   * @generated
   * @ordered
   */
  protected EList<ThreatInvolvement> ownedThreatInvolvements;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ThreatImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.THREAT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @SuppressWarnings("unchecked")
  @Override
  public EList<Component> getAddressedBy() {

    if (addressedBy == null) {
      addressedBy = new EObjectResolvingEList<Component>(Component.class, this,
          CybersecurityPackage.THREAT__ADDRESSED_BY);
    }
    return addressedBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getKind() {

    if (kind != null && kind.eIsProxy()) {
      InternalEObject oldKind = (InternalEObject) kind;
      kind = (EnumerationPropertyLiteral) eResolveProxy(oldKind);
      if (kind != oldKind) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.THREAT__KIND, oldKind, kind));
      }
    }
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetKind() {

    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setKind(EnumerationPropertyLiteral newKind) {

    EnumerationPropertyLiteral oldKind = kind;
    kind = newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT__KIND, oldKind, kind));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public int getLevel() {

    return level;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setLevel(int newLevel) {

    int oldLevel = level;
    level = newLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT__LEVEL, oldLevel, level));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public String getRationale() {

    return rationale;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setRationale(String newRationale) {

    String oldRationale = rationale;
    rationale = newRationale;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT__RATIONALE, oldRationale,
          rationale));

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */

  @Override
  public EList<Threat> getRealizedThreats() {
    Object result = null;
    // Helper that can get value for current feature.
    IHelper helper = null;
    // If current object is adaptable, ask it to get its IHelper.
    if (this instanceof IAdaptable) {
      helper = (IHelper) ((IAdaptable) this).getAdapter(IHelper.class);
    }
    if (null == helper) {
      // No helper found yet.
      // Ask the platform to get the adapter 'IHelper.class' for current object.
      IAdapterManager adapterManager = Platform.getAdapterManager();
      helper = (IHelper) adapterManager.getAdapter(this, IHelper.class);
    }
    if (null == helper) {
      EPackage package_l = eClass().getEPackage();
      // Get the root package of the owner package.
      EPackage rootPackage = org.polarsys.capella.common.mdsofa.common.helper.EcoreHelper.getRootPackage(package_l);
      throw new org.polarsys.capella.common.model.helpers.HelperNotFoundException(
          "No helper retrieved for nsURI " + rootPackage.getNsURI()); //$NON-NLS-1$
    }
    // A helper is found, let's use it. 
    EAnnotation annotation = CybersecurityPackage.Literals.THREAT__REALIZED_THREATS
        .getEAnnotation(org.polarsys.capella.common.model.helpers.IModelConstants.HELPER_ANNOTATION_SOURCE);
    result = helper.getValue(this, CybersecurityPackage.Literals.THREAT__REALIZED_THREATS, annotation);

    try {
      @SuppressWarnings("unchecked")
      Collection<Component> resultAsList = (Collection<Component>) result;
      return new EcoreEList.UnmodifiableEList<Threat>(this, CybersecurityPackage.Literals.THREAT__REALIZED_THREATS,
          resultAsList.size(), resultAsList.toArray());
    } catch (ClassCastException exception) {
      exception.printStackTrace();
      return org.eclipse.emf.common.util.ECollections.emptyEList();
    }

  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */

  @Override
  public EList<Threat> getRealizingThreats() {
    Object result = null;
    // Helper that can get value for current feature.
    IHelper helper = null;
    // If current object is adaptable, ask it to get its IHelper.
    if (this instanceof IAdaptable) {
      helper = (IHelper) ((IAdaptable) this).getAdapter(IHelper.class);
    }
    if (null == helper) {
      // No helper found yet.
      // Ask the platform to get the adapter 'IHelper.class' for current object.
      IAdapterManager adapterManager = Platform.getAdapterManager();
      helper = (IHelper) adapterManager.getAdapter(this, IHelper.class);
    }
    if (null == helper) {
      EPackage package_l = eClass().getEPackage();
      // Get the root package of the owner package.
      EPackage rootPackage = org.polarsys.capella.common.mdsofa.common.helper.EcoreHelper.getRootPackage(package_l);
      throw new org.polarsys.capella.common.model.helpers.HelperNotFoundException(
          "No helper retrieved for nsURI " + rootPackage.getNsURI()); //$NON-NLS-1$
    }
    // A helper is found, let's use it. 
    EAnnotation annotation = CybersecurityPackage.Literals.THREAT__REALIZING_THREATS
        .getEAnnotation(org.polarsys.capella.common.model.helpers.IModelConstants.HELPER_ANNOTATION_SOURCE);
    result = helper.getValue(this, CybersecurityPackage.Literals.THREAT__REALIZING_THREATS, annotation);

    try {
      @SuppressWarnings("unchecked")
      Collection<Component> resultAsList = (Collection<Component>) result;
      return new EcoreEList.UnmodifiableEList<Threat>(this, CybersecurityPackage.Literals.THREAT__REALIZING_THREATS,
          resultAsList.size(), resultAsList.toArray());
    } catch (ClassCastException exception) {
      exception.printStackTrace();
      return org.eclipse.emf.common.util.ECollections.emptyEList();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @SuppressWarnings("unchecked")
  @Override
  public EList<ThreatApplication> getOwnedThreatApplications() {

    if (ownedThreatApplications == null) {
      ownedThreatApplications = new EObjectContainmentEList<ThreatApplication>(ThreatApplication.class, this,
          CybersecurityPackage.THREAT__OWNED_THREAT_APPLICATIONS);
    }
    return ownedThreatApplications;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */

  @SuppressWarnings("unchecked")
  @Override
  public EList<ThreatInvolvement> getOwnedThreatInvolvements() {

    if (ownedThreatInvolvements == null) {
      ownedThreatInvolvements = new EObjectContainmentEList<ThreatInvolvement>(ThreatInvolvement.class, this,
          CybersecurityPackage.THREAT__OWNED_THREAT_INVOLVEMENTS);
    }
    return ownedThreatInvolvements;
  }

  /**
   * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case CybersecurityPackage.THREAT__OWNED_THREAT_APPLICATIONS:
      return ((InternalEList<?>) getOwnedThreatApplications()).basicRemove(otherEnd, msgs);
    case CybersecurityPackage.THREAT__OWNED_THREAT_INVOLVEMENTS:
      return ((InternalEList<?>) getOwnedThreatInvolvements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      return getAddressedBy();
    case CybersecurityPackage.THREAT__KIND:
      if (resolve)
        return getKind();
      return basicGetKind();
    case CybersecurityPackage.THREAT__LEVEL:
      return getLevel();
    case CybersecurityPackage.THREAT__RATIONALE:
      return getRationale();
    case CybersecurityPackage.THREAT__REALIZED_THREATS:
      return getRealizedThreats();
    case CybersecurityPackage.THREAT__REALIZING_THREATS:
      return getRealizingThreats();
    case CybersecurityPackage.THREAT__OWNED_THREAT_APPLICATIONS:
      return getOwnedThreatApplications();
    case CybersecurityPackage.THREAT__OWNED_THREAT_INVOLVEMENTS:
      return getOwnedThreatInvolvements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      getAddressedBy().clear();
      getAddressedBy().addAll((Collection<? extends Component>) newValue);
      return;
    case CybersecurityPackage.THREAT__KIND:
      setKind((EnumerationPropertyLiteral) newValue);
      return;
    case CybersecurityPackage.THREAT__LEVEL:
      setLevel((Integer) newValue);
      return;
    case CybersecurityPackage.THREAT__RATIONALE:
      setRationale((String) newValue);
      return;
    case CybersecurityPackage.THREAT__OWNED_THREAT_APPLICATIONS:
      getOwnedThreatApplications().clear();
      getOwnedThreatApplications().addAll((Collection<? extends ThreatApplication>) newValue);
      return;
    case CybersecurityPackage.THREAT__OWNED_THREAT_INVOLVEMENTS:
      getOwnedThreatInvolvements().clear();
      getOwnedThreatInvolvements().addAll((Collection<? extends ThreatInvolvement>) newValue);
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
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      getAddressedBy().clear();
      return;
    case CybersecurityPackage.THREAT__KIND:
      setKind((EnumerationPropertyLiteral) null);
      return;
    case CybersecurityPackage.THREAT__LEVEL:
      setLevel(LEVEL_EDEFAULT);
      return;
    case CybersecurityPackage.THREAT__RATIONALE:
      setRationale(RATIONALE_EDEFAULT);
      return;
    case CybersecurityPackage.THREAT__OWNED_THREAT_APPLICATIONS:
      getOwnedThreatApplications().clear();
      return;
    case CybersecurityPackage.THREAT__OWNED_THREAT_INVOLVEMENTS:
      getOwnedThreatInvolvements().clear();
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
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      return addressedBy != null && !addressedBy.isEmpty();
    case CybersecurityPackage.THREAT__KIND:
      return kind != null;
    case CybersecurityPackage.THREAT__LEVEL:
      return level != LEVEL_EDEFAULT;
    case CybersecurityPackage.THREAT__RATIONALE:
      return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
    case CybersecurityPackage.THREAT__REALIZED_THREATS:
      return !getRealizedThreats().isEmpty();
    case CybersecurityPackage.THREAT__REALIZING_THREATS:
      return !getRealizingThreats().isEmpty();
    case CybersecurityPackage.THREAT__OWNED_THREAT_APPLICATIONS:
      return ownedThreatApplications != null && !ownedThreatApplications.isEmpty();
    case CybersecurityPackage.THREAT__OWNED_THREAT_INVOLVEMENTS:
      return ownedThreatInvolvements != null && !ownedThreatInvolvements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (level: "); //$NON-NLS-1$
    result.append(level);
    result.append(", rationale: "); //$NON-NLS-1$
    result.append(rationale);
    result.append(')');
    return result.toString();
  }

} // ThreatImpl