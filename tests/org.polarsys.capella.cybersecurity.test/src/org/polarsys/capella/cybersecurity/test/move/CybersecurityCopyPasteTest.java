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

public class CybersecurityCopyPasteTest extends AbstractCybersecurityMoveTest {
  @Override
  public void test() throws Exception {
    init();

    // cannot copy/paste elements between different Architecture levels
    checkMoveDisabled(saPkg, oaArch, "CybersecurityPkg can't be moved to different architecture");
    checkMoveDisabled(threatSASub, oaArch, "Cybersecurity element can't be moved to different architecture");
    checkMoveDisabled(fpaSASub, laPkg, "Cybersecurity element can't be moved to different architecture");
    checkMoveDisabled(subSAPkg, laPkg, "CybersecurityPkg can't be moved to different architecture");
    
    checkCopyDisabled(saPkg, oaArch, "CybersecurityPkg can't be copied to different architecture");
    checkCopyDisabled(threatSASub, oaArch, "Cybersecurity element can't be copied to different architecture");
    checkCopyDisabled(fpaSASub, laPkg, "Cybersecurity element can't be copied to different architecture");
    checkCopyDisabled(subSAPkg, laPkg, "CybersecurityPkg can't be copied to different architecture");
    
    // directly in architecture another CybersecurityPkg
    checkMoveDisabled(subSAPkg1, saArch, "CybersecurityPkg can't be moved as root package");
    checkCopyDisabled(subSAPkg1, saArch, "CybersecurityPkg can't be copied as root package");
    
    // Threat directly in Arch
    checkCopyDisabled(threatSASub1, saArch, "Cybersecurity element can't be copied to architecture");
    
    // at same level
    checkMoveAllowed(threatSASub, saPkg, "Cybersecurity element can be moved to other CybersecurityPkg at same architecture");
    int countThreats = saPkg.getOwnedThreats().size();
    GuiActions.copyAndPaste(ted, Arrays.asList(threatSASub), saPkg);
    assertEquals(saPkg.getOwnedThreats().size(), countThreats + 1);
    
    // CybersecurityPkg to same level
    checkMoveAllowed(subSAPkg1, saPkg, "CybersecurityPkg can be moved to other CybersecurityPkg at same architecture");
    int countPkgs = saPkg.getOwnedCybersecurityPkgs().size();
    GuiActions.copyAndPaste(ted, Arrays.asList(subSAPkg1), saPkg);
    assertEquals(saPkg.getOwnedCybersecurityPkgs().size(), countPkgs + 1);
  }
}
