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

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.cybersecurity.ui.activity.PerformAutomatedTransitionAdapter;

public abstract class CyberTransitionsActivityExplorerTestCase extends ActivityExplorerTestCase {
  public final static String OA__CYBERSECURITY_PKG = "03109427-3bc2-4200-a0b0-a41df66aedb4";
  public final static String SA__CYBERSECURITY_PKG = "0e41208e-3e2c-4131-ab97-2b1673d6b2b0";
  public final static String LA__CYBERSECURITY_PKG = "46c4c194-2d0b-4d23-b112-2cff1abc0a77";

  @Override
  protected ModelElement getTestModelElement() {
    return ((PerformAutomatedTransitionAdapter) link).getModelElement(project);
  }
  
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CybersecurityModel");
  }

  @Override
  protected void doTest() {
    ((PerformAutomatedTransitionAdapter) link).linkPressed(null, project, session);
  }
}
