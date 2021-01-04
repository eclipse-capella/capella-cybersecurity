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
package org.polarsys.capella.cybersecurity.ui;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

/**
 * A helper interface that allows on-the-fly attachment of eMDE extension objects.
 */
public interface ElementExtensionStorage<T extends ElementExtension> extends Adapter, IEditingDomainProvider {

  /**
   * @return the extension object that holds additional properties for the extended element.
   */
  public T getExtension();

  /**
   * @return the element that is extended
   **/
  public ExtensibleElement getExtendedElement();

  /**
   * If the extension already has a container, return it, otherwise go through the adapters
   * to see if there's a planned container for the extension
   * @param extension
   * @return
   */
  public static EObject findContainer(EObject extension) {
    if (extension.eContainer() != null) {
      return extension.eContainer();
    }
    ElementExtensionStorage<?> storage = (ElementExtensionStorage<?>) EcoreUtil.getExistingAdapter(extension, ElementExtensionStorage.class);
    if (storage != null) {
      return storage.getExtendedElement();
    }
    return null;
  }

}
