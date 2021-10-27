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
package org.polarsys.capella.cybersecurity.ui.activity;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractNewScenarioDiagramAdapter;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;

public abstract class CyberPANewScenarioAdapter extends AbstractNewScenarioDiagramAdapter {

  @Override
  protected ModelElement getModelElement(EObject rootSemanticModel) {
    PhysicalArchitecture physicalArchitecture = ModelQueryHelper.getPhysicalArchitecture((Project) rootSemanticModel);
    return ScenarioCreationHelper.selectCapability((Project) rootSemanticModel, physicalArchitecture);
  }
}
