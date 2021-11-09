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
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.cybersecurity.model.Threat;

public class ThreatRealizing implements IQuery {

  @Override
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<Object>();
    if (object instanceof Threat) {
      Threat threat = (Threat) object;
      EList<Threat> realizedThreats = threat.getRealizingThreats();
      if (!realizedThreats.isEmpty()) {
        result.addAll(realizedThreats);
      }
    }
    return result;
  }

}
