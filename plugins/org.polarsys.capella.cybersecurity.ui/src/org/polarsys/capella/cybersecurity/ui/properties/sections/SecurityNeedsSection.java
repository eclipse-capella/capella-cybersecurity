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

// Generated on 20.05.2019 at 12:52:47 CEST by Viewpoint DSL Generator V 0.1

package org.polarsys.capella.cybersecurity.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.IntegerValueGroup;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.ui.CommonHelpers;
import org.polarsys.capella.cybersecurity.ui.CybersecurityUIActivator;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorage;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorageImpl;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class SecurityNeedsSection extends AbstractSection {

  // display properties for this element
  private SecurityNeeds elementExtension;

  private IntegerValueGroup confidentiality;
  private IntegerValueGroup integrity;
  private IntegerValueGroup traceability;
  private IntegerValueGroup availability;
  
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eObject:
   *          current object
   * @generated
   */
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);

    if (eObjectToTest == null) {
      return false;
    } else if (eObjectToTest instanceof SecurityNeeds) {
      return true;
    } else {
      EObject children = getSecurityNeedsObject(eObjectToTest);
      if (children != null) {
        return true;
      }
    }

    return false;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param part
   * @param selection
   * @generated
   */
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);

    if (newEObject != null && !(newEObject instanceof SecurityNeeds)) {
      newEObject = getSecurityNeedsObject(newEObject);
    }

    if (newEObject != null) {
      loadData(newEObject);
    }
  }


  private EObject getSecurityNeedsObject(EObject parent) {
    if (parent == null)
      return null;

    if (!CommonHelpers.isViewpointActive(parent, CybersecurityUIActivator.VIEWPOINT_ID))
      return null;

    if (parent.eContents() == null)
      return null;

    EObject result = null;
    for (EObject iEObject : parent.eContents()) {
      if (iEObject instanceof SecurityNeeds) {
        result =  iEObject;
      }
    }
    if (result == null) {
      EReference storageRef = getStorageRef(parent);
      if (storageRef != null) {
        for (Adapter adapter : parent.eAdapters()) {
          if (adapter instanceof ElementExtensionStorage
              && ((ElementExtensionStorage<?>) adapter).getExtension() instanceof SecurityNeeds) {
            result = ((ElementExtensionStorage<?>) adapter).getExtension();
          }
        }
        if (result == null) {
          ElementExtensionStorage<TrustBoundaryStorage> adapter = new ElementExtensionStorageImpl<>(
              (ExtensibleElement) parent, CybersecurityPackage.Literals.SECURITY_NEEDS);
          result = adapter.getExtension();
        }
      }
    }
    return result;
  }

  private EReference getStorageRef(EObject parent) {

    // we allow to show security needs on cybersecurity objects with a 
    // containment ref of the matching type ...
    if (parent.eClass().getEPackage() == CybersecurityPackage.eINSTANCE) {
      for (EReference e : parent.eClass().getEAllContainments()) {
        if (e.getEType() == CybersecurityPackage.Literals.SECURITY_NEEDS) {
          return e;
        }
      }
    }

    // ... and suitable extensible emde objects 
    if (CommonHelpers.canBeExtendedBy(parent, CybersecurityPackage.Literals.SECURITY_NEEDS)) {
      return EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS;
    }
    
    return null;
  }
  
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param parent:
   * @param aTabbedPropertySheetPage:
   * @generated
   */
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);

    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = ((GridLayout) rootParentComposite.getLayout()).numColumns;

    Group group = getWidgetFactory().createGroup(rootParentComposite, ""); //$NON-NLS-1$
    GridLayout layout = new GridLayout(2, true);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    group.setLayout(layout);
    group.setLayoutData(gd);
    
    
    confidentiality = createIntegerValueGroup(group, Messages.SecurityNeedsSection_1);
    integrity = createIntegerValueGroup(group, Messages.SecurityNeedsSection_2);
    traceability = createIntegerValueGroup(group, Messages.SecurityNeedsSection_3);
    availability = createIntegerValueGroup(group, Messages.SecurityNeedsSection_4);
  }

  // we want a 2x2 layout
  // default integer value group always wants to span all columns, so we'll just trick it
  private IntegerValueGroup createIntegerValueGroup(Group parent, String label) {
    Composite compo = getWidgetFactory().createComposite(parent);
    GridLayout gl = new GridLayout();
    gl.marginHeight = 0;
    gl.marginWidth = 0;
    compo.setLayout(gl);
    compo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    IntegerValueGroup result = new IntegerValueGroup(compo, label, getWidgetFactory(), true);
    result.setDisplayedInWizard(isDisplayedInWizard());
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param object
   * @generated
   */
  public void loadData(EObject object) {
    super.loadData(object);
    confidentiality.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY);
    integrity.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY);
    traceability.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY);
    availability.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY);

    elementExtension = (SecurityNeeds) object;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();
    abstractSemanticFields.add(confidentiality);
    abstractSemanticFields.add(integrity);
    abstractSemanticFields.add(traceability);
    abstractSemanticFields.add(availability);
    return abstractSemanticFields;
  }

  /**
   * pr
   * 
   * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
   */
  @Override
  public void refresh() {
    // must be overwritten since we can also load data from objects without a resource
    if (elementExtension != null) {
      loadData(elementExtension);
    }
  }
  
  
  
}
