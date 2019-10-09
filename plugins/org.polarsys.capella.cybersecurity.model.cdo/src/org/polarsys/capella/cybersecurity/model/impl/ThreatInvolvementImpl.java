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
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Threat Involvement</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatInvolvementImpl#getActor <em>Actor</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatInvolvementImpl#getThreat <em>Threat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatInvolvementImpl extends ModelElementImpl implements ThreatInvolvement {

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ThreatInvolvementImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.THREAT_INVOLVEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Component getComponent() {

    return (Component) eDynamicGet(CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__COMPONENT, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Component basicGetComponent() {

    return (Component) eDynamicGet(CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__COMPONENT, false, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setComponent(Component newComponent) {

    eDynamicSet(CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__COMPONENT, newComponent);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public Threat getThreat() {

    return (Threat) eDynamicGet(CybersecurityPackage.THREAT_INVOLVEMENT__THREAT,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__THREAT, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public Threat basicGetThreat() {

    return (Threat) eDynamicGet(CybersecurityPackage.THREAT_INVOLVEMENT__THREAT,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__THREAT, false, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setThreat(Threat newThreat) {

    eDynamicSet(CybersecurityPackage.THREAT_INVOLVEMENT__THREAT,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__THREAT, newThreat);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT:
      if (resolve)
        return getComponent();
      return basicGetComponent();
    case CybersecurityPackage.THREAT_INVOLVEMENT__THREAT:
      if (resolve)
        return getThreat();
      return basicGetThreat();
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
    case CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT:
      setComponent((Component) newValue);
      return;
    case CybersecurityPackage.THREAT_INVOLVEMENT__THREAT:
      setThreat((Threat) newValue);
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
    case CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT:
      setComponent((Component) null);
      return;
    case CybersecurityPackage.THREAT_INVOLVEMENT__THREAT:
      setThreat((Threat) null);
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
    case CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT:
      return basicGetComponent() != null;
    case CybersecurityPackage.THREAT_INVOLVEMENT__THREAT:
      return basicGetThreat() != null;
    }
    return super.eIsSet(featureID);
  }

} // ThreatInvolvementImpl