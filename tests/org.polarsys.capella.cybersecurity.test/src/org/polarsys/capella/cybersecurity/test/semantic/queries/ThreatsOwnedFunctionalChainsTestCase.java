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
