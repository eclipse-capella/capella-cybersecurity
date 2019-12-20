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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.IntegerValueGroup;
import org.polarsys.capella.core.ui.properties.fields.TextAreaValueGroup;
import org.polarsys.capella.core.ui.properties.fields.TextValueGroup;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.ui.properties.fields.ThreatKindGroup;

public class ThreatSection extends AbstractSection {

  ThreatKindGroup threatKindGroup;
  TextValueGroup rationaleGroup;
  IntegerValueGroup levelGroup;
  
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof Threat;
  }

  @Override
  protected void createContents(Composite rootParentComposite, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createContents(rootParentComposite, aTabbedPropertySheetPage);
    threatKindGroup = new ThreatKindGroup(rootParentComposite, getWidgetFactory());
    levelGroup = new IntegerValueGroup(rootParentComposite, Messages.ThreatSection_0, getWidgetFactory());
    rationaleGroup = new TextAreaValueGroup(rootParentComposite, Messages.ActorCybersecuritySection_1, getWidgetFactory());
  }

  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);
    loadData(newEObject);
  }

  @Override
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);
    threatKindGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__THREAT_KIND);
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

  
  
}
