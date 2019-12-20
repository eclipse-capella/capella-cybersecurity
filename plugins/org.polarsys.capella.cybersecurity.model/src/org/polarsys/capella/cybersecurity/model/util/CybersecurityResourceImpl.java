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

package org.polarsys.capella.cybersecurity.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.polarsys.kitalpha.emde.xmi.XMIExtensionHelperImpl;
import org.polarsys.kitalpha.emde.xmi.XMIExtensionLoadImpl;
import org.polarsys.kitalpha.emde.xmi.XMIExtensionSaveImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package. <!-- end-user-doc -->
 * @see org.polarsys.capella.cybersecurity.model.util.CybersecurityResourceFactoryImpl
 * @generated
 */
public class CybersecurityResourceImpl extends XMIResourceImpl {
  /**
   * Creates an instance of the resource.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param uri the URI of the new resource.
   * @generated
   */
  public CybersecurityResourceImpl(URI uri) {
    super(uri);
  }

  // override to integrate the bug fix
  // https://bugs.eclipse.org/bugs/show_bug.cgi?id=412753. The bug has been
  // resolved in EMF 2.9.1 and 2.10

  @Override

  protected void detachedHelper(EObject eObject) {
    if (useIDs() && unloadingContents == null) {
      if (useUUIDs()) {
        DETACHED_EOBJECT_TO_ID_MAP.put(eObject, getID(eObject));
      }

      if (idToEObjectMap != null && eObjectToIDMap != null) {
        setID(eObject, null);
      }
    }
    resourceImplDetachedHelper(eObject);
  }

  // Duplicated from
  // org.eclipse.emf.ecore.resource.impl.ResourceImpl.detachedHelper(EObject)
  private void resourceImplDetachedHelper(EObject eObject) {
    Map<String, EObject> map = getIntrinsicIDToEObjectMap();
    if (map != null) {
      String id = EcoreUtil.getID(eObject);
      if (id != null) {
        map.remove(id);
      }
    }

    if (isTrackingModification()) {
      eObject.eAdapters().remove(modificationTrackingAdapter);
    }
  }

} // CybersecurityResourceImpl