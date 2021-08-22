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
