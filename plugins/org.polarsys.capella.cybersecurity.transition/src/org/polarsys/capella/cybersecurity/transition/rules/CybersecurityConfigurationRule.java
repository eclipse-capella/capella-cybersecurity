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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.system.rules.AbstractCapellaElementRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

public class CybersecurityConfigurationRule extends AbstractCapellaElementRule {

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION;
  }

  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    CybersecurityConfiguration element = (CybersecurityConfiguration) source;

    result.add(element.getAvailability());
    result.add(element.getConfidentiality());
    result.add(element.getIntegrity());
    result.add(element.getTraceability());

    result.add(element.getThreatKind());
  }
}
