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

public class RealizingThreatsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_ID = "100b227c-6b62-4875-aded-7eeaddf8cba9";
  public static final String TARGET_ID = "76bda8ac-2831-42a4-90c4-bb52745d8380";
  public static final String QUERY = "org.polarsys.capella.cybersecurity.ui.semantic.browser.TraceableElementThreatRealizing";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(SOURCE_ID, TARGET_ID);
  }

}
