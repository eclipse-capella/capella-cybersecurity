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
package org.polarsys.capella.cybersecurity.ui.semantic.browser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.capellacommon.GenericTrace;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;

public class TraceableElementOutgoingTrace implements IQuery {

  public TraceableElementOutgoingTrace() {
    // do nothing
  }

  /**
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  @Override
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<Object>(0);

    if (showCategory(object)) {
      TraceableElement trace = (TraceableElement) object;
      EList<AbstractTrace> traces = trace.getOutgoingTraces();
      for (AbstractTrace abstractTrace : traces) {
        if (abstractTrace instanceof GenericTrace) {
          TraceableElement element = abstractTrace.getTargetElement();
          if (null != element) {
            result.add(element);
          }
        }
      }
    }
    return result;
  }

  protected boolean showCategory(Object object) {
    return object instanceof TraceableElement && !(object instanceof Threat || object instanceof PrimaryAsset);
  }

}
