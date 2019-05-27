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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticCheckboxGroup;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class SemanticCheckboxGroup extends AbstractSemanticCheckboxGroup {

  private final List<Button> semanticFields;

  public SemanticCheckboxGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory,
      EAttribute... attributes) {
    super(parent, widgetFactory);
    this.semanticFields = new ArrayList<Button>(attributes.length);
    for (EAttribute att : attributes) {
      semanticFields.add(createButton(att, CybersecurityEditPlugin.INSTANCE
          .getString("_UI_" + att.getEContainingClass().getName() + "_" + att.getName() + "_feature"), parent)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
  }

  @Override
  public List<Button> getSemanticFields() {
    return semanticFields;
  }

}
