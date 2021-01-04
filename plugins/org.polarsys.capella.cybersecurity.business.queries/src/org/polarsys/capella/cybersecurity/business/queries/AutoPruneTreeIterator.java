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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class AutoPruneTreeIterator<T> extends EcoreUtil.ContentTreeIterator<T> {

  private static final long serialVersionUID = -8463285121458881567L;
  private final Predicate<EObject> pruner;

  protected AutoPruneTreeIterator(Collection<?> emfObjects, Predicate<EObject> pruner) {
    super(emfObjects);
    this.pruner = pruner;
  }

  @Override
  protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
    if (pruner.test(eObject)) {
      return Collections.emptyIterator();
    }
    return super.getEObjectChildren(eObject);
  }

}
