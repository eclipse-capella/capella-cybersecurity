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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.IntegerValueGroup;
import org.polarsys.capella.core.ui.properties.fields.TextValueGroup;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.ui.CommonHelpers;
import org.polarsys.capella.cybersecurity.ui.CybersecurityUIActivator;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorage;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorageImpl;
import org.polarsys.capella.cybersecurity.ui.properties.fields.SemanticCheckboxGroup;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

/**
 * <!-- begin-user-doc --> This class is an implementation of the section
 * '<em><b>[Cyber_ActorAttributes_cyber_ActorAttributes_Section]</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class ActorCybersecuritySection extends AbstractSection {

  // display properties for this element
  private TrustBoundaryStorage elementExtension;

  private SemanticCheckboxGroup checkBoxes;

  private IntegerValueGroup threatSourceProfileGroup;
  private TextValueGroup rationaleGroup;

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
    } else if (eObjectToTest instanceof TrustBoundaryStorage) {
      return true;
    } else {
      EObject children = getTrustBoundaryStorageObject(eObjectToTest);
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

    if (newEObject != null && !(newEObject instanceof TrustBoundaryStorage)) {
      newEObject = getTrustBoundaryStorageObject(newEObject);
    }

    if (newEObject != null) {
      loadData(newEObject);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param parent:
   *          An EObject. It is considered as the Parent of an EMDE extension (a Viewpoint element)
   * @return
   * @generated
   */
  private EObject getTrustBoundaryStorageObject(EObject parent) {
    if (parent == null)
      return null;

    if (!CommonHelpers.isViewpointActive(parent, CybersecurityUIActivator.VIEWPOINT_ID))
      return null;

    EObject result = null;
    for (EObject iEObject : parent.eContents()) {
      if (iEObject instanceof TrustBoundaryStorage) {
        result = (result == null ? (TrustBoundaryStorage) iEObject : null);
        // This case is true when there is more then one extension of the same type.
        if (result == null)
          break;
      }
    }
    if (result == null) {
      if (CommonHelpers.canBeExtendedBy(parent, CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE)) {
        for (Adapter adapter : parent.eAdapters()) {
          if (adapter instanceof ElementExtensionStorage
              && ((ElementExtensionStorage<?>) adapter).getExtension() instanceof TrustBoundaryStorage) {
            result = ((ElementExtensionStorage<?>) adapter).getExtension();
          }
        }
        if (result == null) {
          ElementExtensionStorage<TrustBoundaryStorage> adapter = new ElementExtensionStorageImpl<>(
              (ExtensibleElement) parent, CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE);
          result = adapter.getExtension();
        }
      }
    }
    return result;
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


    Group checkGroup = getWidgetFactory().createGroup(rootParentComposite, ICommonConstants.EMPTY_STRING);
    checkGroup.setLayout(new GridLayout(2, false));
    checkGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    checkBoxes = new SemanticCheckboxGroup(checkGroup, getWidgetFactory());
    checkBoxes.addCheckbox(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__TRUSTED,
        e -> !((TrustBoundaryStorage) e).isThreatSource());
    checkBoxes.addCheckbox(CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE,
        (e) -> {
          EObject container = ElementExtensionStorage.findContainer(e);
          return container instanceof Component && ((Component)container).isActor();
        });

    threatSourceProfileGroup = new IntegerValueGroup(rootParentComposite, Messages.ActorCybersecuritySection_0, getWidgetFactory());
    rationaleGroup = new TextValueGroup(rootParentComposite, Messages.ActorCybersecuritySection_1, getWidgetFactory());
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param object
   * @generated
   */
  public void loadData(EObject object) {
    super.loadData(object);
    checkBoxes.loadData(object);
    threatSourceProfileGroup.loadData(object,
        CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__THREAT_SOURCE_PROFILE);
    rationaleGroup.loadData(object, CybersecurityPackage.Literals.TRUST_BOUNDARY_STORAGE__RATIONALE);
    elementExtension = (TrustBoundaryStorage) object;
    threatSourceProfileGroup.setEnabled(object.eContainer() instanceof Component && ((Component) object.eContainer()).isActor());
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();
    abstractSemanticFields.add(checkBoxes);
    abstractSemanticFields.add(threatSourceProfileGroup);
    abstractSemanticFields.add(rationaleGroup);
    return abstractSemanticFields;
  }

  /**
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
