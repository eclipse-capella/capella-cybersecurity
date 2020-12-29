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

import org.eclipse.sirius.diagram.DDiagram;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.context.PABDiagram;
import org.polarsys.capella.test.diagram.common.ju.step.crud.CreateDiagramStep;
import org.polarsys.capella.test.diagram.common.ju.step.tools.InsertRemoveTool;
import org.polarsys.capella.test.framework.context.SessionContext;

public class CyberPABDiagram extends PABDiagram {

  public CyberPABDiagram(SessionContext context, DDiagram diagram) {
    super(context, diagram);
  }

  public static CyberPABDiagram createDiagram(SessionContext executionContext, String targetIdentifier) {
    CyberPABDiagram diagram = (CyberPABDiagram) new CreateDiagramStep(executionContext, targetIdentifier,
        IDiagramNameConstants.PHYSICAL_ARCHITECTURE_BLANK_DIAGRAM_NAME) {
      @Override
      public DiagramContext getResult() {
        return new CyberPABDiagram(getExecutionContext(), diagram);
      }
    }.run().open();
    CyberDiagramLayers.activateLayer(executionContext.getSession(), diagram.getDiagram(), CybersecurityAnalysisConstants.LAYER_ASSETS);
    return diagram;
  }

  public void insertPrimaryAsset(PrimaryAsset pa) {
    InsertRemoveTool irt = 
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_PAB_INSERT_PA);
    irt.insert(pa.getId());
    irt.getResult();
  }
  
  public void removePrimaryAsset(PrimaryAsset pa) {
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_PAB_INSERT_PA).remove(pa.getId());
  }
  
  public void insertThreat(Threat threat) {
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_PAB_INSERT_THREAT).insert(threat.getId());
  }
  
  public void removeThreat(Threat threat) {
    new InsertRemoveTool(this, CybersecurityAnalysisConstants.TOOL_PAB_INSERT_THREAT).remove(threat.getId());
  }
}

