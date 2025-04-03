package it.gssi.astra.metaeditor.common.ente.customNode;

import org.eclipse.emf.common.util.EList;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.util.Callback;

/**
 * <p>
 * This class represents a custom line segment in {@code (x,y)} coordinate space
 * with drag-able ends. It wraps the coordinates of
 * {@link javafx.scene.shape.Line} to make them available as attributes in FXML.
 * </p>
 * 
 * <p>
 * FXML example usage. The following snippet creates a line that goes from (0,
 * 0) to (0, 50).
 * </p>
 *
 * <pre>
 * {@code
 * <?import it.univaq.disim.ermes.metaeditor.common.ente.customNode.CustomLine?>
 * 
 * <fx:root type="Ente" xmlns:fx="http://javafx.com/fxml/1">
 *    <children>
 *       <CustomLine fx:id="customLine" startX="0" startY="0" endX="0" endY=
"50"/>
 *       <AnchorPoint fx:id="leftEnd" centerX="1" centerY="0.0" radius="3" />
 *       <AnchorPoint fx:id="rightEnd" centerX="1" centerY="50.0" radius="3" />
 *       <Pivot fx:id="pivot" centerX="0.0" centerY="0.0" visible="false"/>
 *    </children>
 * </fx:root>
 * }
 * </pre>
 *
 * <p>
 * <strong>NOTE: The id of CustomLine must be equal to {@code customLine} as
 * stated in {@link LineWrapper}</strong>
 * </p>
 */
public class CustomLine extends LineWrapper {

	/**
	 * Creates a new instance of Line. It is called by JavaFX with the attributes
	 * set in the FXML.
	 * 
	 */
	public CustomLine() {

		lineShape = new javafx.scene.shape.Line();
		lineShape.setStrokeWidth(1);
		lineShape.setFill(Color.TRANSPARENT);
		lineShape.setStroke(Color.BLACK);
		lineShape.setStrokeLineCap(StrokeLineCap.BUTT);
		// Set the id of the underlying shape in order to support CSS styling
		lineShape.setId("customLine");
		this.getChildren().add(lineShape);
	}

	// ================================================================================
	// Wrappers of Line coordinates - START
	// ================================================================================

	public final void setStartX(double value) {
		((javafx.scene.shape.Line) lineShape).setStartX(value);
	}

	public final double getStartX() {
		return ((javafx.scene.shape.Line) lineShape).getStartX();
	}

	public final DoubleProperty startXProperty() {
		return ((javafx.scene.shape.Line) lineShape).startXProperty();
	}

	public final void setStartY(double value) {
		((javafx.scene.shape.Line) lineShape).setStartY(value);
	}

	public final double getStartY() {
		return ((javafx.scene.shape.Line) lineShape).getStartY();
	}

	public final DoubleProperty startYProperty() {
		return ((javafx.scene.shape.Line) lineShape).startYProperty();
	}

	public final void setEndX(double value) {
		((javafx.scene.shape.Line) lineShape).setEndX(value);
	}

	public final double getEndX() {
		return ((javafx.scene.shape.Line) lineShape).getEndX();
	}

	public final DoubleProperty endXProperty() {
		return ((javafx.scene.shape.Line) lineShape).endXProperty();
	}

	public final void setEndY(double value) {
		((javafx.scene.shape.Line) lineShape).setEndY(value);
	}

	public final double getEndY() {
		return ((javafx.scene.shape.Line) lineShape).getEndY();
	}

	public final DoubleProperty endYProperty() {
		return ((javafx.scene.shape.Line) lineShape).endYProperty();
	}

	// ================================================================================
	// Wrappers of Line coordinates - END
	// ================================================================================

	/**
	 * Implementation of {@link LineWrapper#getPointsCoords()}. It adds 4 doubles in
	 * the list of points corresponding to the values of
	 * {@link CustomLine#startXProperty()}, {@link CustomLine#startYProperty()},
	 * {@link CustomLine#endXProperty()}, {@link CustomLine#endYProperty()}
	 */
	@Override
	public ObservableList<Double> getPointsCoords() {

		ObservableList<Double> points = FXCollections.observableArrayList();

		points.add(this.getStartX());
		points.add(this.getStartY());
		points.add(this.getEndX());
		points.add(this.getEndY());

		return points;
	}

