/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.transition.handlers.traceability;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.transition.common.constants.ITransitionConstants;
import org.polarsys.capella.core.transition.common.handlers.contextscope.ContextScopeHandlerHelper;
import org.polarsys.capella.core.transition.common.handlers.scope.IScopeRetriever;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 * 
 */
public class ExtensionRetriever implements IScopeRetriever {

  /**
   * {@inheritDoc}
   */
  public IStatus init(IContext context) {
    return Status.OK_STATUS;
  }

  /**
   * {@inheritDoc}
   */
  public IStatus dispose(IContext context) {
    return Status.OK_STATUS;
  }

  /**
   * {@inheritDoc}
   */
  public Collection<? extends EObject> retrieveRelatedElements(EObject source, IContext context) {
    Collection<EObject> elements = new LinkedList<>();
    if (source instanceof CapellaElement) {
      CapellaElement element = (CapellaElement) source;
      if (!(element instanceof BlockArchitecture) || (element instanceof BlockArchitecture && ContextScopeHandlerHelper
          .getInstance(context).contains(ITransitionConstants.INITIAL_SOURCE_SCOPE, element, context))) {
        BlockArchitecture blockArchitecture = BlockArchitectureExt.getRootBlockArchitecture(element);
        if (element.getOwnedExtensions() != null
            && BlockArchitectureExt.getBlockArchitectureType(blockArchitecture) != Type.PA
            && BlockArchitectureExt.getBlockArchitectureType(blockArchitecture) != Type.EPBS) {
          List<ElementExtension> extensionsList = element.getOwnedExtensions().stream()
              .filter(x -> x.eClass().getEPackage() == CybersecurityPackage.eINSTANCE).collect(Collectors.toList());

          if (!(source instanceof BlockArchitecture)) {
            extensionsList = extensionsList.stream().filter(x -> !(x instanceof CybersecurityPkg))
                .collect(Collectors.toList());
          }
          elements.addAll(extensionsList);
        }
      }
    }
    return elements;
  }

  /**
   * {@inheritDoc}
   */
  public Collection<? extends EObject> retrieveSharedElements(IContext context) {
    return Collections.emptyList();
  }
}
