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
