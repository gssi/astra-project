package it.gssi.astra.metaeditor.common.magnete;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.CanvasUtils;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;
import it.gssi.astra.metaeditor.common.ente.customNode.LineWrapper;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

/**
 * The {@code MagneteUtils} class contains helper methods for connections establishing.
 *
 */
public class MagneteUtils {

	/**
	 * Find all candidate anchor points of the source that are available on the canvas.
	 * 
	 * @param source The {@link Ente} that we are trying to connect
	 * @param targetModels An array of classes which represent a target for the source.
	 * @param target_types The list of compatible targets of the {@link AnchorPoint}
	 * @return A list of anchor points
	 */
	public static List<AnchorPoint> getAnchorPointTargets(Ente source, Class<?>[] targetModels,
			List<String> target_types) {

		Set<EObject> models = LayoutScene.getViewModelMap().keySet();

		List<AnchorPoint> targets = new ArrayList<AnchorPoint>();

		for (EObject model : models) {

			for (Class<?> targetClass : targetModels) {
				if (targetClass.isInstance(model)) {

					Ente other_node = LayoutScene.getViewModelMap().get(model);

					List<AnchorPoint> other_anchorPoints = other_node.getAnchorPoints();

					for (AnchorPoint anchorPoint : other_anchorPoints) {
						if (target_types.contains(anchorPoint.getType())) {
							targets.add(anchorPoint);
						} else {
							if (anchorPoint.isVirtual())
								((AnchorPointVirtual) anchorPoint).destroyVirtual();
						}
					}
					break;
				}
			}
		}

		return targets;
	}

