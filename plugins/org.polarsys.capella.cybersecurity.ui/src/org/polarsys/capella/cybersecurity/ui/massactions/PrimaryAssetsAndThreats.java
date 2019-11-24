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
package org.polarsys.capella.cybersecurity.ui.massactions;

import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.PrimaryAssetType;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.Rationale;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.ThreatKind;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.ThreatLevel;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.ThreatSourceProfile;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnfilter.AbstractMAColumnFilter;

public class PrimaryAssetsAndThreats extends AbstractMAColumnFilter {

  @Override
  public boolean shouldHide(IMAColumn column) {
    
    if ("name".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }

    if ("Involved Actors".equals(column.getId())){ //$NON-NLS-1$
      return false;
    }

    if (column.getClass() == PrimaryAssetType.class
        || column.getClass() == Rationale.class
        || column.getClass() == ThreatKind.class
        || column.getClass() == ThreatLevel.class
        || column.getClass() == ThreatSourceProfile.class) {
      return false;
    }

    if ("Threatened by".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }

    return true;
  }

}
