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

import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;

public class CyberLANewExchangeScenarioAdapter extends CyberLANewScenarioAdapter {
  @Override
  public String getRepresentationName() {
    return IDiagramNameConstants.DATA_FLOW_SCENARIO_DIAGRAM_NAME;
  }
}
