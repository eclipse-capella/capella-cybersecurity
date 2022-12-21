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
