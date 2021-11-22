/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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

import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;

import org.polarsys.kitalpha.emde.model.EmdePackage;

import org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.cybersecurity.model.ThreatSourceUse} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ThreatSourceUseItemProvider extends RelationshipItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor threatSourcePropertyDescriptor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IItemPropertyDescriptor usedActorPropertyDescriptor;

  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThreatSourceUseItemProvider(AdapterFactory adapterFactory) {
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
      // Process CybersecurityPackage.Literals.THREAT_SOURCE_USE__THREAT_SOURCE
      if (threatSourcePropertyDescriptor != null) {
        Object threatSourceValue = eObject.eGet(CybersecurityPackage.Literals.THREAT_SOURCE_USE__THREAT_SOURCE, true);
        if (threatSourceValue != null && threatSourceValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) threatSourceValue)) {
          itemPropertyDescriptors.remove(threatSourcePropertyDescriptor);
        } else if (threatSourceValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.THREAT_SOURCE_USE__THREAT_SOURCE) != null) {
          itemPropertyDescriptors.remove(threatSourcePropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(threatSourcePropertyDescriptor) == false) {
          itemPropertyDescriptors.add(threatSourcePropertyDescriptor);
        }
      }
      // Process CybersecurityPackage.Literals.THREAT_SOURCE_USE__USED_ACTOR
      if (usedActorPropertyDescriptor != null) {
        Object usedActorValue = eObject.eGet(CybersecurityPackage.Literals.THREAT_SOURCE_USE__USED_ACTOR, true);
        if (usedActorValue != null && usedActorValue instanceof EObject
            && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) usedActorValue)) {
          itemPropertyDescriptors.remove(usedActorPropertyDescriptor);
        } else if (usedActorValue == null && ExtensionModelManager.getAnyType(eObject,
            CybersecurityPackage.Literals.THREAT_SOURCE_USE__USED_ACTOR) != null) {
          itemPropertyDescriptors.remove(usedActorPropertyDescriptor);
        } else if (itemPropertyDescriptors.contains(usedActorPropertyDescriptor) == false) {
          itemPropertyDescriptors.add(usedActorPropertyDescriptor);
        }
      }
    }
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addThreatSourcePropertyDescriptor(object);
      addUsedActorPropertyDescriptor(object);
    }
    // begin-extension-code
    checkChildCreationExtender(object);
    // end-extension-code
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Threat Source feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addThreatSourcePropertyDescriptor(Object object) {
    // begin-extension-code
    threatSourcePropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_ThreatSourceUse_threatSource_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_ThreatSourceUse_threatSource_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_ThreatSourceUse_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.THREAT_SOURCE_USE__THREAT_SOURCE, false, false, false, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(threatSourcePropertyDescriptor);
    // end-extension-code
  }

  /**
   * This adds a property descriptor for the Used Actor feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUsedActorPropertyDescriptor(Object object) {
    // begin-extension-code
    usedActorPropertyDescriptor = createItemPropertyDescriptor
    // end-extension-code		
    (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_ThreatSourceUse_usedActor_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_ThreatSourceUse_usedActor_feature", //$NON-NLS-1$//$NON-NLS-2$
            "_UI_ThreatSourceUse_type"), //$NON-NLS-1$
        CybersecurityPackage.Literals.THREAT_SOURCE_USE__USED_ACTOR, true, false, true, null, null,
        // begin-extension-code
        null);
    itemPropertyDescriptors.add(usedActorPropertyDescriptor);
    // end-extension-code
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean hasChildren(Object object) {
    return hasChildren(object, true);
  }

  /**
   * This returns ThreatSourceUse.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ThreatSourceUse")); //$NON-NLS-1$
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {

    String label = ((ThreatSourceUse) object).getId();
    // begin-extension-code
    return label == null || label.length() == 0 ? "[" + getString("_UI_ThreatSourceUse_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    // end-extension-code
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
          EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS,
          CybersecurityFactory.eINSTANCE.createThreatSourceUse());
      if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
        newChildDescriptors.add(commandParameter);
      }
    }
    // end-extension-code

  }

}