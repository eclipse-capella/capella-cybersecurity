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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.capella.common.lib.IdGenerator;
import org.polarsys.capella.cybersecurity.model.*;
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
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class CybersecurityFactoryImpl extends EFactoryImpl implements CybersecurityFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public CybersecurityFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION:
      return createCybersecurityConfiguration();
    case CybersecurityPackage.ENTERPRISE_PRIMARY_ASSET:
      return createEnterprisePrimaryAsset();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CybersecurityPkg createCybersecurityPkg() {
    CybersecurityPkgImpl cybersecurityPkg = new CybersecurityPkgImpl();
    //begin-capella-code
    cybersecurityPkg.setId(IdGenerator.createId());
    //end-capella-code
    return cybersecurityPkg;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Threat createThreat() {
    ThreatImpl threat = new ThreatImpl();
    //begin-capella-code
    threat.setId(IdGenerator.createId());
    //end-capella-code
    return threat;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThreatInvolvement createThreatInvolvement() {
    ThreatInvolvementImpl threatInvolvement = new ThreatInvolvementImpl();
    //begin-capella-code
    threatInvolvement.setId(IdGenerator.createId());
    //end-capella-code
    return threatInvolvement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunctionStorage createFunctionStorage() {
    FunctionStorageImpl functionStorage = new FunctionStorageImpl();
    //begin-capella-code
    functionStorage.setId(IdGenerator.createId());
    //end-capella-code
    return functionStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThreatApplication createThreatApplication() {
    ThreatApplicationImpl threatApplication = new ThreatApplicationImpl();
    //begin-capella-code
    threatApplication.setId(IdGenerator.createId());
    //end-capella-code
    return threatApplication;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PrimaryAssetStorage createPrimaryAssetStorage() {
    PrimaryAssetStorageImpl primaryAssetStorage = new PrimaryAssetStorageImpl();
    //begin-capella-code
    primaryAssetStorage.setId(IdGenerator.createId());
    //end-capella-code
    return primaryAssetStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SecurityNeeds createSecurityNeeds() {
    SecurityNeedsImpl securityNeeds = new SecurityNeedsImpl();
    //begin-capella-code
    securityNeeds.setId(IdGenerator.createId());
    //end-capella-code
    return securityNeeds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TrustBoundaryStorage createTrustBoundaryStorage() {
    TrustBoundaryStorageImpl trustBoundaryStorage = new TrustBoundaryStorageImpl();
    //begin-capella-code
    trustBoundaryStorage.setId(IdGenerator.createId());
    //end-capella-code
    return trustBoundaryStorage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunctionalPrimaryAsset createFunctionalPrimaryAsset() {
    FunctionalPrimaryAssetImpl functionalPrimaryAsset = new FunctionalPrimaryAssetImpl();
    //begin-capella-code
    functionalPrimaryAsset.setId(IdGenerator.createId());
    //end-capella-code
    return functionalPrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InformationPrimaryAsset createInformationPrimaryAsset() {
    InformationPrimaryAssetImpl informationPrimaryAsset = new InformationPrimaryAssetImpl();
    //begin-capella-code
    informationPrimaryAsset.setId(IdGenerator.createId());
    //end-capella-code
    return informationPrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PrimaryAssetMember createPrimaryAssetMember() {
    PrimaryAssetMemberImpl primaryAssetMember = new PrimaryAssetMemberImpl();
    //begin-capella-code
    primaryAssetMember.setId(IdGenerator.createId());
    //end-capella-code
    return primaryAssetMember;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CybersecurityConfiguration createCybersecurityConfiguration() {
    CybersecurityConfigurationImpl cybersecurityConfiguration = new CybersecurityConfigurationImpl();
    //begin-capella-code
    cybersecurityConfiguration.setId(IdGenerator.createId());
    //end-capella-code
    return cybersecurityConfiguration;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnterprisePrimaryAsset createEnterprisePrimaryAsset() {
    EnterprisePrimaryAssetImpl enterprisePrimaryAsset = new EnterprisePrimaryAssetImpl();
    //begin-capella-code
    enterprisePrimaryAsset.setId(IdGenerator.createId());
    //end-capella-code
    return enterprisePrimaryAsset;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CybersecurityPackage getCybersecurityPackage() {
    return (CybersecurityPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
  public FunctionStorage createFunctionStorage(String name_p) {
    FunctionStorage functionStorage = createFunctionStorage();
    functionStorage.setName(name_p);
    return functionStorage;
  }

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public PrimaryAssetStorage createPrimaryAssetStorage(String name_p) {
    PrimaryAssetStorage primaryAssetStorage = createPrimaryAssetStorage();
    primaryAssetStorage.setName(name_p);
    return primaryAssetStorage;
  }

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public SecurityNeeds createSecurityNeeds(String name_p) {
    SecurityNeeds securityNeeds = createSecurityNeeds();
    securityNeeds.setName(name_p);
    return securityNeeds;
  }

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public TrustBoundaryStorage createTrustBoundaryStorage(String name_p) {
    TrustBoundaryStorage trustBoundaryStorage = createTrustBoundaryStorage();
    trustBoundaryStorage.setName(name_p);
    return trustBoundaryStorage;
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

  /**
   * Creates class and sets its name (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p
   *          : default name of created element
   * @generated
   */
  public CybersecurityConfiguration createCybersecurityConfiguration(String name_p) {
    CybersecurityConfiguration cybersecurityConfiguration = createCybersecurityConfiguration();
    cybersecurityConfiguration.setName(name_p);
    return cybersecurityConfiguration;
  }

  /**
   * Creates class and sets its name
   * (This method comes from a customization of the standard EMF generator)
   *
   * @param name_p : default name of created element
   * @generated
   */
  public EnterprisePrimaryAsset createEnterprisePrimaryAsset(String name_p) {
    EnterprisePrimaryAsset enterprisePrimaryAsset = createEnterprisePrimaryAsset();
    enterprisePrimaryAsset.setName(name_p);
    return enterprisePrimaryAsset;
  }

  // begin-capella-code

  // end-capella-code
} // CybersecurityFactoryImpl