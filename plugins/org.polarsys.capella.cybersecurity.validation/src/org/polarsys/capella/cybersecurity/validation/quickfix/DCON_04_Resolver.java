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
package org.polarsys.capella.cybersecurity.validation.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.capella.core.validation.ui.ide.quickfix.AbstractCapellaMarkerResolution;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.emde.model.ElementExtension;

public class DCON_04_Resolver extends AbstractCapellaMarkerResolution {

  @Override
  public void run(IMarker marker) {
    ThreatSourceUse threatSourceUse = (ThreatSourceUse) getModelElements(marker).get(0);
    for (ElementExtension e : threatSourceUse.getThreatSource().getOwnedExtensions()) {
      if (e instanceof TrustBoundaryStorage) {
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(e);
        domain.getCommandStack().execute(new RecordingCommand(domain) {

          @Override
          protected void doExecute() {
            ((TrustBoundaryStorage) e).setThreatSource(true);
          }
        });
      }
    }
  }

}
