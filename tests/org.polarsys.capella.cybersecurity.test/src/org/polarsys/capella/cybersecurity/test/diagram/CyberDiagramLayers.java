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
package org.polarsys.capella.cybersecurity.test.diagram;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramComponentizationManager;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.tools.api.command.ChangeLayerActivationCommand;

public class CyberDiagramLayers {

  public static void activateLayer(Session session, DDiagram diagram, String layerID) {
    Layer layer = null;
    for (Layer l : new DiagramComponentizationManager().getAllLayers(session.getSelectedViewpoints(false), diagram.getDescription())) {
      if(layerID.equals(l.getName())){
        layer = l;
      }
    }
    assertNotNull(layer);
    if (!diagram.getActivatedLayers().contains(layer)) {
      Command c = new ChangeLayerActivationCommand(session.getTransactionalEditingDomain(), diagram, layer, new NullProgressMonitor());
      session.getTransactionalEditingDomain().getCommandStack().execute(c);
    }
    assertTrue(diagram.getActivatedLayers().contains(layer));
  }

}
