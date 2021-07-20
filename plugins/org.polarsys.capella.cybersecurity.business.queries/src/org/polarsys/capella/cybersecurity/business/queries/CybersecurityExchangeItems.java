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
package org.polarsys.capella.cybersecurity.business.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;

public class CybersecurityExchangeItems extends BlockArchitecturePredicateQuery {

  public CybersecurityExchangeItems(EReference theFeature, Predicate<EObject> adder, EClass extensionClass) {
    super(theFeature, adder, extensionClass);
  }
  
  @Override
  public List<EObject> getAvailableElements(EObject element) {
    List<EObject> availableElements = new ArrayList<EObject>();
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
    List<BlockArchitecture> rootAndPreviousBlockArchitectures = BlockArchitectureExt.getRootAndPreviousBlockArchitectures(element);
    for (BlockArchitecture blockArchitecture : rootAndPreviousBlockArchitectures) {
      availableElements.addAll(super.getAvailableElementsOnArchitecture(blockArchitecture, domain));
    }
    return availableElements;
  }
}
