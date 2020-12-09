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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.TextAreaValueGroup;
import org.polarsys.capella.core.ui.properties.fields.TextValueGroup;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;
import org.polarsys.capella.cybersecurity.ui.properties.fields.EnumerationLiterealValueRadioGroup;
import org.polarsys.capella.cybersecurity.ui.properties.fields.IntegerValueRadioGroup;

public class ThreatSection extends AbstractSection {

  EnumerationLiterealValueRadioGroup threatKindGroup;
  TextValueGroup rationaleGroup;
  IntegerValueRadioGroup levelGroup;
  
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof Threat;
  }

  @Override
  protected void createContents(Composite rootParentComposite, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createContents(rootParentComposite, aTabbedPropertySheetPage);
    threatKindGroup = null;
    levelGroup = null;
    rationaleGroup = null;
  }

  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);
    loadData(newEObject);
  }

  @Override
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);
    if(threatKindGroup == null || levelGroup == null || rationaleGroup == null) {
      createThreatKindGroup(capellaElement);
      levelGroup = new IntegerValueRadioGroup(rootParentComposite, Messages.ThreatSection_0, getWidgetFactory(), 1, 5);
      rationaleGroup = new TextAreaValueGroup(rootParentComposite, Messages.ActorCybersecuritySection_1, getWidgetFactory());
    }
    threatKindGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__KIND);
    levelGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__LEVEL);
    rationaleGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__RATIONALE);
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> fields = new ArrayList<>();
    fields.add(threatKindGroup);
    fields.add(levelGroup);
    fields.add(rationaleGroup);
    return fields;
  }

  protected void  createThreatKindGroup(EObject capellaElement) {
    EObject element = capellaElement;
    Session session = SessionManager.INSTANCE.getSession(element);
    Project project = SessionHelper.getCapellaProject(session);
    
    EnumerationPropertyType type = CybersecurityQueries.getThreatKindPropertyType(project);
    int numCols = type != null ? 3 : 1;
    threatKindGroup = new EnumerationLiterealValueRadioGroup(rootParentComposite, CybersecurityEditPlugin.INSTANCE.getString("_UI_Threat_threatKind_feature"),
        type,
        getWidgetFactory(), numCols); 
  }
}
