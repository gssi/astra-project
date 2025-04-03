package it.gssi.astra.metaeditor.common.canvas;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.CustomCommandStack;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;
import it.gssi.astra.metaeditor.common.popup.Popup;
import javafx.event.Event;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;

/**
 * This class is a UI component that extends {@link Tab} and represents a tab
 * within the editor. Each tab contains:
 * <ul>
 * <li>{@link ContainerCanvas}, as content</li>
 * <li>{@link Tooltip}, to indicate the URI of the file</li>
 * <li>{@link TabContextMenu}, to perform operations on the tab</li>
 * </ul>
 */
public class WorkspaceTab extends Tab {

	String title;

	Resource resource;

	private Workspace workspace;

	Resource resourcePersistence;

	MetaEditorPersistence rootPersistence;

	AdapterFactoryEditingDomain editingDomain;

	WorkspaceTab(Workspace workspace, String title, Resource resource, Resource resourcePersistence,
			MetaEditorPersistence rootPersistence, AdapterFactoryEditingDomain editingDomain) {

		this.title = title;
		this.workspace = workspace;
		this.resource = resource;
		this.resourcePersistence = resourcePersistence;
		this.rootPersistence = rootPersistence;
		this.editingDomain = editingDomain;

		initialize();
	}

	private void initialize() {

		this.setText(title);

		this.setOnCloseRequest(e -> closeRequest(e));

		this.setOnClosed(e -> closed(e));

		setDefaultTooltip();

		setDefaultContextMenu();

		setDefaultContent();
	}

	private void setDefaultTooltip() {
		Tooltip tooltip = new Tooltip(resource.getURI().path());
		this.setTooltip(tooltip);
	}

	private void setDefaultContextMenu() {
		TabContextMenu context = new TabContextMenu(workspace, this);
		this.setContextMenu(context);
	}

	private void setDefaultContent() {
		ContainerCanvas container = new ContainerCanvas(resource, resourcePersistence, rootPersistence, editingDomain);
		container.setId("canvas_" + workspace.getTabs().size());
		this.setContent(container);
	}

	/**
	 * Method performed when a tab is closed. If there are no more tabs on the
	 * canvas, the user is asked if he wants to close the editor.
	 * 
	 * @param e
	 */
	public Boolean closed(Event e) {

		Boolean result = false;
		
		//delete the resources from the resourceSet
		LayoutScene layoutScene = LayoutScene.getInstance();
		layoutScene.getResourceSet().getResources().remove(this.resource);
		layoutScene.getResourceSet().getResources().remove(this.resourcePersistence);
		
		if (workspace.getTabs().size() == 0) {

			result = Popup.question("Chiusura ultima tab", "Desideri chiudere l'editor?", false);

			if (result == null || !result.booleanValue()) {
				LayoutScene.getInstance().setWelcomeUI(); // Edit editor layout
			} else {
				LayoutScene.getInstance().closeApp(); // Close app
			}
		}
		
		return result;
	}

	/**
	 * Method performed when a tab is requested to be closed. If the content of the
	 * tab is to be saved it asks the user how to proceed through a popup. Also if
	 * the tab turns out to be the last one asks the user if he wants to close the
	 * editor too.
	 * 
	 * @param e
	 */
	public Boolean closeRequest(Event e) {

		Boolean result = false;

		if (((CustomCommandStack) editingDomain.getCommandStack()).isSaveNeeded()) {

			result = Popup.question("Salvataggio",
					String.format("Salvare le modifiche apportate a %s", resource.getURI().lastSegment()));

			if (result == null) {
				e.consume();
				return null;
			}

			if (result) {
				CustomMenu.getInstance().save();
			}
		}

		return result;
	}
}
