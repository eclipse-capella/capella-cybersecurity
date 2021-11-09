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
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacommon.TransfoLink;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;

public abstract class CybersecurityRealizedElements extends BlockArchitecturePredicateQuery {

  public CybersecurityRealizedElements(EReference theFeature, Predicate<EObject> adder, EClass extensionClass) {
    super(theFeature, adder, extensionClass);
  }
  
  public abstract EClass getExtensionClass();

  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> currentElements = super.getCurrentElements(element, onlyGenerated);
    return getTargetElements(currentElements);
  }

  @Override
  public List<EObject> getAvailableElements(EObject element) {
    List<EObject> currentElements = getCurrentElements(element, false);
    List<EObject> availableElements = getAllAvailableElements(element);
    availableElements.removeAll(currentElements);

    return availableElements;
  }

  protected List<EObject> getTargetElements(List<EObject> list) {
    List<EObject> result = new ArrayList<EObject>();
    for (EObject obj : list) {
      if (obj instanceof TransfoLink) {
        TransfoLink link = (TransfoLink) obj;
        result.add(link.getTarget());
      }
    }
    return result;
  }

  private List<EObject> getAllAvailableElements(EObject element) {
    List<EObject> result = new ArrayList<EObject>();

    if (null != element) {
      BlockArchitecture arch = BlockArchitectureExt.getRootBlockArchitecture(element);
      if (arch != null) {
        for (BlockArchitecture block : arch.getAllocatedArchitectures()) {
          result.addAll(EObjectExt.getAll(block, getExtensionClass()));
        }
      }
    }
    return result;
  }

}
