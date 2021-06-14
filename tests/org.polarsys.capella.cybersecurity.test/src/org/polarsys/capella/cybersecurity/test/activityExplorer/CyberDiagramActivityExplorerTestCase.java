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
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.libraries.model.CapellaModel;
import org.polarsys.capella.core.model.handler.helpers.RepresentationHelper;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.GuiActions;

public abstract class CyberDiagramActivityExplorerTestCase extends CyberEmptyModel {
  Session session;
  SessionContext context;
  CapellaModel model;
  Project project;
  AbstractCapellaNewDiagramHyperlinkAdapter link;
  EObject structure;

  protected abstract AbstractCapellaNewDiagramHyperlinkAdapter createLink();

  protected abstract EObject getStructure();

  protected abstract String getDefaultName();

  protected abstract ModelElement getTestModelElement();

  private int getNrOfDiagrams() {
    Collection<DRepresentationDescriptor> myList = RepresentationHelper
        .getAllRepresentationDescriptorsTargetedBy(Arrays.asList(structure));
    List<DRepresentationDescriptor> filteredDiags = myList.stream().filter(x -> x.getName().equals(getDefaultName()))
        .collect(Collectors.toList());

    return filteredDiags.size();
  }

  protected boolean getResultOfCreateDiagram() {
    return link.createDiagram(structure, session);
  }

  protected void initialize() {
    session = getSessionForTestModel(getRequiredTestModels().get(0));
    context = new SessionContext(session);
    model = getTestModel(getRequiredTestModels().get(0));
    project = model.getProject(session.getTransactionalEditingDomain());
    structure = getStructure();
    link = createLink();
  }

  @Override
  public void test() throws Exception {
    initialize();
    preTest();
    doTest();
  }

  protected void doTest() {
    int nrOfExistingDiagrams = getNrOfDiagrams();
    boolean result = getResultOfCreateDiagram();
    assertTrue(result);

    assertEquals(getNrOfDiagrams(), nrOfExistingDiagrams + 1);
    GuiActions.closeSession(session, false);

  }

  protected void preTest() {
    ModelElement modelElement = getTestModelElement();
    assertEquals(modelElement, structure);
  }
}
