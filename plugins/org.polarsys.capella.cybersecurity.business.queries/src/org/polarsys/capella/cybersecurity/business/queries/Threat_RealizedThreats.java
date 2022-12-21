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
package org.polarsys.capella.cybersecurity.business.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.interaction.AbstractCapabilityRealization;
import org.polarsys.capella.core.data.interaction.InteractionPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;

public class Threat_RealizedThreats extends CybersecurityRealizedElements {

  public Threat_RealizedThreats() {
    super(
        InteractionPackage.Literals.ABSTRACT_CAPABILITY__OWNED_ABSTRACT_CAPABILITY_REALIZATIONS,
        Threat.class::isInstance,
        CybersecurityPackage.Literals.THREAT);
  }

  @Override
  public EClass getExtensionClass() {
    return CybersecurityPackage.Literals.THREAT;
  }
  
  @Override
  protected List<EObject> getTargetElements(List<EObject> list) {
    List<EObject> result = new ArrayList<EObject>();
    for (EObject obj : list) {
      if (obj instanceof AbstractCapabilityRealization) {
        AbstractCapabilityRealization link = (AbstractCapabilityRealization) obj;
        result.add(link.getRealizedCapability());
      }
    }
    return result;
  }
}
