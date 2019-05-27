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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polarsys.capella.common.data.activity.ActivityPackage;
import org.polarsys.capella.common.data.behavior.BehaviorPackage;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.core.data.capellacommon.CapellacommonPackage;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.ctx.CtxPackage;
import org.polarsys.capella.core.data.epbs.EpbsPackage;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.interaction.InteractionPackage;
import org.polarsys.capella.core.data.la.LaPackage;
import org.polarsys.capella.core.data.oa.OaPackage;
import org.polarsys.capella.core.data.pa.PaPackage;
import org.polarsys.capella.core.data.requirement.RequirementPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.ThreatKind;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.emde.model.EmdePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CybersecurityPackageImpl extends EPackageImpl implements CybersecurityPackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass cybersecurityPkgEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass threatEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass threatInvolvementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass functionStorageEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass threatApplicationEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass primaryAssetStorageEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass securityNeedsEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass trustBoundaryStorageEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass primaryAssetEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass functionalPrimaryAssetEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass informationPrimaryAssetEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass primaryAssetMemberEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EEnum threatKindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
   * EPackage.Registry} by the package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
   * performs initialization of the package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CybersecurityPackageImpl() {
    super(eNS_URI, CybersecurityFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>
   * This method is used to initialize {@link CybersecurityPackage#eINSTANCE} when that field is accessed. Clients
   * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CybersecurityPackage init() {
    if (isInited)
      return (CybersecurityPackage) EPackage.Registry.INSTANCE.getEPackage(CybersecurityPackage.eNS_URI);

    // Obtain or create and register package
    CybersecurityPackageImpl theCybersecurityPackage = (CybersecurityPackageImpl) (EPackage.Registry.INSTANCE
        .get(eNS_URI) instanceof CybersecurityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
            : new CybersecurityPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EmdePackage.eINSTANCE.eClass();
    CapellacorePackage.eINSTANCE.eClass();
    OaPackage.eINSTANCE.eClass();
    CtxPackage.eINSTANCE.eClass();
    LaPackage.eINSTANCE.eClass();
    PaPackage.eINSTANCE.eClass();
    EpbsPackage.eINSTANCE.eClass();
    RequirementPackage.eINSTANCE.eClass();
    CapellacommonPackage.eINSTANCE.eClass();
    InformationPackage.eINSTANCE.eClass();
    CsPackage.eINSTANCE.eClass();
    FaPackage.eINSTANCE.eClass();
    InteractionPackage.eINSTANCE.eClass();
    ModellingcorePackage.eINSTANCE.eClass();
    ActivityPackage.eINSTANCE.eClass();
    BehaviorPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCybersecurityPackage.createPackageContents();

    // Initialize created meta-data
    theCybersecurityPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCybersecurityPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CybersecurityPackage.eNS_URI, theCybersecurityPackage);
    return theCybersecurityPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getCybersecurityPkg() {
    return cybersecurityPkgEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getCybersecurityPkg_OwnedThreats() {
    return (EReference) cybersecurityPkgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getCybersecurityPkg_OwnedCybersecurityPkgs() {
    return (EReference) cybersecurityPkgEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getCybersecurityPkg_OwnedPrimaryAssets() {
    return (EReference) cybersecurityPkgEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getThreat() {
    return threatEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getThreat_AddressedBy() {
    return (EReference) threatEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getThreat_ThreatKind() {
    return (EAttribute) threatEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getThreat_Level() {
    return (EAttribute) threatEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getThreat_Rationale() {
    return (EAttribute) threatEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getThreatInvolvement() {
    return threatInvolvementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getThreatInvolvement_Actor() {
    return (EReference) threatInvolvementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getThreatInvolvement_Threat() {
    return (EReference) threatInvolvementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getFunctionStorage() {
    return functionStorageEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getFunctionStorage_ExchangedItems() {
    return (EReference) functionStorageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getFunctionStorage_DataStorage() {
    return (EAttribute) functionStorageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getFunctionStorage_RemanentData() {
    return (EAttribute) functionStorageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getThreatApplication() {
    return threatApplicationEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getThreatApplication_Threat() {
    return (EReference) threatApplicationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getThreatApplication_Asset() {
    return (EReference) threatApplicationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getPrimaryAssetStorage() {
    return primaryAssetStorageEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getSecurityNeeds() {
    return securityNeedsEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getSecurityNeeds_Confidentiality() {
    return (EAttribute) securityNeedsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getSecurityNeeds_Integrity() {
    return (EAttribute) securityNeedsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getSecurityNeeds_Availability() {
    return (EAttribute) securityNeedsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getSecurityNeeds_Traceability() {
    return (EAttribute) securityNeedsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getTrustBoundaryStorage() {
    return trustBoundaryStorageEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getTrustBoundaryStorage_ThreatSource() {
    return (EAttribute) trustBoundaryStorageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getTrustBoundaryStorage_ThreatSourceProfile() {
    return (EAttribute) trustBoundaryStorageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getTrustBoundaryStorage_Trusted() {
    return (EAttribute) trustBoundaryStorageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getTrustBoundaryStorage_Rationale() {
    return (EAttribute) trustBoundaryStorageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getPrimaryAsset() {
    return primaryAssetEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getPrimaryAsset_OwnedSecurityNeeds() {
    return (EReference) primaryAssetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getPrimaryAsset_OwnedThreatApplications() {
    return (EReference) primaryAssetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getPrimaryAsset_OwnedMembers() {
    return (EReference) primaryAssetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getFunctionalPrimaryAsset() {
    return functionalPrimaryAssetEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getFunctionalPrimaryAsset_Functions() {
    return (EReference) functionalPrimaryAssetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getInformationPrimaryAsset() {
    return informationPrimaryAssetEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getInformationPrimaryAsset_ExchangeItems() {
    return (EReference) informationPrimaryAssetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getPrimaryAssetMember() {
    return primaryAssetMemberEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getPrimaryAssetMember_Asset() {
    return (EReference) primaryAssetMemberEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getPrimaryAssetMember_Member() {
    return (EReference) primaryAssetMemberEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EEnum getThreatKind() {
    return threatKindEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public CybersecurityFactory getCybersecurityFactory() {
    return (CybersecurityFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but its
   * first. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void createPackageContents() {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    cybersecurityPkgEClass = createEClass(CYBERSECURITY_PKG);
    createEReference(cybersecurityPkgEClass, CYBERSECURITY_PKG__OWNED_THREATS);
    createEReference(cybersecurityPkgEClass, CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS);
    createEReference(cybersecurityPkgEClass, CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS);

    threatEClass = createEClass(THREAT);
    createEReference(threatEClass, THREAT__ADDRESSED_BY);
    createEAttribute(threatEClass, THREAT__THREAT_KIND);
    createEAttribute(threatEClass, THREAT__LEVEL);
    createEAttribute(threatEClass, THREAT__RATIONALE);

    threatInvolvementEClass = createEClass(THREAT_INVOLVEMENT);
    createEReference(threatInvolvementEClass, THREAT_INVOLVEMENT__ACTOR);
    createEReference(threatInvolvementEClass, THREAT_INVOLVEMENT__THREAT);

    functionStorageEClass = createEClass(FUNCTION_STORAGE);
    createEReference(functionStorageEClass, FUNCTION_STORAGE__EXCHANGED_ITEMS);
    createEAttribute(functionStorageEClass, FUNCTION_STORAGE__DATA_STORAGE);
    createEAttribute(functionStorageEClass, FUNCTION_STORAGE__REMANENT_DATA);

    threatApplicationEClass = createEClass(THREAT_APPLICATION);
    createEReference(threatApplicationEClass, THREAT_APPLICATION__THREAT);
    createEReference(threatApplicationEClass, THREAT_APPLICATION__ASSET);

    primaryAssetStorageEClass = createEClass(PRIMARY_ASSET_STORAGE);

    securityNeedsEClass = createEClass(SECURITY_NEEDS);
    createEAttribute(securityNeedsEClass, SECURITY_NEEDS__CONFIDENTIALITY);
    createEAttribute(securityNeedsEClass, SECURITY_NEEDS__INTEGRITY);
    createEAttribute(securityNeedsEClass, SECURITY_NEEDS__AVAILABILITY);
    createEAttribute(securityNeedsEClass, SECURITY_NEEDS__TRACEABILITY);

    trustBoundaryStorageEClass = createEClass(TRUST_BOUNDARY_STORAGE);
    createEAttribute(trustBoundaryStorageEClass, TRUST_BOUNDARY_STORAGE__THREAT_SOURCE);
    createEAttribute(trustBoundaryStorageEClass, TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE);
    createEAttribute(trustBoundaryStorageEClass, TRUST_BOUNDARY_STORAGE__TRUSTED);
    createEAttribute(trustBoundaryStorageEClass, TRUST_BOUNDARY_STORAGE__RATIONALE);

    primaryAssetEClass = createEClass(PRIMARY_ASSET);
    createEReference(primaryAssetEClass, PRIMARY_ASSET__OWNED_SECURITY_NEEDS);
    createEReference(primaryAssetEClass, PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS);
    createEReference(primaryAssetEClass, PRIMARY_ASSET__OWNED_MEMBERS);

    functionalPrimaryAssetEClass = createEClass(FUNCTIONAL_PRIMARY_ASSET);
    createEReference(functionalPrimaryAssetEClass, FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS);

    informationPrimaryAssetEClass = createEClass(INFORMATION_PRIMARY_ASSET);
    createEReference(informationPrimaryAssetEClass, INFORMATION_PRIMARY_ASSET__EXCHANGE_ITEMS);

    primaryAssetMemberEClass = createEClass(PRIMARY_ASSET_MEMBER);
    createEReference(primaryAssetMemberEClass, PRIMARY_ASSET_MEMBER__ASSET);
    createEReference(primaryAssetMemberEClass, PRIMARY_ASSET_MEMBER__MEMBER);

    // Create enums
    threatKindEEnum = createEEnum(THREAT_KIND);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
   * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    CapellacorePackage theCapellacorePackage = (CapellacorePackage) EPackage.Registry.INSTANCE
        .getEPackage(CapellacorePackage.eNS_URI);
    EmdePackage theEmdePackage = (EmdePackage) EPackage.Registry.INSTANCE.getEPackage(EmdePackage.eNS_URI);
    CsPackage theCsPackage = (CsPackage) EPackage.Registry.INSTANCE.getEPackage(CsPackage.eNS_URI);
    ModellingcorePackage theModellingcorePackage = (ModellingcorePackage) EPackage.Registry.INSTANCE
        .getEPackage(ModellingcorePackage.eNS_URI);
    InformationPackage theInformationPackage = (InformationPackage) EPackage.Registry.INSTANCE
        .getEPackage(InformationPackage.eNS_URI);
    FaPackage theFaPackage = (FaPackage) EPackage.Registry.INSTANCE.getEPackage(FaPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    cybersecurityPkgEClass.getESuperTypes().add(theCapellacorePackage.getNamedElement());
    cybersecurityPkgEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    threatEClass.getESuperTypes().add(theCapellacorePackage.getNamedElement());
    threatInvolvementEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());
    threatInvolvementEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    functionStorageEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());
    functionStorageEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    threatApplicationEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());
    threatApplicationEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    primaryAssetStorageEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());
    primaryAssetStorageEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    securityNeedsEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());
    securityNeedsEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    trustBoundaryStorageEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());
    trustBoundaryStorageEClass.getESuperTypes().add(theEmdePackage.getElementExtension());
    primaryAssetEClass.getESuperTypes().add(theCapellacorePackage.getNamedElement());
    functionalPrimaryAssetEClass.getESuperTypes().add(this.getPrimaryAsset());
    informationPrimaryAssetEClass.getESuperTypes().add(this.getPrimaryAsset());
    primaryAssetMemberEClass.getESuperTypes().add(theModellingcorePackage.getModelElement());

    // Initialize classes and features; add operations and parameters
    initEClass(cybersecurityPkgEClass, CybersecurityPkg.class, "CybersecurityPkg", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCybersecurityPkg_OwnedThreats(), this.getThreat(), null, "ownedThreats", null, 0, -1, //$NON-NLS-1$
        CybersecurityPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCybersecurityPkg_OwnedCybersecurityPkgs(), this.getCybersecurityPkg(), null,
        "ownedCybersecurityPkgs", null, 0, -1, CybersecurityPkg.class, !IS_TRANSIENT, !IS_VOLATILE, //$NON-NLS-1$
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCybersecurityPkg_OwnedPrimaryAssets(), this.getPrimaryAsset(), null, "ownedPrimaryAssets", //$NON-NLS-1$
        null, 0, -1, CybersecurityPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(threatEClass, Threat.class, "Threat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(getThreat_AddressedBy(), theCsPackage.getComponent(), null, "addressedBy", null, 0, -1, //$NON-NLS-1$
        Threat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThreat_ThreatKind(), this.getThreatKind(), "threatKind", null, 0, 1, Threat.class, //$NON-NLS-1$
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThreat_Level(), ecorePackage.getEInt(), "level", null, 0, 1, Threat.class, !IS_TRANSIENT, //$NON-NLS-1$
        !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThreat_Rationale(), ecorePackage.getEString(), "rationale", null, 0, 1, Threat.class, //$NON-NLS-1$
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(threatInvolvementEClass, ThreatInvolvement.class, "ThreatInvolvement", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThreatInvolvement_Actor(), theCsPackage.getAbstractActor(), null, "actor", null, 0, 1, //$NON-NLS-1$
        ThreatInvolvement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThreatInvolvement_Threat(), this.getThreat(), null, "threat", null, 0, 1, //$NON-NLS-1$
        ThreatInvolvement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionStorageEClass, FunctionStorage.class, "FunctionStorage", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionStorage_ExchangedItems(), theInformationPackage.getExchangeItem(), null, "exchangedItems", //$NON-NLS-1$
        null, 0, -1, FunctionStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionStorage_DataStorage(), ecorePackage.getEBoolean(), "dataStorage", null, 0, 1, //$NON-NLS-1$
        FunctionStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionStorage_RemanentData(), ecorePackage.getEBoolean(), "remanentData", null, 0, 1, //$NON-NLS-1$
        FunctionStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);

    initEClass(threatApplicationEClass, ThreatApplication.class, "ThreatApplication", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThreatApplication_Threat(), this.getThreat(), null, "threat", null, 0, 1, //$NON-NLS-1$
        ThreatApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThreatApplication_Asset(), this.getPrimaryAsset(), null, "asset", null, 0, 1, //$NON-NLS-1$
        ThreatApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primaryAssetStorageEClass, PrimaryAssetStorage.class, "PrimaryAssetStorage", !IS_ABSTRACT, //$NON-NLS-1$
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(securityNeedsEClass, SecurityNeeds.class, "SecurityNeeds", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSecurityNeeds_Confidentiality(), ecorePackage.getEInt(), "confidentiality", null, 0, 1, //$NON-NLS-1$
        SecurityNeeds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getSecurityNeeds_Integrity(), ecorePackage.getEInt(), "integrity", null, 0, 1, //$NON-NLS-1$
        SecurityNeeds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getSecurityNeeds_Availability(), ecorePackage.getEInt(), "availability", null, 0, 1, //$NON-NLS-1$
        SecurityNeeds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getSecurityNeeds_Traceability(), ecorePackage.getEInt(), "traceability", null, 0, 1, //$NON-NLS-1$
        SecurityNeeds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(trustBoundaryStorageEClass, TrustBoundaryStorage.class, "TrustBoundaryStorage", !IS_ABSTRACT, //$NON-NLS-1$
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrustBoundaryStorage_ThreatSource(), ecorePackage.getEBoolean(), "threatSource", null, 0, 1, //$NON-NLS-1$
        TrustBoundaryStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrustBoundaryStorage_ThreatSourceProfile(), ecorePackage.getEInt(), "threatSourceProfile", //$NON-NLS-1$
        null, 0, 1, TrustBoundaryStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrustBoundaryStorage_Trusted(), ecorePackage.getEBoolean(), "trusted", "true", 0, 1, //$NON-NLS-1$//$NON-NLS-2$
        TrustBoundaryStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTrustBoundaryStorage_Rationale(), ecorePackage.getEString(), "rationale", null, 0, 1, //$NON-NLS-1$
        TrustBoundaryStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);

    initEClass(primaryAssetEClass, PrimaryAsset.class, "PrimaryAsset", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrimaryAsset_OwnedSecurityNeeds(), this.getSecurityNeeds(), null, "ownedSecurityNeeds", null, //$NON-NLS-1$
        0, 1, PrimaryAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryAsset_OwnedThreatApplications(), this.getThreatApplication(), null,
        "ownedThreatApplications", null, 0, -1, PrimaryAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryAsset_OwnedMembers(), this.getPrimaryAssetMember(), null, "ownedMembers", null, 0, -1, //$NON-NLS-1$
        PrimaryAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionalPrimaryAssetEClass, FunctionalPrimaryAsset.class, "FunctionalPrimaryAsset", !IS_ABSTRACT, //$NON-NLS-1$
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionalPrimaryAsset_Functions(), theFaPackage.getAbstractFunction(), null, "functions", //$NON-NLS-1$
        null, 0, -1, FunctionalPrimaryAsset.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
        IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(informationPrimaryAssetEClass, InformationPrimaryAsset.class, "InformationPrimaryAsset", //$NON-NLS-1$
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInformationPrimaryAsset_ExchangeItems(), theInformationPackage.getExchangeItem(), null,
        "exchangeItems", null, 0, -1, InformationPrimaryAsset.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, //$NON-NLS-1$
        !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(primaryAssetMemberEClass, PrimaryAssetMember.class, "PrimaryAssetMember", !IS_ABSTRACT, //$NON-NLS-1$
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrimaryAssetMember_Asset(), this.getPrimaryAsset(), null, "asset", null, 0, 1, //$NON-NLS-1$
        PrimaryAssetMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryAssetMember_Member(), theModellingcorePackage.getModelElement(), null, "member", null, //$NON-NLS-1$
        0, 1, PrimaryAssetMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(threatKindEEnum, ThreatKind.class, "ThreatKind"); //$NON-NLS-1$
    addEEnumLiteral(threatKindEEnum, ThreatKind.EAVESDROPPING);
    addEEnumLiteral(threatKindEEnum, ThreatKind.THEFT_AND_DATA_ALTERATION);
    addEEnumLiteral(threatKindEEnum, ThreatKind.DENIAL_OF_SERVICE);
    addEEnumLiteral(threatKindEEnum, ThreatKind.INTRUSION);
    addEEnumLiteral(threatKindEEnum, ThreatKind.TAMPERING);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.polarsys.org/kitalpha/emde/1.0.0/constraint
    createConstraintAnnotations();
    // http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping
    createConstraintMappingAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.polarsys.org/kitalpha/emde/1.0.0/constraint</b>. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void createConstraintAnnotations() {
    String source = "http://www.polarsys.org/kitalpha/emde/1.0.0/constraint"; //$NON-NLS-1$
    addAnnotation(cybersecurityPkgEClass, source,
        new String[] { "ExtendedElement", " http://www.polarsys.org/capella/core/cs/1.4.0#//BlockArchitecture" //$NON-NLS-1$ //$NON-NLS-2$
        });
    addAnnotation(threatInvolvementEClass, source,
        new String[] { "ExtendedElement", " http://www.polarsys.org/capella/core/cs/1.4.0#//AbstractActor" //$NON-NLS-1$ //$NON-NLS-2$
        });
    addAnnotation(functionStorageEClass, source,
        new String[] { "ExtendedElement", " http://www.polarsys.org/capella/core/fa/1.4.0#//AbstractFunction" //$NON-NLS-1$ //$NON-NLS-2$
        });
    addAnnotation(primaryAssetStorageEClass, source, new String[] { "ExtendedElement", //$NON-NLS-1$
        " http://www.polarsys.org/capella/common/behavior/1.4.0#//AbstractEvent" //$NON-NLS-1$
    });
    addAnnotation(securityNeedsEClass, source, new String[] { "ExtendedElement", //$NON-NLS-1$
        " http://www.polarsys.org/capella/common/behavior/1.4.0#//AbstractEvent" //$NON-NLS-1$
    });
    addAnnotation(trustBoundaryStorageEClass, source,
        new String[] { "ExtendedElement", " http://www.polarsys.org/capella/core/cs/1.4.0#//Component" //$NON-NLS-1$ //$NON-NLS-2$
        });
  }

  /**
   * Initializes the annotations for <b>http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping</b>. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void createConstraintMappingAnnotations() {
    String source = "http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping"; //$NON-NLS-1$
    addAnnotation(cybersecurityPkgEClass, source, new String[] { "Mapping", //$NON-NLS-1$
        " platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//BlockArchitecture" //$NON-NLS-1$
    });
    addAnnotation(threatInvolvementEClass, source, new String[] { "Mapping", //$NON-NLS-1$
        " platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//AbstractActor" //$NON-NLS-1$
    });
    addAnnotation(functionStorageEClass, source, new String[] { "Mapping", //$NON-NLS-1$
        " platform:/plugin/org.polarsys.capella.core.data.gen/model/FunctionalAnalysis.ecore#//AbstractFunction" //$NON-NLS-1$
    });
    addAnnotation(primaryAssetStorageEClass, source, new String[] { "Mapping", //$NON-NLS-1$
        " platform:/plugin/org.polarsys.capella.common.data.behavior.gen/model/Behavior.ecore#//AbstractEvent" //$NON-NLS-1$
    });
    addAnnotation(securityNeedsEClass, source, new String[] { "Mapping", //$NON-NLS-1$
        " platform:/plugin/org.polarsys.capella.common.data.behavior.gen/model/Behavior.ecore#//AbstractEvent" //$NON-NLS-1$
    });
    addAnnotation(trustBoundaryStorageEClass, source, new String[] { "Mapping", //$NON-NLS-1$
        " platform:/plugin/org.polarsys.capella.core.data.gen/model/CompositeStructure.ecore#//Component\r\n" //$NON-NLS-1$
    });
  }

} // CybersecurityPackageImpl
