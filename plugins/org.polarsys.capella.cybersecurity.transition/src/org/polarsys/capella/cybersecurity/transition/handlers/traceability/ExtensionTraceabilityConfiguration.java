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
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.transition.common.handlers.traceability.ITraceabilityHandler;
import org.polarsys.capella.core.transition.common.handlers.traceability.config.TraceabilityConfiguration;
import org.polarsys.capella.core.transition.system.handlers.traceability.ReconciliationTraceabilityHandler;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 * 
 */
public class ExtensionTraceabilityConfiguration extends TraceabilityConfiguration {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void initHandlers(IContext fContext) {
    super.initHandlers(fContext);
    addHandler(fContext, new ExtensionTraceabilityHandler());
    addHandler(fContext, new TopDownReconciliationTraceabilityHandler(getIdentifier(fContext)));
  }

  protected class TopDownReconciliationTraceabilityHandler extends ReconciliationTraceabilityHandler {

    public TopDownReconciliationTraceabilityHandler(String identifier) {
      super(identifier);
    }

    @Override
    protected void initializeBlockArchitecture(BlockArchitecture source, BlockArchitecture target, IContext context,
        LevelMappingTraceability map) {
      super.initializeBlockArchitecture(source, target, context, map);
      addMapping(map, new CybersecurityServices().getDefaultCyberSecurityPackage(source, false),
          new CybersecurityServices().getDefaultCyberSecurityPackage(target, false), context);
    }
  }

  @Override
  public boolean useHandlerForAttachment(EObject source, EObject target, ITraceabilityHandler handler,
      IContext context) {
    return false;
  }

  @Override
  public boolean useHandlerForSourceElements(EObject source, ITraceabilityHandler handler, IContext context) {
    if (source instanceof Threat) {
      return handler instanceof ExtensionTraceabilityHandler;

    } else if (source instanceof CybersecurityPkg && source.eContainer() instanceof BlockArchitecture) {
      return handler instanceof TopDownReconciliationTraceabilityHandler;
    }
    return super.useHandlerForSourceElements(source, handler, context);
  }

  @Override
  public boolean useHandlerForTracedElements(EObject source, ITraceabilityHandler handler, IContext context) {
    if (source instanceof Threat) {
      return handler instanceof ExtensionTraceabilityHandler;

    } else if (source instanceof CybersecurityPkg && source.eContainer() instanceof BlockArchitecture) {
      return handler instanceof TopDownReconciliationTraceabilityHandler;
    }
    return super.useHandlerForTracedElements(source, handler, context);
  }

}
