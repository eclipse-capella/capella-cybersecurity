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
package org.polarsys.capella.cybersecurity.test.semantic.queries;

public class EnterprisePrimaryAssetsPAsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_EPA_ID = "96b6740e-1c54-452d-87c1-96e28813c320";
  public static final String TARGET_FPA_ID = "6d555daa-e081-4e69-868a-23fa1562c7fb";
  public static final String TARGET_IPA_ID = "52e144a0-ae77-4e6b-bbbb-ea85ae0dd72b";
  public static final String QUERY = "EnterprisePrimaryAsset__PrimaryAssets";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(SOURCE_EPA_ID, TARGET_FPA_ID, TARGET_IPA_ID);
  }

}