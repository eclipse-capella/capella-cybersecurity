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
package org.polarsys.capella.cybersecurity.test.properties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.libraries.IModel;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.properties.sections.PrimaryAssetInverseMember;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.helpers.EObjectHelper;

public abstract class AbstractPrimaryAssetInverseMemberSectionTest extends BasicTestCase {
  protected IModel model;

  @Override
  public List<String> getRequiredTestModels() {
    return Collections.singletonList("CybersecurityModel");
  }
  
  protected void init() {
    model = getTestModel(getRequiredTestModels().iterator().next());
  }
  
  public void doTest(String idObject, String[] expectedIds, PrimaryAssetInverseMember section) {
    EObject elementToCheck = EObjectHelper.getObject(model, idObject);
    assertEquals(getExpectedIds(expectedIds), getAvailableIds(section, elementToCheck));
  }

  public Set<String> getExpectedIds(String[] ids) {
    return Arrays.asList(ids).stream().collect(Collectors.toSet());
  }

  public Set<String> getAvailableIds(PrimaryAssetInverseMember section, EObject elementToCheck) {
    List<EObject> availableElements = section.getAvailableElements(elementToCheck);
    return availableElements.stream().map(element -> ((PrimaryAsset) element).getId()).collect(Collectors.toSet());
  }
}
