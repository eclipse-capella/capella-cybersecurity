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
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.test.framework.api.NonDirtyTestCase;

public abstract class CyberEmptyModel extends NonDirtyTestCase {
  public final static String OA = "d4beedad-e43c-4073-845d-b8d6c8f28542";
  public final static String OA__ENTITIES_PKG = "f6985216-39d9-48a0-8b3d-ab47621b6b82";
  public final static String LA__LOGICAL_COMPONENT_PKG = "379a40b0-c136-47cd-b4e0-9e42e33b6e96";
  public final static String PA__PHYSICAL_COMPONENT_PKG = "b78ef284-d837-4c56-937f-7b8657abb2fc";
  public final static String SA__SYSTEM_COMPONENT_PKG = "fea4f6b5-3863-4f5c-b048-b3cf7b6e7ba4";

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }

}
