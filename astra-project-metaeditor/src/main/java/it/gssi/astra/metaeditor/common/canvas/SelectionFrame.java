package it.gssi.astra.metaeditor.common.canvas;

import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class defines the spin box of the ente
 * 
 *
 */
public class SelectionFrame extends Rectangle {
	
	/**
	 * @param ente 
	 */
	public SelectionFrame(Ente ente) {
		Color c = Color.rgb(0,255,0,0.1); 
		this.setFill(c);
		this.setManaged(false);
		this.setVisible(true);
		updateBoud(ente.getBoundsInParent());
		ente.boundsInParentProperty().addListener((obj,oldValue,newValue)->updateBoud(newValue));
	}
	
	/**
	 * Update the bounds of the box
	 * @param newValue
	 */
	public void updateBoud(Bounds newValue) {
		this.setLayoutX(newValue.getMinX());
		this.setLayoutY(newValue.getMinY());
		this.setWidth(newValue.getWidth());
		this.setHeight(newValue.getHeight());
	}
}

