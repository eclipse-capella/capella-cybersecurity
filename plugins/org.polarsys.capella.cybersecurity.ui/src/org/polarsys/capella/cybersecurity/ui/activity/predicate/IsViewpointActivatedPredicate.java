/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.activity.predicate;

import org.eclipse.amalgam.explorer.activity.ui.api.editor.activities.ExplorerActivity;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.input.ActivityExplorerEditorInput;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.predicates.IPredicate;
import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.cybersecurity.CyberSecurityViewpointHelper;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;

public class IsViewpointActivatedPredicate implements IPredicate {
  @Override
  public boolean isActivityOk(ExplorerActivity activity) {
    ActivityExplorerEditorInput editorInput = ActivityExplorerManager.INSTANCE.getEditor().getEditorInput();
    if (editorInput != null) {
      Object adapter = editorInput.getAdapter(Session.class);
      if (adapter instanceof Session) {
        Session session = (Session) adapter;
        Project capellaProject = SessionHelper.getCapellaProject(session);
        return CyberSecurityViewpointHelper.isViewpointActive(capellaProject);
      }
    }
    return false;
  }
}