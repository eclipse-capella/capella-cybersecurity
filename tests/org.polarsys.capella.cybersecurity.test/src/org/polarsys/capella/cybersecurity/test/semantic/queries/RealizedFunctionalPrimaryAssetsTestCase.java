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

public class RealizedFunctionalPrimaryAssetsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_ID = "c9e3c8d2-5c36-4832-81bd-b836dea7e63b";
  public static final String TARGET_ID = "55ee6393-fc70-4135-9a5e-6ca8764d5114";
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
