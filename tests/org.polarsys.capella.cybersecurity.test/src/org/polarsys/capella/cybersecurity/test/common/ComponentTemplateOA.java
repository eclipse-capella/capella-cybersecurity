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
package org.polarsys.capella.cybersecurity.test.common;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;

public class ComponentTemplateOA extends ComponentTemplate1 {

  public ComponentTemplateOA(CapellaModelSkeleton skeleton, DynamicValidationTest test) {
    super(skeleton, test);
  }

  @Override
  protected Component getRootComponent(CapellaModelSkeleton skeleton) {
    OperationalAnalysis oa = skeleton.getOperationalAnalysis();
    oa.getOwnedEntityPkg().getOwnedEntities().add(OaFactory.eINSTANCE.createEntity("Entity"));
    return oa.getOwnedEntityPkg().getOwnedEntities().get(0);
  }

  @Override
  protected AbstractFunction getRootFunction(CapellaModelSkeleton skeleton) {
    OperationalAnalysis oa = skeleton.getOperationalAnalysis();
    return oa.getContainedOperationalActivityPkg().getOwnedOperationalActivities().get(0);
  }

  @Override
  protected EClass getComponentClass() {
    return BasicDynamicModelTest.OE;
  }

  @Override
  protected EClass getFunctionClass() {
    return BasicDynamicModelTest.OAC;
  }

}
