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
    registerUpdatedReference(CybersecurityPackage.Literals.THREAT__OWNED_THREAT_APPLICATIONS);
    registerUpdatedReference(CybersecurityPackage.Literals.THREAT__OWNED_THREAT_INVOLVEMENTS);
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
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.THREAT__OWNED_THREAT_APPLICATIONS));
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.THREAT__OWNED_THREAT_INVOLVEMENTS));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void attachRelated(EObject element, EObject result, IContext context) {
    super.attachRelated(element, result, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result, CybersecurityPackage.Literals.THREAT__KIND, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result, CybersecurityPackage.Literals.THREAT__ADDRESSED_BY, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.THREAT__OWNED_THREAT_APPLICATIONS, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.THREAT__OWNED_THREAT_INVOLVEMENTS, context);
  }
  
  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    
    Threat element = (Threat) source;
    result.addAll(element.getOwnedThreatApplications());
    result.addAll(element.getOwnedThreatInvolvements());
    if (element.getKind() != null) {
      result.add(element.getKind().eContainer().eContainer());
    }
    if (ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE, element, context)) {
      result.addAll(element.getAddressedBy());
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE, element.getAddressedBy(), context);
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE,
          element.getOwnedThreatApplications(), context);
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE,
          element.getOwnedThreatInvolvements(), context);
    }
  }
}
