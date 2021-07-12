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

package org.polarsys.capella.cybersecurity.ui.properties.sections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.polarsys.capella.core.data.core.properties.sections.NamedElementSection;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.cybersecurity.CyberSecurityViewpointHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

public class SecurityAwareNamedElementSection extends NamedElementSection {

  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);
    if (super.select(toTest) && CyberSecurityViewpointHelper.isViewpointActive(eObjectToTest)) {
      if (eObjectToTest instanceof AbstractFunction || eObjectToTest instanceof FunctionalExchange
          || eObjectToTest instanceof Component || eObjectToTest instanceof ComponentExchange || eObjectToTest instanceof ExchangeItem) {
        return true;
      }
      if (eObjectToTest instanceof SecurityNeeds || eObjectToTest instanceof FunctionStorage
          || eObjectToTest instanceof TrustBoundaryStorage || eObjectToTest instanceof PrimaryAssetStorage) {
        return false;
      }
      
      EPackage pkg = eObjectToTest.eClass().getEPackage();
      if (CybersecurityPackage.eINSTANCE.equals(pkg)) {
        return true;
      }
    }
    return false;
  }
}
