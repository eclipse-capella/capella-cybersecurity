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
package org.polarsys.capella.cybersecurity.model.edit.decorators;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class FunctionalPrimaryAssetProviderDecorator extends ItemProviderAdapterDecorator implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  
  private static final String OA_PRIMARY_ASSETS_PREFIX = "OperationalActivity";
  private static final String FUNCTIONAL_PRIMARY_ASSETS_PREFIX = "Functional";

  public FunctionalPrimaryAssetProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }
  
  @Override
  public Object getImage(Object object) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture((EObject)object);
    String image = "full/obj16/FunctionalPrimaryAssetDecorated";
    if (architecture instanceof OperationalAnalysis) {
      image = "full/obj16/OperationalActivityPrimaryAssetDecorated";
    }
    
    return overlayImage(object, CybersecurityEditPlugin.INSTANCE.getImage(image));
  }
  
  @Override
  public String getText(Object object) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture((EObject)object);
    String text = super.getText(object);
    if (architecture instanceof OperationalAnalysis) {
      text = text.replace(FUNCTIONAL_PRIMARY_ASSETS_PREFIX, OA_PRIMARY_ASSETS_PREFIX);
    }
    return text;
  }
}
