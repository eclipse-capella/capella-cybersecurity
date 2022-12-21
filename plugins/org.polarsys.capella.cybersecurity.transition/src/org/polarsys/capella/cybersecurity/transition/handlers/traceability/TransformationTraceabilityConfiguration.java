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
