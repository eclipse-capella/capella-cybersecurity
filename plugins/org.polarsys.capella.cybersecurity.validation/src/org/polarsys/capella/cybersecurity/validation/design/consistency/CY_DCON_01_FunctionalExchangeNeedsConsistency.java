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
package org.polarsys.capella.cybersecurity.validation.design.consistency;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.fa.FunctionalExchange;

/**
 * The SecurityNeeds of a FunctionalExchange must be at least as high as those of each of its allocated ExchangeItems.
 */
public class CY_DCON_01_FunctionalExchangeNeedsConsistency extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    return SecurityNeedsConsistency.securityNeedsConsistency(ctx, e -> ((FunctionalExchange) e).getExchangedItems());
  }

}
