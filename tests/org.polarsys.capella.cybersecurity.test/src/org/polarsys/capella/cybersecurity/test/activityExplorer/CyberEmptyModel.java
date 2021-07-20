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
  public final static String OA_ENTITIES = "f6985216-39d9-48a0-8b3d-ab47621b6b82";
  public final static String LA__LOGICAL_COMPONENT = "709a8dd2-a707-4bd7-8871-48e52405d24d";
  public final static String PA__PHYSICAL_COMPONENT = "b3b4a2c0-6e76-4474-9082-6c6bb7d058d6";
  public final static String SA__SYSTEM_COMPONENT = "aad3c686-3612-44c0-9ce8-4bb74e1093d0";

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }

}
