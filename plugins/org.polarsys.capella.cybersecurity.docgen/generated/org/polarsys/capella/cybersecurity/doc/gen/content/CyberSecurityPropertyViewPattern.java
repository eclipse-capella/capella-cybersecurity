/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *   
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
//Generated with EGF 1.6.2.201911290829
package org.polarsys.capella.cybersecurity.doc.gen.content;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.capella.cybersecurity.docgen.helper.CybersecurityHelper;
import org.eclipse.core.runtime.Path;

public class CyberSecurityPropertyViewPattern {
  protected static String nl;

  public static synchronized CyberSecurityPropertyViewPattern create(String lineSeparator) {
    nl = lineSeparator;
    CyberSecurityPropertyViewPattern result = new CyberSecurityPropertyViewPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public CyberSecurityPropertyViewPattern() {
    //Here is the constructor
    StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).

  }

  public String generate(Object argument) throws Exception {
    final StringBuffer stringBuffer = new StringBuffer();

    InternalPatternContext ctx = (InternalPatternContext) argument;
    Map<String, String> queryCtx = null;
    IQuery.ParameterDescription paramDesc = null;
    Node.Container currentNode = ctx.getNode();

    List<Object> documentTitleList = null;
    //this pattern can only be called by another (i.e. it's not an entry point in execution)
    List<Object> elementList = null;
    //this pattern can only be called by another (i.e. it's not an entry point in execution)

    for (Object documentTitleParameter : documentTitleList) {
      for (Object elementParameter : elementList) {

        this.documentTitle = (java.lang.String) documentTitleParameter;
        this.element = (org.eclipse.emf.ecore.EObject) elementParameter;

        if (preCondition(ctx)) {
          ctx.setNode(new Node.Container(currentNode, getClass()));
          orchestration(ctx);
        }

      }
    }
    ctx.setNode(currentNode);
    if (ctx.useReporter()) {
      ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
    }

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }

  public String orchestration(PatternContext ctx) throws Exception {
    InternalPatternContext ictx = (InternalPatternContext) ctx;

    method_content(new StringBuffer(), ictx);

    if (ictx.useReporter()) {
      Map<String, Object> parameterValues = new HashMap<String, Object>();
      parameterValues.put("documentTitle", this.documentTitle);
      parameterValues.put("element", this.element);
      String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
      String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
      ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    }
    return null;
  }

  protected java.lang.String documentTitle = null;

  public void set_documentTitle(java.lang.String object) {
    this.documentTitle = object;
  }

  protected org.eclipse.emf.ecore.EObject element = null;

  public void set_element(org.eclipse.emf.ecore.EObject object) {
    this.element = object;
  }

  public Map<String, Object> getParameters() {
    final Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("documentTitle", this.documentTitle);
    parameters.put("element", this.element);
    return parameters;
  }

  protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    Path pathToHtmlFolder = new Path(ctx.getValue("outputFolder").toString());
    String htmlFolderName = pathToHtmlFolder.lastSegment();
    stringBuffer.append(CybersecurityHelper.getCiatSection(element));
    stringBuffer.append(CybersecurityHelper.getExchangeItemPrimaryAssets(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getFunctionFunctionalPrimaryAssets(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getFunctionInformationPrimaryAssets(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getFunctionalChainPrimaryAssets(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getInvolvingThreats(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getThreatSourceAndRationale(element));
    stringBuffer.append(CybersecurityHelper.getThreatSourceUse(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getThreatSourceUsedBy(element, htmlFolderName));
    stringBuffer.append(TEXT_1);
    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
  }

  public boolean preCondition(PatternContext ctx) throws Exception {
    return CybersecurityHelper.hasCybersecurityPropertyView(element);
  }
}