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
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.transition.common.handlers.traceability.ITraceabilityHandler;
import org.polarsys.capella.core.transition.common.handlers.traceability.config.TraceabilityConfiguration;
import org.polarsys.capella.core.transition.system.handlers.traceability.ReconciliationTraceabilityHandler;
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

  @Override
  public boolean useHandlerForAttachment(EObject source, EObject target, ITraceabilityHandler handler,
      IContext context) {
    return true;
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
}
