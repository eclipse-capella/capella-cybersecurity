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
package org.polarsys.capella.cybersecurity.ui;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.EditingDomainProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

/**
 * This storage implementation attaches the extension to its extended element when the extension is modified.
 **/
public class ElementExtensionStorageImpl<T extends ElementExtension> extends EditingDomainProvider
    implements ElementExtensionStorage<T> {

  private final T elementExtension;
  private final EReference storageRef;
  private ExtensibleElement extendedElement;

  public ElementExtensionStorageImpl(ExtensibleElement extendedElement, EClass storageClass) {
    this(extendedElement, storageClass, EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS);
  }

  public ElementExtensionStorageImpl(ExtensibleElement extendedElement, EClass storageClass, EReference storageRef) {
    super(TransactionUtil.getEditingDomain(extendedElement));
    this.elementExtension = (T) storageClass.getEPackage().getEFactoryInstance().create(storageClass);
    this.storageRef = storageRef;
    this.extendedElement = extendedElement;
    extendedElement.eAdapters().add(this);
    elementExtension.eAdapters().add(this);
  }

  @Override
  public boolean isAdapterForType(Object type) {
    if (type == ElementExtensionStorage.class) {
      return true;
    }
    return super.isAdapterForType(type);
  }

  private boolean isAttachmentTrigger(Notification n) {

    if (n.isReset()) {
      return false;
    }

    switch (n.getEventType()) {
    case Notification.REMOVE:
    case Notification.REMOVE_MANY:
    case Notification.UNSET:
      return false;
    }

    return true;

  }

  @Override
  public void notifyChanged(Notification msg) {
    // when something is set on the extension for the first time, attach it and re-fire the notification
    // so that it gets recorded and can be undone later
    if (msg.getNotifier() == elementExtension && elementExtension.eResource() == null && isAttachmentTrigger(msg)) {
      if (storageRef.isMany()) {
        ((Collection<T>) extendedElement.eGet(storageRef)).add(elementExtension);
      } else {
        extendedElement.eSet(storageRef, elementExtension);
      }
      ((InternalEObject) msg.getNotifier()).eNotify(msg);
    }
  }

  @Override
  public Notifier getTarget() {
    return extendedElement;
  }

  @Override
  public T getExtension() {
    return elementExtension;
  }

  @Override
  public ExtensibleElement getExtendedElement() {
    return extendedElement;
  }

}
