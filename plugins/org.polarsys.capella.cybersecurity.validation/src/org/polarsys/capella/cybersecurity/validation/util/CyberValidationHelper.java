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
package org.polarsys.capella.cybersecurity.validation.util;

import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class CyberValidationHelper {

  /*
   * Returns the title label of a primary asset.
   */
  public static String getPATitleLabel(PrimaryAsset pa) {
    return pa instanceof FunctionalPrimaryAsset
        && BlockArchitectureExt.getRootBlockArchitecture(pa) instanceof OperationalAnalysis
            ?
            "(Operational Activity Primary Asset) "
            : NamingHelper.getTitleLabel(pa);
  }
}
