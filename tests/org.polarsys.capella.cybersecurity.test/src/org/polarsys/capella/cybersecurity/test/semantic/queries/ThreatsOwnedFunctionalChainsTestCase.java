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

public class ThreatsOwnedFunctionalChainsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String QUERY = "org.polarsys.capella.cybersecurity.ui.semantic.browser.Threat__OwnedFunctionalChains";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(PA__THREAT1_ID, PA__FC1_THREAT_ID);
  }

}
