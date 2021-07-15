/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.ui.semantic.browser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.polarsys.capella.core.data.capellacommon.GenericTrace;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.common.helpers.query.IQuery;

public class TraceableElementIncomingTrace implements IQuery {

  public TraceableElementIncomingTrace() {
    // do nothing
  }

  /**
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<Object>(0);

    if (showCategory(object)) {
      TraceableElement trace = (TraceableElement) object;
      EList<AbstractTrace> traces = trace.getIncomingTraces();
      for (AbstractTrace abstractTrace : traces) {
        if (abstractTrace instanceof GenericTrace) {
          TraceableElement element = abstractTrace.getSourceElement();
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
