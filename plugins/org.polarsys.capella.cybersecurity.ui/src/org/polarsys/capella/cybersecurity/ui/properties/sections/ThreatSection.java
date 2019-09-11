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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.data.core.properties.sections.NamedElementSection;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.IntegerValueGroup;
import org.polarsys.capella.core.ui.properties.fields.TextValueGroup;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.ui.properties.fields.ThreatKindGroup;

public class ThreatSection extends NamedElementSection {

  ThreatKindGroup threatKindGroup;
  TextValueGroup rationaleGroup;
  IntegerValueGroup levelGroup;
  
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof Threat;
  }

  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);
    threatKindGroup = new ThreatKindGroup(rootParentComposite, getWidgetFactory());
    rationaleGroup = new TextValueGroup(rootParentComposite, Messages.ActorCybersecuritySection_1, getWidgetFactory());
    levelGroup = new IntegerValueGroup(rootParentComposite, Messages.ThreatSection_0, getWidgetFactory());
  }

  @Override
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);
    threatKindGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__THREAT_KIND);
    rationaleGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__RATIONALE);
    levelGroup.loadData(capellaElement, CybersecurityPackage.Literals.THREAT__LEVEL);
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> fields = super.getSemanticFields();
    fields.add(threatKindGroup);
    fields.add(rationaleGroup);
    fields.add(levelGroup);
    return fields;
  }

  
  
}
