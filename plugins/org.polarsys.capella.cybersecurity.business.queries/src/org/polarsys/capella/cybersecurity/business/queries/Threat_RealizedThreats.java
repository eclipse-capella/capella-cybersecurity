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
package org.polarsys.capella.cybersecurity.business.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.interaction.AbstractCapabilityRealization;
import org.polarsys.capella.core.data.interaction.InteractionPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;

public class Threat_RealizedThreats extends CybersecurityRealizedElements {

  public Threat_RealizedThreats() {
    super(
        InteractionPackage.Literals.ABSTRACT_CAPABILITY__OWNED_ABSTRACT_CAPABILITY_REALIZATIONS,
        Threat.class::isInstance,
        CybersecurityPackage.Literals.THREAT);
  }

  @Override
  public EClass getExtensionClass() {
    return CybersecurityPackage.Literals.THREAT;
  }
  
  @Override
  protected List<EObject> getTargetElements(List<EObject> list) {
    List<EObject> result = new ArrayList<EObject>();
    for (EObject obj : list) {
      if (obj instanceof AbstractCapabilityRealization) {
        AbstractCapabilityRealization link = (AbstractCapabilityRealization) obj;
        result.add(link.getRealizedCapability());
      }
    }
    return result;
  }
}
