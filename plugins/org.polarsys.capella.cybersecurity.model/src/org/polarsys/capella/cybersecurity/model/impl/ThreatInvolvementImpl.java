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
   * The cached value of the '{@link #getComponent() <em>Component</em>}' reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getComponent()
   * @generated
   * @ordered
   */
  protected Component component;

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

    if (component != null && component.eIsProxy()) {
      InternalEObject oldComponent = (InternalEObject) component;
      component = (Component) eResolveProxy(oldComponent);
      if (component != oldComponent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT,
              oldComponent, component));
      }
    }
    return component;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Component basicGetComponent() {

    return component;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setComponent(Component newComponent) {

    Component oldComponent = component;
    component = newComponent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT_INVOLVEMENT__COMPONENT,
          oldComponent, component));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public Threat getThreat() {

    if (threat != null && threat.eIsProxy()) {
      InternalEObject oldThreat = (InternalEObject) threat;
      threat = (Threat) eResolveProxy(oldThreat);
      if (threat != oldThreat) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.THREAT_INVOLVEMENT__THREAT,
              oldThreat, threat));
      }
    }
    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public Threat basicGetThreat() {

    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setThreat(Threat newThreat) {

    Threat oldThreat = threat;
    threat = newThreat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT_INVOLVEMENT__THREAT, oldThreat,
          threat));

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
      return component != null;
    case CybersecurityPackage.THREAT_INVOLVEMENT__THREAT:
      return threat != null;
    }
    return super.eIsSet(featureID);
  }

} // ThreatInvolvementImpl