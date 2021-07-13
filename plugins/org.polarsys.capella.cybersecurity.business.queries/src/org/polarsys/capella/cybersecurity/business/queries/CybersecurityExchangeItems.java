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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;

public class CybersecurityExchangeItems extends BlockArchitecturePredicateQuery {

  public CybersecurityExchangeItems(EReference theFeature, Predicate<EObject> adder, EClass extensionClass) {
    super(theFeature, adder, extensionClass);
  }
  
  @Override
  public List<EObject> getAvailableElements(EObject element) {
    List<EObject> availableElements = new ArrayList<EObject>();
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
    List<BlockArchitecture> rootAndPreviousBlockArchitectures = BlockArchitectureExt.getRootAndPreviousBlockArchitectures(element);
    for (BlockArchitecture blockArchitecture : rootAndPreviousBlockArchitectures) {
      availableElements.addAll(super.getAvailableElementsOnArchitecture(blockArchitecture, domain));
    }
    return availableElements;
  }
}
