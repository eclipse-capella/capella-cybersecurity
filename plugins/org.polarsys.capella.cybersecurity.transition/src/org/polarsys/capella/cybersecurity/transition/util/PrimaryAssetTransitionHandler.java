package org.polarsys.capella.cybersecurity.transition.util;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.capella.common.ef.command.ICommand;
import org.polarsys.capella.core.transition.system.topdown.ui.handlers.IntramodelTransitionHandler;

public class PrimaryAssetTransitionHandler extends IntramodelTransitionHandler {

  @Override
  protected ICommand createCommand(Collection<?> selection, IProgressMonitor progressMonitor) {
    return CyberTransitionUICommandHelper.getInstance().getPrimaryAssetTransitionCommand(selection, progressMonitor);
  }
}
