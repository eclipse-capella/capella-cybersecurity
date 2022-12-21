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
