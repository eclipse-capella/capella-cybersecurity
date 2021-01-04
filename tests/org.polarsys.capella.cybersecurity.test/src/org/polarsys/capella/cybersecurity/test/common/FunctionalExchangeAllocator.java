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
package org.polarsys.capella.cybersecurity.test.common;

import java.util.Collection;

import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentExchangeFunctionalExchangeAllocation;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.fa.FunctionalExchange;

public class FunctionalExchangeAllocator {

  private final Collection<? extends FunctionalExchange> allocations;
  
  FunctionalExchangeAllocator(Collection<? extends FunctionalExchange> fes){
    allocations = fes;
  }

  public FunctionalExchangeAllocator on(ComponentExchange c){
    for (FunctionalExchange fe : allocations){
      ComponentExchangeFunctionalExchangeAllocation a = FaFactory.eINSTANCE.createComponentExchangeFunctionalExchangeAllocation();
      a.setSourceElement(c);
      a.setTargetElement(fe);
      c.getOwnedComponentExchangeFunctionalExchangeAllocations().add(a);
    }
    return this;
  }
  
}
