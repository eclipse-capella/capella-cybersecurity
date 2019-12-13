package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;

public class TrustedColumn extends AbstractCybersecurityColumn {
  public TrustedColumn() {
    id = getClass().getCanonicalName();
    label = Messages.ThreatColumns_Label_Trusted;
    name = Messages.ThreatColumns_Name_Trusted;
  }
  @Override
  public Object getDataValue(EObject rowObject) {
    String result = null;
    boolean hasAnyActors =
        Stream.concat(
        CybersecurityQueries.getInvolvedActors((Threat) rowObject),
        CybersecurityQueries.getInvolvedThreatSources((Threat) rowObject))
        .findAny().isPresent();
    
    if (hasAnyActors) {
        result = Stream.concat(
          CybersecurityQueries.getInvolvedActors((Threat) rowObject),
          CybersecurityQueries.getInvolvedThreatSources((Threat) rowObject))
       .filter(c -> CybersecurityQueries.isThreatSource(c))
       .findAny().isPresent() ? Messages.ThreatColumns_Trusted_no : Messages.ThreatColumns_Trusted_yes;
    }
    return result;
  }
}