	/**
	 * <p>
	 * Used to connect a node along a segment of a bendable element, only if the graphical element of the bendable
	 * element provides a full anchor point.
	 * </p>
	 * <p>
	 * It works by projecting the source anchor point on the segment and creating the new virtual anchor point at
	 * the same position of the intersection on segment.
	 * </p>
	 * <P>
	 * It creates a {@link AnchorPointVirtual} on the nearest segment which will be added to the list of candidates targets of the source.
	 * </p>
	 * 
	 * @param sourceAnchor The anchor point that we are trying to connect
	 * @param targetModel An array of classes which represent a target for the source.
	 * @param targetType The type of the newly created anchor point
	 * @return A virtual anchor point
	 * 
	 * @see Segment
	 */
	public static AnchorPoint getFullAnchorPointTarget(AnchorPoint sourceAnchor, Class<?> targetModel,
			String targetType) {

		double distance = Double.MAX_VALUE;

		Segment nearest_segment = null;

		Set<EObject> models = LayoutScene.getViewModelMap().keySet();

		// Cycle all models
		for (EObject model : models) {

			// Filter only models that offer this full anchor point
			if (targetModel.isInstance(model)) {

				// Get corresponding javaFX node
				Ente other_node = LayoutScene.getViewModelMap().get(model);

				List<LineWrapper> lines = new ArrayList<LineWrapper>();
				other_node.lookupAll("CustomLine").forEach((n) -> {
					lines.add((LineWrapper) n);
				});
				other_node.lookupAll("CustomPolyline").forEach((n) -> {
					lines.add((LineWrapper) n);
				});

				if (!lines.isEmpty()) {
					for (LineWrapper line : lines) {

						BendPoint[] allBendPoints = line.getPuntiPolilinea().toArray(new BendPoint[0]);

						// Cycle on all the segments that build the polyline
						for (int c = 0; c <= (allBendPoints.length - 2); c++) {

							double[] firstBendPoint_pos = allBendPoints[c].getCoordinatesRelativeToCanvas();
							double firstBendPointX = firstBendPoint_pos[0];
							double firstBendPointY = firstBendPoint_pos[1];

							double[] secondBendPoint_pos = allBendPoints[c + 1].getCoordinatesRelativeToCanvas();
							double secondBendPointX = secondBendPoint_pos[0];
							double secondBendPointY = secondBendPoint_pos[1];

							double[] sourceAnchor_pos = sourceAnchor.getCoordinatesRelativeToCanvas();
							double sourceAnchorX = sourceAnchor_pos[0];
							double sourceAnchorY = sourceAnchor_pos[1];

							// Check if my anchor point is in range of current considered segment
							if (CanvasUtils.isProjectedPointOnSegment(firstBendPointX, firstBendPointY,
									secondBendPointX, secondBendPointY, sourceAnchorX, sourceAnchorY)) {

								// Check if distance is less than the distance from previous considered segment
								if (secondBendPointX != firstBendPointX) {
									double coefficienteAngolare = (secondBendPointY - firstBendPointY)
											/ (secondBendPointX - firstBendPointX);
									double q = -secondBendPointX * coefficienteAngolare + secondBendPointY;

									double new_distance = CanvasUtils.distanzaPuntoRetta(coefficienteAngolare, q,
											sourceAnchorX, sourceAnchorY);

									if (new_distance < distance) {
										distance = new_distance;
										nearest_segment = new Segment(other_node);
										nearest_segment.setFirstBendPoint(allBendPoints[c]);
										nearest_segment.setSecondBendPoint(allBendPoints[c + 1]);
									}
								} else { // Vertical segment

									double x = firstBendPointX;

									double new_distance = Math.abs(sourceAnchorX - x);

									if (new_distance < distance) {
										distance = new_distance;
										nearest_segment = new Segment(other_node, x);
										nearest_segment.setFirstBendPoint(allBendPoints[c]);
										nearest_segment.setSecondBendPoint(allBendPoints[c + 1]);
									}
								}
							}
						}
					}
				}
			}
		}

		// Create a virtual anchor point on the projection of my anchor point over the
		// segment and returns it to Magnet function
		if (nearest_segment != null) {
			Ente padre = nearest_segment.getPadre();

			AnchorPointVirtual virtualAnchorPoint = new AnchorPointVirtual();

			virtualAnchorPoint.setEntePadre(padre);
			virtualAnchorPoint.setVirtual();

			virtualAnchorPoint.setFirst(nearest_segment.getFirstBendPoint());
			virtualAnchorPoint.setSecond(nearest_segment.getSecondBendPoint());

			virtualAnchorPoint.setType(targetType);

			Point2D projected = CanvasUtils.getProjectedPointOnSegment(nearest_segment,
					sourceAnchor.getCoordinatesRelativeToCanvas()[0], sourceAnchor.getCoordinatesRelativeToCanvas()[1]);

			virtualAnchorPoint.setCenterX(projected.getX());
			virtualAnchorPoint.setCenterY(projected.getY());

			LayoutScene.getInstance().getCanvas().getChildren().add(virtualAnchorPoint);

			Bounds boundsInLocal = virtualAnchorPoint.getBoundsInLocal();
			Bounds boundsInScene = virtualAnchorPoint.localToScene(boundsInLocal);

			Bounds sc = padre.sceneToLocal(boundsInScene);

			virtualAnchorPoint.setCenterX(sc.getCenterX());
			virtualAnchorPoint.setCenterY(sc.getCenterY());

			padre.getChildren().add(virtualAnchorPoint);

			return virtualAnchorPoint;
		}

		return null;
	}

