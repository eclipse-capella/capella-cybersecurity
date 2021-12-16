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