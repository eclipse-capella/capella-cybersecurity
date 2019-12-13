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
package org.polarsys.capella.cybersecurity.ui.massactions.filters;

import org.polarsys.capella.cybersecurity.ui.massactions.columns.AvailabilityColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ComponentColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ConfidentialityColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.IntegrityColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.TypeColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.RealizedByColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.TraceabilityColumn;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnfilter.AbstractMAColumnFilter;

public class PrimaryAssetsAndArchitectureFilter extends AbstractMAColumnFilter {

  @Override
  public boolean shouldHide(IMAColumn column) {

    if ("name".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }
  
    if (column.getClass() == TypeColumn.class 
        || column.getClass() == ConfidentialityColumn.class
        || column.getClass() == IntegrityColumn.class
        || column.getClass() == AvailabilityColumn.class
        || column.getClass() == TraceabilityColumn.class
        || column.getClass() == RealizedByColumn.class
        || column.getClass() == ComponentColumn.class
        ) {
      return false;
    }

    return true;
  }

}
