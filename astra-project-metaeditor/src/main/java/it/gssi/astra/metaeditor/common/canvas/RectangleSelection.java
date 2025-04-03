package it.gssi.astra.metaeditor.common.canvas;

import it.gssi.astra.metaeditor.common.utility.CustomColor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

/**
 * This class extends the {@link Rectangle} and it is a UI component used to
 * simulate selection on the canvas.
 */
public class RectangleSelection extends Rectangle{
	
	public RectangleSelection(){
		this.setStroke(CustomColor.primary);
		this.setStrokeWidth(2);
		this.setStrokeLineCap(StrokeLineCap.ROUND);
		this.setFill(Color.LIGHTGRAY.deriveColor(0, 1.2, 1, 0.6));
	}
}
