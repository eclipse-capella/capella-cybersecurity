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
