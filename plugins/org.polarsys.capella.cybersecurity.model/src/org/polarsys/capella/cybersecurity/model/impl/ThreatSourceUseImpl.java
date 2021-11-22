/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.capella.core.data.capellacore.impl.RelationshipImpl;

import org.polarsys.capella.core.data.cs.Component;

import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Threat Source Use</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatSourceUseImpl#getThreatSource <em>Threat
 * Source</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatSourceUseImpl#getUsedActor <em>Used Actor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatSourceUseImpl extends RelationshipImpl implements ThreatSourceUse {

  /**
   * The cached value of the '{@link #getUsedActor() <em>Used Actor</em>}' reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getUsedActor()
   * @generated
   * @ordered
   */
  protected Component usedActor;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ThreatSourceUseImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.THREAT_SOURCE_USE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  @Override
  public Component getThreatSource() {

    Component threatSource = basicGetThreatSource();
    return threatSource != null && threatSource.eIsProxy() ? (Component) eResolveProxy((InternalEObject) threatSource)
        : threatSource;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */

  public Component basicGetThreatSource() {
    EObject container = eContainer();
    if (container instanceof Component) {
      return (Component) container;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  @Override
  public Component getUsedActor() {

    if (usedActor != null && usedActor.eIsProxy()) {
      InternalEObject oldUsedActor = (InternalEObject) usedActor;
      usedActor = (Component) eResolveProxy(oldUsedActor);
      if (usedActor != oldUsedActor) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CybersecurityPackage.THREAT_SOURCE_USE__USED_ACTOR,
              oldUsedActor, usedActor));
      }
    }
    return usedActor;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public Component basicGetUsedActor() {

    return usedActor;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  @Override
  public void setUsedActor(Component newUsedActor) {

    Component oldUsedActor = usedActor;
    usedActor = newUsedActor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CybersecurityPackage.THREAT_SOURCE_USE__USED_ACTOR,
          oldUsedActor, usedActor));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.THREAT_SOURCE_USE__THREAT_SOURCE:
      if (resolve)
        return getThreatSource();
      return basicGetThreatSource();
    case CybersecurityPackage.THREAT_SOURCE_USE__USED_ACTOR:
      if (resolve)
        return getUsedActor();
      return basicGetUsedActor();
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
    case CybersecurityPackage.THREAT_SOURCE_USE__USED_ACTOR:
      setUsedActor((Component) newValue);
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
    case CybersecurityPackage.THREAT_SOURCE_USE__USED_ACTOR:
      setUsedActor((Component) null);
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
    case CybersecurityPackage.THREAT_SOURCE_USE__THREAT_SOURCE:
      return basicGetThreatSource() != null;
    case CybersecurityPackage.THREAT_SOURCE_USE__USED_ACTOR:
      return usedActor != null;
    }
    return super.eIsSet(featureID);
  }

} // ThreatSourceUseImpl