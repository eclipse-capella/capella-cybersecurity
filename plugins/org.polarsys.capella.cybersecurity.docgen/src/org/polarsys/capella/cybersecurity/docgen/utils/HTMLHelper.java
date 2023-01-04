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

import java.util.Arrays;

import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.docgen.util.StringUtil;

public class HTMLHelper {

	private static final String IMG_TEMPLATE = "<img src=\"PATH_IMG\" alt=\"ALT_NAME\">";
	private static final String LINK_TEMPLATE = "<a href=\"PATH_ELEMENT\">NAME_ELEMENT</a>";
	private static final String NAME_ELEMENT = "NAME_ELEMENT";
	private static final String PATH_ELEMENT = "PATH_ELEMENT";
	private static final String PATH_IMG = "PATH_IMG";
	private static final String ALT_NAME = "ALT_NAME";

	public static String getSubtitle(String subtitle) {
		return "<h2>" + subtitle + "</h2>";
	}

	public static String getUlList(String... elements) {
		String htmlList = StringUtil.stringListToBulette(Arrays.asList(elements));
		return htmlList;
	}

	public static String getListElement(String element) {
		return "<li>" + element + "</li>";
	}

	public static String getListElement(String name, String value) {
		return "<b>" + name + ": " + "</b>" + value;
	}

	public static String getBold(String content) {
		return "<b>" + content + "</b>";
	}

	public static String getParagraph(String content) {
		return "<p>" + content + "</p>";
	}

	private static String getPathElement(CapellaElement element, String htmlFolderName) {
		return "../" + htmlFolderName + "/" + CybersecurityFileNameSerivice.SERVICE.getFileName(element) + ".html";
	}

	public static String getLinkElementList(CapellaElement element, String htmlFolderName) {
		StringBuilder builder = new StringBuilder();
		builder.append(IMG_TEMPLATE.replace(PATH_IMG, ImageHelper.getPathImgGif(element)).replace(ALT_NAME,
				ImageHelper.getPathImgGif(element)));
		builder.append(LINK_TEMPLATE.replace(NAME_ELEMENT, element.getLabel()).replace(PATH_ELEMENT,
				getPathElement(element, htmlFolderName)));
		return builder.toString();
	}

}
