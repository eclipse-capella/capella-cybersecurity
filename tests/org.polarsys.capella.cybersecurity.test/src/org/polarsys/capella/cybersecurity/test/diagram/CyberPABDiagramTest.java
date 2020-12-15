/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.sirius.diagram.EdgeStyle;
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
import org.polarsys.capella.core.data.fa.ComponentExchangeFunctionalExchangeAllocation;
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
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

public class CyberPABDiagramTest extends EmptyProject {

  protected TransactionalEditingDomainHelper tedHelper;
  
  private FunctionalPrimaryAsset fpa;
  private InformationPrimaryAsset ipa;
  private PrimaryAssetMember m1;
  private PrimaryAssetMember m2;

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
    RGBValues fpaColor = ((Square) fpaNode.getStyle()).getColor();

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
    RGBValues ipaColor = ((Square) ipaNode.getStyle()).getColor();

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
      ComponentExchangeFunctionalExchangeAllocation a = FaFactory.eINSTANCE
          .createComponentExchangeFunctionalExchangeAllocation();
      a.setSourceElement(componentExchange);
      a.setTargetElement(functionalExchange);
      componentExchange.getOwnedComponentExchangeFunctionalExchangeAllocations().add(a);

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
      assertEquals(((EdgeStyle) exchangeStyle).getStrokeColor(), ((Square) informationAssetStyle).getColor());

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
    
    
//    this dumps a screenshot..
//    ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
//    IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel() + "/png.gif"));
//    DialectUIManager.INSTANCE.export(diagram.getDiagram(), session, dest, format, new NullProgressMonitor());

  }


  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }

}

