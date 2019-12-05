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
package org.polarsys.capella.cybersecurity.test.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionPort;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;

/**
 * The entry point for the fluent Allocator API. 
 */
public class Allocators {

  public static ExchangeItemAllocator allocate(ExchangeItem e) {
    return ExchangeItemAllocator.allocate(Collections.singleton(e), false);  
  }

  public static ExchangeItemAllocator allocateExchangeItems(Collection<? extends ExchangeItem> ei) {
    return ExchangeItemAllocator.allocate(ei);
  }
  
  public static ExchangeItemAllocator allocate(ExchangeItem ... exchangeItems) {
    return ExchangeItemAllocator.allocate(exchangeItems);
  }
  
  public static FunctionAllocator allocate(AbstractFunction f) {
    return FunctionAllocator.allocate(Collections.singleton(f));
  }

  public static FunctionAllocator allocateFunctions(Collection<? extends AbstractFunction> functs) {
    return FunctionAllocator.allocate(functs);
  }

  public static FunctionAllocator allocate(AbstractFunction ...abstractFunctions) {
    return FunctionAllocator.allocate(abstractFunctions);
  }
  
  public static FunctionPortAllocator allocate(FunctionPort p) {
    return FunctionPortAllocator.allocate(Collections.singleton(p));
  }

  public static FunctionPortAllocator allocateFunctionPorts(Collection<? extends FunctionPort> fxp) {
    return FunctionPortAllocator.allocate(fxp);
  }

  public static FunctionPortAllocator allocate(FunctionPort...functionPorts) {
    return FunctionPortAllocator.allocate(functionPorts);
  }
  
  public static FunctionalExchangeAllocator allocate(FunctionalExchange... fes) {
    return new FunctionalExchangeAllocator(Arrays.asList(fes));
  }

}
