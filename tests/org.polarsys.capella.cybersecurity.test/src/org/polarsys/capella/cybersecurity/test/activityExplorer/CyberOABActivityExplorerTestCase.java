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

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.cybersecurity.ui.activity.CreateCyberOABDiagramHyperlink;

public class CyberOABActivityExplorerTestCase extends CyberDiagramActivityExplorerTestCase {

  @Override
  protected AbstractCapellaNewDiagramHyperlinkAdapter createLink() {
    return new CreateCyberOABDiagramHyperlink() {
      @Override
      protected boolean useDefaultName() {
        return true;
      }

    };
  }

  @Override
  protected EObject getStructure() {
    return context.getSemanticElement(OA__ENTITIES_PKG);
  }

  @Override
  protected String getDefaultName() {
    return "[OAB] Operational Entities";
  }

  @Override
  protected ModelElement getTestModelElement() {
    return (ModelElement) ((CreateCyberOABDiagramHyperlink) link).getModelElement(project);
  }

}
