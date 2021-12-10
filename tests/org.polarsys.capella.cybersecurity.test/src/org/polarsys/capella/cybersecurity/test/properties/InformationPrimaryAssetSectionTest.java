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

import org.polarsys.capella.cybersecurity.ui.properties.sections.InformationPrimaryAssetSection;

public class InformationPrimaryAssetSectionTest extends AbstractCybersecuritySectionTest {
  @Override
  public void test() throws Exception {
    super.init();
    doTest(PA__IPA_4_ID, new InformationPrimaryAssetSection(), 2);
    doTestNotSelect(PA__EPA_2_ID, new InformationPrimaryAssetSection());
    doTestNotSelect(PA__FPA_3_ID, new InformationPrimaryAssetSection());
  }
}
