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
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

/**
 * A PrimaryAsset must be threatened by a Threat
 */
public class CY_DCOV_04_PrimaryAssetWithoutThread extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    PrimaryAsset pa = (PrimaryAsset) ctx.getTarget();
    if (!CybersecurityQueries.getThreatsOf(pa).findAny().isPresent()) {
      return ctx.createFailureStatus(pa, NamingHelper.getTitleLabel(pa));
    }
    return ctx.createSuccessStatus();
  }

}
