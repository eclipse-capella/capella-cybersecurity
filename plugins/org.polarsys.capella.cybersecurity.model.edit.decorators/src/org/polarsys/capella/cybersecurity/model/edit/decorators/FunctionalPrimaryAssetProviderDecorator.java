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

import java.util.Arrays;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.core.data.capellamodeller.provider.CapellaModellerEditPlugin;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class FunctionalPrimaryAssetProviderDecorator extends ItemProviderAdapterDecorator implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

  public FunctionalPrimaryAssetProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }
  
  @Override
  public Object getImage(Object object) {
    BlockArchitecture architecture = BlockArchitectureExt.getRootBlockArchitecture((EObject)object);
    String image = "full/obj16/PhysicalFunction";
    if (architecture instanceof OperationalAnalysis) {
      image = "full/obj16/OperationalActivity";
    } else if (architecture instanceof SystemAnalysis) {
      image = "full/obj16/SystemFunction";
    } else if (architecture instanceof LogicalArchitecture) {
      image = "full/obj16/LogicalFunction";
    }
    return new ComposedImage(Arrays.asList(CapellaModellerEditPlugin.INSTANCE.getImage(image),
        CybersecurityEditPlugin.INSTANCE.getImage("full/ovr16/PrimaryAssetDecorator")));
  }
}
