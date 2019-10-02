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
package org.polarsys.capella.cybersecurity.ui.properties.sections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.platform.sirius.ted.SemanticEditingDomainFactory.SemanticEditingDomain;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.MultipleSemanticField;
import org.polarsys.capella.core.ui.properties.helpers.DialogHelper;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

/**
 * This section allows adding/removing an element to a primary asset
 * via the properties page of the element.
 */
public abstract class PrimaryAssetInverseMember extends AbstractSection {

  private PrimaryAssetField primaryAssetMemberships;
  private final EClass assetClass;
  private final EClass memberClass;

  public PrimaryAssetInverseMember(EClass assetClass, EClass memberClass) {
    this.assetClass = assetClass;
    this.memberClass = memberClass;
  }

  @Override
  public boolean select(Object toTest) {
    return memberClass.isInstance(super.selection(toTest));
  }

  @Override
  protected void createContents(Composite rootParentComposite, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    primaryAssetMemberships = new PrimaryAssetField(getReferencesGroup(), Messages.FunctionCybersecuritySection_FunctionPrimaryAssetProperty_Label, getWidgetFactory());
  }

  @Override
  public void loadData(EObject object) {
    super.loadData(object);
    primaryAssetMemberships.loadData(object);
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    return Collections.singletonList(primaryAssetMemberships);
  }

  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);
    loadData((CapellaElement) newEObject);
  }

  private class PrimaryAssetField extends MultipleSemanticField {
    public PrimaryAssetField(Composite parent, String label, TabbedPropertySheetWidgetFactory widgetFactory) {
      super(parent, label, widgetFactory, new PrimaryAssetController());
    }

    @Override
    protected void doDeleteCommand(EObject element, EStructuralFeature feature) {
      for (EObject fpa : _controller.loadValues(element, feature)) {
        ((PrimaryAssetController)_controller).doRemoveOperationInWriteOpenValues(element, feature, fpa);
      }
    }

    protected void handleDeleteButtonClicked() {
      super.handleDeleteButtonClicked();
      loadData(semanticElement);
    }

    protected List<EObject> openTransferDialog(Button button, List<EObject> currentElements, List<EObject> availableElements, String title, String message) {
      return DialogHelper.openTransferDialog(button, currentElements, availableElements, title, NLS.bind(Messages.PrimaryAssetInverseMember_TransferDialogTitle, EObjectLabelProviderHelper.getText(semanticElement)));
    }

  }

  private class PrimaryAssetController extends AbstractMultipleSemanticFieldController {

    @Override
    public List<EObject> loadValues(EObject semanticElement, EStructuralFeature semanticFeature) {
      return doQueryCurrentElements(semanticElement, null);
    }

    protected List<EObject> doQueryCurrentElements(EObject semanticElement, IBusinessQuery query){
      SemanticEditingDomain domain = (SemanticEditingDomain) TransactionHelper.getExecutionManager(semanticElement).getEditingDomain();
      return domain
        .getCrossReferencer()
        .getInverseReferences(semanticElement, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER, true)
        .stream()
        .map(s -> ((PrimaryAssetMember)s.getEObject()).getAsset())
        .distinct()
        .collect(Collectors.toList());
    }

    protected List<EObject> doQueryAvailableElements(EObject semanticElement, IBusinessQuery query){
      return new ArrayList<>(ItemPropertyDescriptor.getReachableObjectsOfType(semanticElement, assetClass));
    }

    @Override
    protected void doAddOperationInWriteOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
        EObject fpa) {
      PrimaryAssetMember m = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
      m.setAsset((PrimaryAsset) fpa);
      m.setMember((ModelElement) semanticElement);
      ((PrimaryAsset)fpa).getOwnedMembers().add(m);
    }

    @Override
    protected void doRemoveOperationInWriteOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
        EObject object) {
      for (Iterator<PrimaryAssetMember> it = ((PrimaryAsset) object).getOwnedMembers().iterator(); it.hasNext();) {
        PrimaryAssetMember member = it.next();
        if (member.getMember() == semanticElement) {
          it.remove();
        }
      }
    }

    @Override
    protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
      return null;
    }
  }

  public static final class AbstractFunctionSection extends PrimaryAssetInverseMember {
    public AbstractFunctionSection() {
      super(CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET, FaPackage.Literals.ABSTRACT_FUNCTION);
    }
  }

  public static final class ExchangeItemSection extends PrimaryAssetInverseMember {
    public ExchangeItemSection() {
      super(CybersecurityPackage.Literals.INFORMATION_PRIMARY_ASSET, InformationPackage.Literals.EXCHANGE_ITEM);
    }
  }

}
