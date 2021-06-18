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
package org.polarsys.capella.cybersecurity.ui.properties.sections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.ContainmentTableField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;

public class InformationPrimaryAssetSection extends AbstractSection {

  ContainmentTableField _containmentTableField;
  CyberMultipleSemanticField realizedWidget;

  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof InformationPrimaryAsset;
  }

  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);
    boolean displayedInWizard = isDisplayedInWizard();

    Group memberGroup = getWidgetFactory().createGroup(rootParentComposite, ""); //$NON-NLS-1$
    memberGroup.setLayout(new GridLayout(1, false));
    GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
    layoutData.horizontalSpan = 2;
    memberGroup.setLayoutData(layoutData);

    _containmentTableField = new ContainmentTableField(memberGroup, getWidgetFactory(), null,
        CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER, CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER,
        Messages.InformationPrimaryAssetSection_0, Messages.InformationPrimaryAssetSection_1);
    _containmentTableField.setDisplayedInWizard(displayedInWizard);
    
    realizedWidget = new CyberMultipleSemanticField(getReferencesGroup(),
        ICommonConstants.EMPTY_STRING, getWidgetFactory(), new CybersecurityRealizationsController());
    realizedWidget.setLabel("Realized Information Primary Assets");
    realizedWidget.setDisplayedInWizard(false);
  }

  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);
    loadData(newEObject);
  }

  @Override
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);
    _containmentTableField.loadData(capellaElement, CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS);
    realizedWidget.loadData(capellaElement, ModellingcorePackage.Literals.TRACEABLE_ELEMENT__OUTGOING_TRACES);
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> fields = new ArrayList<>();
    fields.add(_containmentTableField);
    fields.add(realizedWidget);
    return fields;
  }

}
