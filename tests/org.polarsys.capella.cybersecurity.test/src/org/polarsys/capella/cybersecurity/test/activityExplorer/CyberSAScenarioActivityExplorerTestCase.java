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
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.cybersecurity.ui.activity.ScenarioCreationHelper;

public abstract class CyberSAScenarioActivityExplorerTestCase extends CyberDiagramActivityExplorerTestCase {

  public static final String THREAT = "100b227c-6b62-4875-aded-7eeaddf8cba9";

  @Override
  protected EObject getStructure() {
    return context.getSemanticElement(THREAT);
  }

  @Override
  protected ModelElement getTestModelElement() {
    SystemAnalysis systemAnalysis = ModelQueryHelper.getSystemAnalysis(project);
    return (ModelElement) ScenarioCreationHelper.getAllAbstractCapabitilies(project, systemAnalysis).get(0);
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

}
