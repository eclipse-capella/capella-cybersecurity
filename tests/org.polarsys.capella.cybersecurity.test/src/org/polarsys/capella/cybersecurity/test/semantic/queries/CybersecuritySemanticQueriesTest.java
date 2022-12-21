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

import java.util.Collections;
import java.util.List;

import org.polarsys.capella.test.semantic.queries.ju.AbstractSemanticQueryTestCase;

public abstract class CybersecuritySemanticQueriesTest extends AbstractSemanticQueryTestCase {
  public static final String OA__OP1_THREAT_ID = "23ea602e-1db3-4ebb-927b-c13d81f38bab";
  public static final String OA__THREAT1_ID = "58b25370-b7df-4019-b38b-7d64ad157fb3";
  public static final String OA__SCENARIO1_THREAT_ID = "cfdf6031-4680-451d-803f-a67cf64d739b";
  
  public static final String PA__EPA2_ID = "96b6740e-1c54-452d-87c1-96e28813c320";
  public static final String PA__FPA3_ID = "6d555daa-e081-4e69-868a-23fa1562c7fb";
  public static final String PA__IPA4_ID = "52e144a0-ae77-4e6b-bbbb-ea85ae0dd72b";
  public static final String PA__FC1_THREAT_ID = "adab8932-d73c-49c5-b59c-96073942c0b6";
  public static final String PA__THREAT1_ID = "cb4843d5-6bab-408e-8025-1ca31fc5b050";
  public static final String PA__SCENARIO1_THREAT_ID = "61dfb0d3-82c7-4132-a878-778d07a52c3a";

  @Override
  public List<String> getRequiredTestModels() {
    return Collections.singletonList("CybersecurityModel");
  }

}