	/**
	 * Auxiliary method
	 * 
	 * @param sourceAnchor
	 * @param target
	 * @param distance
	 * @return
	 */
	public static AnchorPoint getFullAnchorPointTarget(AnchorPoint sourceAnchor, Ente target, double distance) {

		Segment nearest_segment = null;

		// Get corresponding javaFX node
		Ente other_node = target;

		List<LineWrapper> lines = new ArrayList<LineWrapper>();
		other_node.lookupAll("CustomLine").forEach((n) -> {
			lines.add((LineWrapper) n);
		});
		other_node.lookupAll("CustomPolyline").forEach((n) -> {
			lines.add((LineWrapper) n);
		});

		if (!lines.isEmpty()) {
			for (LineWrapper line : lines) {

				BendPoint[] allBendPoints = line.getPuntiPolilinea().toArray(new BendPoint[0]);

				// Cycle on all the segments that build the polyline
				for (int c = 0; c <= (allBendPoints.length - 2); c++) {

					double[] firstBendPoint_pos = allBendPoints[c].getCoordinatesRelativeToCanvas();
					double firstBendPointX = firstBendPoint_pos[0];
					double firstBendPointY = firstBendPoint_pos[1];

					double[] secondBendPoint_pos = allBendPoints[c + 1].getCoordinatesRelativeToCanvas();
					double secondBendPointX = secondBendPoint_pos[0];
					double secondBendPointY = secondBendPoint_pos[1];

					double[] sourceAnchor_pos = sourceAnchor.getCoordinatesRelativeToCanvas();
					double sourceAnchorX = sourceAnchor_pos[0];
					double sourceAnchorY = sourceAnchor_pos[1];

					// Check if my anchor point is in range of current considered segment
					if (CanvasUtils.isProjectedPointOnSegment(firstBendPointX, firstBendPointY, secondBendPointX,
							secondBendPointY, sourceAnchorX, sourceAnchorY)) {

						// Check if distance is less than the distance from previous considered segment
						if (secondBendPointX != firstBendPointX) {
							double coefficienteAngolare = (secondBendPointY - firstBendPointY)
									/ (secondBendPointX - firstBendPointX);
							double q = -secondBendPointX * coefficienteAngolare + secondBendPointY;

							double new_distance = CanvasUtils.distanzaPuntoRetta(coefficienteAngolare, q, sourceAnchorX,
									sourceAnchorY);

							if (new_distance < distance) {
								distance = new_distance;
								nearest_segment = new Segment(other_node);
								nearest_segment.setFirstBendPoint(allBendPoints[c]);
								nearest_segment.setSecondBendPoint(allBendPoints[c + 1]);
							}
						} else { // Vertical segment

							double x = firstBendPointX;

							double new_distance = Math.abs(sourceAnchorX - x);

							if (new_distance < distance) {
								distance = new_distance;
								nearest_segment = new Segment(other_node, x);
								nearest_segment.setFirstBendPoint(allBendPoints[c]);
								nearest_segment.setSecondBendPoint(allBendPoints[c + 1]);
							}
						}
					}
				}
			}
		}

		// Create a virtual anchor point on the projection of my anchor point over the
		// segment and returns it to Magnet function
		if (nearest_segment != null) {
			Ente padre = nearest_segment.getPadre();

			AnchorPointVirtual virtualAnchorPoint = new AnchorPointVirtual();

			virtualAnchorPoint.setEntePadre(padre);
			virtualAnchorPoint.setVirtual();

			virtualAnchorPoint.setFirst(nearest_segment.getFirstBendPoint());
			virtualAnchorPoint.setSecond(nearest_segment.getSecondBendPoint());

//			virtualAnchorPoint.setType(targetType);

			Point2D projected = CanvasUtils.getProjectedPointOnSegment(nearest_segment,
					sourceAnchor.getCoordinatesRelativeToCanvas()[0], sourceAnchor.getCoordinatesRelativeToCanvas()[1]);

			virtualAnchorPoint.setCenterX(projected.getX());
			virtualAnchorPoint.setCenterY(projected.getY());

			LayoutScene.getInstance().getCanvas().getChildren().add(virtualAnchorPoint);

			Bounds boundsInLocal = virtualAnchorPoint.getBoundsInLocal();
			Bounds boundsInScene = virtualAnchorPoint.localToScene(boundsInLocal);

			Bounds sc = padre.sceneToLocal(boundsInScene);

			virtualAnchorPoint.setCenterX(sc.getCenterX());
			virtualAnchorPoint.setCenterY(sc.getCenterY());

			padre.getChildren().add(virtualAnchorPoint);

			return virtualAnchorPoint;
		}

		return null;
	}

	/**
	 * Rounds a number to the closest double given the number of required decimal
	 * places.
	 *
	 * @param number   Number to be rounded
	 * @param decimals Decimal places
	 * @return Rounded number
	 */
	public static double round(double number, int decimals) {
		double out = number * Math.pow(10, decimals);
		out = Math.round(out) / Math.pow(10, decimals);

		return out;
	}

	/**
	 * Rounds a number to the nearest double given the number of required decimal
	 * places.
	 *
	 * @param array    Array to be rounded
	 * @param decimals Decimal places
	 * @return Rounded number
	 */
	public static double[] round(double[] array, int decimals) {
		double[] out = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			out[i] = round(array[i], decimals);
		}

		return out;
	}

	/**
	 * Abs an array of double.
	 *
	 * @param array Array to be unsigned
	 * @return Absolute number
	 */
	public static double[] abs(double[] array) {
		double[] out = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			out[i] = Math.abs(array[i]);
		}

		return out;
	}
}
