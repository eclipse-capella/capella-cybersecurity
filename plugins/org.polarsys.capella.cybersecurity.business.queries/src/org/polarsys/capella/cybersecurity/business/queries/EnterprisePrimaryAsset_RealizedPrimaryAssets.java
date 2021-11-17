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

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class EnterprisePrimaryAsset_RealizedPrimaryAssets extends CybersecurityRealizedElements {

  public EnterprisePrimaryAsset_RealizedPrimaryAssets() {
    super(ModellingcorePackage.Literals.TRACEABLE_ELEMENT__OUTGOING_TRACES, PrimaryAsset.class::isInstance,
        CybersecurityPackage.Literals.ENTERPRISE_PRIMARY_ASSET);
  }

  @Override
  public EClass getExtensionClass() {
    return CybersecurityPackage.Literals.PRIMARY_ASSET;
  }

}
