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
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.data.modellingcore.provider.ModelElementItemProvider;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class TrustBoundaryStorageItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public TrustBoundaryStorageItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
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

      addThreatSourcePropertyDescriptor(object);
      addThreatSourceProfilePropertyDescriptor(object);
      addTrustedPropertyDescriptor(object);
      addRationalePropertyDescriptor(object);
    }
    // begin-extension-code
    checkChildCreationExtender(object);
    // end-extension-code
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Threat Source feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addThreatSourcePropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TrustBoundaryStorage_threatSource_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TrustBoundaryStorage_threatSource_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_TrustBoundaryStorage_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE, true, false, false,
        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
        // begin-extension-code
        null));
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Threat Source Profile feature. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   */
  protected void addThreatSourceProfilePropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TrustBoundaryStorage_threatSourceProfile_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TrustBoundaryStorage_threatSourceProfile_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_TrustBoundaryStorage_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE, true, false, false,
        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null,
        // begin-extension-code
        null));
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Trusted feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addTrustedPropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TrustBoundaryStorage_trusted_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TrustBoundaryStorage_trusted_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_TrustBoundaryStorage_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__TRUSTED, true, false, false,
        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
        // begin-extension-code
        null));
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Rationale feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addRationalePropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TrustBoundaryStorage_rationale_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TrustBoundaryStorage_rationale_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_TrustBoundaryStorage_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__RATIONALE, true, false, false,
        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        // begin-extension-code
        null));
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
   * This returns TrustBoundaryStorage.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/TrustBoundaryStorage")); //$NON-NLS-1$
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

    String label = ((TrustBoundaryStorage) object).getId();
    // begin-extension-code
    return label == null || label.length() == 0 ? "[" + getString("_UI_TrustBoundaryStorage_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

    switch (notification.getFeatureID(TrustBoundaryStorage.class)) {
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE:
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE:
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__TRUSTED:
    case CybersecurityPackage.TRUST_BOUNDARY_STORAGE__RATIONALE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    }
    super.notifyChanged(notification);
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

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createCybersecurityConfiguration());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

    // begin-extension-code
    {
      CommandParameter commandParameter = createChildParameter(
          ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_CONSTRAINTS,
          CapellacoreFactory.eINSTANCE.createConstraint());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

  }

}