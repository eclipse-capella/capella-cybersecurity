/*******************************************************************
* Copyright � 2021 Thales Global Services SAS
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
  public static final String QUERY = "EnterprisePrimaryAsset__PrimaryAssets";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(PA__EPA2_ID, PA__FPA3_ID, PA__IPA4_ID);
  }

}