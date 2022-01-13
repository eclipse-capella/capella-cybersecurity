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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellacommon.TransfoLink;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.interaction.AbstractCapabilityRealization;
import org.polarsys.capella.core.data.interaction.InteractionFactory;
import org.polarsys.capella.core.data.interaction.InteractionPackage;
import org.polarsys.capella.core.data.migration.context.MigrationContext;
import org.polarsys.capella.core.data.migration.contribution.AbstractMigrationContribution;
import org.polarsys.capella.core.platform.sirius.ui.commands.CapellaDeleteCommand;
import org.polarsys.capella.cybersecurity.CyberSecurityViewpointHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.activator.CybersecurityModelActivator;

public class CybersecurityMigrationContribution extends AbstractMigrationContribution {
  Map<String, String> savedValues = new HashMap<>();
  Map<String, Threat> savedThreats = new HashMap<>();
  Map<EObject, String> savedThreatIdLinks = new HashMap<>();
  private CybersecurityConfiguration config;
  List<AbstractTrace> transfoToDelete = new ArrayList<>();
  List<ThreatApplication> threatApplications = new ArrayList<>();
  List<ThreatInvolvement> threatInvolvments = new ArrayList<>();
  

  @Override
  public void unaryMigrationExecute(EObject currentElement, MigrationContext context) {
    if (config != null && currentElement instanceof Threat) {
      savedThreats.put(((Threat) currentElement).getId(), (Threat) currentElement);
      threatMigration((Threat) currentElement);
    }
    if (config != null && currentElement instanceof SecurityNeeds) {
      securityNeedsMigration((SecurityNeeds) currentElement);
    }
    if (currentElement instanceof ThreatApplication) {
      threatApplications.add((ThreatApplication) currentElement);
    }
    if (currentElement instanceof ThreatInvolvement) {
      threatInvolvments.add((ThreatInvolvement) currentElement);
    }
  }

  public EStructuralFeature getFeature(EObject object, String prefix, String name, boolean isElement) {
    if (object instanceof PrimaryAsset && name.contains("ownedThreatApplications")) {
      return ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS;
    }
    if (object instanceof Component && name.contains("ownedThreatInvolvements")) {
     return ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS;
    }
    return super.getFeature(object, prefix, name, isElement);
  }

  @Override
  public void unaryStartMigrationExecute(ExecutionManager executionManager, Resource resource,
      MigrationContext context) {
    if (context.getResource().getName().contains(".afm")) {
      EList<EObject> ct = resource.getContents();
      if (!ct.isEmpty() && CyberSecurityViewpointHelper.isViewpointActive(ct.get(0))) {
        config = new CybersecurityModelActivator().createCybersecurityConfiguration();
      }
    }
  }

  @Override
  public void unaryEndMigrationExecute(ExecutionManager executionManager, Resource resource, MigrationContext context) {
    if (config != null && !resource.getContents().isEmpty() && resource.getContents().get(0) instanceof Project) {
      Project project = (Project) resource.getContents().get(0);
      if (CybersecurityQueries.getCybersecurityConfiguration(project) == null) {
        project.getOwnedExtensions().add(config);
      }
      if (!transfoToDelete.isEmpty()) {
        // delete transfo link
        CapellaDeleteCommand command = new CapellaDeleteCommand(TransactionHelper.getExecutionManager(transfoToDelete),
            transfoToDelete, false, false, true);
        if (command.canExecute()) {
          command.execute();
        }
        transfoToDelete.clear();
      }
      
      threatApplications.forEach(this::threatApplicationMigration);
      threatInvolvments.forEach(this::threatInvolvementMigration);
    }
  }

  @Override
  public boolean ignoreUnknownFeature(String prefix, String name, boolean isElement, EObject peekObject, String value,
      XMLResource resource, MigrationContext context) {
    if (peekObject instanceof Threat && "threatKind".equals(name)) {
      savedValues.put(((Threat) peekObject).getId() + ":" + name, value);
      return true;
    }
    if (peekObject instanceof SecurityNeeds) {
      savedValues.put(((SecurityNeeds) peekObject).getId() + ":" + name, value);
      return true;
    }
    if (name.equals("threat")
        && (peekObject instanceof ThreatApplication || peekObject instanceof ThreatInvolvement)) {
      savedThreatIdLinks.put(peekObject, value.substring(1));
      return true;
    }
    return false;
  }

  @Override
  public void dispose(MigrationContext context) {
    savedValues.clear();
    config = null;
  }

  private void threatMigration(Threat threat) {
    String searchValue = savedValues.get(threat.getId() + ":threatKind");
    // threat kind "Theft and data alteration" was split in "Theft" and "Data alteration"
    if (searchValue != null && searchValue.contains("THEFT")) {
      searchValue = "THEFT";
    }

    EnumerationPropertyLiteral literal = getLiteral(config.getThreatKind(), searchValue);
    if (literal != null) {
      threat.setKind(literal);
    }

    // TransfoLinks become AbstractCapabilityRealization links
    for (AbstractTrace trace : threat.getOutgoingTraces()) {
      if (trace instanceof TransfoLink) {
        AbstractCapabilityRealization link = InteractionFactory.eINSTANCE.createAbstractCapabilityRealization();
        link.setTargetElement(trace.getTargetElement());
        link.setSourceElement(trace.getSourceElement());
        ((List<EObject>) threat
            .eGet(InteractionPackage.Literals.ABSTRACT_CAPABILITY__OWNED_ABSTRACT_CAPABILITY_REALIZATIONS)).add(link);
        transfoToDelete.add(trace);
      }
    }
  }

  private void securityNeedsMigration(SecurityNeeds sn) {
    EnumerationPropertyLiteral literalC = getLiteral(config.getConfidentiality(),
        savedValues.get(sn.getId() + ":confidentiality"));
    EnumerationPropertyLiteral literalI = getLiteral(config.getIntegrity(),
        savedValues.get(sn.getId() + ":integrity"));
    EnumerationPropertyLiteral literalT = getLiteral(config.getTraceability(),
        savedValues.get(sn.getId() + ":traceability"));
    EnumerationPropertyLiteral literalA = getLiteral(config.getAvailability(),
        savedValues.get(sn.getId() + ":availability"));

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

  private void threatApplicationMigration(ThreatApplication threatApplication) {
    if (threatApplication.eContainer() instanceof PrimaryAsset) {
      PrimaryAsset asset = (PrimaryAsset) threatApplication.eContainer();
      String threatId = savedThreatIdLinks.get(threatApplication);
      Threat threat = savedThreats.get(threatId);
      if (threat != null) {
        threatApplication.setAsset(asset);
        asset.getOwnedMigratedElements().remove(threatApplication);
        threat.getOwnedThreatApplications().add(threatApplication);
      }
    }
  }

  private void threatInvolvementMigration(ThreatInvolvement threatInvolvement) {
    if (threatInvolvement.eContainer() instanceof Component) {
      Component component = (Component) threatInvolvement.eContainer();
      String threatId = savedThreatIdLinks.get(threatInvolvement);
      Threat threat = savedThreats.get(threatId);
      if (threat != null) {
        threatInvolvement.setComponent(component);
        component.getOwnedMigratedElements().remove(threatInvolvement);
        threat.getOwnedThreatInvolvements().add(threatInvolvement);
      }
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
