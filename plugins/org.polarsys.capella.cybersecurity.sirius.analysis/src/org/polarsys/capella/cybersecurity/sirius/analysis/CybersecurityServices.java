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
package org.polarsys.capella.cybersecurity.sirius.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.Ellipse;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
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
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.cs.PhysicalLink;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.AbstractEventOperation;
import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.SequenceMessage;
import org.polarsys.capella.core.data.interaction.StateFragment;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.EntityPkg;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.model.helpers.FunctionalChainExt;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.core.sirius.analysis.CsServices;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
import org.polarsys.capella.core.sirius.analysis.ShapeUtil;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
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
    BlockArchitecture ba = any instanceof BlockArchitecture ? (BlockArchitecture)any : 
        (BlockArchitecture) EcoreUtil2.getFirstContainer(any, CsPackage.Literals.BLOCK_ARCHITECTURE);
    if (ba == null) {
      return null;
    }
    
    CybersecurityPkg pkg = getRootCibersecurityPkg(ba);
    if(pkg != null) {
      return pkg;
    }
    
    if (create) {
      pkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
      pkg.setName(Messages.CybersecurityServices_0);
      ba.getOwnedExtensions().add(pkg);
      return pkg;
    }
    return null;
  }
  
  public CybersecurityPkg getRootCibersecurityPkg(BlockArchitecture ba) {
    return (CybersecurityPkg) ba.getOwnedExtensions().stream().filter(CybersecurityPkg.class::isInstance).findFirst().orElse(null);
  }

  public Threat createThreat(EObject any) {
    Session session = SessionManager.INSTANCE.getSession(any);
    if (session != null) {
      Project project = SessionHelper.getCapellaProject(session);
      return createThreat(any, project);
    }
    return null;
  }
  
  public Threat createThreat(EObject any, Project project) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(any, true);
    if (pkg != null) {
      Threat threat = createThreatInPkg(pkg);
      // set threat kind to be the first one available in the config threat kind type
      CybersecurityQueries.setThreatKindFromIndex(threat, 0, CybersecurityQueries.getThreatKindPropertyType(project));
      return threat;
    }
    return null;
  }
  
  public Threat createThreatInPkg(CybersecurityPkg pkg) {
    Threat threat = CybersecurityFactory.eINSTANCE.createThreat();
    pkg.getOwnedThreats().add(threat);

    String elementPrefix = prefixService.getPrefix(threat);
    String uniqueName = CapellaServices.getService().getUniqueName(threat, elementPrefix);
    threat.setName(uniqueName);

    return threat;
  }

  public String getThreatLabel(Threat threat) {
    String defaultLabel = EObjectLabelProviderHelper.getText(threat);
    if (threat.getKind() != null) {
      String kind = threat.getKind().getName().toUpperCase();
      return defaultLabel + "\n(" + kind + ")";
    }
    return defaultLabel + "\n(UNDEFINED)";
  }

  public String getPrimaryAssetLabel(EObject asset) {
    return EObjectLabelProviderHelper.getText(asset);
  }

  public String getActorLabel(EObject actor) {
    return EObjectLabelProviderHelper.getText(actor);
  }

  public Collection<EObject> getABPrimaryAssetScope(DSemanticDecorator view) {
    EObject object = view.getTarget();
    CybersecurityPkg cspkg = getDefaultCyberSecurityPackage(object, false);
    if (cspkg != null) {
      return new ArrayList<>(EObjectExt.getAll(cspkg, CybersecurityPackage.Literals.PRIMARY_ASSET));
    }
    return Collections.emptyList();
  }

  public Collection<EObject> getABThreatScope(DSemanticDecorator view) {
    EObject object = view.getTarget();
    CybersecurityPkg cspkg = getDefaultCyberSecurityPackage(object, false);
    if (cspkg != null) {
      return new ArrayList<>(EObjectExt.getAll(cspkg, CybersecurityPackage.Literals.THREAT));
    }
    return Collections.emptyList();
  }

  public int getAssetColor1Red(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    
    if (e instanceof Part && ((Part) e).getAbstractType() instanceof Component
        && !isSupportingAssetHighlightedComponent(view)) {
      return 0;
    }
    
    if (e instanceof Entity && !isSupportingAssetHighlightedComponent(view)) {
      return 0;
    }
    
    if (diagram != null) {
      int nbOfElements = 0;
      int color = 0;
      for (PrimaryAsset asset : getRelatedAssets(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
        if (element != null && element instanceof DNode) {
          nbOfElements++;
          color = ((Ellipse) element.getStyle()).getColor().getRed();
        }
      }
      for (Threat threat : getRelatedThreats(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
        if (element != null && element instanceof DNode) {
          nbOfElements++;
          color = ((Ellipse) element.getStyle()).getColor().getRed();
        }
      }
      return nbOfElements > 1 ? 0 : color;
    }
    return 0;
  }

  public int getAssetColor1Blue(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    
    if (e instanceof Part && ((Part) e).getAbstractType() instanceof Component
        && !isSupportingAssetHighlightedComponent(view)) {
      return 0;
    }
    
    if (e instanceof Entity && !isSupportingAssetHighlightedComponent(view)) {
      return 0;
    }
    
    if (diagram != null) {
      int nbOfElements = 0;
      int color = 0;
      for (PrimaryAsset asset : getRelatedAssets(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
        if (element != null && element instanceof DNode) {
          nbOfElements++;
          color = ((Ellipse) element.getStyle()).getColor().getBlue();
        }
      }
      for (Threat threat : getRelatedThreats(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
        if (element != null && element instanceof DNode) {
          nbOfElements++;
          color = ((Ellipse) element.getStyle()).getColor().getBlue();
        }
      }
      return nbOfElements > 1 ? 0 : color;
    }
    return 0;
  }

  public int getAssetColor1Green(DSemanticDecorator view) {
    EObject e = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    
    if (e instanceof Part && ((Part) e).getAbstractType() instanceof Component
        && !isSupportingAssetHighlightedComponent(view)) {
      return 0;
    }
    
    if (e instanceof Entity && !isSupportingAssetHighlightedComponent(view)) {
      return 0;
    }
    
    if (diagram != null) {
      int nbOfElements = 0;
      int color = 0;
      for (PrimaryAsset asset : getRelatedAssets(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
        if (element != null && element instanceof DNode) {
          nbOfElements++;
          color = ((Ellipse) element.getStyle()).getColor().getGreen();
        }
      }
      for (Threat threat : getRelatedThreats(e)) {
        DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
        if (element != null && element instanceof DNode) {
          nbOfElements++;
          color = ((Ellipse) element.getStyle()).getColor().getGreen();
        }
      }
      return nbOfElements > 1 ? 0 : color;
    }
    return 0;
  }

  private int computeColorByLiteral(int literalValue, int literalSize, int colorMin, int colorMax) {
    if (literalValue == literalSize - 1)
      return colorMax;
    else if (literalValue == 1)
      return colorMin;
    else
      return (literalSize - literalValue - 1) * (colorMin - colorMax) / (literalSize - 2) + colorMax;
  }

  /**
   * Returns the green value of the Security Need, from the currently activated Security Needs Layers. Because the size
   * of Security Needs value is different, we calculate which is the min value of the green color: 
   * Example: 
   * If we have Confidentiality 3, but confidentiaity size is 6 and we have Integrity 2 and Integrity size is 2, the green value
   * shall be 0. (because in odesign red's value is 255, the element will be painted in red)
   * 
   * @param view
   * @return the the min value of the Green color, the smaller the green is, the element will be more red-ish.
   */
  public int getSecurityNeedsGreen(DSemanticDecorator view) {
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
    int colorMinVal = 210;
    int colorMaxVal = 20;
    int colorGreenMin = colorMinVal;

    if (diagram == null) {
      return colorGreenMin;
    }
    ModelElement element = (ModelElement) view.getTarget();

    Set<String> activatedLayerNames = new DDiagramQuery(diagram).getAllActivatedLayers().stream().map(Layer::getName)
        .collect(Collectors.toSet());

    Session session = SessionManager.INSTANCE.getSession(view);
    Project project = SessionHelper.getCapellaProject(session);

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_CONFIDENTIALITY)) {
      int confidentiality = getConfidentiality(element);
      int confidentialitySize = CybersecurityQueries.getConfidentialitySize(project);
      int color = computeColorByLiteral(confidentiality, confidentialitySize, colorMinVal, colorMaxVal);
      colorGreenMin = color < colorGreenMin ? color : colorGreenMin;
    }

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_INTEGRITY)) {
      int integrity = getIntegrity(element);
      int integritySize = CybersecurityQueries.getIntegritySize(project);
      int color = computeColorByLiteral(integrity, integritySize, colorMinVal, colorMaxVal);
      colorGreenMin = color < colorGreenMin ? color : colorGreenMin;
    }

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_AVAILABILITY)) {
      int availability = getAvailability(element);
      int availabilitySize = CybersecurityQueries.getAvailabilitySize(project);
      int color = computeColorByLiteral(availability, availabilitySize, colorMinVal, colorMaxVal);
      colorGreenMin = color < colorGreenMin ? color : colorGreenMin;
    }

    if (activatedLayerNames.contains(CybersecurityAnalysisConstants.LAYER_TRACEABILITY)) {
      int traceability = getTraceability(element);
      int traceabilitySize = CybersecurityQueries.getTraceabilitySize(project);
      int color = computeColorByLiteral(traceability, traceabilitySize, colorMinVal, colorMaxVal);
      colorGreenMin = color < colorGreenMin ? color : colorGreenMin;

    }
    return colorGreenMin;
  }
  
  public FunctionalPrimaryAsset createFunctionalPrimaryAsset(EObject any) {
    return createFunctionalPrimaryAssetInPkg(getDefaultCyberSecurityPackage(any, true));
  }

  public FunctionalPrimaryAsset createFunctionalPrimaryAssetInPkg(CybersecurityPkg pkg) {
    FunctionalPrimaryAsset asset = (FunctionalPrimaryAsset) attachToDefaultCybersecurityPkg(
        CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset(), pkg);

    if (asset != null) {
      String elementPrefix;
      if (BlockArchitectureExt.getRootBlockArchitecture(asset) instanceof OperationalAnalysis) {
        elementPrefix = "OperationalActivityPrimaryAsset";
      }
      else 
        elementPrefix = prefixService.getPrefix(asset);
      
      String uniqueName = CapellaServices.getService().getUniqueName(asset, elementPrefix);
      asset.setName(uniqueName);
    }

    return asset;
  }

  public InformationPrimaryAsset createInformationPrimaryAsset(EObject any) {
    return createInformationPrimaryAssetInPkg(getDefaultCyberSecurityPackage(any, true));
  }
  
  public InformationPrimaryAsset createInformationPrimaryAssetInPkg(CybersecurityPkg pkg) {
    InformationPrimaryAsset asset = (InformationPrimaryAsset) attachToDefaultCybersecurityPkg(
        CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset(), pkg);

    if (asset != null) {
      String elementPrefix = prefixService.getPrefix(asset);
      String uniqueName = CapellaServices.getService().getUniqueName(asset, elementPrefix);
      asset.setName(uniqueName);
    }

    return asset;
  }
  
  public EnterprisePrimaryAsset createEnterprisePrimaryAsset(EObject any) {
    return createEnterprisePrimaryAssetInPkg(getDefaultCyberSecurityPackage(any, true));
  }
  
  public EnterprisePrimaryAsset createEnterprisePrimaryAssetInPkg(CybersecurityPkg pkg) {
    EnterprisePrimaryAsset asset = (EnterprisePrimaryAsset) attachToDefaultCybersecurityPkg(
        CybersecurityFactory.eINSTANCE.createEnterprisePrimaryAsset(), pkg);

    if (asset != null) {
      String elementPrefix = prefixService.getPrefix(asset);
      String uniqueName = CapellaServices.getService().getUniqueName(asset, elementPrefix);
      asset.setName(uniqueName);
    }

    return asset;
  }

  private EObject attachToDefaultCybersecurityPkg(EObject cyberObject, CybersecurityPkg pkg) {
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
  
  public ThreatSourceUse createThreaSourcetUse(Component threatSource, Component actor) {
    ThreatSourceUse tu = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    tu.setUsedActor(actor);
    threatSource.getOwnedExtensions().add(tu);
    return tu;
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

  protected PhysicalLink getRepresentedPhysicalLink(ModelElement element) {
    PhysicalLink pl = null;
    if (element instanceof PhysicalLink) {
      pl = (PhysicalLink) element;
    }
    return pl;
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
  
  public List<Component> getAllThreatEntities(EObject element) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(element);
    return BlockArchitectureExt.getAllComponents(architecture).stream().filter(c -> !c.isActor() && c instanceof Entity)
        .collect(Collectors.toList());
  }
  
  public Collection<Threat> getAllCurrentLevelThreats(EObject element) {
    return getThreats(getDefaultCyberSecurityPackage(element, false));
  }
  
  public Collection<Threat> getThreats(CybersecurityPkg pkg) {
    List<Threat> threats = new ArrayList<>();
    if(pkg == null) {
      return threats;
    }
    
    for(CybersecurityPkg subPkg : pkg.getOwnedCybersecurityPkgs()) {
      threats.addAll(getThreats(subPkg));
    }
    threats.addAll(pkg.getOwnedThreats());
    return threats;
  }
  
  public Collection<PrimaryAsset> getAllCurrentLevelFunctionalPrimaryAssets(EObject element) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(element, false);
    return getPrimaryAssets(pkg).stream().filter(FunctionalPrimaryAsset.class::isInstance).collect(Collectors.toList());
  }
  
  public Collection<PrimaryAsset> getAllCurrentLevelInformationPrimaryAssets(EObject element) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(element, false);
    return getPrimaryAssets(pkg).stream().filter(InformationPrimaryAsset.class::isInstance).collect(Collectors.toList());
  }
  
  public Collection<PrimaryAsset> getAllCurrentLevelEnterprisePrimaryAssets(EObject element) {
    CybersecurityPkg pkg = getDefaultCyberSecurityPackage(element, false);
    return getPrimaryAssets(pkg).stream().filter(EnterprisePrimaryAsset.class::isInstance).collect(Collectors.toList());
  }
  
  public Collection<PrimaryAsset> getPrimaryAssets(CybersecurityPkg pkg) {
    List<PrimaryAsset> primaryAssets = new ArrayList<>();
    if(pkg == null) {
      return primaryAssets;
    }
    
    for(CybersecurityPkg subPkg : pkg.getOwnedCybersecurityPkgs()) {
      primaryAssets.addAll(getPrimaryAssets(subPkg));
    }
    primaryAssets.addAll(pkg.getOwnedPrimaryAssets());
    return primaryAssets;
  }

  public Collection<PrimaryAsset> getRelatedAssets(EObject element) {
    if (element instanceof Part && ((Part) element).getAbstractType() instanceof Component) {
      Component component = (Component) ((Part) element).getAbstractType();
      return getRelatedAssetsForComponent(component);
    }
    if (element instanceof Component) {
      Component component = (Component) element;
      return getRelatedAssetsForComponent(component);
    }
    if (element instanceof ComponentExchange) {
      ComponentExchange componentExchange = (ComponentExchange) element;
      return getRelatedAssetsForComponentExchange(componentExchange);
    }
    if (element instanceof PhysicalLink) {
      PhysicalLink physicalLink = (PhysicalLink) element;
      return getRelatedAssetsForPhysicalLink(physicalLink);
    }

    Collection<EObject> semantics = new ArrayList<>();
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(element);
    List<FunctionalChain> functionalChains = FunctionalChainExt.getAllFunctionalChains(architecture);

    if (element instanceof SequenceMessage) {
      element = getRepresentedFunctionalExchange((ModelElement) element);
    } else if (element instanceof StateFragment) {
      element = getRepresentedFunction((ModelElement) element);
    }

    semantics.add(element);
    if (element instanceof FunctionalExchange) {
      semantics.addAll(((FunctionalExchange) element).getExchangedItems());
      for (FunctionalChain fc : functionalChains) {
        if (fc.getInvolvedFunctionalExchanges().contains(element)) {
          semantics.add(fc);
        }
      }
    }

    if (element instanceof AbstractFunction) {
      FunctionStorage fs = getFunctionStorage((ExtensibleElement) element);
      if (fs != null) {
        semantics.addAll(fs.getExchangedItems());
      }
      for (FunctionalChain fc : functionalChains) {
        if (fc.getInvolvedFunctions().contains(element)) {
          semantics.add(fc);
        }
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

    return assets.stream().distinct().collect(Collectors.toList());
  }

  private Collection<PrimaryAsset> getRelatedAssetsForPhysicalLink(PhysicalLink physicalLink) {
    // retrieve allocatedComponentExchanges -> allocatedFunctionalExchanges -> Related Assets
    List<ComponentExchange> allocatedComponentExchanges = physicalLink.getAllocatedComponentExchanges();
    List<PrimaryAsset> relatedAssets = allocatedComponentExchanges.stream().map(exchange -> getRelatedAssets(exchange))
        .flatMap(Collection::stream).distinct().collect(Collectors.toList());
    return relatedAssets;
  }

  private Collection<PrimaryAsset> getRelatedAssetsForComponentExchange(ComponentExchange componentExchange) {
    // retrieve allocatedFunctionalExchanges-> Related Assets
    List<FunctionalExchange> allocatedFunctionalExchanges = componentExchange.getAllocatedFunctionalExchanges();
    Collection<PrimaryAsset> relatedAssets = allocatedFunctionalExchanges.stream()
        .map(exchange -> getRelatedAssets(exchange)).flatMap(Collection::stream).distinct()
        .collect(Collectors.toList());
    return relatedAssets;
  }

  public Collection<Threat> getRelatedThreats(EObject element) {
    // if element is an asset skip calculating related assets and return element
    Collection<PrimaryAsset> relatedAssets = element instanceof PrimaryAsset ? Arrays.asList((PrimaryAsset) element)
        : getRelatedAssets(element);
    Collection<Threat> threats = relatedAssets.stream()
        .map(asset -> CybersecurityQueries.getThreatsOf(asset).collect(Collectors.toList())).flatMap(Collection::stream)
        .distinct().collect(Collectors.toList());

    return threats;
  }

  public boolean hasAssetStyleCustomization(EObject element) {
    // customization for Assets Layer - return true if style has to be applied on the given element
    TransactionalEditingDomain domain = TransactionHelper.getEditingDomain(element);
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(element);
    List<FunctionalChain> functionalChains = FunctionalChainExt.getAllFunctionalChains(architecture);

    if (element instanceof ComponentExchange || element instanceof Component) {
      return false;
    }
    
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
        for (FunctionalChain fc : functionalChains) {
          if (fc.getInvolvedFunctionalExchanges().contains(element)) {
            if (hasAssetStyleCustomization(fc)) {
              return true;
            }
          }
        }
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

        for (FunctionalChain fc : functionalChains) {
          if (fc.getInvolvedFunctions().contains(element)) {
            if (hasAssetStyleCustomization(fc)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public boolean hasSupportingAssetStyleCustomization(EObject element, DSemanticDecorator view) {
    // customization for Supporting Assets Layer - return true if style has to be applied on the given element

    // element has this style if:
    // - element is a Component
    //   - for this component, if BPC, calculate all subused components, then their allocated functions, then their
    //     related assets and threats THAT ARE DISPLAYED(!!)
    //   - for this component, if NPC, calculate all subused and deployed components, then same as above
    // - element is a ComponentExchange
    // - element is a PhysicalLink

    //filter out Functions and FunctionalExchanges
    if (element instanceof AbstractFunction || element instanceof FunctionalExchange) {
      return false;
    }
    
    TransactionalEditingDomain domain = TransactionHelper.getEditingDomain(element);
    if (domain instanceof SemanticEditingDomain) {
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      return hasDisplayedAssetsOrThreats(diagram, element);
    }

    return false;
  }

  private boolean hasDisplayedAssetsOrThreats(DDiagram diagram, EObject element) {
    Collection<PrimaryAsset> relatedAssets = new ArrayList<>();
    relatedAssets = getRelatedAssets(element);

    // check if any related asset is displayed
    List<PrimaryAsset> displayedRelatedAssets = getDisplayedAssets(diagram, relatedAssets);
    if (displayedRelatedAssets.size() > 0) {
      return true;
    }

    // if no asset is displayed, check if any related threat is displayed
    List<Threat> relatedThreats = relatedAssets.stream().map(asset -> getRelatedThreats(asset))
        .flatMap(Collection::stream).distinct().collect(Collectors.toList());
    List<Threat> displayedRelatedThreats = getDisplayedRelatedThreats(diagram, relatedThreats);
    if (displayedRelatedThreats.size() > 0) {
      return true;
    }

    // no related asset or threat is displayed
    return false;
  }

  private List<Threat> getDisplayedRelatedThreats(DDiagram diagram, List<Threat> relatedThreats) {
    // check displayed threats
    List<Threat> displayedRelatedThreats = new ArrayList<>();
    for (Threat threat : relatedThreats) {
      DDiagramElement elem = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
      if (elem instanceof DNode) {
        // threat is displayed, add it to the list
        displayedRelatedThreats.add(threat);
      }
    }
    return displayedRelatedThreats;
  }

  /*
   * Remove customization of a function if it has two or more involving functional chains and they are not present in
   * diagram
   */
  public boolean removeCustomizationIfNeeded(DSemanticDecorator view) {
    EObject target = view.getTarget();
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);

    if (diagram != null ) {
      EList<FunctionalChain> functionalChains = null;
      if (target instanceof AbstractFunction) {
       functionalChains = ((AbstractFunction) target).getInvolvingFunctionalChains();
      }
      if (target instanceof FunctionalExchange) {
        functionalChains = ((FunctionalExchange) target).getInvolvingFunctionalChains();
      }
      
      if (functionalChains.size() > 1) {
        boolean allFunctionalChainsAreRemoved = true;
        for (FunctionalChain fc : functionalChains) {
          if (diagram.getOwnedDiagramElements().contains(fc)) {
            allFunctionalChainsAreRemoved = false;
          }
        }
        if (allFunctionalChainsAreRemoved) {
          ShapeUtil.removeCustomisation(ShapeUtil.getCurrentStyle((DDiagramElement) view),
              new EStructuralFeature[] { DiagramPackage.Literals.BORDERED_STYLE__BORDER_COLOR });
          ShapeUtil.removeCustomisation(ShapeUtil.getCurrentStyle((DDiagramElement) view),
              new EStructuralFeature[] { DiagramPackage.Literals.EDGE_STYLE__STROKE_COLOR });
        }
      }
    }
    return true;
  }

  private List<PrimaryAsset> getDisplayedAssets(DDiagram diagram, Collection<PrimaryAsset> relatedAssets) {
    // check displayed assets
    List<PrimaryAsset> displayedRelatedAssets = new ArrayList<>();
    for (PrimaryAsset asset : relatedAssets) {
      DDiagramElement elem = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
      if (elem instanceof DNode) {
        // asset is displayed, add it to the list
        displayedRelatedAssets.add(asset);
      }
    }
    return displayedRelatedAssets;
  }

  private Collection<PrimaryAsset> getRelatedAssetsForComponent(Component component) {
    Collection<Component> allSubUsedComponents = ComponentExt.getAllSubUsedAndDeployedComponents(component);
    
    List<AbstractFunction> allocatedFunctions = allSubUsedComponents.stream().map(comp -> comp.getAllocatedFunctions())
        .flatMap(Collection::stream).distinct().collect(Collectors.toList());

    // get related assets
    List<PrimaryAsset> relatedAssets = allocatedFunctions.stream().map(func -> getRelatedAssets(func))
        .flatMap(Collection::stream).distinct().collect(Collectors.toList());
    return relatedAssets;
  }

  public String getAssetDecorationBorderSize(DSemanticDecorator view) {
    if (view instanceof AbstractDNode) {
      EObject e = view.getTarget();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      if (diagram != null) {
        for (PrimaryAsset asset : getRelatedAssets(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
          if (element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
        for (Threat threat : getRelatedThreats(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
          if (element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  public String getSupportingAssetsDecorationBorderSize(DSemanticDecorator view) {
    if (view instanceof AbstractDNode) {
      EObject e = view.getTarget();

      if (!isSupportingAssetHighlightedComponent(view)) {
        return "1";
      }

      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      if (diagram != null) {
        for (PrimaryAsset asset : getRelatedAssets(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
          if (element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
        for (Threat threat : getRelatedThreats(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
          if (element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  private boolean isSupportingAssetHighlightedComponent(DSemanticDecorator view) {
    EObject element = view.getTarget();
    if (!(element instanceof Part || element instanceof Entity)) {
      return false;
    }
    
    if (element instanceof Entity) {
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      return isSupportingAssetHighlightedComponent(diagram, (Entity) element);
    }
    
    if (((Part) element).getAbstractType() instanceof PhysicalComponent) {
      PhysicalComponent comp = (PhysicalComponent) ((Part) element).getAbstractType();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      if (comp.getNature() == PhysicalComponentNature.NODE) {         
        return isSupportingAssetHighlightedNPCComponent(diagram, comp);
      }
      if (comp.getNature() == PhysicalComponentNature.BEHAVIOR) {
        if (hasAllocatedFunctions(comp)) {
          return true;
        }
        //no allocated functions, check the BPC child components that should be highlighted, but are hidden
        return isSupportingAssetHighlightedBPCComponent(diagram, comp);
      }
    } else if (((Part) element).getAbstractType() instanceof Component) {
      Component comp = (Component) ((Part) element).getAbstractType();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      return isSupportingAssetHighlightedComponent(diagram, comp);
    }
    
    return false;
  }

  private boolean hasAllocatedFunctions(Component comp) {
    List<AbstractFunction> allocatedFunctions = comp.getAllocatedFunctions();
    return allocatedFunctions.size() > 0 ? true : false;
  }
  
  private boolean isSupportingAssetHighlightedComponent(DDiagram diagram, Component comp) {
    // if component has allocated functions, return true
    if (hasAllocatedFunctions(comp)) {
      return true;
    }

    // if component has component children that are highlighted, but not visible, it must take the highlighting style
    List<Component> componentChildren = ComponentExt.getSubUsedComponents(comp);
    for (Component component : componentChildren) {
      if (isSupportingAssetHighlightedComponent(diagram, component) && !isDisplayedInDiagram(diagram, component)) {
        return true;
      }
    }
    return false;
  }

  private boolean isSupportingAssetHighlightedBPCComponent(DDiagram diagram, PhysicalComponent comp) {
    //if component has allocated functions, return true
    if (hasAllocatedFunctions(comp)) {
      return true;
    }
    
    //if component has BPC children that are highlighted, but not visible, it must take the highlighting style  
    List<PhysicalComponent> bpcChildren = getBPCChildrenOfComponent(comp);
    if (bpcChildren.size() > 0) {
      for (PhysicalComponent bpcComponent : bpcChildren) {
        if (isSupportingAssetHighlightedBPCComponent(diagram, bpcComponent)
            && !isDisplayedInDiagram(diagram, bpcComponent)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isSupportingAssetHighlightedNPCComponent(DDiagram diagram, PhysicalComponent comp) {
    if (hasDirectBPCWithSupportingAssetCustomization(comp)) {
      return true;
    }
    //no BPC child components, check NPC children
    List<PhysicalComponent> npcChildren = getNPCChildrenOfComponent(comp);
    if (npcChildren.size() > 0) {
      for (PhysicalComponent npcComponent : npcChildren) {
        if (isSupportingAssetHighlightedNPCComponent(diagram, npcComponent)
            && !isDisplayedInDiagram(diagram, npcComponent)) {
          return true;
        }
      }
      //no child component is highlighted and hidden -> check functions if PA
      if (comp.isActor()) {
        List<AbstractFunction> allocatedFunctions = comp.getAllocatedFunctions();

        // get related assets from only these allocated functions
        List<PrimaryAsset> relatedAssets = allocatedFunctions.stream().map(func -> getRelatedAssets(func))
            .flatMap(Collection::stream).distinct().collect(Collectors.toList());
        if (relatedAssets.size() > 0) {
          return true;
        }
      }
    }   
    //no BPC children, no NPC children, check functions
    List<PrimaryAsset> relatedAssets = comp.getAllocatedFunctions().stream()
        .map(func -> getRelatedAssets(func))
        .flatMap(Collection::stream).distinct().collect(Collectors.toList()); 
    return relatedAssets.size() > 0 ? true : false;
  }

  private boolean isDisplayedInDiagram(DDiagram diagram, Component component) {
    List<DRepresentationElement> diagramElements = diagram.getRepresentationElements()
        .stream().filter(element -> element instanceof DNodeContainer && element.getSemanticElements().contains(component))
        .collect(Collectors.toList());
    return diagramElements.isEmpty() ? false : true;
  }

  private List<PhysicalComponent> getBPCChildrenOfComponent(PhysicalComponent comp) {
    List<PhysicalComponent> children = getDirectChildrenOfComponent(comp);
    List<PhysicalComponent> bpcChildren = getBPCComponentsFromList(children);    
    return bpcChildren;
  }
  
  private List<PhysicalComponent> getNPCChildrenOfComponent(PhysicalComponent comp) {
    List<PhysicalComponent> children = getDirectChildrenOfComponent(comp);
    List<PhysicalComponent> npcChildren = getNPCComponentsFromList(children);    
    return npcChildren;
  }

  private List<PhysicalComponent> getNPCComponentsFromList(List<PhysicalComponent> components) {
    return components.stream().distinct()
        .filter(c -> ((PhysicalComponent) c).getNature().equals(PhysicalComponentNature.NODE))
        .collect(Collectors.toList());
  }
  
  private List<PhysicalComponent> getBPCComponentsFromList(List<PhysicalComponent> components) {
    return components.stream().distinct()
        .filter(c -> ((PhysicalComponent) c).getNature().equals(PhysicalComponentNature.BEHAVIOR))
        .collect(Collectors.toList());
  }

  private boolean hasDirectBPCWithSupportingAssetCustomization(PhysicalComponent comp) {       
    List<PhysicalComponent> children = getDirectChildrenOfComponent(comp);
    List<PhysicalComponent> bpcChildren = getBPCComponentsFromList(children);    
    return bpcChildren.size() > 0 ? true : false;
  }
  
  private List<PhysicalComponent> getDirectChildrenOfComponent(PhysicalComponent comp) {
    Stream<PhysicalComponent> stream1 = comp.getSubPhysicalComponents().stream();
    Stream<PhysicalComponent> stream2 = comp.getDeployedPhysicalComponents().stream();
    return Stream.concat(stream1, stream2).collect(Collectors.toList());
  }

  private boolean isSupportingAssetHighlightedExchange(EObject element) {
    // filter out the FunctionalExchanges, they will be considered in Assets Layer
    if (element instanceof FunctionalExchange) {
      return false;
    }
    return true;
  }

  public boolean isElementAtOperationalLevel(EObject element) {
    return BlockArchitectureExt.getRootBlockArchitecture(element) instanceof OperationalAnalysis;
  }

  public boolean isToolAtOperationalLevel(EObject context) {
    return context.eCrossReferences().stream().anyMatch(o -> o instanceof Entity || o instanceof EntityPkg);
  }

  public String getAssetDecorationSize(DSemanticDecorator view) {
    if (view instanceof DEdge) {
      EObject e = view.getTarget();
      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      if (diagram != null) {
        for (PrimaryAsset asset : getRelatedAssets(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
          if (element != null && element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
        for (Threat threat : getRelatedThreats(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
          if (element != null && element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  public String getSupportingAssetsDecorationSize(DSemanticDecorator view) {
    if (view instanceof DEdge) {
      EObject e = view.getTarget();

      if (!isSupportingAssetHighlightedExchange(e)) {
        return "1";
      }

      DDiagram diagram = CapellaServices.getService().getDiagramContainer(view);
      if (diagram != null) {
        for (PrimaryAsset asset : getRelatedAssets(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, asset);
          if (element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
        for (Threat threat : getRelatedThreats(e)) {
          DDiagramElement element = DiagramServices.getDiagramServices().getDiagramElement(diagram, threat);
          if (element != null && element instanceof DNode) {
            return "5"; //$NON-NLS-1$
          }
        }
      }
      return "1"; //$NON-NLS-1$
    }
    return null;
  }

  public boolean hasTrustedColor(Part part) {
    return CybersecurityQueries.isTrusted(part);
  }
  
  public boolean hasTrustedColor(Entity entity) {
    return CybersecurityQueries.isTrusted(entity);
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

    PhysicalLink representedPhysicalLink = getRepresentedPhysicalLink(element);
    if (representedPhysicalLink != null) {
      return CybersecurityQueries.isTrustBoundary(representedPhysicalLink);
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
      return CybersecurityQueries.getConfidentialityIndex(needs);
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
      return CybersecurityQueries.getIntegrityIndex(needs);
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
      return CybersecurityQueries.getAvailabilityIndex(needs);
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
      return CybersecurityQueries.getTraceabilityIndex(needs);
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
    int maxSecurityNeedValue = 0;

    DDiagram diagram = CapellaServices.getService().getDiagramContainer(decorator);
    if (diagram == null) {
      return maxSecurityNeedValue;
    }
    ModelElement element = (ModelElement) decorator.getTarget();

    Set<String> activatedLayerNames = new DDiagramQuery(diagram).getAllActivatedLayers().stream().map(Layer::getName)
        .collect(Collectors.toSet());

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
    ((Ellipse) assetView.getOwnedStyle())
        .setColor(RGBValues.create(colorRands.nextInt(), colorRands.nextInt(), colorRands.nextInt()));
    ((Ellipse) assetView.getOwnedStyle()).getCustomFeatures().add("color"); //$NON-NLS-1$
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

  public void setConfidentiality(ExtensibleElement element, EnumerationPropertyLiteral value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setConfidentialityValue(value);
  }

  public void setIntegrity(ExtensibleElement element, EnumerationPropertyLiteral value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setIntegrityValue(value);
  }

  public void setTraceability(ExtensibleElement element, EnumerationPropertyLiteral value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setTraceabilityValue(value);
  }

  public void setAvailability(ExtensibleElement element, EnumerationPropertyLiteral value) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    sn.setAvailabilityValue(value);
  }

  public void setConfidentiality(ExtensibleElement element, int index, EnumerationPropertyType type) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    CybersecurityQueries.setConfidentialityFromIndex(sn, index, type);
  }

  public void setIntegrity(ExtensibleElement element, int index, EnumerationPropertyType type) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    CybersecurityQueries.setIntegrityFromIndex(sn, index, type);
  }

  public void setTraceability(ExtensibleElement element, int index, EnumerationPropertyType type) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    CybersecurityQueries.setTraceabilityFromIndex(sn, index, type);
  }

  public void setAvailability(ExtensibleElement element, int index, EnumerationPropertyType type) {
    SecurityNeeds sn = getSecurityNeeds(element, true);
    CybersecurityQueries.setAvailabilityFromIndex(sn, index, type);
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
