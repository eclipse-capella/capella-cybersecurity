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

package org.polarsys.capella.cybersecurity.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityFactory
 * @model kind="package"
 * @generated
 */
public interface CybersecurityPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "cybersecurity"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.polarsys.org/capella/cybersecurity/1.0"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "cybersecurity"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  CybersecurityPackage eINSTANCE = org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl.init();

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl <em>Pkg</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getCybersecurityPkg()
   * @generated
   */
  int CYBERSECURITY_PKG = 0;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Owned Threats</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_THREATS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Cybersecurity Pkgs</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Primary Assets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Pkg</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl <em>Threat</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.ThreatImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreat()
   * @generated
   */
  int THREAT = 1;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Addressed By</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__ADDRESSED_BY = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Threat Kind</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__THREAT_KIND = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__LEVEL = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__RATIONALE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Threat</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatInvolvementImpl <em>Threat Involvement</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.ThreatInvolvementImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatInvolvement()
   * @generated
   */
  int THREAT_INVOLVEMENT = 2;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OWNED_EXTENSIONS = CapellacorePackage.RELATIONSHIP__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__ID = CapellacorePackage.RELATIONSHIP__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__SID = CapellacorePackage.RELATIONSHIP__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__CONSTRAINTS = CapellacorePackage.RELATIONSHIP__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OWNED_CONSTRAINTS = CapellacorePackage.RELATIONSHIP__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.RELATIONSHIP__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Realized Flow</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__REALIZED_FLOW = CapellacorePackage.RELATIONSHIP__REALIZED_FLOW;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__INCOMING_TRACES = CapellacorePackage.RELATIONSHIP__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OUTGOING_TRACES = CapellacorePackage.RELATIONSHIP__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__VISIBLE_IN_DOC = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__VISIBLE_IN_LM = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__SUMMARY = CapellacorePackage.RELATIONSHIP__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__DESCRIPTION = CapellacorePackage.RELATIONSHIP__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__REVIEW = CapellacorePackage.RELATIONSHIP__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OWNED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.RELATIONSHIP__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__APPLIED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__STATUS = CapellacorePackage.RELATIONSHIP__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__FEATURES = CapellacorePackage.RELATIONSHIP__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__APPLIED_REQUIREMENTS = CapellacorePackage.RELATIONSHIP__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Component</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__COMPONENT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Threat</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT__THREAT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Threat Involvement</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_INVOLVEMENT_FEATURE_COUNT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl <em>Function Storage</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getFunctionStorage()
   * @generated
   */
  int FUNCTION_STORAGE = 3;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_EXTENSIONS = ModellingcorePackage.MODEL_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__ID = ModellingcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__SID = ModellingcorePackage.MODEL_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_MIGRATED_ELEMENTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Exchanged Items</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__EXCHANGED_ITEMS = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Data Storage</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__DATA_STORAGE = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Remanent Data</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__REMANENT_DATA = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Function Storage</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE_FEATURE_COUNT = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatApplicationImpl <em>Threat Application</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.ThreatApplicationImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatApplication()
   * @generated
   */
  int THREAT_APPLICATION = 4;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OWNED_EXTENSIONS = CapellacorePackage.RELATIONSHIP__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__ID = CapellacorePackage.RELATIONSHIP__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__SID = CapellacorePackage.RELATIONSHIP__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__CONSTRAINTS = CapellacorePackage.RELATIONSHIP__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OWNED_CONSTRAINTS = CapellacorePackage.RELATIONSHIP__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.RELATIONSHIP__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Realized Flow</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__REALIZED_FLOW = CapellacorePackage.RELATIONSHIP__REALIZED_FLOW;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__INCOMING_TRACES = CapellacorePackage.RELATIONSHIP__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OUTGOING_TRACES = CapellacorePackage.RELATIONSHIP__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__VISIBLE_IN_DOC = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__VISIBLE_IN_LM = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__SUMMARY = CapellacorePackage.RELATIONSHIP__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__DESCRIPTION = CapellacorePackage.RELATIONSHIP__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__REVIEW = CapellacorePackage.RELATIONSHIP__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OWNED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.RELATIONSHIP__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__APPLIED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__STATUS = CapellacorePackage.RELATIONSHIP__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__FEATURES = CapellacorePackage.RELATIONSHIP__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__APPLIED_REQUIREMENTS = CapellacorePackage.RELATIONSHIP__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Threat</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__THREAT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Asset</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION__ASSET = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Threat Application</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_APPLICATION_FEATURE_COUNT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetStorageImpl <em>Primary Asset Storage</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetStorageImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getPrimaryAssetStorage()
   * @generated
   */
  int PRIMARY_ASSET_STORAGE = 5;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_EXTENSIONS = ModellingcorePackage.MODEL_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__ID = ModellingcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__SID = ModellingcorePackage.MODEL_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_MIGRATED_ELEMENTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The number of structural features of the '<em>Primary Asset Storage</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE_FEATURE_COUNT = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl <em>Security Needs</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getSecurityNeeds()
   * @generated
   */
  int SECURITY_NEEDS = 6;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_EXTENSIONS = ModellingcorePackage.MODEL_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__ID = ModellingcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__SID = ModellingcorePackage.MODEL_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_MIGRATED_ELEMENTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Confidentiality</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__CONFIDENTIALITY = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Integrity</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__INTEGRITY = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Availability</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__AVAILABILITY = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Traceability</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__TRACEABILITY = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Security Needs</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS_FEATURE_COUNT = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl <em>Trust Boundary Storage</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getTrustBoundaryStorage()
   * @generated
   */
  int TRUST_BOUNDARY_STORAGE = 7;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_EXTENSIONS = ModellingcorePackage.MODEL_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__ID = ModellingcorePackage.MODEL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__SID = ModellingcorePackage.MODEL_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_CONSTRAINTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_MIGRATED_ELEMENTS = ModellingcorePackage.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Threat Source</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__THREAT_SOURCE = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Threat Source Profile</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Trusted</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__TRUSTED = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__RATIONALE = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Trust Boundary Storage</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE_FEATURE_COUNT = ModellingcorePackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl <em>Primary Asset</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getPrimaryAsset()
   * @generated
   */
  int PRIMARY_ASSET = 8;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Owned Threat Applications</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__OWNED_MEMBERS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Primary Asset</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl <em>Functional Primary Asset</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getFunctionalPrimaryAsset()
   * @generated
   */
  int FUNCTIONAL_PRIMARY_ASSET = 9;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_EXTENSIONS = PRIMARY_ASSET__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__ID = PRIMARY_ASSET__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__SID = PRIMARY_ASSET__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__CONSTRAINTS = PRIMARY_ASSET__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_CONSTRAINTS = PRIMARY_ASSET__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS = PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__NAME = PRIMARY_ASSET__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__INCOMING_TRACES = PRIMARY_ASSET__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OUTGOING_TRACES = PRIMARY_ASSET__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__VISIBLE_IN_DOC = PRIMARY_ASSET__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__VISIBLE_IN_LM = PRIMARY_ASSET__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__SUMMARY = PRIMARY_ASSET__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__DESCRIPTION = PRIMARY_ASSET__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__REVIEW = PRIMARY_ASSET__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_PROPERTY_VALUES = PRIMARY_ASSET__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES = PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__APPLIED_PROPERTY_VALUES = PRIMARY_ASSET__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS = PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS = PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__STATUS = PRIMARY_ASSET__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__FEATURES = PRIMARY_ASSET__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__APPLIED_REQUIREMENTS = PRIMARY_ASSET__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Owned Threat Applications</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS = PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS;

  /**
   * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__OWNED_MEMBERS = PRIMARY_ASSET__OWNED_MEMBERS;

  /**
   * The feature id for the '<em><b>Functions</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS = PRIMARY_ASSET_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Functional Primary Asset</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET_FEATURE_COUNT = PRIMARY_ASSET_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.InformationPrimaryAssetImpl <em>Information Primary Asset</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.InformationPrimaryAssetImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getInformationPrimaryAsset()
   * @generated
   */
  int INFORMATION_PRIMARY_ASSET = 10;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_EXTENSIONS = PRIMARY_ASSET__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__ID = PRIMARY_ASSET__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__SID = PRIMARY_ASSET__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__CONSTRAINTS = PRIMARY_ASSET__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_CONSTRAINTS = PRIMARY_ASSET__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS = PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__NAME = PRIMARY_ASSET__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__INCOMING_TRACES = PRIMARY_ASSET__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OUTGOING_TRACES = PRIMARY_ASSET__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__VISIBLE_IN_DOC = PRIMARY_ASSET__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__VISIBLE_IN_LM = PRIMARY_ASSET__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__SUMMARY = PRIMARY_ASSET__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__DESCRIPTION = PRIMARY_ASSET__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__REVIEW = PRIMARY_ASSET__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_PROPERTY_VALUES = PRIMARY_ASSET__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES = PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__APPLIED_PROPERTY_VALUES = PRIMARY_ASSET__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS = PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS = PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__STATUS = PRIMARY_ASSET__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__FEATURES = PRIMARY_ASSET__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__APPLIED_REQUIREMENTS = PRIMARY_ASSET__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Owned Threat Applications</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS = PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS;

  /**
   * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__OWNED_MEMBERS = PRIMARY_ASSET__OWNED_MEMBERS;

  /**
   * The feature id for the '<em><b>Exchange Items</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__EXCHANGE_ITEMS = PRIMARY_ASSET_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Information Primary Asset</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET_FEATURE_COUNT = PRIMARY_ASSET_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetMemberImpl <em>Primary Asset Member</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetMemberImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getPrimaryAssetMember()
   * @generated
   */
  int PRIMARY_ASSET_MEMBER = 11;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OWNED_EXTENSIONS = CapellacorePackage.RELATIONSHIP__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__ID = CapellacorePackage.RELATIONSHIP__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__SID = CapellacorePackage.RELATIONSHIP__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__CONSTRAINTS = CapellacorePackage.RELATIONSHIP__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OWNED_CONSTRAINTS = CapellacorePackage.RELATIONSHIP__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.RELATIONSHIP__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Realized Flow</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__REALIZED_FLOW = CapellacorePackage.RELATIONSHIP__REALIZED_FLOW;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__INCOMING_TRACES = CapellacorePackage.RELATIONSHIP__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OUTGOING_TRACES = CapellacorePackage.RELATIONSHIP__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__VISIBLE_IN_DOC = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__VISIBLE_IN_LM = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__SUMMARY = CapellacorePackage.RELATIONSHIP__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__DESCRIPTION = CapellacorePackage.RELATIONSHIP__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__REVIEW = CapellacorePackage.RELATIONSHIP__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OWNED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.RELATIONSHIP__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__APPLIED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__STATUS = CapellacorePackage.RELATIONSHIP__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__FEATURES = CapellacorePackage.RELATIONSHIP__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__APPLIED_REQUIREMENTS = CapellacorePackage.RELATIONSHIP__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Asset</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__ASSET = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Member</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER__MEMBER = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Primary Asset Member</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_MEMBER_FEATURE_COUNT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.ThreatKind <em>Threat Kind</em>}' enum.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.ThreatKind
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatKind()
   * @generated
   */
  int THREAT_KIND = 12;

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg <em>Pkg</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Pkg</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPkg
   * @generated
   */
  EClass getCybersecurityPkg();

  /**
   * Returns the meta object for the containment reference list
   * '{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedThreats <em>Owned Threats</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Owned Threats</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedThreats()
   * @see #getCybersecurityPkg()
   * @generated
   */
  EReference getCybersecurityPkg_OwnedThreats();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedCybersecurityPkgs <em>Owned Cybersecurity Pkgs</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Cybersecurity Pkgs</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedCybersecurityPkgs()
   * @see #getCybersecurityPkg()
   * @generated
   */
  EReference getCybersecurityPkg_OwnedCybersecurityPkgs();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedPrimaryAssets <em>Owned Primary Assets</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Primary Assets</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPkg#getOwnedPrimaryAssets()
   * @see #getCybersecurityPkg()
   * @generated
   */
  EReference getCybersecurityPkg_OwnedPrimaryAssets();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.Threat <em>Threat</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Threat</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat
   * @generated
   */
  EClass getThreat();

  /**
   * Returns the meta object for the reference list '{@link org.polarsys.capella.cybersecurity.model.Threat#getAddressedBy <em>Addressed By</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Addressed By</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getAddressedBy()
   * @see #getThreat()
   * @generated
   */
  EReference getThreat_AddressedBy();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.capella.cybersecurity.model.Threat#getThreatKind <em>Threat Kind</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Threat Kind</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getThreatKind()
   * @see #getThreat()
   * @generated
   */
  EAttribute getThreat_ThreatKind();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.capella.cybersecurity.model.Threat#getLevel <em>Level</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getLevel()
   * @see #getThreat()
   * @generated
   */
  EAttribute getThreat_Level();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.capella.cybersecurity.model.Threat#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rationale</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getRationale()
   * @see #getThreat()
   * @generated
   */
  EAttribute getThreat_Rationale();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement <em>Threat Involvement</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Threat Involvement</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatInvolvement
   * @generated
   */
  EClass getThreatInvolvement();

  /**
   * Returns the meta object for the reference
   * '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getComponent <em>Component</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference '<em>Component</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getComponent()
   * @see #getThreatInvolvement()
   * @generated
   */
  EReference getThreatInvolvement_Component();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getThreat <em>Threat</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Threat</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatInvolvement#getThreat()
   * @see #getThreatInvolvement()
   * @generated
   */
  EReference getThreatInvolvement_Threat();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage <em>Function Storage</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Storage</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionStorage
   * @generated
   */
  EClass getFunctionStorage();

  /**
   * Returns the meta object for the reference list
   * '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#getExchangedItems <em>Exchanged Items</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Exchanged Items</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionStorage#getExchangedItems()
   * @see #getFunctionStorage()
   * @generated
   */
  EReference getFunctionStorage_ExchangedItems();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#isDataStorage <em>Data Storage</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Data Storage</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionStorage#isDataStorage()
   * @see #getFunctionStorage()
   * @generated
   */
  EAttribute getFunctionStorage_DataStorage();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.FunctionStorage#isRemanentData <em>Remanent Data</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Remanent Data</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionStorage#isRemanentData()
   * @see #getFunctionStorage()
   * @generated
   */
  EAttribute getFunctionStorage_RemanentData();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.ThreatApplication <em>Threat Application</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Threat Application</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatApplication
   * @generated
   */
  EClass getThreatApplication();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.ThreatApplication#getThreat <em>Threat</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Threat</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatApplication#getThreat()
   * @see #getThreatApplication()
   * @generated
   */
  EReference getThreatApplication_Threat();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.ThreatApplication#getAsset <em>Asset</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Asset</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatApplication#getAsset()
   * @see #getThreatApplication()
   * @generated
   */
  EReference getThreatApplication_Asset();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage <em>Primary Asset Storage</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Asset Storage</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage
   * @generated
   */
  EClass getPrimaryAssetStorage();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds <em>Security Needs</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Security Needs</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds
   * @generated
   */
  EClass getSecurityNeeds();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentiality <em>Confidentiality</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Confidentiality</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentiality()
   * @see #getSecurityNeeds()
   * @generated
   */
  EAttribute getSecurityNeeds_Confidentiality();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrity <em>Integrity</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Integrity</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrity()
   * @see #getSecurityNeeds()
   * @generated
   */
  EAttribute getSecurityNeeds_Integrity();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailability <em>Availability</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Availability</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailability()
   * @see #getSecurityNeeds()
   * @generated
   */
  EAttribute getSecurityNeeds_Availability();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceability <em>Traceability</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Traceability</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceability()
   * @see #getSecurityNeeds()
   * @generated
   */
  EAttribute getSecurityNeeds_Traceability();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage <em>Trust Boundary Storage</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Trust Boundary Storage</em>'.
   * @see org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage
   * @generated
   */
  EClass getTrustBoundaryStorage();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isThreatSource <em>Threat Source</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Threat Source</em>'.
   * @see org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isThreatSource()
   * @see #getTrustBoundaryStorage()
   * @generated
   */
  EAttribute getTrustBoundaryStorage_ThreatSource();

  /**
   * Returns the meta object for the attribute '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getThreatSourceProfile <em>Threat Source Profile</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Threat Source Profile</em>'.
   * @see org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getThreatSourceProfile()
   * @see #getTrustBoundaryStorage()
   * @generated
   */
  EAttribute getTrustBoundaryStorage_ThreatSourceProfile();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isTrusted <em>Trusted</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Trusted</em>'.
   * @see org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#isTrusted()
   * @see #getTrustBoundaryStorage()
   * @generated
   */
  EAttribute getTrustBoundaryStorage_Trusted();

  /**
   * Returns the meta object for the attribute
   * '{@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getRationale <em>Rationale</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Rationale</em>'.
   * @see org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage#getRationale()
   * @see #getTrustBoundaryStorage()
   * @generated
   */
  EAttribute getTrustBoundaryStorage_Rationale();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset <em>Primary Asset</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Asset</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAsset
   * @generated
   */
  EClass getPrimaryAsset();

  /**
   * Returns the meta object for the containment reference list '{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedThreatApplications <em>Owned Threat Applications</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Threat Applications</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedThreatApplications()
   * @see #getPrimaryAsset()
   * @generated
   */
  EReference getPrimaryAsset_OwnedThreatApplications();

  /**
   * Returns the meta object for the containment reference list
   * '{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedMembers <em>Owned Members</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Owned Members</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAsset#getOwnedMembers()
   * @see #getPrimaryAsset()
   * @generated
   */
  EReference getPrimaryAsset_OwnedMembers();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset <em>Functional Primary Asset</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Functional Primary Asset</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset
   * @generated
   */
  EClass getFunctionalPrimaryAsset();

  /**
   * Returns the meta object for the reference list
   * '{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctions <em>Functions</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Functions</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctions()
   * @see #getFunctionalPrimaryAsset()
   * @generated
   */
  EReference getFunctionalPrimaryAsset_Functions();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset <em>Information Primary Asset</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Information Primary Asset</em>'.
   * @see org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset
   * @generated
   */
  EClass getInformationPrimaryAsset();

  /**
   * Returns the meta object for the reference list '{@link org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset#getExchangeItems <em>Exchange Items</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Exchange Items</em>'.
   * @see org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset#getExchangeItems()
   * @see #getInformationPrimaryAsset()
   * @generated
   */
  EReference getInformationPrimaryAsset_ExchangeItems();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember <em>Primary Asset Member</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Asset Member</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAssetMember
   * @generated
   */
  EClass getPrimaryAssetMember();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getAsset <em>Asset</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Asset</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getAsset()
   * @see #getPrimaryAssetMember()
   * @generated
   */
  EReference getPrimaryAssetMember_Asset();

  /**
   * Returns the meta object for the reference
   * '{@link org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getMember <em>Member</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference '<em>Member</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAssetMember#getMember()
   * @see #getPrimaryAssetMember()
   * @generated
   */
  EReference getPrimaryAssetMember_Member();

  /**
   * Returns the meta object for enum '{@link org.polarsys.capella.cybersecurity.model.ThreatKind <em>Threat Kind</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for enum '<em>Threat Kind</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatKind
   * @generated
   */
  EEnum getThreatKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CybersecurityFactory getCybersecurityFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl <em>Pkg</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPkgImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getCybersecurityPkg()
     * @generated
     */
    EClass CYBERSECURITY_PKG = eINSTANCE.getCybersecurityPkg();

    /**
     * The meta object literal for the '<em><b>Owned Threats</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference CYBERSECURITY_PKG__OWNED_THREATS = eINSTANCE.getCybersecurityPkg_OwnedThreats();

    /**
     * The meta object literal for the '<em><b>Owned Cybersecurity Pkgs</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS = eINSTANCE.getCybersecurityPkg_OwnedCybersecurityPkgs();

    /**
     * The meta object literal for the '<em><b>Owned Primary Assets</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS = eINSTANCE.getCybersecurityPkg_OwnedPrimaryAssets();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatImpl <em>Threat</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.ThreatImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreat()
     * @generated
     */
    EClass THREAT = eINSTANCE.getThreat();

    /**
     * The meta object literal for the '<em><b>Addressed By</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THREAT__ADDRESSED_BY = eINSTANCE.getThreat_AddressedBy();

    /**
     * The meta object literal for the '<em><b>Threat Kind</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute THREAT__THREAT_KIND = eINSTANCE.getThreat_ThreatKind();

    /**
     * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute THREAT__LEVEL = eINSTANCE.getThreat_Level();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute THREAT__RATIONALE = eINSTANCE.getThreat_Rationale();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatInvolvementImpl <em>Threat Involvement</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.ThreatInvolvementImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatInvolvement()
     * @generated
     */
    EClass THREAT_INVOLVEMENT = eINSTANCE.getThreatInvolvement();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference THREAT_INVOLVEMENT__COMPONENT = eINSTANCE.getThreatInvolvement_Component();

    /**
     * The meta object literal for the '<em><b>Threat</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference THREAT_INVOLVEMENT__THREAT = eINSTANCE.getThreatInvolvement_Threat();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl <em>Function Storage</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.FunctionStorageImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getFunctionStorage()
     * @generated
     */
    EClass FUNCTION_STORAGE = eINSTANCE.getFunctionStorage();

    /**
     * The meta object literal for the '<em><b>Exchanged Items</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_STORAGE__EXCHANGED_ITEMS = eINSTANCE.getFunctionStorage_ExchangedItems();

    /**
     * The meta object literal for the '<em><b>Data Storage</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_STORAGE__DATA_STORAGE = eINSTANCE.getFunctionStorage_DataStorage();

    /**
     * The meta object literal for the '<em><b>Remanent Data</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_STORAGE__REMANENT_DATA = eINSTANCE.getFunctionStorage_RemanentData();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatApplicationImpl <em>Threat Application</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.ThreatApplicationImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatApplication()
     * @generated
     */
    EClass THREAT_APPLICATION = eINSTANCE.getThreatApplication();

    /**
     * The meta object literal for the '<em><b>Threat</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference THREAT_APPLICATION__THREAT = eINSTANCE.getThreatApplication_Threat();

    /**
     * The meta object literal for the '<em><b>Asset</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference THREAT_APPLICATION__ASSET = eINSTANCE.getThreatApplication_Asset();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetStorageImpl <em>Primary Asset Storage</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetStorageImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getPrimaryAssetStorage()
     * @generated
     */
    EClass PRIMARY_ASSET_STORAGE = eINSTANCE.getPrimaryAssetStorage();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl <em>Security Needs</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.SecurityNeedsImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getSecurityNeeds()
     * @generated
     */
    EClass SECURITY_NEEDS = eINSTANCE.getSecurityNeeds();

    /**
     * The meta object literal for the '<em><b>Confidentiality</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute SECURITY_NEEDS__CONFIDENTIALITY = eINSTANCE.getSecurityNeeds_Confidentiality();

    /**
     * The meta object literal for the '<em><b>Integrity</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute SECURITY_NEEDS__INTEGRITY = eINSTANCE.getSecurityNeeds_Integrity();

    /**
     * The meta object literal for the '<em><b>Availability</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute SECURITY_NEEDS__AVAILABILITY = eINSTANCE.getSecurityNeeds_Availability();

    /**
     * The meta object literal for the '<em><b>Traceability</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute SECURITY_NEEDS__TRACEABILITY = eINSTANCE.getSecurityNeeds_Traceability();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl <em>Trust Boundary Storage</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getTrustBoundaryStorage()
     * @generated
     */
    EClass TRUST_BOUNDARY_STORAGE = eINSTANCE.getTrustBoundaryStorage();

    /**
     * The meta object literal for the '<em><b>Threat Source</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute TRUST_BOUNDARY_STORAGE__THREAT_SOURCE = eINSTANCE.getTrustBoundaryStorage_ThreatSource();

    /**
     * The meta object literal for the '<em><b>Threat Source Profile</b></em>' attribute feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE = eINSTANCE.getTrustBoundaryStorage_ThreatSourceProfile();

    /**
     * The meta object literal for the '<em><b>Trusted</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute TRUST_BOUNDARY_STORAGE__TRUSTED = eINSTANCE.getTrustBoundaryStorage_Trusted();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute TRUST_BOUNDARY_STORAGE__RATIONALE = eINSTANCE.getTrustBoundaryStorage_Rationale();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl <em>Primary Asset</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getPrimaryAsset()
     * @generated
     */
    EClass PRIMARY_ASSET = eINSTANCE.getPrimaryAsset();

    /**
     * The meta object literal for the '<em><b>Owned Threat Applications</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS = eINSTANCE.getPrimaryAsset_OwnedThreatApplications();

    /**
     * The meta object literal for the '<em><b>Owned Members</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference PRIMARY_ASSET__OWNED_MEMBERS = eINSTANCE.getPrimaryAsset_OwnedMembers();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl <em>Functional Primary Asset</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.FunctionalPrimaryAssetImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getFunctionalPrimaryAsset()
     * @generated
     */
    EClass FUNCTIONAL_PRIMARY_ASSET = eINSTANCE.getFunctionalPrimaryAsset();

    /**
     * The meta object literal for the '<em><b>Functions</b></em>' reference list feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS = eINSTANCE.getFunctionalPrimaryAsset_Functions();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.InformationPrimaryAssetImpl <em>Information Primary Asset</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.InformationPrimaryAssetImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getInformationPrimaryAsset()
     * @generated
     */
    EClass INFORMATION_PRIMARY_ASSET = eINSTANCE.getInformationPrimaryAsset();

    /**
     * The meta object literal for the '<em><b>Exchange Items</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFORMATION_PRIMARY_ASSET__EXCHANGE_ITEMS = eINSTANCE.getInformationPrimaryAsset_ExchangeItems();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetMemberImpl <em>Primary Asset Member</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.PrimaryAssetMemberImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getPrimaryAssetMember()
     * @generated
     */
    EClass PRIMARY_ASSET_MEMBER = eINSTANCE.getPrimaryAssetMember();

    /**
     * The meta object literal for the '<em><b>Asset</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference PRIMARY_ASSET_MEMBER__ASSET = eINSTANCE.getPrimaryAssetMember_Asset();

    /**
     * The meta object literal for the '<em><b>Member</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference PRIMARY_ASSET_MEMBER__MEMBER = eINSTANCE.getPrimaryAssetMember_Member();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.ThreatKind <em>Threat Kind</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.ThreatKind
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatKind()
     * @generated
     */
    EEnum THREAT_KIND = eINSTANCE.getThreatKind();

  }

} // CybersecurityPackage
