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
package org.polarsys.capella.cybersecurity.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class CybersecurityUIActivator extends AbstractUIPlugin {

  public static final String VIEWPOINT_ID = "org.polarsys.capella.cybersecurity"; //$NON-NLS-1$

  private static CybersecurityUIActivator __plugin;

 @Override
 public void start(BundleContext context_p) throws Exception {
   super.start(context_p);
   __plugin = this;
 }

 /**
  * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
  */
 @Override
 public void stop(BundleContext context_p) throws Exception {
   __plugin = null;
   super.stop(context_p);
 }

 /**
  * Returns the shared instance
  * 
  * @return the shared instance
  */
 public static CybersecurityUIActivator getDefault() {
   return __plugin;
 }

  
}
