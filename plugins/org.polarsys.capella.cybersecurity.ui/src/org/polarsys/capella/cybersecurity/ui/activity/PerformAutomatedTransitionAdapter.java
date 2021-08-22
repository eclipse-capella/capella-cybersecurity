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
package org.polarsys.capella.cybersecurity.ui.activity;
import java.util.Collections;

import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaHyperlinkAdapter;
import org.polarsys.capella.core.transition.system.topdown.ui.commands.TransitionUICommandHelper;

/**
 * Perform an automated transition of Operational Activities.
 */
public abstract class PerformAutomatedTransitionAdapter extends AbstractCapellaHyperlinkAdapter {
  
  public static final String CYBERSECURITY_TRANSITION_CMD = "org.polarsys.capella.cybersecurity.transition.command1";

  public PerformAutomatedTransitionAdapter() {
    super(ActivityExplorerManager.INSTANCE.getRootSemanticModel());
  }

  @Override
  public void linkPressed(HyperlinkEvent event, EObject rootSemanticModel, Session session) {
    ModelElement modelElement = getModelElement(rootSemanticModel);
    if (modelElement != null) {
      TransitionUICommandHelper.getInstance().executeCommand(CYBERSECURITY_TRANSITION_CMD,
          Collections.singleton((Object) modelElement));
    }
  }
  
  public abstract ModelElement getModelElement(EObject rootSemanticModel);
}
