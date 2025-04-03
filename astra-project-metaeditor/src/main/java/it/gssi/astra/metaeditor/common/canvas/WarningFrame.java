package it.gssi.astra.metaeditor.common.canvas;

import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class defines the warning box of the ente
 * 
 *
 */
public class WarningFrame extends Rectangle {
	
	/**
	 * @param ente 
	 */
	public WarningFrame(Ente ente) {
		this.setFill(Color.TRANSPARENT);
		this.setStrokeWidth(2);
		this.setStroke(Color.YELLOW);
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

