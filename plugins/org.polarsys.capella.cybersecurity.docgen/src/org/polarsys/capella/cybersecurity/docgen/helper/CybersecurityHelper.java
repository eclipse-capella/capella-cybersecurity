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
package org.polarsys.capella.cybersecurity.docgen.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.ctx.SystemComponent;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FunctionalChain;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.interaction.AbstractCapability;
import org.polarsys.capella.core.data.oa.Entity;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.cybersecurity.docgen.constants.ConstantsCybersecurityDocGen;
import org.polarsys.capella.cybersecurity.docgen.utils.HTMLHelper;
import org.polarsys.capella.cybersecurity.model.CybersecurityPkg;
import org.polarsys.capella.cybersecurity.model.CybersecurityQueries;
import org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset;
import org.polarsys.capella.cybersecurity.model.FunctionalPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.InformationPrimaryAsset;
import org.polarsys.capella.cybersecurity.model.PrimaryAsset;
import org.polarsys.capella.cybersecurity.model.SecurityNeeds;
import org.polarsys.capella.cybersecurity.model.Threat;
import org.polarsys.capella.cybersecurity.model.TrustBoundaryStorage;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

public class CybersecurityHelper {
	public static boolean hasCybersecurityPropertyView(EObject element) {
		return element instanceof FunctionalChain || element instanceof ExchangeItem
				|| element instanceof AbstractFunction
				|| element instanceof Component;
	}

	public static String getThreatSourceAndRationale(EObject element) {
		StringBuilder builder = new StringBuilder();
		if (hasThreatSourceInfo(element)) {
			Optional<Integer> threatSourceProfile = ((CapellaElement) element).getOwnedExtensions().stream()
					.filter(ext -> ext instanceof TrustBoundaryStorage).findAny()
					.map(trb -> ((TrustBoundaryStorage) trb).getThreatSourceProfile());
			Boolean isThreatSource = ((CapellaElement) element).getOwnedExtensions().stream()
					.filter(ext -> ext instanceof TrustBoundaryStorage).findAny()
					.map(trb -> ((TrustBoundaryStorage) trb).isThreatSource()).orElse(false);
			Boolean isTrusted = ((CapellaElement) element).getOwnedExtensions().stream()
					.filter(ext -> ext instanceof TrustBoundaryStorage).findAny()
					.map(trb -> ((TrustBoundaryStorage) trb).isTrusted()).orElse(null);
			Optional<String> rationale = ((CapellaElement) element).getOwnedExtensions().stream()
					.filter(ext -> ext instanceof TrustBoundaryStorage).findAny()
					.map(trb -> ((TrustBoundaryStorage) trb).getRationale());
			List<String> listTrustBoundaryInfo = new ArrayList<>();

			if (isTrusted == null || isTrusted) {
				listTrustBoundaryInfo.add(HTMLHelper.getBold(ConstantsCybersecurityDocGen.TRUSTED));
			} else {
				listTrustBoundaryInfo.add(HTMLHelper.getBold(ConstantsCybersecurityDocGen.NOT_TRUSTED));
			}

			if (isThreatSource) {
				listTrustBoundaryInfo.add(HTMLHelper.getBold(ConstantsCybersecurityDocGen.THREAT_SOURCE));
			}

			if (threatSourceProfile.isPresent()) {
				listTrustBoundaryInfo.add(HTMLHelper.getListElement(ConstantsCybersecurityDocGen.PROFILE,
						threatSourceProfile.get().toString()));
			}

			if (listTrustBoundaryInfo.size() > 0) {
				builder.append(HTMLHelper.getSubtitle(ConstantsCybersecurityDocGen.TRUST_BOUNDARY));
				builder.append(HTMLHelper.getUlList(listTrustBoundaryInfo.toArray(new String[listTrustBoundaryInfo.size()])));
			}

			if (rationale.isPresent()) {
				builder.append(HTMLHelper.getSubtitle(ConstantsCybersecurityDocGen.RATIONALE));
				builder.append(HTMLHelper.getParagraph(rationale.get().toString()));
			}
		}
		return builder.toString();
	}
	
