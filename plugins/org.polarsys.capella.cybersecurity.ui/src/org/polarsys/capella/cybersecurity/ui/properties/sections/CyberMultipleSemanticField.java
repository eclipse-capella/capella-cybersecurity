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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.core.ui.properties.controllers.IMultipleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.MultipleSemanticField;

public class CyberMultipleSemanticField extends MultipleSemanticField {

  public CyberMultipleSemanticField(Composite parent, String label, TabbedPropertySheetWidgetFactory widgetFactory,
      IMultipleSemanticFieldController controller) {
    super(parent, label, widgetFactory, controller);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected void removeAllDataValue(final EObject object, final EStructuralFeature feature) {
    AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        List<EObject> containmentList = new ArrayList<>((List<EObject>) object.eGet(feature));
        for (EObject containedObject : containmentList) {
          deleteContainmentValue(containedObject);
        }
      }
    };
    executeCommand(command);
  }
}
