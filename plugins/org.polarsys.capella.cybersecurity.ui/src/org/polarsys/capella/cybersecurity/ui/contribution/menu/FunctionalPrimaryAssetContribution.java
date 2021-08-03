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
package org.polarsys.capella.cybersecurity.ui.contribution.menu;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.common.menu.dynamic.contributions.IMDEMenuItemContribution;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class FunctionalPrimaryAssetContribution implements IMDEMenuItemContribution {

  private static final String OA_PA_PREFIX = "OperationalActivityPrimaryAsset";

  /**
   * @see org.polarsys.capella.common.ui.menu.IMDEMenuItemContribution#executionContribution()
   */
  public Command executionContribution(EditingDomain editingDomain, ModelElement containerElement,
      ModelElement createdElement, EStructuralFeature feature) {
    BlockArchitecture ba = BlockArchitectureExt.getRootBlockArchitecture(containerElement);
    if (ba instanceof OperationalAnalysis) {
      ((PrimaryAsset) createdElement).setName(EcoreUtil2.getUniqueName(createdElement, containerElement, feature,
          ModellingcorePackage.Literals.ABSTRACT_NAMED_ELEMENT__NAME, OA_PA_PREFIX));
    }
    return null;
  }

  /**
   * @see org.polarsys.capella.common.ui.menu.IMDEMenuItemContribution#getMetaclass()
   */
  public EClass getMetaclass() {
    return CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET;
  }

  /**
   * @see org.polarsys.capella.common.ui.menu.IMDEMenuItemContribution#selectionContribution()
   */
  public boolean selectionContribution(ModelElement modelElement, EClass cls, EStructuralFeature feature) {
    return true;
  }
}