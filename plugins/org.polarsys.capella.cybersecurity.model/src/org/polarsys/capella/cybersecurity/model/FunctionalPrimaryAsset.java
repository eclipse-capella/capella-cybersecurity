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

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.core.data.fa.AbstractFunction;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Functional Primary Asset</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset()
 * @model
 * @generated
 */

public interface FunctionalPrimaryAsset extends PrimaryAsset {

  /**
   * Returns the value of the '<em><b>Functions</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.core.data.fa.AbstractFunction}.
  
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functions</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getFunctionalPrimaryAsset_Functions()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */

  EList<AbstractFunction> getFunctions();

} // FunctionalPrimaryAsset
