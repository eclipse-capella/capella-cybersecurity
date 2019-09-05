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
import org.polarsys.capella.common.lib.IdGenerator;
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
      return createCybersecurityPkg();
    case CybersecurityPackage.THREAT:
      return createThreat();
    case CybersecurityPackage.THREAT_INVOLVEMENT:
      return createThreatInvolvement();
    case CybersecurityPackage.FUNCTION_STORAGE:
      return createFunctionStorage();
    case CybersecurityPackage.THREAT_APPLICATION:
      return createThreatApplication();
    case CybersecurityPackage.PRIMARY_ASSET_STORAGE:
      return createPrimaryAssetStorage();
    case CybersecurityPackage.SECURITY_NEEDS:
      return createSecurityNeeds();
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE:
      return createTrustBoundaryStorage();
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET:
      return createFunctionalPrimaryAsset();
    case CybersecurityPackage.INFORMATION_PRIMARY_ASSET:
      return createInformationPrimaryAsset();
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER:
      return createPrimaryAssetMember();
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
    // begin-capella-code

    cybersecurityPkg.setId(IdGenerator.createId());

    // end-capella-code
    return cybersecurityPkg;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Threat createThreat() {
    ThreatImpl threat = new ThreatImpl();
    // begin-capella-code

    threat.setId(IdGenerator.createId());

    // end-capella-code
    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ThreatInvolvement createThreatInvolvement() {
    ThreatInvolvementImpl threatInvolvement = new ThreatInvolvementImpl();
    // begin-capella-code

    threatInvolvement.setId(IdGenerator.createId());

    // end-capella-code
    return threatInvolvement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public FunctionStorage createFunctionStorage() {
    FunctionStorageImpl functionStorage = new FunctionStorageImpl();
    // begin-capella-code

    functionStorage.setId(IdGenerator.createId());

    // end-capella-code
    return functionStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ThreatApplication createThreatApplication() {
    ThreatApplicationImpl threatApplication = new ThreatApplicationImpl();
    // begin-capella-code

    threatApplication.setId(IdGenerator.createId());

    // end-capella-code
    return threatApplication;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public PrimaryAssetStorage createPrimaryAssetStorage() {
    PrimaryAssetStorageImpl primaryAssetStorage = new PrimaryAssetStorageImpl();
    // begin-capella-code

    primaryAssetStorage.setId(IdGenerator.createId());

    // end-capella-code
    return primaryAssetStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public SecurityNeeds createSecurityNeeds() {
    SecurityNeedsImpl securityNeeds = new SecurityNeedsImpl();
    // begin-capella-code

    securityNeeds.setId(IdGenerator.createId());

    // end-capella-code
    return securityNeeds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public TrustBoundaryStorage createTrustBoundaryStorage() {
    TrustBoundaryStorageImpl trustBoundaryStorage = new TrustBoundaryStorageImpl();
    // begin-capella-code

    trustBoundaryStorage.setId(IdGenerator.createId());

    // end-capella-code
    return trustBoundaryStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public FunctionalPrimaryAsset createFunctionalPrimaryAsset() {
    FunctionalPrimaryAssetImpl functionalPrimaryAsset = new FunctionalPrimaryAssetImpl();
    // begin-capella-code

    functionalPrimaryAsset.setId(IdGenerator.createId());

    // end-capella-code
    return functionalPrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public InformationPrimaryAsset createInformationPrimaryAsset() {
    InformationPrimaryAssetImpl informationPrimaryAsset = new InformationPrimaryAssetImpl();
    // begin-capella-code

    informationPrimaryAsset.setId(IdGenerator.createId());

    // end-capella-code
    return informationPrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public PrimaryAssetMember createPrimaryAssetMember() {
    PrimaryAssetMemberImpl primaryAssetMember = new PrimaryAssetMemberImpl();
    // begin-capella-code

    primaryAssetMember.setId(IdGenerator.createId());

    // end-capella-code
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

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public CybersecurityPkg createCybersecurityPkg(String name_p) {
    CybersecurityPkg cybersecurityPkg = createCybersecurityPkg();
    cybersecurityPkg.setName(name_p);
    return cybersecurityPkg;
  }

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public Threat createThreat(String name_p) {
    Threat threat = createThreat();
    threat.setName(name_p);
    return threat;
  }

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public FunctionalPrimaryAsset createFunctionalPrimaryAsset(String name_p) {
    FunctionalPrimaryAsset functionalPrimaryAsset = createFunctionalPrimaryAsset();
    functionalPrimaryAsset.setName(name_p);
    return functionalPrimaryAsset;
  }

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public InformationPrimaryAsset createInformationPrimaryAsset(String name_p) {
    InformationPrimaryAsset informationPrimaryAsset = createInformationPrimaryAsset();
    informationPrimaryAsset.setName(name_p);
    return informationPrimaryAsset;
  }

  // begin-capella-code

  // end-capella-code
} // CybersecurityFactoryImpl