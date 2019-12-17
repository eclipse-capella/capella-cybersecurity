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
package org.polarsys.capella.cybersecurity.validation.design.consistency;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.fa.ComponentExchange;

/**
 * The SecurityNeeds of a ComponentExchange must be at least as high as those of each of its allocated Functional
 * Exchanges.
 */
public class CY_DCON_02_ComponentExchangeSecurityNeedsConsistency extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    return SecurityNeedsConsistency.securityNeedsConsistency(ctx,
        e -> ((ComponentExchange) e).getAllocatedFunctionalExchanges());
  }

}
