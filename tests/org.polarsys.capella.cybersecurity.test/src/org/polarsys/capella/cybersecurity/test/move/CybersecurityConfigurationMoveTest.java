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
package org.polarsys.capella.cybersecurity.test.move;

import org.eclipse.emf.ecore.EObject;

public class CybersecurityConfigurationMoveTest extends AbstractCybersecurityMoveTest {
  @Override
  public void test() throws Exception {
    init();
    EObject config = context.getSemanticElement(CYBERSECURITY_CONFIGURATION);
    // cannot copy/paste elements between different Architecture levels
    checkMoveDisabled(config, oaArch, "Cybersecurity Configuration can't be moved");
    checkMoveDisabled(config, project, "Cybersecurity Configuration can't be moved");
    checkMoveDisabled(config, config, "Cybersecurity Configuration can't be moved");
  }
}
