package it.gssi.astra.metaeditor.common.ente.customNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.emf.ecore.EObject;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.ente.DragContext;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.ente.EnteBendable;
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.magnete.AnchorPointVirtual;
import it.gssi.astra.metaeditor.common.magnete.Magnete;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

/**
 * <p>
 * The class {@code BendPoint} provides a visual representation on the canvas
 * for the points of {@link LineWrapper#lineShape}.
 * </p>
 * <p>
 * The class {@code BendPoint} extends {@link Circle} so that it will appear as
 * a circle to be dragged on the canvas. They are invisible by default but
 * become visible when the {@code DraggableNode} is selected @see
 * DraggableNode#selectedProperty().
 * </p>
 * <p>
 * The coordinates of {@code BendPoint} are inherited from the properties
 * {@code centerX} and {@code centerY} of {@link Circle}. Their value is binded
 * to the attributes of {@code ElementPosition} when they are instantiated by
 * the implementations of {@link LineWrapper#addBendPoints()}.
 * </p>
 *
 */
public class BendPoint extends Circle {

	private DoubleProperty x_Property, y_Property;

	/**
	 * These variables are only pointers needed to remove the listeners added to
	 * xProperty and yProperty when redrawPolyline is called by CustomPolyline or
	 * CustomPolygon.
	 */
	public ChangeListener<Number> X_ChangeListener, Y_ChangeListener;

	/**
	 * These variables are only pointers needed to remove the bindings added by
	 * {@link LineWrapper#addBendPoints()} and {@link LineWrapper#addModel(EObject)}
	 * when a bend point is removed from a CustomPolyline or CustomPolygon.
	 */
	private Binding X_Binding, Y_Binding;

	public Binding getX_Binding() {
		return X_Binding;
	}

	public void setX_Binding(Binding x_Binding) {
		X_Binding = x_Binding;
	}

	public Binding getY_Binding() {
		return Y_Binding;
	}

	public void setY_Binding(Binding y_Binding) {
		Y_Binding = y_Binding;
	}

	private EventHandler<? super MouseEvent> parentDragEvent;

	public final DragContext dragContext = new DragContext();

	/**
	 * Defining the layout of BendPoint
	 * 
	 */
	public BendPoint() {
		super(3);
		setFill(Color.DARKGRAY);
		setStroke(Color.TRANSPARENT);
		setStrokeWidth(20);
		setStrokeType(StrokeType.OUTSIDE);
		setStrokeLineCap(StrokeLineCap.BUTT);
	}

	private LineWrapper lineWrapper;

	/**
	 * Instantiate a new {@code BendPoint} wrapping a point of
	 * {@link LineWrapper#lineShape}.
	 * 
	 * When the handler of {@link MouseEvent#MOUSE_RELEASED} sets
	 * {@code centerXProperty} and {@code centerYProperty} the listeners of these
	 * properties will update the coordinates of {@link LineWrapper#lineShape}
	 * 
	 * @param x      The observable property of coordinate X of the point of
	 *               {@code LineWrapper#lineShape} that you are wrapping
	 * @param y      The observable property of coordinate Y of the point of
	 *               {@code LineWrapper#lineShape} that you are wrapping
	 * @param parent {@link BendPoint#lineWrapper} will contain the subclass of
	 *               {@code LineWrapper} instantiating the {@code BendPoint}.
	 * 
	 */
	public BendPoint(DoubleProperty x, DoubleProperty y, LineWrapper parent) {
		super(x.get(), y.get(), 3);

		setFill(Color.DARKGRAY);
		setStroke(Color.TRANSPARENT);
		setStrokeWidth(4);
		setStrokeType(StrokeType.OUTSIDE);
		setStrokeLineCap(StrokeLineCap.BUTT);

		this.x_Property = x;
		this.y_Property = y;

		centerXProperty().addListener((observable, oldValue, newValue) -> {
			x_Property.set((double) newValue);
			updateAttachedNodesPosition();
		});
		centerYProperty().addListener((observable, oldValue, newValue) -> {
			y_Property.set((double) newValue);
			updateAttachedNodesPosition();
		});

		this.lineWrapper = parent;
		this.parentDragEvent = parent.getOnMouseDragged();

		enableDrag();
	}

	public DoubleProperty getX_Property() {

		return this.x_Property;
	}

