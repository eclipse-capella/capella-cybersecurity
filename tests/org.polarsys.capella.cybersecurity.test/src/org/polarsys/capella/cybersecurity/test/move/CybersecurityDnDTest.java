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
package org.polarsys.capella.cybersecurity.test.move;

import java.util.Arrays;

import org.polarsys.capella.test.framework.helpers.GuiActions;

public class CybersecurityDnDTest extends AbstractCybersecurityMoveTest {
  @Override
  public void test() throws Exception {
    init();
    
    // cannot dnd elements between different Architecture levels
    assertFalse(GuiActions.canDnD(oaArch, Arrays.asList(saPkg)));
    assertFalse(GuiActions.canDnD(oaPkg, Arrays.asList(saPkg)));
    assertFalse(GuiActions.canDnD(oaPkg, Arrays.asList(context.getSemanticElement(THREAT1_SA), context.getSemanticElement(FPA1_SA))));
    assertFalse(GuiActions.canDnD(laPkg, Arrays.asList(context.getSemanticElement(THREAT1_SA), context.getSemanticElement(FPA1_SA))));
    assertFalse(GuiActions.canDnD(paPkg, Arrays.asList(threatSASub, fpaSASub)));
    
    // cannot dnd directly in architecture another CybersecurityPkg
    assertFalse(GuiActions.canDnD(saArch, Arrays.asList(subSAPkg1)));
    
    // cannot dnd a Threat directly in Arch
    assertFalse(GuiActions.canDnD(saArch, Arrays.asList(threatSASub1)));
    
    // dnd at same level
    assertTrue(GuiActions.canDnD(saPkg, Arrays.asList(threatSASub, fpaSASub)));
    GuiActions.dragAndDrop(ted, saPkg, Arrays.asList(threatSASub, fpaSASub));
    assertEquals(threatSASub.eContainer(), saPkg);
    assertEquals(fpaSASub.eContainer(), saPkg);
    
    // can dnd a CybersecurityPkg to same level
    assertTrue(GuiActions.canDnD(saPkg, Arrays.asList(subSAPkg1)));
    GuiActions.dragAndDrop(ted, saPkg, Arrays.asList(subSAPkg1));
    assertEquals(threatSASub1.eContainer(), subSAPkg1);
    assertEquals(threatSASub1.eContainer().eContainer(), saPkg);
  }
}
