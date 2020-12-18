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
  protected IItemPropertyDescriptor confidentialityValuePropertyDescriptor;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor integrityValuePropertyDescriptor;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor availabilityValuePropertyDescriptor;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor traceabilityValuePropertyDescriptor;

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
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE
      if (confidentialityValuePropertyDescriptor != null) {
        Object confidentialityValueValue = eObject
            .eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, true);
        if (confidentialityValueValue != null && confidentialityValueValue instanceof EObject && ModelExtensionHelper
            .getInstance(eObject).isExtensionModelDisabled((EObject) confidentialityValueValue)) {
          itemPropertyDescriptors.remove(confidentialityValuePropertyDescriptor);
        } else if (confidentialityValueValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE) != null) {
          itemPropertyDescriptors.remove(confidentialityValuePropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(confidentialityValuePropertyDescriptor) == false) {
          itemPropertyDescriptors.add(confidentialityValuePropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE
      if (integrityValuePropertyDescriptor != null) {
        Object integrityValueValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE, true);
        if (integrityValueValue != null && integrityValueValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) integrityValueValue)) {
          itemPropertyDescriptors.remove(integrityValuePropertyDescriptor);
        } else if (integrityValueValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE) != null) {
          itemPropertyDescriptors.remove(integrityValuePropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(integrityValuePropertyDescriptor) == false) {
          itemPropertyDescriptors.add(integrityValuePropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE
      if (availabilityValuePropertyDescriptor != null) {
        Object availabilityValueValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE,
            true);
        if (availabilityValueValue != null && availabilityValueValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) availabilityValueValue)) {
          itemPropertyDescriptors.remove(availabilityValuePropertyDescriptor);
        } else if (availabilityValueValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE) != null) {
          itemPropertyDescriptors.remove(availabilityValuePropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(availabilityValuePropertyDescriptor) == false) {
          itemPropertyDescriptors.add(availabilityValuePropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE
      if (traceabilityValuePropertyDescriptor != null) {
        Object traceabilityValueValue = eObject.eGet(CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE,
            true);
        if (traceabilityValueValue != null && traceabilityValueValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) traceabilityValueValue)) {
          itemPropertyDescriptors.remove(traceabilityValuePropertyDescriptor);
        } else if (traceabilityValueValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE) != null) {
          itemPropertyDescriptors.remove(traceabilityValuePropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(traceabilityValuePropertyDescriptor) == false) {
          itemPropertyDescriptors.add(traceabilityValuePropertyDescriptor);
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

      addConfidentialityValuePropertyDescriptor(object);
      addIntegrityValuePropertyDescriptor(object);
      addAvailabilityValuePropertyDescriptor(object);
      addTraceabilityValuePropertyDescriptor(object);
    }
    // begin-extension-code
    checkChildCreationExtender(object);
    // end-extension-code
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Confidentiality Value feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addConfidentialityValuePropertyDescriptor(Object object) {
    // begin-extension-code
    confidentialityValuePropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_confidentialityValue_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_confidentialityValue_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(confidentialityValuePropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Integrity Value feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addIntegrityValuePropertyDescriptor(Object object) {
    // begin-extension-code
    integrityValuePropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_integrityValue_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_integrityValue_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(integrityValuePropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Availability Value feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAvailabilityValuePropertyDescriptor(Object object) {
    // begin-extension-code
    availabilityValuePropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_availabilityValue_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_availabilityValue_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(availabilityValuePropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Traceability Value feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTraceabilityValuePropertyDescriptor(Object object) {
    // begin-extension-code
    traceabilityValuePropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_SecurityNeeds_traceabilityValue_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_SecurityNeeds_traceabilityValue_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_SecurityNeeds_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(traceabilityValuePropertyDescriptor);
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