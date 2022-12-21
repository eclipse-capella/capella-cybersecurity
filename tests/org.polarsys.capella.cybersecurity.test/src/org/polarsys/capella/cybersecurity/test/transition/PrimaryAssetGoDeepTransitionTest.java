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
package org.polarsys.capella.cybersecurity.test.transition;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;

public class PrimaryAssetGoDeepTransitionTest extends CyberTopDownTransitionTestCase {

  private final static String FPA = "55ee6393-fc70-4135-9a5e-6ca8764d5114";
  private final static String INTERACTION = "9a306d6a-5289-487e-bb40-c74fe275e6a0";
  private final static String OPERATIONAL_PROCESS_INVOLVEMENT_LINK = "d499feb3-612f-4fd8-91c2-c07dac0281e0";
  private final static String OPERATIONAL_PROCESS = "a1506e79-a0f4-4d65-a86a-8a8187ea1e76";

  @Override
  protected void doTest() {
    // transit PA and check that the member (Operational Process) is fully transited - with all involvement links
    // because Operational Process involves an interaction, the interaction should be also transited
    performPrimaryAssetTransition(getObjects(FPA));
    AbstractFunction rootSystemFunction = BlockArchitectureExt.getRootFunction(saArch);
    FunctionalChain operationalProcess = (FunctionalChain) mustBeTransitioned(OPERATIONAL_PROCESS, rootSystemFunction);
    mustBeTransitioned(INTERACTION, rootSystemFunction);
    mustBeTransitioned(OPERATIONAL_PROCESS_INVOLVEMENT_LINK, operationalProcess);
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

}
