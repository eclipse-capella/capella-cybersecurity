/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.emde.model.edit.provider.helpers.EMDEHelper;

public class CommonHelpers {
  public static final String CYBERSECURITY_CFG_KEYWORD = "Cybersecurity Configuration";
  public static final String CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD = "Security.Confidentiality";
  public static final String CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD = "Security.Integrity";
  public static final String CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD = "Security.Traceability";
  public static final String CYBERSECURITY_CFG_SECURITY_AVIABILITY_KEYWORD = "Security.Aviability";
  
  public static boolean canBeExtendedBy(EObject parent, EClass extensionClass) {
    Collection<EClass> extendedElements = EMDEHelper.getExtendedElement(new BasicDiagnostic(), extensionClass);
    for (EClass extendedElement : extendedElements) {
      if (extendedElement.isInstance(parent)) {
        return true;
      }
    }
    return false;
  }

  public static boolean isViewpointActive(EObject modelElement, String viewpointId) {
    return ViewpointManager.getInstance(modelElement).isUsed(viewpointId)
        && !ViewpointManager.getInstance(modelElement).isFiltered(viewpointId);
  }

  public static Project getCurrentProject() {
    IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    
    if (activeEditor != null) {
      IEditorInput input = activeEditor.getEditorInput();
      if (input instanceof SessionEditorInput) {
        Session editorInputSession = ((SessionEditorInput) input).getSession();
        return SessionHelper.getCapellaProject(editorInputSession);
      }
    }
    return null;
  }
}
