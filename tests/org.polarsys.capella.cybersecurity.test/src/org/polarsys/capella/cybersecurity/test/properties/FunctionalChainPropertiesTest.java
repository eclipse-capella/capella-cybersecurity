/*******************************************************************

Copyright © 2021 Thales Global Services SAS


Licensed under the Thales Inner Source Software License:
Version 1.2, InnerOpen - Distribution Controlled


You may not use this file except in compliance with the License.
You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses

See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.properties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.libraries.IModel;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.properties.sections.PrimaryAssetInverseMember.FunctionalChainSection;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.helpers.EObjectHelper;

public class FunctionalChainPropertiesTest extends BasicTestCase {
  private static final String FUNCTIONAL_CHAIN_ID = "4fe91596-f414-481d-a0ce-60c12dd582ed";
  private static final String[] FC_PRIMARY_ASSETS_IDS = new String[] { "c9e3c8d2-5c36-4832-81bd-b836dea7e63b", "37e60d49-7838-435f-8b59-7c3c2b35fa6c" };
  private static final String OPERATIONAL_PROCESS_ID = "12a75ec7-3dc9-40a2-b930-93bb5bee2b37";
  private static final String[] OP_PRIMARY_ASSETS_IDS = new String[] { "55ee6393-fc70-4135-9a5e-6ca8764d5114" };

  @Override
  public List<String> getRequiredTestModels() {
    return Collections.singletonList("CybersecurityModel");
  }

  @Override
  public void test() throws Exception {
    FunctionalChainSection fcSection = new FunctionalChainSection();
    IModel model = getTestModel(getRequiredTestModels().iterator().next());
    doTest(FUNCTIONAL_CHAIN_ID, FC_PRIMARY_ASSETS_IDS, fcSection, model);
    doTest(OPERATIONAL_PROCESS_ID, OP_PRIMARY_ASSETS_IDS, fcSection, model);

  }

  public void doTest(String idObject, String[] primaryAssetsIds, FunctionalChainSection fcSection, IModel model) {
    FunctionalChain fc = (FunctionalChain) EObjectHelper.getObject(model, idObject);
    assertEquals(getExpectedPAIds(primaryAssetsIds), getAvailablePAIds(fcSection, fc));
  }

  public Set<String> getExpectedPAIds(String[] primaryAssetsIds) {
    return Arrays.asList(primaryAssetsIds).stream().collect(Collectors.toSet());
  }

  public Set<String> getAvailablePAIds(FunctionalChainSection fcSection, FunctionalChain functionalChainTest) {
    List<EObject> availableElements = fcSection.getAvailableElements(functionalChainTest);
    return availableElements.stream().map(element -> ((PrimaryAsset) element).getId()).collect(Collectors.toSet());
  }

}
