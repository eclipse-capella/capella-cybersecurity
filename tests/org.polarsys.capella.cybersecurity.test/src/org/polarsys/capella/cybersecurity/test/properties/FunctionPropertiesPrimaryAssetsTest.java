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

import org.polarsys.capella.cybersecurity.ui.properties.sections.PrimaryAssetInverseMember.AbstractFunctionSection;

public class FunctionPropertiesPrimaryAssetsTest extends AbstractPrimaryAssetInverseMemberSectionTest {
  private static final String OA__OA_1_ID = "01654fc4-26d9-4b09-834a-0f475ea2b31d";
  private static final String OA__FPA_1_ID = "55ee6393-fc70-4135-9a5e-6ca8764d5114";
  
  private static final String PA__FPA_1_ID = "99711cee-9093-48fb-910b-f7b16eacb9b7";
  private static final String PA__FPA_3_ID = "6d555daa-e081-4e69-868a-23fa1562c7fb";
  private static final String PA__FUNCTION_ID = "3018ccfb-9cfd-4d36-bffe-bc67b422e78a";

  @Override
  public void test() throws Exception {
    super.init();
    doTest(OA__OA_1_ID, new String[] {OA__FPA_1_ID}, new AbstractFunctionSection());
    doTest(PA__FUNCTION_ID, new String[] {PA__FPA_1_ID, PA__FPA_3_ID}, new AbstractFunctionSection());
  }
}
