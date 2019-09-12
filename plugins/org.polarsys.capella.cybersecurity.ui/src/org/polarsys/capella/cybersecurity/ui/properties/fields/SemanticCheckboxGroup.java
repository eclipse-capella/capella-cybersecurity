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
package org.polarsys.capella.cybersecurity.ui.properties.fields;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticCheckboxGroup;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class SemanticCheckboxGroup extends AbstractSemanticCheckboxGroup {
  private final static String KEY_ENABLER = "semantic_checkbox_enabler"; //$NON-NLS-1$
  private final List<Button> semanticFields;
  private final Composite parent;

  public SemanticCheckboxGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, EAttribute... attributes) {
    super(parent, widgetFactory);
    this.parent = parent;
    this.semanticFields = new ArrayList<Button>();
    for (EAttribute att : attributes) {
      addCheckbox(att);
    }
  }

  public SemanticCheckboxGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
    this(parent, widgetFactory, new EAttribute[0]);
  }

  public void addCheckbox(EAttribute att, Predicate<EObject> enabler) {
    Button button = createButton(att, CybersecurityEditPlugin.INSTANCE
        .getString("_UI_" + att.getEContainingClass().getName() + "_" + att.getName() + "_feature"), parent);
    button.setData(KEY_ENABLER, enabler);
    semanticFields.add(button);
  }

  public void addCheckbox(EAttribute att) {
    addCheckbox(att, null);
  }

  @Override
  public List<Button> getSemanticFields() {
    return semanticFields;
  }

  @Override
  public void loadData(EObject semanticElement) {
    super.loadData(semanticElement);
    for (Button b : getSemanticFields()) {
      @SuppressWarnings("unchecked")
      Predicate<EObject> enabler = (Predicate<EObject>) b.getData(KEY_ENABLER);
      if (enabler != null) {
        b.setEnabled(enabler.test(semanticElement));
      }
    }
  }

}
