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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class ThreatUseItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {

  public ThreatUseItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  @Override
  public String getText(Object object) {
    if (object instanceof ThreatSourceUse) {
      ThreatSourceUse tu = (ThreatSourceUse) object;
      Component usedActor = tu.getUsed();
      if (usedActor != null) {
        String threatLabel = EObjectLabelProviderHelper.getText(usedActor);
        if (!threatLabel.isEmpty()) {
          return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_ThreatSourceUse_type") + "] to " //$NON-NLS-1$
              + threatLabel;
        }
      }
    }

    return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_ThreatSourceUse_type") + "]"; //$NON-NLS-1$
  }

}