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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;
import org.polarsys.capella.core.sirius.analysis.constants.IFilterNameConstants;

public class CreateCyberSABDiagramHyperlink extends AbstractCapellaNewDiagramHyperlinkAdapter {

  @Override
  public String getRepresentationName() {
    return IDiagramNameConstants.SYSTEM_ARCHITECTURE_BLANK_DIAGRAM_NAME;
  }

  @Override
  public ModelElement getModelElement(EObject rootSemanticModel) {
    return ModelQueryHelper.getSystemComponentPkg((Project) rootSemanticModel);
  }

  @Override
  protected Collection<String> getExtraFilterNames() {
    return Collections.singleton(IFilterNameConstants.FILTER_SAB_COLLAPSE_FUNCTION_PORTS);
  }

}
