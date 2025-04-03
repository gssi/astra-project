package it.gssi.astra.metaeditor.common.canvas.section;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * This class is a UI component that extends the {@link Rectangle} and is used
 * to represent a section on the canvas. A section consists mainly of: name,
 * width, height and an offset.
 *
 */
public class CanvasSectionFX extends Rectangle {
	
	private String name;
	
	public CanvasSectionFX(String name, int with, int height, int layoutX) {
		this.setFill(Color.TRANSPARENT);
		this.setStrokeType(StrokeType.INSIDE);
		this.setStroke(Color.RED);
		this.setStrokeWidth(1.0);
		
		this.setWidth(with);
		this.setHeight(height);
		this.setLayoutX(layoutX);
		
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
}
