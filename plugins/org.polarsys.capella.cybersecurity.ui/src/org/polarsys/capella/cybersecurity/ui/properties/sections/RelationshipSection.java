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
package org.polarsys.capella.cybersecurity.ui.properties.sections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.core.properties.sections.CapellaElementSection;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;

public class RelationshipSection extends CapellaElementSection {

  @Override
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);
    return eObjectToTest instanceof ThreatInvolvement || eObjectToTest instanceof ThreatApplication || eObjectToTest instanceof PrimaryAssetMember;
  }

}
