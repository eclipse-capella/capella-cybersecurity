/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.model.edit.decorators;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class PrimaryAssetStorageItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {
  
  public PrimaryAssetStorageItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  @Override
  public String getText(Object object) {
    return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_PrimaryAssetStorage_type") + "]"; //$NON-NLS-1$
  }

}
