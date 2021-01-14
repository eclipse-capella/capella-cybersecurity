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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeSpec;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.viewpoint.description.RepresentationElementMapping;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.migration.context.MigrationContext;
import org.polarsys.capella.core.data.migration.contribution.AbstractMigrationContribution;
import org.polarsys.capella.cybersecurity.CyberSecurityViewpointHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.activator.CybersecurityModelActivator;

public class CybersecurityMigrationContribution extends AbstractMigrationContribution {
  Map<String, String> savedValues = new HashMap<>();
  private CybersecurityConfiguration config;

  @Override
  public void unaryMigrationExecute(EObject currentElement, MigrationContext context) {
    if (config != null && currentElement instanceof Threat) {
      threatMigration((Threat) currentElement);
    }
    if (config != null && currentElement instanceof SecurityNeeds) {
      securityNeedsMigration((SecurityNeeds) currentElement);
    }
  }

  @Override
  public String getQName(EObject peekObject, String typeQName, EStructuralFeature feature, Resource resource,
      XMLHelper helper, MigrationContext context) {
    if (typeQName.equals("style:SquareDescription") && peekObject instanceof DNode
        && ((DNode) peekObject).getTarget() instanceof PrimaryAsset) {
      return "style:EllipseNodeDescription";
    }
    if (typeQName.equals("diagram:Square") && peekObject instanceof DNode
        && ((DNode) peekObject).getTarget() instanceof PrimaryAsset) {
      return "diagram:Ellipse";
    }
    return super.getQName(peekObject, typeQName, feature, resource, helper, context);
  }

  @Override
  public void updateCreatedObject(EObject peekObject, EObject eObject, String typeQName, EStructuralFeature feature,
      XMLResource resource, XMLHelper helper, MigrationContext context) {
    if (typeQName.contains("notation:Node")) {
      if (peekObject instanceof Node) {
        for (Object child : ((Node) peekObject).getChildren()) {
          if (child instanceof Node) {
            Node node = (Node) child;
            if (node.getType().equals("3003")) {
              node.setType("3016");
            }
          }
        }
      }
    }
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
  }

  private void securityNeedsMigration(SecurityNeeds sn) {
    EnumerationPropertyLiteral literalC = getLiteral(config.getConfidentiality(),
        savedValues.get(sn.getId() + ":confidentiality"));
    EnumerationPropertyLiteral literalI = getLiteral(config.getIntegrity(), savedValues.get(sn.getId() + ":integrity"));
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
