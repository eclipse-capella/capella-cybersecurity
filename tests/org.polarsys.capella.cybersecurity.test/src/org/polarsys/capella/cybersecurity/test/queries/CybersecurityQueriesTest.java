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

import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.test.framework.api.NonDirtyTestCase;

public abstract class CybersecurityQueriesTest extends NonDirtyTestCase {
  Session session;
  Project project;
  BlockArchitecture oaArch;
  BlockArchitecture saArch;
  BlockArchitecture laArch;
  BlockArchitecture paArch;
  ExchangeItem eiOA;
  ExchangeItem eiSA;
  ExchangeItem eiLA;

  protected void init() {
    session = getSession(getRequiredTestModels().get(0));
    project = SessionHelper.getCapellaProject(session);

    oaArch = BlockArchitectureExt.getBlockArchitecture(Type.OA, project);
    saArch = BlockArchitectureExt.getBlockArchitecture(Type.SA, project);
    laArch = BlockArchitectureExt.getBlockArchitecture(Type.LA, project);
    paArch = BlockArchitectureExt.getBlockArchitecture(Type.PA, project);

    eiOA = InformationFactory.eINSTANCE.createExchangeItem();
    eiSA = InformationFactory.eINSTANCE.createExchangeItem();
    eiLA = InformationFactory.eINSTANCE.createExchangeItem();

    AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        BlockArchitectureExt.getInterfacePkg(oaArch, false).getOwnedExchangeItems().add(eiOA);
        BlockArchitectureExt.getInterfacePkg(saArch, false).getOwnedExchangeItems().add(eiSA);
        BlockArchitectureExt.getInterfacePkg(laArch, false).getOwnedExchangeItems().add(eiLA);
      }
    };
    TransactionHelper.getExecutionManager(project).execute(cmd);
  }

  protected abstract void doTest();

  @Override
  public void test() throws Exception {
    init();
    doTest();
  }

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }
}
