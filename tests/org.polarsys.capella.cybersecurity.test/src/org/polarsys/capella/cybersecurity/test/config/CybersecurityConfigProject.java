/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.test.config;

import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.test.common.TransactionalEditingDomainHelper;
import org.polarsys.capella.test.diagram.tools.ju.model.EmptyProject;

public abstract class CybersecurityConfigProject extends EmptyProject {
  protected String[] threatKinds = { "Eavesdropping", "Denial of service", "Theft", "Data alteration", "Intrusion",
      "Tampering" };

  @Override
  protected void undoAllChanges() {
  }

  protected void addLiteralType(EnumerationPropertyType type, Project project, String literalName) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(literalName));
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void removeLiteralType(EnumerationPropertyType type, Project project, int index) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        type.getOwnedLiterals().remove(index);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  protected void removeAllLiteralTypes(EnumerationPropertyType type, Project project) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        type.getOwnedLiterals().clear();
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  protected void removePropertyType(EnumerationPropertyType type, Project project) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        project.getOwnedEnumerationPropertyTypes().remove(type);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void updateThreatKind(Threat threat, EnumerationPropertyLiteral literal, Project project) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        threat.setKind(literal);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  protected void updateConfidentialityValue(SecurityNeeds sn, EnumerationPropertyLiteral literal, Project project) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        sn.setConfidentialityValue(literal);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  SecurityNeeds sn = null;
  protected SecurityNeeds createSecurityNeeds(Project project, PrimaryAsset primaryAsset) {
    TransactionalEditingDomainHelper tedHelper = new TransactionalEditingDomainHelper(
        TransactionUtil.getEditingDomain(project));
    try {
      tedHelper.executeCommand(() -> {
        sn = CybersecurityFactory.eINSTANCE.createSecurityNeeds();
        primaryAsset.getOwnedExtensions().add(sn);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sn;
  }
}
