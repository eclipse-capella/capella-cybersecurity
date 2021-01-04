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
package org.polarsys.capella.cybersecurity.ui.massactions.filters;

import org.polarsys.capella.cybersecurity.ui.massactions.columns.InvolvedActorsByThreatColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ThreatSourceProfileColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.TrustedColumn;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnfilter.AbstractMAColumnFilter;

public class ThreatsFilter extends AbstractMAColumnFilter {

  @Override
  public boolean shouldHide(IMAColumn column) {
    
    if ("name".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }

    if ("threatKind".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }
    
    if ("level".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }
    
    if ("rationale".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }
    
    if (column.getClass() == InvolvedActorsByThreatColumn.class
        || column.getClass() == TrustedColumn.class
        || column.getClass() == ThreatSourceProfileColumn.class) {
      return false;
    }

    return true;
  }

}
