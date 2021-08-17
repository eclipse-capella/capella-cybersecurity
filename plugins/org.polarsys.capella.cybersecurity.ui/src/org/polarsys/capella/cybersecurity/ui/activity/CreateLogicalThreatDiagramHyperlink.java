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
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;

public class CreateLogicalThreatDiagramHyperlink extends AbstractCapellaNewDiagramHyperlinkAdapter {

  @Override
  public String getRepresentationName() {
    return CybersecurityAnalysisConstants.DIAGRAM_THREAT;
  }

  @Override
  public ModelElement getModelElement(EObject rootSemanticModel) {
    return ModelQueryHelper.getLogicalComponentPkg((Project) rootSemanticModel);
  }

}