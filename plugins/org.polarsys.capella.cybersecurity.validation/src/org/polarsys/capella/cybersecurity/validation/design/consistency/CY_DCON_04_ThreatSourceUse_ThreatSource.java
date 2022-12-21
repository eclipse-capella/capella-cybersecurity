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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

public class CY_DCON_04_ThreatSourceUse_ThreatSource extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    ThreatSourceUse threatSourceUse = (ThreatSourceUse) ctx.getTarget();
    Component use = threatSourceUse.getThreatSource();
    if (CybersecurityQueries.isThreatSource(use)) {
      return ctx.createSuccessStatus();
    }
    return ctx.createFailureStatus(threatSourceUse, NamingHelper.getTitleLabel(threatSourceUse), use,
        NamingHelper.getTitleLabel(use));

  }

}
