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
