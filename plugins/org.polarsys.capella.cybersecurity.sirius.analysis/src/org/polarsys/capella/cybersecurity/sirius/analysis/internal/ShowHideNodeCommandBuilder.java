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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.helper.task.UnexecutableTask;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.tools.internal.command.builders.NodeCreationCommandBuilder;
import org.eclipse.sirius.tools.api.command.DCommand;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

public class ShowHideNodeCommandBuilder extends NodeCreationCommandBuilder {

  public ShowHideNodeCommandBuilder(NodeCreationDescription tool, DDiagram diagram) {
    super(tool, diagram);
  }

  public ShowHideNodeCommandBuilder(NodeCreationDescription tool, DDiagramElement diagramElement) {
    super(tool, diagramElement);
  }

  /**
   * Copied from super builder..
   * 
   * Indicates if the target of the Node to create (DDiagramElement or
   * directly the DDiagram) can be editable (by calling the
   * PermissionAuthority).
   * 
   * @return true if the node can be created, false otherwise
   */
  private boolean canCreateNodeInTarget() {
      boolean nodeCanBeCreatedInTarget = false;
      if (diagramElement != null) {
          nodeCanBeCreatedInTarget = permissionAuthority.canEditInstance(diagramElement);
          if (nodeCanBeCreatedInTarget) {
              EObject target = diagramElement.getTarget();
              nodeCanBeCreatedInTarget = target != null && !target.eIsProxy();
          }
      } else if (diagram != null) {
          nodeCanBeCreatedInTarget = permissionAuthority.canEditInstance(diagram);
          if (nodeCanBeCreatedInTarget && diagram instanceof DSemanticDecorator) {
              EObject target = ((DSemanticDecorator) diagram).getTarget();
              nodeCanBeCreatedInTarget = target != null && !target.eIsProxy();
          }
      }
      return nodeCanBeCreatedInTarget;
  }

  @Override
  protected DCommand buildCreateNodeCommandFromTool(EObject semanticContainer, EObject container) {
    DCommand result = createEnclosingCommand();
    if (canCreateNodeInTarget()) {
      result.getTasks().add(new ShowHideNodeTask(container, tool));
    } else {
      result.getTasks().add(UnexecutableTask.INSTANCE);
    }
    return result;
  }

  @Override
  protected String getEnclosingCommandLabel() {
    return "show/hide elements";
  }
  
}
