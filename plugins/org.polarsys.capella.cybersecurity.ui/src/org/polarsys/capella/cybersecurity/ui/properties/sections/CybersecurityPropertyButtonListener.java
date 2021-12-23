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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;

public class CybersecurityPropertyButtonListener implements SelectionListener {

  private static CybersecurityPropertyButtonListener listener;
  private Set<AbstractSection> sections;

  public static CybersecurityPropertyButtonListener getCybersecurityPropertyListener() {
    if (null == listener) {
      listener = new CybersecurityPropertyButtonListener();
    }
    return listener;
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    if (!getSections().isEmpty()) {
      for (AbstractSection section : getSections()) {
        section.refresh();
      }
    }
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {
    widgetSelected(e);

  }

  public Set<AbstractSection> getSections() {
    if (null == sections) {
      sections = new HashSet<>();
    }
    return sections;
  }

  public void registerPropertySection(AbstractSection section) {
    if (!getSections().contains(section)) {
      getSections().add(section);
    }
  }

  public void unregisterPropertySection(AbstractSection section) {
    getSections().remove(section);
  }

}
