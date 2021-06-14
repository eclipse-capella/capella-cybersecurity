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
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;

import junit.framework.Test;

public class CyberActivityExplorerTestSuite extends BasicTestSuite {

  public static Test suite() {
    return new CyberActivityExplorerTestSuite();
  }

  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> tests = new ArrayList<BasicTestArtefact>();
    tests.add(new CyberLABActivityExplorerTestCase());
    tests.add(new CyberSABActivityExplorerTestCase());
    tests.add(new CyberPABActivityExplorerTestCase());
    tests.add(new LogicalTDBActivityExplorerTestCase());
    tests.add(new SystemTDBActivityExplorerTestCase());
    tests.add(new PhysicalTDBActivityExplorerTestCase());
    return tests;
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }

}
