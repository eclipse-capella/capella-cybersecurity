/*******************************************************************************
 * Copyright (c) 2019, 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

public class ThreatSourceProfileColumn extends AbstractCybersecurityColumn {
  public ThreatSourceProfileColumn() {
    id = getClass().getCanonicalName();
    label = Messages.ThreatColumns_Label_ThreatSourceProfile;
    name = Messages.ThreatColumns_Name_ThreatSourceProfile;
  }
  @Override
  public Object getDataValue(EObject rowObject) {
    return CybersecurityQueries.getInvolvedThreatSources((Threat)rowObject)
        .flatMap(c -> c.getOwnedExtensions().stream())
        .filter(TrustBoundaryStorage.class::isInstance)
        .map(e -> (((TrustBoundaryStorage)e).getThreatSourceProfile()))
        .reduce(Math::max).orElse(0);
  }
}