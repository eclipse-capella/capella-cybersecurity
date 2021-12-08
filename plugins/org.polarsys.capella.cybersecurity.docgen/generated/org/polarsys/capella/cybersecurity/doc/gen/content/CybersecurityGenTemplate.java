//Generated with EGF 1.6.2.202001031546
package org.polarsys.capella.cybersecurity.doc.gen.content;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.capella.cybersecurity.model.*;
import org.polarsys.capella.docgen.foundations.*;
import org.polarsys.capella.docgen.util.CapellaServices;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.polarsys.capella.cybersecurity.docgen.utils.ImageHelper;
import org.polarsys.capella.cybersecurity.docgen.helper.CybersecurityHelper;
import org.polarsys.capella.cybersecurity.docgen.utils.CybersecurityFileNameSerivice;
import org.eclipse.core.runtime.Path;

public class CybersecurityGenTemplate extends org.polarsys.capella.docgen.foundations.NamedElementDocGen {
  protected static String nl;

  public static synchronized CybersecurityGenTemplate create(String lineSeparator) {
    nl = lineSeparator;
    CybersecurityGenTemplate result = new CybersecurityGenTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public CybersecurityGenTemplate() {
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

    List<Object> parameterList = null;
    //this pattern can only be called by another (i.e. it's not an entry point in execution)

    for (Object parameterParameter : parameterList) {

      this.parameter = (org.polarsys.capella.core.data.capellacore.CapellaElement) parameterParameter;

      if (preCondition(ctx)) {
        ctx.setNode(new Node.Container(currentNode, getClass()));
        orchestration(ctx);
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

    method_createPNG(new StringBuffer(), ictx);
    super.orchestration(new SuperOrchestrationContext(ictx));

    if (ictx.useReporter()) {
      Map<String, Object> parameterValues = new HashMap<String, Object>();
      parameterValues.put("parameter", this.parameter);
      String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
      String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
      ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    }
    return null;
  }

  protected org.polarsys.capella.core.data.capellacore.CapellaElement parameter = null;

  public void set_parameter(org.polarsys.capella.core.data.capellacore.CapellaElement object) {
    this.parameter = object;
  }

  public Map<String, Object> getParameters() {
    final Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("parameter", this.parameter);
    return parameters;
  }

  protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    super.method_content(stringBuffer, ctx);
    Path pathToHtmlFolder = new Path(ctx.getValue("outputFolder").toString());
    String htmlFolderName = pathToHtmlFolder.lastSegment();
    stringBuffer.append(CybersecurityHelper.getContent(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getThreatKind(element));
    stringBuffer.append(CybersecurityHelper.getLevel(element));
    stringBuffer.append(CybersecurityHelper.getRationale(element));
    stringBuffer.append(CybersecurityHelper.getRealizingThreats(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getRealizingPrimaryAsset(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getRealizedThreats(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getRealizedPrimaryAsset(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getReferencedCapellaElement(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getThreatApplicationTo(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getPrimaryAssets(element, htmlFolderName));
    stringBuffer.append(CybersecurityHelper.getThreatsContent(element, htmlFolderName));
    stringBuffer.append(TEXT_1);
    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
  }

  protected void method_setCapellaContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    element = parameter;
    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "setCapellaContext", stringBuffer.toString());
  }

  protected void method_createPNG(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    String outputFolder = ctx.getValue("outputFolder").toString();
    String projectName = ctx.getValue("projectName").toString();
    ImageHelper.createPNG(parameter, projectName, outputFolder);

    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "createPNG", stringBuffer.toString());
  }

  protected void method_fileNameService(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    fileNameService = CybersecurityFileNameSerivice.SERVICE;
    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "fileNameService", stringBuffer.toString());
  }

  public boolean preCondition(PatternContext ctx) throws Exception {
    return parameter instanceof PrimaryAsset || parameter instanceof Threat || parameter instanceof CybersecurityPkg;
  }
}