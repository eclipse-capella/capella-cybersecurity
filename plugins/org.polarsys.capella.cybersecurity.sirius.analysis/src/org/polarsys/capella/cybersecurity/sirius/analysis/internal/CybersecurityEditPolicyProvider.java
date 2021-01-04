/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.sirius.analysis.internal;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.tools.api.command.IDiagramCommandFactory;
import org.eclipse.sirius.diagram.tools.api.command.IDiagramCommandFactoryProvider;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DDiagramEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.policies.AbstractCreateEditPolicyProvider;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecuritySiriusAnalysisActivator;

/**
 * This class installs a custom diagram command factory that can handle the show hide tools
 * defined in cybersecurity diagrams.
 */
// TODO find a better way to install the edit policy provider. currently it is queried for every created edit part..
public class CybersecurityEditPolicyProvider extends AbstractCreateEditPolicyProvider {

  @Override
  public void createEditPolicies(EditPart editPart) {
    Object property = editPart.getViewer().getProperty(DDiagramEditor.EDITOR_ID);
    if (property instanceof DDiagramEditor) {
        DDiagramEditor diagramEditor = (DDiagramEditor) property;
        final IDiagramCommandFactoryProvider oldProvider = diagramEditor.getEmfCommandFactoryProvider();   
        diagramEditor.setEmfCommandFactoryProvider(new IDiagramCommandFactoryProvider() {
          @Override
          public IDiagramCommandFactory getCommandFactory(TransactionalEditingDomain editingDomain) {
            return new CybersecurityDiagramCommandFactory(editingDomain, oldProvider);
          }
        });
    }
  }

  @Override
  protected boolean isValidEditPart(EditPart editPart) {
    boolean isCyberDiagram = false;
    if (editPart instanceof DDiagramEditPart) {
      DDiagramEditPart part = (DDiagramEditPart) editPart;
      Diagram diagram = (Diagram) part.getModel();
      if (diagram != null) {
        DDiagram dsem = (DDiagram) diagram.getElement();
        if (dsem != null) {
          URI design = EcoreUtil.getURI(dsem.getDescription()).trimFragment();
          isCyberDiagram = CybersecuritySiriusAnalysisActivator.getDefault().getRegisteredViewpoints().stream()
              .map(v -> EcoreUtil.getURI(v).trimFragment()).anyMatch(uri -> uri.equals(design));
        }
      }
    }
    return isCyberDiagram;
  }

}
