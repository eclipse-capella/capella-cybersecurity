package org.polarsys.capella.cybersecurity.test.activityExplorer;

import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.cybersecurity.ui.activity.CyberOANewActivityScenarioAdapter;

public class CyberOASActivityExplorerTestCase extends CyberOAScenarioActivityExplorerTestCase {

  @Override
  protected AbstractCapellaNewDiagramHyperlinkAdapter createLink() {
    return new CyberOANewActivityScenarioAdapter() {
      @Override
      protected boolean useDefaultName() {
        return true;
      }
    };
  }

  @Override
  protected String getDefaultName() {
    return "[OAS] Threat 1 OA";
  }

}
