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
package org.polarsys.capella.cybersecurity.ui.activity;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractNewScenarioDiagramAdapter;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;

public abstract class CyberSANewScenarioAdapter extends AbstractNewScenarioDiagramAdapter {

  @Override
  protected ModelElement getModelElement(EObject rootSemanticModel) {
    SystemAnalysis systemAnalysis = ModelQueryHelper.getSystemAnalysis((Project) rootSemanticModel);
    return ScenarioCreationHelper.selectCapability((Project) rootSemanticModel, systemAnalysis);
  }
}
