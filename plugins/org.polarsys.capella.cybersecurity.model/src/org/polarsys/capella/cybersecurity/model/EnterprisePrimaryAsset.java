
package org.polarsys.capella.cybersecurity.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enterprise Primary Asset</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.cybersecurity.model.EnterprisePrimaryAsset#getPrimaryAssets <em>Primary Assets</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getEnterprisePrimaryAsset()
 * @model
 * @generated
 */

public interface EnterprisePrimaryAsset extends PrimaryAsset {

  /**
   * Returns the value of the '<em><b>Primary Assets</b></em>' reference list.
   * The list contents are of type {@link org.polarsys.capella.cybersecurity.model.PrimaryAsset}.
  
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Primary Assets</em>' reference list.
   * @see org.polarsys.capella.cybersecurity.model.CybersecurityPackage#getEnterprisePrimaryAsset_PrimaryAssets()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   *        annotation="http://www.polarsys.org/capella/derived viatra.variant='patternbody' viatra.expression='Threat.outgoingTraces(self, acr);\nAbstractCapabilityRealization.realizedCapability(acr, target);'"
   *        annotation="http://www.polarsys.org/capella/semantic"
   *        annotation="http://www.polarsys.org/capella/MNoE/CapellaLike/Mapping UML/SysML\040semantic\040equivalences='keyword::none' explanation='Derived and transient' constraints='none'"
   * @generated
   */

  EList<PrimaryAsset> getPrimaryAssets();

} // EnterprisePrimaryAsset
