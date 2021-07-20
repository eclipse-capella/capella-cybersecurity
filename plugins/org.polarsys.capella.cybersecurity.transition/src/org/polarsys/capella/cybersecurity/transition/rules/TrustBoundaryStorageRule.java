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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.common.rules.AbstractUpdateRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 *
 */
public class TrustBoundaryStorageRule extends AbstractUpdateRule {
  
  public TrustBoundaryStorageRule() {
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE);
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE);
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__TRUSTED);
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__RATIONALE);
  }

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE;
  }
  
  @Override
  public EClass getTargetType(EObject element, IContext context) {
    return CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE;
  }
}
