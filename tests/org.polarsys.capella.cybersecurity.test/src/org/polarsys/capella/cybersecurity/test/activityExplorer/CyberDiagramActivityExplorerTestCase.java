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

import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.AbstractCapellaNewDiagramHyperlinkAdapter;
import org.polarsys.capella.core.model.handler.helpers.RepresentationHelper;
import org.polarsys.capella.test.framework.helpers.GuiActions;

public abstract class CyberDiagramActivityExplorerTestCase extends ActivityExplorerTestCase {

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
    if (link instanceof AbstractCapellaNewDiagramHyperlinkAdapter)
      return ((AbstractCapellaNewDiagramHyperlinkAdapter) link).createDiagram(structure, session);

    return false;
  }

  protected void doTest() {
    int nrOfExistingDiagrams = getNrOfDiagrams();
    boolean result = getResultOfCreateDiagram();
    assertTrue(result);

    assertEquals(getNrOfDiagrams(), nrOfExistingDiagrams + 1);
    GuiActions.closeSession(session, false);
  }
}
