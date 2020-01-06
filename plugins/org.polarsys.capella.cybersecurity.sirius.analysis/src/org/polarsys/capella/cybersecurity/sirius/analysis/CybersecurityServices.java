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
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.menu.dynamic.util.INamePrefixService;
import org.polarsys.capella.common.platform.sirius.ted.SemanticEditingDomainFactory.SemanticEditingDomain;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.interaction.StateFragment;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.core.sirius.analysis.CsServices;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
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
import org.polarsys.capella.cybersecurity.model.impl.TrustBoundaryStorageImpl;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class CybersecurityServices {

  private static final String TRUSTED_COMPONENT_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/Trusted.png"; //$NON-NLS-1$
  private static final String UNTRUSTED_COMPONENT_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/NotTrusted.png"; //$NON-NLS-1$
  private static final String DATASTORAGE_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/DataStorage.png"; //$NON-NLS-1$
  private static final String REMANENT_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/RemanentData.png"; //$NON-NLS-1$
  private static final String THREATSOURCE_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/ThreatSource.png"; //$NON-NLS-1$
  private static final String PRIMARY_ASSET_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/PrimaryAsset.png"; //$NON-NLS-1$
  private static final String FLAME_DECORATION = "/org.polarsys.capella.cybersecurity.model.edit/icons/full/ovr16/TrustLimit.png"; //$NON-NLS-1$

  final INamePrefixService prefixService = PlatformUI.getWorkbench().getService(INamePrefixService.class);

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

      String elementPrefix = prefixService.getPrefix(threat);
      String uniqueName = CapellaServices.getService().getUniqueName(threat, elementPrefix);
      threat.setName(uniqueName);

      return threat;
    }
    return null;
  }

  public String getThreatLabel(EObject asset) {
    Threat thear = (Threat) asset;
    String kind = ((Threat) asset).getThreatKind().getName().replaceAll("_", " ").toUpperCase();
    if (thear.getName() == null || thear.getName().trim().isEmpty()) {
      return kind;
    }
    return EObjectLabelProviderHelper.getText(asset) + "\n(" + kind + ")";
  }

  public String getPrimaryAssetLabel(EObject asset) {
    return EObjectLabelProviderHelper.getText(asset);
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
    FunctionalPrimaryAsset asset = (FunctionalPrimaryAsset) attachToDefaultCybersecurityPkg(any,
        CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset());

    if (asset != null) {
      String elementPrefix = prefixService.getPrefix(asset);
      String uniqueName = CapellaServices.getService().getUniqueName(asset, elementPrefix);
      asset.setName(uniqueName);
    }

    return asset;
  }

  public InformationPrimaryAsset createInformationPrimaryAsset(EObject any) {
    InformationPrimaryAsset asset = (InformationPrimaryAsset) attachToDefaultCybersecurityPkg(any,
        CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset());

    if (asset != null) {
      String elementPrefix = prefixService.getPrefix(asset);
      String uniqueName = CapellaServices.getService().getUniqueName(asset, elementPrefix);
      asset.setName(uniqueName);
    }

    return asset;
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
    return CsServices.getService().createActor(BlockArchitectureExt.getRootBlockArchitecture(any));
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

  public String getTrustDecoration(ModelElement element) {
    return TRUSTED_COMPONENT_DECORATION;
  }

  public String getNoTrustDecoration(ModelElement element) {
    return UNTRUSTED_COMPONENT_DECORATION;
  }

  public String getDatastorageDecoration(ModelElement element) {
    return DATASTORAGE_DECORATION;
  }

  public String getRemanentDataDecoration(ModelElement element) {
    return REMANENT_DECORATION;
  }

  public String getThreatSourceDecoration(ModelElement element) {
    return THREATSOURCE_DECORATION;
  }

  public String getPrimaryAssetDecoration(ModelElement element) {
    return PRIMARY_ASSET_DECORATION;
  }

  protected AbstractFunction getRepresentedFunction(ModelElement element) {
    AbstractFunction af = null;
    if (element instanceof AbstractFunction) {
      af = (AbstractFunction) element;
    } else if (element instanceof StateFragment) {
      af = ((StateFragment) element).getRelatedAbstractFunction();
    }
    return af;
  }

  public String getFlameDecoration(EObject object) {
    return FLAME_DECORATION;
  }

  protected FunctionalExchange getRepresentedFunctionalExchange(ModelElement element) {
    FunctionalExchange fe = null;
    if (element instanceof FunctionalExchange) {
      fe = (FunctionalExchange) element;
    } else if (element instanceof SequenceMessage) {
      AbstractEventOperation invokedOperation = ((SequenceMessage) element).getInvokedOperation();
      if (invokedOperation instanceof FunctionalExchange) {
        fe = (FunctionalExchange) invokedOperation;
      }
    }
    return fe;
  }

  protected ComponentExchange getRepresentedComponentExchange(ModelElement element) {
    ComponentExchange ce = null;
    if (element instanceof ComponentExchange) {
      ce = (ComponentExchange) element;
    } else if (element instanceof SequenceMessage) {
      AbstractEventOperation invokedOperation = ((SequenceMessage) element).getInvokedOperation();
      if (invokedOperation instanceof ComponentExchange) {
        ce = (ComponentExchange) invokedOperation;
      }
    }
    return ce;
  }

  public boolean hasDatastorageDecoration(ModelElement element) {
    AbstractFunction af = getRepresentedFunction(element);
    if (af != null) {
      FunctionStorage storage = getFunctionStorage(af);
      return storage != null && storage.isDataStorage();
    }
    return false;
  }

  public boolean hasRemanentDataDecoration(ModelElement element) {
    AbstractFunction af = getRepresentedFunction(element);
    if (af != null) {
      FunctionStorage storage = getFunctionStorage(af);
      return storage != null && storage.isRemanentData();
    }
    return false;
  }

  protected Component getRepresentedComponent(ModelElement element) {
    Component component = null;
    if (element instanceof Component) {
      component = (Component) element;

    } else if (element instanceof Part) {
      component = (Component) ((Part) element).getAbstractType();

    } else if (element instanceof InstanceRole) {
      AbstractInstance representedInstance = ((InstanceRole) element).getRepresentedInstance();
      if (representedInstance instanceof Part) {
        component = (Component) ((Part) representedInstance).getAbstractType();
      }
    }
    return component;
  }

  public boolean hasTrustDecoration(ModelElement element) {
    Component component = getRepresentedComponent(element);
    if (component != null) {
      return CybersecurityQueries.isTrusted(component);
    }
    return false;
  }

  public boolean hasNoTrustDecoration(ModelElement element) {
    Component component = getRepresentedComponent(element);
    if (component != null) {
      TrustBoundaryStorage storage = CybersecurityQueries.getTrustBoundaryStorage(component);
      return storage != null && !storage.isTrusted() && !storage.isThreatSource();
    }
    return false;
  }

  public boolean hasThreatSourceDecoration(ModelElement element) {
    Component component = getRepresentedComponent(element);
    if (component != null) {
      TrustBoundaryStorage storage = CybersecurityQueries.getTrustBoundaryStorage(component);
      return storage != null && storage.isThreatSource();
    }
    return false;
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
    return BlockArchitectureExt.getAllComponents(architecture).stream().filter(c -> c.isActor())
        .collect(Collectors.toList());
  }

  public Collection<PrimaryAsset> getRelatedAssets(EObject element) {
    Collection<EObject> semantics = new ArrayList<>();
    if (element instanceof SequenceMessage) {
      element = getRepresentedFunctionalExchange((ModelElement) element);
    } else if (element instanceof StateFragment) {
      element = getRepresentedFunction((ModelElement) element);
    }

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

    Collection<PrimaryAsset> assets = new ArrayList<>();
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
      if (element instanceof SequenceMessage) {
        element = getRepresentedFunctionalExchange((ModelElement) element);
      } else if (element instanceof StateFragment) {
        element = getRepresentedFunction((ModelElement) element);
      }

      Collection<EStructuralFeature.Setting> refs = ((SemanticEditingDomain) domain).getCrossReferencer()
          .getInverseReferences(element, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER, true);
      if (!refs.isEmpty()) {
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
        if (element instanceof DNode) {
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

  public boolean hasTrustedColor(InstanceRole element) {
    Component component = getRepresentedComponent(element);
    if (component != null) {
      return CybersecurityQueries.isTrusted(component);
    }
    return TrustBoundaryStorageImpl.TRUSTED_EDEFAULT;
  }

  public boolean hasFlameDecoration(ModelElement element) {
    ComponentExchange representedComponentExchange = getRepresentedComponentExchange(element);
    if (representedComponentExchange != null) {
      return CybersecurityQueries.isTrustBoundary(representedComponentExchange);
    }
    FunctionalExchange representedFunctionalExchange = getRepresentedFunctionalExchange(element);
    if (representedFunctionalExchange != null) {
      return CybersecurityQueries.isTrustBoundary(representedFunctionalExchange);
    }
    return false;
  }

  public int getConfidentiality(ModelElement modelElement) {
    AbstractFunction representedFunction = getRepresentedFunction(modelElement);
    if (representedFunction != null) {
      modelElement = representedFunction;
    }
    SecurityNeeds needs = getSecurityNeeds(modelElement);
    if (needs != null) {
      return needs.getConfidentiality();
    }
    return 0;
  }

  public int getIntegrity(ModelElement modelElement) {
    AbstractFunction representedFunction = getRepresentedFunction(modelElement);
    if (representedFunction != null) {
      modelElement = representedFunction;
    }
    SecurityNeeds needs = getSecurityNeeds(modelElement);
    if (needs != null) {
      return needs.getIntegrity();
    }
    return 0;
  }

  public int getAvailability(ModelElement modelElement) {
    AbstractFunction representedFunction = getRepresentedFunction(modelElement);
    if (representedFunction != null) {
      modelElement = representedFunction;
    }
    SecurityNeeds needs = getSecurityNeeds(modelElement);
    if (needs != null) {
      return needs.getAvailability();
    }
    return 0;
  }

  public int getTraceability(ModelElement modelElement) {
    AbstractFunction representedFunction = getRepresentedFunction(modelElement);
    if (representedFunction != null) {
      modelElement = representedFunction;
    }
    SecurityNeeds needs = getSecurityNeeds(modelElement);
    if (needs != null) {
      return needs.getTraceability();
    }
    return 0;
  }

  /**
   * Returns the max value of the Security Need, from the currently activated Security Needs Layers. Example:
   * Confidentiality: 3, Integrity: 2. If the both layers are activated then the result is 3, if only Integrity layer is
   * activated then the result is 2, if no layer is activated then the result is 0.
   * 
   * @param decorator
   *          the element decorator.
   * @return the the max value of the Security Need.
   */
  public int getMaxSecurityNeedValue(DSemanticDecorator decorator) {
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(decorator);
    ModelElement element = (ModelElement) decorator.getTarget();

    Set<String> activatedLayerNames = new DDiagramQuery(diagram).getAllActivatedLayers().stream().map(Layer::getName)
        .collect(Collectors.toSet());

    int maxSecurityNeedValue = 0;

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_CONFIDENTIALITY)) {
      int confidentiality = getConfidentiality(element);
      maxSecurityNeedValue = confidentiality > maxSecurityNeedValue ? confidentiality : maxSecurityNeedValue;
    }

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_INTEGRITY)) {
      int integrity = getIntegrity(element);
      maxSecurityNeedValue = integrity > maxSecurityNeedValue ? integrity : maxSecurityNeedValue;
    }

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_AVAILABILITY)) {
      int availability = getAvailability(element);
      maxSecurityNeedValue = availability > maxSecurityNeedValue ? availability : maxSecurityNeedValue;
    }

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_TRACEABILITY)) {
      int traceability = getTraceability(element);
      maxSecurityNeedValue = traceability > maxSecurityNeedValue ? traceability : maxSecurityNeedValue;
    }

    return maxSecurityNeedValue;
  }

  // make a new random color for every new asset node
  public EObject setNewRandomColor(DNode assetView) {
    ((Square) assetView.getOwnedStyle())
        .setColor(RGBValues.create(colorRands.nextInt(), colorRands.nextInt(), colorRands.nextInt()));
    ((Square) assetView.getOwnedStyle()).getCustomFeatures().add("color"); //$NON-NLS-1$
    return assetView;
  }

  public IFigure getThreatLevelDecorator(final EObject context, DSemanticDiagram diagram) {
    ThreatLevelDecorator decorator = (ThreatLevelDecorator) EcoreUtil.getExistingAdapter(context,
        ThreatLevelDecorator.class);
    if (decorator != null) {
      return decorator.getLabel();
    } else {
      decorator = new ThreatLevelDecorator((Threat) context);
      context.eAdapters().add(decorator);
      return decorator.getLabel();
    }
  }

  public boolean hasThreatLevelDecorator(ModelElement context) {
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

        @Override
        public void addNotify() {
          // Nothing
        }
      };
      label.setFont(getThreatLevelDecoratorFont());
      Rectangle bounds = label.getTextBounds();
      label.setBounds(bounds);
    }

    private void removeDecorator() {
      Notifier notifier = getTarget();
      if (notifier != null) {
        notifier.eAdapters().remove(this);
      }
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
      return JFaceResources.getFontRegistry().defaultFont();
    }

  }

}
