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
package org.polarsys.capella.cybersecurity.test.semantic.queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;

import junit.framework.Test;

public class CybersecuritySemanticQueriesTestSuite extends BasicTestSuite {

  public static Test suite() {
    return new CybersecuritySemanticQueriesTestSuite();
  }

  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> tests = new ArrayList<BasicTestArtefact>();
    tests.add(new RealizedFunctionalPrimaryAssetsTestCase());
    tests.add(new RealizingFunctionalPrimaryAssetsTestCase());
    tests.add(new RealizedInformationPrimaryAssetsTestCase());
    tests.add(new RealizingInformationPrimaryAssetsTestCase());
    tests.add(new RealizedThreatsTestCase());
    tests.add(new RealizingThreatsTestCase());
    tests.add(new IncomingTracesSecurityNeedsTestCase());
    tests.add(new OutgoingTracesSecurityNeedsTestCase());
    return tests;
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

}
