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
