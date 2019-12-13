package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultIntegerDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class AvailabilityColumn extends AbstractCybersecurityColumn {
  public AvailabilityColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_Availability;
    name = Messages.PrimaryAssetColumns_Name_Availability;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    SecurityNeeds sn = CybersecurityQueries.getSecurityNeeds((ExtensibleElement) rowObject);
    if (sn != null) {
      return sn.getAvailability();
    }
    
    // consistency with the property view
    return 0;
  }
  
  @Override
  public void setDataValue(EObject rowObject, Object newValue) {
    if (newValue instanceof Integer) {
      getCyberService().setAvailability((ExtensibleElement) rowObject, (Integer) newValue);
    }   
  }
  
  @Override
  protected IDisplayConverter createDisplayConverter() {
    return new DefaultIntegerDisplayConverter();
  }
}