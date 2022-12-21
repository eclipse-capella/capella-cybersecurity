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
package org.polarsys.capella.cybersecurity.ui.properties.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.kitalpha.emde.model.EmdePackage;

public class ActorUseController extends AbstractMultipleSemanticFieldController {

  /**
   * {@inheritDoc}
   */
  @Override
  protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
    return BusinessQueriesProvider.getInstance().getContribution(CsPackage.Literals.COMPONENT,
        EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<EObject> loadValues(EObject semanticElement, EStructuralFeature semanticFeature) {
    List<EObject> values = new ArrayList<EObject>();
    Object lst = semanticElement.eGet(semanticFeature);
    if (lst instanceof Collection<?>) {
      for (Object obj : (Collection<?>) lst) {
        if (obj instanceof ThreatSourceUse && ((ThreatSourceUse) obj).getUsed() != null) {
          values.add(((ThreatSourceUse) obj).getUsed());
        }
      }
    }

    return values;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  @Override
  protected void doAddOperationInWriteOpenValues(EObject semanticElement, EStructuralFeature semanticFeature, EObject object) {
    ThreatSourceUse tsu = CybersecurityFactory.eINSTANCE.createThreatSourceUse();
    tsu.setUsed((Component)object);
    ((List<EObject>)semanticElement.eGet(semanticFeature)).add(tsu);
  }

  /**
   * Do the remove operation in {@link #writeOpenValues(EObject, EStructuralFeature, List)}
   * @param semanticElement
   * @param semanticFeature
   * @param object
   */
  @SuppressWarnings("unchecked")
  @Override
  protected void doRemoveOperationInWriteOpenValues(EObject semanticElement, EStructuralFeature semanticFeature, EObject object) {
    EObject tsuToRemove = null;
    for (EObject obj : (List<EObject>) semanticElement.eGet(semanticFeature)) {
      if ((obj instanceof ThreatSourceUse) && ((ThreatSourceUse) obj).getUsed().equals(object)) {
        tsuToRemove = obj;
      }
    }
    if (tsuToRemove != null) {
      AbstractSemanticField.deleteContainmentValue(tsuToRemove);
    }
  }

}
