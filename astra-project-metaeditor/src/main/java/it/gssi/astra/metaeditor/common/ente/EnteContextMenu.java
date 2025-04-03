package it.gssi.astra.metaeditor.common.ente;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.CanvasManagementImpl;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * This class create and manage the context menu of Ente  
 * 
 */
public class EnteContextMenu extends ContextMenu{
	
	Ente ente;
	public Menu menuItemNewChild; 

	public EnteContextMenu(Ente ente) {
		this.ente = ente;
		menuItemNewChild = new Menu("New Child");
		menuItemNewChild.setDisable(true);
		createMenuItem();
		this.getItems().add(menuItemNewChild);
	}
	
	public void createMenuItem() {

		MenuItem menuToFront = new MenuItem("Porta in primo piano");
		menuToFront.setOnAction((event) -> {
			
			double foregroundViewOrder = LayoutScene.getInstance().getCanvas().getForegroundViewOrder();
			
			if (ente.getDraggableNode().getViewOrder() > foregroundViewOrder)
				ente.getDraggableNode().setViewOrder(foregroundViewOrder - 1);
		});

		MenuItem menuToBack = new MenuItem("Porta in secondo piano");
		menuToBack.setOnAction((event) -> {
			
			double backgroundViewOrder = LayoutScene.getInstance().getCanvas().getBackgroundViewOrder();
			
			if (ente.getDraggableNode().getViewOrder() < backgroundViewOrder)
				ente.getDraggableNode().setViewOrder(backgroundViewOrder + 1);
		});

		MenuItem menuCarryOn = new MenuItem("Porta in avanti");
		menuCarryOn.setOnAction((event) -> {
			ente.getDraggableNode().setViewOrder(ente.getDraggableNode().getViewOrder() - 1);
		});

		MenuItem menuBringBack = new MenuItem("Porta indietro");
		menuBringBack.setOnAction((event) -> {
			ente.getDraggableNode().setViewOrder(ente.getDraggableNode().getViewOrder() + 1);
		});
		
		MenuItem resetZIndex = new MenuItem("Reset Z-Index");
		resetZIndex.setOnAction((event) -> {
			ente.getDraggableNode().setViewOrder(ente.graphicalElement.getZIndexDefault());
		});
		
		MenuItem menuSnapToGrid = new MenuItem("Snap to Grid");
		menuSnapToGrid.setOnAction((event) -> {
			ente.getDraggableNode().snapToGrid(ente.pivot);
		});
		
		// Copy
		MenuItem menuCopy = new MenuItem("Copia");
		menuCopy.setOnAction((copy) -> {
			CustomMenu.getInstance().copy();
			copy.consume();
		});
		
		// Delete
		MenuItem menuDelete = new MenuItem("Elimina");
		menuDelete.setOnAction((del) -> {
			CanvasManagementImpl.getInstance().deleteSelectedItems();
			del.consume();
		});

		// Add All
		getItems().addAll(menuToFront, menuToBack, menuCarryOn, menuBringBack,resetZIndex,menuSnapToGrid, menuCopy, menuDelete);

		// Position menu on screen
		ente.getDraggableNode().setOnContextMenuRequested((event) -> {
			menuItemNewChild.getItems().clear();
			this.show(this.ente, event.getScreenX(), event.getScreenY());
			ente.createMenu();
			event.consume();
		});
		
		
	}
	
	public MenuItem getMenuItem(String name) {
		for (MenuItem menuItem : menuItemNewChild.getItems()) {
			if (menuItem.getId().equals(name)) {
				return menuItem;
			}
		}
		return null;
	}
	
	public Menu getNewChild() {
		return menuItemNewChild;
	}


}
