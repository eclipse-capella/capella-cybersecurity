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

package org.polarsys.capella.cybersecurity.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.AbstractNamedElement;
import org.polarsys.capella.common.data.modellingcore.AbstractRelationship;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.data.modellingcore.PublishableElement;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.InvolverElement;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.data.capellacore.Namespace;
import org.polarsys.capella.core.data.capellacore.Relationship;
import org.polarsys.capella.core.data.capellacore.Structure;
import org.polarsys.capella.core.data.fa.AbstractFunctionalChainContainer;
import org.polarsys.capella.core.data.interaction.AbstractCapability;
import org.polarsys.capella.cybersecurity.model.*;
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
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.emde.model.Element;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage
 * @generated
 */
public class CybersecurityAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static CybersecurityPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public CybersecurityAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = CybersecurityPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected CybersecuritySwitch<Adapter> modelSwitch = new CybersecuritySwitch<Adapter>() {
    @Override
    public Adapter caseCybersecurityPkg(CybersecurityPkg object) {
      return createCybersecurityPkgAdapter();
    }

    @Override
    public Adapter caseThreat(Threat object) {
      return createThreatAdapter();
    }

    @Override
    public Adapter caseThreatInvolvement(ThreatInvolvement object) {
      return createThreatInvolvementAdapter();
    }

    @Override
    public Adapter caseFunctionStorage(FunctionStorage object) {
      return createFunctionStorageAdapter();
    }

    @Override
    public Adapter caseThreatApplication(ThreatApplication object) {
      return createThreatApplicationAdapter();
    }

    @Override
    public Adapter casePrimaryAssetStorage(PrimaryAssetStorage object) {
      return createPrimaryAssetStorageAdapter();
    }

    @Override
    public Adapter caseSecurityNeeds(SecurityNeeds object) {
      return createSecurityNeedsAdapter();
    }

    @Override
    public Adapter caseTrustBoundaryStorage(TrustBoundaryStorage object) {
      return createTrustBoundaryStorageAdapter();
    }

    @Override
    public Adapter casePrimaryAsset(PrimaryAsset object) {
      return createPrimaryAssetAdapter();
    }

    @Override
    public Adapter caseFunctionalPrimaryAsset(FunctionalPrimaryAsset object) {
      return createFunctionalPrimaryAssetAdapter();
    }

    @Override
    public Adapter caseInformationPrimaryAsset(InformationPrimaryAsset object) {
      return createInformationPrimaryAssetAdapter();
    }

    @Override
    public Adapter casePrimaryAssetMember(PrimaryAssetMember object) {
      return createPrimaryAssetMemberAdapter();
    }

    @Override
    public Adapter caseCybersecurityConfiguration(CybersecurityConfiguration object) {
      return createCybersecurityConfigurationAdapter();
    }

    @Override
    public Adapter caseEnterprisePrimaryAsset(EnterprisePrimaryAsset object) {
      return createEnterprisePrimaryAssetAdapter();
    }

    @Override
    public Adapter caseThreatSourceUse(ThreatSourceUse object) {
      return createThreatSourceUseAdapter();
    }

    @Override
    public Adapter caseElement(Element object) {
      return createElementAdapter();
    }

    @Override
    public Adapter caseExtensibleElement(ExtensibleElement object) {
      return createExtensibleElementAdapter();
    }

    @Override
    public Adapter caseModelElement(ModelElement object) {
      return createModelElementAdapter();
    }

    @Override
    public Adapter caseAbstractNamedElement(AbstractNamedElement object) {
      return createAbstractNamedElementAdapter();
    }

    @Override
    public Adapter caseTraceableElement(TraceableElement object) {
      return createTraceableElementAdapter();
    }

    @Override
    public Adapter casePublishableElement(PublishableElement object) {
      return createPublishableElementAdapter();
    }

    @Override
    public Adapter caseCapellaElement(CapellaElement object) {
      return createCapellaElementAdapter();
    }

    @Override
    public Adapter caseNamedElement(NamedElement object) {
      return createNamedElementAdapter();
    }

    @Override
    public Adapter caseElementExtension(ElementExtension object) {
      return createElementExtensionAdapter();
    }

    @Override
    public Adapter caseNamespace(Namespace object) {
      return createNamespaceAdapter();
    }

    @Override
    public Adapter caseStructure(Structure object) {
      return createStructureAdapter();
    }

    @Override
    public Adapter caseInvolverElement(InvolverElement object) {
      return createInvolverElementAdapter();
    }

    @Override
    public Adapter caseAbstractFunctionalChainContainer(AbstractFunctionalChainContainer object) {
      return createAbstractFunctionalChainContainerAdapter();
    }