	/**
	 * Utility method needed to create an observable of {@code CustomLine} which
	 * will trigger listeners when the coordinates of {@code CustomLine} change. The
	 * method {@link CustomLine#getPointsCoords()} cannot be used because it doesn't
	 * fire change notification. The observable list
	 * {@link LineWrapper#punti_polilinea} cannot be used because it fires change
	 * events before the line has effectively moved.
	 * 
	 * @return An observable of {@code CustomLine} which will trigger listeners when
	 *         the coordinates of {@code CustomLine} change.
	 */
	public ObservableList<CustomLine> getObservableProperties() {

		ObservableList<CustomLine> points = FXCollections.observableArrayList(new Callback<CustomLine, Observable[]>() {
			@Override
			public Observable[] call(CustomLine param) {
				return new Observable[] { param.startXProperty(), param.startYProperty(), param.endXProperty(),
						param.endYProperty() };
			}
		});

		points.add(this);

		return points;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addModel(ElementPosition objModel) {

		parse_attachedNodes();

		this.model = objModel;

		if (!model.getBendPoints().isEmpty()) {

			EList<MetaEditor.MetaEditorPersistence.BendPoint> persistedBendpoints = model.getBendPoints();

			this.setStartX(persistedBendpoints.get(0).getX());
			this.setStartY(persistedBendpoints.get(0).getY());
			this.setEndX(persistedBendpoints.get(1).getX());
			this.setEndY(persistedBendpoints.get(1).getY());
		}

		addBendPoints();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBendPoints() {

		BendPoint startBendPoint = new BendPoint(startXProperty(), startYProperty(), this);
		setContextMenuFor(startBendPoint);
		punti_polilinea.add(startBendPoint);

		BendPoint endBendPoint = new BendPoint(endXProperty(), endYProperty(), this);
		setContextMenuFor(endBendPoint);
		punti_polilinea.add(endBendPoint);

		this.getChildren().addAll(punti_polilinea);

		punti_polilinea.get(0).attachedNodes.putAll(first_attachedNodes);
		punti_polilinea.get(punti_polilinea.size() - 1).attachedNodes.putAll(last_attachedNodes);
		punti_polilinea.get(0).updateAttachedNodesPosition();

		fixPosition();

		if (model.getBendPoints().isEmpty()) {

			MetaEditor.MetaEditorPersistence.BendPoint persistedStartBendpoint = MetaEditorPersistenceFactory.eINSTANCE
					.createBendPoint();
			persistedStartBendpoint.setX((int) Math.round(this.getStartX()));
			persistedStartBendpoint.setY((int) Math.round(this.getStartY()));

			model.getBendPoints().add(persistedStartBendpoint);

			startBendPoint.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedStartBendpoint, "x",
					startBendPoint, "centerX", Converters.EINT_DOUBLE));

			startBendPoint.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedStartBendpoint, "y",
					startBendPoint, "centerY", Converters.EINT_DOUBLE));

			MetaEditor.MetaEditorPersistence.BendPoint persistedEndBendpoint = MetaEditorPersistenceFactory.eINSTANCE
					.createBendPoint();
			persistedEndBendpoint.setX((int) Math.round(this.getEndX()));
			persistedEndBendpoint.setY((int) Math.round(this.getEndY()));

			model.getBendPoints().add(persistedEndBendpoint);

			startBendPoint.setX_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedEndBendpoint, "x",
					endBendPoint, "centerX", Converters.EINT_DOUBLE));

			startBendPoint.setY_Binding(JFX2EMF.bindValues(Contexts.BENDPOINT_POSITIONS, persistedEndBendpoint, "y",
					endBendPoint, "centerY", Converters.EINT_DOUBLE));

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

	public void setContextMenuFor(BendPoint bendpoint) {

	}
}
