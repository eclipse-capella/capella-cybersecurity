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

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.cybersecurity.ui.activity.CreateCyberOABDiagramHyperlink;

public class CyberOABActivityExplorerTestCase extends CyberDiagramActivityExplorerTestCase {

  @Override
  protected AbstractCapellaNewDiagramHyperlinkAdapter createLink() {
    return new CreateCyberOABDiagramHyperlink() {
      @Override
      protected boolean useDefaultName() {
        return true;
      }

    };
  }

  @Override
  protected EObject getStructure() {
    return context.getSemanticElement(OA__ENTITIES_PKG);
  }

  @Override
  protected String getDefaultName() {
    return "[OAB] Operational Entities";
  }

  @Override
  protected ModelElement getTestModelElement() {
    return (ModelElement) ((CreateCyberOABDiagramHyperlink) link).getModelElement(project);
  }

}
