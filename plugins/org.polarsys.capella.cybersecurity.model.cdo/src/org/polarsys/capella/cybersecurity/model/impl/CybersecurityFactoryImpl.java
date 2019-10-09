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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.ThreatKind;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CybersecurityFactoryImpl extends EFactoryImpl implements CybersecurityFactory {
  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static CybersecurityFactory init() {
    try {
      CybersecurityFactory theCybersecurityFactory = (CybersecurityFactory) EPackage.Registry.INSTANCE
          .getEFactory(CybersecurityPackage.eNS_URI);
      if (theCybersecurityFactory != null) {
        return theCybersecurityFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CybersecurityFactoryImpl();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public CybersecurityFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case CybersecurityPackage.CYBERSECURITY_PKG:
      return (EObject) createCybersecurityPkg();
    case CybersecurityPackage.THREAT:
      return (EObject) createThreat();
    case CybersecurityPackage.THREAT_INVOLVEMENT:
      return (EObject) createThreatInvolvement();
    case CybersecurityPackage.FUNCTION_STORAGE:
      return (EObject) createFunctionStorage();
    case CybersecurityPackage.THREAT_APPLICATION:
      return (EObject) createThreatApplication();
    case CybersecurityPackage.PRIMARY_ASSET_STORAGE:
      return (EObject) createPrimaryAssetStorage();
    case CybersecurityPackage.SECURITY_NEEDS:
      return (EObject) createSecurityNeeds();
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE:
      return (EObject) createTrustBoundaryStorage();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET:
      return (EObject) createFunctionalPrimaryAsset();
    case CybersecurityPackage.INFORMATION_PRIMARY_ASSET:
      return (EObject) createInformationPrimaryAsset();
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER:
      return (EObject) createPrimaryAssetMember();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    case CybersecurityPackage.THREAT_KIND:
      return createThreatKindFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case CybersecurityPackage.THREAT_KIND:
      return convertThreatKindToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public CybersecurityPkg createCybersecurityPkg() {
    CybersecurityPkgImpl cybersecurityPkg = new CybersecurityPkgImpl();
    return cybersecurityPkg;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Threat createThreat() {
    ThreatImpl threat = new ThreatImpl();
    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ThreatInvolvement createThreatInvolvement() {
    ThreatInvolvementImpl threatInvolvement = new ThreatInvolvementImpl();
    return threatInvolvement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public FunctionStorage createFunctionStorage() {
    FunctionStorageImpl functionStorage = new FunctionStorageImpl();
    return functionStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ThreatApplication createThreatApplication() {
    ThreatApplicationImpl threatApplication = new ThreatApplicationImpl();
    return threatApplication;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public PrimaryAssetStorage createPrimaryAssetStorage() {
    PrimaryAssetStorageImpl primaryAssetStorage = new PrimaryAssetStorageImpl();
    return primaryAssetStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public SecurityNeeds createSecurityNeeds() {
    SecurityNeedsImpl securityNeeds = new SecurityNeedsImpl();
    return securityNeeds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public TrustBoundaryStorage createTrustBoundaryStorage() {
    TrustBoundaryStorageImpl trustBoundaryStorage = new TrustBoundaryStorageImpl();
    return trustBoundaryStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public FunctionalPrimaryAsset createFunctionalPrimaryAsset() {
    FunctionalPrimaryAssetImpl functionalPrimaryAsset = new FunctionalPrimaryAssetImpl();
    return functionalPrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public InformationPrimaryAsset createInformationPrimaryAsset() {
    InformationPrimaryAssetImpl informationPrimaryAsset = new InformationPrimaryAssetImpl();
    return informationPrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public PrimaryAssetMember createPrimaryAssetMember() {
    PrimaryAssetMemberImpl primaryAssetMember = new PrimaryAssetMemberImpl();
    return primaryAssetMember;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ThreatKind createThreatKindFromString(EDataType eDataType, String initialValue) {
    ThreatKind result = ThreatKind.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException(
          "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertThreatKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public CybersecurityPackage getCybersecurityPackage() {
    return (CybersecurityPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CybersecurityPackage getPackage() {
    return CybersecurityPackage.eINSTANCE;
  }

  // begin-capella-code

  // end-capella-code
} // CybersecurityFactoryImpl