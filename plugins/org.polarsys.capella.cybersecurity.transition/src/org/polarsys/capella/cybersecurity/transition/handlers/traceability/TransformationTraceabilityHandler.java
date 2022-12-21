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
package org.polarsys.capella.cybersecurity.transition.handlers.traceability;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.interaction.AbstractCapabilityRealization;
import org.polarsys.capella.core.data.interaction.InteractionFactory;
import org.polarsys.capella.core.transition.common.handlers.traceability.LinkTraceabilityHandler;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 * 
 */
public class TransformationTraceabilityHandler extends LinkTraceabilityHandler {
  public TransformationTraceabilityHandler(String identifier) {
    super(identifier);
  }

  @Override
  public void attachTraceability(EObject sourceElement, EObject targetElement, IContext context) {
    if ((sourceElement instanceof Threat) && (targetElement instanceof Threat)) {
      // 1- Get the source and target as Capella elements
      Threat source = (Threat) sourceElement;
      Threat target = (Threat) targetElement;

      AbstractCapabilityRealization link = InteractionFactory.eINSTANCE.createAbstractCapabilityRealization();
      link.setTargetElement(source);
      link.setSourceElement(target);
      target.getOwnedAbstractCapabilityRealizations().add(link);
      addMappings(sourceElement, targetElement, context);
    }
  }

}
