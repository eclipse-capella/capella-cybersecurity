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

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.la.LaPackage;
import org.polarsys.capella.core.data.pa.PaPackage;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;
import org.polarsys.capella.core.model.skeleton.CapellaModelSkeleton;
import org.polarsys.capella.cybersecurity.model.activator.CybersecurityModelActivator;
import org.polarsys.capella.cybersecurity.ui.CybersecurityProjectWizard;
import org.polarsys.capella.test.framework.api.BasicTestCase;

/**
 * This tests does not use a serialized test model, but builds one dynamically during {@link #setUp()}.
 * A capella model skeleton is created and is then initialized further by subclasses which must implement
 * {@link #initModel(CapellaModelSkeleton)}.
 */
public abstract class BasicDynamicModelTest extends BasicTestCase {

  public static final EClass PC = PaPackage.Literals.PHYSICAL_COMPONENT;
  public static final EClass PF = PaPackage.Literals.PHYSICAL_FUNCTION;
  public static final EClass CP = FaPackage.Literals.COMPONENT_PORT;
  public static final EClass FIP = FaPackage.Literals.FUNCTION_INPUT_PORT;
  public static final EClass FOP = FaPackage.Literals.FUNCTION_OUTPUT_PORT;
  public static final EClass FE = FaPackage.Literals.FUNCTIONAL_EXCHANGE;
  public static final EClass I = CsPackage.Literals.INTERFACE;
  public static final EClass EI = InformationPackage.Literals.EXCHANGE_ITEM;
  public static final EClass CE = FaPackage.Literals.COMPONENT_EXCHANGE;
  public static final EClass PP = CsPackage.Literals.PHYSICAL_PORT;
  public static final EClass PL = CsPackage.Literals.PHYSICAL_LINK;
  public static final EClass LC = LaPackage.Literals.LOGICAL_COMPONENT;


  protected ExecutionManager manager;
  protected CapellaModelSkeleton skeleton;
  protected TransactionalEditingDomainHelper tedHelper;
  protected Project project;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();

    manager = ExecutionManagerRegistry.getInstance().addNewManager();
    tedHelper = new TransactionalEditingDomainHelper(manager.getEditingDomain());
    
    skeleton = new CapellaModelSkeleton.Builder(manager)
        .setURI(URI.createPlatformResourceURI("/project/project.melodymodeller", false)) //$NON-NLS-1$
        .setName("project")
        .build(); //$NON-NLS-1$
    
    Notifier target = skeleton.getTarget();
    if (target instanceof Project) {
      project = (Project) target;
      executeCommand(() -> {
        new CybersecurityModelActivator().addProjectCybersecurityConfig(project);
      });
    }
    
    executeCommand(() -> {
      initModel(skeleton);
    });
  }

  public void tearDown() {
    ExecutionManagerRegistry.getInstance().removeManager(manager);
  }

  protected final void executeCommand(Runnable runnable, Map<?,?> options) throws RollbackException, InterruptedException {
    tedHelper.executeCommand(runnable, options);
  }

  /**
   * Wraps a runnable into a RecordingCommand and executes that on the editing domain for this test.
   * @param runnable
   * @throws RollbackException
   * @throws InterruptedException
   */
  protected final void executeCommand(Runnable runnable) throws RollbackException, InterruptedException {
    executeCommand(runnable, Collections.emptyMap());
  }

  /**
   * Initialize the dynamic test model. This method is called in a write transaction.
   * @param skeleton the model skeleton
   */
  protected abstract void initModel(CapellaModelSkeleton skeleton2);


  /**
   * Undo the last command on the stack
   */
  protected final void undo() {
    ((TransactionalCommandStack)manager.getEditingDomain().getCommandStack()).undo();
  }

  /**
   * Creates an instance of the given class, and stores it under the given container, using the
   * default add command. Then invokes the capella creation service on the new element.
   * The creation service handles setting additional element attributes, and creation of supplementary
   * elements, the most famous one, creating a part for its component.
   * @param <T>
   * @param container
   * @param zzz
   * @return
   */
  public <T extends EObject> T create(EObject container, EClass zzz) {
    @SuppressWarnings("unchecked") T result = (T) EcoreUtil.create(zzz);
    Command command = AddCommand.create(manager.getEditingDomain(), container, null, result);
    if (command.canExecute()) {
      command.execute();
      CapellaElementExt.creationService(result);
      return result;
    }
    throw new IllegalArgumentException("Cannot add " + result + " to " + container); //$NON-NLS-1$ //$NON-NLS-2$
  }

  
}
