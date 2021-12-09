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
package org.polarsys.capella.cybersecurity.ui.semantic.browser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.kitalpha.emde.model.EmdePackage;

public class ActorsUsed implements IQuery {

  @Override
  public List<Object> compute(Object element) {
    List<Object> usedElements = new ArrayList<>();
    Object lst = ((EObject)element).eGet(EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS);
    if (lst instanceof Collection<?>) {
      for (Object obj : (Collection<?>) lst) {
        if (obj instanceof ThreatSourceUse) {
          usedElements.add(((ThreatSourceUse) obj).getUsedActor());
        }
      }
    }
    return usedElements;
  }
}
