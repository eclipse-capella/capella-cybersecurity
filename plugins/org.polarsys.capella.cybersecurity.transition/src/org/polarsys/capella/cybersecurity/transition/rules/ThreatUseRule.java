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
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;

/**
 *
 */
public class ThreatUseRule extends AbstractCapellaElementRule {
  
  public ThreatUseRule() {
    registerUpdatedReference(CybersecurityPackage.Literals.THREAT_SOURCE_USE__THREAT_SOURCE);
  }

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.THREAT_SOURCE_USE;
  }
  
  @Override
  protected void premicesRelated(EObject element, ArrayList<IPremise> needed) {
    super.premicesRelated(element, needed);
    needed.addAll(createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.THREAT_SOURCE_USE__USED));
  }
  
  @Override
  protected void attachRelated(EObject element, EObject result, IContext context) {
    super.attachRelated(element, result, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result, CybersecurityPackage.Literals.THREAT_SOURCE_USE__USED, context);
  }
  
  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    ThreatSourceUse element = (ThreatSourceUse) source;
    result.add(element.getThreatSource());
    result.add(element.getUsed());
    ContextScopeHandlerHelper.getInstance(context).add(ITransitionConstants.SOURCE_SCOPE, element.getThreatSource(), context);
    ContextScopeHandlerHelper.getInstance(context).add(ITransitionConstants.SOURCE_SCOPE, element.getUsed(), context);
  }
}
