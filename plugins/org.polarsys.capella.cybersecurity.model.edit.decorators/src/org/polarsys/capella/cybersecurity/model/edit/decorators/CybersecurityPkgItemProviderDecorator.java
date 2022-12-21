/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.model.edit.decorators;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.common.menu.dynamic.util.DynamicCommandParameter;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.ctx.CtxFactory;
import org.polarsys.capella.core.data.epbs.EpbsFactory;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.core.data.la.LaFactory;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;

public class CybersecurityPkgItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {

  public CybersecurityPkgItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  @Override
  public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
    Collection<Object> newChildDescriptors = (Collection<Object>) super.getNewChildDescriptors(object, editingDomain,sibling);
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture((EObject) object);
    
    newChildDescriptors = newChildDescriptors.stream()
        .filter(x -> x instanceof CommandParameter && !(((CommandParameter)x).getValue() instanceof FunctionalPrimaryAsset))
        .collect(Collectors.toList());
    
    BlockArchitecture arch = createTmpArchitecture(architecture);
    FunctionalPrimaryAsset primaryAsset = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
    CybersecurityPkg pkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
    
    pkg.getOwnedPrimaryAssets().add(primaryAsset);
    if(arch != null) {
      arch.getOwnedExtensions().add(pkg);
    }
    
    String label = "Functional Primary Asset";
    if (architecture instanceof OperationalAnalysis) {
      label = "Operational Activity Primary Asset";
    }
    
    DynamicCommandParameter desc = new DynamicCommandParameter(null,
        CybersecurityPackage.Literals.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS,
        primaryAsset, label);
    newChildDescriptors.add(desc);
    
    return newChildDescriptors;
  }
  
  private BlockArchitecture createTmpArchitecture(BlockArchitecture architecture) {
    BlockArchitecture arch = null;
    Type type = BlockArchitectureExt.getBlockArchitectureType(architecture);
    switch(type) {
    case OA:
      arch = OaFactory.eINSTANCE.createOperationalAnalysis();
      break;
    case SA:
      arch = CtxFactory.eINSTANCE.createSystemAnalysis();
      break;
    case LA:
      arch = LaFactory.eINSTANCE.createLogicalArchitecture();
      break;
    case PA:
      arch = PaFactory.eINSTANCE.createPhysicalArchitecture();
      break;
    case EPBS:
      arch = EpbsFactory.eINSTANCE.createEPBSArchitecture();
      break;  
    default:
      break;
    }
    
    return arch;
  }
}
