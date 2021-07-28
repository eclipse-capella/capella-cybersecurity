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
package org.polarsys.capella.cybersecurity.ui.contribution.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.ui.properties.TabbedPropertiesLabelProvider;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;

public class CyberTabbedPropertiesLabelProvider extends TabbedPropertiesLabelProvider {

  private static final String OPERATIONAL_ACTIVITY_PRIMARY_ASSET = "(Operational Activity Primary Asset)";

  @Override
  public String getText(Object element) {
    EObject modelElement = getModelElement(element);
    if (modelElement instanceof FunctionalPrimaryAsset
        && BlockArchitectureExt.getRootBlockArchitecture(modelElement) instanceof OperationalAnalysis) {
      String name = ((FunctionalPrimaryAsset) modelElement).getName();
      return OPERATIONAL_ACTIVITY_PRIMARY_ASSET + ICommonConstants.WHITE_SPACE_CHARACTER
          + (name == null ? ICommonConstants.EMPTY_STRING : name);
    }
    return super.getText(element);
  }

  private EObject getModelElement(Object element) {
    if (element instanceof StructuredSelection) {
      StructuredSelection selection = (StructuredSelection) element;
      return CapellaAdapterHelper.resolveDescriptorOrBusinessObject(selection.getFirstElement());
    }
    return null;
  }
}
