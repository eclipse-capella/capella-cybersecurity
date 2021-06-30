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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.ui.statushandlers.StatusManager;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;

public abstract class DynamicValidationTest extends BasicDynamicModelTest {
  protected EnumerationPropertyType typeConfidentiality;
  protected EnumerationPropertyType typeAvailability;
  protected EnumerationPropertyType typeIntegrity;
  protected EnumerationPropertyType typeTraceability;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    ModelValidationService.getInstance().loadXmlConstraintDeclarations();
    
    typeConfidentiality = CybersecurityQueries.getConfidentialityPropertyType(project);
    typeAvailability = CybersecurityQueries.getAvailabilityPropertyType(project);
    typeIntegrity = CybersecurityQueries.getIntegrityPropertyType(project);
    typeTraceability = CybersecurityQueries.getTraceabilityPropertyType(project);
  }

  /**
   * Validate the given Object with the EMF Validation service.
   * Triggers a failure unless the result status 'isOK()'. 
   * 
   * @param e
   * @throws InterruptedException 
   */
  protected IStatus ok(EObject e, String ruleID) throws InterruptedException {
    IStatus status = ValidationHelpers.validate(e, ruleID);
    if (!status.isOK()) {
      StatusManager.getManager().handle(status, StatusManager.LOG);
      fail(status.getMessage());
    }
    return status;
  }
  
  protected void ok(IStatus s) {
    assertTrue(s.isOK());
  }
  
  protected void ko(IStatus s) {
    assertFalse(s.isOK());
  }

  /**
   * Validate the given Object with the EMF Validation service.
   * Triggers a failure if the result status 'isOK()'.
   * @param e
   * @throws InterruptedException 
   */
  protected IStatus ko(EObject e, String ruleID) throws InterruptedException {
    IStatus status = ValidationHelpers.validate(e, ruleID);
    assertFalse("Validator returned unexpected OK Status", status.isOK()); //$NON-NLS-1$
    return status;
  }
  
  protected ComponentTemplate1 createComponentTemplate(CapellaModelSkeleton skeleton, String architecture) {
    switch(architecture) {
    case LA:
      return new ComponentTemplateLA(skeleton, this);
    case SA:
      return new ComponentTemplateSA(skeleton, this);
    case PA:
      return new ComponentTemplatePA(skeleton, this);
    default:
      return new ComponentTemplateOA(skeleton, this);
    }
  }
  
}
