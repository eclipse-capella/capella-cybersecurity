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

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.cybersecurity.ui.activity.PerformAutomatedTransitionAdapter;

public abstract class CyberTransitionsActivityExplorerTestCase extends ActivityExplorerTestCase {
  public final static String OA__CYBERSECURITY_PKG = "03109427-3bc2-4200-a0b0-a41df66aedb4";
  public final static String SA__CYBERSECURITY_PKG = "0e41208e-3e2c-4131-ab97-2b1673d6b2b0";
  public final static String LA__CYBERSECURITY_PKG = "46c4c194-2d0b-4d23-b112-2cff1abc0a77";

  @Override
  protected ModelElement getTestModelElement() {
    return ((PerformAutomatedTransitionAdapter) link).getModelElement(project);
  }
  
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

  @Override
  protected void doTest() {
    ((PerformAutomatedTransitionAdapter) link).linkPressed(null, project, session);
  }
}
