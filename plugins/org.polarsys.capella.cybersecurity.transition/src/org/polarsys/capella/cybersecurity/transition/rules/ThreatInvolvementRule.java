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
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;

/**
 *
 */
public class ThreatInvolvementRule extends AbstractCapellaElementRule {
  
  public ThreatInvolvementRule() {
    registerUpdatedReference(CybersecurityPackage.Literals.THREAT_INVOLVEMENT__COMPONENT);
  }

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.THREAT_INVOLVEMENT;
  }
  
  @Override
  protected void premicesRelated(EObject element, ArrayList<IPremise> needed) {
    super.premicesRelated(element, needed);
    needed
        .addAll(createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.THREAT_INVOLVEMENT__COMPONENT));
  }

  @Override
  protected void attachRelated(EObject element, EObject result, IContext context) {
    super.attachRelated(element, result, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.THREAT_INVOLVEMENT__COMPONENT, context);
  }
  
  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    result.add(((ThreatInvolvement) source).getComponent());
    
    if (ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE, source, context)) {
      ContextScopeHandlerHelper.getInstance(context).add(ITransitionConstants.SOURCE_SCOPE,
          ((ThreatInvolvement) source).getComponent(), context);
    }
  }
}
