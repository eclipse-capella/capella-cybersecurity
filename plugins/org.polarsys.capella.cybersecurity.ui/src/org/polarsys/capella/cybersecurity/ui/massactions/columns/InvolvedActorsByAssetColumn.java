package org.polarsys.capella.cybersecurity.ui.massactions.columns;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.ui.massactions.Messages;
import org.polarsys.kitalpha.massactions.core.painter.cell.TextAndLabelImagePainter;

public class InvolvedActorsByAssetColumn extends AbstractCybersecurityColumn {

  public InvolvedActorsByAssetColumn() {
    id = getClass().getCanonicalName();
    label = Messages.ThreatColumns_Label_InvolvedActors;
    name = Messages.ThreatColumns_Name_InvolvedActors;
  }

  @Override
  public Object getDataValue(EObject rowObject) {
    return Stream.concat(CybersecurityQueries.getInvolvedActors((PrimaryAsset) rowObject),
        CybersecurityQueries.getInvolvedThreatSources((PrimaryAsset) rowObject)).collect(Collectors.toList());
  }

  @Override
  protected ICellPainter createCellPainter() {
    return new TextAndLabelImagePainter();
  }
}