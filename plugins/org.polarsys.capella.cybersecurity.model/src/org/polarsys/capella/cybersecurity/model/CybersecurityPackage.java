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

package org.polarsys.capella.cybersecurity.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.interaction.InteractionPackage;

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
   * The feature id for the '<em><b>Owned Primary Assets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Cybersecurity Pkgs</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_PKG__OWNED_CYBERSECURITY_PKGS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

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
  int THREAT__OWNED_EXTENSIONS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__ID = InteractionPackage.ABSTRACT_CAPABILITY__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SID = InteractionPackage.ABSTRACT_CAPABILITY__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__CONSTRAINTS = InteractionPackage.ABSTRACT_CAPABILITY__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_CONSTRAINTS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_MIGRATED_ELEMENTS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__NAME = InteractionPackage.ABSTRACT_CAPABILITY__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__INCOMING_TRACES = InteractionPackage.ABSTRACT_CAPABILITY__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OUTGOING_TRACES = InteractionPackage.ABSTRACT_CAPABILITY__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__VISIBLE_IN_DOC = InteractionPackage.ABSTRACT_CAPABILITY__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__VISIBLE_IN_LM = InteractionPackage.ABSTRACT_CAPABILITY__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SUMMARY = InteractionPackage.ABSTRACT_CAPABILITY__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__DESCRIPTION = InteractionPackage.ABSTRACT_CAPABILITY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__REVIEW = InteractionPackage.ABSTRACT_CAPABILITY__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_PROPERTY_VALUES = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OWNED_ENUMERATION_PROPERTY_TYPES = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__APPLIED_PROPERTY_VALUES = InteractionPackage.ABSTRACT_CAPABILITY__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OWNED_PROPERTY_VALUE_GROUPS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__APPLIED_PROPERTY_VALUE_GROUPS = InteractionPackage.ABSTRACT_CAPABILITY__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__STATUS = InteractionPackage.ABSTRACT_CAPABILITY__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__FEATURES = InteractionPackage.ABSTRACT_CAPABILITY__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__APPLIED_REQUIREMENTS = InteractionPackage.ABSTRACT_CAPABILITY__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Owned Traces</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_TRACES = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_TRACES;

  /**
   * The feature id for the '<em><b>Contained Generic Traces</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__CONTAINED_GENERIC_TRACES = InteractionPackage.ABSTRACT_CAPABILITY__CONTAINED_GENERIC_TRACES;

  /**
   * The feature id for the '<em><b>Contained Requirements Traces</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__CONTAINED_REQUIREMENTS_TRACES = InteractionPackage.ABSTRACT_CAPABILITY__CONTAINED_REQUIREMENTS_TRACES;

  /**
   * The feature id for the '<em><b>Naming Rules</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__NAMING_RULES = InteractionPackage.ABSTRACT_CAPABILITY__NAMING_RULES;

  /**
   * The feature id for the '<em><b>Owned Property Value Pkgs</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_PROPERTY_VALUE_PKGS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_PROPERTY_VALUE_PKGS;

  /**
   * The feature id for the '<em><b>Involved Involvements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INVOLVED_INVOLVEMENTS = InteractionPackage.ABSTRACT_CAPABILITY__INVOLVED_INVOLVEMENTS;

  /**
   * The feature id for the '<em><b>Owned Functional Chains</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_FUNCTIONAL_CHAINS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_FUNCTIONAL_CHAINS;

  /**
   * The feature id for the '<em><b>Pre Condition</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__PRE_CONDITION = InteractionPackage.ABSTRACT_CAPABILITY__PRE_CONDITION;

  /**
   * The feature id for the '<em><b>Post Condition</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__POST_CONDITION = InteractionPackage.ABSTRACT_CAPABILITY__POST_CONDITION;

  /**
   * The feature id for the '<em><b>Owned Scenarios</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_SCENARIOS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_SCENARIOS;

  /**
   * The feature id for the '<em><b>Incoming Capability Allocation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INCOMING_CAPABILITY_ALLOCATION = InteractionPackage.ABSTRACT_CAPABILITY__INCOMING_CAPABILITY_ALLOCATION;

  /**
   * The feature id for the '<em><b>Outgoing Capability Allocation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OUTGOING_CAPABILITY_ALLOCATION = InteractionPackage.ABSTRACT_CAPABILITY__OUTGOING_CAPABILITY_ALLOCATION;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__EXTENDS = InteractionPackage.ABSTRACT_CAPABILITY__EXTENDS;

  /**
   * The feature id for the '<em><b>Extending</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__EXTENDING = InteractionPackage.ABSTRACT_CAPABILITY__EXTENDING;

  /**
   * The feature id for the '<em><b>Abstract Capability Extension Points</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__ABSTRACT_CAPABILITY_EXTENSION_POINTS = InteractionPackage.ABSTRACT_CAPABILITY__ABSTRACT_CAPABILITY_EXTENSION_POINTS;

  /**
   * The feature id for the '<em><b>Super Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SUPER_GENERALIZATIONS = InteractionPackage.ABSTRACT_CAPABILITY__SUPER_GENERALIZATIONS;

  /**
   * The feature id for the '<em><b>Sub Generalizations</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SUB_GENERALIZATIONS = InteractionPackage.ABSTRACT_CAPABILITY__SUB_GENERALIZATIONS;

  /**
   * The feature id for the '<em><b>Includes</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INCLUDES = InteractionPackage.ABSTRACT_CAPABILITY__INCLUDES;

  /**
   * The feature id for the '<em><b>Including</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INCLUDING = InteractionPackage.ABSTRACT_CAPABILITY__INCLUDING;

  /**
   * The feature id for the '<em><b>Super</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SUPER = InteractionPackage.ABSTRACT_CAPABILITY__SUPER;

  /**
   * The feature id for the '<em><b>Sub</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__SUB = InteractionPackage.ABSTRACT_CAPABILITY__SUB;

  /**
   * The feature id for the '<em><b>Included Abstract Capabilities</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INCLUDED_ABSTRACT_CAPABILITIES = InteractionPackage.ABSTRACT_CAPABILITY__INCLUDED_ABSTRACT_CAPABILITIES;

  /**
   * The feature id for the '<em><b>Including Abstract Capabilities</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INCLUDING_ABSTRACT_CAPABILITIES = InteractionPackage.ABSTRACT_CAPABILITY__INCLUDING_ABSTRACT_CAPABILITIES;

  /**
   * The feature id for the '<em><b>Extended Abstract Capabilities</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__EXTENDED_ABSTRACT_CAPABILITIES = InteractionPackage.ABSTRACT_CAPABILITY__EXTENDED_ABSTRACT_CAPABILITIES;

  /**
   * The feature id for the '<em><b>Extending Abstract Capabilities</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__EXTENDING_ABSTRACT_CAPABILITIES = InteractionPackage.ABSTRACT_CAPABILITY__EXTENDING_ABSTRACT_CAPABILITIES;

  /**
   * The feature id for the '<em><b>Owned Functional Chain Abstract Capability Involvements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_FUNCTIONAL_CHAIN_ABSTRACT_CAPABILITY_INVOLVEMENTS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_FUNCTIONAL_CHAIN_ABSTRACT_CAPABILITY_INVOLVEMENTS;

  /**
   * The feature id for the '<em><b>Owned Abstract Function Abstract Capability Involvements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__OWNED_ABSTRACT_FUNCTION_ABSTRACT_CAPABILITY_INVOLVEMENTS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_ABSTRACT_FUNCTION_ABSTRACT_CAPABILITY_INVOLVEMENTS;

  /**
   * The feature id for the '<em><b>Available In States</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__AVAILABLE_IN_STATES = InteractionPackage.ABSTRACT_CAPABILITY__AVAILABLE_IN_STATES;

  /**
   * The feature id for the '<em><b>Owned Abstract Capability Realizations</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__OWNED_ABSTRACT_CAPABILITY_REALIZATIONS = InteractionPackage.ABSTRACT_CAPABILITY__OWNED_ABSTRACT_CAPABILITY_REALIZATIONS;

  /**
   * The feature id for the '<em><b>Involved Abstract Functions</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INVOLVED_ABSTRACT_FUNCTIONS = InteractionPackage.ABSTRACT_CAPABILITY__INVOLVED_ABSTRACT_FUNCTIONS;

  /**
   * The feature id for the '<em><b>Involved Functional Chains</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__INVOLVED_FUNCTIONAL_CHAINS = InteractionPackage.ABSTRACT_CAPABILITY__INVOLVED_FUNCTIONAL_CHAINS;

  /**
   * The feature id for the '<em><b>Addressed By</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__ADDRESSED_BY = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__KIND = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__LEVEL = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__RATIONALE = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Realized Threats</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int THREAT__REALIZED_THREATS = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Realizing Threats</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT__REALIZING_THREATS = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Threat</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_FEATURE_COUNT = InteractionPackage.ABSTRACT_CAPABILITY_FEATURE_COUNT + 6;

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
  int FUNCTION_STORAGE__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Exchanged Items</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__EXCHANGED_ITEMS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Data Storage</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__DATA_STORAGE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Remanent Data</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE__REMANENT_DATA = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Function Storage</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_STORAGE_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

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
  int PRIMARY_ASSET_STORAGE__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The number of structural features of the '<em>Primary Asset Storage</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_STORAGE_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

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
  int SECURITY_NEEDS__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Confidentiality Value</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__CONFIDENTIALITY_VALUE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Integrity Value</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__INTEGRITY_VALUE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Availability Value</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__AVAILABILITY_VALUE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Traceability Value</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS__TRACEABILITY_VALUE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Security Needs</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int SECURITY_NEEDS_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

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
  int TRUST_BOUNDARY_STORAGE__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Threat Source</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__THREAT_SOURCE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Threat Source Profile</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Trusted</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__TRUSTED = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE__RATIONALE = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Trust Boundary Storage</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUST_BOUNDARY_STORAGE_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

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
   * The feature id for the '<em><b>Realized Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Realizing Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Primary Asset</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int PRIMARY_ASSET_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

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
   * The feature id for the '<em><b>Realized Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS = PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS;

  /**
   * The feature id for the '<em><b>Realizing Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS = PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS;

  /**
   * The feature id for the '<em><b>Functions</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__FUNCTIONS = PRIMARY_ASSET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Functional Chains</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS = PRIMARY_ASSET_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Functional Primary Asset</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTIONAL_PRIMARY_ASSET_FEATURE_COUNT = PRIMARY_ASSET_FEATURE_COUNT + 2;

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
   * The feature id for the '<em><b>Realized Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS = PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS;

  /**
   * The feature id for the '<em><b>Realizing Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMATION_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS = PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS;

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
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl <em>Configuration</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getCybersecurityConfiguration()
   * @generated
   */
  int CYBERSECURITY_CONFIGURATION = 12;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OWNED_EXTENSIONS = CapellacorePackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__ID = CapellacorePackage.NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__SID = CapellacorePackage.NAMED_ELEMENT__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OWNED_CONSTRAINTS = CapellacorePackage.NAMED_ELEMENT__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.NAMED_ELEMENT__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__NAME = CapellacorePackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__INCOMING_TRACES = CapellacorePackage.NAMED_ELEMENT__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OUTGOING_TRACES = CapellacorePackage.NAMED_ELEMENT__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__VISIBLE_IN_DOC = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__VISIBLE_IN_LM = CapellacorePackage.NAMED_ELEMENT__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__SUMMARY = CapellacorePackage.NAMED_ELEMENT__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__DESCRIPTION = CapellacorePackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__REVIEW = CapellacorePackage.NAMED_ELEMENT__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OWNED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.NAMED_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__APPLIED_PROPERTY_VALUES = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.NAMED_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__STATUS = CapellacorePackage.NAMED_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__FEATURES = CapellacorePackage.NAMED_ELEMENT__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__APPLIED_REQUIREMENTS = CapellacorePackage.NAMED_ELEMENT__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Confidentiality</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Integrity</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__INTEGRITY = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Traceability</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__TRACEABILITY = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Availability</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__AVAILABILITY = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Threat Kind</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION__THREAT_KIND = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Configuration</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int CYBERSECURITY_CONFIGURATION_FEATURE_COUNT = CapellacorePackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.EnterprisePrimaryAssetImpl <em>Enterprise Primary Asset</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.EnterprisePrimaryAssetImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getEnterprisePrimaryAsset()
   * @generated
   */
  int ENTERPRISE_PRIMARY_ASSET = 13;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_EXTENSIONS = PRIMARY_ASSET__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__ID = PRIMARY_ASSET__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__SID = PRIMARY_ASSET__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__CONSTRAINTS = PRIMARY_ASSET__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_CONSTRAINTS = PRIMARY_ASSET__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS = PRIMARY_ASSET__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__NAME = PRIMARY_ASSET__NAME;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__INCOMING_TRACES = PRIMARY_ASSET__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OUTGOING_TRACES = PRIMARY_ASSET__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__VISIBLE_IN_DOC = PRIMARY_ASSET__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__VISIBLE_IN_LM = PRIMARY_ASSET__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__SUMMARY = PRIMARY_ASSET__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__DESCRIPTION = PRIMARY_ASSET__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__REVIEW = PRIMARY_ASSET__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_PROPERTY_VALUES = PRIMARY_ASSET__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES = PRIMARY_ASSET__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__APPLIED_PROPERTY_VALUES = PRIMARY_ASSET__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS = PRIMARY_ASSET__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS = PRIMARY_ASSET__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__STATUS = PRIMARY_ASSET__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__FEATURES = PRIMARY_ASSET__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__APPLIED_REQUIREMENTS = PRIMARY_ASSET__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Owned Threat Applications</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS = PRIMARY_ASSET__OWNED_THREAT_APPLICATIONS;

  /**
   * The feature id for the '<em><b>Owned Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__OWNED_MEMBERS = PRIMARY_ASSET__OWNED_MEMBERS;

  /**
   * The feature id for the '<em><b>Realized Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS = PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS;

  /**
   * The feature id for the '<em><b>Realizing Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS = PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS;

  /**
   * The feature id for the '<em><b>Primary Assets</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS = PRIMARY_ASSET_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enterprise Primary Asset</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTERPRISE_PRIMARY_ASSET_FEATURE_COUNT = PRIMARY_ASSET_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatSourceUseImpl <em>Threat Source Use</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.polarsys.capella.cybersecurity.model.impl.ThreatSourceUseImpl
   * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatSourceUse()
   * @generated
   */
  int THREAT_SOURCE_USE = 14;

  /**
   * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OWNED_EXTENSIONS = CapellacorePackage.RELATIONSHIP__OWNED_EXTENSIONS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__ID = CapellacorePackage.RELATIONSHIP__ID;

  /**
   * The feature id for the '<em><b>Sid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__SID = CapellacorePackage.RELATIONSHIP__SID;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__CONSTRAINTS = CapellacorePackage.RELATIONSHIP__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OWNED_CONSTRAINTS = CapellacorePackage.RELATIONSHIP__OWNED_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Owned Migrated Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OWNED_MIGRATED_ELEMENTS = CapellacorePackage.RELATIONSHIP__OWNED_MIGRATED_ELEMENTS;

  /**
   * The feature id for the '<em><b>Realized Flow</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__REALIZED_FLOW = CapellacorePackage.RELATIONSHIP__REALIZED_FLOW;

  /**
   * The feature id for the '<em><b>Incoming Traces</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__INCOMING_TRACES = CapellacorePackage.RELATIONSHIP__INCOMING_TRACES;

  /**
   * The feature id for the '<em><b>Outgoing Traces</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OUTGOING_TRACES = CapellacorePackage.RELATIONSHIP__OUTGOING_TRACES;

  /**
   * The feature id for the '<em><b>Visible In Doc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__VISIBLE_IN_DOC = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_DOC;

  /**
   * The feature id for the '<em><b>Visible In LM</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__VISIBLE_IN_LM = CapellacorePackage.RELATIONSHIP__VISIBLE_IN_LM;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__SUMMARY = CapellacorePackage.RELATIONSHIP__SUMMARY;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__DESCRIPTION = CapellacorePackage.RELATIONSHIP__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Review</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__REVIEW = CapellacorePackage.RELATIONSHIP__REVIEW;

  /**
   * The feature id for the '<em><b>Owned Property Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OWNED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Enumeration Property Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OWNED_ENUMERATION_PROPERTY_TYPES = CapellacorePackage.RELATIONSHIP__OWNED_ENUMERATION_PROPERTY_TYPES;

  /**
   * The feature id for the '<em><b>Applied Property Values</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__APPLIED_PROPERTY_VALUES = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUES;

  /**
   * The feature id for the '<em><b>Owned Property Value Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__OWNED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__OWNED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Applied Property Value Groups</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__APPLIED_PROPERTY_VALUE_GROUPS = CapellacorePackage.RELATIONSHIP__APPLIED_PROPERTY_VALUE_GROUPS;

  /**
   * The feature id for the '<em><b>Status</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__STATUS = CapellacorePackage.RELATIONSHIP__STATUS;

  /**
   * The feature id for the '<em><b>Features</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__FEATURES = CapellacorePackage.RELATIONSHIP__FEATURES;

  /**
   * The feature id for the '<em><b>Applied Requirements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__APPLIED_REQUIREMENTS = CapellacorePackage.RELATIONSHIP__APPLIED_REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Threat Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__THREAT_SOURCE = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Used</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE__USED = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Threat Source Use</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAT_SOURCE_USE_FEATURE_COUNT = CapellacorePackage.RELATIONSHIP_FEATURE_COUNT + 2;

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
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.Threat#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Kind</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getKind()
   * @see #getThreat()
   * @generated
   */
  EReference getThreat_Kind();

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
   * Returns the meta object for the reference list
   * '{@link org.polarsys.capella.cybersecurity.model.Threat#getRealizedThreats <em>Realized Threats</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Realized Threats</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getRealizedThreats()
   * @see #getThreat()
   * @generated
   */
  EReference getThreat_RealizedThreats();

  /**
   * Returns the meta object for the reference list
   * '{@link org.polarsys.capella.cybersecurity.model.Threat#getRealizingThreats <em>Realizing Threats</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Realizing Threats</em>'.
   * @see org.polarsys.capella.cybersecurity.model.Threat#getRealizingThreats()
   * @see #getThreat()
   * @generated
   */
  EReference getThreat_RealizingThreats();

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
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentialityValue <em>Confidentiality Value</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Confidentiality Value</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getConfidentialityValue()
   * @see #getSecurityNeeds()
   * @generated
   */
  EReference getSecurityNeeds_ConfidentialityValue();

  /**
   * Returns the meta object for the reference
   * '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrityValue <em>Integrity Value</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference '<em>Integrity Value</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getIntegrityValue()
   * @see #getSecurityNeeds()
   * @generated
   */
  EReference getSecurityNeeds_IntegrityValue();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailabilityValue <em>Availability Value</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Availability Value</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getAvailabilityValue()
   * @see #getSecurityNeeds()
   * @generated
   */
  EReference getSecurityNeeds_AvailabilityValue();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceabilityValue <em>Traceability Value</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Traceability Value</em>'.
   * @see org.polarsys.capella.cybersecurity.model.SecurityNeeds#getTraceabilityValue()
   * @see #getSecurityNeeds()
   * @generated
   */
  EReference getSecurityNeeds_TraceabilityValue();

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
   * Returns the meta object for the reference list '{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getRealizedPrimaryAssets <em>Realized Primary Assets</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Realized Primary Assets</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAsset#getRealizedPrimaryAssets()
   * @see #getPrimaryAsset()
   * @generated
   */
  EReference getPrimaryAsset_RealizedPrimaryAssets();

  /**
   * Returns the meta object for the reference list '{@link org.polarsys.capella.cybersecurity.model.PrimaryAsset#getRealizingPrimaryAssets <em>Realizing Primary Assets</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Realizing Primary Assets</em>'.
   * @see org.polarsys.capella.cybersecurity.model.PrimaryAsset#getRealizingPrimaryAssets()
   * @see #getPrimaryAsset()
   * @generated
   */
  EReference getPrimaryAsset_RealizingPrimaryAssets();

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
   * Returns the meta object for the reference list '{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctionalChains <em>Functional Chains</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Functional Chains</em>'.
   * @see org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctionalChains()
   * @see #getFunctionalPrimaryAsset()
   * @generated
   */
  EReference getFunctionalPrimaryAsset_FunctionalChains();

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
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration <em>Configuration</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Configuration</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration
   * @generated
   */
  EClass getCybersecurityConfiguration();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getConfidentiality <em>Confidentiality</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Confidentiality</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getConfidentiality()
   * @see #getCybersecurityConfiguration()
   * @generated
   */
  EReference getCybersecurityConfiguration_Confidentiality();

  /**
   * Returns the meta object for the reference
   * '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getIntegrity <em>Integrity</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference '<em>Integrity</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getIntegrity()
   * @see #getCybersecurityConfiguration()
   * @generated
   */
  EReference getCybersecurityConfiguration_Integrity();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getTraceability <em>Traceability</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Traceability</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getTraceability()
   * @see #getCybersecurityConfiguration()
   * @generated
   */
  EReference getCybersecurityConfiguration_Traceability();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getAvailability <em>Availability</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Availability</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getAvailability()
   * @see #getCybersecurityConfiguration()
   * @generated
   */
  EReference getCybersecurityConfiguration_Availability();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getThreatKind <em>Threat Kind</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Threat Kind</em>'.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration#getThreatKind()
   * @see #getCybersecurityConfiguration()
   * @generated
   */
  EReference getCybersecurityConfiguration_ThreatKind();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset <em>Enterprise Primary Asset</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Enterprise Primary Asset</em>'.
   * @see org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset
   * @generated
   */
  EClass getEnterprisePrimaryAsset();

  /**
   * Returns the meta object for the reference list '{@link org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset#getPrimaryAssets <em>Primary Assets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Primary Assets</em>'.
   * @see org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset#getPrimaryAssets()
   * @see #getEnterprisePrimaryAsset()
   * @generated
   */
  EReference getEnterprisePrimaryAsset_PrimaryAssets();

  /**
   * Returns the meta object for class '{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse <em>Threat Source Use</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Threat Source Use</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatSourceUse
   * @generated
   */
  EClass getThreatSourceUse();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getThreatSource <em>Threat Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Threat Source</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getThreatSource()
   * @see #getThreatSourceUse()
   * @generated
   */
  EReference getThreatSourceUse_ThreatSource();

  /**
   * Returns the meta object for the reference '{@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getUsed <em>Used</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Used</em>'.
   * @see org.polarsys.capella.cybersecurity.model.ThreatSourceUse#getUsed()
   * @see #getThreatSourceUse()
   * @generated
   */
  EReference getThreatSourceUse_Used();

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
     * The meta object literal for the '<em><b>Kind</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference THREAT__KIND = eINSTANCE.getThreat_Kind();

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
     * The meta object literal for the '<em><b>Realized Threats</b></em>' reference list feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference THREAT__REALIZED_THREATS = eINSTANCE.getThreat_RealizedThreats();

    /**
     * The meta object literal for the '<em><b>Realizing Threats</b></em>' reference list feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference THREAT__REALIZING_THREATS = eINSTANCE.getThreat_RealizingThreats();

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
     * The meta object literal for the '<em><b>Confidentiality Value</b></em>' reference feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference SECURITY_NEEDS__CONFIDENTIALITY_VALUE = eINSTANCE.getSecurityNeeds_ConfidentialityValue();

    /**
     * The meta object literal for the '<em><b>Integrity Value</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference SECURITY_NEEDS__INTEGRITY_VALUE = eINSTANCE.getSecurityNeeds_IntegrityValue();

    /**
     * The meta object literal for the '<em><b>Availability Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECURITY_NEEDS__AVAILABILITY_VALUE = eINSTANCE.getSecurityNeeds_AvailabilityValue();

    /**
     * The meta object literal for the '<em><b>Traceability Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECURITY_NEEDS__TRACEABILITY_VALUE = eINSTANCE.getSecurityNeeds_TraceabilityValue();

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
     * The meta object literal for the '<em><b>Realized Primary Assets</b></em>' reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference PRIMARY_ASSET__REALIZED_PRIMARY_ASSETS = eINSTANCE.getPrimaryAsset_RealizedPrimaryAssets();

    /**
     * The meta object literal for the '<em><b>Realizing Primary Assets</b></em>' reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference PRIMARY_ASSET__REALIZING_PRIMARY_ASSETS = eINSTANCE.getPrimaryAsset_RealizingPrimaryAssets();

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
     * The meta object literal for the '<em><b>Functional Chains</b></em>' reference list feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTIONAL_PRIMARY_ASSET__FUNCTIONAL_CHAINS = eINSTANCE.getFunctionalPrimaryAsset_FunctionalChains();

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
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityConfigurationImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getCybersecurityConfiguration()
     * @generated
     */
    EClass CYBERSECURITY_CONFIGURATION = eINSTANCE.getCybersecurityConfiguration();

    /**
     * The meta object literal for the '<em><b>Confidentiality</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CYBERSECURITY_CONFIGURATION__CONFIDENTIALITY = eINSTANCE.getCybersecurityConfiguration_Confidentiality();

    /**
     * The meta object literal for the '<em><b>Integrity</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CYBERSECURITY_CONFIGURATION__INTEGRITY = eINSTANCE.getCybersecurityConfiguration_Integrity();

    /**
     * The meta object literal for the '<em><b>Traceability</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CYBERSECURITY_CONFIGURATION__TRACEABILITY = eINSTANCE.getCybersecurityConfiguration_Traceability();

    /**
     * The meta object literal for the '<em><b>Availability</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CYBERSECURITY_CONFIGURATION__AVAILABILITY = eINSTANCE.getCybersecurityConfiguration_Availability();

    /**
     * The meta object literal for the '<em><b>Threat Kind</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CYBERSECURITY_CONFIGURATION__THREAT_KIND = eINSTANCE.getCybersecurityConfiguration_ThreatKind();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.EnterprisePrimaryAssetImpl <em>Enterprise Primary Asset</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.EnterprisePrimaryAssetImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getEnterprisePrimaryAsset()
     * @generated
     */
    EClass ENTERPRISE_PRIMARY_ASSET = eINSTANCE.getEnterprisePrimaryAsset();

    /**
     * The meta object literal for the '<em><b>Primary Assets</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTERPRISE_PRIMARY_ASSET__PRIMARY_ASSETS = eINSTANCE.getEnterprisePrimaryAsset_PrimaryAssets();

    /**
     * The meta object literal for the '{@link org.polarsys.capella.cybersecurity.model.impl.ThreatSourceUseImpl <em>Threat Source Use</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.polarsys.capella.cybersecurity.model.impl.ThreatSourceUseImpl
     * @see org.polarsys.capella.cybersecurity.model.impl.CybersecurityPackageImpl#getThreatSourceUse()
     * @generated
     */
    EClass THREAT_SOURCE_USE = eINSTANCE.getThreatSourceUse();

    /**
     * The meta object literal for the '<em><b>Threat Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THREAT_SOURCE_USE__THREAT_SOURCE = eINSTANCE.getThreatSourceUse_ThreatSource();

    /**
     * The meta object literal for the '<em><b>Used</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THREAT_SOURCE_USE__USED = eINSTANCE.getThreatSourceUse_Used();

  }

} // CybersecurityPackage
