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

import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;

public class FunctionalPrimaryAsset_Functions extends BlockArchitecturePredicateQuery {
  public FunctionalPrimaryAsset_Functions() {
    super(CybersecurityPackage.Literals.PRIMARY_ASSET__OWNED_MEMBERS, AbstractFunction.class::isInstance,
        CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET);
  }
}
