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
package org.polarsys.capella.cybersecurity.business.queries;

import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;

public class EnterprisePrimaryAsset_PrimaryAssets extends BlockArchitecturePredicateQuery {

  public EnterprisePrimaryAsset_PrimaryAssets() {
    super(CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS,
        obj -> PrimaryAsset.class.isInstance(obj) && !(EnterprisePrimaryAsset.class.isInstance(obj)),
        CybersecurityPackage.Literals.ENTERPRISE_PRIMARY_ASSET);
  }

}
