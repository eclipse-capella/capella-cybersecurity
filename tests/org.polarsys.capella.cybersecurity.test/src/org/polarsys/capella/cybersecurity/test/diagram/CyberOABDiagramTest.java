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

import org.eclipse.emf.transaction.RollbackException;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.test.common.Allocators;

public class CyberOABDiagramTest extends CyberXABDiagramTest {

  @Override
  protected String getSystemId() {
    return OA__OPERATIONAL_ENTITIES;
  }

  @Override
  protected String getDataPkgId() {
    return OA__DATA;
  }

  @Override
  protected String getInterfacePkgId() {
    return OA__INTERFACES;
  }

  @Override
  protected Type getType() {
    return Type.OA;
  }

  @Override
  protected String getRepresentationName() {
    return IDiagramNameConstants.OPERATIONAL_ENTITY_BLANK_DIAGRAM_NAME;
  }

  @Override
  protected CyberOABDiagram createDiagram() {
    return CyberOABDiagram.createDiagram(context, getSystemId());
  }

  @Override
  protected void createDiagramElements() {
    CyberOABDiagram diagram = (CyberOABDiagram) this.diagram;

    diagramElements.put("component1", diagram.createEntity("component1", diagram.getDiagramId()));
    diagramElements.put("component2", diagram.createEntity("component2", diagram.getDiagramId()));
    diagramElements.put("component3", diagram.createEntity("component3", diagram.getDiagramId()));
    diagramElements.put("component4", diagram.createEntity("component4", diagramElements.get("component3")));
    diagramElements.put("component5", diagram.createEntity("component5", diagramElements.get("component4")));
    diagramElements.put("component6", diagram.createEntity("component6", diagramElements.get("component5")));
    diagramElements.put("actor4", diagram.createEntity("actor4", diagramElements.get("component3")));
    diagramElements.put("actor5", diagram.createEntity("actor5", diagramElements.get("actor4")));
    diagramElements.put("component7", diagram.createEntity("component7", diagramElements.get("actor5")));
    diagramElements.put("component8", diagram.createEntity("component8", diagramElements.get("component7")));
  }

  @Override
  protected void insertPrimaryAsset(PrimaryAsset pa) {
    ((CyberOABDiagram) diagram).insertPrimaryAsset(pa);
  }

  @Override
  protected void removePrimaryAsset(PrimaryAsset pa) {
    ((CyberOABDiagram) diagram).removePrimaryAsset(pa);
  }

  @Override
  protected void insertThreat(Threat threat) {
    ((CyberOABDiagram) diagram).insertThreat(threat);
  }

  @Override
  protected void removeThreat(Threat threat) {
    ((CyberOABDiagram) diagram).removeThreat(threat);
  }

  @Override
  protected void step3() throws RollbackException, InterruptedException {
    CyberOABDiagram diagram = (CyberOABDiagram) this.diagram;

    // create 2 entities in diagram
    String entity1Id = diagram.createEntity("e1", diagram.getDiagramId());
    String entity2Id = diagram.createEntity("e2", diagram.getDiagramId());

    // create an untrusted actor and a trusted one inside the previous ones
    String untrustedActorId = diagram.createActor("untrustedActor", entity1Id);
    String trustedActorId = diagram.createActor("trustedActor", entity2Id);

    executeCommand(() -> {
      AbstractType untrustedActor = ((Entity) diagram.getSemanticObjectMap().get("untrustedActor"));
      TrustBoundaryStorage storage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
      storage.setTrusted(false);
      untrustedActor.getOwnedExtensions().add(storage);
    });
    // create activities inside the actors and an interaction between them
    String func1 = diagram.createFunction("func1", untrustedActorId);
    String func2 = diagram.createFunction("func2", trustedActorId);
    diagram.createFunctionalExchange(func1, func2, "functional exchange");
    FunctionalExchange functionalExchange = (FunctionalExchange) diagram.getSemanticObjectMap()
        .get("functional exchange");

    // create a communication mean between the 'container' entities
    diagram.createComponentExchange(entity1Id, entity2Id, "component exchange");
    ComponentExchange componentExchange = (ComponentExchange) diagram.getSemanticObjectMap().get("component exchange");

    executeCommand(() -> {
      // add an allocated functional exchange to the component exchange
      Allocators.allocate(functionalExchange).on(componentExchange);
    });

    assertTrue(CybersecurityQueries.isTrustBoundary(functionalExchange));
    assertTrue(CybersecurityQueries.isTrustBoundary(componentExchange));
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
