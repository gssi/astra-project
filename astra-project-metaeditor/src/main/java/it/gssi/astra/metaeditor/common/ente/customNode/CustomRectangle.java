package it.gssi.astra.metaeditor.common.ente.customNode;

import org.eclipse.emf.common.util.EList;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.ente.EnteBendable;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 * <p>
 * The {@code Rectangle} class defines a rectangle with the specified width and
 * height. It wraps the coordinates of {@link javafx.scene.shape.Rectangle} to
 * make them available as attributes in FXML. That is made by
 * {@link CustomPolygon#points}.
 * </p>
 * 
 * <p>
 * FXML example usage. The following snippet creates a rectangle of dimensions
 * 75x168.
 * </p>
 *
 * <pre>
 * {@code
 * <?import it.univaq.disim.ermes.metaeditor.common.ente.customNode.CustomRectangle?>
 * 
 * <fx:root type="Ente" xmlns:fx="http://javafx.com/fxml/1">
 * <children>
 *    <CustomRectangle fx:id="customLine" height="168.0" width="75.0" stroke=
"TRANSPARENT" />
 *    <Pivot fx:id="pivot" centerX="0.0" centerY="0.0" visible="false"/>
 * </children>
 * </fx:root>
 * }
 * </pre>
 * 
 * <p>
 * <strong>NOTE: The id of CustomRectangle must be equal to {@code customLine}
 * as stated in {@link LineWrapper}</strong>
 * </p>
 *
 */
public class CustomRectangle extends LineWrapper {

	public CustomRectangle() {

		lineShape = new javafx.scene.shape.Rectangle();
		lineShape.setStrokeWidth(1);
		lineShape.setFill(Color.TRANSPARENT);
		lineShape.setStroke(Color.BLACK);
		lineShape.setStrokeLineCap(StrokeLineCap.BUTT);
		// Set the id of the underlying shape in order to support CSS styling
		lineShape.setId("customLine");
		this.getChildren().add(lineShape);

	}

	// ================================================================================
	// Wrappers of Rectangle styling methods - START
	// ================================================================================

	public final void setWidth(double value) {
		((javafx.scene.shape.Rectangle) lineShape).setWidth(value);
	}

	public final double getWidth() {
		return ((javafx.scene.shape.Rectangle) lineShape).getWidth();
	}

	public final DoubleProperty widthProperty() {
		return ((javafx.scene.shape.Rectangle) lineShape).widthProperty();
	}

	public final void setHeight(double value) {
		((javafx.scene.shape.Rectangle) lineShape).setHeight(value);
	}

	public final double getHeight() {
		return ((javafx.scene.shape.Rectangle) lineShape).getHeight();
	}

	public final DoubleProperty heightProperty() {
		return ((javafx.scene.shape.Rectangle) lineShape).heightProperty();
	}

	// ================================================================================
	// Wrappers of Rectangle styling methods - STOP
	// ================================================================================

	/**
	 * Implementation of {@link LineWrapper#getPointsCoords()}. It is never used and
	 * the implementation doesn't make sense, so it could be removed.
	 * 
	 */
	@Override
	public ObservableList<Double> getPointsCoords() {
		ObservableList<Double> points = FXCollections.observableArrayList();

		points.add(this.getWidth());
		points.add(this.getHeight());

		return points;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addModel(ElementPosition objModel) {

		this.model = objModel;

		if (!model.getBendPoints().isEmpty()) {

			EList<MetaEditor.MetaEditorPersistence.BendPoint> persistedBendpoints = model.getBendPoints();

			this.setWidth(persistedBendpoints.get(0).getX());
			this.setHeight(persistedBendpoints.get(0).getY());

		}
		addBendPoints();

		punti_polilinea.addListener(new ListChangeListener<BendPoint>() {

			@Override
			public void onChanged(Change<? extends BendPoint> c) {
				while (c.next()) {
					if (c.wasUpdated()) {
						BendPoint b = punti_polilinea.get(c.getFrom());
						if (b.getCenterX() < 10) {
							b.setCenterX(10);
						}
						if (b.getCenterY() < 10) {
							b.setCenterY(10);
						}

					}

				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBendPoints() {

		BendPoint handle = new BendPoint(widthProperty(), heightProperty(), this);
		setContextMenuFor(handle);
		punti_polilinea.add(handle);

		this.getChildren().addAll(punti_polilinea);

		fixPosition();

		if (model.getBendPoints().isEmpty()) {

			MetaEditor.MetaEditorPersistence.BendPoint persistedBendpoint = MetaEditorPersistenceFactory.eINSTANCE
					.createBendPoint();
			persistedBendpoint.setX((int) Math.round(handle.getX_Property().get()));
			persistedBendpoint.setY((int) Math.round(handle.getY_Property().get()));

			model.getBendPoints().add(persistedBendpoint);

			handle.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedBendpoint, "x", handle,
					"centerX", Converters.EINT_DOUBLE));

			handle.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedBendpoint, "y", handle,
					"centerY", Converters.EINT_DOUBLE));

		} else {

			MetaEditor.MetaEditorPersistence.BendPoint persistedBendpoint = model.getBendPoints().get(0);

			handle.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedBendpoint, "x", handle,
					"centerX", Converters.EINT_DOUBLE));

			handle.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedBendpoint, "y", handle,
					"centerY", Converters.EINT_DOUBLE));
		}

	}

	public void setContextMenuFor(BendPoint bendpoint) {

		ContextMenu contextMenu = new ContextMenu();

		MenuItem menuSnapToGrid = new MenuItem("Snap to grid");

		menuSnapToGrid.setOnAction((event) -> {
			bendpoint.snapBendPointToGrid();
			((EnteBendable) this.parent).updateDraggableNodePosition();
		});

		contextMenu.getItems().addAll(menuSnapToGrid);

		bendpoint.setOnContextMenuRequested((event) -> {
			contextMenu.show(bendpoint, event.getScreenX(), event.getScreenY());
			event.consume();
		});

	}
}
