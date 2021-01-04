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
package org.polarsys.capella.cybersecurity.sirius.analysis;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;
import org.polarsys.kitalpha.emde.model.edit.provider.helpers.EMDEHelper;

public class ExtensibleElementExt {

  /**
   * Can the given extensible element have an extension of the given type?
   */
  public static boolean canBeExtendedBy(EObject extensibleElement, EClass extensionClass) {
    Collection<EClass> extendedElements = EMDEHelper.getExtendedElement(new BasicDiagnostic(), extensionClass);
    for (EClass extendedElement : extendedElements) {
      if (extendedElement.isInstance(extensibleElement)) {
        return true;
      }
    }
    return false;
  }
  
  @SuppressWarnings("unchecked")
  public static <T extends ElementExtension> T getExtension(ExtensibleElement element, Class<T> clazz){
    for (ElementExtension e : element.getOwnedExtensions()) {
      if (clazz.isInstance(e)) {
        return (T) e;
      }
    }
    return null;
  }
  
}
