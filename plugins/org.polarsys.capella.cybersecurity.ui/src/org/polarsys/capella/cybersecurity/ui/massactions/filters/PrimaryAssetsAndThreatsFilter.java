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

import org.polarsys.capella.cybersecurity.ui.massactions.columns.InvolvedActorsByAssetColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.RationaleColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ThreatKindColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ThreatLevelColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.ThreatSourceProfileMaxColumn;
import org.polarsys.capella.cybersecurity.ui.massactions.columns.TypeColumn;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnfilter.AbstractMAColumnFilter;

public class PrimaryAssetsAndThreatsFilter extends AbstractMAColumnFilter {

  @Override
  public boolean shouldHide(IMAColumn column) {

    if ("name".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }

    if (column.getClass() == InvolvedActorsByAssetColumn.class || column.getClass() == TypeColumn.class
        || column.getClass() == RationaleColumn.class || column.getClass() == ThreatKindColumn.class
        || column.getClass() == ThreatLevelColumn.class || column.getClass() == ThreatSourceProfileMaxColumn.class) {
      return false;
    }

    if ("Threatened by".equals(column.getId())) { //$NON-NLS-1$
      return false;
    }

    return true;
  }

}
