package it.gssi.astra.metaeditor.common.canvas;

import it.gssi.astra.metaeditor.common.dataManager.cloneManager.CloneImpl;
import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * The Canvas is a UI component and represents the drawing area of the editor.
 * {@link Ente} can be placed on the {@link Canvas} through the palette or by
 * uploading an existing file.
 */
public class Canvas extends AnchorPane {

	CanvasMouseGesture gesture;
	ContextMenu contextMenu;

	public Canvas() {

		contextMenu = new ContextMenu();
		gesture = new CanvasMouseGesture(this);

		// Paste
		MenuItem menuPaste = new MenuItem("Incolla");
		menuPaste.setOnAction((del) -> {

			CloneImpl.getInstance().paste(false);
		});
		contextMenu.getItems().addAll(menuPaste);

	}

	/**
	 * Search for the further back node which has the highest view order as stated
	 * by {@link Node#viewOrderProperty()}
	 * 
	 * @return the view order of the node
	 */
	public double getBackgroundViewOrder() {
		double max_viewOrder = -999999;
		for (Node dnode : this.getChildren()) {
			if (dnode.getViewOrder() > max_viewOrder)
				max_viewOrder = dnode.getViewOrder();
		}

		return max_viewOrder;
	}

	/**
	 * Search for the further on node which has the lowest view order as stated by
	 * {@link Node#viewOrderProperty()}
	 * 
	 * @return the view order of the node
	 */
	public double getForegroundViewOrder() {
		double min_viewOrder = 999999;
		for (Node dnode : this.getChildren()) {
			if (dnode.getViewOrder() < min_viewOrder)
				min_viewOrder = dnode.getViewOrder();
		}

		return min_viewOrder;
	}

}
