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
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.context.XABDiagram;
import org.polarsys.capella.test.diagram.common.ju.step.crud.CreateDiagramStep;
import org.polarsys.capella.test.diagram.common.ju.step.tools.InsertRemoveTool;
import org.polarsys.capella.test.framework.context.SessionContext;

public class CyberXABDiagram extends XABDiagram {

  public CyberXABDiagram(Type type, SessionContext context, DDiagram diagram) {
    super(type, context, diagram);
  }

  public static CyberXABDiagram createDiagram(SessionContext executionContext, String targetIdentifier, Type type,
      String representationName) {
    CyberXABDiagram diagram = (CyberXABDiagram) new CreateDiagramStep(executionContext, targetIdentifier,
        representationName) {
      @Override
      public DiagramContext getResult() {
        return new CyberXABDiagram(type, getExecutionContext(), diagram);
      }
    }.run().open();
    CyberDiagramLayers.activateLayer(executionContext.getSession(), diagram.getDiagram(),
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

}
