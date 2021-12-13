/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
