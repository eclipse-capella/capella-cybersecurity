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
package org.polarsys.capella.cybersecurity.test.transition;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.capella.common.ef.command.ICommand;
import org.polarsys.capella.core.transition.system.topdown.commands.IntramodelTransitionCommand;
import org.polarsys.capella.core.transition.system.topdown.constants.ITopDownConstants;

public class CyberTransitionCommandHelper
    extends org.polarsys.capella.core.transition.system.topdown.commands.TransitionCommandHelper {

  public static CyberTransitionCommandHelper getInstance() {
    return new CyberTransitionCommandHelper();
  }

  public ICommand getCybersecurityTransitionCommand(Collection<?> elements, IProgressMonitor monitor) {
    return new IntramodelTransitionCommand(elements, monitor) {
      @Override
      protected String getTransitionKind() {
        return ITopDownConstants.TRANSITION_TOPDOWN;
      }
    };
  }
}
