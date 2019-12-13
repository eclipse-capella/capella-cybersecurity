package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

// displays the rationales of threats threatening the asset
public class RationaleColumn extends AbstractCybersecurityColumn {
  public RationaleColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_Rationale;
    name = Messages.PrimaryAssetColumns_Name_Rationale;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    return CybersecurityQueries.getThreatsOf(((PrimaryAsset) rowObject)).map(t -> t.getRationale())
        .filter(r -> r != null && !r.isEmpty()).collect(Collectors.joining("/")); //$NON-NLS-1$
  }
}