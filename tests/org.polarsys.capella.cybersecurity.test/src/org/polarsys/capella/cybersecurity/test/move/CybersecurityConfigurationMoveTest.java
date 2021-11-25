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
package org.polarsys.capella.cybersecurity.test.move;

import org.eclipse.emf.ecore.EObject;

public class CybersecurityConfigurationMoveTest extends AbstractCybersecurityMoveTest {
  @Override
  public void test() throws Exception {
    init();
    EObject config = context.getSemanticElement(CYBERSECURITY_CONFIGURATION);
    // cannot copy/paste elements between different Architecture levels
    checkMoveDisabled(config, oaArch, "Cybersecurity Configuration can't be moved");
    checkMoveDisabled(config, project, "Cybersecurity Configuration can't be moved");
    checkMoveDisabled(config, config, "Cybersecurity Configuration can't be moved");
  }
}
