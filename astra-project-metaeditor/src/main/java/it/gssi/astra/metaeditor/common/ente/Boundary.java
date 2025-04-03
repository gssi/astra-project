package it.gssi.astra.metaeditor.common.ente;

import it.gssi.astra.metaeditor.common.canvas.Canvas;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class is a UI component used to represent the selection of an {@link Ente} on
 * the {@link Canvas}. This component is formed by a blue rectangle and is displayed at
 * the selection of the {@link Ente}.
 * 
 */
public class Boundary extends Rectangle {

	public Boundary(Ente ente) {
		this.setFill(Color.TRANSPARENT);
		this.setStrokeWidth(1.5);
		this.setStroke(Color.TRANSPARENT);
		this.getStrokeDashArray().addAll(1.5d, 4d);
		this.setManaged(false);
		this.setVisible(true);
		updateBoud(ente.getBoundsInParent());
		ente.boundsInParentProperty().addListener((obj, oldValue, newValue) -> updateBoud(newValue));
	}

	public void updateBoud(Bounds newValue) {
		this.setLayoutX(newValue.getMinX());
		this.setLayoutY(newValue.getMinY());
		this.setWidth(newValue.getWidth());
		this.setHeight(newValue.getHeight());
	}
}