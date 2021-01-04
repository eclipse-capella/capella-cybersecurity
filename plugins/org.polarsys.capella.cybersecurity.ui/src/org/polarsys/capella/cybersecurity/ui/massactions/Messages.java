/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.ui.massactions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.polarsys.capella.cybersecurity.ui.massactions.messages"; //$NON-NLS-1$
  public static String PrimaryAssetColumns_Label_Availability;
  public static String PrimaryAssetColumns_Label_Component;
  public static String PrimaryAssetColumns_Label_Confidentiality;
  public static String PrimaryAssetColumns_Label_Integrity;
  public static String PrimaryAssetColumns_Label_MaxThreatLevel;
  public static String PrimaryAssetColumns_Label_MaxThreatSourceProfile;
  public static String PrimaryAssetColumns_Label_Rationale;
  public static String PrimaryAssetColumns_Label_RealizedBy;
  public static String PrimaryAssetColumns_Label_ThreatKind;
  public static String PrimaryAssetColumns_Label_Traceability;
  public static String PrimaryAssetColumns_Label_Type;
  public static String PrimaryAssetColumns_Name_Availability;
  public static String PrimaryAssetColumns_Name_Component;
  public static String PrimaryAssetColumns_Name_Confidentiality;
  public static String PrimaryAssetColumns_Name_Integrity;
  public static String PrimaryAssetColumns_Name_MaxThreatLevel;
  public static String PrimaryAssetColumns_Name_MaxThreatSourceProfile;
  public static String PrimaryAssetColumns_Name_Rationale;
  public static String PrimaryAssetColumns_Name_RealizedBy;
  public static String PrimaryAssetColumns_Name_ThreatKind;
  public static String PrimaryAssetColumns_Name_Traceability;
  public static String PrimaryAssetColumns_Name_Type;
  public static String PrimaryAssetColumns_PrimaryAssetType_functional;
  public static String PrimaryAssetColumns_PrimaryAssetType_information;
  public static String ThreatColumns_Label_InvolvedActors;
  public static String ThreatColumns_Label_ThreatSourceProfile;
  public static String ThreatColumns_Label_Trusted;
  public static String ThreatColumns_Name_InvolvedActors;
  public static String ThreatColumns_Name_ThreatSourceProfile;
  public static String ThreatColumns_Name_Trusted;
  public static String ThreatColumns_Trusted_no;
  public static String ThreatColumns_Trusted_yes;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
