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

import java.util.HashMap;

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
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentExchangeAllocation;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.Allocators;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.capella.test.diagram.common.ju.context.XABDiagram;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public abstract class CyberXABDiagramTest extends EmptyProject {

  protected TransactionalEditingDomainHelper tedHelper;

  protected FunctionalPrimaryAsset fpa;
  protected InformationPrimaryAsset ipa;
  protected Threat threat;

  protected HashMap<String, String> diagramElements;
  protected SessionContext context;
  protected Session session;
  protected XABDiagram diagram;
  protected CybersecurityServices services;

  protected final static RGBValues BLACK_COLOR = RGBValues.create(0, 0, 0);
  protected final static Integer HIGHLIGHTED_BORDER_SIZE = new Integer(5);
  protected final static Integer NORMAL_BORDER_SIZE = new Integer(1);

  protected abstract String getSystemId();

  protected abstract String getDataPkgId();

  protected abstract String getInterfacePkgId();

  protected abstract Type getType();

  protected abstract String getRepresentationName();

  protected abstract XABDiagram createDiagram();

  protected abstract void insertPrimaryAsset(PrimaryAsset pa);

  protected abstract void removePrimaryAsset(PrimaryAsset pa);

  protected abstract void insertThreat(Threat threat);

  protected abstract void createDiagramElements();

  protected RGBValues getFpaColor() {
    return ((Square) diagram.getView(fpa).getStyle()).getColor();
  }

  protected RGBValues getIpaColor() {
    return ((Square) diagram.getView(ipa).getStyle()).getColor();
  }

  protected RGBValues getThreatColor() {
    return ((Square) diagram.getView(threat).getStyle()).getColor();
  }

  protected void checkComponentLooksNormal(String component) {
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get(component);
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(NORMAL_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }


  @Override
  protected void undoAllChanges() {
    // don't undo anything
    // https://bugs.polarsys.org/show_bug.cgi?id=2686
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    session = getSession(getRequiredTestModel());
    context = new SessionContext(session);
    ViewpointManager manager = ViewpointManager.getInstance(session.getTransactionalEditingDomain().getResourceSet());
    manager.activate(CybersecurityAnalysisConstants.VIEWPOINT_ID);
    tedHelper = new TransactionalEditingDomainHelper(session.getTransactionalEditingDomain());
    diagramElements = new HashMap<>();
    diagram = createDiagram();
    services = new CybersecurityServices();
    createDiagramElements();
  }


  protected void step1() throws RollbackException, InterruptedException {
    String component1 = diagramElements.get("component1");
    String component2 = diagramElements.get("component2");

    String function1 = diagram.createFunction("function1", component1);
    String function2 = diagram.createFunction("function2", component2);
    diagramElements.put("function1", function1);
    diagramElements.put("function2", function2);
    diagram.createFunctionalExchange(function1, function2, "fe");

    executeCommand(() -> {
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(getSystemId()));
      ipa = services.createInformationPrimaryAsset(context.getSemanticElement(getSystemId()));

      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember((ModelElement) diagram.getSemanticObjectMap().get(function1));

      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m2.setMember((ModelElement) diagram.getSemanticObjectMap().get(function2));

      fpa.getOwnedMembers().add(m1);
      fpa.getOwnedMembers().add(m2);
    });

    // now add the fpa, and check that function nodes have same border color as asset color
    insertPrimaryAsset(fpa);

    DNode f1Node = (DNode) diagram.getViewObjectMap().get(function1);
    DNode f2Node = (DNode) diagram.getViewObjectMap().get(function2);

    assertEquals(getFpaColor(), ((Square) f1Node.getStyle()).getBorderColor());
    assertEquals(getFpaColor(), ((Square) f2Node.getStyle()).getBorderColor());

  }

  protected void step2() throws RollbackException, InterruptedException {

    DNode f1Node = (DNode) diagram.getViewObjectMap().get(diagramElements.get("function1"));
    DNode f2Node = (DNode) diagram.getViewObjectMap().get(diagramElements.get("function2"));

    executeCommand(() -> {
      ExchangeItem ei1 = InformationFactory.eINSTANCE.createExchangeItem();
      ExchangeItem ei2 = InformationFactory.eINSTANCE.createExchangeItem();
      DataPkg p1 = context.getSemanticElement(getDataPkgId());
      p1.getOwnedExchangeItems().add(ei1);
      p1.getOwnedExchangeItems().add(ei2);

      FunctionStorage f1Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f1Storage.getExchangedItems().add(ei1);
      ((AbstractFunction) diagram.getSemanticObjectMap().get("function1")).getOwnedExtensions().add(f1Storage);

      FunctionStorage f2Storage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
      f2Storage.getExchangedItems().add(ei1);
      ((AbstractFunction) diagram.getSemanticObjectMap().get("function2")).getOwnedExtensions().add(f2Storage);

      ((FunctionalExchange) diagram.getSemanticObjectMap().get("fe")).getExchangedItems().add(ei2);

      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      PrimaryAssetMember m2 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember(ei1);
      m2.setMember(ei2);
      ipa.getOwnedMembers().add(m1);
      ipa.getOwnedMembers().add(m2);

    });

    insertPrimaryAsset(ipa);

    DEdge feEdge = diagram.getDiagram().getEdges().stream()
        .filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("fe")).findFirst().get();

    assertEquals(getIpaColor(), ((Square) f1Node.getStyle()).getBorderColor());
    assertEquals(getIpaColor(), ((Square) f2Node.getStyle()).getBorderColor());
    assertEquals(getIpaColor(), ((EdgeStyle) feEdge.getStyle()).getStrokeColor());
  }

  protected void step3() throws RollbackException, InterruptedException {

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
      String function3 = diagram.createFunction("function3", untrustedActorId);
      String function4 = diagram.createFunction("function4", trustedActorId);
      diagram.createFunctionalExchange(function3, function4, "functional exchange");
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
  }
  
  protected void step4() throws RollbackException, InterruptedException {
    executeCommand(() -> {
      // create an actor
      String actorId = diagram.createActor("actor", diagram.getDiagramId());

      // create three functions inside the actor and functional exchange between them
      String function5 = diagram.createFunction("function5", actorId);
      String function6 = diagram.createFunction("function6", actorId);
      String function7 = diagram.createFunction("function7", actorId);
      diagram.createFunctionalExchange(function5, function6, "functionalExchange");
      diagram.createFunctionalExchange(function6, function7, "functionalExchange2");

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
      insertPrimaryAsset(fpa);

      // remove functional chains
      diagram.removeFunctionalChain("path");
      diagram.removeFunctionalChain("path2");

      // get view and style for one function and the primaryAsset
      DDiagramElement functionView = diagram.getView(diagram.getSemanticObjectMap().get("function5"));
      Style functionStyle = functionView.getStyle();
      DDiagramElement primaryAssetView = diagram.getView(diagram.getSemanticObjectMap().get(fpa.getId()));
      Style primaryAssetStyle = primaryAssetView.getStyle();

      // assert that the border color of the function and the primaryAsset are the same
      assertEquals(((Square) functionStyle).getBorderColor(), ((Square) primaryAssetStyle).getColor());

      // get view and style for the middle function
      DDiagramElement middleFunctionView = diagram.getView(diagram.getSemanticObjectMap().get("function6"));
      Style middleFunctionStyle = middleFunctionView.getStyle();

      assertEquals(((Square) middleFunctionStyle).getBorderColor(), ((Square) primaryAssetStyle).getColor());
    });
  }

  protected void step5() throws RollbackException, InterruptedException {
    executeCommand(() -> {
      // create an actor
      String actor3Id = diagram.createActor("actor3", diagram.getDiagramId());

      // create two functions inside the actor and a functional exchange between them
      String function8 = diagram.createFunction("function8", actor3Id);
      String function9 = diagram.createFunction("function9", actor3Id);
      diagram.createFunctionalExchange(function8, function9, "exchange");

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
      insertPrimaryAsset(ipa1);
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
      insertPrimaryAsset(ipa2);
      diagram.refreshDiagram();
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getBlue(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getRed(), 0);
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor().getGreen(), 0);
    });
  }

  protected void step6() throws RollbackException, InterruptedException {
    // scenario 1
    // create 4 components, one inside the other
    String component3 = diagramElements.get("component3");
    String component4 = diagramElements.get("component4");
    String component5 = diagramElements.get("component5");
    String component6 = diagramElements.get("component6");

    // create Function inside the last created component
    String function10 = diagram.createFunction("function10", component6);

    diagramElements.put("function10", function10);

    executeCommand(() -> {
      // create FunctionalPrimaryAsset and add the function as member
      fpa = services.createFunctionalPrimaryAsset(context.getSemanticElement(getSystemId()));
      PrimaryAssetMember m1 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m1.setMember((ModelElement) diagram.getSemanticObjectMap().get("function10"));
      fpa.getOwnedMembers().add(m1);

      insertPrimaryAsset(fpa);
      CyberDiagramLayers.activateLayer(session, diagram.getDiagram(),
          CybersecurityAnalysisConstants.LAYER_SUPPORTING_ASSETS);
      diagram.refreshDiagram();
    });

    // check that function node has same border color as primary asset color
    DNode fNode = (DNode) diagram.getViewObjectMap().get("function10");
    assertEquals(getFpaColor(), ((Square) fNode.getStyle()).getBorderColor());

    // check that first component has same border color as primary asset color and highlighted border
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component6");
    assertEquals(getFpaColor(), ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that fourth component has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component3");
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(NORMAL_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second component has black border color and it is not highlighted
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component5");
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(NORMAL_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }

  protected void step7() throws RollbackException, InterruptedException {
    // scenario 2
    // create threat, apply it to primary asset and add threat to diagram
    executeCommand(() -> {
      threat = services.createThreat(fpa);
      services.createThreatApplication(threat, fpa);
      insertThreat(threat);
      diagram.refreshDiagram();
    });

    // check that function node has black color (asset and threat present in the diagram)
    DNode fNode = (DNode) diagram.getViewObjectMap().get("function10");
    assertEquals(BLACK_COLOR, ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((Square) fNode.getStyle()).getBorderSize());

    // check that first component has black color and highlighted border size
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component6");
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }

  protected void step8() {
    // scenario 3
    // remove primary asset from diagram
    removePrimaryAsset(fpa);
    DNode fNode = (DNode) diagram.getViewObjectMap().get("function10");

    // check that the function node has the same border color as the threat color
    assertEquals(getThreatColor(), ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((Square) fNode.getStyle()).getBorderSize());

    // check that first component has the same border color as the threat color
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component6");
    assertEquals(getThreatColor(), ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

  }

  protected void step9() throws RollbackException, InterruptedException {
    // scenario 4
    // create one Actor inside first component, then another Actor inside it
    String actor4 = diagramElements.get("actor4");
    String actor5 = diagramElements.get("actor5");

    // create one component inside actor5, then another component inside it
    String component7 = diagramElements.get("component7");
    String component8 = diagramElements.get("component8");

    // create Function inside the last component
    String function11 = diagram.createFunction("function11", component8);
    executeCommand(() -> {
      // add the new functions as members of primary asset
      PrimaryAssetMember m4 = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m4.setMember((ModelElement) diagram.getSemanticObjectMap().get("function11"));
      fpa.getOwnedMembers().add(m4);
      diagram.refreshDiagram();
    });

    diagramElements.put("function11", function11);
    // check that the new function nodes have the same border color as the threat color
    DNode fNode = (DNode) diagram.getViewObjectMap().get("function11");
    assertEquals(getThreatColor(), ((Square) fNode.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((Square) fNode.getStyle()).getBorderSize());

    // check that first component has same border color as primary asset color
    DNodeContainer fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component8");
    assertEquals(getThreatColor(), ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second Actor has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("actor4");
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(NORMAL_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());

    // check that second component has black border color
    fNodeContainer = (DNodeContainer) diagram.getViewObjectMap().get("component7");
    assertEquals(BLACK_COLOR, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderColor());
    assertEquals(NORMAL_BORDER_SIZE, ((FlatContainerStyle) fNodeContainer.getStyle()).getBorderSize());
  }

  protected void step10() throws RollbackException, InterruptedException {
    // scenario 5
    // create a component exchange between the 'container' actors
    diagram.createComponentExchange(diagramElements.get("component5"), diagramElements.get("component7"), "CE1");
    ComponentExchange componentExchange = (ComponentExchange) diagram.getSemanticObjectMap().get("CE1");

    // create an exchange item and add to interfaces
    ExchangeItem exchangeItem1 = InformationFactory.eINSTANCE.createExchangeItem();
    InterfacePkg pkg = context.getSemanticElement(getInterfacePkgId());
    executeCommand(() -> {
      pkg.getOwnedExchangeItems().add(exchangeItem1);

      // add exchange item to functional exchange and information primary assets
      diagram.createFunctionalExchange(diagramElements.get("function10"), diagramElements.get("function11"),
          "functionalExchange1");
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
    assertEquals(getThreatColor(), ((EdgeStyle) componentExchangeEdge.getStyle()).getStrokeColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((EdgeStyle) componentExchangeEdge.getStyle()).getSize());

    step10CreateAndCheckPhysicalLink(componentExchange);
  }

  protected void step10CreateAndCheckPhysicalLink(ComponentExchange componentExchange)
      throws RollbackException, InterruptedException {
    executeCommand(() -> {
    // create a physical link between components and allocate component exchange
    diagram.createPhysicalLink(diagramElements.get("component4"), diagramElements.get("component3"), "PL1");
    PhysicalLink physicalLink = (PhysicalLink) diagram.getSemanticObjectMap().get("PL1");
    ComponentExchangeAllocation a1 = FaFactory.eINSTANCE.createComponentExchangeAllocation();
    a1.setSourceElement(physicalLink);
    a1.setTargetElement(componentExchange);
    physicalLink.getOwnedComponentExchangeAllocations().add(a1);
    });
    DEdge physicalLinkEdge = diagram.getDiagram().getEdges().stream()
        .filter(e -> e.getTarget() == diagram.getSemanticObjectMap().get("PL1")).findFirst().get();
    assertEquals(getThreatColor(), ((EdgeStyle) physicalLinkEdge.getStyle()).getStrokeColor());
    assertEquals(HIGHLIGHTED_BORDER_SIZE, ((EdgeStyle) physicalLinkEdge.getStyle()).getSize());

  }

  @Override
  public void test() throws Exception {

    step1();

    // Support Assets layer
    // remove asset members to clear colorization
    executeCommand(() -> fpa.getOwnedMembers().clear());

    step2();
    step3();
    step4();
    step5();

    executeCommand(() -> fpa.getOwnedMembers().clear());

    step6();
    step7();
    step8();
    step9();
    step10();
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
