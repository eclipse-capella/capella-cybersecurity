package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

public class ComponentColumn extends AbstractCybersecurityColumn {
  public ComponentColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_Component;
    name = Messages.PrimaryAssetColumns_Name_Component;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    if (rowObject instanceof InformationPrimaryAsset) {
      return CybersecurityQueries.getSupportingComponents((InformationPrimaryAsset) rowObject)
          .collect(Collectors.toList());
    }
    if (rowObject instanceof FunctionalPrimaryAsset) {
      return CybersecurityQueries.getSupportingComponents((FunctionalPrimaryAsset) rowObject)
          .collect(Collectors.toList());
    }
    return null;
  }
}