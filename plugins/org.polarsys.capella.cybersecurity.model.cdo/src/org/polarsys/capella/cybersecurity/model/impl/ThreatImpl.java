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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.polarsys.capella.common.model.helpers.IHelper;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;

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
 * </ul>
 *
 * @generated
 */
public class ThreatImpl extends NamedElementImpl implements Threat {

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
   * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected static final String RATIONALE_EDEFAULT = null;

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

    return (EList<Component>) eDynamicGet(CybersecurityPackage.THREAT__ADDRESSED_BY,
        CybersecurityPackage.Literals.THREAT__ADDRESSED_BY, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public EnumerationPropertyLiteral getKind() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.THREAT__KIND,
        CybersecurityPackage.Literals.THREAT__KIND, true, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  public EnumerationPropertyLiteral basicGetKind() {

    return (EnumerationPropertyLiteral) eDynamicGet(CybersecurityPackage.THREAT__KIND,
        CybersecurityPackage.Literals.THREAT__KIND, false, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setKind(EnumerationPropertyLiteral newKind) {

    eDynamicSet(CybersecurityPackage.THREAT__KIND, CybersecurityPackage.Literals.THREAT__KIND, newKind);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public int getLevel() {

    return (Integer) eDynamicGet(CybersecurityPackage.THREAT__LEVEL, CybersecurityPackage.Literals.THREAT__LEVEL, true,
        true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setLevel(int newLevel) {

    eDynamicSet(CybersecurityPackage.THREAT__LEVEL, CybersecurityPackage.Literals.THREAT__LEVEL, newLevel);

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public String getRationale() {

    return (String) eDynamicGet(CybersecurityPackage.THREAT__RATIONALE, CybersecurityPackage.Literals.THREAT__RATIONALE,
        true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  @Override
  public void setRationale(String newRationale) {

    eDynamicSet(CybersecurityPackage.THREAT__RATIONALE, CybersecurityPackage.Literals.THREAT__RATIONALE, newRationale);

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
      return !getAddressedBy().isEmpty();
    case CybersecurityPackage.THREAT__KIND:
      return basicGetKind() != null;
    case CybersecurityPackage.THREAT__LEVEL:
      return getLevel() != LEVEL_EDEFAULT;
    case CybersecurityPackage.THREAT__RATIONALE:
      return RATIONALE_EDEFAULT == null ? getRationale() != null : !RATIONALE_EDEFAULT.equals(getRationale());
    case CybersecurityPackage.THREAT__REALIZED_THREATS:
      return !getRealizedThreats().isEmpty();
    case CybersecurityPackage.THREAT__REALIZING_THREATS:
      return !getRealizingThreats().isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // ThreatImpl