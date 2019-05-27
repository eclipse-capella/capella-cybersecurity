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
package org.polarsys.capella.cybersecurity.ui;

import org.eclipse.emf.common.notify.Adapter;
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
}
