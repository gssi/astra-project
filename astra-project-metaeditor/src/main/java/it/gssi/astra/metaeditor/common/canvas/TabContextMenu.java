package it.gssi.astra.metaeditor.common.canvas;

import it.gssi.astra.metaeditor.common.dataManager.fileManager.FileManagerImpl;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * This UI component represents the Context Menu of the workspace tab.
 * Contains closing and saving actions.
 */
public class TabContextMenu extends ContextMenu {

	public TabContextMenu(Workspace workspace, WorkspaceTab ownerTab) {

		MenuItem close = new MenuItem("Chiudi");

		close.setOnAction(e -> {
			workspace.closeRequestTab(ownerTab);
		});

		MenuItem closeOtherMenu = new MenuItem("Chiudi altre");

		closeOtherMenu.setOnAction(e -> {
			workspace.closeOtherTabs(ownerTab);
		});

		MenuItem clossAllMenu = new MenuItem("Chiudi tutte");

		clossAllMenu.setOnAction(e -> {

			workspace.closeAllTabs(ownerTab);
		});

		SeparatorMenuItem sep = new SeparatorMenuItem();

		MenuItem save = new MenuItem("Salva");

		save.setOnAction(e -> {
			FileManagerImpl.getInstance().save();
		});

		MenuItem saveAll = new MenuItem("Salva tutte");

		saveAll.setOnAction(e -> {
			FileManagerImpl.getInstance().saveAll();
		});

		this.getItems().addAll(close, closeOtherMenu, clossAllMenu, sep, save, saveAll);
	}
}
