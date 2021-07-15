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
