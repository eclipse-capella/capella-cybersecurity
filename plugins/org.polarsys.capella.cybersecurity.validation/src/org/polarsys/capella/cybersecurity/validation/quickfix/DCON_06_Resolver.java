/*******************************************************************
* Copyright © 2022 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