	public DoubleProperty getY_Property() {

		return this.y_Property;
	}

	public void setX_Property(double value) {

		this.x_Property.set(value);
	}

	public void setY_Property(double value) {

		this.y_Property.set(value);
	}

	/**
	 * Remove all mouse event handlers
	 */
	public void disableDrag() {
		setOnMousePressed(null);
		setOnMouseClicked(null);
		setOnMouseDragged(null);
		setOnMouseEntered(null);
		setOnMouseExited(null);
		setOnMouseReleased(null);
	}

	/**
	 * Auxiliary observable property for X coordinate needed to implement
	 * constraints on bend point horizontal dragging. Its value is set by the
	 * handler of {@link MouseEvent#MOUSE_DRAGGED} Its value change will notify all
	 * listeners added to {@link LineWrapper#punti_polilinea} before
	 * {@link BendPoint#x_Property} is set. All the listeners which implement an
	 * horizontal constraint must check {@code newValueX} and update the value of
	 * {@link BendPoint#draggableHorizontally} accordingly.
	 */
	private DoubleProperty newValueX = new SimpleDoubleProperty();

	public DoubleProperty getNewValueX() {
		return newValueX;
	}

	/**
	 * Auxiliary observable property for Y coordinate needed to implement
	 * constraints on bend point vertical dragging. Its value is set by the handler
	 * of {@link MouseEvent#MOUSE_DRAGGED} Its value change will notify all
	 * listeners added to {@link LineWrapper#punti_polilinea} before
	 * {@link BendPoint#y_Property} is set. In this way the validation of
	 * constraints happens just before the coordinates of {@code BendPoint} become
	 * invalid. So the variables {@code newValueX} and {@code newValueY} represent
	 * where the bend point is going to go. All the listeners which implement a
	 * vertical constraint must check {@code newValueY} and update the value of
	 * {@link BendPoint#draggableVertically} accordingly.
	 */
	private DoubleProperty newValueY = new SimpleDoubleProperty();

	public DoubleProperty getNewValueY() {
		return newValueY;
	}

	private boolean draggableHorizontally = true;

	public void disableDraggingHorizontal() {
		draggableHorizontally = false;
	}

	public void enableDraggingHorizontal() {
		draggableHorizontally = true;
	}

	private boolean draggableVertically = true;

	public void disableDraggingVertical() {
		draggableVertically = false;
	}

	public void enableDraggingVertical() {
		draggableVertically = true;
	}

	/**
	 * Enable all mouse event handlers Make a bend point movable by dragging it
	 * around with the mouse.
	 */
	public void enableDrag() {

		setOnMousePressed(event -> {
			if (lineWrapper != null) {
				lineWrapper.setOnMouseDragged(null);
			}
			this.setStroke(Color.web("0078D7", 0.6));

			dragContext.initialTranslateX = getCenterX();
			dragContext.initialTranslateY = getCenterY();

			Point2D canvasPoint = LayoutScene.getInstance().getCanvas().sceneToLocal(event.getSceneX(),
					event.getSceneY());

			dragContext.mouseAnchorX = canvasPoint.getX();
			dragContext.mouseAnchorY = canvasPoint.getY();
		});

		setOnMouseClicked(event -> {
			this.setStroke(Color.TRANSPARENT);

		});

		setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

				// boundary canvas
				Point2D canvasPoint = LayoutScene.getInstance().getCanvas().sceneToLocal(mouseEvent.getSceneX(),
						mouseEvent.getSceneY());

				LayoutScene.getInstance().getContainerCanvas().getScrollHandler().setDraggedNode(BendPoint.this);
				
				double canvasWidth = LayoutScene.getInstance().getContainerCanvas().getRootPersistence()
						.getCanvasWidth() - 8;
				
				double canvasHeight = LayoutScene.getInstance().getContainerCanvas().getRootPersistence()
						.getCanvasHeight();

				// Top
				if (canvasPoint.getY() < 0 
						|| canvasPoint.getX() < 3 
						|| canvasPoint.getY() > canvasHeight
						|| canvasPoint.getX() > canvasWidth
				) {
					mouseEvent.consume();
					return;
				}

				Ente ente = BendPoint.this.lineWrapper.parent;
				DraggableNode parentNode = ente.getDraggableNode();

				double offsetX = parentNode.snapToGrid(dragContext.mouseAnchorX - canvasPoint.getX());
				double offsetY = parentNode.snapToGrid(dragContext.mouseAnchorY - canvasPoint.getY());

				newValueX.set(dragContext.initialTranslateX - offsetX);
				newValueY.set(dragContext.initialTranslateY - offsetY);

				if (draggableHorizontally && draggableVertically) {

					setX_Property(newValueX.get());
					setY_Property(newValueY.get());

					setTranslateX((-1) * offsetX);
					setTranslateY((-1) * offsetY);

				} else if (draggableHorizontally) {

					setX_Property(newValueX.get());
					setTranslateX((-1) * offsetX);

				} else if (draggableVertically) {

					setY_Property(newValueY.get());
					setTranslateY((-1) * offsetY);

				}

				updateAttachedNodesPosition();

				mouseEvent.consume();

			}

		});

		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					getScene().setCursor(Cursor.HAND);

					// Disable
					if (lineWrapper != null) {
						lineWrapper.setOnMouseDragged(null);
					}
				}
			}
		});

		setOnMouseExited(mouseEvent -> {

			if (!mouseEvent.isPrimaryButtonDown()) {

				getScene().setCursor(Cursor.DEFAULT);

				// Enable

				if (lineWrapper != null) {
					lineWrapper.setOnMouseDragged(parentDragEvent);
				}

			}
		});

		setOnMouseReleased((event) -> {

			// Enable
			this.setStroke(Color.TRANSPARENT);
			if (lineWrapper != null) {
				lineWrapper.setOnMouseDragged(parentDragEvent);
			}

			if (!event.isStillSincePress()) {
				// if there has been a drag

				setTranslateX(0);
				setTranslateY(0);

				EMFCommands emfCommand = new EMFCommands();
				emfCommand.begin();

				setCenterX(getX_Property().get());
				setCenterY(getY_Property().get());

				// disconnect and try to reconnect nodes along the polyline
				List<AnchorPointVirtual> virtuals = getVirtualAnchorPointsAssociated();
				for (AnchorPointVirtual ap : virtuals) {
					AnchorPoint target = ap.getTarget();
					ap.disconnect();
					Ente padre = target.getEntePadre();

					if (padre instanceof EnteBendable) {
						EnteBendable ente = (EnteBendable) padre;
						Magnete.stretchPolyline(ente.getCustomLine(), target);
					} else {
						Magnete.connect(padre.getDraggableNode(), target);
					}
				}

				// launch magnet for this bendpoint
				if (BendPoint.this == getFirstBendPoint() || BendPoint.this == getLastBendPoint()) {

					AnchorPoint associated = getExtremeAnchorPointAssociated();

					if (associated != null) {
						associated.disconnect();
						Magnete.stretchPolyline(lineWrapper, associated);
					}
				}

				((EnteBendable) lineWrapper.parent).updateDraggableNodePosition();

				emfCommand.end();
			}

			event.consume();
		});

	}

	private BendPoint getFirstBendPoint() {
		return lineWrapper.getPuntiPolilinea().get(0);
	}

	private BendPoint getLastBendPoint() {
		return lineWrapper.getPuntiPolilinea().get(lineWrapper.getPuntiPolilinea().size() - 1);
	}

	public boolean isFirstBendPoint() {
		return lineWrapper.getPuntiPolilinea().indexOf(this) == 0;
	}

	public boolean isLastBendPoint() {
		return lineWrapper.getPuntiPolilinea().indexOf(this) == (lineWrapper.getPuntiPolilinea().size() - 1);
	}

	public BendPoint getPreviousBendPoint() {
		if (this == getFirstBendPoint()) {
			return null;
		} else {
			return lineWrapper.getPuntiPolilinea().get(lineWrapper.getPuntiPolilinea().indexOf(this) - 1);
		}
	}

	public BendPoint getNextBendPoint() {
		if (this == getLastBendPoint()) {
			return null;
		} else {
			return lineWrapper.getPuntiPolilinea().get(lineWrapper.getPuntiPolilinea().indexOf(this) + 1);
		}

	}

	private BendPoint getSecondBendPoint() {
		return lineWrapper.getPuntiPolilinea().get(1);
	}

	private BendPoint getSecondLastBendPoint() {
		return lineWrapper.getPuntiPolilinea().get(lineWrapper.getPuntiPolilinea().size() - 2);
	}

	public BendPoint getExtremeNeighbor() {
		if (this == getFirstBendPoint())
			return getSecondBendPoint();
		if (this == getLastBendPoint())
			return getSecondLastBendPoint();

		return null;
	}

	/**
	 * @see LineWrapper#parse_attachedNodes()
	 */
	public Map<Node, Double[]> attachedNodes = new HashMap<Node, Double[]>();

	/**
	 * Gets the {@code AnchorPoint} attached to this {@code BendPoint}
	 * 
	 * @return the attached {@code AnchorPoint}, if it exists.
	 */
	public AnchorPoint getExtremeAnchorPointAssociated() {
		for (Node node : attachedNodes.keySet()) {
			if (node instanceof AnchorPoint)
				if (!((AnchorPoint) node).isVirtual())
					return (AnchorPoint) node;
		}

		return null;
	}

	/**
	 * Gets the virtual anchor points attached to this {@code BendPoint}
	 * 
	 * @return the list of virtual anchor points associated. It could be empty.
	 */
	public List<AnchorPointVirtual> getVirtualAnchorPointsAssociated() {
		List<AnchorPointVirtual> virtuals = new ArrayList<AnchorPointVirtual>();

		for (Node node : attachedNodes.keySet()) {
			if (node instanceof AnchorPointVirtual)
				virtuals.add((AnchorPointVirtual) node);
		}

		return virtuals;
	}

	/**
	 * This function update the position of nodes attached to this {@code BendPoint}
	 * 
	 * @see LineWrapper#parse_attachedNodes() and
	 *      {@link PolylineUtils#updatePosition(BendPoint, BendPoint)}
	 */
	public void updateAttachedNodesPosition() {

		if (lineWrapper.getPuntiPolilinea().size() > 1) {
			if (BendPoint.this == getFirstBendPoint()) {
				PolylineUtils.updatePosition(BendPoint.this, getSecondBendPoint());
				PolylineUtils.updatePosition(getLastBendPoint(), getSecondLastBendPoint());

				return;
			}
			if (BendPoint.this == getLastBendPoint()) {
				PolylineUtils.updatePosition(BendPoint.this, getSecondLastBendPoint());
				PolylineUtils.updatePosition(getFirstBendPoint(), getSecondBendPoint());

				return;
			}
			if (BendPoint.this == getSecondBendPoint()) {
				PolylineUtils.updatePosition(getFirstBendPoint(), getSecondBendPoint());
			}
			if (BendPoint.this == getSecondLastBendPoint()) {
				PolylineUtils.updatePosition(getLastBendPoint(), getSecondLastBendPoint());
			}

			PolylineUtils.updatePosition(BendPoint.this);
		}
	}

	/**
	 * Update coordinates to align its center to the grid
	 */
	public void snapBendPointToGrid() {

		double[] current_coords = this.getCoordinatesRelativeToCanvas();

		double _x = current_coords[0];
		double _y = current_coords[1];

		Ente ente = this.lineWrapper.parent;
		DraggableNode parentNode = (DraggableNode) ente.getParent();

		int risoluzione_griglia = parentNode.draggingStepLength;

		double g = risoluzione_griglia;
		double h = risoluzione_griglia / 2d;

		double modX = _x % g;
		double modY = _y % g;

		double offsetX = modX >= h ? g - modX : ((-1) * modX);
		double offsetY = modY >= h ? g - modY : ((-1) * modY);

		setCenterX(getCenterX() + offsetX);
		setCenterY(getCenterY() + offsetY);

	}

	public double[] getCoordinatesRelativeToCanvas() {
		Bounds boundsInLocal;
		Bounds boundsInScene;

		boundsInLocal = this.getBoundsInLocal();
		boundsInScene = this.localToScene(boundsInLocal);

		Bounds sc = LayoutScene.getInstance().getCanvas().sceneToLocal(boundsInScene);

		return new double[] { sc.getCenterX(), sc.getCenterY() };
	}

	public double getTempPositionX() {
		return getCenterX() + getTranslateX();
	}

	public double getTempPositionY() {
		return getCenterY() + getTranslateY();
	}
}
