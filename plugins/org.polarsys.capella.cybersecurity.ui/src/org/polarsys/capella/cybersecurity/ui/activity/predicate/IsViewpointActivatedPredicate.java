/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.activity.predicate;

import org.eclipse.amalgam.explorer.activity.ui.api.editor.ActivityExplorerEditor;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.input.ActivityExplorerEditorInput;
import org.eclipse.amalgam.explorer.activity.ui.api.editor.predicates.IPredicate;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.CyberSecurityViewpointHelper;

public class IsViewpointActivatedPredicate implements IPredicate {

  @Override
  public boolean isOk() {
    IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    if (activeEditor instanceof ActivityExplorerEditor) {
      ActivityExplorerEditor activityExplorerEditor = (ActivityExplorerEditor) activeEditor;
      ActivityExplorerEditorInput editorInput = activityExplorerEditor.getEditorInput();

      if (editorInput != null) {
        Object adapter = editorInput.getAdapter(Session.class);

        if (adapter instanceof Session) {
          Session session = (Session) adapter;
          Project capellaProject = SessionHelper.getCapellaProject(session);

          return CyberSecurityViewpointHelper.isViewpointActive(capellaProject);
        }
      }

    }
    return false;
  }

}