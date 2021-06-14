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
package org.polarsys.capella.cybersecurity.test.activityExplorer;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.test.framework.api.NonDirtyTestCase;

public abstract class CyberEmptyModel extends NonDirtyTestCase {
  public final static String LA__LOGICAL_COMPONENT = "709a8dd2-a707-4bd7-8871-48e52405d24d";
  public final static String PA__PHYSICAL_COMPONENT = "b3b4a2c0-6e76-4474-9082-6c6bb7d058d6";
  public final static String SA__SYSTEM_COMPONENT = "aad3c686-3612-44c0-9ce8-4bb74e1093d0";

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("CyberEmptyModel");
  }

}
