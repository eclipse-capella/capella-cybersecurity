/*******************************************************************
* Copyright © 2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
package org.polarsys.capella.cybersecurity.test.transition;

import org.polarsys.capella.core.data.ctx.SystemFunction;
import org.polarsys.capella.core.data.ctx.SystemFunctionPkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.la.LogicalFunction;
import org.polarsys.capella.core.data.la.LogicalFunctionPkg;
import org.polarsys.capella.core.data.oa.OperationalActivity;
import org.polarsys.capella.core.data.pa.PhysicalFunction;
import org.polarsys.capella.core.data.pa.PhysicalFunctionPkg;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt.Type;
import org.polarsys.capella.cybersecurity.model.CybersecurityFactory;
import org.polarsys.capella.cybersecurity.model.FunctionStorage;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAssetMember;

public class FunctionalPrimaryAssetTransitionTest extends PrimaryAssetTransitionTest {
  private static final String OPERATIONAL_ACTIVITY_1 = "618e273c-5b56-4855-8a43-18217359fd7b";

  SystemFunction systemFunction;
  LogicalFunction logicalFunction;
  FunctionStorage functionStorage;

  FunctionStorage transitionedFunctionStorage;
  ExchangeItem transitionedExchangeItem;

  @Override
  protected PrimaryAsset createPrimaryAsset() {
    return CybersecurityFactory.eINSTANCE.createFunctionalPrimaryAsset();
  }

  @Override
  protected void checkPAMMembersTransitioned(Type level) {
    switch(level) {
    case SA:
      SystemFunction rootFunctionSA = ((SystemFunctionPkg) BlockArchitectureExt.getFunctionPkg(saArch, false))
          .getOwnedSystemFunctions().get(0);
      systemFunction = (SystemFunction) mustBeTransitionedDirecltyContainedBy(OPERATIONAL_ACTIVITY_1,
          rootFunctionSA);
      transitionedFunctionStorage = (FunctionStorage) mustBeTransitionedDirecltyContainedBy(functionStorage.getId(),
          systemFunction);
      transitionedFunctionStorage.getExchangedItems();
      transitionedExchangeItem = (ExchangeItem) mustBeTransitionedDirecltyContainedBy(exchangeItem.getId(),
          BlockArchitectureExt.getInterfacePkg(saArch, false));
      break;
    case LA:
      LogicalFunction rootFunctionLA = ((LogicalFunctionPkg) BlockArchitectureExt.getFunctionPkg(laArch, false))
          .getOwnedLogicalFunctions().get(0);
      logicalFunction = (LogicalFunction) mustBeTransitionedDirecltyContainedBy(systemFunction.getId(), rootFunctionLA);
      transitionedFunctionStorage = (FunctionStorage) mustBeTransitionedDirecltyContainedBy(
          transitionedFunctionStorage.getId(), logicalFunction);
      transitionedExchangeItem = (ExchangeItem) mustBeTransitionedDirecltyContainedBy(transitionedExchangeItem.getId(),
          BlockArchitectureExt.getInterfacePkg(laArch, false));
      break;
    case PA:
      PhysicalFunction rootFunctionPA = ((PhysicalFunctionPkg) BlockArchitectureExt.getFunctionPkg(paArch, false))
          .getOwnedPhysicalFunctions().get(0);
      PhysicalFunction physicalFunction = (PhysicalFunction) mustBeTransitionedDirecltyContainedBy(
          logicalFunction.getId(), rootFunctionPA);
      mustBeTransitionedDirecltyContainedBy(transitionedFunctionStorage.getId(), physicalFunction);
      mustBeTransitionedDirecltyContainedBy(transitionedExchangeItem.getId(),
          BlockArchitectureExt.getInterfacePkg(paArch, false).getOwnedInterfacePkgs().get(0));
      break;
    default:
      break;
    }
  }

  @Override
  protected void addPAMMembers() {
    // create the function storage, associate the exchange item with it and add the function storage to a newly created
    // function associated with the primary asset
    OperationalActivity operationalActivity = getObject(OPERATIONAL_ACTIVITY_1);
    functionStorage = CybersecurityFactory.eINSTANCE.createFunctionStorage();

    functionStorage.setDataStorage(true);
    functionStorage.setRemanentData(true);
    functionStorage.getExchangedItems().add(exchangeItem);

    PrimaryAssetMember primaryAssetMember = CybersecurityFactory.eINSTANCE.createPrimaryAssetMember();
    operationalActivity.getOwnedExtensions().add(functionStorage);
    primaryAssetMember.setMember(operationalActivity);
    
    primaryAssetMembers.add(primaryAssetMember);
  }

}
