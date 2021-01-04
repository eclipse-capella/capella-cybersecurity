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
package org.polarsys.capella.cybersecurity.business.queries;

import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

public class InformationPrimaryAsset_ExchangeItems extends BlockArchitecturePredicateQuery {

  public InformationPrimaryAsset_ExchangeItems() {
    super(CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS, ExchangeItem.class::isInstance,
        CybersecurityPackage.Literals.INFORMATION_PRIMARY_ASSET);
  }

}
