/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.validation.design.consistency;

import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.utils.NamingHelper;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.validation.util.CyberValidationHelper;

public class CY_DCON_03_ThreatOrAsset_Realization extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    EObject element = ctx.getTarget();
    BlockArchitecture currentBa = BlockArchitectureExt.getRootBlockArchitecture(element);
    if ((element instanceof Threat || element instanceof PrimaryAsset) && !(currentBa instanceof PhysicalArchitecture)) {
      NamedElement currentElement = (NamedElement) element;
      if (currentElement.getIncomingTraces().stream().map(trace -> trace.getSourceElement()).filter(elem -> {
        BlockArchitecture elemBa = BlockArchitectureExt.getRootBlockArchitecture(elem);
        BlockArchitecture prevBa = BlockArchitectureExt.getPreviousBlockArchitecture(elemBa);
        return prevBa.equals(currentBa);
      }).collect(Collectors.toList()).isEmpty()) {
        return ctx.createFailureStatus(currentElement, getTitleLabel(currentElement),
            EObjectLabelProviderHelper.getMetaclassLabel(currentElement, false), getAllocatingArchitecture(currentBa));
      }
    }
    return ctx.createSuccessStatus();
  }

  private String getTitleLabel(EObject obj) {
    if (obj instanceof Threat) {
      return NamingHelper.getTitleLabel(obj);
    } else if (obj instanceof PrimaryAsset) {
      return CyberValidationHelper.getPATitleLabel((PrimaryAsset)obj);
    }
    return "";
  }
  
  private String getAllocatingArchitecture(BlockArchitecture ba) {
    EList<BlockArchitecture> allocatingArch = ba.getAllocatingArchitectures();
    if(!allocatingArch.isEmpty()) {
      BlockArchitecture arch = allocatingArch.get(0);
      return EObjectLabelProviderHelper.getMetaclassLabel(arch, false);
    }

    return "";
  }
}