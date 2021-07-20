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

public class IncomingTracesSecurityNeedsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_ID = "306ad44f-c93e-4c2b-9dfa-8a7238db8536";
  public static final String TARGET_ID = "dc6b4ac1-5b53-45a6-ab03-9b35eefd67bb";
  public static final String QUERY = "org.polarsys.capella.core.semantic.queries.basic.queries.TraceableElementIncomingTrace01";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(SOURCE_ID, TARGET_ID);
  }

}
