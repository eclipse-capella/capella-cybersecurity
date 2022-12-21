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
import org.polarsys.capella.cybersecurity.ui.activity.LAPerformAutomatedTransitionAdapter;

public class CyberTransitionsFromSAActivityExplorerTestCase extends CyberTransitionsActivityExplorerTestCase {
  @Override
  protected AbstractHyperlinkAdapter createLink() {
    return new LAPerformAutomatedTransitionAdapter() {
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
    return context.getSemanticElement(SA__CYBERSECURITY_PKG);
  }
}
