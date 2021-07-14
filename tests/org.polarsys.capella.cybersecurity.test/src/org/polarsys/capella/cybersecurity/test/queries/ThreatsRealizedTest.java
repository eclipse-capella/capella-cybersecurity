/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.queries;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.cybersecurity.business.queries.Threat_RealizedThreats;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

public class ThreatsRealizedTest extends CybersecurityQueriesTest {
  Threat oaThreat;
  Threat saThreat;

  protected void init() {
    super.init();
    oaThreat = CybersecurityFactory.eINSTANCE.createThreat();
    saThreat = CybersecurityFactory.eINSTANCE.createThreat();
    
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        CybersecurityPkg oaPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(oaArch, true);
        oaPkg.getOwnedThreats().add(oaThreat);
        CybersecurityPkg saPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(saArch, true);
        saPkg.getOwnedThreats().add(saThreat);
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
  }
  
  @Override
  protected void doTest() {
    List<EObject> elements = new Threat_RealizedThreats().getAvailableElements(saThreat);
    assertTrue(elements.contains(oaThreat));
    assertFalse(elements.contains(saThreat));
  }
}
