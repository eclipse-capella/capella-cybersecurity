/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
