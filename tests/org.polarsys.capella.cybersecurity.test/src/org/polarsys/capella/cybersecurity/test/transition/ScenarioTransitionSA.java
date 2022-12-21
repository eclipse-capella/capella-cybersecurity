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

import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;

public class ScenarioTransitionSA extends ScenarioTransitionTest {

  @Override
  protected CybersecurityPkg getCurrentPackage() {
    return saPkg;
  }

  @Override
  protected CybersecurityPkg getNextPkg() {
    return laPkg;
  }

}
