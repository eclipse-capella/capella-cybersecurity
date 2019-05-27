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
package org.polarsys.capella.cybersecurity.business.queries;

import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

public class FunctionStorage_ExchangeItems extends BlockArchitecturePredicateQuery {

  public FunctionStorage_ExchangeItems() {
    super(CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS, ExchangeItem.class::isInstance,
        CybersecurityPackage.Literals.FUNCTION_STORAGE);
  }

}
