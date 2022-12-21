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
