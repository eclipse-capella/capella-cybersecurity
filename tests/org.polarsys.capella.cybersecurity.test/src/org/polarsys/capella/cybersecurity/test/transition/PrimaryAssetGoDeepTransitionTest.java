/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