    @Override
    public Adapter caseAbstractCapability(AbstractCapability object) {
      return createAbstractCapabilityAdapter();
    }

    @Override
    public Adapter caseAbstractRelationship(AbstractRelationship object) {
      return createAbstractRelationshipAdapter();
    }

    @Override
    public Adapter caseRelationship(Relationship object) {
      return createRelationshipAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg <em>Pkg</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPkg
   * @generated
   */
  public Adapter createCybersecurityPkgAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.Threat <em>Threat</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.Threat
   * @generated
   */
  public Adapter createThreatAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement <em>Threat Involvement</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.ThreatInvolvement
   * @generated
   */
  public Adapter createThreatInvolvementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage <em>Function Storage</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.FunctionStorage
   * @generated
   */
  public Adapter createFunctionStorageAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.ThreatApplication <em>Threat Application</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.ThreatApplication
   * @generated
   */
  public Adapter createThreatApplicationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage <em>Primary Asset Storage</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage
   * @generated
   */
  public Adapter createPrimaryAssetStorageAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds <em>Security Needs</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds
   * @generated
   */
  public Adapter createSecurityNeedsAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage <em>Trust Boundary Storage</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage
   * @generated
   */
  public Adapter createTrustBoundaryStorageAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset <em>Primary Asset</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAsset
   * @generated
   */
  public Adapter createPrimaryAssetAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset <em>Functional Primary Asset</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset
   * @generated
   */
  public Adapter createFunctionalPrimaryAssetAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset <em>Information Primary Asset</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset
   * @generated
   */
  public Adapter createInformationPrimaryAssetAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember <em>Primary Asset Member</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAssetMember
   * @generated
   */
  public Adapter createPrimaryAssetMemberAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration <em>Configuration</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration
   * @generated
   */
  public Adapter createCybersecurityConfigurationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset <em>Enterprise Primary Asset</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset
   * @generated
   */
  public Adapter createEnterprisePrimaryAssetAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse <em>Threat Source Use</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.cybersecurity.model.ThreatSourceUse
   * @generated
   */
  public Adapter createThreatSourceUseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.model.Element <em>Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.kitalpha.emde.model.Element
   * @generated
   */
  public Adapter createElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.model.ExtensibleElement <em>Extensible Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.kitalpha.emde.model.ExtensibleElement
   * @generated
   */
  public Adapter createExtensibleElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.common.data.modellingcore.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.common.data.modellingcore.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.common.data.modellingcore.AbstractNamedElement <em>Abstract Named Element</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.common.data.modellingcore.AbstractNamedElement
   * @generated
   */
  public Adapter createAbstractNamedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.common.data.modellingcore.TraceableElement <em>Traceable Element</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.common.data.modellingcore.TraceableElement
   * @generated
   */
  public Adapter createTraceableElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.common.data.modellingcore.PublishableElement <em>Publishable Element</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.common.data.modellingcore.PublishableElement
   * @generated
   */
  public Adapter createPublishableElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.capellacore.CapellaElement <em>Capella Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.capellacore.CapellaElement
   * @generated
   */
  public Adapter createCapellaElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.capellacore.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.capellacore.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.model.ElementExtension <em>Element Extension</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.kitalpha.emde.model.ElementExtension
   * @generated
   */
  public Adapter createElementExtensionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.capellacore.Namespace <em>Namespace</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.capellacore.Namespace
   * @generated
   */
  public Adapter createNamespaceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.capellacore.Structure <em>Structure</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.capellacore.Structure
   * @generated
   */
  public Adapter createStructureAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.capellacore.InvolverElement <em>Involver Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.capellacore.InvolverElement
   * @generated
   */
  public Adapter createInvolverElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.fa.AbstractFunctionalChainContainer <em>Abstract Functional Chain Container</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.fa.AbstractFunctionalChainContainer
   * @generated
   */
  public Adapter createAbstractFunctionalChainContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.interaction.AbstractCapability <em>Abstract Capability</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.interaction.AbstractCapability
   * @generated
   */
  public Adapter createAbstractCapabilityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link org.polarsys.capella.common.data.modellingcore.AbstractRelationship <em>Abstract Relationship</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.polarsys.capella.common.data.modellingcore.AbstractRelationship
   * @generated
   */
  public Adapter createAbstractRelationshipAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.polarsys.capella.core.data.capellacore.Relationship <em>Relationship</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.polarsys.capella.core.data.capellacore.Relationship
   * @generated
   */
  public Adapter createRelationshipAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // CybersecurityAdapterFactory
