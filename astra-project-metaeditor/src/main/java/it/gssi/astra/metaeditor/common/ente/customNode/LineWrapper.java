package it.gssi.astra.metaeditor.common.ente.customNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import it.gssi.astra.metaeditor.common.canvas.CanvasUtils;
import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Callback;

/**
 * <p>Base class for custom JavaFX components based on {@link BendPoint} and used
 * by the controller {@link it.gssi.astra.metaeditor.common.ente.EnteBendable}.
 * </p>
 * 
 * <p>
 * Provides a Shape object {@link LineWrapper#lineShape} which will be casted by
 * subclasses (e.g. CustomLine will cast it to Line, CustomRectangle to Rectangle, etc.).
 * {@link LineWrapper#lineShape} allows to customize some of the styling attributes of
 * the line simply setting the attributes in the fxml (e.g. stroke, fill, etc.).
 * If you want to add support to other FXML attributes this class must implement the
 * corresponding methods as already made in the region named "Wrappers of Shape styling methods"
 * </p>
 * <p>
 * The subclasses will then be available as custom JavaFX components to be used in the FXML
 * or in SceneBuilder with the id <strong>exactly equal to</strong> {@code customLine}.
 * </p>
 * <p>
 * Contains a list of all bend points. You can add or remove bend points by right clicking one
 * of the bend point of the line on canvas
 * </p>
 * 
 *@see <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/doc-files/introduction_to_fxml.html#custom_components">How to create JavaFX Custom components</a>
 */
public abstract class LineWrapper extends Group {

	ElementPosition model;

	/**
	 * An observable list of {@link BendPoint}
	 */
	protected ObservableList<BendPoint> punti_polilinea = FXCollections
			.observableArrayList(new Callback<BendPoint, Observable[]>() {
				@Override
				public Observable[] call(BendPoint param) {
					return new Observable[] { param.getNewValueX(), param.getNewValueY(), };
				}
			});

	public ObservableList<BendPoint> getPuntiPolilinea() {
		return punti_polilinea;
	}

	public Ente parent;

	protected Shape lineShape;

	public Boolean bendPointsVisibility = true;

	public LineWrapper() {
		super();
	}
	
	//================================================================================
    // Wrappers of Shape styling methods - START
    //================================================================================

	public final void setStrokeWidth(double value) {
		lineShape.setStrokeWidth(value);
	}

	public final double getStrokeWidth() {
		return lineShape.getStrokeWidth();
	}

	/**
	 * Defines a square pen line width. A value of 0.0 specifies a hairline stroke.
	 * A value of less than 0.0 will be treated as 0.0.
	 *
	 * @return the square pen line width
	 */
	public final DoubleProperty strokeWidthProperty() {
		return lineShape.strokeWidthProperty();
	}

	public final void setStrokeLineCap(StrokeLineCap value) {
		lineShape.setStrokeLineCap(value);
	}

	public final StrokeLineCap getStrokeLineCap() {
		return lineShape.getStrokeLineCap();
	}

	/**
	 * The end cap style of this {@code Shape} as one of the following values that
	 * define possible end cap styles: {@code StrokeLineCap.BUTT},
	 * {@code StrokeLineCap.ROUND}, and {@code StrokeLineCap.SQUARE}. The image
	 * shows a line using the values in the mentioned order.
	 * <p>
	 * <img src="doc-files/strokelinecap.png" alt="A visual illustration of
	 * StrokeLineCap using 3 different values">
	 * </p>
	 *
	 * @return the end cap style of this shape
	 * @see StrokeLineCap
	 */
	public final ObjectProperty<StrokeLineCap> strokeLineCapProperty() {
		return lineShape.strokeLineCapProperty();
	}

	public void setStroke(Paint value) {
		lineShape.setStroke(value);
	}
	
	public final Paint getStroke() {
		return lineShape.getStroke();
	}

	public final ObjectProperty<Paint> strokeProperty() {
		return lineShape.strokeProperty();
	}

	public final void setFill(Paint value) {
		lineShape.setFill(value);
	}

	public final Paint getFill() {
		return lineShape.getFill();
	}

	public final ObjectProperty<Paint> fillProperty() {
		return lineShape.fillProperty();
	}
	
	//================================================================================
    // Wrappers of Shape styling methods - END
    //================================================================================


	public Boolean getBendPointsVisibility() {
		return bendPointsVisibility;
	}

	public Shape getLineShape() {
		return lineShape;
	}

	public LineWrapper(Node... children) {
		super(children);
	}

	public LineWrapper(Collection<Node> children) {
		super(children);
	}

	/**
	 * Gets the coordinates from the model if we are loading the model and instantiates the bend-points
	 * calling {@link LineWrapper#addBendPoints()}
	 * @param objModel The element position instance.
	 */
	public void addModel(ElementPosition objModel) {
	}

	public void fixPosition() {
		punti_polilinea.forEach(bendPoint -> {
			bendPoint.setCenterX(bendPoint.getCenterX() + this.getLayoutX());
			bendPoint.setCenterY(bendPoint.getCenterY() + this.getLayoutY());
		});

		this.setLayoutX(0);
		this.setLayoutY(0);

	}

	public void showBendPoints(boolean visible) {
		if (punti_polilinea != null) {
			punti_polilinea.forEach(point -> {
				point.setVisible(visible);
				point.setManaged(visible);
				point.toFront();
			});
			bendPointsVisibility = visible;
		}
	}

