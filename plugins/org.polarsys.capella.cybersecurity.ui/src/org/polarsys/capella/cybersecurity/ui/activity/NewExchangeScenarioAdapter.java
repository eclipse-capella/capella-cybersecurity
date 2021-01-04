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
package org.polarsys.capella.cybersecurity.ui.activity;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.interaction.ScenarioKind;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.ModelCreationHelper;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;

// FIXME Use adapter from Capella 1.4.1 for Cybersecurity 0.9.2 and delete this class
public class NewExchangeScenarioAdapter extends AbstractCapellaNewDiagramHyperlinkAdapter {

  @Override
  public String getRepresentationName() {
    return IDiagramNameConstants.DATA_FLOW_SCENARIO_DIAGRAM_NAME;
  }
  
  @Override
  protected ModelElement getModelElement(EObject rootSemanticModel) {
    Project project = (Project)rootSemanticModel;
    return ModelCreationHelper.selectCapabilityAndCreateScenario(project, ModelQueryHelper.getPhysicalArchitecture(project), ScenarioKind.DATA_FLOW);
  }
}
