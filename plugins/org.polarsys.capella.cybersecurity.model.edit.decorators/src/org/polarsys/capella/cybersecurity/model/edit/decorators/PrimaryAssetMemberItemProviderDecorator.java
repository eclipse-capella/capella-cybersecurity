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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class PrimaryAssetMemberItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {

  public PrimaryAssetMemberItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  @Override
  public String getText(Object object) {
    if (object instanceof PrimaryAssetMember) {
      PrimaryAssetMember pam = (PrimaryAssetMember) object;
      ModelElement member = pam.getMember();
      if (member != null) {
        String memberLabel = EObjectLabelProviderHelper.getText(member);
        if (!memberLabel.isEmpty()) {
          return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_PrimaryAssetMember_type") + "] to " //$NON-NLS-1$
              + memberLabel;
        }
      }
    }

    return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_PrimaryAssetMember_type") + "]"; //$NON-NLS-1$
  }

  @Override
  public Object getImage(Object object) {
    return overlayImage(object, CybersecurityEditPlugin.INSTANCE.getImage("full/obj16/PrimaryAssetMember"));
  }

}
