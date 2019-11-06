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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.viewpoint.description.tool.MappingBasedToolDescription;

class ShowHideNodeContainerTask extends ShowHideTask {

  public ShowHideNodeContainerTask(EObject container, ContainerCreationDescription tool) {
    super(container, tool);
  }

  @Override
  protected Collection<DDiagramElementContainer> getCandidateChildren(EObject container) {
    if (container instanceof DDiagram) {
      return ((DDiagram)container).getContainers();
    }
    if (container instanceof DDiagramElementContainer) {
      return ((DDiagramElementContainer)container).getContainers();
    }
    return Collections.emptyList();
  }

  @Override
  protected Collection<ContainerMapping> getMappings(MappingBasedToolDescription tool) {
    return ((ContainerCreationDescription)tool).getContainerMappings();
  }

}
