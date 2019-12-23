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
package org.polarsys.capella.cybersecurity.validation.design.coverage;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;

/**
 * A threat must involve a Threat Source or an Actor
 */
public class CY_DCOV_02_NoThreatSourceOrActor extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    Threat t = (Threat) ctx.getTarget();
    if (!CybersecurityQueries.getInvolvedComponents(t).findAny().isPresent()) {
      return ctx.createFailureStatus(t, NamingHelper.getTitleLabel(t));
    }
    return ctx.createSuccessStatus();
  }

}
