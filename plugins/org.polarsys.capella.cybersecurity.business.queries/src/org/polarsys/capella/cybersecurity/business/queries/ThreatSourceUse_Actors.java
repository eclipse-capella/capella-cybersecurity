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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.kitalpha.emde.model.EmdePackage;

public class ThreatSourceUse_Actors extends BlockArchitecturePredicateQuery {

  public ThreatSourceUse_Actors() {
    super(EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS, obj -> Component.class.isInstance(obj),
        CsPackage.Literals.COMPONENT);
  }

  @Override
  public List<EObject> getAvailableElements(EObject threatSource) {
    List<EObject> elements = super.getAvailableElements(threatSource);
    List<EObject> usedElements = new ArrayList<>();
    Object lst = threatSource.eGet(EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS);
    if (lst instanceof Collection<?>) {
      for (Object obj : (Collection<?>) lst) {
        if (obj instanceof ThreatSourceUse) {
          EObject usedActor = ((ThreatSourceUse) obj).getUsed();
          usedElements.add(usedActor);
        }
      }
    }
    elements.removeAll(usedElements);
    return elements
        .stream().filter(usedActor -> satisfyGeneralCondition(threatSource, usedActor) && !usedActor.equals(threatSource))
        .collect(Collectors.toList());
  }
  
  public List<EObject> getAllComponents(EObject component) {
    return super.getAvailableElements(component);
  }

  private boolean satisfyGeneralCondition(EObject threatSource, EObject usedActor) {
    if (!(BlockArchitectureExt.getRootBlockArchitecture(threatSource) instanceof OperationalAnalysis)) {
      Component cUsedActor = (Component) usedActor;
      return cUsedActor.isActor();
    }
    return true;
  }

  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> usedElements = new ArrayList<>();
    Object lst = element.eGet(EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS);
    if (lst instanceof Collection<?>) {
      for (Object obj : (Collection<?>) lst) {
        if (obj instanceof ThreatSourceUse && ((ThreatSourceUse) obj).getUsed() != null) {
          usedElements.add(((ThreatSourceUse) obj).getUsed());
        }
      }
    }
    return usedElements;
  }

}
