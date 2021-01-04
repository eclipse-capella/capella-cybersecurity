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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticKindGroup;

public class EnumerationLiterealValueRadioGroup extends AbstractSemanticKindGroup {

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
  public EnumerationLiterealValueRadioGroup(Composite parent, String label, EnumerationPropertyType type,
      TabbedPropertySheetWidgetFactory widgetFactory, int numCols) {
    super(parent, widgetFactory, label, numCols); // $NON-NLS-1$
    buttons = new ArrayList<Button>();
    if (type != null && !type.getOwnedLiterals().isEmpty()) {
      EList<EnumerationPropertyLiteral> literals = type.getOwnedLiterals();
      for(EnumerationPropertyLiteral literal : literals) {
        Button button = createButton(_group, literal.getName(), literal, true, SWT.RADIO);
        buttons.add(button);
      }
    } else {
      Button button = createButton(_group, "UNDEFINED", null, false, SWT.RADIO);
      buttons.add(button);
    }
  }
  
  @Override
  protected Group createGroup(Composite parent, String label, boolean enabled, int numColumns) {
    super.createGroup(parent, label, enabled, numColumns);
    _group.setLayout(new GridLayout(numColumns, false));
    GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
    gd.horizontalSpan = ((GridLayout) parent.getLayout()).numColumns;
    _group.setLayoutData(gd);
    return _group;
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
    for (Button button : getSemanticFields()) {
      if (button != null) {
        button.setSelection(value != null ? value.equals(button.getData()) : false);
      }
    }
    if (value == null) {
      Button defaultBtn = getDefaultSemanticField();
      if (defaultBtn != null) {
        defaultBtn.setSelection(true);
      }
    }
  }
}
