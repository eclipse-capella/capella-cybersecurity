/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
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

    CybersecurityPropertyButtonListener.getCybersecurityPropertyListener().registerPropertySection(this);
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

  @Override
  public void dispose() {
    super.dispose();
    CybersecurityPropertyButtonListener.getCybersecurityPropertyListener().unregisterPropertySection(this);
  }

}
