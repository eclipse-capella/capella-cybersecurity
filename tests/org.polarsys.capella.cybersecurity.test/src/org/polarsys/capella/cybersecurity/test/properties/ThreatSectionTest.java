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
package org.polarsys.capella.cybersecurity.test.properties;

import org.polarsys.capella.cybersecurity.ui.properties.sections.ThreatSection;

public class ThreatSectionTest extends AbstractCybersecuritySectionTest {
  @Override
  public void test() throws Exception {
    super.init();
    doTest(PA__THREAT_1_ID, new ThreatSection(), 4);
    doTestNotSelect(PA__FPA_3_ID, new ThreatSection());
    doTestNotSelect(PA__IPA_4_ID, new ThreatSection());
  }
}
