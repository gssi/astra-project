package it.gssi.astra.metaeditor.common.ente.customNode;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.ente.EnteBendable;
import it.gssi.astra.metaeditor.common.magnete.AnchorPointVirtual;
import it.gssi.astra.metaeditor.common.magnete.Magnete;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 * <p>
 * Creates a polyline, defined by the array of the segment points. This class
 * represents a polyline, defined by the array of the segment points in
 * {@code (x,y)} coordinate space with drag-able points. It wraps the
 * coordinates of {@link javafx.scene.shape.Polyline} to make them available as
 * attributes in FXML. That is made by {@link CustomPolyline#points}. The
 * Polyline class is similar to the Polygon class, except that it is not
 * automatically closed.
 * </p>
 * 
 * <p>
 * FXML example usage. The following snippet creates a polyline made of four
 * points.
 * </p>
 *
 * <pre>
 * {@code
 * <?import it.univaq.disim.ermes.metaeditor.common.ente.customNode.CustomPolyline?>
 * 
 * <fx:root type="Ente" xmlns:fx="http://javafx.com/fxml/1">
 *  <children>
 *     <CustomPolyline fx:id="customLine" points="0.0, 0.0, 75.0, 0.0" />
 *     <AnchorPoint fx:id="leftEnd" centerX="0.0" radius="3" />
 *	   <AnchorPoint fx:id="rightEnd" centerX="75.0" radius="3" />
 *     <Pivot fx:id="pivot" centerX="0.0" centerY="0.0" visible="false"/>
 *  </children>
 * </fx:root>
 * }
 * </pre>
 * 
 * <p>
 * <strong>NOTE: The id of CustomPolyline must be equal to {@code customLine} as
 * stated in {@link LineWrapper}</strong>
 * </p>
 *
 */
public class CustomPolyline extends LineWrapper {

	/**
	 * Creates a new instance of CustomPolyline. It is called by JavaFX with the
	 * attributes set in the FXML.
	 * 
	 */
	public CustomPolyline() {

		lineShape = new javafx.scene.shape.Polyline(0.0, 0.0, 50.0, 0.0);
		lineShape.setStrokeWidth(1);
		lineShape.setFill(Color.TRANSPARENT);
		lineShape.setStroke(Color.BLACK);
		lineShape.setStrokeLineCap(StrokeLineCap.BUTT);
		// Set the id of the underlying shape in order to support CSS styling
		lineShape.setId("customLine");
		// Listener needed to initialize the points of ahape through FXML attribute
		points.addListener(new ListChangeListener<Double>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Double> c) {
				((javafx.scene.shape.Polyline) lineShape).getPoints().clear();
				((javafx.scene.shape.Polyline) lineShape).getPoints().addAll(points);
			}

		});

		this.getChildren().add(lineShape);
	}

	// ================================================================================
	// Wrapper of Polyline coordinates - START
	// ================================================================================

	private final ObservableList<Double> points = FXCollections.observableArrayList();

	public final ObservableList<Double> getPoints() {
		return points;
	}

	// ================================================================================
	// Wrapper of Polyline coordinates - STOP
	// ================================================================================

	/**
	 * Implementation of {@link LineWrapper#getPointsCoords()}. It is exactly the
	 * same as {@link CustomPolyline#points}
	 */
	@Override
	public ObservableList<Double> getPointsCoords() {
		return ((javafx.scene.shape.Polyline) lineShape).getPoints();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addModel(ElementPosition objModel) {

		parse_attachedNodes();

		this.model = objModel;

		if (!model.getBendPoints().isEmpty()) {

			this.getPointsCoords().clear();

			for (MetaEditor.MetaEditorPersistence.BendPoint bendPoint : model.getBendPoints()) {
				this.getPointsCoords().add((double) bendPoint.getX());
				this.getPointsCoords().add((double) bendPoint.getY());
			}
		}

		addBendPoints();

		// Here we listen for the actions of adding and removing bend points to the
		// model
		// in order to update the element's graphic (the position changed event is
		// managed by the databinding)
		this.model.eAdapters().add(new AdapterImpl() {

			public void notifyChanged(Notification notification) {

				if (notification.getEventType() == Notification.ADD
						&& ((EStructuralFeatureImpl) notification.getFeature()).isContainment()) {

					MetaEditor.MetaEditorPersistence.BendPoint bendPoint = (MetaEditor.MetaEditorPersistence.BendPoint) notification
							.getNewValue();

					DoubleProperty xProperty = new SimpleDoubleProperty(bendPoint.getX());
					DoubleProperty yProperty = new SimpleDoubleProperty(bendPoint.getY());

					BendPoint new_bendPoint = new BendPoint(xProperty, yProperty, CustomPolyline.this);
					setContextMenuFor(new_bendPoint);

					int bendPoint_index = notification.getPosition();

					if (bendPoint_index != 0)
						punti_polilinea.add(bendPoint_index, new_bendPoint);
					else
						punti_polilinea.add(bendPoint_index + 1, new_bendPoint);

					CustomPolyline.this.getChildren().add(new_bendPoint);

					new_bendPoint.snapBendPointToGrid();
					redrawPolyline();

					new_bendPoint.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, bendPoint, "x",
							new_bendPoint, "centerX", Converters.EINT_DOUBLE));

					new_bendPoint.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, bendPoint, "y",
							new_bendPoint, "centerY", Converters.EINT_DOUBLE));
				}

				if (notification.getEventType() == Notification.REMOVE
						&& ((EStructuralFeatureImpl) notification.getFeature()).isContainment()) {

					int old_bendPoint_index = notification.getPosition();

					BendPoint clicked_BendPoint = punti_polilinea.get(old_bendPoint_index);

					// Dispose old bindings otherwise they will run again if we undo the remove
					clicked_BendPoint.getX_Binding().dispose();
					clicked_BendPoint.getY_Binding().dispose();

					punti_polilinea.remove(old_bendPoint_index);

					CustomPolyline.this.getChildren().remove(clicked_BendPoint);

					redrawPolyline();

					punti_polilinea.get(0).updateAttachedNodesPosition();
				}
			}

		});

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBendPoints() {

		List<Double> points = this.getPointsCoords();

		for (int i = 0; i < points.size(); i += 2) {
			final int index = i;

			DoubleProperty xProperty = new SimpleDoubleProperty(points.get(i));
			DoubleProperty yProperty = new SimpleDoubleProperty(points.get(i + 1));

			BendPoint bendPoint = new BendPoint(xProperty, yProperty, this);
			punti_polilinea.add(bendPoint);

			bendPoint.X_ChangeListener = new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {
					points.set(index, (double) x);
				}
			};
			xProperty.addListener(bendPoint.X_ChangeListener);

			bendPoint.Y_ChangeListener = new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {
					points.set(index + 1, (double) y);
				}
			};
			yProperty.addListener(bendPoint.Y_ChangeListener);
		}

		punti_polilinea.forEach(p -> setContextMenuFor(p));

		this.getChildren().addAll(punti_polilinea);

		punti_polilinea.get(0).attachedNodes.putAll(first_attachedNodes);
		punti_polilinea.get(punti_polilinea.size() - 1).attachedNodes.putAll(last_attachedNodes);
		punti_polilinea.get(0).updateAttachedNodesPosition();

		fixPosition();

		if (model.getBendPoints().isEmpty()) {

			for (BendPoint point : punti_polilinea) {

				MetaEditor.MetaEditorPersistence.BendPoint bendpoint = MetaEditorPersistenceFactory.eINSTANCE
						.createBendPoint();
				bendpoint.setX((int) Math.round(point.getX_Property().get()));
				bendpoint.setY((int) Math.round(point.getY_Property().get()));

				model.getBendPoints().add(bendpoint);

				point.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, bendpoint, "x", point, "centerX",
						Converters.EINT_DOUBLE));

				point.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, bendpoint, "y", point, "centerY",
						Converters.EINT_DOUBLE));
			}
		} else {

			int c = 0;

			for (MetaEditor.MetaEditorPersistence.BendPoint b : model.getBendPoints()) {

				BendPoint point = punti_polilinea.get(c);

				point.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, b, "x", point, "centerX",
						Converters.EINT_DOUBLE));

				point.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, b, "y", point, "centerY",
						Converters.EINT_DOUBLE));

				c++;
			}

		}
	}

	/**
	 * Add a new bend-point to the left of the clicked bend-point, if it is not the
	 * first of the sequence. Otherwise it will be put to the right.
	 */
	@Override
	public void addAnotherBendPoint(BendPoint clicked_BendPoint) {

		int index = punti_polilinea.indexOf(clicked_BendPoint);

		double x = 0;
		double y = 0;

		if (index != 0) {
			x = (clicked_BendPoint.getX_Property().doubleValue() + this.getPointsCoords().get((index * 2) - 2)) / 2;
			y = (clicked_BendPoint.getY_Property().doubleValue() + this.getPointsCoords().get((index * 2) - 1)) / 2;
		} else {
			x = (clicked_BendPoint.getX_Property().doubleValue() + this.getPointsCoords().get(2)) / 2;
			y = (clicked_BendPoint.getY_Property().doubleValue() + this.getPointsCoords().get(3)) / 2;
		}

		MetaEditor.MetaEditorPersistence.BendPoint bendpoint = MetaEditorPersistenceFactory.eINSTANCE.createBendPoint();
		bendpoint.setX((int) Math.round(x));
		bendpoint.setY((int) Math.round(y));

		Command addPersistenceBendPoint;

		if (index != 0) {
			addPersistenceBendPoint = AddCommand.create(LayoutScene.getInstance().getEditingDomain(), model,
					MetaEditorPersistencePackage.eINSTANCE.getBendableElementPosition_BendPoints(), bendpoint, index);
		} else {
			addPersistenceBendPoint = AddCommand.create(LayoutScene.getInstance().getEditingDomain(), model,
					MetaEditorPersistencePackage.eINSTANCE.getBendableElementPosition_BendPoints(), bendpoint, index + 1);
		}

		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(addPersistenceBendPoint);

	}

	/**
	 * Removes the clicked bend-point. It will re-attach pending nodes to remaining
	 * bend-points.
	 */
	@Override
	public void removeBendPoint(BendPoint clicked_BendPoint) {

		int index = punti_polilinea.indexOf(clicked_BendPoint);

		if (clicked_BendPoint.isFirstBendPoint()) {
			clicked_BendPoint.getNextBendPoint().attachedNodes.putAll(clicked_BendPoint.attachedNodes);
		}
		if (clicked_BendPoint.isLastBendPoint()) {
			clicked_BendPoint.getPreviousBendPoint().attachedNodes.putAll(clicked_BendPoint.attachedNodes);
		}

		MetaEditor.MetaEditorPersistence.BendPoint bendPoint = model.getBendPoints().get(index);
		Command removeBendPoint = RemoveCommand.create(LayoutScene.getInstance().getEditingDomain(), model,
				MetaEditorPersistencePackage.eINSTANCE.getBendableElementPosition_BendPoints(), bendPoint);
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(removeBendPoint);

	}

	/**
	 * Update bend-point listeners when a bend-point is removed or a new one is
	 * added.
	 */
	private void redrawPolyline() {

		getPointsCoords().clear();

		for (BendPoint bendpoint : punti_polilinea) {

			if (bendpoint.X_ChangeListener != null)
				bendpoint.getX_Property().removeListener(bendpoint.X_ChangeListener);
			if (bendpoint.Y_ChangeListener != null)
				bendpoint.getY_Property().removeListener(bendpoint.Y_ChangeListener);

			int current_index = punti_polilinea.indexOf(bendpoint);

			// Redraw polyline
			getPointsCoords().add(current_index * 2, (double) bendpoint.getX_Property().get());
			getPointsCoords().add((current_index * 2) + 1, (double) bendpoint.getY_Property().get());

			// Add listener which will redraw polyline when a bend point is dragged
			bendpoint.X_ChangeListener = new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {
					getPointsCoords().set(current_index * 2, (double) x);
				}
			};
			bendpoint.getX_Property().addListener(bendpoint.X_ChangeListener);

			bendpoint.Y_ChangeListener = new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {
					getPointsCoords().set((current_index * 2) + 1, (double) y);
				}
			};
			bendpoint.getY_Property().addListener(bendpoint.Y_ChangeListener);

		}
	}

	public void setContextMenuFor(BendPoint bendpoint) {

		ContextMenu contextMenu = new ContextMenu();

		MenuItem menuAdd = new MenuItem("Add");
		menuAdd.setOnAction((event) -> {
			this.addAnotherBendPoint(bendpoint);

			List<AnchorPointVirtual> virtuals = bendpoint.getVirtualAnchorPointsAssociated();
			for (AnchorPointVirtual ap : virtuals) {
				Ente other = ap.getTarget().getEntePadre();
				ap.disconnect();
				Magnete.connect(other.getDraggableNode());
			}
		});

		MenuItem menuRemove = new MenuItem("Remove");

		menuRemove.setOnAction((event) -> {
			this.removeBendPoint(bendpoint);

			List<AnchorPointVirtual> virtuals = bendpoint.getVirtualAnchorPointsAssociated();
			for (AnchorPointVirtual ap : virtuals) {
				Ente other = ap.getTarget().getEntePadre();
				ap.disconnect();
				Magnete.connect(other.getDraggableNode());
			}
		});

		MenuItem menuSnapToGrid = new MenuItem("Snap to grid");

		menuSnapToGrid.setOnAction((event) -> {
			bendpoint.snapBendPointToGrid();
			((EnteBendable) this.parent).updateDraggableNodePosition();
		});

		if (bendpoint.isFirstBendPoint() || bendpoint.isLastBendPoint())
			// We do not add the remove menu because we cannot remove the external bend
			// points and then use CTRL-Z without losing position of anchor points.
			contextMenu.getItems().addAll(menuAdd, menuSnapToGrid);
		else
			contextMenu.getItems().addAll(menuAdd, menuRemove, menuSnapToGrid);

		bendpoint.setOnContextMenuRequested((event) -> {
			contextMenu.show(bendpoint, event.getScreenX(), event.getScreenY());
			event.consume();
		});

	}
}
