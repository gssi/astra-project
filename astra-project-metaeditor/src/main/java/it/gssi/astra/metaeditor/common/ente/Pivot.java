package it.gssi.astra.metaeditor.common.ente;

import it.gssi.astra.metaeditor.common.LayoutScene;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * This Class represent the point of the {@link DraggableNode} that we wont to snap to grid
 * 
 */
public class Pivot extends Circle{
	
	/**
	 * This is used to instantiate the Pivot when exist into fxml
	 * 
	 */
	public Pivot() {
		super(0.5);
		this.setFill(Color.RED);
		this.setCenterX(0.0);
		this.setCenterY(0.0);
	}
	
	/**
	 * This is used to create the Pivot when not exist into fxml
	 * @param ente Ente
	 */
	public Pivot(Ente ente) {
		super(0.5);
		ente.getChildren().add(this);
		this.setFill(Color.RED);
		this.setCenterX(0.0);
		this.setCenterY(0.0);
		this.setVisible(false);
	}
	
	public double[] getCoordinatesRelativeToCanvas() {
		Bounds boundsInLocal;
		Bounds boundsInScene;

		boundsInLocal = this.getBoundsInLocal();
		boundsInScene = this.localToScene(boundsInLocal);
		
		Bounds sc = LayoutScene.getInstance().getCanvas().sceneToLocal(boundsInScene);

		return new double[] { sc.getCenterX(), sc.getCenterY() };
	}
}
