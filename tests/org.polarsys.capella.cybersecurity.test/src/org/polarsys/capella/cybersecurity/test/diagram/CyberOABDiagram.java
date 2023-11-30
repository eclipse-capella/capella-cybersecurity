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
package org.polarsys.capella.cybersecurity.test.diagram;

import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
import org.polarsys.capella.core.sirius.analysis.constants.IToolNameConstants;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.context.OABDiagram;
import org.polarsys.capella.test.diagram.common.ju.step.crud.CreateDiagramStep;
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreateContainerTool;
import org.polarsys.capella.test.diagram.common.ju.step.tools.InsertRemoveTool;
import org.polarsys.capella.test.framework.context.SessionContext;

public class CyberOABDiagram extends OABDiagram {

  public CyberOABDiagram(SessionContext context, DDiagram diagram) {
    super(context, diagram);
  }

  public static CyberOABDiagram createDiagram(SessionContext context, String targetIdentifier) {
    CyberOABDiagram diagram = (CyberOABDiagram) new CreateDiagramStep(context, targetIdentifier,
        IDiagramNameConstants.OPERATIONAL_ENTITY_BLANK_DIAGRAM_NAME) {
      @Override
      public DiagramContext getResult() {
        return new CyberOABDiagram(getExecutionContext(), diagram);
      }
    }.run().open();
    CyberDiagramLayers.activateLayer(context.getSession(), diagram.getDiagram(),
        CybersecurityAnalysisConstants.LAYER_ASSETS);
    return diagram;

  }

  public void insertPrimaryAsset(PrimaryAsset pa) {
    InsertRemoveTool irt = new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_XAB_INSERT_PA);
    irt.insert(pa.getId());
    irt.getResult();
  }

  public void removePrimaryAsset(PrimaryAsset pa) {
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_XAB_INSERT_PA).remove(pa.getId());
  }

  public void insertThreat(Threat threat) {
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_XAB_INSERT_THREAT).insert(threat.getId());
  }
  
  public void removeThreat(Threat threat) {
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_XAB_INSERT_THREAT).remove(threat.getId());
  }
  
  public String createEntity(String id, String containerId) {
    DDiagramElementContainer element = new CreateContainerTool(this, IToolNameConstants.TOOL_OAB_CREATE_OE, containerId,
        id).run();
    return ((CapellaElement) element.getTarget()).getId();
  }

}
