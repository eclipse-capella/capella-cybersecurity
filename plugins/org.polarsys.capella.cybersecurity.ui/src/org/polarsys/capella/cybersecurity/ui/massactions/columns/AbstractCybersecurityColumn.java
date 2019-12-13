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
package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.polarsys.capella.cybersecurity.sirius.analysis.CybersecurityServices;
import org.polarsys.capella.cybersecurity.ui.massactions.converters.ManyRefDisplayConverter;
import org.polarsys.kitalpha.massactions.core.column.AbstractMAColumn;

public abstract class AbstractCybersecurityColumn extends AbstractMAColumn {

  protected CybersecurityServices cyberService;

  @Override
  public void setDataValue(EObject rowObject, Object newValue) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void dataChanged(Collection<EObject> newData) {
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    return null;
  }

  @Override
  protected IDisplayConverter createDisplayConverter() {
    return new ManyRefDisplayConverter();
  }

  // TODO CyberSecurityService should be a singleton, when this is done this code can be removed
  public CybersecurityServices getCyberService() {
    if (cyberService == null) {
      cyberService = new CybersecurityServices();
    }

    return cyberService;
  }

}
