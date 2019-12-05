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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintFilter;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.libraries.model.CapellaModel;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class ReflectiveValidationTest extends BasicTestCase {
  
  private final String ruleID;
  private final String requiredTestModel;
  
  public ReflectiveValidationTest(String ruleID, String requiredTestModel) {
    this.ruleID = ruleID;
    this.requiredTestModel = requiredTestModel;
  }

  protected static final Pattern PATTERN_FAIL = Pattern.compile("_fail$"); //$NON-NLS-1$
  protected static final Pattern PATTERN_OK = Pattern.compile("_ok$"); //$NON-NLS-1$
  protected static final Pattern PATTERN_TEST = Pattern.compile("^test"); //$NON-NLS-1$
  
  protected Collection<EObject> okElements = new ArrayList<>();
  protected Collection<EObject> failElements = new ArrayList<>();
  protected Collection<EObject> toValidate = new ArrayList<>();

  @Override
  public String getName() {
    return ruleID + "/ " + requiredTestModel; //$NON-NLS-1$
  }
  
  public void setUp() throws Exception {
    super.setUp();
    ModelValidationService.getInstance().loadXmlConstraintDeclarations();
    CapellaModel model = getTestModel(getRequiredTestModels().iterator().next());
    TransactionalEditingDomain domain = model.getEditingDomain();
    Project project = model.getProject(domain);
    for (Iterator<EObject> it = project.eAllContents(); it.hasNext();){

      EObject next = it.next();
      
      if (shouldValidate(next)) {
        toValidate.add(next);
      }
      
      if (expectOk(next)) {
        okElements.add(next);
      } else if (expectFail(next)) {
        failElements.add(next);
      }
    }
  }
  
  /**
   * Runs model validation on the given EObejct. Before running the validation,
   * we install a filter on the validator to only validate the constraint
   * returned by getConstraintId()
   * 
   * @param e
   * @return the status we receive from the model validation service after validation.
   */
  protected IStatus validate(EObject e) {
    return validate(Collections.singleton(e));
  }
  
  /**
   * Create the validator that's used by validate()
   * @return
   */
  protected IValidator<EObject> getValidator() {
    return ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
  }
  
  protected IStatus validate(Collection<EObject> elements){
 // force activation of constraints under test
    ConstraintRegistry registry = ConstraintRegistry.getInstance();
    for (String ruleID : getRuleIDs()) {
      IConstraintDescriptor descriptor = registry.getDescriptor(ruleID);
      assertNotNull("Did not find constraint with id " + ruleID //$NON-NLS-1$ 
          + "in the constraint registry", descriptor); //$NON-NLS-1$
      
      descriptor.setEnabled(true);
    }
    IValidator<EObject> validator = getValidator();
    validator.addConstraintFilter(new IConstraintFilter() {
      public boolean accept(IConstraintDescriptor constraint_p, EObject target_p) {
        return getRuleIDs().contains(constraint_p.getId());
      }
    });
    return validator.validate(elements);
  }

  protected boolean findName(EObject element, Pattern pattern) {
    if (element instanceof NamedElement) {
      String name = ((NamedElement) element).getName();
      return name != null && pattern.matcher(name).find();
    }
    return false;
  }
  
  protected boolean matchName(EObject element, Pattern pattern) {
    if (element instanceof NamedElement) {
      String name = ((NamedElement) element).getName();
      return name != null && pattern.matcher(name).matches();
    }
    return false;
  }

  protected boolean shouldValidate(EObject element) {
    return element instanceof Component && findName(element, PATTERN_TEST);
  }

  protected  boolean expectOk(EObject element) {
    return findName(element, PATTERN_OK);
  }

  protected  boolean expectFail(EObject element) {
    return findName(element, PATTERN_FAIL);
  }

  @Override
  public void test() throws Exception {

    assertTrue(failElements.size() > 0);
    assertTrue(okElements.size() > 0);
    assertTrue(toValidate.size() > 0);
    
    validateResult(validate(toValidate));
  }
  
  protected IStatus find(IStatus root, Predicate<IStatus> pred){

    Deque<IStatus> toWork = new ArrayDeque<>();
    toWork.add(root);
    
    while (!toWork.isEmpty()) {

      IStatus current = toWork.pop();
      if (pred.test(current)) {
        return current;
      }
      
      IStatus[] children = current.getChildren();

      for (int i = 0; i < children.length; i++) {
        toWork.push(children[children.length - i - 1]);
      }
      
    }

    return null;

  }
 
  protected void validateResult(IStatus validationResult) throws Exception {

    // there should be a status for elements tagged to fail
    for (EObject e : failElements) {
      IStatus s = find(validationResult, t -> isFailureStatusFor(t, e));
      assertNotNull(s);
    }

    // there should be no status for elements tagged OK
    for (EObject e : okElements) {
      IStatus s = find(validationResult, t -> isFailureStatusFor(t, e));
      assertNull(s);
    }

  }

  protected boolean isFailureStatusFor(IStatus status, EObject target) {
    return !status.isOK() 
        && status instanceof ConstraintStatus && ((ConstraintStatus) status).getTarget() == target;
  }
  
  @Override
  public List<String> getRequiredTestModels() {
    return Collections.singletonList(requiredTestModel);
  }

  protected Collection<String> getRuleIDs() {
    return Collections.singleton(ruleID);
  }

  
}
