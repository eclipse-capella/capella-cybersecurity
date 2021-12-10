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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.crud.CreateDiagramStep;
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreateContainerTool;
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreateNodeTool;
import org.polarsys.capella.test.diagram.common.ju.step.tools.DragAndDropFromProjectExplorerTool;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.emde.model.EmdePackage;

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

  public DDiagramElementContainer createOperationalEntity() {
    return new CreateContainerTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_OPERATIONAL_ENTITY, getDiagramId()).run();
  }
  
  public DNode createOperationalActor() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_OPERATIONAL_ACTOR, getDiagramId()).run();
  }
  
  public DNode createActor() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_ACTOR, getDiagramId()).run();
  }
  
  protected void setThreatSource(CapellaElement actor) {
    TrustBoundaryStorage storage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
    storage.setThreatSource(true);
    actor.getOwnedExtensions().add(storage);
  }
  
  public DNode createInformationPrimaryAsset() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_INFORMATION_PRIMARY_ASSET, getDiagramId()).run();
  }
  
  public DNode createEnterprisePrimaryAsset() {
    return new CreateNodeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_ENTERPRISE_PRIMARY_ASSET, getDiagramId()).run();
  }
  
  public DEdge createThreatInvolvement(DNode threat, DNode actor) {
    return new CreateDEdgeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_THREATINVOLVEMENT, threat.getUid(), actor.getUid()).run(); 
  }

  public DEdge createThreatApplication(DNode threat, DNode asset) {
    return new CreateDEdgeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_THREATAPPLICATION, threat.getUid(), asset.getUid()).run(); 
  }
  
  public DEdge createThreatSourceUse(DNode threatSource, DNode actor) {
     return new ThreatDiagramCreateDEdgeTool(this, CybersecurityAnalysisConstants.TOOL_CREATE_THREATSOURCEUSE, threatSource.getUid(), actor.getUid()).run(); 
  }
  
  public void dndThreat(DiagramContext diagram, EObject threat) {
    new DragAndDropFromProjectExplorerTool(diagram,
        CybersecurityAnalysisConstants.TOOL_DND_THREAT, threat,
        diagram.getDiagramId()).run();
  }
  
  public void dndInformationPrimaryAsset(DiagramContext diagram, EObject pa) {
    new DragAndDropFromProjectExplorerTool(diagram,
        CybersecurityAnalysisConstants.TOOL_DND_INFORMATION_PRIMARY_ASSET, pa,
        diagram.getDiagramId()).run();
  }
  
  public void dndFunctionalPrimaryAsset(DiagramContext diagram, EObject pa) {
    new DragAndDropFromProjectExplorerTool(diagram,
        CybersecurityAnalysisConstants.TOOL_DND_FUNCTIONAL_PRIMARY_ASSET, pa,
        diagram.getDiagramId()).run();
  }
  
  public void dndEnterprisePrimaryAsset(DiagramContext diagram, EObject pa) {
    new DragAndDropFromProjectExplorerTool(diagram,
        CybersecurityAnalysisConstants.TOOL_DND_ENTERPRISE_PRIMARY_ASSET, pa,
        diagram.getDiagramId()).run();
  }

  public static ThreatDiagram createDiagram(SessionContext executionContext, String targetIdentifier) {
    return (ThreatDiagram) new CreateDiagramStep(executionContext, targetIdentifier,
        CybersecurityAnalysisConstants.DIAGRAM_THREAT) {
      public DiagramContext getResult() {
        return new ThreatDiagram(getExecutionContext(), diagram);
      }
    }.run().open();
  }
  
  public static class ThreatDiagramCreateDEdgeTool extends CreateDEdgeTool {

    public ThreatDiagramCreateDEdgeTool(DiagramContext context, String toolName, String sourceView, String targetView) {
      super(context, toolName, sourceView, targetView);
    }
    
    @Override
    public DEdge getResult() {
      return null;
    }
    
    @Override
    protected void postRunTest() {
      // fixme: edge does not appear in diagram (in test)
      // super.postRunTest();
      
      EObject threatSource = getDiagramContext().getView(_sourceView).getTarget();
      ThreatSourceUse use = (ThreatSourceUse) ((Collection<?>) threatSource.eGet(EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS))
        .stream()
        .filter(ThreatSourceUse.class::isInstance)
        .findFirst()
        .orElse(null);
      
      assertNotNull(use);
      assertEquals(use.getUsedActor(), getDiagramContext().getView(_targetView).getTarget());
    }
  }

}
