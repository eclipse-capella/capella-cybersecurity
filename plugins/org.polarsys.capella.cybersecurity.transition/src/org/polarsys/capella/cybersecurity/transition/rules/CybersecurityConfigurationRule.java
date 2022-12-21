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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.system.rules.AbstractCapellaElementRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

public class CybersecurityConfigurationRule extends AbstractCapellaElementRule {

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.CYBERSECURITY_CONFIGURATION;
  }

  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    CybersecurityConfiguration element = (CybersecurityConfiguration) source;

    result.add(element.getAvailability());
    result.add(element.getConfidentiality());
    result.add(element.getIntegrity());
    result.add(element.getTraceability());

    result.add(element.getThreatKind());
  }
}
