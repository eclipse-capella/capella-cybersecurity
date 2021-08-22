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
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.Collections;

import org.eclipse.amalgam.explorer.activity.ui.api.hyperlinkadapter.AbstractHyperlinkAdapter;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.cybersecurity.test.transition.CyberTransitionCommandHelper;
import org.polarsys.capella.cybersecurity.ui.activity.SAPerformAutomatedTransitionAdapter;

public class CyberTransitionsFromOAActivityExplorerTestCase extends CyberTransitionsActivityExplorerTestCase {
  @Override
  protected AbstractHyperlinkAdapter createLink() {
    return new SAPerformAutomatedTransitionAdapter() {
      @Override
      public void linkPressed(HyperlinkEvent event, EObject rootSemanticModel, Session session) {
        ModelElement modelElement = getModelElement(rootSemanticModel);
        if (modelElement != null) {
          TransactionHelper.getExecutionManager(modelElement)
              .execute(CyberTransitionCommandHelper
                  .getInstance().getCybersecurityTransitionCommand(Collections.singleton((Object) modelElement),
                      new NullProgressMonitor()));

        }
      }
    };
  }

  @Override
  protected EObject getStructure() {
    return context.getSemanticElement(OA__CYBERSECURITY_PKG);
  }
}
