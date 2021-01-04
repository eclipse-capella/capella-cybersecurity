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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.common.libraries.IModel;
import org.polarsys.capella.common.libraries.manager.LibraryManager;
import org.polarsys.capella.common.libraries.manager.LibraryManagerExt;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.libraries.model.ICapellaModel;

public class BlockArchitecturePredicateQuery implements IBusinessQuery {

  private final EReference theFeature;// = CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS;
  private final Predicate<EObject> adder;
  private final EClass extensionClass;

  public BlockArchitecturePredicateQuery(EReference theFeature, Predicate<EObject> adder, EClass extensionClass) {
    super();
    this.theFeature = theFeature;
    this.extensionClass = extensionClass;
    this.adder = adder;
  }

  @Override
  public List<EObject> getAvailableElements(EObject element) {

    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
    BlockArchitecture arch = (BlockArchitecture) EcoreUtil2.getFirstContainer(element,
        CsPackage.Literals.BLOCK_ARCHITECTURE);
    List<EObject> result = new ArrayList<EObject>();

    // Predicate<EObject> adder = ExchangeItem.class::isInstance;
    walkProject(arch, arch, result, adder);

    for (IModel model : LibraryManagerExt.getAllActivesReferences(LibraryManager.INSTANCE.getModel(domain))) {
      if (model instanceof ICapellaModel) {
        Project project = ((ICapellaModel) model).getProject(domain);
        walkProject(project, arch, result, adder);
      }
    }
    return result;
  }

  protected void walkProject(EObject root, BlockArchitecture archi, Collection<EObject> result,
      Predicate<EObject> adder) {
    for (Iterator<EObject> it = createIterator(root, archi.eClass()); it.hasNext();) {
      EObject next = it.next();
      if (adder.test(next)) {
        result.add(next);
      }
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    return (List<EObject>) element.eGet(theFeature);
  }

  @Override
  public EClass getEClass() {
    return extensionClass;
  }

  @Override
  public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(theFeature);
  }

  private TreeIterator<EObject> createIterator(EObject root, EClass blockArchitectureClass) {
    return new AutoPruneTreeIterator<>(Collections.singleton(root),
        e -> e instanceof BlockArchitecture && e.eClass() != blockArchitectureClass);
  }

}
