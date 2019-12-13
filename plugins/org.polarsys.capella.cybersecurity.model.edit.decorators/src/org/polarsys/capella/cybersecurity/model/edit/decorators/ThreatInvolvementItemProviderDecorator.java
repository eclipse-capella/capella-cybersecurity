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
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.gen.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityEditPlugin;

public class ThreatInvolvementItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {

  public ThreatInvolvementItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  @Override
  public String getText(Object object) {
    if (object instanceof ThreatInvolvement) {
      ThreatInvolvement ti = (ThreatInvolvement) object;
      Threat threat = ti.getThreat();
      if (threat != null) {
        String threatLabel = EObjectLabelProviderHelper.getText(threat);
        if (!threatLabel.isEmpty()) {
          return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_ThreatInvolvement_type") + "] to " //$NON-NLS-1$
              + threatLabel;
        }
      }
    }

    return "[" + CybersecurityEditPlugin.INSTANCE.getString("_UI_PrimaryAssetMember_type") + "]"; //$NON-NLS-1$
  }

}
