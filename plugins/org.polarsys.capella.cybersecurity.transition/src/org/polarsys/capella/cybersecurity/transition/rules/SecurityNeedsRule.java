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
import org.polarsys.capella.core.transition.common.handlers.attachment.AttachmentHelper;
import org.polarsys.capella.core.transition.common.rules.AbstractUpdateRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;

public class SecurityNeedsRule extends AbstractUpdateRule {

  public SecurityNeedsRule() {
    registerUpdatedReference(CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE);
    registerUpdatedReference(CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE);
    registerUpdatedReference(CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE);
    registerUpdatedReference(CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE);
  }

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.SECURITY_NEEDS;
  }

  @Override
  public EClass getTargetType(EObject element, IContext context) {
    return CybersecurityPackage.Literals.SECURITY_NEEDS;
  }

  @Override
  protected void premicesRelated(EObject element, ArrayList<IPremise> needed) {
    super.premicesRelated(element, needed);
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE));
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE));
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE));
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void attachRelated(EObject element, EObject result, IContext context) {
    super.attachRelated(element, result, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE, context);
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE, context);
  }

  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);

    SecurityNeeds element = (SecurityNeeds) source;
    if (element.getConfidentialityValue() != null)
      result.add(element.getConfidentialityValue().eContainer().eContainer());
    else if (element.getAvailabilityValue() != null)
      result.add(element.getAvailabilityValue().eContainer().eContainer());
    else if (element.getIntegrityValue() != null)
      result.add(element.getIntegrityValue().eContainer().eContainer());
    else if (element.getTraceabilityValue() != null)
      result.add(element.getTraceabilityValue().eContainer().eContainer());
  }

}
