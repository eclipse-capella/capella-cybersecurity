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
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.Ellipse;
import org.eclipse.sirius.diagram.FlatContainerStyle;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.diagram.impl.SquareImpl;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.sirius.viewpoint.Style;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.cs.PhysicalLink;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentExchangeAllocation;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
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

public class CyberPABDiagramTest extends EmptyProject {

  protected TransactionalEditingDomainHelper tedHelper;
  
  private FunctionalPrimaryAsset fpa;
  private InformationPrimaryAsset ipa;
  private Threat threat;

  @Override
  protected void undoAllChanges() {
    //don't undo anything
    //https://bugs.polarsys.org/show_bug.cgi?id=2686
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

    CyberPABDiagram diagram = CyberPABDiagram.createDiagram(context, PA__PHYSICAL_SYSTEM);
  
    String c1 = diagram.createBehaviorComponent("comp1", diagram.getDiagramId());
    String c2 = diagram.createBehaviorComponent("comp2", diagram.getDiagramId());
    
    String f1 = diagram.createFunction("f1", c1);
    String f2 = diagram.createFunction("f2", c2);
    diagram.createFunctionalExchange(f1, f2, "fe");

    CybersecurityServices services = new CybersecurityServices();

    executeCommand(() -> 
      {
        fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));
        ipa = services.createInformationPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));

        PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
        m1.setMember((ModelElement) diagram.getSemanticObjectMap().get(f1));

        PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
        m2.setMember((ModelElement) diagram.getSemanticObjectMap().get(f2));

        fpa.getOwnedMembers().add(m1);
        fpa.getOwnedMembers().add(m2);
      }
    );

    // now add the fpa, and check that function nodes have same border color as asset color
    diagram.insertPrimaryAsset(fpa);


    DNode fpaNode = (DNode) diagram.getView(fpa);
    RGBValues fpaColor = ((Ellipse) fpaNode.getStyle()).getColor();

    DNode f1Node = (DNode) diagram.getViewObjectMap().get(f1);
    DNode f2Node = (DNode) diagram.getViewObjectMap().get(f2);
    
    assertEquals(fpaColor, ((Square)f1Node.getStyle()).getBorderColor());
    assertEquals(fpaColor, ((Square)f2Node.getStyle()).getBorderColor());

    // remove asset members to clear colorization
    executeCommand(() -> fpa.getOwnedMembers().clear());
    
    executeCommand(() -> {
      ExchangeItem ei1 = InformationFactory.eINSTANCE.createExchangeItem();
      ExchangeItem ei2 = InformationFactory.eINSTANCE.createExchangeItem();
      DataPkg p1 = context.getSemanticElement(PA__DATA);
      p1.getOwnedExchangeItems().add(ei1);
      p1.getOwnedExchangeItems().add(ei2);

      FunctionStorage f1Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f1Storage.getExchangedItems().add(ei1);
      ((PhysicalFunction)diagram.getSemanticObjectMap().get("f1")).getOwnedExtensions().add(f1Storage);
      
      FunctionStorage f2Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f2Storage.getExchangedItems().add(ei1);
      ((PhysicalFunction)diagram.getSemanticObjectMap().get("f2")).getOwnedExtensions().add(f2Storage);

      ((FunctionalExchange)diagram.getSemanticObjectMap().get("fe")).getExchangedItems().add(ei2);

      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(ei1);
      m2.setMember(ei2);
      ipa.getOwnedMembers().add(m1);
      ipa.getOwnedMembers().add(m2);

    });

    diagram.insertPrimaryAsset(ipa);

    DNode ipaNode = (DNode) diagram.getView(ipa);
    RGBValues ipaColor = ((Ellipse) ipaNode.getStyle()).getColor();

    DEdge feEdge = diagram.getDiagram().getEdges().stream().filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("fe")).findFirst().get();

    assertEquals(ipaColor, ((Square)f1Node.getStyle()).getBorderColor());
    assertEquals(ipaColor, ((Square)f2Node.getStyle()).getBorderColor());
    assertEquals(ipaColor, ((EdgeStyle)feEdge.getStyle()).getStrokeColor());
    
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
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));
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
      assertEquals(((Square) functionStyle).getBorderColor(), ((Ellipse) primaryAssetStyle).getColor());

      // get view and style for the middle function
      DDiagramElement middleFunctionView = diagram.getView(diagram.getSemanticObjectMap().get("function2"));
      Style middleFunctionStyle = middleFunctionView.getStyle();

      assertEquals(((Square) middleFunctionStyle).getBorderColor(), ((Ellipse) primaryAssetStyle).getColor());
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
      InterfacePkg pkg = context.getSemanticElement(PA__INTERFACES);
      pkg.getOwnedExchangeItems().add(exchangeItem1);

      // add exchange item to functional exchange and information primary assets
      FunctionalExchange fe = (FunctionalExchange) diagram.getSemanticObjectMap().get("exchange");
      fe.getExchangedItems().add(exchangeItem1);
      PrimaryAssetMember member1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      member1.setMember(exchangeItem1);

      InformationPrimaryAsset ipa1 = services
          .createInformationPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));
      ipa1.getOwnedMembers().add(member1);
      diagram.insertPrimaryAsset(ipa1);
      DDiagramElement exchangeView = diagram.getView(fe);
      Style exchangeStyle = exchangeView.getStyle();

      DDiagramElement informationAssetView = diagram.getView(diagram.getSemanticObjectMap().get(ipa1.getId()));
      Style informationAssetStyle = informationAssetView.getStyle();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor(), ((Ellipse) informationAssetStyle).getColor());

      InformationPrimaryAsset ipa2 = services
          .createInformationPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));
      PrimaryAssetMember member2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      member2.setMember(exchangeItem1);
      ipa2.getOwnedMembers().add(member2);
      diagram.insertPrimaryAsset(ipa2);
      diagram.refreshDiagram();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getBlue(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getRed(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getGreen(), 0);
    });
    
    
    //Support Assets layer 
    // remove asset members to clear colorization
    executeCommand(() -> fpa.getOwnedMembers().clear());  
    
    //scenario 1
    //create one NPC component, then another NPC component inside it
    String compNPC1 = diagram.createNodeComponent("compNPC1", diagram.getDiagramId());
    String compNPC2 = diagram.createNodeComponent("compNPC2", compNPC1);
    
    //create one BPC component inside NPC2, then another BPC component inside it
    String compBPC3 = diagram.createDeployedBehaviorComponent("compBPC3", compNPC2);
    String compBPC4 = diagram.createDeployedBehaviorComponent("compBPC4", compBPC3);
    
    //create PhysicalFunction inside BPC4
    String physicalFunction1 = diagram.createFunction("physicalFunction1", compBPC4);
    
    executeCommand(() -> {    
      //create FunctionalPrimaryAsset and add PhysicalFunction1 as member
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember((ModelElement) diagram.getSemanticObjectMap().get("physicalFunction1"));
      fpa.getOwnedMembers().add(m1);    
    
      diagram.insertPrimaryAsset(fpa);
      CyberDiagramLayers.activateLayer(session, diagram.getDiagram(), CybersecurityAnalysisConstants.LAYER_SUPPORTING_ASSETS);
      diagram.refreshDiagram(); 
    }); 
    Integer highlightedBorderSize = new Integer(5);
    Integer borderSize = new Integer(1);
    
    //check that function node has same border color as primary asset color
    fpaNode = (DNode) diagram.getView(fpa);
    fpaColor = ((Ellipse) fpaNode.getStyle()).getColor();
    DNode fNode = (DNode) diagram.getViewObjectMap().get("physicalFunction1");
    assertEquals(fpaColor, ((Square) fNode.getStyle()).getBorderColor());

    //check that first node component has same border color as primary asset color and highlighted border
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compNPC2");
    assertEquals(fpaColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that first behavior component has same border color as primary asset color and highlighted border
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compBPC4");
    assertEquals(fpaColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that second node component has black border color and it is not highlighted
    RGBValues blackColor = RGBValues.create(0, 0, 0);
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compNPC1");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that second behavior component has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compBPC3");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //scenario 2
    //create threat, apply it to primary asset and add threat to diagram
    executeCommand(() -> {
      threat = services.createThreat(fpa);
      services.createThreatApplication(threat, fpa);
      diagram.insertThreat(threat);
      diagram.refreshDiagram();
    });
    
    //check that function node has black color (asset and threat present in the diagram)
    fNode = (DNode) diagram.getViewObjectMap().get("physicalFunction1");
    assertEquals(blackColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    //check that first node component has black color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compNPC2");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that first behavior component has black color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compBPC4");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    
    //scenario 3
    //remove primary asset from diagram
    diagram.removePrimaryAsset(fpa);
    
    //check that the function node has the same border color as the threat color
    DNode threatNode = (DNode) diagram.getView(threat);
    RGBValues threatColor = ((Ellipse) threatNode.getStyle()).getColor();
    assertEquals(threatColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());

    //check that first node component has the same border color as the threat color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compNPC2");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that first behavior component has the same border color as the threat color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compBPC4");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //scenario 4
    //create one Physical Actor inside first NPC component, then another Physical Actor inside it
    String actorPA1 = diagram.createNodeComponent("actorPA1", compNPC1);
    String actorPA2 = diagram.createNodeComponent("actorPA2", actorPA1);
    
    //create one BPC component inside actorPA2, then another BPC component inside it
    String compBPC5 = diagram.createDeployedBehaviorComponent("compBPC5", actorPA2);
    String compBPC6 = diagram.createDeployedBehaviorComponent("compBPC6", compBPC5);
    
    //create PhysicalFunction inside BPC6
    String physicalFunction3 = diagram.createFunction("physicalFunction3", compBPC6);
    executeCommand(() -> {
      //add the new functions as members of primary asset
      PrimaryAssetMember m4 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m4.setMember((ModelElement) diagram.getSemanticObjectMap().get("physicalFunction3"));
      fpa.getOwnedMembers().add(m4);
      diagram.refreshDiagram();
    });
    
    //check that the new function nodes have the same border color as the threat color
    fNode = (DNode) diagram.getViewObjectMap().get("physicalFunction3");
    assertEquals(threatColor, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((Square) fNode.getStyle()).getBorderSize());
    
    //check that first Physical Actor has same border color as the threat color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actorPA2");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that first behavior component has same border color as primary asset color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compBPC6");
    assertEquals(threatColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(highlightedBorderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that second Physical Actor has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actorPA1");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //check that second behavior component has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("compBPC5");
    assertEquals(blackColor, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(borderSize, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
    
    //scenario 5
    // create a component exchange between the 'container' actors
    diagram.createComponentExchange(compBPC3, compBPC5, "CE1");
    ComponentExchange componentExchange = (ComponentExchange) diagram.getSemanticObjectMap().get("CE1");

    //create an exchange item and add to interfaces
    ExchangeItem exchangeItem1 = InformationFactory.eINSTANCE.createExchangeItem();
    InterfacePkg pkg = context.getSemanticElement(PA__INTERFACES);
    executeCommand(() -> {
      pkg.getOwnedExchangeItems().add(exchangeItem1);

      // add exchange item to functional exchange and information primary assets
      diagram.createFunctionalExchange(physicalFunction1, physicalFunction3, "functionalExchange1");
      FunctionalExchange functionalExchange = (FunctionalExchange) diagram.getSemanticObjectMap().get("functionalExchange1");
      functionalExchange.getExchangedItems().add(exchangeItem1);
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(exchangeItem1);
      ipa = services.createInformationPrimaryAsset(context.getSemanticElement(PA__PHYSICAL_SYSTEM));
      ipa.getOwnedMembers().add(m1);
      services.createThreatApplication(threat, ipa);

      // add an allocated functional exchange to the component exchange
      Allocators.allocate(functionalExchange).on(componentExchange);
    
      // create a physical link between components and allocate component exchange
      diagram.createPhysicalLink(compNPC2, compNPC1, "PL1");   
      PhysicalLink physicalLink = (PhysicalLink) diagram.getSemanticObjectMap().get("PL1");
      ComponentExchangeAllocation a1 = FaFactory.eINSTANCE.createComponentExchangeAllocation();
      a1.setSourceElement(physicalLink);
      a1.setTargetElement(componentExchange);
      physicalLink.getOwnedComponentExchangeAllocations().add(a1);
    });
    
    //check physical link and component exchange have same color as threat color
    DEdge componentExchangeEdge = diagram.getDiagram().getEdges()
        .stream().filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("CE1"))
        .findFirst().get();
    assertEquals(threatColor, ((EdgeStyle) componentExchangeEdge.getStyle()).getStrokeColor());
    assertEquals(highlightedBorderSize, ((EdgeStyle) componentExchangeEdge.getStyle()).getSize());
    
    DEdge physicalLinkEdge = diagram.getDiagram().getEdges()
        .stream().filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("PL1"))
        .findFirst().get();
    assertEquals(threatColor, ((EdgeStyle) physicalLinkEdge.getStyle()).getStrokeColor());
    assertEquals(highlightedBorderSize, ((EdgeStyle) physicalLinkEdge.getStyle()).getSize());
    
//    this dumps a screenshot..
//    ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
//    IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel() + "/png.gif"));
//    DialectUIManager.INSTANCE.export(diagram.getDiagram(), session, dest, format, new NullProgressMonitor());

  }


  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }

}

