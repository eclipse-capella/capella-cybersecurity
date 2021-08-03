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
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    
    Threat element = (Threat) source;
    if (element.getKind() != null) {
      result.add(element.getKind().eContainer().eContainer());
    }
    if (ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE, element, context)) {
      result.addAll(element.getAddressedBy());
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE, element.getAddressedBy(), context);
    }
  }
}
