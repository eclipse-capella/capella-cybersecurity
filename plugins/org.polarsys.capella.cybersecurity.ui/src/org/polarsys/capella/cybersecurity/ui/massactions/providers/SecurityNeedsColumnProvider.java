/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.ui.massactions.providers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.AvailabilityColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ConfidentialityColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.IntegrityColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.TraceabilityColumn;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnprovider.AbstractMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;

public class SecurityNeedsColumnProvider extends AbstractMAColumnProvider {

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> commonPossibleFeatures,
      Collection<EObject> data) {

    if (data.stream().anyMatch(e -> !(e instanceof PrimaryAsset))) {
      return Collections.emptyList();
    }

    return Arrays.asList(new ConfidentialityColumn(), new IntegrityColumn(), new AvailabilityColumn(),
        new TraceabilityColumn());
  }

}
