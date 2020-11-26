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
package org.polarsys.capella.cybersecurity.ui;

import java.util.List;

import org.eclipse.amalgam.explorer.activity.ui.api.manager.ActivityExplorerManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.platform.sirius.ui.project.NewProjectWizard;
import org.polarsys.capella.core.platform.sirius.ui.project.internal.WizardNewProjectCreationPage;
import org.polarsys.capella.core.platform.sirius.ui.project.operations.ProjectSessionCreationHelper;
import org.polarsys.capella.core.platform.sirius.ui.project.operations.SessionCreationHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.impl.CybersecurityFactoryImpl;
import org.polarsys.kitalpha.ad.services.manager.ViewpointActivationException;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;
import org.polarsys.kitalpha.ad.viewpoint.predicate.exceptions.EvaluationException;

public class CybersecurityProjectWizard extends NewProjectWizard {

  @Override
  protected WizardNewProjectCreationPage createLocalProjectDescriptionPage() {
    WizardNewProjectCreationPage page = super.createLocalProjectDescriptionPage();
    page.setDescription(Messages.CybersecurityProjectWizard_description);
    page.setTitle(Messages.CybersecurityProjectWizard_title);
    return page;
  }
  
  @Override
  protected SessionCreationHelper createSessionCreationHelper() {
    return new ProjectSessionCreationHelper(modelPage.isEpbsSelected(), modelPage.isOpaSelected(),
        getProjectApproach()) {

      @Override
      public Session createAirdSession(List<IFile> semanticFiles, URI airdResourceURI, IProgressMonitor monitor) {
        Session sess = super.createAirdSession(semanticFiles, airdResourceURI, monitor);
        try {
          ViewpointManager.getInstance(sess.getTransactionalEditingDomain().getResourceSet())
              .activate(CybersecurityUIActivator.VIEWPOINT_ID);
        } catch (ViewpointActivationException | EvaluationException e) {
          CybersecurityUIActivator.getDefault().getLog().log(new Status(IStatus.ERROR,
              CybersecurityUIActivator.getDefault().getBundle().getSymbolicName(), e.getMessage(), e));
        }
        return sess;
      }

    };
  }
  
  @Override
  public boolean performFinish() {
    boolean result = super.performFinish();
    
    EObject rootModel = ActivityExplorerManager.INSTANCE.getRootSemanticModel();
    AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
      public void run() {
        if(rootModel instanceof Project)
          addProjectCybersecurityConfig((Project)rootModel);
      }
    };
    TransactionHelper.getExecutionManager(rootModel).execute(command);
 
    return result;
  }
  
  public void addProjectCybersecurityConfig(Project project_p) {
    CybersecurityPkg pkg = CybersecurityFactoryImpl.eINSTANCE.createCybersecurityPkg();
    pkg.setName(CommonHelpers.CYBERSECURITY_CFG_KEYWORD);
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CommonHelpers.CYBERSECURITY_CFG_SECURITY_CONFIDENTIALITY_KEYWORD));
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CommonHelpers.CYBERSECURITY_CFG_SECURITY_INTEGRITY_KEYWORD));
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CommonHelpers.CYBERSECURITY_CFG_SECURITY_TRACEABILITY_KEYWORD));
    pkg.getOwnedEnumerationPropertyTypes().add(createEnumerationPropertyType(CommonHelpers.CYBERSECURITY_CFG_SECURITY_AVIABILITY_KEYWORD));
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
