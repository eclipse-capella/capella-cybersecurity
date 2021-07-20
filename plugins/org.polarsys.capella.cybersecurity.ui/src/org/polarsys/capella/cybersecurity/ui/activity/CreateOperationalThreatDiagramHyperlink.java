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

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.EntityPkg;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.core.ui.toolkit.helpers.SelectionDialogHelper;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityAnalysisConstants;

public class CreateOperationalThreatDiagramHyperlink extends AbstractCapellaNewDiagramHyperlinkAdapter {

  @Override
  public String getRepresentationName() {
    return CybersecurityAnalysisConstants.DIAGRAM_THREAT;
  }

  @Override
  public ModelElement getModelElement(EObject rootSemanticModel) {
    OperationalAnalysis operationalAnalysis = ModelQueryHelper.getOperationalAnalysis((Project) rootSemanticModel);
    return selectEntity((Project) rootSemanticModel, operationalAnalysis);
  }

  public static Entity selectEntity(final Project project, BlockArchitecture architecture) {
    Entity[] result = new Entity[1];
    EntityPkg entityPkg = (EntityPkg) BlockArchitectureExt.getComponentPkg(architecture);
    if (entityPkg != null) {
      EList<Entity> allEntities = entityPkg.getOwnedEntities();
      if (!allEntities.isEmpty()) {
        Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
        result[0] = (Entity) SelectionDialogHelper
            .simplePropertySelectionDialogWizard(new ArrayList<EObject>(allEntities), shell);
        return result[0];
      }

      // No entities found, let's create a new one

      AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
        @Override
        public void run() {
          result[0] = createEntity(entityPkg);
        }
      };
      TransactionHelper.getExecutionManager(project).execute(cmd);
    }
    return result[0];
  }

  public static Entity createEntity(EntityPkg entityPkg) {
    Entity result = OaFactory.eINSTANCE.createEntity();
    entityPkg.getOwnedEntities().add(result);
    CapellaElementExt.creationService(result);

    return result;
  }

}
