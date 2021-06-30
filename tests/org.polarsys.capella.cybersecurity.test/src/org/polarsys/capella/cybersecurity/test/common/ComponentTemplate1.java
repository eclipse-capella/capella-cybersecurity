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

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.PhysicalPort;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.FunctionInputPort;
import org.polarsys.capella.core.data.fa.FunctionOutputPort;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;

/**
 * A physical component with 2 unused cp and 2 allocated functions, each function has 2 fip and 2 fop.
 */
public abstract class ComponentTemplate1 {
  
  public Component component;
  public AbstractFunction pf1;
  public FunctionOutputPort fop1_1;
  public FunctionOutputPort fop1_2;
  public FunctionInputPort fip1_1;
  public FunctionInputPort fip1_2; 
  public AbstractFunction pf2;
  public FunctionOutputPort fop2_1;
  public FunctionOutputPort fop2_2;
  public FunctionInputPort fip2_1;
  public FunctionInputPort fip2_2;

  public ComponentPort cp1;
  public ComponentPort cp2;
  
  public PhysicalPort pp1;
  public PhysicalPort pp2;

  public ComponentTemplate1(CapellaModelSkeleton skeleton, DynamicValidationTest test) {

    Component rootC = getRootComponent(skeleton);
    AbstractFunction rootF = getRootFunction(skeleton);

    component = test.create(rootC, getComponentClass());

    cp1 = test.create(component, BasicDynamicModelTest.CP);
    cp2 = test.create(component, BasicDynamicModelTest.CP);

    pf1 = test.create(rootF, getFunctionClass());
    pf2 = test.create(rootF, getFunctionClass());

    Allocators.allocate(pf1, pf2).on(component);

    fop1_1 = test.create(pf1, BasicDynamicModelTest.FOP);
    fop1_2 = test.create(pf1, BasicDynamicModelTest.FOP);
    fip1_1 = test.create(pf1, BasicDynamicModelTest.FIP);
    fip1_2 = test.create(pf1, BasicDynamicModelTest.FIP);

    fip2_1 = test.create(pf2, BasicDynamicModelTest.FIP);
    fip2_2 = test.create(pf2, BasicDynamicModelTest.FIP);
    fop2_1 = test.create(pf2, BasicDynamicModelTest.FOP);
    fop2_2 = test.create(pf2, BasicDynamicModelTest.FOP);

    pp1 = test.create(component, BasicDynamicModelTest.PP);
    pp2 = test.create(component, BasicDynamicModelTest.PP);
  }
  
  protected abstract Component getRootComponent(CapellaModelSkeleton skeleton);
  
  protected abstract AbstractFunction getRootFunction(CapellaModelSkeleton skeleton);
  
  protected abstract EClass getComponentClass();
  
  protected abstract EClass getFunctionClass();
}