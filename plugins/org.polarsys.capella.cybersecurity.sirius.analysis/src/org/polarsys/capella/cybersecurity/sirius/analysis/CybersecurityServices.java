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
import java.util.PrimitiveIterator.OfInt;
import java.util.Random;
import java.util.stream.Collectors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.graphics.Font;
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
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.core.sirius.analysis.CsServices;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
import org.polarsys.capella.core.sirius.analysis.FaServices;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
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

  final OfInt colorRands = new Random().ints(0, 255).iterator();

  public CybersecurityPkg getDefaultCyberSecurityPackage(EObject any, boolean create) {
    BlockArchitecture ba = (BlockArchitecture) EcoreUtil2.getFirstContainer(any, CsPackage.Literals.BLOCK_ARCHITECTURE);
    if (ba != null) {
      for (EObject e : ba.getOwnedExtensions()) {
        if (e instanceof CybersecurityPkg) {
          return (CybersecurityPkg) e;
        }
      }
      if (create) {
        CybersecurityPkg pkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
        pkg.setName(Messages.CybersecurityServices_0);
        ba.getOwnedExtensions().add(pkg);
        return pkg;
      }
    }
    return null;
  }

  public Threat createThreat(EObject any) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(any, true);
    if (pkg != null) {
      Threat threat = CybersecurityFactory.eINSTANCE.createThreat();
      pkg.getOwnedThreats().add(threat);
      return threat;
    }
    return null;
  }

  public Collection<EObject> getABPrimaryAssetScope(DSemanticDecorator view) {
    EObject object = view.getTarget();
    CybersecurityPkg cspkg = getDefaultCyberSecurityPackage(object, false);
    if (cspkg != null) {
      return new ArrayList<>(EObjectExt.getAll(cspkg, CybersecurityPackage.Literals.PRIMARY_ASSET));
    }
    return Collections.emptyList();
  }

  public int getAssetColor1Red(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    for (PrimaryAsset asset : getRelatedAssets(e)) {
      DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
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
      DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
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
      DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
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
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(context, true);
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
    iv.setThreat(threat);
    actor.getOwnedExtensions().add(iv);
    return iv;
  }

  public ThreatApplication createThreatApplication(Threat threat, PrimaryAsset asset) {
    ThreatApplication ap = CybersecurityFactory.eINSTANCE.createThreatApplication();
    ap.setThreat(threat);
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
    return CybersecurityQueries.isTrusted(part);
  }

  public boolean hasNoTrustDecoration(Part part) {
    TrustBoundaryStorage storage = CybersecurityQueries.getTrustBoundaryStorage(part);
    return storage != null && !storage.isTrusted();
  }

  public boolean hasThreatSourceDecoration(Part part) {
    TrustBoundaryStorage storage = CybersecurityQueries.getTrustBoundaryStorage(part);
    return storage != null && storage.isThreatSource();
  }

  private FunctionStorage getFunctionStorage(ExtensibleElement element) {
    return ExtensibleElementExt.getExtension(element, FunctionStorage.class);
  }

  private SecurityNeeds getSecurityNeeds(ExtensibleElement element, boolean create) {
    SecurityNeeds sn = ExtensibleElementExt.getExtension(element, SecurityNeeds.class);
    if (sn == null && create) {
      if (!ExtensibleElementExt.canBeExtendedBy(element, CybersecurityPackage.Literals.SECURITY_NEEDS)) {
        throw new IllegalArgumentException();
      }
      sn = CybersecurityFactory.eINSTANCE.createSecurityNeeds();
      element.getOwnedExtensions().add(sn);
    }
    return sn;
  }

  private SecurityNeeds getSecurityNeeds(ExtensibleElement element) {
    return getSecurityNeeds(element, false);
  }
  
  public Collection<Component> getAllThreatActors(EObject element) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(element);
    return BlockArchitectureExt.getAllComponents(architecture).stream().filter(c -> c.isActor()).collect(Collectors.toList());
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
    if (view instanceof AbstractDNode) {
      EObject e = view.getTarget();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      for (PrimaryAsset asset : getRelatedAssets(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
        if (element != null && element instanceof DNode) {
          return "5"; //$NON-NLS-1$
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
          return "5"; //$NON-NLS-1$
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  public boolean hasTrustedColor(Part part) {
    return CybersecurityQueries.isTrusted(part);
  }

  public boolean hasFlameDecoration(ComponentExchange ce) {
    return CybersecurityQueries.isTrustBoundary(ce);
  }

  public boolean hasFlameDecoration(FunctionalExchange e) {
    return CybersecurityQueries.isTrustBoundary(e);
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

  // make a new random color for every new asset node
  public EObject setNewRandomColor(DNode assetView) {
    ((Square)assetView.getOwnedStyle()).setColor(RGBValues.create(colorRands.nextInt(), colorRands.nextInt(), colorRands.nextInt()));
    ((Square)assetView.getOwnedStyle()).getCustomFeatures().add("color"); //$NON-NLS-1$
    return assetView;
  }


  public IFigure getThreatLevelDecorator(final EObject context, DSemanticDiagram diagram) {
    ThreatLevelDecorator decorator = (ThreatLevelDecorator) EcoreUtil.getExistingAdapter(context, ThreatLevelDecorator.class);
    if (decorator != null) {
      return decorator.getLabel();
    } else {
      decorator = new ThreatLevelDecorator((Threat) context);
      context.eAdapters().add(decorator);
      return decorator.getLabel();
    }
  }

  public boolean hasThreatLevelDecorator(EObject context) {
    return context instanceof Threat;
  }

  public void setConfidentiality(ExtensibleElement element, int value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setConfidentiality(value);
  }

  public void setIntegrity(ExtensibleElement element, int value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setIntegrity(value);
  }

  public void setTraceability(ExtensibleElement element, int value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setTraceability(value);
  }

  public void setAvailability(ExtensibleElement element, int value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setAvailability(value);
  }

  private static class ThreatLevelDecorator extends AdapterImpl {
    private final static String FONT = "CybersecurityServices.ThreatLevelDecoratorFont"; //$NON-NLS-1$
    private final Label label;
    private ThreatLevelDecorator(Threat threat) {
      this.label = new Label(getLabelText(threat)) {
        @Override
        public void removeNotify() {
          removeDecorator();
        }
      };
      label.setFont(getThreatLevelDecoratorFont());
      Rectangle bounds = label.getTextBounds();
      label.setBounds(bounds);
    }

    private void removeDecorator() {
      getTarget().eAdapters().remove(this);
    }

    private String getLabelText(Threat threat) {
      return "(" + String.valueOf(threat.getLevel()) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Label getLabel() {
      return label;
    }

    @Override
    public boolean isAdapterForType(Object type) {
      return type == ThreatLevelDecorator.class;
    }

    private void updateLabel(Threat t) {
      label.setText(getLabelText(t));
    }

    @Override
    public void notifyChanged(Notification msg) {
      if (msg.getFeature() == CybersecurityPackage.Literals.THREAT__LEVEL) {        
        updateLabel((Threat) msg.getNotifier());
      }
    }

    private Font getThreatLevelDecoratorFont() {
      FontRegistry registry = JFaceResources.getFontRegistry();
      Font font = registry.get(FONT);
      if (font == registry.defaultFont()) {
        FontDescriptor smaller = JFaceResources.getDefaultFontDescriptor().increaseHeight(-2);
        registry.put(FONT, smaller.getFontData());
        font = registry.get(FONT);
      }
      return font;
    }

  }

  
  
}
