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

// Generated on 20.05.2019 at 12:52:47 CEST by Viewpoint DSL Generator V 0.1

package org.polarsys.capella.cybersecurity.ui.properties.fields;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticCheckboxGroup;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

/**
 * <!-- begin-user-doc --> The '<em><b>[Toto_semanticCheckboxGroup]</b></em>' customized CheckboxGroup field. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class ThreatSourceGroup extends AbstractSemanticCheckboxGroup {

  private Button isThreatSourceButton;

  /**
   * Constructor. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param parent_p
   * @param widgetFactory_p
   * @generated
   */
  public ThreatSourceGroup(Composite parent_p, TabbedPropertySheetWidgetFactory widgetFactory_p) {
    super(parent_p, widgetFactory_p);
    isThreatSourceButton = createButton(CybersecurityPackage.eINSTANCE.getTrustBoundaryStorage_ThreatSource(),
        Messages.ThreatSourceGroup_0, parent_p);
    Layout parentLayout = parent_p.getLayout();
    if (parentLayout != null && parentLayout instanceof GridLayout) {
      GridData gd = new GridData(GridData.FILL_HORIZONTAL);
      gd.horizontalSpan = ((GridLayout) parentLayout).numColumns;
      isThreatSourceButton.setLayoutData(gd);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> {@inheritDoc}
   * 
   * @generated
   */
  @Override
  public List<Button> getSemanticFields() {
    List<Button> fields = new ArrayList<Button>();
    fields.add(isThreatSourceButton);
    return fields;
  }

}