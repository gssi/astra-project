package it.gssi.astra.metaeditor.common.ente;

import java.util.Iterator;


import MetaEditor.MetaEditorPersistence.ElementPosition;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.ContainerCanvas;
import it.gssi.astra.metaeditor.common.canvas.ErrorFrame;
import it.gssi.astra.metaeditor.common.canvas.SelectionFrame;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.canvas.WarningFrame;
import it.gssi.astra.metaeditor.common.dataManager.commands.CustomCommandStack;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.grid.GridUtils;
import it.gssi.astra.metaeditor.common.magnete.Magnete;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * This class is the container of ente, 
 * ente is child of draggable node!, that means when we put the drag-able node on canvas we are putting the ente olso
 * 
 */
public class DraggableNode extends Group {

	/**
	 * It takes the value from {@link Ente#getDraggingStepLength()}
	 */
	public int draggingStepLength;

	private Ente ente;

	public Ente getEnte() {
		return ente;
	}
	
	public Boundary boundary;

	public ErrorFrame errorFrame;
	public WarningFrame warningFrame;
	public SelectionFrame selectionFrame;

	public DragMouseGestures mouseGesture;

	public ContainerCanvas ownCanvas;

	/**
	 * @param e if the ente contained into this draggable node 
	 * @param elementPosition corresponding to element position of this ente
	 */
	public DraggableNode(Ente e) {

		ownCanvas = LayoutScene.getInstance().getContainerCanvas();

		this.ente = e;
		
		this.boundary = new Boundary(ente);

		this.getChildren().addAll(boundary, e);

		errorFrame = new ErrorFrame(getEnte());
		warningFrame = new WarningFrame(getEnte());
		selectionFrame = new SelectionFrame(getEnte());

		mouseGesture = new DragMouseGestures(this);

		draggingStepLength = e.getDraggingStepLength();
		selectedProperty();
	}

	/**
	 * This function binds JavaFX coordinates with {@code ElementPosition} coordinates
	 * using the library provided by e(fx)clipse. But if {@code layoutXProperty} and
	 * {@code layoutYProperty} have been previously bound with some custom code then
	 * only a listener is necessary to propagate the changes of X and Y to the model.
	 * 
	 * @param e if the ente contained into this draggable node 
	 * @param elementPosition corresponding to element position of this ente
	 */
	public void synchronizePosition(Ente e, ElementPosition elementPosition) {
		
		if (!e.getDraggableNode().layoutXProperty().isBound()) {
			// data binding between layoutX property and persistence of X
			JFX2EMF.bindValues(Contexts.PERSISTENCE, elementPosition, "x", this, "layoutX", Converters.EINT_DOUBLE);
			
		} else {
			this.layoutXProperty().addListener((observable, oldValue, newValue) -> {
				elementPosition.setX((int) Math.round((Double) newValue));
			});
		}
		
		if (!e.getDraggableNode().layoutYProperty().isBound()) {
			// data binding between layoutY property and persistence of Y
			JFX2EMF.bindValues(Contexts.PERSISTENCE, elementPosition, "y", this, "layoutY", Converters.EINT_DOUBLE);
			
		} else {
			this.layoutYProperty().addListener((observable, oldValue, newValue) -> {
				elementPosition.setY((int) Math.round((Double) newValue));
			});
		}
		
		// data binding between view order property and persistence of Z
		JFX2EMF.bindValues(Contexts.PERSISTENCE, elementPosition, "z", this, "viewOrder", Converters.EINT_DOUBLE);
		
		CustomCommandStack commandStack = (CustomCommandStack) LayoutScene.getInstance().getEditingDomain().getCommandStack();
		
		this.scaleXProperty().addListener((observable, oldValue, newValue) -> {
			if (!commandStack.isReadOnly()) {
				ente.dropOldConnections();
				Magnete.connect(DraggableNode.this);
			}
		});

		this.scaleYProperty().addListener((observable, oldValue, newValue) -> {
			if (!commandStack.isReadOnly()) {
				ente.dropOldConnections();
				Magnete.connect(DraggableNode.this);
			}
		});
	}
	
	/**
	 * Validation function of value coming from the Numeric field of X.
	 *
	 * @param val
	 */
	public boolean isXInsideCanvas(Object val) {
		
		String newValue = (String) val;
		if (!newValue.isEmpty()) {
			if (LayoutScene.getInstance().getRootPersistence().getCanvasWidth() < Double.valueOf(newValue)
					+ this.getBoundsInParent().getWidth()) {
				return false;
			} else
				return true;
		} else
			return true;
		
	}
	
	/**
	 * Validation function of value coming from the Numeric field of Y.
	 *
	 * @param val
	 */
	public boolean isYInsideCanvas(Object val) {

		String newValue = (String) val;
		if (!newValue.isEmpty()) {
			if (LayoutScene.getInstance().getRootPersistence().getCanvasHeight() < Double.valueOf(newValue)
					+ this.getBoundsInParent().getHeight()) {
				return false;
			} else
				return true;
		} else
			return true;
		
	}

	/**
	 * Specifies whether this {@code DraggableNode} is contained in
	 * {@code SelectionModel}.
	 *
	 * @defaultValue false
	 */
	private BooleanProperty selectedProperty;
	