	/**
	 * Instantiate the bend-points and bind them to element position x,y attributes
	 */
	public void addBendPoints() {
	}

	public void addAnotherBendPoint(BendPoint bendPoint) {
	}

	public void removeBendPoint(BendPoint anchorPoint1) {
	}
	
	public Map<Node, Double[]> first_attachedNodes = new HashMap<Node, Double[]>();
	public Map<Node, Double[]> last_attachedNodes = new HashMap<Node, Double[]>();

	/**
	 * 
	 * Parse every node (actually only circles, but can be extended to {@link javafx.scene.Node}) that
	 * appear in the FXML and logically attach them to the nearest bend point chosen between the left
	 * end bend point or right end bend point.
	 * In particular the circles near the bend point of left end will be inserted in the map {@link 
	 * LineWrapper#first_attachedNodes} while the circles near the bend point of right end will be
	 * inserted into {@link LineWrapper#last_attachedNodes}.
	 * Every node of these maps has an array of two doubles associated, which represents the offset
	 * of the node from the bend point vertically and horizontally.
	 * These doubles will be used by {@link PolylineUtils#updatePosition(BendPoint, BendPoint)} to
	 * let
	 * these attached node follow the bend point position.
	 * 
	 * E.g. It is used to determine the position of the anchor points of bendable elements and update
	 * it dynamically.
	 * 
	 */
	public void parse_attachedNodes() {

		for (Node node : parent.getChildren()) {
			if (node != LineWrapper.this) {

				var local = node.getBoundsInLocal();
				var scene = node.localToScene(local);
				var fromParent = parent.sceneToLocal(scene);

				double nodeCenterX = (fromParent.getMinX() + fromParent.getMaxX()) / 2;
				double nodeCenterY = (fromParent.getMinY() + fromParent.getMaxY()) / 2;

				double first_pointX = this.getPointsCoords().get(0);
				double first_pointY = this.getPointsCoords().get(1);
				double last_pointX = this.getPointsCoords().get(this.getPointsCoords().size() - 2);
				double last_pointY = this.getPointsCoords().get(this.getPointsCoords().size() - 1);

				double distance_left = CanvasUtils.distance(nodeCenterX, nodeCenterY, first_pointX, first_pointY);
				double distance_right = CanvasUtils.distance(nodeCenterX, nodeCenterY, last_pointX, last_pointY);

				// Attach to extreme left bend point
				if (distance_left < distance_right) {

					/*
					 * Take into account an FXML containing a CustomPolyline with more than two
					 * points If there were only two points the code remains valid
					 */
					double second_pointX = this.getPointsCoords().get(2);
					double second_pointY = this.getPointsCoords().get(3);

					if (first_pointY == second_pointY) {
						double parallel_distance = (int) Math.round(Math.abs(nodeCenterX - first_pointX));
						double orthogonal_distance = (int) Math.round(Math.abs(nodeCenterY - first_pointY));
						first_attachedNodes.put(node, new Double[] { parallel_distance, orthogonal_distance });

					} else if (first_pointX == second_pointX) {
						double parallel_distance = (int) Math.round(Math.abs(nodeCenterY - first_pointY));
						double orthogonal_distance = (int) Math.round(Math.abs(nodeCenterX - first_pointX));
						first_attachedNodes.put(node, new Double[] { parallel_distance, orthogonal_distance });
					}
				}

				// Attach to extreme right bend point
				if (distance_right < distance_left) {

					/*
					 * Take into account an FXML containing a CustomPolyline with more than two
					 * points If there were only two points the code remains valid
					 */
					double second_last_pointX = this.getPointsCoords().get(this.getPointsCoords().size() - 4);
					double second_last_pointY = this.getPointsCoords().get(this.getPointsCoords().size() - 3);

					if (second_last_pointY == last_pointY) {
						double parallel_distance = (int) Math.round(Math.abs(nodeCenterX - last_pointX));
						double orthogonal_distance = (int) Math.round(Math.abs(nodeCenterY - last_pointY));
						last_attachedNodes.put(node, new Double[] { parallel_distance, orthogonal_distance });

					} else if (second_last_pointX == last_pointX) {
						double parallel_distance = (int) Math.round(Math.abs(nodeCenterY - last_pointY));
						double orthogonal_distance = (int) Math.round(Math.abs(nodeCenterX - last_pointX));
						last_attachedNodes.put(node, new Double[] { parallel_distance, orthogonal_distance });
					}
				}

			}
		}
	}

	public BendPoint getBendPointAssociated(Node node) {
		for (BendPoint b : punti_polilinea) {
			for (Node currentNode : b.attachedNodes.keySet()) {
				if (currentNode == node) {
					return b;
				}
			}
		}

		return null;
	}

	/**
	 * Override this method to standardize the management of points of {@code LineWrapper#lineShape}
	 * 
	 * @return An observableList of doubles.
	 */
	public abstract ObservableList<Double> getPointsCoords();
	
	/**
	 * 
	 * Override this method to add a context menu to all the bend points of this object.
	 * 
	 * This method must be called every time a new bend point is added to this object.
	 * 
	 * @param bendpoint
	 */
	public abstract void setContextMenuFor(BendPoint bendpoint);
}