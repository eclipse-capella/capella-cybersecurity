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

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.model.helpers.ModelQueryHelper;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;

/**
 * Perform an automated transition of Operational Activities.
 */
public class PAPerformAutomatedTransitionAdapter extends PerformAutomatedTransitionAdapter {
  @Override
  public ModelElement getModelElement(EObject rootSemanticModel) {
    if (rootSemanticModel instanceof Project) {
      return new CybersecurityServices().getDefaultCyberSecurityPackage(ModelQueryHelper.getRootLogicalFunction((Project) rootSemanticModel), false);
    }
    return null;
  }
}
