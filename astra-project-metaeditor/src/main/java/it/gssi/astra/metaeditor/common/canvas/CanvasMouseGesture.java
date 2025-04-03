package it.gssi.astra.metaeditor.common.canvas;

import java.util.ArrayList;
import java.util.List;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.cloneManager.CloneImpl;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.palette.PaletteGesture;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * This class handles mouse events on the canvas, specifically: mouse pressed
 * and drag events. These events have the main purpose of simulating the
 * selection on the canvas through the {@link RectangleSelection}.
 * 
 * When the canvas is selected (MOUSE_PRESSED) the click coordinates (source
 * point) are stored and the {@link RectangleSelection} with 0x0 size is added
 * to the canvas. When the mouse is dragged, the distance between the cursor and
 * the point of origin is calculated, with this value the size of the
 * {@link RectangleSelection} is changed. Finally at the release of the mouse
 * are selected all the entities that are within the {@link RectangleSelection}.
 *
 */
public class CanvasMouseGesture {

	private final DragContext dragContext = new DragContext();

	private final RectangleSelection rect = new RectangleSelection();

	private final Canvas canvas;

	private boolean enabled = false;

	public CanvasMouseGesture(Canvas canvas) {

		this.canvas = canvas;

		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
		canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);
		
		
		canvas.setOnDragEntered(OnDragEntered); 
		canvas.setOnDragExited(OnDragExited);
		canvas.setOnDragOver(OnDragOver);
		canvas.setOnDragDropped(OnDragDropped);
	}

	private final class DragContext {

		public double mouseAnchorX;
		public double mouseAnchorY;
	}

	private EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			// simple flag to prevent multiple handling of this event or we'd get an
			// exception because rect is already on the scene
			// eg if you drag with left mouse button and while doing that click the right
			// mouse button
			if (enabled)
				return;

			dragContext.mouseAnchorX = event.getX();
			dragContext.mouseAnchorY = event.getY();

			rect.setX(dragContext.mouseAnchorX);
			rect.setY(dragContext.mouseAnchorY);
			rect.setWidth(0);
			rect.setHeight(0);

			canvas.getChildren().add(rect);
			CloneImpl.getInstance().clickedX = (int) event.getX();
			CloneImpl.getInstance().clickedY = (int) event.getY();

			event.consume();

			enabled = true;

			//LayoutScene.getInstance().treeView.getSelectionModel().clearSelection(0);
			canvas.contextMenu.hide();

			if (event.getButton() == MouseButton.SECONDARY) {
				canvas.contextMenu.show(canvas, event.getScreenX(), event.getScreenY());
				event.consume();
			}
		}
	};

	private EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			if (!event.isShiftDown() && !event.isShortcutDown()) {
				// if not there has been a drag
				SelectionModel.clear(false);
			}

			List<DraggableNode> addToSelectionModel = new ArrayList<DraggableNode>();
			List<DraggableNode> removeFromSelectionModel = new ArrayList<DraggableNode>();
			List<DraggableNode> intersectedElements = new ArrayList<DraggableNode>();
			
			for (Node node : canvas.getChildren()) {

				if (node instanceof DraggableNode) {
					DraggableNode dNode = (DraggableNode) node;

					if (node.getBoundsInParent().intersects(rect.getBoundsInParent()) && dNode.isVisible()) {
						
						intersectedElements.add(dNode);

						// Node inside the selection rectangle
						if (event.isShiftDown() || event.isShortcutDown()) {
							if (SelectionModel.contains(dNode)) {
								removeFromSelectionModel.add(dNode);
							} else {
								addToSelectionModel.add(dNode);
							}
						} else {
							addToSelectionModel.add(dNode);
						}
					} 
					/*else {
						// Node outside the selection rectangle
						if (!event.isShiftDown() && !event.isShortcutDown() && dNode.isVisible()) {
							removeFromSelectionModel.add(dNode);
						}
					}*/
				}
			}
			
			//in caso di sovrapposizione, voglio selezionare/deselezionare solo il dNode con lo zIndex più basso
			if ((event.isShiftDown() || event.isShortcutDown()) && rect.getHeight() == 0 && rect.getWidth() == 0 &&
					intersectedElements.size() > 1) {
				DraggableNode nodeMinZIndez = intersectedElements.get(0);
				for (DraggableNode currentNode : intersectedElements) {
					if (currentNode.getViewOrder() < nodeMinZIndez.getViewOrder()) {
						nodeMinZIndez = currentNode;
					}
				}
				if (SelectionModel.contains(nodeMinZIndez)) 
					SelectionModel.remove(nodeMinZIndez);
				else 
					SelectionModel.add(nodeMinZIndez);
			}
			else {
				SelectionModel.remove(removeFromSelectionModel);
				SelectionModel.add(addToSelectionModel);
			}
			
			rect.setX(0);
			rect.setY(0);
			rect.setWidth(0);
			rect.setHeight(0);

			canvas.getChildren().remove(rect);

			event.consume();

			enabled = false;
		}
	};

	private EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {

			double offsetX = event.getX() - dragContext.mouseAnchorX;
			double offsetY = event.getY() - dragContext.mouseAnchorY;

			if (event.getX() <= 0) {
				rect.setWidth(dragContext.mouseAnchorX);
			} else {
				if (offsetX > 0)
					rect.setWidth(offsetX);
				else {
					rect.setX(event.getX());
					rect.setWidth(dragContext.mouseAnchorX - rect.getX());
				}
			}

			if (event.getY() <= 0) {
				rect.setHeight(dragContext.mouseAnchorY);
			} else {
				if (offsetY > 0) {
					rect.setHeight(offsetY);
				} else {
					rect.setY(event.getY());
					rect.setHeight(dragContext.mouseAnchorY - rect.getY());
				}
			}

			event.consume();
		}
	};
	
	public static EventHandler<DragEvent> OnDragOver = new EventHandler<DragEvent>() {

		public void handle(DragEvent event) {
			/* data is dragged over the target */
//		                System.out.println("onDragOver");

			/*
			 * accept it only if it is not dragged from the same node and if it has a string
			 * data
			 */
			if (event.getGestureSource() != ((AnchorPane) event.getSource()) && event.getDragboard().hasString()) {
				/* allow for both copying and moving, whatever user chooses */
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

			}

			event.consume();
		}
	};

	public static EventHandler<DragEvent> OnDragEntered = new EventHandler<DragEvent>() {

		public void handle(DragEvent event) {
			/* the drag-and-drop gesture entered the target */
//		                System.out.println("onDragEntered");
			/* show to the user that it is an actual gesture target */

			if (event.getGestureSource() != ((AnchorPane) event.getSource()) && event.getDragboard().hasString()
					&& !(event.getSource() instanceof Node)) {
				((AnchorPane) event.getSource())
						.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
			}

			event.consume();
		}
	};

	public static EventHandler<DragEvent> OnDragExited = new EventHandler<DragEvent>() {

		public void handle(DragEvent event) {
			/* mouse moved away, remove the graphical cues */
			((AnchorPane) event.getTarget()).setBackground(Background.EMPTY);

			event.consume();
		}
	};

	public static EventHandler<DragEvent> OnDragDropped = new EventHandler<DragEvent>() {

		public void handle(DragEvent event) {
			
			Dragboard db = event.getDragboard();
			boolean success = false;
			if (db.hasString()) {
				LayoutScene.getInstance().paletteInterface.createElement(event, PaletteGesture.root);
				success = true;
			}
			/*
			 * let the source know whether the string was successfully transferred and used
			 */
			event.setDropCompleted(success);

			event.consume();
		}
	};
}