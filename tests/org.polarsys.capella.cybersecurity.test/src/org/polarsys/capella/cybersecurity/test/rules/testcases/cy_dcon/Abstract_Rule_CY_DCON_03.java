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
package org.polarsys.capella.cybersecurity.test.rules.testcases.cy_dcon;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.core.data.capellacommon.CapellacommonFactory;
import org.polarsys.capella.core.data.capellacommon.TransfoLink;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.test.common.DynamicValidationTest;

public abstract class Abstract_Rule_CY_DCON_03<T> extends DynamicValidationTest {
  protected String RULE;
  private T elementOA;
  private T elementOAko;
  private T elementSA;
  private T elementSAko;
  private T elementLA;
  private T elementLAko;
  private T elementPA;

  @Override
  protected void initModel(CapellaModelSkeleton skeleton2) {
    elementOA = createElement(OA);
    elementOAko = createElement(OA);
    elementSA = createElement(SA);
    elementSAko = createElement(SA);
    linkElements((TraceableElement)elementSA, (TraceableElement)elementOA);
    elementLA = createElement(LA);
    elementLAko = createElement(LA);
    linkElements((TraceableElement)elementLA, (TraceableElement)elementSA);
    elementPA = createElement(PA);
    linkElements((TraceableElement)elementPA, (TraceableElement)elementLA);
    setRule();
  }

  @Override
  public void test() throws Exception {
    ok((EObject)elementOA, RULE);
    ok((EObject)elementSA, RULE);
    ok((EObject)elementLA, RULE);
    ko((EObject)elementOAko, RULE);
    ko((EObject)elementSAko, RULE);
    ko((EObject)elementLAko, RULE);
    ok((EObject)elementPA, RULE);
  }

  private T createElement(String arhitecture) {
    CybersecurityPkg pkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
    T element = createElement();
    getElementsFromCybersecurityPkg(pkg).add(element);
    if (arhitecture.equals(OA)) {
      skeleton.getOperationalAnalysis().getOwnedExtensions().add(pkg);
    } else if (arhitecture.equals(SA)) {
      skeleton.getSystemAnalysis().getOwnedExtensions().add(pkg);
    } else if (arhitecture.equals(LA)) {
      skeleton.getLogicalArchitecture().getOwnedExtensions().add(pkg);
    } else if (arhitecture.equals(PA)) {
      skeleton.getPhysicalArchitecture().getOwnedExtensions().add(pkg);
    }
    return element;
  }
  
  private void linkElements(TraceableElement source, TraceableElement target) {
    TransfoLink link = CapellacommonFactory.eINSTANCE.createTransfoLink();
    link.setSourceElement(source);
    link.setTargetElement(target);
    addLinkIntoArhitecture(link, source);
  }
  
  private void addLinkIntoArhitecture(TransfoLink link, TraceableElement element) {
    BlockArchitecture arhitecture = BlockArchitectureExt.getRootBlockArchitecture(element);
    if (arhitecture instanceof OperationalAnalysis) {
      skeleton.getOperationalAnalysis().getOwnedTraces().add(link);
    } else if (arhitecture instanceof SystemAnalysis) {
      skeleton.getSystemAnalysis().getOwnedTraces().add(link);
    } else if (arhitecture instanceof LogicalArchitecture) {
      skeleton.getLogicalArchitecture().getOwnedTraces().add(link);
    } else if (arhitecture instanceof PhysicalArchitecture) {
      skeleton.getPhysicalArchitecture().getOwnedTraces().add(link);
    }
  
  }
  
  protected abstract void setRule();

  protected abstract T createElement();
  
  protected abstract EList<T> getElementsFromCybersecurityPkg(CybersecurityPkg cybersecurityPkg);
}
