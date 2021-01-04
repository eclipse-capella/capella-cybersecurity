/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.model.activator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.libraries.manager.LibraryManager;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.libraries.model.ICapellaModel;
import org.polarsys.capella.cybersecurity.model.CybersecurityConfiguration;
import org.polarsys.capella.cybersecurity.model.impl.CybersecurityFactoryImpl;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager.OverallListener2;
import org.polarsys.kitalpha.resourcereuse.model.Resource;

public class CybersecurityModelActivator implements BundleActivator {

  public static final String PLUGIN_ID = "org.polarsys.capella.cybersecurity.model"; //$NON-NLS-1$

  private static BundleContext context;
  private static CybersecurityModelActivator defaultActivator;
  private static OverallListener2 listener;
  
  public static final String CYBERSECURITY_CFG_KEYWORD = "Cybersecurity Configuration";
  public static final String CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD = "Security.Confidentiality";
  public static final String CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD = "Security.Integrity";
  public static final String CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD = "Security.Traceability";
  public static final String CYBERSECURITY_CFG_SECURITY_AVAILABILITY_KEYWORD = "Security.Availability";
  
  public static final String CYBERSECURITY_CFG_THREAD_KIND_KEYWORD = "Thread.Kind";
  public static final String THREAT_KIND_EAVESDROPPING_KEYWORD = "Eavesdropping";
  public static final String THREAT_KIND_THEFT_KEYWORD = "Theft";
  public static final String THREAT_KIND_DATA_ALTERATION_KEYWORD = "Data alteration";
  public static final String THREAT_KIND_DENIAL_OF_SERVICE_KEYWORD = "Denial of service";
  public static final String THREAT_KIND_INTRUSION_KEYWORD = "Intrusion";
  public static final String THREAT_KIND_TAMPERING_KEYWORD = "Tampering";
  
  public CybersecurityModelActivator() {
    listener = new OverallListener2() {
      @Override
      public void handleReferencing(Object ctx, Resource vp) {
        TransactionalEditingDomain ted = TransactionUtil.getEditingDomain(ctx);
        Object model = LibraryManager.INSTANCE.getModel(ted);
        if (model instanceof ICapellaModel) {
          Project project = ((ICapellaModel) model).getProject(ted);
          AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
            public void run() {
              addProjectCybersecurityConfig(project);
            }
          };
          TransactionHelper.getExecutionManager((EObject)project).execute(command);
        }
      }

      @Override
      public void handleUnReferencing(Object ctx, Resource vp) {
      }

      @Override
      public void handleActivation(Object ctx, Resource vp) {
      }

      @Override
      public void handleInactivation(Object ctx, Resource vp) {
      }

    };
  }

  static BundleContext getContext() {
    return context;
  }

  public static CybersecurityModelActivator getDefault() {
    return defaultActivator;
  }

  /*
   * (non-Javadoc)
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext )
   */
  @Override
  public void start(BundleContext bundleContext) throws Exception {
    CybersecurityModelActivator.context = bundleContext;
    defaultActivator = this;
    ViewpointManager.addOverallListener(listener);
  }

  /*
   * (non-Javadoc)
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    defaultActivator = null;
    CybersecurityModelActivator.context = null;
    ViewpointManager.removeOverallListener(listener);
  }
  
  public void addProjectCybersecurityConfig(Project project_p) {
    CybersecurityConfiguration config = CybersecurityFactoryImpl.eINSTANCE.createCybersecurityConfiguration();
    config.setName(CYBERSECURITY_CFG_KEYWORD);
    config.setConfidentiality(createEnumerationPropertySecurityType(CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD, config));
    config.setIntegrity(createEnumerationPropertySecurityType(CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD, config));
    config.setTraceability(createEnumerationPropertySecurityType(CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD, config));
    config.setAvailability(createEnumerationPropertySecurityType(CYBERSECURITY_CFG_SECURITY_AVAILABILITY_KEYWORD, config));
    config.setThreatKind(createEnumerationPropertyThreadKindType(CYBERSECURITY_CFG_THREAD_KIND_KEYWORD, config));
    project_p.getOwnedExtensions().add(config); 
  }
  
  private EnumerationPropertyType createEnumerationPropertySecurityType(String typeName,  CybersecurityConfiguration config) {
    EnumerationPropertyType type = CapellacoreFactory.eINSTANCE.createEnumerationPropertyType(typeName);
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("0"));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("1"));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("2"));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("3"));
    config.getOwnedEnumerationPropertyTypes().add(type);
    return type;
  }
  
  private EnumerationPropertyType createEnumerationPropertyThreadKindType(String typeName, CybersecurityConfiguration config) {
    EnumerationPropertyType type = CapellacoreFactory.eINSTANCE.createEnumerationPropertyType(typeName);
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(THREAT_KIND_EAVESDROPPING_KEYWORD));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(THREAT_KIND_DENIAL_OF_SERVICE_KEYWORD));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(THREAT_KIND_THEFT_KEYWORD));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(THREAT_KIND_DATA_ALTERATION_KEYWORD));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(THREAT_KIND_INTRUSION_KEYWORD));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral(THREAT_KIND_TAMPERING_KEYWORD));
    config.getOwnedEnumerationPropertyTypes().add(type);
    return type;
  }
}
