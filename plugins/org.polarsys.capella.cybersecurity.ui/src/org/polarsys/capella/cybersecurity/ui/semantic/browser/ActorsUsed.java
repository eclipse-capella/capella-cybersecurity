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

import java.util.List;
import java.util.stream.Collectors;

import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;

public class ActorsUsed implements IQuery {

  @Override
  public List<Object> compute(Object element) {
    return CybersecurityQueries.getUsedActors((Component) element).collect(Collectors.toList());
  }
}
