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

public class RealizingInformationPrimaryAssetsTestCase extends CybersecuritySemanticQueriesTest {

  public static final String SOURCE_ID = "c7583b9c-276d-4c44-8c54-9e3f928cb98b";
  public static final String TARGET_ID = "1b4b4f10-5370-46ac-bda8-c6f0fdc73e68";
  public static final String QUERY = "org.polarsys.capella.cybersecurity.ui.semantic.browser.TraceableElementPrimaryAssetRealizing";

  @Override
  protected String getQueryCategoryIdentifier() {
    return QUERY;
  }

  @Override
  public void test() throws Exception {
    testQuery(SOURCE_ID, TARGET_ID);
  }

}
