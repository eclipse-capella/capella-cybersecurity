/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

public abstract class CybersecuritySection extends AbstractSection {

  protected CyberMultipleSemanticField widget;
  protected boolean showRealizations;
  
  public CybersecuritySection() {
    this(true);
  }
  
  public CybersecuritySection(boolean showRealizations) {
    this.showRealizations = showRealizations;
  }

  protected void addRealizedWidget(String label) {
    if (showRealizations) {
      widget = new CyberMultipleSemanticField(getReferencesGroup(), ICommonConstants.EMPTY_STRING,
          getWidgetFactory(), getController());
      widget.setLabel(label);
      widget.setDisplayedInWizard(isDisplayedInWizard());
    }
  }
  
  protected void addUsedWidget(String label) {
    widget = new CyberMultipleSemanticField(getReferencesGroup(), ICommonConstants.EMPTY_STRING, getWidgetFactory(),
        getController()) {
      @Override
      protected void removeAllDataValue(EObject object, EStructuralFeature feature) {
        AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
          @Override
          public void run() {
            List<EObject> containmentList = new ArrayList<>((List<EObject>) object.eGet(feature));
            for (EObject containedObject : containmentList) {
              if (containedObject instanceof ThreatSourceUse) {
                deleteContainmentValue(containedObject);
              }
            }
          }
        };
        executeCommand(command);
      }
    };
    widget.setLabel(label);
    widget.setDisplayedInWizard(isDisplayedInWizard());
  }
  
  protected abstract AbstractMultipleSemanticFieldController getController();

  public void loadRealizedWidget(EObject capellaElement, EReference feature) {
    if(showRealizations) {
      widget.loadData(capellaElement, feature);
    }
  }

  public void addRealizedFields(List<AbstractSemanticField> fields) {
    if(showRealizations) {
      fields.add(widget);
    }
  }
  
  protected boolean isRealizedArchitecture(EObject capellaElement) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture(capellaElement);
    Type aType = BlockArchitectureExt.getBlockArchitectureType(architecture);
    return aType != Type.OA && aType != Type.EPBS;
  }
}
