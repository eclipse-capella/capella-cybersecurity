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
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.impl.CybersecurityFactoryImpl;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager.OverallListener2;
import org.polarsys.kitalpha.resourcereuse.model.Resource;

public class CybersecurityModelActivator implements BundleActivator {

  public static final String PLUGIN_ID = "org.polarsys.capella.cybersecurity.model"; //$NON-NLS-1$

  private static BundleContext context;
  private static CybersecurityModelActivator defaultActivator;
  private static OverallListener2 listener;
  
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
          if(project instanceof EObject) {
            System.out.println(ted);
          }
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
    CybersecurityPkg pkg = CybersecurityFactoryImpl.eINSTANCE.createCybersecurityPkg();
    pkg.setName(CybersecurityQueries.CYBERSECURITY_CFG_KEYWORD);
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CybersecurityQueries.CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD));
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CybersecurityQueries.CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD));
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CybersecurityQueries.CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD));
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CybersecurityQueries.CYBERSECURITY_CFG_SECURITY_AVAILABILITY_KEYWORD));
    project_p.getOwnedExtensions().add(pkg); 
  }
  
  private EnumerationPropertyType createEnumerationPropertyType(String typeName) {
    EnumerationPropertyType type = CapellacoreFactory.eINSTANCE.createEnumerationPropertyType(typeName);
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("0"));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("1"));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("2"));
    type.getOwnedLiterals().add(CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral("3"));
    return type;
  }
}
