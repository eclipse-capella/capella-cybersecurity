package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

public class ThreatSourceProfileColumn extends AbstractCybersecurityColumn {
  public ThreatSourceProfileColumn() {
    id = getClass().getCanonicalName();
    label = Messages.ThreatColumns_Label_ThreatSourceProfile;
    name = Messages.ThreatColumns_Name_ThreatSourceProfile;
  }
  @Override
  public Object getDataValue(EObject rowObject) {
    return CybersecurityQueries.getInvolvedThreatSources((Threat)rowObject)
        .flatMap(c -> c.getOwnedExtensions().stream())
        .filter(TrustBoundaryStorage.class::isInstance)
        .map(e -> (((TrustBoundaryStorage)e).getThreatSourceProfile()))
        .reduce(Math::max).orElse(0);
  }
}