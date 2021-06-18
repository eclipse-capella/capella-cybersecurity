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
package org.polarsys.capella.cybersecurity.transition.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.common.constants.ITransitionConstants;
import org.polarsys.capella.core.transition.common.handlers.attachment.AttachmentHelper;
import org.polarsys.capella.core.transition.common.handlers.contextscope.ContextScopeHandlerHelper;
import org.polarsys.capella.core.transition.system.rules.AbstractCapellaElementRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;

/**
 *
 */
public class ThreatRule extends AbstractCapellaElementRule {

  public ThreatRule() {
    registerUpdatedReference(CybersecurityPackage.Literals.THREAT__ADDRESSED_BY);
    registerUpdatedReference(CybersecurityPackage.Literals.THREAT__KIND);
    registerUpdatedAttribute(CybersecurityPackage.Literals.THREAT__LEVEL);
    registerUpdatedAttribute(CybersecurityPackage.Literals.THREAT__RATIONALE);
  }
  
  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.THREAT;
  }
  
  @Override
  protected void premicesRelated(EObject element, ArrayList<IPremise> needed) {
    super.premicesRelated(element, needed);
    needed.addAll(createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.THREAT__KIND));
    needed.addAll(createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.THREAT__ADDRESSED_BY));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void attachRelated(EObject element, EObject result, IContext context) {
    super.attachRelated(element, result, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result, CybersecurityPackage.Literals.THREAT__KIND, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result, CybersecurityPackage.Literals.THREAT__ADDRESSED_BY, context);
  }
  
  @Override
  protected void updateElement(EObject element, EObject result, IContext context) {
    super.updateElement(element, result, context);
    if(element instanceof Threat && result instanceof Threat) {
      ((Threat) result).setKind(((Threat) element).getKind());
    }
  }
  
  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    
    Threat element = (Threat) source;
    if (ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE, element, context)) {
      result.addAll(element.getAddressedBy());
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE, element.getAddressedBy(), context);
    }
  }
}
