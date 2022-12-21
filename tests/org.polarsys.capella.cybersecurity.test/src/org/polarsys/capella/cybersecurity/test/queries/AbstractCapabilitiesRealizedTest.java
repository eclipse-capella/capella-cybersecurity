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
package org.polarsys.capella.cybersecurity.test.queries;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.ctx.Capability_RealizedCapabilities;
import org.polarsys.capella.core.business.queries.la.CapabilityRealization_RealizedCapabilities;
import org.polarsys.capella.cybersecurity.business.queries.Threat_RealizedThreats;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.test.framework.api.NonDirtyTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;

public class AbstractCapabilitiesRealizedTest extends NonDirtyTestCase {
  
  public static final String SA_CAPABILITY1 = "fcf094b4-20cb-45b3-a7f7-529cc31e2196";
  public static final String LA_CAPABILITY1 = "8db1e358-c6b3-466a-8fdc-a3760e894649";
  public static final String PA_CAPABILITY1 = "e78ce9ba-7d31-454b-86c1-b050fc7e7160";
  public static final String MODEL = "CybersecurityModel";
  
  public static final String SA_THREAT1 = "100b227c-6b62-4875-aded-7eeaddf8cba9";
  public static final String LA_THREAT1 = "76bda8ac-2831-42a4-90c4-bb52745d8380";
  public static final String PA_THREAT1 = "cb4843d5-6bab-408e-8025-1ca31fc5b050";
  
  protected SessionContext context;
  protected Session session;
  
  @Override
  public void test() throws Exception {
    session = getSession(MODEL);
    context = new SessionContext(session);
    
    // SA Capability realized shall not propose Threats, Threat shall not propose Capabilities
    checkRealizedAbstractCapabilities(SA_CAPABILITY1, new Capability_RealizedCapabilities());
    checkRealizedThreats(SA_THREAT1, new Threat_RealizedThreats());
    
    // LA CapabilityRealization realized shall not propose Threats, Threat shall not propose CapabilityRealizations
    checkRealizedAbstractCapabilities(LA_CAPABILITY1, new CapabilityRealization_RealizedCapabilities());
    checkRealizedThreats(LA_THREAT1, new Threat_RealizedThreats());
    
    // PA CapabilityRealization realized shall not propose Threats, Threat shall not propose CapabilityRealizations
    checkRealizedAbstractCapabilities(PA_CAPABILITY1, new CapabilityRealization_RealizedCapabilities());
    checkRealizedThreats(PA_THREAT1, new Threat_RealizedThreats());
  }
  
  private void checkRealizedAbstractCapabilities(String capabilityId, IBusinessQuery query) {
    EObject capability = context.getSemanticElement(capabilityId);
    List<EObject> elements = query.getAvailableElements(capability);
    boolean hasThreats = elements.stream().filter(x -> x instanceof Threat).findAny().isPresent();
    assertFalse(capabilityId + " shall not be able to realize Threats", hasThreats);
  }
  
  private void checkRealizedThreats(String threatId, IBusinessQuery query) {
    EObject threat = context.getSemanticElement(threatId);
    List<EObject> elements = query.getAvailableElements(threat);
    boolean hasCapability = elements.stream().filter(x -> !(x instanceof Threat)).findAny().isPresent();
    assertFalse(threatId + " shall not be able to realize Capabilities or CapabilityRealization", hasCapability);
  }
  
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(MODEL);
  }
}
