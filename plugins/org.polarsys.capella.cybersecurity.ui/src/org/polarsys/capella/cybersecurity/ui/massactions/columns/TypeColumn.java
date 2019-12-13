package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityPackage;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

public class TypeColumn extends AbstractCybersecurityColumn {
  public TypeColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_Type;
    name = Messages.PrimaryAssetColumns_Name_Type;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    if (rowObject.eClass() == CybersecurityPackage.Literals.FUNCTIONAL_PRIMARY_ASSET) {
      return Messages.PrimaryAssetColumns_PrimaryAssetType_functional;
    }
    if (rowObject.eClass() == CybersecurityPackage.Literals.INFORMATION_PRIMARY_ASSET) {
      return Messages.PrimaryAssetColumns_PrimaryAssetType_information;
    }
    return rowObject.eClass().getName();
  }
}