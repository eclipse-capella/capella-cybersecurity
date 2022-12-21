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

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.platform.sirius.ui.commands.CapellaDeleteCommand;
import org.polarsys.capella.core.validation.ui.ide.quickfix.AbstractCapellaMarkerResolution;

public class DCON_06_Resolver extends AbstractCapellaMarkerResolution {

  @Override
  public void run(IMarker marker) {
    List<EObject> all = getModelElements(marker);
    NamedElement element = (NamedElement) all.get(0);

    AbstractReadWriteCommand abstrctCommand = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        CapellaDeleteCommand command = new CapellaDeleteCommand(TransactionHelper.getExecutionManager(element),
            all.subList(2, all.size()), false, false, true);
        if (command.canExecute()) {
          command.execute();
        }
      }
    };
    TransactionHelper.getExecutionManager(element).execute(abstrctCommand);
    
    try {
      marker.delete();
    } catch (CoreException e1) {
      // do nothing
    }
  }
}
