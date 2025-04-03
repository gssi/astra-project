package it.gssi.astra.metaeditor.common.ente;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.magnete.Magnete;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

/**
 * 
 * This Class manage the gesture of Draggable Node for example the selection the
 * drag
 *
 */
public class DragMouseGestures {

	private DraggableNode node;

	public DragMouseGestures(DraggableNode node) {

		this.node = node;

		node.setOnMousePressed(onMousePressedEventHandler);
		node.setOnMouseDragged(onMouseDraggedEventHandler);
		node.setOnMouseReleased(onMouseReleasedEventHandler);
		node.setOnMouseEntered(onMouseEnteredEventHandler);
		node.setOnMouseExited(onMouseExitedEventHandler);

		// Disable mouse dragged if the node is pinned or the canvas is locked
		node.addEventFilter(MouseEvent.MOUSE_DRAGGED, e -> {
			if (CustomMenu.getInstance().isLocked()) {
				e.consume();
			}
		});

	}

	private final DragContext dragContext = new DragContext();

	private boolean enabled = false;

	public EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent mouseEvent) {
			
			// don't do anything if the user is in the process of adding to the selection
			// model
			if (mouseEvent.isShortcutDown() || mouseEvent.isShiftDown())
				return;

			// node.toFront();

			Point2D canvasPoint = LayoutScene.getInstance().getCanvas().sceneToLocal(mouseEvent.getSceneX(),
					mouseEvent.getSceneY());

			dragContext.mouseAnchorX = canvasPoint.getX();
			dragContext.mouseAnchorY = canvasPoint.getY();

			// clear the model if the current node isn't in the selection => new selection
			if (!SelectionModel.contains(node)) {
				SelectionModel.clearAdd(node);
			}

			// flag that the mouse released handler should consume the event, so it won't
			// bubble up to the pane which has a rubberband selection mouse released handler
			enabled = true;

			// prevent rubberband selection handler
			mouseEvent.consume();
		}
	};

	public EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent mouseEvent) {

			if (!enabled)
				return;

			Point2D canvasPoint = LayoutScene.getInstance().getCanvas().sceneToLocal(mouseEvent.getSceneX(),
					mouseEvent.getSceneY());

			double offsetX = canvasPoint.getX() - dragContext.mouseAnchorX;
			double offsetY = canvasPoint.getY() - dragContext.mouseAnchorY;

			offsetX = node.snapToGrid(offsetX);
			offsetY = node.snapToGrid(offsetY);
			
			//Scroll
			LayoutScene.getInstance().getContainerCanvas().getScrollHandler().setDraggedNode(node);

			// all in selection
			for (DraggableNode node : SelectionModel.getSelection()) {

				if (!node.getEnte().getPinned() && !CustomMenu.getInstance().isLocked()) {

					node.setTranslateX(offsetX);
					node.setTranslateY(offsetY);

					// Check if the node is inside the canvas

					// Left Side
					if (node.getBoundsInParent().getMinX() < 0) {
						node.setTranslateX(-node.getLayoutX());
					}
					// Top Side
					if (node.getBoundsInParent().getMinY() < 0) {
						node.setTranslateY(-node.getLayoutY());
					}
					// Right Side
					if (node.getBoundsInParent().getMaxX() > LayoutScene.getInstance().getContainerCanvas().getGrid()
							.getGridWidth()) {
						
						var offset = LayoutScene.getInstance().getContainerCanvas().getGrid().getWidth()-node.getLayoutX()- node.getBoundsInParent().getWidth();
						
						node.setTranslateX(offset);
					}
					// Bottom Side
					if (node.getBoundsInParent().getMaxY() > LayoutScene.getInstance().getContainerCanvas().getGrid()
							.getGridHeight()) {
						
						var offset = LayoutScene.getInstance().getContainerCanvas().getGrid().getHeight()-node.getLayoutY()- node.getBoundsInParent().getHeight();

						node.setTranslateY(offset);
					}
				}
			}
		}
	};

	public EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent mouseEvent) {

			// prevent rubberband selection handler
			if (enabled) {

				if (!mouseEvent.isStillSincePress()) {
					// if there has been a drag

					EMFCommands emfCommand = new EMFCommands();
					emfCommand.begin();

					for (DraggableNode node : SelectionModel.getSelection()) {

						if (!node.getEnte().getPinned()) {

							// Drop all connection before changing coordinates, so that the CTRL-Z
							// will trigger changes to coordinates before undoing the drop of connections.
							// Otherwise the reconnection would not have worked with mismatched coordinates.
							node.getEnte().dropOldConnections();

							// set node's layout position to current position,remove translate coordinates
							fixPosition(node);

							if (!(SelectionModel.getSelection().size() > 1)) {
								// if there is only one element in the selection
								node.snapToGrid(node.getEnte().pivot);
							}

							Magnete.connect(node);
						}
					}

					emfCommand.end();
				}

				enabled = false;

				mouseEvent.consume();
			}
		}
	};

	private EventHandler<MouseEvent> onMouseEnteredEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (!event.isPrimaryButtonDown()) {
				node.getScene().setCursor(Cursor.HAND);
			}
		}
	};

	private EventHandler<MouseEvent> onMouseExitedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (!event.isPrimaryButtonDown()) {
				node.getScene().setCursor(Cursor.DEFAULT);
			}
		}
	};

	/**
	 * Set node's layout position to current position, remove translate coordinates.
	 * 
	 * @param node Draggable Node
	 */
	private void fixPosition(DraggableNode node) {

		double x = node.getTranslateX();
		double y = node.getTranslateY();

		node.setLayoutX(node.getLayoutX() + x);
		node.setLayoutY(node.getLayoutY() + y);

		node.setTranslateX(0);
		node.setTranslateY(0);
	}
}
