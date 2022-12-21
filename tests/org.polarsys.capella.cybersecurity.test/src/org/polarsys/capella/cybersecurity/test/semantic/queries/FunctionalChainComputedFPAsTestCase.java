/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
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