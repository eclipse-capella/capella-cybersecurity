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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.cs.PhysicalLink;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentExchangeFunctionalExchangeAllocation;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
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
import org.polarsys.kitalpha.emde.model.ElementExtension;

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
    
//    this dumps a screenshot..
//    ExportFormat format = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.PNG);
//    IPath dest = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(new Path("/" + getRequiredTestModel() + "/png.gif"));
//    DialectUIManager.INSTANCE.export(diagram.getDiagram(), session, dest, format, new NullProgressMonitor());

  }


  protected final void executeCommand(Runnable r) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(r);
  }

}

