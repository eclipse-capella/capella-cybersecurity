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

package org.polarsys.capella.cybersecurity.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.core.data.capellacore.provider.RelationshipItemProvider;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.data.modellingcore.provider.ModelElementItemProvider;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.ThreatApplication;
import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.cybersecurity.model.ThreatApplication} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ThreatApplicationItemProvider extends RelationshipItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor threatPropertyDescriptor;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor assetPropertyDescriptor;

  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ThreatApplicationItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void checkChildCreationExtender(Object object) {
    super.checkChildCreationExtender(object);
    if (object instanceof EObject) {
      EObject eObject = (EObject) object;
      // Process CybersecurityPackage.Literals.THREAT_APPLICATION__THREAT
      if (threatPropertyDescriptor != null) {
        Object threatValue = eObject.eGet(CybersecurityPackage.Literals.THREAT_APPLICATION__THREAT, true);
        if (threatValue != null && threatValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) threatValue)) {
          itemPropertyDescriptors.remove(threatPropertyDescriptor);
        } else if (threatValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.THREAT_APPLICATION__THREAT) != null) {
          itemPropertyDescriptors.remove(threatPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(threatPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(threatPropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.THREAT_APPLICATION__ASSET
      if (assetPropertyDescriptor != null) {
        Object assetValue = eObject.eGet(CybersecurityPackage.Literals.THREAT_APPLICATION__ASSET, true);
        if (assetValue != null && assetValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) assetValue)) {
          itemPropertyDescriptors.remove(assetPropertyDescriptor);
        } else if (assetValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.THREAT_APPLICATION__ASSET) != null) {
          itemPropertyDescriptors.remove(assetPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(assetPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(assetPropertyDescriptor);
        }
      }
    }
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addThreatPropertyDescriptor(object);
      addAssetPropertyDescriptor(object);
    }
    // begin-extension-code
    checkChildCreationExtender(object);
    // end-extension-code
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Threat feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addThreatPropertyDescriptor(Object object) {
    // begin-extension-code
    threatPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_ThreatApplication_threat_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_ThreatApplication_threat_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_ThreatApplication_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.THREAT_APPLICATION__THREAT, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(threatPropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Asset feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addAssetPropertyDescriptor(Object object) {
    // begin-extension-code
    assetPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_ThreatApplication_asset_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_ThreatApplication_asset_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_ThreatApplication_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.THREAT_APPLICATION__ASSET, false, false, false, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(assetPropertyDescriptor);
    // end-extension-code
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean hasChildren(Object object) {
    return hasChildren(object, true);
  }

  /**
   * This returns ThreatApplication.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ThreatApplication")); //$NON-NLS-1$
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean shouldComposeCreationImage() {
    return true;
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {

    String label = ((ThreatApplication) object).getId();
    // begin-extension-code
    return label == null || label.length() == 0 ? "[" + getString("_UI_ThreatApplication_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    // end-extension-code
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createCybersecurityPkg());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createThreatInvolvement());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createFunctionStorage());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createThreatApplication());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createPrimaryAssetStorage());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createSecurityNeeds());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createTrustBoundaryStorage());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

  }

}