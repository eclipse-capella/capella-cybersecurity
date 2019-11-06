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
package org.polarsys.capella.cybersecurity.sirius.analysis.internal;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.tools.api.command.IDiagramCommandFactoryProvider;
import org.eclipse.sirius.diagram.tools.internal.command.UndoRedoCapableEMFCommandFactory;
import org.eclipse.sirius.tools.internal.command.builders.CommandBuilder;
import org.eclipse.sirius.viewpoint.description.tool.AbstractToolDescription;

/**
 * This command factory checks if a NodeCreation/ContainerCreation tool is defined as a show/hide tool
 * and handles these tools. All other tools are handled by a delegate factory.
 * Show/Hide tools are currently identified as tools whose Name/ID starts with the {@link #SHOW_HIDE_MARKER_ID} marker prefix.
 */
public class CybersecurityDiagramCommandFactory extends UndoRedoCapableEMFCommandFactory {

  public static final String SHOW_HIDE_MARKER_ID = "show_hide__.";

  private final IDiagramCommandFactoryProvider delegate;

  public CybersecurityDiagramCommandFactory(TransactionalEditingDomain domain, IDiagramCommandFactoryProvider delegate) {
    super(domain);
    this.delegate = delegate;
  }

  private boolean isShowHideTool(AbstractToolDescription tool) {
    return tool.getName().startsWith(SHOW_HIDE_MARKER_ID);
  }

  @Override
  public Command buildCreateNodeCommandFromTool(DDiagram diagram, NodeCreationDescription tool) {
    if (isShowHideTool(tool)) {
      CommandBuilder builder = new ShowHideNodeCommandBuilder(tool, diagram);
      builder.init(modelAccessor, domain, uiCallBack);
      return builder.buildCommand();
    }
    return delegate.getCommandFactory(domain).buildCreateNodeCommandFromTool(diagram, tool);
  }

  @Override
  public Command buildCreateNodeCommandFromTool(DDiagramElementContainer container, NodeCreationDescription tool) {
    if (isShowHideTool(tool)) {
      CommandBuilder builder = new ShowHideNodeCommandBuilder(tool, container);
      builder.init(modelAccessor, domain, uiCallBack);
      return builder.buildCommand();
    }
    return delegate.getCommandFactory(domain).buildCreateNodeCommandFromTool(container, tool);
  }

  @Override
  public Command buildCreateContainerCommandFromTool(DDiagram diagram, ContainerCreationDescription tool) {
    if (isShowHideTool(tool)) {
      final CommandBuilder builder = new ShowHideNodeContainerCommandBuilder(tool, diagram);
      builder.init(modelAccessor, domain, uiCallBack);
      return builder.buildCommand();
    }
    return delegate.getCommandFactory(domain).buildCreateContainerCommandFromTool(diagram, tool);
  }

  @Override
  public Command buildCreateContainerCommandFromTool(DDiagramElementContainer nodeContainer,
      ContainerCreationDescription tool) {
    if (isShowHideTool(tool)) {
      final CommandBuilder builder = new ShowHideNodeContainerCommandBuilder(tool, nodeContainer);
      builder.init(modelAccessor, domain, uiCallBack);
      return builder.buildCommand();
    }
    return delegate.getCommandFactory(domain).buildCreateContainerCommandFromTool(nodeContainer, tool);
  }

}
