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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polarsys.capella.common.data.modellingcore.AbstractNamedElement;
import org.polarsys.capella.common.data.modellingcore.AbstractRelationship;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.data.modellingcore.PublishableElement;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.data.capellacore.Relationship;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage
 * @generated
 */
public class CybersecuritySwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static CybersecurityPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public CybersecuritySwitch() {
    if (modelPackage == null) {
      modelPackage = CybersecurityPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case CybersecurityPackage.CYBERSECURITY_PKG: {
      CybersecurityPkg cybersecurityPkg = (CybersecurityPkg) theEObject;
      T result = caseCybersecurityPkg(cybersecurityPkg);
      if (result == null)
        result = caseNamedElement(cybersecurityPkg);
      if (result == null)
        result = caseElementExtension(cybersecurityPkg);
      if (result == null)
        result = caseAbstractNamedElement(cybersecurityPkg);
      if (result == null)
        result = caseCapellaElement(cybersecurityPkg);
      if (result == null)
        result = caseTraceableElement(cybersecurityPkg);
      if (result == null)
        result = casePublishableElement(cybersecurityPkg);
      if (result == null)
        result = caseModelElement(cybersecurityPkg);
      if (result == null)
        result = caseExtensibleElement(cybersecurityPkg);
      if (result == null)
        result = caseElement(cybersecurityPkg);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.THREAT: {
      Threat threat = (Threat) theEObject;
      T result = caseThreat(threat);
      if (result == null)
        result = caseNamedElement(threat);
      if (result == null)
        result = caseAbstractNamedElement(threat);
      if (result == null)
        result = caseCapellaElement(threat);
      if (result == null)
        result = caseTraceableElement(threat);
      if (result == null)
        result = casePublishableElement(threat);
      if (result == null)
        result = caseModelElement(threat);
      if (result == null)
        result = caseExtensibleElement(threat);
      if (result == null)
        result = caseElement(threat);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.THREAT_INVOLVEMENT: {
      ThreatInvolvement threatInvolvement = (ThreatInvolvement) theEObject;
      T result = caseThreatInvolvement(threatInvolvement);
      if (result == null)
        result = caseRelationship(threatInvolvement);
      if (result == null)
        result = caseElementExtension(threatInvolvement);
      if (result == null)
        result = caseAbstractRelationship(threatInvolvement);
      if (result == null)
        result = caseCapellaElement(threatInvolvement);
      if (result == null)
        result = caseTraceableElement(threatInvolvement);
      if (result == null)
        result = casePublishableElement(threatInvolvement);
      if (result == null)
        result = caseModelElement(threatInvolvement);
      if (result == null)
        result = caseExtensibleElement(threatInvolvement);
      if (result == null)
        result = caseElement(threatInvolvement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.FUNCTION_STORAGE: {
      FunctionStorage functionStorage = (FunctionStorage) theEObject;
      T result = caseFunctionStorage(functionStorage);
      if (result == null)
        result = caseModelElement(functionStorage);
      if (result == null)
        result = caseElementExtension(functionStorage);
      if (result == null)
        result = caseExtensibleElement(functionStorage);
      if (result == null)
        result = caseElement(functionStorage);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.THREAT_APPLICATION: {
      ThreatApplication threatApplication = (ThreatApplication) theEObject;
      T result = caseThreatApplication(threatApplication);
      if (result == null)
        result = caseRelationship(threatApplication);
      if (result == null)
        result = caseElementExtension(threatApplication);
      if (result == null)
        result = caseAbstractRelationship(threatApplication);
      if (result == null)
        result = caseCapellaElement(threatApplication);
      if (result == null)
        result = caseTraceableElement(threatApplication);
      if (result == null)
        result = casePublishableElement(threatApplication);
      if (result == null)
        result = caseModelElement(threatApplication);
      if (result == null)
        result = caseExtensibleElement(threatApplication);
      if (result == null)
        result = caseElement(threatApplication);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.PRIMARY_ASSET_STORAGE: {
      PrimaryAssetStorage primaryAssetStorage = (PrimaryAssetStorage) theEObject;
      T result = casePrimaryAssetStorage(primaryAssetStorage);
      if (result == null)
        result = caseModelElement(primaryAssetStorage);
      if (result == null)
        result = caseElementExtension(primaryAssetStorage);
      if (result == null)
        result = caseExtensibleElement(primaryAssetStorage);
      if (result == null)
        result = caseElement(primaryAssetStorage);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.SECURITY_NEEDS: {
      SecurityNeeds securityNeeds = (SecurityNeeds) theEObject;
      T result = caseSecurityNeeds(securityNeeds);
      if (result == null)
        result = caseModelElement(securityNeeds);
      if (result == null)
        result = caseElementExtension(securityNeeds);
      if (result == null)
        result = caseExtensibleElement(securityNeeds);
      if (result == null)
        result = caseElement(securityNeeds);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE: {
      TrustBoundaryStorage trustBoundaryStorage = (TrustBoundaryStorage) theEObject;
      T result = caseTrustBoundaryStorage(trustBoundaryStorage);
      if (result == null)
        result = caseModelElement(trustBoundaryStorage);
      if (result == null)
        result = caseElementExtension(trustBoundaryStorage);
      if (result == null)
        result = caseExtensibleElement(trustBoundaryStorage);
      if (result == null)
        result = caseElement(trustBoundaryStorage);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.PRIMARY_ASSET: {
      PrimaryAsset primaryAsset = (PrimaryAsset) theEObject;
      T result = casePrimaryAsset(primaryAsset);
      if (result == null)
        result = caseNamedElement(primaryAsset);
      if (result == null)
        result = caseAbstractNamedElement(primaryAsset);
      if (result == null)
        result = caseCapellaElement(primaryAsset);
      if (result == null)
        result = caseTraceableElement(primaryAsset);
      if (result == null)
        result = casePublishableElement(primaryAsset);
      if (result == null)
        result = caseModelElement(primaryAsset);
      if (result == null)
        result = caseExtensibleElement(primaryAsset);
      if (result == null)
        result = caseElement(primaryAsset);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.FUNCTIONAL_PRIMARY_ASSET: {
      FunctionalPrimaryAsset functionalPrimaryAsset = (FunctionalPrimaryAsset) theEObject;
      T result = caseFunctionalPrimaryAsset(functionalPrimaryAsset);
      if (result == null)
        result = casePrimaryAsset(functionalPrimaryAsset);
      if (result == null)
        result = caseNamedElement(functionalPrimaryAsset);
      if (result == null)
        result = caseAbstractNamedElement(functionalPrimaryAsset);
      if (result == null)
        result = caseCapellaElement(functionalPrimaryAsset);
      if (result == null)
        result = caseTraceableElement(functionalPrimaryAsset);
      if (result == null)
        result = casePublishableElement(functionalPrimaryAsset);
      if (result == null)
        result = caseModelElement(functionalPrimaryAsset);
      if (result == null)
        result = caseExtensibleElement(functionalPrimaryAsset);
      if (result == null)
        result = caseElement(functionalPrimaryAsset);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.INFORMATION_PRIMARY_ASSET: {
      InformationPrimaryAsset informationPrimaryAsset = (InformationPrimaryAsset) theEObject;
      T result = caseInformationPrimaryAsset(informationPrimaryAsset);
      if (result == null)
        result = casePrimaryAsset(informationPrimaryAsset);
      if (result == null)
        result = caseNamedElement(informationPrimaryAsset);
      if (result == null)
        result = caseAbstractNamedElement(informationPrimaryAsset);
      if (result == null)
        result = caseCapellaElement(informationPrimaryAsset);
      if (result == null)
        result = caseTraceableElement(informationPrimaryAsset);
      if (result == null)
        result = casePublishableElement(informationPrimaryAsset);
      if (result == null)
        result = caseModelElement(informationPrimaryAsset);
      if (result == null)
        result = caseExtensibleElement(informationPrimaryAsset);
      if (result == null)
        result = caseElement(informationPrimaryAsset);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.PRIMARY_ASSET_MEMBER: {
      PrimaryAssetMember primaryAssetMember = (PrimaryAssetMember) theEObject;
      T result = casePrimaryAssetMember(primaryAssetMember);
      if (result == null)
        result = caseRelationship(primaryAssetMember);
      if (result == null)
        result = caseAbstractRelationship(primaryAssetMember);
      if (result == null)
        result = caseCapellaElement(primaryAssetMember);
      if (result == null)
        result = caseTraceableElement(primaryAssetMember);
      if (result == null)
        result = casePublishableElement(primaryAssetMember);
      if (result == null)
        result = caseModelElement(primaryAssetMember);
      if (result == null)
        result = caseExtensibleElement(primaryAssetMember);
      if (result == null)
        result = caseElement(primaryAssetMember);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case CybersecurityPackage.CYBERSECURITY_CONFIGURATION: {
      CybersecurityConfiguration cybersecurityConfiguration = (CybersecurityConfiguration) theEObject;
      T result = caseCybersecurityConfiguration(cybersecurityConfiguration);
      if (result == null)
        result = caseNamedElement(cybersecurityConfiguration);
      if (result == null)
        result = caseElementExtension(cybersecurityConfiguration);
      if (result == null)
        result = caseAbstractNamedElement(cybersecurityConfiguration);
      if (result == null)
        result = caseCapellaElement(cybersecurityConfiguration);
      if (result == null)
        result = caseTraceableElement(cybersecurityConfiguration);
      if (result == null)
        result = casePublishableElement(cybersecurityConfiguration);
      if (result == null)
        result = caseModelElement(cybersecurityConfiguration);
      if (result == null)
        result = caseExtensibleElement(cybersecurityConfiguration);
      if (result == null)
        result = caseElement(cybersecurityConfiguration);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pkg</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pkg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCybersecurityPkg(CybersecurityPkg object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Threat</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Threat</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThreat(Threat object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Threat Involvement</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Threat Involvement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThreatInvolvement(ThreatInvolvement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Storage</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Storage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionStorage(FunctionStorage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Threat Application</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Threat Application</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThreatApplication(ThreatApplication object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Asset Storage</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Asset Storage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryAssetStorage(PrimaryAssetStorage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Security Needs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Security Needs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecurityNeeds(SecurityNeeds object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trust Boundary Storage</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trust Boundary Storage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrustBoundaryStorage(TrustBoundaryStorage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Asset</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Asset</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryAsset(PrimaryAsset object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Functional Primary Asset</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Functional Primary Asset</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionalPrimaryAsset(FunctionalPrimaryAsset object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Information Primary Asset</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Information Primary Asset</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInformationPrimaryAsset(InformationPrimaryAsset object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Asset Member</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Asset Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryAssetMember(PrimaryAssetMember object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCybersecurityConfiguration(CybersecurityConfiguration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtensibleElement(ExtensibleElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelElement(ModelElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Named Element</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractNamedElement(AbstractNamedElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Traceable Element</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Traceable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceableElement(TraceableElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Publishable Element</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Publishable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePublishableElement(PublishableElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Capella Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Capella Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCapellaElement(CapellaElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Extension</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Extension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementExtension(ElementExtension object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Relationship</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Relationship</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRelationship(AbstractRelationship object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationship(Relationship object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
   * anyway. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} // CybersecuritySwitch
