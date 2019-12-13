package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

// displays the threat kinds, even if multiple different kinds threaten the asset
public class ThreatKindColumn extends AbstractCybersecurityColumn {
  public ThreatKindColumn() {
    id = getClass().getCanonicalName();
    label = Messages.PrimaryAssetColumns_Label_ThreatKind;
    name = Messages.PrimaryAssetColumns_Name_ThreatKind;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    return CybersecurityQueries.getThreatsOf(((PrimaryAsset) rowObject))
        .map(t -> t.getThreatKind() == null ? "null" : t.getThreatKind().getLiteral()) //$NON-NLS-1$
        .distinct().collect(Collectors.joining("/")); //$NON-NLS-1$
  }
}