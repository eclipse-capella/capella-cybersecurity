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
import org.polarsys.capella.cybersecurity.business.queries.InformationPrimaryAsset_ExchangeItems;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

public class InformationPrimaryAssetsExchangeItemsTest extends CybersecurityQueriesTest {
  @Override
  protected void doTest() {
    InformationPrimaryAsset ipa = CybersecurityFactory.eINSTANCE.createInformationPrimaryAsset();
    
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        CybersecurityPkg saPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(saArch, true);
        saPkg.getOwnedPrimaryAssets().add(ipa);
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
    
    List<EObject> elements = new InformationPrimaryAsset_ExchangeItems().getAvailableElements(ipa);
    assertTrue(elements.contains(eiOA));
    assertTrue(elements.contains(eiSA));
    assertFalse(elements.contains(eiLA));
  }
}
