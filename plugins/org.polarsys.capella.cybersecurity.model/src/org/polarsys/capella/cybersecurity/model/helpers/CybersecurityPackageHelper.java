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
package org.polarsys.capella.cybersecurity.model.helpers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.model.helpers.IHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;

/**
 * @generated
 */
public class CybersecurityPackageHelper implements IHelper {

  /**
   * @generated
   */
  public Object getValue(EObject object, EStructuralFeature feature, EAnnotation annotation) {
    Object ret = null;

    if (ret == null && object instanceof CybersecurityPkg) {
      ret = CybersecurityPkgHelper.getInstance().doSwitch((CybersecurityPkg) object, feature);
    }
    if (ret == null && object instanceof Threat) {
      ret = ThreatHelper.getInstance().doSwitch((Threat) object, feature);
    }
    if (ret == null && object instanceof ThreatInvolvement) {
      ret = ThreatInvolvementHelper.getInstance().doSwitch((ThreatInvolvement) object, feature);
    }
    if (ret == null && object instanceof FunctionStorage) {
      ret = FunctionStorageHelper.getInstance().doSwitch((FunctionStorage) object, feature);
    }
    if (ret == null && object instanceof ThreatApplication) {
      ret = ThreatApplicationHelper.getInstance().doSwitch((ThreatApplication) object, feature);
    }
    if (ret == null && object instanceof PrimaryAssetStorage) {
      ret = PrimaryAssetStorageHelper.getInstance().doSwitch((PrimaryAssetStorage) object, feature);
    }
    if (ret == null && object instanceof SecurityNeeds) {
      ret = SecurityNeedsHelper.getInstance().doSwitch((SecurityNeeds) object, feature);
    }
    if (ret == null && object instanceof TrustBoundaryStorage) {
      ret = TrustBoundaryStorageHelper.getInstance().doSwitch((TrustBoundaryStorage) object, feature);
    }
    if (ret == null && object instanceof PrimaryAsset) {
      ret = PrimaryAssetHelper.getInstance().doSwitch((PrimaryAsset) object, feature);
    }
    if (ret == null && object instanceof FunctionalPrimaryAsset) {
      ret = FunctionalPrimaryAssetHelper.getInstance().doSwitch((FunctionalPrimaryAsset) object, feature);
    }
    if (ret == null && object instanceof InformationPrimaryAsset) {
      ret = InformationPrimaryAssetHelper.getInstance().doSwitch((InformationPrimaryAsset) object, feature);
    }
    if (ret == null && object instanceof PrimaryAssetMember) {
      ret = PrimaryAssetMemberHelper.getInstance().doSwitch((PrimaryAssetMember) object, feature);
    }
    if (ret == null && object instanceof CybersecurityConfiguration) {
      ret = CybersecurityConfigurationHelper.getInstance().doSwitch((CybersecurityConfiguration) object, feature);
    }
    if (ret == null && object instanceof EnterprisePrimaryAsset) {
      ret = EnterprisePrimaryAssetHelper.getInstance().doSwitch((EnterprisePrimaryAsset) object, feature);
    }
    if (ret == null && object instanceof ThreatSourceUse) {
      ret = ThreatSourceUseHelper.getInstance().doSwitch((ThreatSourceUse) object, feature);
    }
    return ret;
  }

}
