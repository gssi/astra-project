package it.gssi.astra.metaeditor.common.canvas;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * This class handles automatic scrolling of the canvas when a draggable element
 * is moved outside
 */
public class CanvasScrollHandler {

	private ContainerCanvas scrollPane;

	private Timeline scrolltimeline = new Timeline();

	private double scrollVelocity = 0.02;

	private Node draggedNode;

	private Point2D cursorPoint = new Point2D(0, 0);

	private enum VScrollDirection {
		TOP, BOTTOM
	}

	private enum HScrollDirection {
		LEFT, RIGHT
	}

	/*
	 * EVENTS
	 */

	/**
	 * Stop scroll on mouse release
	 */
	private EventHandler<MouseEvent> mouseRelease = mouseEvent -> {
		reset();
	};

	/**
	 * Start scroll and save the cursor location
	 */
	private EventHandler<MouseEvent> mouseDragged = mouseEvent -> {

		cursorPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());

		scrolltimeline.play();
	};

	/**
	 * Initialize scroll when cursor exits canvas
	 */
	private EventHandler<MouseEvent> onMouseExited = mouseEvent -> {

		if (mouseEvent.isPrimaryButtonDown()) {

			scrollPane.getCanvas().getScene().addEventFilter(MouseEvent.MOUSE_DRAGGED, mouseDragged);

			scrollPane.getCanvas().getScene().addEventFilter(MouseEvent.MOUSE_RELEASED, mouseRelease);
		}
	};

	/*
	 * CONSTRUCTOR
	 */

	public CanvasScrollHandler(ContainerCanvas scrollPane) {

		this.scrollPane = scrollPane;

		initialize();
	}

	
	/*
	 * These two functions computeHvalue and computeVvalue are used to center the object 
	 * passed to him as a parameter to scroll the canvas for a more precise search
	 */
	
	public void computeHvalue(DraggableNode dNode) {
		Double value = (1/LayoutScene.getInstance().getContainerCanvas().getCanvas().getWidth()) * dNode.layoutXProperty().get();
		//calculate the smallest and largest shown
		Bounds bounds = scrollPane.getViewportBounds();
	    int lowestXPixelShown = -1 * (int)bounds.getMinX() + 1;
	    int highestXPixelShown = (int) (lowestXPixelShown + bounds.getWidth());
	    //get y coordinate of draggable node 
	    var coordXDraggableNode = dNode.layoutXProperty().get() ;
	    if (!(coordXDraggableNode > lowestXPixelShown && coordXDraggableNode < highestXPixelShown ))
	    	scrollPane.setHvalue(value);
	}
		
		
	public void computeVvalue(DraggableNode dNode) {
		Double value = (1/LayoutScene.getInstance().getContainerCanvas().getCanvas().getHeight()) * dNode.layoutYProperty().get();
		//calculate the smallest and largest shown
		Bounds bounds = scrollPane.getViewportBounds();
	    int lowestYPixelShown = -1 * (int)bounds.getMinY() + 1;
	    int highestYPixelShown = (int) (lowestYPixelShown + bounds.getHeight());
	    //get y coordinate of draggable node 
	    var coordYDraggableNode = dNode.layoutYProperty().get() ;
	    if (!(coordYDraggableNode > lowestYPixelShown && coordYDraggableNode < highestYPixelShown))
	    	scrollPane.setVvalue(value);
	}
	
	/*
	 * METHODS
	 */

	private void initialize() {

		scrolltimeline.setCycleCount(Timeline.INDEFINITE);
		scrolltimeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), ActionEvent -> scrollCanvas()));

		scrollPane.getCanvas().setOnMouseExited(onMouseExited);

		scrollPane.getCanvas().setOnMouseEntered(e -> reset());
	}

	/**
	 * Reset handler
	 */
	private void reset() {

		scrollPane.getCanvas().getScene().removeEventFilter(MouseEvent.MOUSE_DRAGGED, mouseDragged);

		scrollPane.getCanvas().getScene().removeEventFilter(MouseEvent.MOUSE_RELEASED, mouseRelease);

		draggedNode = null;

		scrolltimeline.stop();
	}

	/**
	 * This method fire the event of <code>MouseEvent.MOUSE_DRAGGED</code> with
	 * <code>point</code> coordinates and as a <code>node</code> target.
	 */
	private void fireDragEvent(Node node, Point2D point) {

		if (node != null) {
			MouseEvent e = new MouseEvent(MouseEvent.MOUSE_DRAGGED, point.getX(), point.getY(), 0, 0, null, 0, false,
					false, false, false, false, false, false, false, false, false, false, false, null);

			Event.fireEvent(node, e);
		}
	}

	/**
	 * Detects the direction of the scroll based on the cursor position relative to
	 * the canvas
	 */
	private VScrollDirection detectVScrollDirection(Bounds canvasBounds, Point2D cursorPoint) {

		if (cursorPoint.getY() <= canvasBounds.getMinY()) {
			// Top
			return VScrollDirection.TOP;
		} else if (cursorPoint.getY() >= canvasBounds.getMaxY()) {
			// Bottom
			return VScrollDirection.BOTTOM;
		}

		return null;
	}

	/**
	 * Detects the direction of the scroll based on the cursor position relative to
	 * the canvas
	 */
	private HScrollDirection detectHScrollDirection(Bounds canvasBounds, Point2D cursorPoint) {

		if (cursorPoint.getX() <= canvasBounds.getMinX()) {
			// Left
			return HScrollDirection.LEFT;
		} else if (cursorPoint.getX() >= canvasBounds.getMaxX()) {
			// Bottom
			return HScrollDirection.RIGHT;
		}

		return null;
	}

	/**
	 * This method scrolls the canvas depending on the position of the cursor, also
	 * simulates the drag of the current node to improve the fluidity of the
	 * movement.
	 * 
	 * Since <code>MouseEvent.MOUSE_DRAGGED<code> of the node is launched only when
	 * the cursor is moved, it is necessary to simulate the event to avoid that the
	 * node remains stationary during the scroll.
	 * 
	 * To simulate this event you must first set the target node via
	 * {@link setDraggedNode()}
	 * 
	 * @see it.gssi.astra.metaeditor.common.ente.DragMouseGestures#onMouseDraggedEventHandler
	 */
	private void scrollCanvas() {

		Bounds canvasBounds = scrollPane.localToScene(scrollPane.getBoundsInParent());

		VScrollDirection vScrollDirection = detectVScrollDirection(canvasBounds, cursorPoint);

		verticalScroll(vScrollDirection);

		HScrollDirection hScrollDirection = detectHScrollDirection(canvasBounds, cursorPoint);

		horizontalScroll(hScrollDirection);

		// Simulate the drag event at each scroll
		fireDragEvent(draggedNode, cursorPoint);
	}

	/**
	 * Make a vertical scroll on the canvas
	 * 
	 * @param vScrollDirection
	 */
	public void verticalScroll(VScrollDirection vScrollDirection) {

		double scrollGap = 0;

		if (vScrollDirection == VScrollDirection.TOP) {
			scrollGap = scrollVelocity * -1;
		} else if (vScrollDirection == VScrollDirection.BOTTOM) {
			scrollGap = scrollVelocity * 1;
		} else {
			scrollGap = 0;
		}

		double vValue = scrollPane.getVvalue() + scrollGap;

		vValue = Math.min(vValue, 1.0);
		vValue = Math.max(vValue, 0.0);

		scrollPane.setVvalue(vValue);
	}

	/**
	 * Make a horizontal scroll on the canvas
	 * 
	 * @param vScrollDirection
	 */
	public void horizontalScroll(HScrollDirection hScrollDirection) {

		double scrollGap = 0;

		if (hScrollDirection == HScrollDirection.LEFT) {
			scrollGap = scrollVelocity * -1;
		} else if (hScrollDirection == HScrollDirection.RIGHT) {
			scrollGap = scrollVelocity * 1;
		} else {
			scrollGap = 0;
		}

		double hValue = scrollPane.getHvalue() + scrollGap;
		hValue = Math.min(hValue, 1.0);
		hValue = Math.max(hValue, 0.0);

		scrollPane.setHvalue(hValue);
	}

	public void setDraggedNode(Node draggedNode) {
		this.draggedNode = draggedNode;
	}
}
