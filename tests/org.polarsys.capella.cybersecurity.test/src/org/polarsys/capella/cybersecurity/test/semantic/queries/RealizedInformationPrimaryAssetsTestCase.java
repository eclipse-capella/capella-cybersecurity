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

public class RealizedInformationPrimaryAssetsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_ID = "c7583b9c-276d-4c44-8c54-9e3f928cb98b";
  public static final String TARGET_ID = "9aa70aff-0d62-4717-a9ca-41edebc6badd";
  public static final String QUERY = "org.polarsys.capella.cybersecurity.ui.semantic.browser.TraceableElementPrimaryAssetRealized";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(SOURCE_ID, TARGET_ID);
  }

}
