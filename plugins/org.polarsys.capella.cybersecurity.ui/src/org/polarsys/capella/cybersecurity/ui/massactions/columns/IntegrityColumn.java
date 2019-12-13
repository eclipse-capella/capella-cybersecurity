package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultIntegerDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class IntegrityColumn extends AbstractCybersecurityColumn {
  public IntegrityColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_Integrity;
    name = Messages.PrimaryAssetColumns_Name_Integrity;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    SecurityNeeds sn = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) rowObject);
    if (sn != null) {
      return sn.getIntegrity();
    }
    
    // consistency with the property view
    return 0;
  }

  @Override
  public void setDataValue(EObject rowObject, Object newValue) {

    if (newValue instanceof Integer) {
      getCyberService().setIntegrity((ExtensibleElement) rowObject, (Integer) newValue);
    }

  }

  @Override
  protected IDisplayConverter createDisplayConverter() {
    return new DefaultIntegerDisplayConverter();
  }
}