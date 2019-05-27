/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.sirius.analysis;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CybersecuritySiriusAnalysisActivator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.polarsys.capella.cybersecurity.sirius.analysis"; //$NON-NLS-1$
  private static final String ODESIGN_PATH = "/analysis/cybersecurity.odesign"; //$NON-NLS-1$
  private static Set<Viewpoint> REGISTERED_VIEWPOINTS = new HashSet<>();

  // The shared instance
  private static CybersecuritySiriusAnalysisActivator plugin;

  /**
   * The constructor
   */
  public CybersecuritySiriusAnalysisActivator() {
  }

  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    REGISTERED_VIEWPOINTS.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + ODESIGN_PATH));
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    REGISTERED_VIEWPOINTS.forEach(ViewpointRegistry.getInstance()::disposeFromPlugin);
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static CybersecuritySiriusAnalysisActivator getDefault() {
    return plugin;
  }

}
