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
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.tools.internal.command.builders.ContainerCreationCommandBuilder;
import org.eclipse.sirius.tools.api.command.DCommand;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

class ShowHideNodeContainerCommandBuilder extends ContainerCreationCommandBuilder {

  public ShowHideNodeContainerCommandBuilder(ContainerCreationDescription tool, DDiagram diagram) {
    super(tool, diagram);
  }
  
  public ShowHideNodeContainerCommandBuilder(ContainerCreationDescription tool, DDiagramElementContainer elementContainer) {
    super(tool, elementContainer);
  }

  /**
   * Indicates if the target of the Container to create (DDiagramElement or
   * directly the DDiagram) can be editable (by calling the
   * PermissionAuthority).
   * 
   * @return true if the container can be created, false otherwise
   */
  private boolean canCreateContainerInTarget() {
      boolean containerCanBeCreatedInTarget = false;
      if (nodeContainer != null) {
          containerCanBeCreatedInTarget = permissionAuthority.canEditInstance(nodeContainer);
          if (containerCanBeCreatedInTarget) {
              EObject target = nodeContainer.getTarget();
              containerCanBeCreatedInTarget = target != null && !target.eIsProxy();
          }
      } else if (diagram != null) {
          containerCanBeCreatedInTarget = permissionAuthority.canEditInstance(diagram);
          if (containerCanBeCreatedInTarget && diagram instanceof DSemanticDecorator) {
              EObject target = ((DSemanticDecorator) diagram).getTarget();
              containerCanBeCreatedInTarget = target != null && !target.eIsProxy();
          }
      }
      return containerCanBeCreatedInTarget;
  }

  @Override
  protected DCommand buildCreateNodeCommandFromTool(EObject semanticContainer, EObject container) {
    DCommand result = createEnclosingCommand();
    if (canCreateContainerInTarget()) {
      result.getTasks().add(new ShowHideNodeContainerTask(container, tool));
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