	public boolean getSelected() {
		return selectedProperty.get();
	}

	public void setSelected(boolean value) {
		selectedProperty().set(value);
	}

	public BooleanProperty selectedProperty() {
		if (selectedProperty == null) {
			selectedProperty = new BooleanPropertyBase(false) {
				@Override
				protected void invalidated() {
					if (get()) {
						boundary.setFill(Color.web("#80808020"));
						boundary.setStroke(Color.web("#0078D7"));
						addSelectionFrame();
					} else {
						boundary.setFill(Color.TRANSPARENT);
						boundary.setStroke(Color.TRANSPARENT);
						removeSelectionFrame();
					}

					if (getEnte() instanceof EnteBendable) {
						EnteBendable ente = (EnteBendable) getEnte();
						if (get())
							ente.getCustomLine().showBendPoints(true);
						else
							ente.getCustomLine().showBendPoints(false);
					}
				}

				@Override
				public Object getBean() {
					return DraggableNode.this;
				}

				@Override
				public String getName() {
					return "selected";
				}
			};
		}
		return selectedProperty;
	}
	
	/**
	 * Listener that select child when the parent is selected
	 * 
	 */
	public ChangeListener<Object> selectWithParentListener = new ChangeListener<Object>() {
		@Override
		public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
			if ((boolean) newValue) {
				SelectionModel.getSelection().add(DraggableNode.this);
				DraggableNode.this.setSelected(true);
			}
		}
	};
	
	/**
	 * Discretization of the drag of {@code DraggableNode} and {@link BendPoint} at steps defined by {@link DraggableNode#draggingStepLength}.
	 * 
	 * @param position It is an offset
	 * @return the new offset to be applied by the drag
	 */
	public Double snapToGrid(Double position) {
		return GridUtils.snapToGrid(position, draggingStepLength);
	}

	/**
	 * Snap to grid is a function used to position this drag-able node to line it up with the grid
	 * @param pivot 
	 */
	public void snapToGrid(Pivot pivot) {

		if (getEnte() instanceof EnteBendable) {
			((EnteBendable) getEnte()).customLine.getPuntiPolilinea().forEach(b -> {
				b.snapBendPointToGrid();
			});
			((EnteBendable) getEnte()).updateDraggableNodePosition();

			double[] offset = GridUtils.snapToGrid(pivot.getCoordinatesRelativeToCanvas(), draggingStepLength);

			if (this.getLayoutX() != 0)
				ente.elementPosition.setX((int) Math.round(this.getLayoutX() + offset[0]));
			
			if (this.getLayoutY() != 0)
				ente.elementPosition.setY((int) Math.round(this.getLayoutY() + offset[1]));
		} else {
			double[] offset = GridUtils.snapToGrid(pivot.getCoordinatesRelativeToCanvas(), draggingStepLength);

			if (this.getLayoutX() != 0)
				ente.elementPosition.setX((int) Math.round(this.getLayoutX() + offset[0]));
			
			if (this.getLayoutY() != 0)
				ente.elementPosition.setY((int) Math.round(this.getLayoutY() + offset[1]));
		}

	}

	/**
	 * This function insert into drag-able node the highlighting frame
	 * 
	 * @param critique is true if is an error false is a warning
	 */
	public void addErrorFrame(boolean critique) {
		if (critique) {
			if (!this.getChildren().contains(errorFrame)) {
				this.getChildren().add(0, errorFrame);
			}
		} else {
			if (!this.getChildren().contains(warningFrame)) {
				this.getChildren().add(0, warningFrame);
			}
		}
	}
	
	/**
	 * This function insert into drag-able node the selection frame
	 * 
	 */
	public void addSelectionFrame() {
		
		if(!this.getChildren().contains(selectionFrame)){
			this.getChildren().add(selectionFrame);
			selectionFrame.setViewOrder(20);
		}
		@SuppressWarnings("rawtypes")
		Iterator i = ente.getModel().eAllContents();
		while (i.hasNext()) {
			Ente ente = ownCanvas.getViewModelMap().get(i.next());
			if(ente != null)
				if(!ente.getDraggableNode().getChildren().contains(ente.getDraggableNode().selectionFrame)){
					ente.getDraggableNode().getChildren().add(ente.getDraggableNode().selectionFrame);
					ente.getDraggableNode().selectionFrame.setViewOrder(20);
				}
		}
		
	}

	public void removeErrorFrame() {
		this.getChildren().remove(errorFrame);
		this.getChildren().remove(warningFrame);
	}
	
	
	public void removeSelectionFrame() {
		if(this.getChildren().contains(selectionFrame)){
			this.getChildren().remove(selectionFrame);
		}
		@SuppressWarnings("rawtypes")
		Iterator i = ente.getModel().eAllContents();
		while (i.hasNext()) {
			Ente ente = ownCanvas.getViewModelMap().get(i.next());
			if(ente != null)
				if(ente.getDraggableNode().getChildren().contains(ente.getDraggableNode().selectionFrame)){
					ente.getDraggableNode().getChildren().remove(ente.getDraggableNode().selectionFrame);
				}
		}
		
	}

	public DragMouseGestures getMouseGesture() {
		return this.mouseGesture;
	};
}
