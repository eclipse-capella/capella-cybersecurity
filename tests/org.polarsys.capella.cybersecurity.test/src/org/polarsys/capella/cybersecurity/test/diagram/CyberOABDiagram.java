/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreatePathTool;
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
  
  @Override
  public void createFunctionalChain(String path, String... links) {
    new CreatePathTool(this, IToolNameConstants.TOOL_OAIB_CREATE_OPERATIONAL_PROCESS, path, links).run();
  }

  public String createEntity(String id, String containerId) {
    DDiagramElementContainer element = new CreateContainerTool(this, IToolNameConstants.TOOL_OAB_CREATE_OE, containerId,
        id).run();
    return ((CapellaElement) element.getTarget()).getId();
  }

}
