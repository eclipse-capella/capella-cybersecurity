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
package org.polarsys.capella.cybersecurity.ui.contribution.migration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.migration.context.MigrationContext;
import org.polarsys.capella.core.data.migration.contribution.AbstractMigrationContribution;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.activator.CybersecurityModelActivator;

public class CybersecurityMigrationContribution extends AbstractMigrationContribution {
  Map<String, String> savedValues = new HashMap<>();
  Project project;

  @Override
  public void unaryMigrationExecute(EObject currentElement, MigrationContext context) {
    if (currentElement instanceof Project && !savedValues.isEmpty()) {
      project = (Project) currentElement;
      if ((CybersecurityQueries.getCybersecurityConfiguration(project) == null)) {
        new CybersecurityModelActivator().addProjectCybersecurityConfig(project);
      }
    }

    if (project != null && currentElement instanceof Threat) {
      threatMigration((Threat) currentElement);
    }
    if (project != null && currentElement instanceof SecurityNeeds) {
      securityNeedsMigration((SecurityNeeds) currentElement);
    }
  }

  @Override
  public boolean ignoreUnknownFeature(String prefix, String name, boolean isElement, EObject peekObject, String value,
      XMLResource resource, MigrationContext context) {
    if (peekObject instanceof Threat && "threatKind".equals(name)) {
      savedValues.put(peekObject.hashCode() + ":" + name, value);
      return true;
    }
    if (peekObject instanceof SecurityNeeds) {
      savedValues.put(peekObject.hashCode() + ":" + name, value);
      return true;
    }
    return false;
  }

  @Override
  public void dispose(MigrationContext context) {
    savedValues.clear();
    project = null;
  }

  private void threatMigration(Threat threat) {
    EnumerationPropertyLiteral literal = getLiteral(CybersecurityQueries.getThreatKindPropertyType(project),
        savedValues.get(threat.hashCode() + ":threatKind"));

    if (literal != null) {
      threat.setKind(literal);
    }
  }

  private void securityNeedsMigration(SecurityNeeds sn) {
    EnumerationPropertyLiteral literalC = getLiteral(CybersecurityQueries.getConfidentialityPropertyType(project),
        savedValues.get(sn.hashCode() + ":confidentiality"));
    EnumerationPropertyLiteral literalI = getLiteral(CybersecurityQueries.getIntegrityPropertyType(project),
        savedValues.get(sn.hashCode() + ":integrity"));
    EnumerationPropertyLiteral literalT = getLiteral(CybersecurityQueries.getTraceabilityPropertyType(project),
        savedValues.get(sn.hashCode() + ":traceability"));
    EnumerationPropertyLiteral literalA = getLiteral(CybersecurityQueries.getAvailabilityPropertyType(project),
        savedValues.get(sn.hashCode() + ":availability"));

    if (literalC != null) {
      sn.setConfidentialityValue(literalC);
    }
    if (literalI != null) {
      sn.setIntegrityValue(literalI);
    }
    if (literalT != null) {
      sn.setTraceabilityValue(literalT);
    }
    if (literalA != null) {
      sn.setAvailabilityValue(literalA);
    }
  }

  private EnumerationPropertyLiteral getLiteral(EnumerationPropertyType type, String value) {
    if (value != null && type != null) {
      Optional<EnumerationPropertyLiteral> result = type.getOwnedLiterals().stream()
          .filter(
              literal -> literal.getName() != null && literal.getName().equalsIgnoreCase(value.replaceAll("_", " ")))
          .findAny();
      if (result.isPresent()) {
        return result.get();
      }
    }
    return null;
  }
}
