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
