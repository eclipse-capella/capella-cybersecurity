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
package org.polarsys.capella.cybersecurity.test.properties;

import org.polarsys.capella.cybersecurity.ui.properties.sections.SecurityNeedsSection;

public class SecurityNeedsSectionTest extends AbstractCybersecuritySectionTest {
  @Override
  public void test() throws Exception {
    super.init();
    doTest(PA__EPA_2_ID, new SecurityNeedsSection(), 4);
    doTest(PA__FPA_3_ID, new SecurityNeedsSection(), 4);
    doTest(PA__IPA_4_ID, new SecurityNeedsSection(), 4);
    doTest(PA__THREAT_1_ID, new SecurityNeedsSection(), 4);
    doTest(PA__PHYSICAL_FUNCTION_3_ID, new SecurityNeedsSection(), 4);
    doTest(PA__EXCHANGE_ITEM_1_ID, new SecurityNeedsSection(), 4);
    doTestNotSelect(PA__CYBERSECURITY_PKG_ID, new SecurityNeedsSection());
  }
}
