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

public class FunctionalChainComputedFPAsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_ID = "b20c896d-bfbe-4ef8-96fd-599046a3fe4c";
  public static final String TARGET_ID = "99711cee-9093-48fb-910b-f7b16eacb9b7";
  public static final String QUERY = "FunctionalExchange__ComputedFunctionalPrimaryAssets";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(SOURCE_ID, TARGET_ID);
  }

}