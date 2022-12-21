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

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.Threat;

public class OperationalThreatSection extends ThreatSection {
  public OperationalThreatSection() {
    super(false);
  }
  
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    return eObjectToTest instanceof Threat && !isRealizedArchitecture(eObjectToTest);
  }
}
