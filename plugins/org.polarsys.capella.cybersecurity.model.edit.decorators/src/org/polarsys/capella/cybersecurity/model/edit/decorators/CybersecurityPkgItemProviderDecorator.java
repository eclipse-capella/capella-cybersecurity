/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
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
    if (architecture instanceof OperationalAnalysis) {
      newChildDescriptors = newChildDescriptors.stream()
        .filter(x -> x instanceof CommandParameter && !(((CommandParameter)x).getValue() instanceof FunctionalPrimaryAsset))
        .collect(Collectors.toList());
      
      OperationalAnalysis operationalAnalysis =  OaFactory.eINSTANCE.createOperationalAnalysis();
      FunctionalPrimaryAsset primaryAsset = CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
      CybersecurityPkg pkg = CybersecurityFactory.eINSTANCE.createCybersecurityPkg();
      
      pkg.getOwnedPrimaryAssets().add(primaryAsset);
      operationalAnalysis.getOwnedExtensions().add(pkg);
      DynamicCommandParameter desc = new DynamicCommandParameter(null,
          CybersecurityPackage.Literals.CYBERSECURITY_PKG__OWNED_PRIMARY_ASSETS,
          primaryAsset, "Operational Activity Primary Asset");
      
      newChildDescriptors.add(desc);
    }
    return newChildDescriptors;
  }
}
