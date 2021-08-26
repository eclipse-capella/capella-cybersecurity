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
