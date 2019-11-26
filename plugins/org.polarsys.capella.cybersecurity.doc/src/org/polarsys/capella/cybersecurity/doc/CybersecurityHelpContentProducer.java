package org.polarsys.capella.cybersecurity.doc;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.stream.Collectors;

import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.help.IHelpContentProducer;
import org.eclipse.osgi.util.NLS;

public class CybersecurityHelpContentProducer implements IHelpContentProducer {

  private static final String RULES_HREF = "html/rules.html?"; //$NON-NLS-1$
  
  
  
  @Override
  public InputStream getInputStream(String pluginID, String href, Locale locale) {
    if (href.startsWith(RULES_HREF)) {
      return new ByteArrayInputStream(generateValidationDocumentation().getBytes(StandardCharsets.UTF_8));
    }
    return null;
  }

  
  private String generateValidationDocumentation() {
    
    StringBuilder tables = new StringBuilder();
    
    String tableTemplate = readTemplate("rule.txt"); //$NON-NLS-1$
    for (IConstraintDescriptor desc : ConstraintRegistry.getInstance().getAllDescriptors()) {
      if (desc.getId().startsWith("org.polarsys.capella.cybersecurity.validation.")){ //$NON-NLS-1$
        tables.append(getTableFor(desc, tableTemplate));
      }
    }

    String main = readTemplate("main.txt"); //$NON-NLS-1$
    return main.replace("$body", tables.toString()); //$NON-NLS-1$
  }
  
  private String getTableFor(IConstraintDescriptor desc, String template) {
    
    String imgPath = desc.getSeverity() == ConstraintSeverity.WARNING ? 
        "PLUGINS_ROOT/org.polarsys.capella.validation.doc/html/Images/warning.gif" : //$NON-NLS-1$
        "PLUGINS_ROOT/org.polarsys.capella.validation.doc/html/Images/error.gif"; //$NON-NLS-1$
        return NLS.bind(template, new Object[] {
        desc.getSeverity().getLiteral(), // title
        desc.getSeverity().getLiteral(), // alt
        imgPath, // imgsrc
        desc.getName(),
        desc.getDescription()});
  }

  private String readTemplate(String template) {
    URL url;
    BufferedReader br = null;
    try {
      url = new URL("platform:/plugin/org.polarsys.capella.cybersecurity.doc/templates/" + template); //$NON-NLS-1$
      br = new BufferedReader(new InputStreamReader( url.openConnection().getInputStream()));
      return br.lines().collect(Collectors.joining(System.getProperty("line.separator"))); //$NON-NLS-1$
    } catch (IOException e) {
      
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return ""; //$NON-NLS-1$
  }

}
