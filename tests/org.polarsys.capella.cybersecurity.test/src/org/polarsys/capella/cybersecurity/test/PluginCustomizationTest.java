/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.cybersecurity.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.core.internal.preferences.legacy.ProductPreferencesService;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.polarsys.capella.test.framework.api.BasicTestCase;

/**
 * This test ensures that all preferences customized in Capella product are also in Cybersecurity product
 */
public class PluginCustomizationTest extends BasicTestCase {

  @Override
  public void test() throws Exception {
    String ini = Platform.getProduct().getProperty(ProductPreferencesService.PRODUCT_KEY);

    Properties capellaIni = loadProperties(Platform.getBundle("org.polarsys.capella.rcp").getResource(ini));
    Properties cybersecurityIni = loadProperties(
        Platform.getBundle("org.polarsys.capella.cybersecurity.rcp").getResource(ini));

    ArrayList<String> errors = new ArrayList<>();

    for (Object key : capellaIni.keySet()) {

      if (!cybersecurityIni.containsKey(key)) {
        errors.add(NLS.bind("Missing key: {0}", key));

      } else if (cybersecurityIni.containsKey(key) && !capellaIni.get(key).equals(cybersecurityIni.get(key))) {
        errors.add(NLS.bind("Different value for key: {0}: {1}", key, capellaIni.get(key)));
      }
    }

    assertTrue(
        NLS.bind("Errors in plugin customization: {0}\n", ini) + errors.stream().collect(Collectors.joining("\n")),
        errors.isEmpty());
  }

  private Properties loadProperties(URL url) {
    assertNotNull(url);
    Properties result = new Properties();
    InputStream input = null;
    try {
      input = url.openStream();
      result.load(input);
    } catch (IOException e) {
      assertTrue(e.getMessage(), false);
    } finally {
      if (input != null)
        try {
          input.close();
        } catch (IOException e) {
          // ignore
        }
    }
    return result;
  }

}
