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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;

public abstract class CybersecuritySection extends AbstractSection {

  private CyberMultipleSemanticField realizedWidget;
  private boolean showRealizations;
  
  public CybersecuritySection() {
    this(true);
  }
  
  public CybersecuritySection(boolean showRealizations) {
    this.showRealizations = showRealizations;
  }

  protected void addRealizedWidget(String label) {
    if (showRealizations) {
      realizedWidget = new CyberMultipleSemanticField(getReferencesGroup(), ICommonConstants.EMPTY_STRING,
          getWidgetFactory(), new CybersecurityRealizationsController());
      realizedWidget.setLabel(label);
      realizedWidget.setDisplayedInWizard(isDisplayedInWizard());
    }
  }

  public void loadRealizedWidget(EObject capellaElement) {
    if(showRealizations) {
      realizedWidget.loadData(capellaElement, ModellingcorePackage.Literals.TRACEABLE_ELEMENT__OUTGOING_TRACES);
    }
  }

  public void addRealizedFields(List<AbstractSemanticField> fields) {
    if(showRealizations) {
      fields.add(realizedWidget);
    }
  }
  
  protected boolean isRealizedArchitecture(EObject capellaElement) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(capellaElement);
    Type aType = BlockArchitectureExt.getBlockArchitectureType(architecture);
    return aType != Type.OA && aType != Type.EPBS;
  }
}
