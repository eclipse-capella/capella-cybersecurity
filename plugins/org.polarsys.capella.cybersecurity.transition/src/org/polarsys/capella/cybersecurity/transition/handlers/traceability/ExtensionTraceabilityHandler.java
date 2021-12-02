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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.common.handlers.session.SessionHandlerHelper;
import org.polarsys.capella.core.transition.common.handlers.traceability.ITraceabilityHandler;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 * 
 */
public class ExtensionTraceabilityHandler implements ITraceabilityHandler {

  /**
   * {@inheritDoc}
   */
  public void attachTraceability(EObject sourceElement, EObject targetElement, IContext context) {
    // Nothing
  }

  /**
   * {@inheritDoc}
   */
  public List<EObject> retrieveTracedElements(EObject source, IContext context) {
    if (source instanceof Threat) {
      return (List) ((Threat) source).getRealizingThreats();
    }
    return Collections.emptyList();
  }

  /**
   * {@inheritDoc}
   */
  public List<EObject> retrieveSourceElements(EObject source, IContext context) {
    if (source instanceof Threat) {
      return (List) ((Threat) source).getRealizedThreats();
    }
    return Collections.emptyList();
  }

  /**
   * {@inheritDoc}
   * 
   * @deprecated
   */
  @Deprecated
  public List<EObject> retrieveTracedElements(EObject source, IContext context, EClass clazz) {
    return Collections.emptyList();
  }

  /**
   * {@inheritDoc}
   * 
   * @deprecated
   */
  @Deprecated
  public boolean isTraced(EObject element, IContext context) {
    return !retrieveTracedElements(element, context).isEmpty();
  }

  /**
   * {@inheritDoc}
   * 
   * @deprecated
   */
  @Deprecated
  public String getId(EObject element, IContext context) {
    return SessionHandlerHelper.getInstance(context).getId(element, context);
  }

  /**
   * {@inheritDoc}
   */
  public IStatus init(IContext context) {
    return Status.OK_STATUS;
  }

  /**
   * {@inheritDoc}
   */
  public IStatus dispose(IContext context) {
    return Status.OK_STATUS;
  }
}
