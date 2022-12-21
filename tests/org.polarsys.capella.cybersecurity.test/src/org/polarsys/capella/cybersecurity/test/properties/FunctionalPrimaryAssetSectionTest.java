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

import org.polarsys.capella.cybersecurity.ui.properties.sections.FunctionalPrimaryAssetSection;

public class FunctionalPrimaryAssetSectionTest extends AbstractCybersecuritySectionTest {
  @Override
  public void test() throws Exception {
    super.init();
    doTest(PA__FPA_3_ID, new FunctionalPrimaryAssetSection(), 2);
    doTestNotSelect(PA__EPA_2_ID, new FunctionalPrimaryAssetSection());
    doTestNotSelect(PA__IPA_4_ID, new FunctionalPrimaryAssetSection());
  }
}
