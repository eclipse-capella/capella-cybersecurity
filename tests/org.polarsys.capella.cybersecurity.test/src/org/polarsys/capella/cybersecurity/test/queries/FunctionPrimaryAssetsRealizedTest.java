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
package org.polarsys.capella.cybersecurity.test.queries;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.cybersecurity.business.queries.FunctionalPrimaryAsset_RealizedPrimaryAssets;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

public class FunctionPrimaryAssetsRealizedTest extends CybersecurityQueriesTest {
  PrimaryAsset oaPA;
  PrimaryAsset saPA;
  PrimaryAsset oaIPA;

  protected void init() {
    super.init();
    oaPA = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    oaIPA = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    saPA = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        CybersecurityPkg oaPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(oaArch, true);
        oaPkg.getOwnedPrimaryAssets().add(oaPA);
        oaPkg.getOwnedPrimaryAssets().add(oaIPA);
        CybersecurityPkg saPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(saArch, true);
        saPkg.getOwnedPrimaryAssets().add(saPA);
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
  }
  
  @Override
  protected void doTest() {
    List<EObject> elements = new FunctionalPrimaryAsset_RealizedPrimaryAssets().getAvailableElements(saPA);
    assertTrue(elements.contains(oaPA));
    assertTrue(elements.contains(oaIPA));
    assertFalse(elements.contains(saPA));
  }
}
