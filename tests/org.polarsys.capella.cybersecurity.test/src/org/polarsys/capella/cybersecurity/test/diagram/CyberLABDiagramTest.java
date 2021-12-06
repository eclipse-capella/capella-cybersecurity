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

import org.eclipse.emf.transaction.RollbackException;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;

public class CyberLABDiagramTest extends CyberXABDiagramTest {

  @Override
  protected String getSystemId() {
    return LA__LOGICAL_SYSTEM;
  }

  @Override
  protected String getDataPkgId() {
    return LA__DATA;
  }

  @Override
  protected String getInterfacePkgId() {
    return LA__INTERFACES;
  }

  @Override
  protected Type getType() {
    return Type.LA;
  }

  @Override
  protected String getRepresentationName() {
    return IDiagramNameConstants.LOGICAL_ARCHITECTURE_BLANK_DIAGRAM_NAME;
  }

  @Override
  protected CyberXABDiagram createDiagram() {
    return CyberXABDiagram.createDiagram(context, getSystemId(), getType(), getRepresentationName());
  }

  @Override
  protected void createDiagramElements() {
    CyberXABDiagram diagram = (CyberXABDiagram) this.diagram;

    diagramElements.put("component1", diagram.createComponent("component1", diagram.getDiagramId()));
    diagramElements.put("component2", diagram.createComponent("component2", diagram.getDiagramId()));
    diagramElements.put("component3", diagram.createComponent("component3", diagram.getDiagramId()));
    diagramElements.put("component4", diagram.createComponent("component4", diagramElements.get("component3")));
    diagramElements.put("component5", diagram.createComponent("component5", diagramElements.get("component4")));
    diagramElements.put("component6", diagram.createComponent("component6", diagramElements.get("component5")));
    diagramElements.put("actor4", diagram.createActor("actor4", diagramElements.get("component3")));
    diagramElements.put("actor5", diagram.createActor("actor5", diagramElements.get("actor4")));
    diagramElements.put("component7", diagram.createComponent("component7", diagramElements.get("actor5")));
    diagramElements.put("component8", diagram.createComponent("component8", diagramElements.get("component7")));
  }

  @Override
  protected void insertPrimaryAsset(PrimaryAsset pa) {
    ((CyberXABDiagram) diagram).insertPrimaryAsset(pa);
  }

  @Override
  protected void removePrimaryAsset(PrimaryAsset pa) {
    ((CyberXABDiagram) diagram).removePrimaryAsset(pa);
  }

  @Override
  protected void insertThreat(Threat threat) {
    ((CyberXABDiagram) diagram).insertThreat(threat);
  }
  
  @Override
  protected void removeThreat(Threat threat) {
    ((CyberXABDiagram) diagram).removeThreat(threat);
  }

  @Override
  protected void step6() throws RollbackException, InterruptedException {
    super.step6();
    // check that third component has normal border size and black color
    checkComponentLooksNormal("component4");
  }

  @Override
  protected void step7() throws RollbackException, InterruptedException {
    super.step7();
    // check that third component has normal border size and black color
    checkComponentLooksNormal("component4");
  }

  @Override
  protected void step8() {
    super.step8();
    // check that third component has normal border size and black color
    checkComponentLooksNormal("component4");
  }

  @Override
  protected void step9() throws RollbackException, InterruptedException {
    super.step9();
    // check that first actor has the same border color as the threat color
    checkComponentLooksNormal("actor5");
  }

  @Override
  protected void step10CreateAndCheckPhysicalLink(ComponentExchange componentExchange) {
    // do nothing
  }
}
