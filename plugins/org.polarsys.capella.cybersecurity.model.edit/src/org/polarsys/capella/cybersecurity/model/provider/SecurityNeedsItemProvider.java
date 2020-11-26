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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.data.modellingcore.provider.ModelElementItemProvider;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.cybersecurity.model.SecurityNeeds} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SecurityNeedsItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor confidentialityPropertyDescriptor;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor integrityPropertyDescriptor;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor availabilityPropertyDescriptor;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor traceabilityPropertyDescriptor;

  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public SecurityNeedsItemProvider(AdapterFactory adapterFactory) {
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
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY
      if (confidentialityPropertyDescriptor != null) {
        Object confidentialityValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, true);
        if (confidentialityValue != null && confidentialityValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) confidentialityValue)) {
          itemPropertyDescriptors.remove(confidentialityPropertyDescriptor);
        } else if (confidentialityValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY) != null) {
          itemPropertyDescriptors.remove(confidentialityPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(confidentialityPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(confidentialityPropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY
      if (integrityPropertyDescriptor != null) {
        Object integrityValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY, true);
        if (integrityValue != null && integrityValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) integrityValue)) {
          itemPropertyDescriptors.remove(integrityPropertyDescriptor);
        } else if (integrityValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY) != null) {
          itemPropertyDescriptors.remove(integrityPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(integrityPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(integrityPropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY
      if (availabilityPropertyDescriptor != null) {
        Object availabilityValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, true);
        if (availabilityValue != null && availabilityValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) availabilityValue)) {
          itemPropertyDescriptors.remove(availabilityPropertyDescriptor);
        } else if (availabilityValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY) != null) {
          itemPropertyDescriptors.remove(availabilityPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(availabilityPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(availabilityPropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY
      if (traceabilityPropertyDescriptor != null) {
        Object traceabilityValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, true);
        if (traceabilityValue != null && traceabilityValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) traceabilityValue)) {
          itemPropertyDescriptors.remove(traceabilityPropertyDescriptor);
        } else if (traceabilityValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY) != null) {
          itemPropertyDescriptors.remove(traceabilityPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(traceabilityPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(traceabilityPropertyDescriptor);
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

      addConfidentialityPropertyDescriptor(object);
      addIntegrityPropertyDescriptor(object);
      addAvailabilityPropertyDescriptor(object);
      addTraceabilityPropertyDescriptor(object);
    }
    // begin-extension-code
    checkChildCreationExtender(object);
    // end-extension-code
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Confidentiality feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addConfidentialityPropertyDescriptor(Object object) {
    // begin-extension-code
    confidentialityPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_confidentiality_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_confidentiality_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY, true, false, false, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(confidentialityPropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Integrity feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addIntegrityPropertyDescriptor(Object object) {
    // begin-extension-code
    integrityPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_integrity_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_integrity_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY, true, false, false, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(integrityPropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Availability feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addAvailabilityPropertyDescriptor(Object object) {
    // begin-extension-code
    availabilityPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_availability_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_availability_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY, true, false, false, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(availabilityPropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Traceability feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addTraceabilityPropertyDescriptor(Object object) {
    // begin-extension-code
    traceabilityPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_traceability_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_traceability_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY, true, false, false, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(traceabilityPropertyDescriptor);
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
   * This returns SecurityNeeds.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/SecurityNeeds")); //$NON-NLS-1$
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

    String label = ((SecurityNeeds) object).getId();
    // begin-extension-code
    return label == null || label.length() == 0 ? "[" + getString("_UI_SecurityNeeds_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

    switch (notification.getFeatureID(SecurityNeeds.class)) {
    case CybersecurityPackage.SECURITY_NEEDS__CONFIDENTIALITY:
    case CybersecurityPackage.SECURITY_NEEDS__INTEGRITY:
    case CybersecurityPackage.SECURITY_NEEDS__AVAILABILITY:
    case CybersecurityPackage.SECURITY_NEEDS__TRACEABILITY:
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
          ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_CONSTRAINTS,
          CapellacoreFactory.eINSTANCE.createConstraint());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

  }

}