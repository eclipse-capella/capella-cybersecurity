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
package org.polarsys.capella.cybersecurity.ui.activity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellacommon.AbstractCapabilityPkg;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.ctx.CtxPackage;
import org.polarsys.capella.core.data.interaction.AbstractCapability;
import org.polarsys.capella.core.data.la.CapabilityRealizationPkg;
import org.polarsys.capella.core.data.la.LaPackage;
import org.polarsys.capella.core.data.oa.OaPackage;
import org.polarsys.capella.core.data.oa.OperationalCapabilityPkg;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.ModelCreationHelper;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.ui.toolkit.helpers.SelectionDialogHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

// from ModelCreationHelper
public class ScenarioCreationHelper {

  public static AbstractCapability selectCapability(final Project project, BlockArchitecture architecture) {
    AbstractCapability[] result = new AbstractCapability[1];
    List<EObject> all = getAllAbstractCapabitilies(project, architecture);

    AbstractCapabilityPkg capabilityPkg = BlockArchitectureExt.getAbstractCapabilityPkg(architecture);
    if (capabilityPkg != null) {
      if (!all.isEmpty()) {
        Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
        result[0] = (AbstractCapability) SelectionDialogHelper
            .simplePropertySelectionDialogWizard(new ArrayList<EObject>(all), shell);
        return result[0];
      }
      // No capability found, let's create a new one.
      AbstractReadWriteCommand cmd = new AbstractReadWriteCommand() {
        @Override
        public void run() {
          result[0] = ModelCreationHelper.createAbstractCapability(capabilityPkg);
        }
      };
      TransactionHelper.getExecutionManager(project).execute(cmd);

    }
    return result[0];
  }
  
  public static List<EObject> getAllAbstractCapabitilies(final Project project, BlockArchitecture architecture) {
    List<EObject> result = new ArrayList<>();

    // add Threats
    CybersecurityPkg cyberPkg = new CybersecurityServices().getDefaultCyberSecurityPackage(architecture, false);
    if (cyberPkg != null) {
      result.addAll(cyberPkg.getOwnedThreats());
    }

    // add Capabilities
    AbstractCapabilityPkg capabilityPkg = BlockArchitectureExt.getAbstractCapabilityPkg(architecture);
    if (capabilityPkg != null) {
      EClass clazz = CtxPackage.Literals.CAPABILITY;
      if (capabilityPkg instanceof CapabilityRealizationPkg) {
        clazz = LaPackage.Literals.CAPABILITY_REALIZATION;
      } else if (capabilityPkg instanceof OperationalCapabilityPkg) {
        clazz = OaPackage.Literals.OPERATIONAL_CAPABILITY;
      }
      result.addAll(EObjectExt.getAll(capabilityPkg, clazz));
    }

    return result;
  }
 
}
