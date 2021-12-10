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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.capella.core.libraries.model.CapellaModel;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.helpers.EObjectHelper;

public abstract class AbstractCybersecuritySectionTest extends BasicTestCase {
  public static final String PA__EPA_2_ID = "96b6740e-1c54-452d-87c1-96e28813c320";
  public static final String PA__FPA_3_ID = "6d555daa-e081-4e69-868a-23fa1562c7fb";
  public static final String PA__IPA_4_ID = "52e144a0-ae77-4e6b-bbbb-ea85ae0dd72b";
  public static final String PA__THREAT_1_ID = "cb4843d5-6bab-408e-8025-1ca31fc5b050";
  public static final String PA__PHYSICAL_FUNCTION_3_ID = "3018ccfb-9cfd-4d36-bffe-bc67b422e78a";
  public static final String PA__EXCHANGE_ITEM_1_ID = "096c065c-4f08-4915-ae54-5fbfebeaa1e4";
  public static final String PA__CYBERSECURITY_PKG_ID = "e3201310-ef8c-46d5-8589-d9ddb6313095";
  private CapellaModel model;
  
  @Override
  public List<String> getRequiredTestModels() {
    return Collections.singletonList("CybersecurityModel");
  }
  
  protected void init() {
    model = getTestModel(getRequiredTestModels().get(0));
  }
  
  public void doTest(String idSelected, AbstractSection section, int numFields) {
    EObject elementToCheck = EObjectHelper.getObject(model, idSelected);
    
    assertTrue(section.select(elementToCheck));
    section.createControls(new Shell(), null);
    assertEquals(section.getSemanticFields().size(), numFields);
  }
  
  public void doTestNotSelect(String idSelected, AbstractSection section) {
    EObject elementToCheck = EObjectHelper.getObject(model, idSelected);
    
    assertFalse(section.select(elementToCheck));
  }
}
