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
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;

/**
 * The exchange items on an InformationPrimaryAsset must be allocated somewhere
 */
public class CY_DCOV_05_InformationPrimaryAssetNotHandled extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    InformationPrimaryAsset ipa = (InformationPrimaryAsset) ctx.getTarget();
    for (ExchangeItem ei : ipa.getExchangeItems()) {
      boolean handled = CybersecurityQueries.getAllocatingFunctionalExchanges(ei).findAny().isPresent()
          || CybersecurityQueries.getAllocatingFunctions(ei).findAny().isPresent();
      if (!handled) {
        return ctx.createFailureStatus(ipa, NamingHelper.getTitleLabel(ipa));
      }
    }
    return ctx.createSuccessStatus();
  }

}
