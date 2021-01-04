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

import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.polarsys.capella.core.data.gen.edit.decorators.CustomDecoratorAdapterFactory;
import org.polarsys.capella.core.data.gen.edit.decorators.ForwardingItemProviderAdapterDecorator;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetStorage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.capella.cybersecurity.model.ThreatInvolvement;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.model.provider.CybersecurityItemProviderAdapterFactory;

public class CybersecurityItemProviderDecoratorAdapterFactory extends CustomDecoratorAdapterFactory {

  public CybersecurityItemProviderDecoratorAdapterFactory() {
    super(new CybersecurityItemProviderAdapterFactory());
  }

  @Override
  protected IItemProviderDecorator createItemProviderDecorator(Object target, Object Type) {
    if (target instanceof FunctionStorage) {
      return new FunctionStorageItemProviderDecorator(this);
    } else if (target instanceof PrimaryAssetMember) {
      return new PrimaryAssetMemberItemProviderDecorator(this);
    } else if (target instanceof PrimaryAssetStorage) {
      return new PrimaryAssetStorageItemProviderDecorator(this);
    } else if (target instanceof SecurityNeeds) {
      return new SecurityNeedsItemProviderDecorator(this);
    } else if (target instanceof ThreatApplication) {
      return new ThreatApplicationItemProviderDecorator(this);
    } else if (target instanceof ThreatInvolvement) {
      return new ThreatInvolvementItemProviderDecorator(this);
    } else if (target instanceof TrustBoundaryStorage) {
      return new TrustBoundaryStorageItemProviderDecorator(this);
    } else if (target instanceof FunctionalPrimaryAsset) {
      return new FunctionalPrimaryAssetProviderDecorator(this);
    } else if (target instanceof InformationPrimaryAsset) {
      return new InformationPrimaryAssetProviderDecorator(this);
    }

    return new ForwardingItemProviderAdapterDecorator(this);
  }
}
