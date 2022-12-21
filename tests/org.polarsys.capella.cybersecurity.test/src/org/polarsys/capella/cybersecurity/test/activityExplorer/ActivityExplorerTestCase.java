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

import org.eclipse.amalgam.explorer.activity.ui.api.hyperlinkadapter.AbstractHyperlinkAdapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.libraries.model.CapellaModel;
import org.polarsys.capella.test.framework.context.SessionContext;

public abstract class ActivityExplorerTestCase extends CyberEmptyModel {
  Session session;
  SessionContext context;
  CapellaModel model;
  Project project;
  AbstractHyperlinkAdapter link;
  EObject structure;
  
  protected abstract EObject getStructure();
  
  protected abstract AbstractHyperlinkAdapter createLink();

  protected abstract ModelElement getTestModelElement();

  protected void preTest() {
    ModelElement modelElement = getTestModelElement();
    assertEquals(modelElement, structure);
  }

  protected abstract void doTest();

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
}
