/*******************************************************************************
 * Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
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
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.crud.CreateDiagramStep;
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreateNodeTool;
import org.polarsys.capella.test.framework.context.SessionContext;

public class ThreatDiagram extends DiagramContext {

  public ThreatDiagram(SessionContext context, DDiagram diagram) {
    super(context, diagram);
  }

  public DNode createThreat() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_THREAT, getDiagramId()).run(); 
  }

  public DNode createFunctionalPrimaryAsset() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_FUNCTIONAL_PRIMARY_ASSET, getDiagramId()).run();
  }

  public DNode createActor() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_ACTOR, getDiagramId()).run();
  }
  
  public DNode createInformationPrimaryAsset() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_INFORMATION_PRIMARY_ASSET, getDiagramId()).run();
  }

  public DEdge createThreatInvolvement(DNode threat, DNode actor) {
    return new CreateDEdgeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_THREATINVOLVEMENT, threat.getUid(), actor.getUid()).run(); 
  }

  public DEdge createThreatApplication(DNode threat, DNode asset) {
    return new CreateDEdgeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_THREATAPPLICATION, threat.getUid(), asset.getUid()).run(); 
  }

  public static ThreatDiagram createDiagram(SessionContext executionContext, String targetIdentifier) {
    return (ThreatDiagram) new CreateDiagramStep(executionContext, targetIdentifier,
        CybersecurityAnalysisConstants.DIAGRAM_THREAT) {
      public DiagramContext getResult() {
        return new ThreatDiagram(getExecutionContext(), diagram);
      }
    }.run().open();
  }

}
