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
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.FlatContainerStyle;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.diagram.impl.SquareImpl;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.sirius.viewpoint.Style;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.Allocators;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class CyberOABDiagramTest extends EmptyProject {

  protected TransactionalEditingDomainHelper tedHelper;

  private FunctionalPrimaryAsset fpa;
  private InformationPrimaryAsset ipa;
  private Threat threat;

  @Override
  protected void undoAllChanges() {
    // don't undo anything
    // https://bugs.polarsys.org/show_bug.cgi?id=2686
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    Session session = getSession(getRequiredTestModel());
    tedHelper = new TransactionalEditingDomainHelper(session.getTransactionalEditingDomain());
  }

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);

    CyberOABDiagram diagram = CyberOABDiagram.createDiagram(context, OA__OPERATIONAL_ENTITIES);

    CybersecurityServices services = new CybersecurityServices();

    String e1 = diagram.createEntity("entity1", diagram.getDiagramId());
    String e2 = diagram.createEntity("entity2", diagram.getDiagramId());
    String f1 = diagram.createFunction("f1", e1);
    String f2 = diagram.createFunction("f2", e2);

    diagram.createFunctionalExchange(f1, f2, "interaction1");

    executeCommand(() -> {
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(OA__OPERATIONAL_ENTITIES));
      ipa = services.createInformationPrimaryAsset(context.getSemanticElement(OA__OPERATIONAL_ENTITIES));

      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember((ModelElement) diagram.getSemanticObjectMap().get(f1));

      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m2.setMember((ModelElement) diagram.getSemanticObjectMap().get(f2));

      fpa.getOwnedMembers().add(m1);
      fpa.getOwnedMembers().add(m2);
    });

    // now add the fpa, and check that function nodes have same border color as asset color
    diagram.insertPrimaryAsset(fpa);

    DNode fpaNode = (DNode) diagram.getView(fpa);
    RGBValues fpaColor = ((Square) fpaNode.getStyle()).getColor();

    DNode f1Node = (DNode) diagram.getViewObjectMap().get(f1);
    DNode f2Node = (DNode) diagram.getViewObjectMap().get(f2);

    assertEquals(fpaColor, ((Square) f1Node.getStyle()).getBorderColor());
    assertEquals(fpaColor, ((Square) f2Node.getStyle()).getBorderColor());

    executeCommand(() -> fpa.getOwnedMembers().clear());

    executeCommand(() -> {
      ExchangeItem ei1 = InformationFactory.eINSTANCE.createExchangeItem();
      ExchangeItem ei2 = InformationFactory.eINSTANCE.createExchangeItem();
      DataPkg p1 = context.getSemanticElement(OA__DATA);
      p1.getOwnedExchangeItems().add(ei1);
      p1.getOwnedExchangeItems().add(ei2);

      FunctionStorage f1Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f1Storage.getExchangedItems().add(ei1);
      ((AbstractFunction) diagram.getSemanticObjectMap().get("f1")).getOwnedExtensions().add(f1Storage);

      FunctionStorage f2Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f2Storage.getExchangedItems().add(ei1);
      ((AbstractFunction) diagram.getSemanticObjectMap().get("f2")).getOwnedExtensions().add(f2Storage);

      ((FunctionalExchange) diagram.getSemanticObjectMap().get("interaction1")).getExchangedItems().add(ei2);

      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(ei1);
      m2.setMember(ei2);
      ipa.getOwnedMembers().add(m1);
      ipa.getOwnedMembers().add(m2);

    });

    diagram.insertPrimaryAsset(ipa);

    DNode ipaNode = (DNode) diagram.getView(ipa);
    RGBValues ipaColor = ((Square) ipaNode.getStyle()).getColor();

    DEdge feEdge = diagram.getDiagram().getEdges().stream()
        .filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("interaction1")).findFirst().get();

    assertEquals(ipaColor, ((Square) f1Node.getStyle()).getBorderColor());
    assertEquals(ipaColor, ((Square) f2Node.getStyle()).getBorderColor());
    assertEquals(ipaColor, ((EdgeStyle) feEdge.getStyle()).getStrokeColor());

    executeCommand(() -> fpa.getOwnedMembers().clear());

    executeCommand(() -> {
      // create 2 entities in diagram
      String entity1Id = diagram.createEntity("e1", diagram.getDiagramId());
      String entity2Id = diagram.createEntity("e2", diagram.getDiagramId());

      // create an untrusted actor and a trusted one inside the previous ones
      String untrustedActorId = diagram.createActor("untrustedActor", entity1Id);
      String trustedActorId = diagram.createActor("trustedActor", entity2Id);

      AbstractType untrustedActor = ((Entity) diagram.getSemanticObjectMap().get("untrustedActor"));
      TrustBoundaryStorage storage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
      storage.setTrusted(false);
      untrustedActor.getOwnedExtensions().add(storage);

      // create activities inside the actors and an interaction between them
      String func1 = diagram.createFunction("func1", untrustedActorId);
      String func2 = diagram.createFunction("func2", trustedActorId);
      diagram.createFunctionalExchange(func1, func2, "functional exchange");
      FunctionalExchange functionalExchange = (FunctionalExchange) diagram.getSemanticObjectMap()
          .get("functional exchange");

      // create a communication mean between the 'container' entities
      diagram.createComponentExchange(entity1Id, entity2Id, "component exchange");
      ComponentExchange componentExchange = (ComponentExchange) diagram.getSemanticObjectMap()
          .get("component exchange");

      // add an allocated functional exchange to the component exchange
      Allocators.allocate(functionalExchange).on(componentExchange);

      assertTrue(CybersecurityQueries.isTrustBoundary(functionalExchange));
      assertTrue(CybersecurityQueries.isTrustBoundary(componentExchange));

    });

    executeCommand(() -> {
      // create an actor
      String actorId = diagram.createActor("actor", diagram.getDiagramId());

      // create three functions inside the actor and interactions between them
      String function1 = diagram.createFunction("function1", actorId);
      String function2 = diagram.createFunction("function2", actorId);
      String function3 = diagram.createFunction("function3", actorId);
      diagram.createFunctionalExchange(function1, function2, "functionalExchange");
      diagram.createFunctionalExchange(function2, function3, "functionalExchange2");

      // create two operational processes
      diagram.createFunctionalChain("path", "functionalExchange");
      FunctionalChain funcChain = (FunctionalChain) diagram.getSemanticObjectMap().get("path");

      diagram.createFunctionalChain("path2", "functionalExchange2");
      FunctionalChain funcChain2 = (FunctionalChain) diagram.getSemanticObjectMap().get("path2");

      // create a functional primary asset and add the operational processes as members
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(OA__OPERATIONAL_ENTITIES));
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(funcChain2);
      m1.setMember(funcChain);
      fpa.getOwnedMembers().add(m1);
      fpa.getOwnedMembers().add(m2);
      diagram.insertPrimaryAsset(fpa);

      // remove operational processes
      diagram.removeFunctionalChain("path");
      diagram.removeFunctionalChain("path2");

      // get view and style for one function and the primaryAsset
      DDiagramElement functionView = diagram.getView(diagram.getSemanticObjectMap().get("function1"));
      Style functionStyle = functionView.getStyle();
      DDiagramElement primaryAssetView = diagram.getView(diagram.getSemanticObjectMap().get(fpa.getId()));
      Style primaryAssetStyle = primaryAssetView.getStyle();

      // assert that the border color of the function and the primaryAsset are the same
      assertEquals(((SquareImpl) functionStyle).getBorderColor(), ((SquareImpl) primaryAssetStyle).getColor());

      // get view and style for the middle function
      DDiagramElement middleFunctionView = diagram.getView(diagram.getSemanticObjectMap().get("function2"));
      Style middleFunctionStyle = middleFunctionView.getStyle();

      assertEquals(((SquareImpl) middleFunctionStyle).getBorderColor(), ((SquareImpl) primaryAssetStyle).getColor());
    });

    executeCommand(() -> {
      // create an actor
      String actor3Id = diagram.createActor("actor3", diagram.getDiagramId());

      // create two functions inside the actor and a functional exchange between them
      String firstEntityId = diagram.createFunction("firstEntity", actor3Id);
      String secondEntityId = diagram.createFunction("secondEntity", actor3Id);
      diagram.createFunctionalExchange(firstEntityId, secondEntityId, "exchange");

      // create an exchange item and add to interfaces
      ExchangeItem exchangeItem1 = InformationFactory.eINSTANCE.createExchangeItem();
      InterfacePkg pkg = context.getSemanticElement(OA__INTERFACES);
      pkg.getOwnedExchangeItems().add(exchangeItem1);

      // add exchange item to functional exchange and information primary assets
      FunctionalExchange fe = (FunctionalExchange) diagram.getSemanticObjectMap().get("exchange");
      fe.getExchangedItems().add(exchangeItem1);
      PrimaryAssetMember member1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      member1.setMember(exchangeItem1);

      InformationPrimaryAsset ipa1 = services
          .createInformationPrimaryAsset(context.getSemanticElement(OA__OPERATIONAL_ENTITIES));
      ipa1.getOwnedMembers().add(member1);
      diagram.insertPrimaryAsset(ipa1);
      DDiagramElement exchangeView = diagram.getView(fe);
      Style exchangeStyle = exchangeView.getStyle();

      DDiagramElement informationAssetView = diagram.getView(diagram.getSemanticObjectMap().get(ipa1.getId()));
      Style informationAssetStyle = informationAssetView.getStyle();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor(), ((Square) informationAssetStyle).getColor());

      InformationPrimaryAsset ipa2 = services
          .createInformationPrimaryAsset(context.getSemanticElement(OA__OPERATIONAL_ENTITIES));
      PrimaryAssetMember member2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      member2.setMember(exchangeItem1);
      ipa2.getOwnedMembers().add(member2);
      diagram.insertPrimaryAsset(ipa2);
      diagram.refreshDiagram();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getBlue(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getRed(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getGreen(), 0);
    });

    // remove asset members to clear colorization
    executeCommand(() -> fpa.getOwnedMembers().clear());

    // scenario 1
    // create one entity, then another entity inside it
    String entOE1 = diagram.createEntity("entOE1", diagram.getDiagramId());
    String entOE2 = diagram.createEntity("entOE2", entOE1);

    // create one entity inside entOE2, then another entity inside it
    String entOE3 = diagram.createEntity("entOE3", entOE2);
    String entOE4 = diagram.createEntity("entOE4", entOE3);

    // create a function inside entOE4
    String function1 = diagram.createFunction("operationalInteraction1", entOE4);

    executeCommand(() -> {
      // create FunctionalPrimaryAsset and add function1 as member
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(OA__OPERATIONAL_ENTITIES));
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember((ModelElement) diagram.getSemanticObjectMap().get("operationalInteraction1"));
      fpa.getOwnedMembers().add(m1);

      diagram.insertPrimaryAsset(fpa);
      CyberDiagramLayers.activateLayer(session, diagram.getDiagram(),
          CybersecurityAnalysisConstants.LAYER_SUPPORTING_ASSETS);
      diagram.refreshDiagram();
    });
    Integer highlightedBorderSize = new Integer(5);
    Integer borderSize = new Integer(1);

    // check that function node has same border color as primary asset color
    fpaNode = (DNode) diagram.getView(fpa);
    fpaColor = ((Square) fpaNode.getStyle()).getColor();
    DNode fNode = (DNode) diagram.getViewObjectMap().get("operationalInteraction1");
    assertEquals(fpaColor, ((Square) fNode.getStyle()).getBorderColor());

    // check that first entity has same border color as primary asset color and highlighted border
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE4");
    assertEquals(fpaColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    // [TODO] - resolve bug
    // assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second entity has black border color and it is not highlighted
    RGBValues blackColor = RGBValues.create(0, 0, 0);
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE3");
    // [TODO] - resolve bug
    // assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that third entity has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE2");
    // [TODO] - resolve bug
    // assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that fourth entity has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE1");
    // [TODO] - resolve bug
    // assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // scenario 2
    // create threat, apply it to primary asset and add threat to diagram
    executeCommand(() -> {
      threat = services.createThreat(fpa);
      services.createThreatApplication(threat, fpa);
      diagram.insertThreat(threat);
      diagram.refreshDiagram();
    });

    // check that function node has black color (asset and threat present in the diagram)
    fNode = (DNode) diagram.getViewObjectMap().get("operationalInteraction1");
    assertEquals(blackColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    // check that first entity has black color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE2");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    // [TODO] - resolve bug
    // assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that third entity has black color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE4");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // scenario 3
    // remove primary asset from diagram
    diagram.removePrimaryAsset(fpa);

    // check that the function node has the same border color as the threat color
    DNode threatNode = (DNode) diagram.getView(threat);
    RGBValues threatColor = ((Square) threatNode.getStyle()).getColor();
    assertEquals(threatColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    // check that first entity has the same border color as the threat color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE2");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    // [TODO] - resolve bug
    // assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second entity has the same black color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entOE1");
    // [TODO] - resolve bug
    // assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // scenario 4
    // create one entity inside entOE1, then another entity inside it
    String entityOE1 = diagram.createEntity("entityOE1", entOE1);
    String entityOE2 = diagram.createEntity("entityOE2", entityOE1);

    // create one entity inside entityOE2, then an actor inside it
    String entityOE3 = diagram.createEntity("entityOE3", entityOE2);
    String actorOA1 = diagram.createActor("actorOA1", entityOE3);

    // create a function inside OA1
    String interaction3 = diagram.createFunction("interaction3", actorOA1);
    executeCommand(() -> {
      // add the new functions as members of primary asset
      PrimaryAssetMember m4 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m4.setMember((ModelElement) diagram.getSemanticObjectMap().get("interaction3"));
      fpa.getOwnedMembers().add(m4);
      diagram.refreshDiagram();
    });

    // check that the new function nodes have the same border color as the threat color
    fNode = (DNode) diagram.getViewObjectMap().get("interaction3");
    assertEquals(threatColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    // check that Operational Actor has same border color as the threat color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actorOA1");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    // [TODO] - resolve bug
    // assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that first entity has same border color as primary asset color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entityOE3");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    // [TODO] - resolve bug
    // assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second entity has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entityOE2");
    // [TODO] - resolve bug
    // assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that third entity has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("entityOE1");
    // [TODO] - resolve bug
    // assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

  }

  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }
}
