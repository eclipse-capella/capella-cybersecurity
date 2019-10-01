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
package org.polarsys.capella.cybersecurity.sirius.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.polarsys.capella.common.data.behavior.AbstractEvent;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.platform.sirius.ted.SemanticEditingDomainFactory.SemanticEditingDomain;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.AbstractFunctionalBlock;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.ComponentExchangeExt;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.core.sirius.analysis.CsServices;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
import org.polarsys.capella.core.sirius.analysis.FaServices;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class CybersecurityServices {

  private static final String TRUSTED_COMPONENT_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/obj16/trusted-16.png"; //$NON-NLS-1$
  private static final String UNTRUSTED_COMPONENT_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/obj16/notTrusted-16.png"; //$NON-NLS-1$
  private static final String DATASTORAGE_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/obj16/datastorage-16.png"; //$NON-NLS-1$
  private static final String REMANENT_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/obj16/remanentData-16.png"; //$NON-NLS-1$
  private static final String THREATSOURCE_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/obj16/threatSource.png"; //$NON-NLS-1$

  final FaServices FA_SERVICES = new FaServices();
  final CsServices CS_SERVICES = new CsServices();

  public CybersecurityPkg getDefaultCyberSecurityPackage(EObject any) {
    BlockArchitecture ba = (BlockArchitecture) EcoreUtil2.getFirstContainer(any, CsPackage.Literals.BLOCK_ARCHITECTURE);
    if (ba != null) {
      for (EObject e : ba.getOwnedExtensions()) {
        if (e instanceof CybersecurityPkg) {
          return (CybersecurityPkg) e;
        }
      }
      CybersecurityPkg pkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
      pkg.setName(Messages.CybersecurityServices_0);
      ba.getOwnedExtensions().add(pkg);
      return pkg;
    }
    return null;
  }

  public Threat createThreat(EObject any) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(any);
    if (pkg != null) {
      Threat threat = CybersecurityFactory.eINSTANCE.createThreat();
      pkg.getOwnedThreats().add(threat);
      return threat;
    }
    return null;
  }

  public Collection<EObject> getABPrimaryAssetScope(DSemanticDecorator view) {
    EObject object = view.getTarget();
    return new ArrayList<>(EObjectExt.getAll(getDefaultCyberSecurityPackage(object), CybersecurityPackage.Literals.PRIMARY_ASSET));
  }

  public int getAssetColor1Red(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    for (PrimaryAsset asset : getRelatedAssets(e)) {
      DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement((DDiagram) diagram, asset);
      if (element != null && element instanceof DNode) {
        return ((Square) element.getStyle()).getColor().getRed();
      }
    }
    return 0;
  }

  public int getAssetColor1Blue(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    for (PrimaryAsset asset : getRelatedAssets(e)) {
      DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement((DDiagram) diagram, asset);
      if (element != null && element instanceof DNode) {
        return ((Square) element.getStyle()).getColor().getBlue();
      }
    }
    return 0;
  }

  public int getAssetColor1Green(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    for (PrimaryAsset asset : getRelatedAssets(e)) {
      DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement((DDiagram) diagram, asset);
      if (element != null && element instanceof DNode) {
        return ((Square) element.getStyle()).getColor().getGreen();
      }
    }
    return 0;
  }

  public FunctionalPrimaryAsset createFunctionalPrimaryAsset(EObject any) {
    FunctionalPrimaryAsset asset = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    return (FunctionalPrimaryAsset) attachToDefaultCybersecurityPkg(any, asset);
  }

  public InformationPrimaryAsset createInformationPrimaryAsset(EObject any) {
    InformationPrimaryAsset asset = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    return (InformationPrimaryAsset) attachToDefaultCybersecurityPkg(any, asset);
  }

  private EObject attachToDefaultCybersecurityPkg(EObject context, EObject cyberObject) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(context);
    Command cmd = AddCommand.create(TransactionUtil.getEditingDomain(pkg), pkg, null,
        Collections.singleton(cyberObject));
    if (cmd.canExecute()) {
      cmd.execute();
      return cyberObject;
    }
    return null;
  }

  public Component createActor(EObject any) {
    return CS_SERVICES.createActor(BlockArchitectureExt.getRootBlockArchitecture(any));
  }

  public ThreatInvolvement createThreatInvolvement(Threat threat, Component actor) {
    ThreatInvolvement iv = CybersecurityFactory.eINSTANCE.createThreatInvolvement();
    iv.setComponent(actor);
    iv.setThreat(threat);
    actor.getOwnedExtensions().add(iv);
    return iv;
  }

  public ThreatApplication createThreatApplication(Threat threat, PrimaryAsset asset) {
    ThreatApplication ap = CybersecurityFactory.eINSTANCE.createThreatApplication();
    ap.setThreat(threat);
    ap.setAsset(asset);
    asset.getOwnedThreatApplications().add(ap);
    return ap;
  }

  public boolean hasActorSpyIcon(Component actor) {
    for (ElementExtension ext : actor.getOwnedExtensions()) {
      if (ext instanceof TrustBoundaryStorage) {
        return ((TrustBoundaryStorage) ext).isThreatSource();
      }
    }
    return false;
  }

  public String getTrustDecoration(Part part) {
    return TRUSTED_COMPONENT_DECORATION;
  }

  public String getNoTrustDecoration(Part part) {
    return UNTRUSTED_COMPONENT_DECORATION;
  }

  public String getDatastorageDecoration(AbstractFunction af) {
    return DATASTORAGE_DECORATION;
  }

  public String getRemanentDataDecoration(AbstractFunction af) {
    return REMANENT_DECORATION;
  }

  public String getThreatSourceDecoration(Part part) {
    return THREATSOURCE_DECORATION;
  }

  public boolean hasDatastorageDecoration(AbstractFunction af) {
    FunctionStorage storage = getFunctionStorage(af);
    return storage != null && storage.isDataStorage();
  }

  public boolean hasRemanentDataDecoration(AbstractFunction af) {
    FunctionStorage storage = getFunctionStorage(af);
    return storage != null && storage.isRemanentData();
  }

  public boolean hasTrustDecoration(Part part) {
    return isTrusted(part);
  }

  public boolean hasNoTrustDecoration(Part part) {
    TrustBoundaryStorage storage = getTrustBoundaryStorage(part);
    return storage != null && !storage.isTrusted();
  }

  public boolean hasThreatSourceDecoration(Part part) {
    TrustBoundaryStorage storage = getTrustBoundaryStorage(part);
    return storage != null && storage.isThreatSource();
  }

  private TrustBoundaryStorage getTrustBoundaryStorage(ExtensibleElement element) {
    if (element instanceof Part) {
      element = ((Part) element).getType();
    }
    return ExtensibleElementExt.getExtension(element, TrustBoundaryStorage.class);
  }

  private FunctionStorage getFunctionStorage(ExtensibleElement element) {
    return ExtensibleElementExt.getExtension(element, FunctionStorage.class);
  }

  private SecurityNeeds getSecurityNeeds(ExtensibleElement element) {
    return ExtensibleElementExt.getExtension(element, SecurityNeeds.class);
  }

  public Collection<Component> getAllThreatActors(EObject element) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(element);
    return BlockArchitectureExt.getAllComponents(architecture);
  }

  public Collection<PrimaryAsset> getRelatedAssets(EObject element) {
    Collection<EObject> semantics = new ArrayList<EObject>();
    semantics.add(element);
    if (element instanceof FunctionalExchange) {
      semantics.addAll(((FunctionalExchange) element).getExchangedItems());
    }
    if (element instanceof AbstractFunction) {
      FunctionStorage fs = getFunctionStorage((ExtensibleElement) element);
      if (fs != null) {
        semantics.addAll(fs.getExchangedItems());
      }
    }

    Collection<PrimaryAsset> assets = new ArrayList<PrimaryAsset>();
    for (EObject semantic : semantics) {
      for (EObject member : EObjectExt.getReferencers(semantic,
          CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER)) {
        PrimaryAsset asset = ((PrimaryAssetMember) member).getAsset();
        assets.add(asset);
      }
    }

    return assets;
  }

  public boolean hasAssetStyleCustomization(EObject element) {
    TransactionalEditingDomain domain = TransactionHelper.getEditingDomain(element);
    if (domain instanceof SemanticEditingDomain) {

      Collection<EStructuralFeature.Setting> refs = ((SemanticEditingDomain) domain).getCrossReferencer()
          .getInverseReferences(element, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER, true);
      if (refs.size() > 0) {
        return true;
      }
      if (element instanceof FunctionalExchange) {
        for (ExchangeItem ei : ((FunctionalExchange) element).getExchangedItems()) {
          if (hasAssetStyleCustomization(ei)) {
            return true;
          }
        }
      }
      if (element instanceof AbstractFunction) {
        FunctionStorage fs = getFunctionStorage((ExtensibleElement) element);
        if (fs != null) {
          for (ExchangeItem ei : fs.getExchangedItems()) {
            if (hasAssetStyleCustomization(ei)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public String getAssetDecorationBorderSize(DSemanticDecorator view) {
    if (view instanceof DNode) {
      EObject e = view.getTarget();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      for (PrimaryAsset asset : getRelatedAssets(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
        if (element != null && element instanceof DNode) {
          return "5";
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  public String getAssetDecorationSize(DSemanticDecorator view) {
    if (view instanceof DEdge) {
      EObject e = view.getTarget();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      for (PrimaryAsset asset : getRelatedAssets(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
        if (element != null && element instanceof DNode) {
          return "5";
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  public boolean hasTrustedColor(Part part) {
    return isTrusted(part);
  }

  public boolean hasFlameDecoration(ComponentExchange ce) {
    Component source = ComponentExchangeExt.getSourceComponent(ce);
    Component target = ComponentExchangeExt.getTargetComponent(ce);
    return isTrusted(source) ^ isTrusted(target);
  }

  public boolean hasFlameDecoration(FunctionalExchange e) {
    AbstractFunction sf = (AbstractFunction) e.getSourceFunctionOutputPort().eContainer();
    AbstractFunction tf = (AbstractFunction) e.getTargetFunctionInputPort().eContainer();
    return isTrusted(sf) ^ isTrusted(tf);
  }

  public Integer getConfidentiality(AbstractEvent e) {
    SecurityNeeds needs = getSecurityNeeds(e);
    if (needs != null) {
      return needs.getConfidentiality();
    }
    return 0;
  }

  public Integer getIntegrity(AbstractEvent e) {
    SecurityNeeds needs = getSecurityNeeds(e);
    if (needs != null) {
      return needs.getIntegrity();
    }
    return 0;
  }

  public Integer getAvailability(AbstractEvent e) {
    SecurityNeeds needs = getSecurityNeeds(e);
    if (needs != null) {
      return needs.getAvailability();
    }
    return 0;
  }

  public Integer getTraceability(AbstractEvent e) {
    SecurityNeeds needs = getSecurityNeeds(e);
    if (needs != null) {
      return needs.getTraceability();
    }
    return 0;
  }

  private boolean isTrusted(AbstractFunction f) {
    for (AbstractFunctionalBlock b : f.getAllocationBlocks()) {
      TrustBoundaryStorage tbs = getTrustBoundaryStorage(b);
      if (tbs != null) {
        return tbs.isTrusted();
      }
    }
    return TrustBoundaryStorageImpl.TRUSTED_EDEFAULT;
  }

  private boolean isTrusted(ExtensibleElement e) {
    TrustBoundaryStorage tbs = getTrustBoundaryStorage(e);
    if (tbs != null) {
      return tbs.isTrusted();
    }
    return TrustBoundaryStorageImpl.TRUSTED_EDEFAULT;
  }

}
