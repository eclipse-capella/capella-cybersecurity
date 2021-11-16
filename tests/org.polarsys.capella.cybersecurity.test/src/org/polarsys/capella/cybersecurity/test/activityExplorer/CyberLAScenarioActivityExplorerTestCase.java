/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.cybersecurity.ui.activity.ScenarioCreationHelper;

public abstract class CyberLAScenarioActivityExplorerTestCase extends CyberDiagramActivityExplorerTestCase {

  public static final String THREAT = "76bda8ac-2831-42a4-90c4-bb52745d8380";

  @Override
  protected EObject getStructure() {
    return context.getSemanticElement(THREAT);
  }

  @Override
  protected ModelElement getTestModelElement() {
    LogicalArchitecture logicalArchitecture = ModelQueryHelper.getLogicalArchitecture(project);
    return (ModelElement) ScenarioCreationHelper.getAllAbstractCapabitilies(project, logicalArchitecture).get(0);
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

}
