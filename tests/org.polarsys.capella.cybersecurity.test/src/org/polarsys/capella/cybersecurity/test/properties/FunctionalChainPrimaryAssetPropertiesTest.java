/*******************************************************************

Copyright © 2021 Thales Global Services SAS


Licensed under the Thales Inner Source Software License:
Version 1.2, InnerOpen - Distribution Controlled


You may not use this file except in compliance with the License.
You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses

See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.properties;

import org.polarsys.capella.cybersecurity.ui.properties.sections.PrimaryAssetInverseMember.FunctionalChainSection;

public class FunctionalChainPrimaryAssetPropertiesTest extends AbstractPrimaryAssetInverseMemberSectionTest {
  private static final String FUNCTIONAL_CHAIN_ID = "4fe91596-f414-481d-a0ce-60c12dd582ed";
  private static final String[] FC_PRIMARY_ASSETS_IDS = new String[] { "c9e3c8d2-5c36-4832-81bd-b836dea7e63b", "37e60d49-7838-435f-8b59-7c3c2b35fa6c" };
  private static final String OPERATIONAL_PROCESS_ID = "12a75ec7-3dc9-40a2-b930-93bb5bee2b37";
  private static final String[] OP_PRIMARY_ASSETS_IDS = new String[] { "55ee6393-fc70-4135-9a5e-6ca8764d5114" };

  @Override
  public void test() throws Exception {
    super.init();
    doTest(FUNCTIONAL_CHAIN_ID, FC_PRIMARY_ASSETS_IDS, new FunctionalChainSection());
    doTest(OPERATIONAL_PROCESS_ID, OP_PRIMARY_ASSETS_IDS, new FunctionalChainSection());
  }
}
