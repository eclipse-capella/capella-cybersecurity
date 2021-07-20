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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.EntityPkg;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.cybersecurity.test.diagram.ThreatDiagram;
import org.polarsys.capella.cybersecurity.ui.activity.CreateOperationalThreatDiagramHyperlink;

public class OperationalTDBActivityExplorerTestCase extends CyberDiagramActivityExplorerTestCase {

  @Override
  protected AbstractCapellaNewDiagramHyperlinkAdapter createLink() {
    return new CreateOperationalThreatDiagramHyperlink() {
      @Override
      protected boolean useDefaultName() {
        return true;
      }
    };
  }

  @Override
  protected EObject getStructure() {
    EntityPkg pkg = context.getSemanticElement(OA_ENTITIES);
    OperationalAnalysis oa = context.getSemanticElement(OA);
    createThreatDiagram(oa);
    return pkg.getOwnedEntities().get(0);
  }

  @Override
  protected String getDefaultName() {
    return "[TDB] OE 1";
  }

  @Override
  protected ModelElement getTestModelElement() {
    OperationalAnalysis oa = context.getSemanticElement(OA);
    return oa.getOwnedEntityPkg().getOwnedEntities().get(0);
  }

  public ThreatDiagram createThreatDiagram(BlockArchitecture architecture) {
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      private ThreatDiagram diagram;

      /**
       * @see org.polarsys.capella.common.ef.command.AbstractCommand#getAffectedObjects()
       */
      @Override
      public Collection<?> getAffectedObjects() {
        return Collections.singletonList(diagram);
      }

      /**
       * @see java.lang.Runnable#run()
       */
      @Override
      public void run() {
        Entity entity = CreateOperationalThreatDiagramHyperlink.selectEntity(project, architecture);
        if (entity != null) {
          diagram = ThreatDiagram.createDiagram(context, entity.getId());
        }
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);

    return (ThreatDiagram) cmd.getAffectedObjects().iterator().next();
  }

}
