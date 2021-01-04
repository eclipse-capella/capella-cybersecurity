/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.ui.properties.fields;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticKindGroup;

public class IntegerValueRadioGroup extends AbstractSemanticKindGroup {

  private List<Button> buttons;

  /**
   * 
   * @param parent
   * @param label
   * @param widgetFactory
   * @param min
   * @param max
   * @param enabled
   */
  public IntegerValueRadioGroup(Composite parent, String label, TabbedPropertySheetWidgetFactory widgetFactory, int min,
      int max) {
    super(parent, widgetFactory, label, max - min + 1); // $NON-NLS-1$

    buttons = new ArrayList<Button>();

    for (int i = min; i <= max; ++i) {
      Button button = createButton(_group, String.valueOf(i), i, true, SWT.RADIO);
      buttons.add(button);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Button> getSemanticFields() {
    return buttons;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Button getDefaultSemanticField() {
    return buttons.get(0);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void loadData(EObject semanticElement) {
    loadData(semanticElement, semanticFeature);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void loadData(EObject capellaElement, EStructuralFeature feature) {
    super.loadData(capellaElement, feature);

    Object value = semanticElement.eGet(semanticFeature);
    if (value == null) {
      Button defaultBtn = getDefaultSemanticField();
      if (defaultBtn != null) {
        defaultBtn.setSelection(true);
      }
    } else {
      for (Button button : getSemanticFields()) {
        if (button != null) {
          button.setSelection(value == button.getData());
        }
      }
    }
  }
}
