/*******************************************************************

Copyright © 2021 Thales Global Services SAS

Licensed under the Thales Inner Source Software License:
Version 1.2, InnerOpen - Distribution Controlled

You may not use this file except in compliance with the License.
You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses

See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.properties;

import org.polarsys.capella.cybersecurity.ui.properties.sections.PrimaryAssetInverseMember.AbstractFunctionSection;

public class FunctionPropertiesPrimaryAssetsTest extends AbstractPrimaryAssetInverseMemberSectionTest {
  private static final String OA__OA_1_ID = "01654fc4-26d9-4b09-834a-0f475ea2b31d";
  private static final String OA__FPA_1_ID = "55ee6393-fc70-4135-9a5e-6ca8764d5114";
  
  private static final String PA__FPA_1_ID = "99711cee-9093-48fb-910b-f7b16eacb9b7";
  private static final String PA__FPA_3_ID = "6d555daa-e081-4e69-868a-23fa1562c7fb";
  private static final String PA__FUNCTION_ID = "3018ccfb-9cfd-4d36-bffe-bc67b422e78a";

  @Override
  public void test() throws Exception {
    super.init();
    doTest(OA__OA_1_ID, new String[] {OA__FPA_1_ID}, new AbstractFunctionSection());
    doTest(PA__FUNCTION_ID, new String[] {PA__FPA_1_ID, PA__FPA_3_ID}, new AbstractFunctionSection());
  }
}
