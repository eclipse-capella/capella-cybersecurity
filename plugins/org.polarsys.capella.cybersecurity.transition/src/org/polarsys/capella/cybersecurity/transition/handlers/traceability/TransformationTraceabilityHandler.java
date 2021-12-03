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
