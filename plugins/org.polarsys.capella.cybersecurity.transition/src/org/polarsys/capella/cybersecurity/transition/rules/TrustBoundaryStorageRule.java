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
package org.polarsys.capella.cybersecurity.transition.rules;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.common.rules.AbstractUpdateRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 *
 */
public class TrustBoundaryStorageRule extends AbstractUpdateRule {
  
  public TrustBoundaryStorageRule() {
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE);
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE);
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__TRUSTED);
    registerUpdatedAttribute(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__RATIONALE);
  }

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE;
  }
  
  @Override
  public EClass getTargetType(EObject element, IContext context) {
    return CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE;
  }
}
