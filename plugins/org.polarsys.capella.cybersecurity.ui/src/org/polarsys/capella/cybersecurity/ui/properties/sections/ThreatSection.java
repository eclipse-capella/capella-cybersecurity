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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.TextAreaValueGroup;
import org.polarsys.capella.core.ui.properties.fields.TextValueGroup;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;
import org.polarsys.capella.cybersecurity.ui.properties.fields.EnumerationLiterealValueRadioGroup;
import org.polarsys.capella.cybersecurity.ui.properties.fields.IntegerValueRadioGroup;

public class ThreatSection extends CybersecuritySection {

  EnumerationLiterealValueRadioGroup threatKindGroup;
  TextValueGroup rationaleGroup;
  IntegerValueRadioGroup levelGroup;
  
  public ThreatSection() {
    super(true);
  }
  
  public ThreatSection(boolean showRealizations) {
    super(showRealizations);
  }
  
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof Threat && isRealizedArchitecture(eObjectToTest);
  }

  @Override
  protected void createContents(Composite rootParentComposite, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createContents(rootParentComposite, aTabbedPropertySheetPage);
    threatKindGroup = null;
    levelGroup = null;
    rationaleGroup = null;
    
    super.addRealizedWidget("Realized Threats");
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
    
    super.loadRealizedWidget(capellaElement);
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> fields = new ArrayList<>();
    fields.add(threatKindGroup);
    fields.add(levelGroup);
    fields.add(rationaleGroup);
    
    super.addRealizedFields(fields);
    return fields;
  }

  protected void  createThreatKindGroup(EObject capellaElement) {
    EObject element = capellaElement;
    Session session = SessionManager.INSTANCE.getSession(element);
    Project project = SessionHelper.getCapellaProject(session);
    
    threatKindGroup = new EnumerationLiterealValueRadioGroup(rootParentComposite,
        CybersecurityEditPlugin.INSTANCE.getString("_UI_Threat_threatKind_feature"),
        CybersecurityQueries.getThreatKindPropertyType(project), getWidgetFactory(), 3) {
      @Override
      public void loadData(EObject capellaElement, EStructuralFeature feature) {
        super.loadData(capellaElement, feature);

        Object value = semanticElement.eGet(semanticFeature);
        for (Button button : getSemanticFields()) {
          if (button != null) {
            button.setSelection(value != null ? value.equals(button.getData()) : false);
          }
        }
      }
    };
  }
}
