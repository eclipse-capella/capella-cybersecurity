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
package org.polarsys.capella.cybersecurity.helpers;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.core.model.handler.command.IDeleteHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;

/**
 *
 */
public class CyberSecurityDeleteHelper implements IDeleteHelper {

  @Override
  public Collection<?> getExpandedSelection(Collection<?> selection) {
    return Collections.emptyList();
  }

  @Override
  public boolean isDeleteSemanticStructure(EObject sourceObject, EObject linkObject, EStructuralFeature feature) {
    if (sourceObject instanceof PrimaryAssetMember
        && feature == CybersecurityPackage.Literals.PRIMARY_ASSET_MEMBER__MEMBER) {
      return true;
    } else if (sourceObject instanceof ThreatApplication
        && feature == CybersecurityPackage.Literals.THREAT_APPLICATION__THREAT_OBJ) {
      return true;
    } else if (sourceObject instanceof ThreatInvolvement
        && feature == CybersecurityPackage.Literals.THREAT_INVOLVEMENT__THREAT_OBJ) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isDeleteElement(EObject sourceObject, EObject linkObject, EStructuralFeature feature) {
    return false;
  }

  @Override
  public Collection<EObject> getAdditionalElements(EObject sourceObject, EObject linkObject,
      EStructuralFeature feature) {
    return Collections.emptyList();
  }

  @Override
  public Collection<Command> getAdditionalCommands(EObject sourceObject, EObject linkObject,
      EStructuralFeature feature) {
    return Collections.emptyList();
  }

}
