/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.docgen.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper;

public class CybersecurityDiagramHelper implements IDiagramHelper {

	@Override
	public boolean select(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getElementId(EObject eObject) {
		if (eObject instanceof PrimaryAsset) {
			return ((PrimaryAsset)eObject).getId();
		}
		return null;
	}

	@Override
	public String diagramDocumentationPostTraitement(EObject eObject, String documentation, String projectName,
			String outputFolder) {
		return "";
	}
	
	@Override
	public EObject getSemanticElement(DDiagramElement element) {
		return element.getTarget();
	}
	
	  @Override
	  public boolean isContainer(DDiagramElement element) {
	    return false;
	  }
	
	
}
