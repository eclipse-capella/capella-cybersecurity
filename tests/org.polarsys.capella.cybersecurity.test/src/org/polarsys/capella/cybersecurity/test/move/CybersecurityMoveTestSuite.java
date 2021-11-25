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
package org.polarsys.capella.cybersecurity.test.move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;

import junit.framework.Test;

public class CybersecurityMoveTestSuite extends BasicTestSuite {

  public static Test suite() {
    return new CybersecurityMoveTestSuite();
  }

  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> tests = new ArrayList<BasicTestArtefact>();
    tests.add(new CybersecurityDnDTest());
    tests.add(new CybersecurityCopyPasteTest());
    tests.add(new CybersecurityConfigurationMoveTest());
   
    return tests;
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

}
