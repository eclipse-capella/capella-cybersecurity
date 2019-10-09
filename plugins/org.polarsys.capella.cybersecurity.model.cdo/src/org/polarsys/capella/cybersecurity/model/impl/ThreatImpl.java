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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.capellacore.impl.NamedElementImpl;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatKind;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Threat</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getAddressedBy <em>Addressed By</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getThreatKind <em>Threat Kind</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getLevel <em>Level</em>}</li>
 * <li>{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl#getRationale <em>Rationale</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThreatImpl extends NamedElementImpl implements Threat {

  /**
   * The default value of the '{@link #getThreatKind() <em>Threat Kind</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getThreatKind()
   * @generated
   * @ordered
   */
  protected static final ThreatKind THREAT_KIND_EDEFAULT = ThreatKind.EAVESDROPPING;

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
  protected ThreatImpl() {

    super();

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return CybersecurityPackage.Literals.THREAT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  @SuppressWarnings("unchecked")
  public EList<Component> getAddressedBy() {

    return (EList<Component>) eDynamicGet(CybersecurityPackage.THREAT__ADDRESSED_BY,
        CybersecurityPackage.Literals.THREAT__ADDRESSED_BY, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public ThreatKind getThreatKind() {

    return (ThreatKind) eDynamicGet(CybersecurityPackage.THREAT__THREAT_KIND,
        CybersecurityPackage.Literals.THREAT__THREAT_KIND, true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setThreatKind(ThreatKind newThreatKind) {

    eDynamicSet(CybersecurityPackage.THREAT__THREAT_KIND, CybersecurityPackage.Literals.THREAT__THREAT_KIND,
        newThreatKind);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public int getLevel() {

    return (Integer) eDynamicGet(CybersecurityPackage.THREAT__LEVEL, CybersecurityPackage.Literals.THREAT__LEVEL, true,
        true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setLevel(int newLevel) {

    eDynamicSet(CybersecurityPackage.THREAT__LEVEL, CybersecurityPackage.Literals.THREAT__LEVEL, newLevel);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public String getRationale() {

    return (String) eDynamicGet(CybersecurityPackage.THREAT__RATIONALE, CybersecurityPackage.Literals.THREAT__RATIONALE,
        true, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */

  public void setRationale(String newRationale) {

    eDynamicSet(CybersecurityPackage.THREAT__RATIONALE, CybersecurityPackage.Literals.THREAT__RATIONALE, newRationale);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      return getAddressedBy();
    case CybersecurityPackage.THREAT__THREAT_KIND:
      return getThreatKind();
    case CybersecurityPackage.THREAT__LEVEL:
      return getLevel();
    case CybersecurityPackage.THREAT__RATIONALE:
      return getRationale();
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
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      getAddressedBy().clear();
      getAddressedBy().addAll((Collection<? extends Component>) newValue);
      return;
    case CybersecurityPackage.THREAT__THREAT_KIND:
      setThreatKind((ThreatKind) newValue);
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
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      getAddressedBy().clear();
      return;
    case CybersecurityPackage.THREAT__THREAT_KIND:
      setThreatKind(THREAT_KIND_EDEFAULT);
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
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case CybersecurityPackage.THREAT__ADDRESSED_BY:
      return !getAddressedBy().isEmpty();
    case CybersecurityPackage.THREAT__THREAT_KIND:
      return getThreatKind() != THREAT_KIND_EDEFAULT;
    case CybersecurityPackage.THREAT__LEVEL:
      return getLevel() != LEVEL_EDEFAULT;
    case CybersecurityPackage.THREAT__RATIONALE:
      return RATIONALE_EDEFAULT == null ? getRationale() != null : !RATIONALE_EDEFAULT.equals(getRationale());
    }
    return super.eIsSet(featureID);
  }

} // ThreatImpl