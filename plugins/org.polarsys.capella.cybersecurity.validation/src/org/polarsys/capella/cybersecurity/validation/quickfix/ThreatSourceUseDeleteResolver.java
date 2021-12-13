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
package org.polarsys.capella.cybersecurity.validation.quickfix;

import org.polarsys.capella.core.validation.ui.ide.quickfix.AbstractDeleteCommandResolver;
import org.polarsys.capella.cybersecurity.model.ThreatSourceUse;

public class ThreatSourceUseDeleteResolver extends AbstractDeleteCommandResolver {

  @Override
  public Object getElementToDelete(Object obj) {
    if (obj instanceof ThreatSourceUse) {
      return obj;
    }
    return null;
  }

}

