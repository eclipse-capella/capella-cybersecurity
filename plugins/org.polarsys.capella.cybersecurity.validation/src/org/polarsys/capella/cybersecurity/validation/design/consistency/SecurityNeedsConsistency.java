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

import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class SecurityNeedsConsistency {

  public static IStatus securityNeedsConsistency(IValidationContext ctx,
      Function<ExtensibleElement, Collection<? extends ExtensibleElement>> relation) {
    SecurityNeeds testSN = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) ctx.getTarget());
    if (testSN == null) {
      testSN = CybersecurityFactory.eINSTANCE.createSecurityNeeds();
    }
    SecurityNeeds refSN = relation.apply((ExtensibleElement) ctx.getTarget()).stream()
        .map(CybersecurityQueries::getSecurityNeeds).filter(Objects::nonNull)
        .reduce(CybersecurityFactory.eINSTANCE.createSecurityNeeds(), CybersecurityQueries::reduceSecurityNeeds);
    if (CybersecurityQueries.getConfidentialityIndex(testSN) < CybersecurityQueries.getConfidentialityIndex(refSN) ||
        CybersecurityQueries.getTraceabilityIndex(testSN) < CybersecurityQueries.getTraceabilityIndex(refSN) ||
        CybersecurityQueries.getAvailabilityIndex(testSN) < CybersecurityQueries.getAvailabilityIndex(refSN) ||
        CybersecurityQueries.getIntegrityIndex(testSN) < CybersecurityQueries.getIntegrityIndex(refSN)) {
      return ctx.createFailureStatus(ctx.getTarget(), NamingHelper.getTitleLabel(ctx.getTarget()));
    }
    return ctx.createSuccessStatus();
  }
}
