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
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.business.queries.FunctionStorage_ExchangeItems;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;

public class FunctionStorageExchangeItemsTest extends CybersecurityQueriesTest {
  @Override
  protected void doTest() {
    FunctionStorage functionStorage = CybersecurityFactory.eINSTANCE.createFunctionStorage();
    AbstractFunction rootFunctionSA = BlockArchitectureExt.getRootFunction(saArch);
    
    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        rootFunctionSA.getOwnedExtensions().add(functionStorage);
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
    
    List<EObject> elements = new FunctionStorage_ExchangeItems().getAvailableElements(functionStorage);
    assertTrue(elements.contains(eiOA));
    assertTrue(elements.contains(eiSA));
    assertFalse(elements.contains(eiLA));
  }
}
