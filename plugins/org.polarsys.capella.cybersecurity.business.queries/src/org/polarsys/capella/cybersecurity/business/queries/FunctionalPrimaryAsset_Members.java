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
package org.polarsys.capella.cybersecurity.business.queries;

import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

public class FunctionalPrimaryAsset_Members extends BlockArchitecturePredicateQuery {
  static Predicate<EObject> adderF = AbstractFunction.class::isInstance;
  static Predicate<EObject> adderFC = FunctionalChain.class::isInstance;
  
  public FunctionalPrimaryAsset_Members() { 
    super(CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS, adderF.or(adderFC),
        CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET);
  }
}
