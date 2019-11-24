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
package org.polarsys.capella.cybersecurity.ui.massactions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.polarsys.kitalpha.massactions.core.column.AbstractMAColumn;

public abstract class AbstractCybersecurityColumn extends AbstractMAColumn {

  @Override
  public void setDataValue(EObject rowObject, Object newValue) {
   throw new UnsupportedOperationException();
  }

  @Override
  public void dataChanged(Collection<EObject> newData) {
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected IDisplayConverter createDisplayConverter() {
    return new ManyRefDisplayConverter();
  }

  
  
}
