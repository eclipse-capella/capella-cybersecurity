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
import org.eclipse.sirius.business.api.session.SessionManager;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.menu.dynamic.contributions.IMDEMenuItemContribution;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;

public class ThreatContribution implements IMDEMenuItemContribution {

  /**
   * @see org.polarsys.capella.common.ui.menu.IMDEMenuItemContribution#executionContribution()
   */
  public Command executionContribution(EditingDomain editingDomain, ModelElement containerElement,
      ModelElement createdElement, EStructuralFeature feature) {
    Project project = SessionHelper.getCapellaProject(SessionManager.INSTANCE.getSession(containerElement));
    EnumerationPropertyType propertyType = CybersecurityQueries.getThreatKindPropertyType(project);
    EnumerationPropertyLiteral eavesdroppingLiteral = propertyType.getOwnedLiterals().get(0);
    Threat newElement = (Threat) createdElement;
    newElement.setKind(eavesdroppingLiteral);
    return null;
  }

  /**
   * @see org.polarsys.capella.common.ui.menu.IMDEMenuItemContribution#getMetaclass()
   */
  public EClass getMetaclass() {
    return CybersecurityPackage.Literals.THREAT;
  }

  /**
   * @see org.polarsys.capella.common.ui.menu.IMDEMenuItemContribution#selectionContribution()
   */
  public boolean selectionContribution(ModelElement modelElement, EClass cls, EStructuralFeature feature) {
    return true;
  }
}