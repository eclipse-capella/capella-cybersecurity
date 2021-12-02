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
import org.polarsys.capella.core.transition.common.handlers.traceability.ITraceabilityHandler;
import org.polarsys.capella.core.transition.common.handlers.traceability.config.TraceabilityConfiguration;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 */
public class TransformationTraceabilityConfiguration extends TraceabilityConfiguration {

  static String identifier = "cyber_TransformationTraceabilityConfiguration";
  /**
   * {@inheritDoc}
   */
  @Override
  protected void initHandlers(IContext fContext) {
    super.initHandlers(fContext);
    addHandler(fContext, new TransformationTraceabilityHandler(identifier));
  }

  @Override
  public boolean useHandlerForAttachment(EObject source, EObject target, ITraceabilityHandler handler,
      IContext context) {
    if (source instanceof Threat)
      return handler instanceof TransformationTraceabilityHandler;
    return super.useHandlerForAttachment(source, target, handler, context);
  }
  
}
