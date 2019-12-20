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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticKindGroup;
import org.polarsys.capella.cybersecurity.model.ThreatKind;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class ThreatKindGroup extends AbstractSemanticKindGroup {

  private List<Button> fields;

  /**
   * Constructor.
   * 
   * @param parent
   * @param widgetFactory
   */
  public ThreatKindGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
    super(parent, widgetFactory, CybersecurityEditPlugin.INSTANCE.getString("_UI_Threat_threatKind_feature"), 3); //$NON-NLS-1$
    fields = new ArrayList<>();

    for (ThreatKind kind : ThreatKind.values()) {
      fields.add(createButton(kind));
    }
  }

  @Override
  protected Button createButton(Enumerator enumerated, boolean enabled) {
    return createButton(_group,
        CybersecurityEditPlugin.INSTANCE.getString("_UI_ThreatKind_" + enumerated.getLiteral() + "_literal"), enumerated,
        enabled, SWT.RADIO);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Button> getSemanticFields() {
    return fields;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Button getDefaultSemanticField() {
    return fields.iterator().next();
  }

}
