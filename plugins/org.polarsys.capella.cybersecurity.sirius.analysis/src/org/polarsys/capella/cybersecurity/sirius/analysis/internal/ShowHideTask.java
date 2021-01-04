/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.cybersecurity.sirius.analysis.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.helper.task.AbstractCommandTask;
import org.eclipse.sirius.business.api.helper.task.ICreationTask;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.MessageTranslator;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.tools.api.interpreter.InterpreterUtil;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.description.tool.MappingBasedToolDescription;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.common.ui.toolkit.dialogs.TransferTreeListDialog;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataLabelProvider;
import org.polarsys.capella.core.data.capellacore.NamedElement;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.core.sirius.analysis.actions.extensions.Messages;
import org.polarsys.capella.core.ui.properties.CapellaUIPropertiesPlugin;

abstract class ShowHideTask extends AbstractCommandTask implements ICreationTask {

  private Collection<EObject> selectedObjects = new ArrayList<EObject>();
  private Collection<EObject> deletedObjects = new ArrayList<EObject>();

  private EObject container;
  private MappingBasedToolDescription tool;

  public ShowHideTask(EObject container, MappingBasedToolDescription tool) {
    this.container = container;
    this.tool = tool;
  }

  @Override
  public boolean canExecute() {
    return ((DSemanticDecorator) container).getTarget() != null;
  }

  protected Shell getShell() {
    return PlatformUI.getWorkbench().getDisplay().getActiveShell();
  }

  @Override
  public void execute() {

    Map<EObject, DDiagramElement> shown = new HashMap<>();
    List<EObject> semanticCandidates = new ArrayList<>();

    for (DDiagramElement child : getCandidateChildren(container)) {
      if (getMappings(tool).contains(child.getMapping())) {
        shown.put(child.getTarget(), child);
      }
    }

    EObject context = ((DSemanticDecorator) container).getTarget();
    IInterpreter interpreter = InterpreterUtil.getInterpreter(context);

    for (AbstractNodeMapping mapping : getMappings(tool)) {
      String expression = mapping.getSemanticCandidatesExpression();
      if (expression != null && !expression.trim().isEmpty()) {
        try {
          semanticCandidates.addAll((List<EObject>) interpreter.evaluate(context, expression));
        } catch (EvaluationException e) {
          return;
        }
      } else {
        Session session = SessionManager.INSTANCE.getSession(context);
        ModelAccessor accessor = session.getModelAccessor();
        for (final Resource resource : session.getSemanticResources()) {
          for (final EObject root : resource.getContents()) {
            semanticCandidates.addAll(accessor.eAllContents(root, mapping.getDomainClass()));
          }
        }
      }
    }
    semanticCandidates.removeAll(shown.keySet());

    TransferTreeListDialog dialog;
    boolean expandLeftViewer = CapellaUIPropertiesPlugin.getDefault().isAllowedExpandLeftViewerContent();
    boolean expandRightViewer = CapellaUIPropertiesPlugin.getDefault().isAllowedExpandRightViewerContent();
    int leftViewerExpandLevel = expandLeftViewer ? AbstractTreeViewer.ALL_LEVELS : 0;
    int rightViewerExpandLevel = expandRightViewer ? AbstractTreeViewer.ALL_LEVELS : 0;

    DSemanticDecorator decorator = (DSemanticDecorator) container;    
    DiagramDescription diagramDescription = CapellaServices.getService().getDiagramContainer(decorator).getDescription();    
    String elementTypeToInsert = MessageTranslator.INSTANCE.getMessage(diagramDescription, tool.getLabel());
    
    NamedElement semanticTarget = (NamedElement) decorator.getTarget();

    String wizardMessage = "Select " + elementTypeToInsert + " to show in " + semanticTarget.getName();

    dialog = new TransferTreeListDialog(getShell(), Messages.SelectElementFromListWizard_Title, wizardMessage,
        new DataLabelProvider(), new DataLabelProvider(), leftViewerExpandLevel, rightViewerExpandLevel);
    dialog.setRightInput(new ArrayList<>(shown.keySet()), context);
    dialog.setLeftInput(semanticCandidates, context);

    if (dialog.open() == Window.OK) {
      for (Object e : dialog.getResult()) {
        if (shown.remove(e) == null) {
          // no node exists => must create one
          selectedObjects.add((EObject) e);
        }
      }

      // Deletes all views that were not selected
      // FIXME move this to a separate task
      for (DDiagramElement d : shown.values()) {
        EcoreUtil.remove(d);
        deletedObjects.add(d);
      }

    }
  }

  /**
   * Subclasses override this
   */
  protected abstract Collection<? extends DDiagramElement> getCandidateChildren(EObject container);

  /**
   * Subclasses override this
   */
  protected abstract Collection<? extends AbstractNodeMapping> getMappings(MappingBasedToolDescription tool);

  @Override
  public Collection<EObject> getAffectedElements() {
    return Collections.emptyList();
  }

  @Override
  public Collection<EObject> getCreatedReferences() {
    return Collections.emptyList();
  }

  @Override
  public String getLabel() {
    return "select elements task";
  }

  @Override
  /**
   * These elements weren't actually created. But the invoking Node/ContainerCreation tool doesnt' care, and creates a
   * view for each of these, which is just what we want.
   */
  public Collection<EObject> getCreatedElements() {
    return selectedObjects;
  }

  @Override
  public Collection<DRepresentationElement> getCreatedRepresentationElements() {
    return Collections.emptyList();
  }

}