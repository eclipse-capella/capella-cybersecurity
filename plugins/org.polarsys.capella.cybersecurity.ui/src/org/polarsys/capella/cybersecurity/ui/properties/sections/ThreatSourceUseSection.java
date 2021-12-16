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
package org.polarsys.capella.cybersecurity.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.polarsys.capella.core.data.oa.Entity;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.kitalpha.emde.model.EmdePackage;

public class ThreatSourceUseSection extends CybersecuritySection {

  public ThreatSourceUseSection() {
    super(true);
  }

  public ThreatSourceUseSection(boolean showRealizations) {
    super(showRealizations);
  }

  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return (eObjectToTest instanceof Entity
        || (eObjectToTest instanceof Component && ((Component) eObjectToTest).isActor()));
  }
  
  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);
    super.addUsedWidget("Uses");
  }

  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);
    loadData(newEObject);
  }

  @Override
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);
    
    super.loadRealizedWidget(capellaElement, EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS);
    
    CybersecurityServices service = new CybersecurityServices();
    setEnabled(service.isThreatSource(capellaElement));
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> fields = new ArrayList<>();
    super.addRealizedFields(fields);
    return fields;
  }

  @Override
  protected AbstractMultipleSemanticFieldController getController() {
    return new ActorUseController();
  }

}
