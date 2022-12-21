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
package org.polarsys.capella.cybersecurity.validation.design.consistency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

public class CY_DCON_06_ElementExtensionStorage_Multiple extends AbstractModelConstraint {
  public static final String CY_DCON_06_Validator_Message="{0}{1} has multiple Extension Storages of type {2}.";
  @Override
  public IStatus validate(IValidationContext ctx) {
    NamedElement element = (NamedElement) ctx.getTarget();
    
    Collection<IStatus> statuses = new ArrayList<IStatus>();
    
    validateMultipleElementExtensionStorage(element, SecurityNeeds.class, statuses, ctx);
    validateMultipleElementExtensionStorage(element, FunctionStorage.class, statuses, ctx);
    validateMultipleElementExtensionStorage(element, TrustBoundaryStorage.class, statuses, ctx);
    
    if(!statuses.isEmpty()) {
      return ConstraintStatus.createMultiStatus(ctx, statuses);
    }
    
    return ctx.createSuccessStatus();
  }
  
  private void validateMultipleElementExtensionStorage(NamedElement element, Class<?> classType, Collection<IStatus> statuses, IValidationContext ctx) {
    List<EObject> extensions = getElementExtensionStorages(element, classType);
    if(extensions.size() > 1) {
      statuses.add(ConstraintStatus.createStatus(ctx, element, extensions,
          CY_DCON_06_Validator_Message, new Object[] {element.getName(), NamingHelper.getTitleLabel(element), classType.getSimpleName()}));
    }
  }
  
  private List<EObject> getElementExtensionStorages(NamedElement element, Class<?> classType) {
    return element.eContents().stream().filter(obj -> classType.isInstance(obj)).collect(Collectors.toList());
  }
}