	public static String getInvolvingThreats(EObject element, String htmlFolderName) {
	  String data = "";
    if (element instanceof Component) {
      List<Threat> threats = CybersecurityQueries.getInvolvingThreats((Component) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(threats, htmlFolderName, ConstantsCybersecurityDocGen.INVOLVING_THREATS);
    }
    return data;
	}

	public static String getExchangeItemPrimaryAssets(EObject element, String htmlFolderName) {
	  String data = "";
	  if (element instanceof ExchangeItem) {
      List<InformationPrimaryAsset> assets = CybersecurityQueries.getInformationPrimaryAssets((ExchangeItem) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, ConstantsCybersecurityDocGen.INFORMATION_PRIMARY_ASSETS);
    }
    return data;
	}
	
  public static String getFunctionalPrimaryAssetsTitle(EObject element) {
    if (BlockArchitectureExt.getRootBlockArchitecture(element) instanceof OperationalAnalysis) {
      return ConstantsCybersecurityDocGen.OPERATIONAL_PRIMARY_ASSETS;
    }
    return ConstantsCybersecurityDocGen.FUNCTIONAL_PRIMARY_ASSETS;
  }

  public static String getFunctionFunctionalPrimaryAssets(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof AbstractFunction) {
      List<FunctionalPrimaryAsset> assets = CybersecurityQueries.getFunctionalPrimaryAssets((AbstractFunction) element)
          .collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, getFunctionalPrimaryAssetsTitle(element));
    }
    return data;
  }

  public static String getFunctionInformationPrimaryAssets(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof AbstractFunction) {
      List<InformationPrimaryAsset> assets = CybersecurityQueries
          .getInformationPrimaryAssets((AbstractFunction) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, ConstantsCybersecurityDocGen.INFORMATION_PRIMARY_ASSETS);
    }
    return data;
  }

  public static String getFunctionalChainPrimaryAssets(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof FunctionalChain) {
      List<FunctionalPrimaryAsset> assets = CybersecurityQueries.getFunctionalPrimaryAssets((FunctionalChain) element)
          .collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, getFunctionalPrimaryAssetsTitle(element));
    }
    return data;
  }

	public static String getCiatSection(EObject element) {
		StringBuilder builder = new StringBuilder();
		if (hasCiat(element)) {
			Optional<SecurityNeeds> osn = ((ExtensibleElement) element).getOwnedExtensions().stream()
					.filter(SecurityNeeds.class::isInstance).map(SecurityNeeds.class::cast).findAny();
			if (osn.isPresent()) {
				SecurityNeeds sn = osn.get();
				builder.append(HTMLHelper.getSubtitle(ConstantsCybersecurityDocGen.CIAT));
				String confidentiality = getSecurityNeedValue(sn.getConfidentialityValue());
				String integrity = getSecurityNeedValue(sn.getIntegrityValue());
				String traceability = getSecurityNeedValue(sn.getTraceabilityValue());
				String availability = getSecurityNeedValue(sn.getAvailabilityValue());
				builder.append(HTMLHelper.getUlList(
						HTMLHelper.getListElement(ConstantsCybersecurityDocGen.CONFIDENTIALITY, confidentiality),
						HTMLHelper.getListElement(ConstantsCybersecurityDocGen.INTEGRITY, integrity),
						HTMLHelper.getListElement(ConstantsCybersecurityDocGen.AVAILABILITY, availability),
						HTMLHelper.getListElement(ConstantsCybersecurityDocGen.TRACEABILITY, traceability)));
			}
		}
		return builder.toString();
	}

	public static String getContent(CapellaElement capellaElement, String htmlFolderName) {
		List<Class> allowedContent = Arrays.asList(Threat.class, FunctionalPrimaryAsset.class,
	      InformationPrimaryAsset.class, EnterprisePrimaryAsset.class, CybersecurityPkg.class);
		
		List<CapellaElement> contentList = capellaElement.eContents().stream()
				.filter(eobj -> allowedContent.stream().anyMatch(clazz -> clazz.isInstance(eobj)))
				.map(eobj -> (CapellaElement) eobj).collect(Collectors.toList());
		
		return getHtmlDataToAppend(contentList, htmlFolderName, ConstantsCybersecurityDocGen.CONTENT);
	}

  public static String getThreatKind(EObject element) {
    StringBuilder builder = new StringBuilder();
    if (element instanceof Threat) {
      Threat threat = (Threat) element;
      String kind = threat.getKind().getLabel();
      builder.append(HTMLHelper.getSubtitle(ConstantsCybersecurityDocGen.THREAT_KIND));
      builder.append(HTMLHelper.getParagraph(kind));
    }
    return builder.toString();
  }

	public static String getLevel(EObject element) {
    StringBuilder builder = new StringBuilder();
    if (element instanceof Threat) {
      Threat threat = (Threat) element;
      builder.append(HTMLHelper.getSubtitle(ConstantsCybersecurityDocGen.LEVEL));
      String level = String.valueOf(threat.getLevel());
      builder.append(HTMLHelper.getParagraph(level != null ? level : " "));
    }
    return builder.toString();
	}

  public static String getRationale(EObject element) {
    StringBuilder builder = new StringBuilder();
    if (element instanceof Threat) {
      Threat threat = (Threat) element;
      String rationale = threat.getRationale();
      if (rationale != null) {
        builder.append(HTMLHelper.getSubtitle(ConstantsCybersecurityDocGen.RATIONALE));
        builder.append(HTMLHelper.getParagraph(rationale));
      }
    }
    return builder.toString();
  }

	public static String getRealizingPrimaryAsset(CapellaElement element, String htmlFolderName) {
		StringBuilder builder = new StringBuilder();
		if (hasRealizingPrimaryAsset(element)) {
			builder.append(getRelationsElements(element, ConstantsCybersecurityDocGen.PRIMARY_ASSET_REALIZING,
					htmlFolderName, true, PrimaryAsset.class));
		}
		return builder.toString();
	}

	public static String getRealizedPrimaryAsset(CapellaElement element, String htmlFolderName) {
		StringBuilder builder = new StringBuilder();
		if (hasRealizedPrimaryAsset(element)) {
			builder.append(getRelationsElements(element, ConstantsCybersecurityDocGen.PRIMARY_ASSET_REALIZED,
					htmlFolderName, false, PrimaryAsset.class));
		}
		return builder.toString();
	}

	public static String getReferencedCapellaElement(CapellaElement element, String htmlFolderName) {
		StringBuilder builder = new StringBuilder();
		if (hasReferencesCapellaElement(element)) {
			builder.append(getRelationsElements(element, getReferencedCapellaElementTitle(element), htmlFolderName, false,
					FunctionalChain.class, ExchangeItem.class, AbstractFunction.class));
		}
		return builder.toString();
	}

	private static String getRelationsElements(CapellaElement capellaElement, String title, String htmlFolderName,
			boolean isIncoming, Class... classes) {
		StringBuilder builder = new StringBuilder();
		List<Class> listOfClasses = Arrays.asList(classes);
		List<EObject> elements = getRelations(capellaElement, listOfClasses, isIncoming);
		if (elements.size() > 0) {
			builder.append(HTMLHelper.getSubtitle(title));
			builder.append(HTMLHelper.getUlList(
					elements.stream().map(el -> HTMLHelper.getLinkElementList((CapellaElement) el, htmlFolderName))
							.toArray(String[]::new)));
		}
		return builder.toString();
	}

	private static boolean hasThreatSourceInfo(EObject element) {
		return element instanceof Component;
	}

  public static String getThreatenedBy(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof PrimaryAsset) {
      List<Threat> threats = CybersecurityQueries.getThreatsOf((PrimaryAsset) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(threats, htmlFolderName, ConstantsCybersecurityDocGen.THREATENED_BY);
    }
    return data;
  }
  
  public static String getThreatenedPrimaryAssets(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof Threat) {
      List<PrimaryAsset> assets = CybersecurityQueries.getThreatenedPrimaryAssets((Threat) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, ConstantsCybersecurityDocGen.THREATENED_PRIMARY_ASSETS);
    }
    return data;
  }
  
  public static String getInvolvedActors(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof Threat) {
      List<Component> actors = CybersecurityQueries.getInvolvedActors((Threat) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(actors, htmlFolderName, ConstantsCybersecurityDocGen.INVOLVED_ACTORS);
    }
    return data;
  }
  
  public static String getInvolvedThreatSources(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof Threat) {
      List<Component> actors = CybersecurityQueries.getInvolvedThreatSources((Threat) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(actors, htmlFolderName, ConstantsCybersecurityDocGen.INVOLVED_THREAT_SOURCES);
    }
    return data;
  }

  public static String getPrimaryAssets(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof EnterprisePrimaryAsset) {
      List<CapellaElement> assets = ((EnterprisePrimaryAsset) element).getPrimaryAssets().stream().collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, ConstantsCybersecurityDocGen.PRIMARY_ASSETS);
    }
    return data;
  }
  
  public static String getReferencingEnterprisePrimaryAssets(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof PrimaryAsset) {
      List<CapellaElement> assets = CybersecurityQueries.getEnterprisePrimaryAssets((PrimaryAsset) element)
          .collect(Collectors.toList());
      data = getHtmlDataToAppend(assets, htmlFolderName, ConstantsCybersecurityDocGen.ENTERPRISE_PRIMARY_ASSETS);
    }
    return data;
  }
  
  public static String getThreatsContent(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof Threat) {
      AbstractCapability threat = (AbstractCapability) element;
      List<CapellaElement> elements = new ArrayList<>();
      elements.addAll(threat.getOwnedFunctionalChains());
      elements.addAll(threat.getOwnedScenarios());
      data = getHtmlDataToAppend(elements, htmlFolderName, ConstantsCybersecurityDocGen.CONTENT);
    }
    return data;
  }
  
  public static String getThreatSourceUse(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof Component) {
      List<Component> used = CybersecurityQueries.getUsedActors((Component) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(used, htmlFolderName, ConstantsCybersecurityDocGen.USE);
    }
    return data;
  }
  
  public static String getThreatSourceUsedBy(EObject element, String htmlFolderName) {
    String data = "";
    if (element instanceof Component) {
      List<Component> used = CybersecurityQueries.getUsedByThreatSource((Component) element).collect(Collectors.toList());
      data = getHtmlDataToAppend(used, htmlFolderName, ConstantsCybersecurityDocGen.USED_BY);
    }
    return data;
  }
  
  public static String getHtmlDataToAppend(Collection<? extends CapellaElement> elements, String htmlFolderName, String category) {
    StringBuilder builder = new StringBuilder();
    if (!elements.isEmpty()) {
      builder.append(HTMLHelper.getSubtitle(category));
      builder.append(HTMLHelper.getUlList(
          elements.stream().map(elem -> HTMLHelper.getLinkElementList(elem, htmlFolderName)).toArray(String[]::new)));
    }
    return builder.toString();
  }
  
	private static boolean hasCiat(EObject element) {
		return element instanceof AbstractFunction || element instanceof ExchangeItem
				|| element instanceof PrimaryAsset || element instanceof Threat;
	}

	private static boolean hasRealizedPrimaryAsset(EObject element) {
		return element instanceof PrimaryAsset;
	}

	private static boolean hasReferencesCapellaElement(EObject element) {
		return element instanceof FunctionalPrimaryAsset || element instanceof InformationPrimaryAsset;
	}

	private static boolean hasRealizingPrimaryAsset(EObject element) {
		return element instanceof PrimaryAsset;
	}

	private static String getSecurityNeedValue(EnumerationPropertyLiteral literal) {
		if (literal != null) {
			return literal.getLabel();
		}

		return "0";
	}

	private static List<EObject> getRelations(CapellaElement capellaElement, List<Class> listOfClasses,
			boolean isIncoming) {
		List<AbstractTrace> traces = isIncoming ? capellaElement.getIncomingTraces()
				: capellaElement.getOutgoingTraces();
		List<EObject> elements = traces.stream()
				.map(trace -> isIncoming ? trace.getSourceElement() : trace.getTargetElement())
				.filter(element -> listOfClasses.stream().anyMatch(clazz -> clazz.isInstance(element)))
				.collect(Collectors.toList());
		if (listOfClasses.stream().anyMatch(clazz -> clazz.equals(ExchangeItem.class)) && !isIncoming) {
			elements.addAll(getOutgoingExchangeItem(capellaElement));
		}
		if (listOfClasses.stream().anyMatch(clazz -> clazz.equals(AbstractFunction.class)) && !isIncoming) {
			elements.addAll(getOutgoingFunctions(capellaElement));
		}
		if (listOfClasses.stream().anyMatch(clazz -> clazz.equals(AbstractFunction.class)) && !isIncoming) {
			elements.addAll(getOutgoingFunctionalChains(capellaElement));
		}
		return elements;

	}

	private static List<EObject> getOutgoingExchangeItem(CapellaElement capellaElement) {
		List<EObject> exchangeItems = new ArrayList<>();
		if (capellaElement instanceof InformationPrimaryAsset) {
			exchangeItems = ((InformationPrimaryAsset) capellaElement).getExchangeItems().stream()
					.map(exchangeItem -> (EObject) exchangeItem).collect(Collectors.toList());
		}
		return exchangeItems;
	}

	private static List<EObject> getOutgoingFunctions(CapellaElement capellaElement) {
		List<EObject> functions = new ArrayList<>();
		if (capellaElement instanceof FunctionalPrimaryAsset) {
			functions = ((FunctionalPrimaryAsset) capellaElement).getFunctions().stream()
					.map(function -> (EObject) function).collect(Collectors.toList());
		}
		return functions;
	}

	private static List<EObject> getOutgoingFunctionalChains(CapellaElement capellaElement) {
		List<EObject> functionalChains = new ArrayList<>();
		if (capellaElement instanceof FunctionalPrimaryAsset) {
			functionalChains = ((FunctionalPrimaryAsset) capellaElement).getFunctionalChains().stream()
					.map(functionalChain -> (EObject) functionalChain).collect(Collectors.toList());
		}
		return functionalChains;
	}

	private static String getReferencedCapellaElementTitle(EObject element) {
    if (element instanceof FunctionalPrimaryAsset) {
      BlockArchitecture ba = BlockArchitectureExt.getRootBlockArchitecture(element);
      if (ba instanceof OperationalAnalysis) {
        return ConstantsCybersecurityDocGen.REFERENCED_CAPELLA_ELEMENT_PA_OA;
      }
      return ConstantsCybersecurityDocGen.REFERENCED_CAPELLA_ELEMENT_PA_OTHERS;
    } else if (element instanceof InformationPrimaryAsset) {
      return ConstantsCybersecurityDocGen.REFERENCED_CAPELLA_ELEMENT_IPA;
    }

		throw new InternalError("This function cannot be applied on " + element.eClass().getName());
	}
}