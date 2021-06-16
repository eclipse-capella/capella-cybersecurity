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
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.sirius.viewpoint.Style;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.cs.PhysicalLink;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.data.la.LogicalFunction;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
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

public class CyberLABDiagramTest extends EmptyProject {

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

  protected String getSystemId() {
    return LA__LOGICAL_SYSTEM;
  }

  protected String getDataPkgId() {
    return LA__DATA;
  }

  protected String getInterfacePkgId() {
    return LA__INTERFACES;
  }

  protected Type getType() {
    return Type.LA;
  }

  protected String getRepresentationName() {
    return IDiagramNameConstants.LOGICAL_ARCHITECTURE_BLANK_DIAGRAM_NAME;
  }
  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);

    CyberXABDiagram diagram = CyberXABDiagram.createDiagram(context, getSystemId(), getType(), getRepresentationName());

    String c1 = diagram.createComponent("comp1", diagram.getDiagramId());
    String c2 = diagram.createComponent("comp2", diagram.getDiagramId());

    String f1 = diagram.createFunction("f1", c1);
    String f2 = diagram.createFunction("f2", c2);
    diagram.createFunctionalExchange(f1, f2, "fe");

    CybersecurityServices services = new CybersecurityServices();

    executeCommand(() -> {
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(getSystemId()));
      ipa = services.createInformationPrimaryAsset(context.getSemanticElement(getSystemId()));

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

    // remove asset members to clear colorization
    executeCommand(() -> fpa.getOwnedMembers().clear());

    executeCommand(() -> {
      ExchangeItem ei1 = InformationFactory.eINSTANCE.createExchangeItem();
      ExchangeItem ei2 = InformationFactory.eINSTANCE.createExchangeItem();
      DataPkg p1 = context.getSemanticElement(getDataPkgId());
      p1.getOwnedExchangeItems().add(ei1);
      p1.getOwnedExchangeItems().add(ei2);

      FunctionStorage f1Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f1Storage.getExchangedItems().add(ei1);
      ((LogicalFunction) diagram.getSemanticObjectMap().get("f1")).getOwnedExtensions().add(f1Storage);

      FunctionStorage f2Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f2Storage.getExchangedItems().add(ei1);
      ((LogicalFunction) diagram.getSemanticObjectMap().get("f2")).getOwnedExtensions().add(f2Storage);

      ((FunctionalExchange) diagram.getSemanticObjectMap().get("fe")).getExchangedItems().add(ei2);

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
        .filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("fe")).findFirst().get();

    assertEquals(ipaColor, ((Square) f1Node.getStyle()).getBorderColor());
    assertEquals(ipaColor, ((Square) f2Node.getStyle()).getBorderColor());
    assertEquals(ipaColor, ((EdgeStyle) feEdge.getStyle()).getStrokeColor());

    executeCommand(() -> {
      // create 2 actors in diagram
      String actor1Id = diagram.createActor("actor1", diagram.getDiagramId());
      String actor2Id = diagram.createActor("actor2", diagram.getDiagramId());

      // create an untrusted actor and a trusted one inside the previous ones
      String untrustedActorId = diagram.createActor("untrustedActor", actor1Id);
      String trustedActorId = diagram.createActor("trustedActor", actor2Id);

      AbstractType untrustedActor = ((Part) diagram.getSemanticObjectMap().get("untrustedActor")).getAbstractType();
      TrustBoundaryStorage storage = CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage();
      storage.setTrusted(false);
      untrustedActor.getOwnedExtensions().add(storage);

      // create functions inside the actors and a functional exchange between them
      String func1 = diagram.createFunction("func1", untrustedActorId);
      String func2 = diagram.createFunction("func2", trustedActorId);
      diagram.createFunctionalExchange(func1, func2, "functional exchange");
      FunctionalExchange functionalExchange = (FunctionalExchange) diagram.getSemanticObjectMap()
          .get("functional exchange");

      // create a physical link between the actors
      diagram.createPhysicalLink(untrustedActorId, trustedActorId, "physical link");
      PhysicalLink physicalLink = (PhysicalLink) diagram.getSemanticObjectMap().get("physical link");

      // create a component exchange between the 'container' actors
      diagram.createComponentExchange(actor1Id, actor2Id, "component exchange");
      ComponentExchange componentExchange = (ComponentExchange) diagram.getSemanticObjectMap()
          .get("component exchange");

      // add an allocated functional exchange to the component exchange
      Allocators.allocate(functionalExchange).on(componentExchange);

      assertTrue(CybersecurityQueries.isTrustBoundary(functionalExchange));
      assertTrue(CybersecurityQueries.isTrustBoundary(physicalLink));
      assertTrue(CybersecurityQueries.isTrustBoundary(componentExchange));

    });

    executeCommand(() -> {
      // create an actor
      String actorId = diagram.createActor("actor", diagram.getDiagramId());

      // create three functions inside the actor and functional exchange between them
      String function1 = diagram.createFunction("function1", actorId);
      String function2 = diagram.createFunction("function2", actorId);
      String function3 = diagram.createFunction("function3", actorId);
      diagram.createFunctionalExchange(function1, function2, "functionalExchange");
      diagram.createFunctionalExchange(function2, function3, "functionalExchange2");

      // create two functional chains
      diagram.createFunctionalChain("path", "functionalExchange");
      FunctionalChain funcChain = (FunctionalChain) diagram.getSemanticObjectMap().get("path");

      diagram.createFunctionalChain("path2", "functionalExchange2");
      FunctionalChain funcChain2 = (FunctionalChain) diagram.getSemanticObjectMap().get("path2");

      // create a functional primary asset and add the functional chains as members
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(getSystemId()));
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(funcChain2);
      m1.setMember(funcChain);
      fpa.getOwnedMembers().add(m1);
      fpa.getOwnedMembers().add(m2);
      diagram.insertPrimaryAsset(fpa);

      // remove functional chains
      diagram.removeFunctionalChain("path");
      diagram.removeFunctionalChain("path2");

      // get view and style for one function and the primaryAsset
      DDiagramElement functionView = diagram.getView(diagram.getSemanticObjectMap().get("function1"));
      Style functionStyle = functionView.getStyle();
      DDiagramElement primaryAssetView = diagram.getView(diagram.getSemanticObjectMap().get(fpa.getId()));
      Style primaryAssetStyle = primaryAssetView.getStyle();

      // assert that the border color of the function and the primaryAsset are the same
      assertEquals(((Square) functionStyle).getBorderColor(), ((Square) primaryAssetStyle).getColor());

      // get view and style for the middle function
      DDiagramElement middleFunctionView = diagram.getView(diagram.getSemanticObjectMap().get("function2"));
      Style middleFunctionStyle = middleFunctionView.getStyle();

      assertEquals(((Square) middleFunctionStyle).getBorderColor(), ((Square) primaryAssetStyle).getColor());
    });

    executeCommand(() -> {
      // create an actor
      String actor3Id = diagram.createActor("actor3", diagram.getDiagramId());

      // create two functions inside the actor and a functional exchange between them
      String function1Id = diagram.createFunction("funct1", actor3Id);
      String function2Id = diagram.createFunction("funct2", actor3Id);
      diagram.createFunctionalExchange(function1Id, function2Id, "exchange");

      // create an exchange item and add to interfaces
      ExchangeItem exchangeItem1 = InformationFactory.eINSTANCE.createExchangeItem();
      InterfacePkg pkg = context.getSemanticElement(getInterfacePkgId());
      pkg.getOwnedExchangeItems().add(exchangeItem1);

      // add exchange item to functional exchange and information primary assets
      FunctionalExchange fe = (FunctionalExchange) diagram.getSemanticObjectMap().get("exchange");
      fe.getExchangedItems().add(exchangeItem1);
      PrimaryAssetMember member1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      member1.setMember(exchangeItem1);

      InformationPrimaryAsset ipa1 = services
          .createInformationPrimaryAsset(context.getSemanticElement(getSystemId()));
      ipa1.getOwnedMembers().add(member1);
      diagram.insertPrimaryAsset(ipa1);
      DDiagramElement exchangeView = diagram.getView(fe);
      Style exchangeStyle = exchangeView.getStyle();

      DDiagramElement informationAssetView = diagram.getView(diagram.getSemanticObjectMap().get(ipa1.getId()));
      Style informationAssetStyle = informationAssetView.getStyle();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor(), ((Square) informationAssetStyle).getColor());

      InformationPrimaryAsset ipa2 = services
          .createInformationPrimaryAsset(context.getSemanticElement(getSystemId()));
      PrimaryAssetMember member2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      member2.setMember(exchangeItem1);
      ipa2.getOwnedMembers().add(member2);
      diagram.insertPrimaryAsset(ipa2);
      diagram.refreshDiagram();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getBlue(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getRed(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getGreen(), 0);
    });

    // Support Assets layer
    // remove asset members to clear colorization
    executeCommand(() -> fpa.getOwnedMembers().clear());

    // scenario 1
    // create one LC component, then another LC component inside it
    String compLC1 = diagram.createComponent("compLC1", diagram.getDiagramId());
    String compLC2 = diagram.createComponent("compLC2", compLC1);


    // create one LC component inside LC2, then another LC component inside it
    String compLC3 = diagram.createComponent("compLC3", compLC2);
    String compLC4 = diagram.createComponent("compLC4", compLC3);

    // create LogicalFunction inside LC4
    String logicalFunction1 = diagram.createFunction("logicalFunction1", compLC4);

    executeCommand(() -> {
      // create FunctionalPrimaryAsset and add LogicalFunction1 as member
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(getSystemId()));
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember((ModelElement) diagram.getSemanticObjectMap().get("logicalFunction1"));
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
    DNode fNode = (DNode) diagram.getViewObjectMap().get("logicalFunction1");
    assertEquals(fpaColor, ((Square) fNode.getStyle()).getBorderColor());


    // check that first component has same border color as primary asset color and highlighted border
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC4");
    assertEquals(fpaColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that fourth component has black border color and it is not highlighted
    RGBValues blackColor = RGBValues.create(0, 0, 0);
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC1");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that third component has has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC2");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second behavior component has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC3");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
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
    fNode = (DNode) diagram.getViewObjectMap().get("logicalFunction1");
    assertEquals(blackColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    // check that first component has black color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC4");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // scenario 3
    // remove primary asset from diagram
    diagram.removePrimaryAsset(fpa);

    // check that the function node has the same border color as the threat color
    DNode threatNode = (DNode) diagram.getView(threat);
    RGBValues threatColor = ((Square) threatNode.getStyle()).getColor();
    assertEquals(threatColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    // check that first component has the same border color as the threat color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC4");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // scenario 4
    // create one Actor inside first NPC component, then another Actor inside it
    String actorLA1 = diagram.createActor("actorLA1", compLC1);
    String actorLA2 = diagram.createActor("actorLA2", actorLA1);

    // create one LC component inside actorLA2, then another LC component inside it
    String compLC5 = diagram.createComponent("compLC5", actorLA2);
    String compLC6 = diagram.createComponent("compLC6", compLC5);

    // create LogicalFunction inside LC6
    String logicalFunction3 = diagram.createFunction("logicalFunction3", compLC6);
    executeCommand(() -> {
      // add the new functions as members of primary asset
      PrimaryAssetMember m4 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m4.setMember((ModelElement) diagram.getSemanticObjectMap().get("logicalFunction3"));
      fpa.getOwnedMembers().add(m4);
      diagram.refreshDiagram();
    });

    // check that the new function nodes have the same border color as the threat color
    fNode = (DNode) diagram.getViewObjectMap().get("logicalFunction3");
    assertEquals(threatColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    // check that first component has same border color as primary asset color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC6");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that first Actor has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actorLA2");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second Physical Actor has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actorLA1");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second component has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compLC5");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // scenario 5
    // create a component exchange between the 'container' actors
    diagram.createComponentExchange(compLC3, compLC5, "CE1");
    ComponentExchange componentExchange = (ComponentExchange) diagram.getSemanticObjectMap().get("CE1");

    // create an exchange item and add to interfaces
    ExchangeItem exchangeItem1 = InformationFactory.eINSTANCE.createExchangeItem();
    InterfacePkg pkg = context.getSemanticElement(getInterfacePkgId());
    executeCommand(() -> {
      pkg.getOwnedExchangeItems().add(exchangeItem1);

      // add exchange item to functional exchange and information primary assets
      diagram.createFunctionalExchange(logicalFunction1, logicalFunction3, "functionalExchange1");
      FunctionalExchange functionalExchange = (FunctionalExchange) diagram.getSemanticObjectMap()
          .get("functionalExchange1");
      functionalExchange.getExchangedItems().add(exchangeItem1);
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(exchangeItem1);
      ipa = services.createInformationPrimaryAsset(context.getSemanticElement(getSystemId()));
      ipa.getOwnedMembers().add(m1);
      services.createThreatApplication(threat, ipa);

      // add an allocated functional exchange to the component exchange
      Allocators.allocate(functionalExchange).on(componentExchange);
    });

    // check physical link and component exchange have same color as threat color
    DEdge componentExchangeEdge = diagram.getDiagram().getEdges().stream()
        .filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("CE1")).findFirst().get();
    assertEquals(threatColor, ((EdgeStyle) componentExchangeEdge.getStyle()).getStrokeColor());
    assertEquals(highlightedBorderSize, ((EdgeStyle) componentExchangeEdge.getStyle()).getSize());

    // this dumps a screenshot..
    // ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
    // IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel()
    // + "/png.gif"));
    // DialectUIManager.INSTANCE.export(diagram.getDiagram(), session, dest, format, new NullProgressMonitor());

  }

  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }
}
