/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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


import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.FlatContainerStyle;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;

public class CyberPABDiagramTest extends CyberXABDiagramTest {

  @Override
  protected String getSystemId() {
    return PA__PHYSICAL_SYSTEM;
  }

  @Override
  protected String getDataPkgId() {
    return PA__DATA;
  }

  @Override
  protected String getInterfacePkgId() {
    return PA__INTERFACES;
  }

  @Override
  protected Type getType() {
    return Type.PA;
  }

  @Override
  protected String getRepresentationName() {
    return IDiagramNameConstants.PHYSICAL_ARCHITECTURE_BLANK_DIAGRAM_NAME;
  }

  @Override
  protected CyberPABDiagram createDiagram() {
    return CyberPABDiagram.createDiagram(context, PA__PHYSICAL_SYSTEM);
  }

  @Override
  protected void createDiagramElements() {
    CyberPABDiagram diagram = (CyberPABDiagram) this.diagram;

    diagramElements.put("component1", diagram.createBehaviorComponent("component1", diagram.getDiagramId()));
    diagramElements.put("component2", diagram.createBehaviorComponent("component2", diagram.getDiagramId()));
    diagramElements.put("component3", diagram.createNodeComponent("component3", diagram.getDiagramId()));
    diagramElements.put("component4", diagram.createNodeComponent("component4", diagramElements.get("component3")));
    diagramElements.put("component5",
        diagram.createDeployedBehaviorComponent("component5", diagramElements.get("component4")));
    diagramElements.put("component6",
        diagram.createDeployedBehaviorComponent("component6", diagramElements.get("component5")));
    diagramElements.put("actor4", diagram.createActor("actor4", diagramElements.get("component3")));
    diagramElements.put("actor5", diagram.createActor("actor5", diagramElements.get("actor4")));
    diagramElements.put("component7",
        diagram.createDeployedBehaviorComponent("component7", diagramElements.get("actor5")));
    diagramElements.put("component8",
        diagram.createDeployedBehaviorComponent("component8", diagramElements.get("component7")));
  }

  @Override
  protected void insertPrimaryAsset(PrimaryAsset pa) {
    ((CyberPABDiagram) diagram).insertPrimaryAsset(pa);
  }

  @Override
  protected void removePrimaryAsset(PrimaryAsset pa) {
    ((CyberPABDiagram) diagram).removePrimaryAsset(pa);
  }

  @Override
  protected void insertThreat(Threat threat) {
    ((CyberPABDiagram) diagram).insertThreat(threat);
  }

  @Override
  protected void step6() throws RollbackException, InterruptedException {
    super.step6();
    // check that third component has same border color as primary asset color and highlighted border
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component4");
    assertEquals(getFpaColor(), ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }

  @Override
  protected void step7() throws RollbackException, InterruptedException {
    super.step7();
    // check that third component has black color and highlighted border size
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component4");
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }

  @Override
  protected void step8() {
    super.step8();
    // check that third component has the same border color as the threat color
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component4");
    assertEquals(getThreatColor(), ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }

  @Override
  protected void step9() throws RollbackException, InterruptedException {
    super.step9();
    // check that first actor has the same border color as the threat color
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actor5");
    assertEquals(getThreatColor(), ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }
}

