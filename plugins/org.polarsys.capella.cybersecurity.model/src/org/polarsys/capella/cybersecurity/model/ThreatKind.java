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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Threat Kind</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getThreatKind()
 * @model
 * @generated
 */
public enum ThreatKind implements Enumerator {
  /**
   * The '<em><b>Eavesdropping</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #EAVESDROPPING_VALUE
   * @generated
   * @ordered
   */
  EAVESDROPPING(0, "Eavesdropping", "EAVESDROPPING"), //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>Theft and data alteration</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #THEFT_AND_DATA_ALTERATION_VALUE
   * @generated
   * @ordered
   */
  THEFT_AND_DATA_ALTERATION(1, "Theft_and_data_alteration", "THEFT_AND_DATA_ALTERATION"), //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>Denial of service</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #DENIAL_OF_SERVICE_VALUE
   * @generated
   * @ordered
   */
  DENIAL_OF_SERVICE(2, "Denial_of_service", "DENIAL_OF_SERVICE"), //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>Intrusion</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #INTRUSION_VALUE
   * @generated
   * @ordered
   */
  INTRUSION(3, "Intrusion", "INTRUSION"), //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>Tampering</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #TAMPERING_VALUE
   * @generated
   * @ordered
   */
  TAMPERING(4, "Tampering", "TAMPERING"); //$NON-NLS-1$ //$NON-NLS-2$

  /**
   * The '<em><b>Eavesdropping</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Eavesdropping</b></em>' literal object isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EAVESDROPPING
   * @model name="Eavesdropping" literal="EAVESDROPPING"
   * @generated
   * @ordered
   */
  public static final int EAVESDROPPING_VALUE = 0;

  /**
   * The '<em><b>Theft and data alteration</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Theft and data alteration</b></em>' literal object isn't clear, there really should be
   * more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #THEFT_AND_DATA_ALTERATION
   * @model name="Theft_and_data_alteration" literal="THEFT_AND_DATA_ALTERATION"
   * @generated
   * @ordered
   */
  public static final int THEFT_AND_DATA_ALTERATION_VALUE = 1;

  /**
   * The '<em><b>Denial of service</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Denial of service</b></em>' literal object isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DENIAL_OF_SERVICE
   * @model name="Denial_of_service" literal="DENIAL_OF_SERVICE"
   * @generated
   * @ordered
   */
  public static final int DENIAL_OF_SERVICE_VALUE = 2;

  /**
   * The '<em><b>Intrusion</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Intrusion</b></em>' literal object isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTRUSION
   * @model name="Intrusion" literal="INTRUSION"
   * @generated
   * @ordered
   */
  public static final int INTRUSION_VALUE = 3;

  /**
   * The '<em><b>Tampering</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Tampering</b></em>' literal object isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TAMPERING
   * @model name="Tampering" literal="TAMPERING"
   * @generated
   * @ordered
   */
  public static final int TAMPERING_VALUE = 4;

  /**
   * An array of all the '<em><b>Threat Kind</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static final ThreatKind[] VALUES_ARRAY = new ThreatKind[] { EAVESDROPPING, THEFT_AND_DATA_ALTERATION,
      DENIAL_OF_SERVICE, INTRUSION, TAMPERING, };

  /**
   * A public read-only list of all the '<em><b>Threat Kind</b></em>' enumerators.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public static final List<ThreatKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Threat Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ThreatKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ThreatKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Threat Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ThreatKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ThreatKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Threat Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ThreatKind get(int value) {
    switch (value) {
    case EAVESDROPPING_VALUE:
      return EAVESDROPPING;
    case THEFT_AND_DATA_ALTERATION_VALUE:
      return THEFT_AND_DATA_ALTERATION;
    case DENIAL_OF_SERVICE_VALUE:
      return DENIAL_OF_SERVICE;
    case INTRUSION_VALUE:
      return INTRUSION;
    case TAMPERING_VALUE:
      return TAMPERING;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private ThreatKind(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // ThreatKind
