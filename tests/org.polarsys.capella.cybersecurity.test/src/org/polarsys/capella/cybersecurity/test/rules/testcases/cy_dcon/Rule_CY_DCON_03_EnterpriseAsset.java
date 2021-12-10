/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class Rule_CY_DCON_03_EnterpriseAsset extends Abstract_Rule_CY_DCON_03<PrimaryAsset> {

  @Override
  protected void setRule() {
    super.RULE = "org.polarsys.capella.cybersecurity.validation.CY_DCON_03";
    
  }

  @Override
  protected PrimaryAsset createElement() {
    return CybersecurityFactory.eINSTANCE.createEnterprisePrimaryAsset();
  }

  @Override
  protected EList<PrimaryAsset> getElementsFromCybersecurityPkg(CybersecurityPkg cybersecurityPkg) {
    return cybersecurityPkg.getOwnedPrimaryAssets();
  }
  
}
