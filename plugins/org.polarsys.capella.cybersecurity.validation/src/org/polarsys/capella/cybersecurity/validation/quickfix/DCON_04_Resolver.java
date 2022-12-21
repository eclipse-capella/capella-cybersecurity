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
package org.polarsys.capella.cybersecurity.validation.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
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
            try {
              marker.delete();
            } catch (CoreException e1) {
              // do nothing
            }
          }
        });
      }
    }
  }

}
