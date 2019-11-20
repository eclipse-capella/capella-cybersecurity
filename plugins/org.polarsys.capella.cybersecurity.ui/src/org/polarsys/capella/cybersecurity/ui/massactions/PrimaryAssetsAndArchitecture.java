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

import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.Availability;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.Component;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.Confidentiality;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.Integrity;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.PrimaryAssetType;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.RealizedBy;
import org.polarsys.capella.cybersecurity.ui.massactions.PrimaryAssetColumns.Traceability;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnfilter.AbstractMAColumnFilter;

public class PrimaryAssetsAndArchitecture extends AbstractMAColumnFilter {

  @Override
  public boolean shouldHide(IMAColumn column) {

    if ("name".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }
  
    if (column.getClass() == PrimaryAssetType.class 
        || column.getClass() == Confidentiality.class
        || column.getClass() == Integrity.class
        || column.getClass() == Availability.class
        || column.getClass() == Traceability.class
        || column.getClass() == RealizedBy.class
        || column.getClass() == Component.class
        ) {
      return false;
    }

    return true;
  }

}
