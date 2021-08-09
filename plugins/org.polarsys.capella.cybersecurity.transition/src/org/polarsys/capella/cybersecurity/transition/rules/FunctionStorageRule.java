/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.transition.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.common.constants.ITransitionConstants;
import org.polarsys.capella.core.transition.common.handlers.attachment.AttachmentHelper;
import org.polarsys.capella.core.transition.common.handlers.contextscope.ContextScopeHandlerHelper;
import org.polarsys.capella.core.transition.system.rules.AbstractCapellaElementRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IPremise;

public class FunctionStorageRule extends AbstractCapellaElementRule {

  public FunctionStorageRule() {
    registerUpdatedReference(CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS);
  }

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.FUNCTION_STORAGE;
  }

  @Override
  protected void premicesRelated(EObject element, ArrayList<IPremise> needed) {
    needed.addAll(
        createDefaultPrecedencePremices(element, CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS));
  }

  @Override
  protected void attachRelated(EObject element, EObject result, IContext context) {
    AttachmentHelper.getInstance(context).attachTracedElements(element, result,
        CybersecurityPackage.Literals.FUNCTION_STORAGE__EXCHANGED_ITEMS, context);
  }

  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    result.addAll(((FunctionStorage) source).getExchangedItems());
    
    if (ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE, source, context)) {
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE,
          ((FunctionStorage) source).getExchangedItems(), context);
    }
  }

  @Override
  protected void updateElement(EObject element, EObject result, IContext context) {
    super.updateElement(element, result, context);
    FunctionStorage fsTarget = (FunctionStorage) result;
    FunctionStorage fsSource = (FunctionStorage) element;
    fsTarget.setDataStorage(fsSource.isDataStorage());
    fsTarget.setRemanentData(fsSource.isRemanentData());
  }
}
