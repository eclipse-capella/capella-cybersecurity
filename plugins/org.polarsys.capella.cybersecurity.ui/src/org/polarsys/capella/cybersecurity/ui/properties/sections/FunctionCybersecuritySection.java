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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.MultipleSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.ui.CommonHelpers;
import org.polarsys.capella.cybersecurity.ui.CybersecurityUIActivator;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorage;
import org.polarsys.capella.cybersecurity.ui.ElementExtensionStorageImpl;
import org.polarsys.capella.cybersecurity.ui.properties.fields.SemanticCheckboxGroup;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class FunctionCybersecuritySection extends AbstractSection {

  // display properties for this element
  private FunctionStorage elementExtension;

  private SemanticCheckboxGroup checkboxes;
  private MultipleSemanticField exchangeItems;

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
    } else if (eObjectToTest instanceof FunctionStorage) {
      return true;
    } else {
      EObject children = getFunctionStorageObject(eObjectToTest);
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

    if (newEObject != null && !(newEObject instanceof FunctionStorage)) {
      newEObject = getFunctionStorageObject(newEObject);
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
  private EObject getFunctionStorageObject(EObject parent) {
    if (parent == null)
      return null;

    if (!CommonHelpers.isViewpointActive(parent, CybersecurityUIActivator.VIEWPOINT_ID))
      return null;

    for (EObject iEObject : parent.eContents()) {
      if (iEObject instanceof FunctionStorage) {
        // we return first encountered function storage (in case of many - which is in inconsistent state)
        return iEObject;
      }
    }

    EObject result = null;
    if (result == null) {
      if (CommonHelpers.canBeExtendedBy(parent, CybersecurityPackage.Literals.FUNCTION_STORAGE)) {
        for (Adapter adapter : parent.eAdapters()) {
          if (adapter instanceof ElementExtensionStorage
              && ((ElementExtensionStorage<?>) adapter).getExtension() instanceof FunctionStorage) {
            return ((ElementExtensionStorage<?>) adapter).getExtension();
          }
        }
        if (result == null) {
          ElementExtensionStorage<TrustBoundaryStorage> adapter = new ElementExtensionStorageImpl<>(
              (ExtensibleElement) parent, CybersecurityPackage.Literals.FUNCTION_STORAGE);
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
  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);

    checkboxes = new SemanticCheckboxGroup(getCheckGroup(), getWidgetFactory(),
        CybersecurityPackage.Literals.FUNCTION_STORAGE__DATA_STORAGE,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__REMANENT_DATA);

    exchangeItems = new MultipleSemanticField(getReferencesGroup(), Messages.FunctionCybersecuritySection_0, getWidgetFactory(),
        new AbstractMultipleSemanticFieldController() {

          /**
           * {@inheritDoc}
           */
          // TODO move this handling of queries for unattached objects to capella
          @Override
          public List<EObject> readOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
              boolean availableElements) {
            List<EObject> result = new ArrayList<EObject>(0);
            IBusinessQuery query = getReadOpenValuesQuery(semanticElement);
            if (null != query) {
              List<EObject> capellaElements = null;
              if (availableElements) {
                EObject queryElement = semanticElement.eContainer();
                if (queryElement == null) {
                  ElementExtensionStorage<?> st = (ElementExtensionStorage<?>) EcoreUtil
                      .getExistingAdapter(semanticElement, ElementExtensionStorage.class);
                  queryElement = st.getExtendedElement();
                }
                capellaElements = query.getAvailableElements(queryElement);
              } else {
                capellaElements = query.getCurrentElements(semanticElement, false);
              }
              result.addAll(capellaElements);
            }
            return result;
          }

          /**
           * {@inheritDoc}
           */
          @Override
          protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
            return BusinessQueriesProvider.getInstance().getContribution(semanticElement.eClass(),
                CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS);
          }
        });
    exchangeItems.setDisplayedInWizard(isDisplayedInWizard());
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
    checkboxes.loadData(object);
    exchangeItems.loadData(object, CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS);
    elementExtension = (FunctionStorage) object;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();
    abstractSemanticFields.add(checkboxes);
    abstractSemanticFields.add(exchangeItems);
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
