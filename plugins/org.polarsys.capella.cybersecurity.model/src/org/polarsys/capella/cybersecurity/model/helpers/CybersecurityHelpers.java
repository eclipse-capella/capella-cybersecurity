/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.model.helpers;

import java.util.Optional;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;

public class CybersecurityHelpers {
  public static final String CYBERSECURITY_CFG_KEYWORD = "Cybersecurity Configuration";
  public static final String CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD = "Security.Confidentiality";
  public static final String CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD = "Security.Integrity";
  public static final String CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD = "Security.Traceability";
  public static final String CYBERSECURITY_CFG_SECURITY_AVAILABILITY_KEYWORD = "Security.Availability";
  
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
  
  public static EnumerationPropertyType getEnumerationPropertyType(String configType) {
    Project project = getCurrentProject();
    return getEnumerationPropertyType(configType, project);
  }
  
  public static EnumerationPropertyType getEnumerationPropertyType(String configType, Project project) {
    if (project != null) {
      Optional<ElementExtension> result = project.getOwnedExtensions().stream()
          .filter(x -> x instanceof CybersecurityPkg).findFirst();
      if (result.isPresent()) {
        CybersecurityPkg pkg = (CybersecurityPkg) result.get();
        Optional<EnumerationPropertyType> result1 = pkg.getOwnedEnumerationPropertyTypes().stream()
            .filter(x -> x.getName().equals(configType)).findFirst();
        if (result1.isPresent()) {
          return result1.get();
        }
      }
    }
    return null;
  }
  
  public static int getConfidentialitySize() {
    EnumerationPropertyType type = CybersecurityHelpers.getEnumerationPropertyType(CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }

  public static int getIntegritySize() {
    EnumerationPropertyType type = CybersecurityHelpers.getEnumerationPropertyType(CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }

  public static int getAvailabilitySize() {
    EnumerationPropertyType type = CybersecurityHelpers.getEnumerationPropertyType(CYBERSECURITY_CFG_SECURITY_AVAILABILITY_KEYWORD);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }

  public static int getTraceabilitySize() {
    EnumerationPropertyType type = CybersecurityHelpers.getEnumerationPropertyType(CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD);
    return type == null ? 0 : type.getOwnedLiterals().size();
  }
  
}
