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

// Generated on 20.05.2019 at 12:52:47 CEST by Viewpoint DSL Generator V 0.1

package org.polarsys.capella.cybersecurity.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.sirius.ui.helper.SessionHelper;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.ui.CommonHelpers;
import org.polarsys.capella.cybersecurity.ui.CybersecurityUIActivator;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorage;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorageImpl;
import org.polarsys.capella.cybersecurity.ui.properties.fields.EnumerationLiterealValueRadioGroup;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class SecurityNeedsSection extends AbstractSection {

  // display properties for this element
  private SecurityNeeds elementExtension;

  private EnumerationLiterealValueRadioGroup confidentiality;
  private EnumerationLiterealValueRadioGroup integrity;
  private EnumerationLiterealValueRadioGroup traceability;
  private EnumerationLiterealValueRadioGroup availability;
  private Group group;
  

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eObject:
   *          current object
   * @generated
   */
  @Override
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
  @Override
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

    for (EObject eObject : parent.eContents()) {
      if (eObject instanceof SecurityNeeds) {
        return eObject;
      }
    }

    EObject result = null;

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
    return result;
  }

  private EReference getStorageRef(EObject parent) {

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
  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);

    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = ((GridLayout) rootParentComposite.getLayout()).numColumns;

    group = getWidgetFactory().createGroup(rootParentComposite, ""); //$NON-NLS-1$
    GridLayout layout = new GridLayout(2, true);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    group.setLayout(layout);
    group.setLayoutData(gd);
    
    confidentiality = null;
    integrity = null;
    traceability = null;
    availability = null;
  }
  
  // we want a 2x2 layout
  // default integer value group always wants to span all columns, so we'll just trick it
  private EnumerationLiterealValueRadioGroup createEnumerationLiteralValueRadioGroup(Group parent, String label,
      EnumerationPropertyType type) {
    if (parent != null) {
      Composite compo = getWidgetFactory().createComposite(parent);
      GridLayout gl = new GridLayout();
      gl.marginHeight = 0;
      gl.marginWidth = 0;
      compo.setLayout(gl);
      compo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
      // we display at least one column (display undefined if no configuration is found)
      EnumerationLiterealValueRadioGroup result = new EnumerationLiterealValueRadioGroup(compo, label, type,
          getWidgetFactory(), 4);
      result.setDisplayedInWizard(isDisplayedInWizard());
      return result;
    }
    return null;
  }
  
  private void createSecurityNeedsGroup(Group group, EObject object) {
    EObject element = object;
    if (object instanceof SecurityNeeds) {
      SecurityNeeds need = (SecurityNeeds) object;
      for (Adapter ee : need.eAdapters()) {
        if (ee instanceof ElementExtensionStorage) {
          element = ((ElementExtensionStorage<?>) ee).getExtendedElement();
        }
      }
    }
    Session session = SessionManager.INSTANCE.getSession(element);
    Project project = SessionHelper.getCapellaProject(session);
    confidentiality = createEnumerationLiteralValueRadioGroup(group, Messages.SecurityNeedsSection_1,
        CybersecurityQueries.getConfidentialityPropertyType(project));
    integrity = createEnumerationLiteralValueRadioGroup(group, Messages.SecurityNeedsSection_2,
        CybersecurityQueries.getIntegrityPropertyType(project));
    traceability = createEnumerationLiteralValueRadioGroup(group, Messages.SecurityNeedsSection_3,
        CybersecurityQueries.getTraceabilityPropertyType(project));
    availability = createEnumerationLiteralValueRadioGroup(group, Messages.SecurityNeedsSection_4,
        CybersecurityQueries.getAvailabilityPropertyType(project));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param object
   * @generated
   */
  @Override
  public void loadData(EObject object) {
    super.loadData(object);
    if(confidentiality == null || integrity == null || traceability == null || availability == null) {
      createSecurityNeedsGroup(group, object);
    }
    confidentiality.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__CONFIDENTIALITY_VALUE);
    integrity.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__INTEGRITY_VALUE);
    traceability.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__TRACEABILITY_VALUE);
    availability.loadData(object, CybersecurityPackage.Literals.SECURITY_NEEDS__AVAILABILITY_VALUE);

    elementExtension = (SecurityNeeds) object;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
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
