/*******************************************************************************
 * Copyright (c) 2022 THALES GLOBAL SERVICES.
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

// Generated on 20.05.2019 at 12:52:47 CEST by Viewpoint DSL Generator V 0.1

package org.polarsys.capella.cybersecurity.ui.properties.sections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.ui.CommonHelpers;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorage;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorageImpl;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;


public class ElementExtensionStorageHelper {
  public static EObject getFirstElementExtensionStorageObject(EObject element, Class<?> classType, EClass eCls) {
    for (EObject iEObject : element.eContents()) {
      if(classType.isInstance(iEObject)) {
        // we return first encountered elements (in case of many - which is in inconsistent state)
        return iEObject;
      }
    }
    
    EObject result = null;
    if (CommonHelpers.canBeExtendedBy(element, eCls)) {
      for (Adapter adapter : element.eAdapters()) {
        if (adapter instanceof ElementExtensionStorage
            && classType.isInstance(((ElementExtensionStorage<?>) adapter).getExtension())) {
          return ((ElementExtensionStorage<?>) adapter).getExtension();
        }
      }
      if (result == null) {
        ElementExtensionStorageImpl<ElementExtension> adapter = new ElementExtensionStorageImpl<>((ExtensibleElement) element, eCls);
        result = adapter.getExtension();
      }
    }
    return result;
  }
  
  public static EObject getFirstElementExtensionStorageObjectFromAdapter(EObject element, Class<?> classType, EClass eCls) {
    EObject result = null;
    if (CommonHelpers.canBeExtendedBy(element, eCls)) {
      for (Adapter adapter : element.eAdapters()) {
        if (adapter instanceof ElementExtensionStorage
            && classType.isInstance(((ElementExtensionStorage<?>) adapter).getExtension())) {
          return ((ElementExtensionStorage<?>) adapter).getExtension();
        }
      }
      if (result == null) {
        ElementExtensionStorageImpl<ElementExtension> adapter = new ElementExtensionStorageImpl<>((ExtensibleElement) element, eCls);
        result = adapter.getExtension();
      }
    }
    return result;
  }
}
