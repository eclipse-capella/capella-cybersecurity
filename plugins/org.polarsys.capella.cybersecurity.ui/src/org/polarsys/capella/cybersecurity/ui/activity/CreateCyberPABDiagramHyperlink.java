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
package org.polarsys.capella.cybersecurity.ui.activity;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;

public class CreateCyberPABDiagramHyperlink extends AbstractCapellaNewDiagramHyperlinkAdapter {

  @Override
  public String getRepresentationName() {
    return IDiagramNameConstants.PHYSICAL_ARCHITECTURE_BLANK_DIAGRAM_NAME;
  }

  @Override
  protected ModelElement getModelElement(EObject rootSemanticModel) {
    return ModelQueryHelper.getPhysicalSystem((Project) rootSemanticModel);
  }

// pending https://git.eclipse.org/r/#/c/145284/
//  @Override
//  protected Collection<String> getExtraLayerNames() {
//    return Arrays.asList(CybersecurityAnalysisConstants.LAYER_ASSETS, CybersecurityAnalysisConstants.LAYER_DECORATION, CybersecurityAnalysisConstants.LAYER_TRUST_BOUNDARIES);
//  }
//
//  @Override
//  protected Collection<String> getExtraFilterNames() {
//    return Collections.singleton(IFilterNameConstants.FILTER_PAB_COLLAPSE_FUNCTION_PORTS);
//  }

}
