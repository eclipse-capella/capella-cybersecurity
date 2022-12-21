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

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.ctx.SystemFunction;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.interaction.Scenario;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.LogicalFunction;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.oa.OperationalProcess;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
import org.polarsys.capella.cybersecurity.docgen.Activator;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;

public class ImageHelper {

	private static final String CYBERSCURITY_IMG = "CybersecurityPkg.png";
	private static final String INFORMATION_PRIMARY_ASSET_IMG = "InformationPrimaryAsset.png";
	private static final String FUNCTION_PRIMARY_ASSET_IMG = "FunctionalPrimaryAsset.png";
	private static final String ENTERPRISE_PRIMARY_ASSET_IMG = "EnterprisePrimaryAsset.png";
	private static final String THREAT_IMG = "Threat.png";
	private static final String PATH_IMG = "../icon/";
	private static final String GIF_TYPE = ".gif";

	public static void createPNG(EObject element, String projectName, String outputFolder)
			throws IOException, CoreException {
		if (element instanceof CybersecurityPkg) {
			copyFile(projectName, outputFolder, CYBERSCURITY_IMG);
		} else if (element instanceof FunctionalPrimaryAsset) {
			copyFile(projectName, outputFolder, FUNCTION_PRIMARY_ASSET_IMG);
		} else if (element instanceof InformationPrimaryAsset) {
			copyFile(projectName, outputFolder, INFORMATION_PRIMARY_ASSET_IMG);
		} else if (element instanceof EnterprisePrimaryAsset) {
      copyFile(projectName, outputFolder, ENTERPRISE_PRIMARY_ASSET_IMG);
    } else if (element instanceof Threat) {
			copyFile(projectName, outputFolder, THREAT_IMG);
		}
	}

	public static void copyFile(String projectName, String outputFolder, String fileName)
			throws IOException, CoreException {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		InputStream stream = FileLocator.openStream(bundle, new Path("icons/" + fileName), false);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFolder folder = project.getFolder(outputFolder);
		String targetFilePath = folder.getParent().getProjectRelativePath().toString() + "/icon/" + fileName;

		IFile destinationFile = project.getFile(targetFilePath);
		if (!destinationFile.exists()) {
			destinationFile.create(stream, true, new NullProgressMonitor());
		}
		stream.close();
	}

	public static String getPathImgGif(EObject element) {
		if (element instanceof Threat) {
			return PATH_IMG + Threat.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof FunctionalPrimaryAsset) {
			return PATH_IMG + FunctionalPrimaryAsset.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof InformationPrimaryAsset) {
			return PATH_IMG + InformationPrimaryAsset.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof EnterprisePrimaryAsset) {
      return PATH_IMG + EnterprisePrimaryAsset.class.getSimpleName() + GIF_TYPE;
    } else if (element instanceof CybersecurityPkg) {
      return PATH_IMG + CybersecurityPkg.class.getSimpleName() + GIF_TYPE;
    } else if (element instanceof LogicalFunction) {
			return PATH_IMG + LogicalFunction.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof SystemFunction) {
			return PATH_IMG + SystemFunction.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof PhysicalFunction) {
			return PATH_IMG + PhysicalFunction.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof OperationalActivity) {
			return PATH_IMG + OperationalActivity.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof FunctionalChain) {
			return PATH_IMG + FunctionalChain.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof ExchangeItem) {
			return PATH_IMG + ExchangeItem.class.getSimpleName() + GIF_TYPE;
		} else if (element instanceof OperationalProcess) {
			return PATH_IMG + ExchangeItem.class.getSimpleName() + GIF_TYPE;
    } else if (element instanceof Scenario) {
      return PATH_IMG + Scenario.class.getSimpleName() + GIF_TYPE;
    } else if (element instanceof Entity) {
      if(((Entity) element).isActor()) {
        return PATH_IMG + "Actor" + GIF_TYPE;
      }
      return PATH_IMG + "Entity" + GIF_TYPE;
    } else if (element instanceof Component && ((Component) element).isActor() && ((Component) element).isHuman()) {
      return PATH_IMG + "Actor" + GIF_TYPE;
    } else if (element instanceof SystemComponent && ((SystemComponent) element).isActor()) {
      return PATH_IMG + "SystemActor" + GIF_TYPE;
    } else if (element instanceof LogicalComponent && ((LogicalComponent) element).isActor()) {
      return PATH_IMG + "LogicalActor" + GIF_TYPE;
    } else if (element instanceof PhysicalComponent && ((PhysicalComponent) element).isActor()) {
      return PATH_IMG + "PhysicalActorNode" + GIF_TYPE;
    }
		return "";
	}
}
