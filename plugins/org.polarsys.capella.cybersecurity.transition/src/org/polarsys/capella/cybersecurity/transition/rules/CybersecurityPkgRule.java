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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.transition.common.constants.ITransitionConstants;
import org.polarsys.capella.core.transition.common.handlers.contextscope.ContextScopeHandlerHelper;
import org.polarsys.capella.core.transition.system.rules.AbstractCapellaElementRule;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 *
 */
public class CybersecurityPkgRule extends AbstractCapellaElementRule {

  @Override
  protected EClass getSourceType() {
    return CybersecurityPackage.Literals.CYBERSECURITY_PKG;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void retrieveGoDeep(EObject source, List<EObject> result, IContext context) {
    super.retrieveGoDeep(source, result, context);
    
    //add children
    CybersecurityPkg element = (CybersecurityPkg) source;
    if (ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE, element, context)
        || ContextScopeHandlerHelper.getInstance(context).contains(ITransitionConstants.SOURCE_SCOPE,
            element.eContainer(), context)) {
      result.addAll(element.getOwnedThreats());
      result.addAll(element.getOwnedPrimaryAssets());
      result.addAll(element.getOwnedCybersecurityPkgs());

      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE,
          element.getOwnedThreats(), context);
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE,
          element.getOwnedPrimaryAssets(), context);
      ContextScopeHandlerHelper.getInstance(context).addAll(ITransitionConstants.SOURCE_SCOPE,
          element.getOwnedCybersecurityPkgs(), context);
    }
  }
}
