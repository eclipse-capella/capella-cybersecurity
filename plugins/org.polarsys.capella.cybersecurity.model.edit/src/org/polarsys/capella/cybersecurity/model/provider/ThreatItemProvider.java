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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.polarsys.capella.core.data.capellacore.provider.NamedElementItemProvider;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.cybersecurity.model.Threat} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ThreatItemProvider extends NamedElementItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor kindPropertyDescriptor;

  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ThreatItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void checkChildCreationExtender(Object object) {
    super.checkChildCreationExtender(object);
    if (object instanceof EObject) {
      EObject eObject = (EObject) object;
      // Process CybersecurityPackage.Literals.THREAT__KIND
      if (kindPropertyDescriptor != null) {
        Object kindValue = eObject.eGet(CybersecurityPackage.Literals.THREAT__KIND, true);
        if (kindValue != null && kindValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) kindValue)) {
          itemPropertyDescriptors.remove(kindPropertyDescriptor);
        } else if (kindValue == null
            && ExtensionModelManager.getAnyType(eObject, CybersecurityPackage.Literals.THREAT__KIND) != null) {
          itemPropertyDescriptors.remove(kindPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(kindPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(kindPropertyDescriptor);
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

      addAddressedByPropertyDescriptor(object);
      addKindPropertyDescriptor(object);
      addLevelPropertyDescriptor(object);
      addRationalePropertyDescriptor(object);
      addRealizedThreatsPropertyDescriptor(object);
      addRealizingThreatsPropertyDescriptor(object);
    }
    // begin-extension-code
    checkChildCreationExtender(object);
    // end-extension-code
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Addressed By feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addAddressedByPropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Threat_addressedBy_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Threat_addressedBy_feature", "_UI_Threat_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CybersecurityPackage.Literals.THREAT__ADDRESSED_BY, true, false, true, null, null,
        // begin-extension-code
        null));
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Kind feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addKindPropertyDescriptor(Object object) {
    // begin-extension-code
    kindPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Threat_kind_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Threat_kind_feature", "_UI_Threat_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CybersecurityPackage.Literals.THREAT__KIND, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(kindPropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Level feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addLevelPropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Threat_level_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Threat_level_feature", "_UI_Threat_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CybersecurityPackage.Literals.THREAT__LEVEL, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
        null,
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
        getString("_UI_Threat_rationale_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Threat_rationale_feature", "_UI_Threat_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CybersecurityPackage.Literals.THREAT__RATIONALE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
        null,
        // begin-extension-code
        null));
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Realized Threats feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addRealizedThreatsPropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Threat_realizedThreats_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Threat_realizedThreats_feature", "_UI_Threat_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CybersecurityPackage.Literals.THREAT__REALIZED_THREATS, false, false, false, null, null,
        // begin-extension-code
        null));
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Realizing Threats feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addRealizingThreatsPropertyDescriptor(Object object) {

    // begin-extension-code
    itemPropertyDescriptors.add(createItemPropertyDescriptor
    // end-extension-code
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Threat_realizingThreats_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Threat_realizingThreats_feature", "_UI_Threat_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CybersecurityPackage.Literals.THREAT__REALIZING_THREATS, false, false, false, null, null,
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
   * This returns Threat.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Threat")); //$NON-NLS-1$
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

    String label = ((Threat) object).getName();
    // begin-extension-code
    return label == null || label.length() == 0 ? "[" + getString("_UI_Threat_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

    switch (notification.getFeatureID(Threat.class)) {
    case CybersecurityPackage.THREAT__KIND:
    case CybersecurityPackage.THREAT__LEVEL:
    case CybersecurityPackage.THREAT__RATIONALE:
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

  }

}