/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.ui.massactions.providers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.InvolvedActorsByThreatColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ThreatSourceProfileColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.TrustedColumn;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnprovider.AbstractMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;

public class ThreatColumnProvider extends AbstractMAColumnProvider {

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> commonPossibleFeatures,
      Collection<EObject> data) {

    if (data.stream().anyMatch(e -> !(e instanceof Threat))) {
      return Collections.emptyList();
    }

    return Arrays.asList(new InvolvedActorsByThreatColumn(), new TrustedColumn(), new ThreatSourceProfileColumn());
  }

}
