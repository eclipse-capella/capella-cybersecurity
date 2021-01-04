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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.polarsys.capella.core.model.helpers.CapellaElementExt;

public class TransactionalEditingDomainHelper {

  public TransactionalEditingDomainHelper(TransactionalEditingDomain domain) {
    this.domain = domain;
  }

  private final TransactionalEditingDomain domain;
  
  /**
   * Wraps a runnable into a RecordingCommand and executes that on the editing domain for this test.
   * @param runnable
   * @param options
   * @throws RollbackException
   * @throws InterruptedException
   */
  public final void executeCommand(Runnable runnable, Map<?,?> options) throws RollbackException, InterruptedException {
    ((TransactionalCommandStack)domain.getCommandStack()).execute(new RecordingCommand(domain) {
      @Override
      protected void doExecute() {
        runnable.run();
      }
    }, options);
  }

  /**
   * Wraps a runnable into a RecordingCommand and executes that on the editing domain for this test.
   * @param runnable
   * @throws RollbackException
   * @throws InterruptedException
   */
  public final void executeCommand(Runnable runnable) throws RollbackException, InterruptedException {
    executeCommand(runnable, Collections.emptyMap());
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
    Command command = AddCommand.create(domain, container, null, result);
    if (command.canExecute()) {
      command.execute();
      CapellaElementExt.creationService(result);
      return result;
    }
    throw new IllegalArgumentException("Cannot add " + result + " to " + container); //$NON-NLS-1$ //$NON-NLS-2$
  }
  
  
}
