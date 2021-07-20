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
package org.polarsys.capella.cybersecurity.test.odesign;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.polarsys.capella.test.diagram.common.ju.wrapper.utils.ODesignHelper;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class CyberElementsHaveDirectEditLabelTest extends BasicTestCase {
  StringBuilder failedTest = new StringBuilder();

  @Override
  public void test() throws Exception {
    List<DiagramElementMapping> diagramElementMappings = new ArrayList<DiagramElementMapping>();
    Viewpoint viewpoint = ViewpointRegistry.getInstance()
        .getViewpoint(URI.createURI("viewpoint:/org.polarsys.capella.cybersecurity.sirius.analysis/Cybersecurity"));

    diagramElementMappings.addAll((Collection<? extends DiagramElementMapping>) StreamSupport
        .stream(Spliterators.spliteratorUnknownSize(viewpoint.eResource().getAllContents(), 0), false)
        .filter(DiagramElementMapping.class::isInstance).map(x -> (DiagramElementMapping) x)
        .filter(ODesignHelper::isNotDeprecatedMapping).collect(Collectors.toList()));
    
    checkMappingsHasEditLabels(diagramElementMappings);

    if (this.failedTest.length() == 0) {
      assertTrue(true);
    } else {
      System.err.println(failedTest.toString());
      assertTrue(this.failedTest.toString(), false);
    }
  }

  protected void checkMappingsHasEditLabels(List<DiagramElementMapping> mappingsToCheck) {
    if (mappingsToCheck != null) {
      for (DiagramElementMapping mapping : mappingsToCheck) {
        if (mapping.getLabelDirectEdit() == null) {
          this.failedTest.append("No DirectEditLabel for: " + ODesignHelper.computeModelPath(mapping) + "\n");
        }
      }
    }
  }
}