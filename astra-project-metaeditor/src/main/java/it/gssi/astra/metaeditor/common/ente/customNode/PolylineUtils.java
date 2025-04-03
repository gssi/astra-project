package it.gssi.astra.metaeditor.common.ente.customNode;

import java.util.ArrayList;
import java.util.List;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

/**
 * Class of utils for {@code LineWrapper}
 *
 */
public class PolylineUtils {

	/**
	 * Updates the coordinates of each nodes attached to {@code extremeBendPoint}
	 * 
	 * @param extremeBendPoint
	 * @param neighbor
	 * @see LineWrapper#parse_attachedNodes()
	 */
	public static void updatePosition(BendPoint extremeBendPoint, BendPoint neighbor) {

		for (Node node : extremeBendPoint.attachedNodes.keySet()) {

			double parallel_offset = extremeBendPoint.attachedNodes.get(node)[0];
			double orthogonal_offset = extremeBendPoint.attachedNodes.get(node)[1];
			
			updatePosition(node, parallel_offset, orthogonal_offset, extremeBendPoint, neighbor);
		}

	}

	/**
	 * Updates the coordinates of nodes attached to {@code extremeBendPoint}
	 * 
	 * @param node
	 * @param parallel_offset
	 * @param orthogonal_offset
	 * @param extremeBendPoint
	 * @param neighbor
	 * @see LineWrapper#parse_attachedNodes()
	 */
	public static void updatePosition(Node node, double parallel_offset, double orthogonal_offset, BendPoint extremeBendPoint, BendPoint neighbor) {

		Circle circle = (Circle) node;

		double anchorX;
		double anchorY;

		double extremeBendPointX = extremeBendPoint.getX_Property().get();
		double extremeBendPointY = extremeBendPoint.getY_Property().get();

		double neighborX = neighbor.getX_Property().get();
		double neighborY = neighbor.getY_Property().get();

		double coefficienteAngolare;
		double q;

		coefficienteAngolare = (extremeBendPointY - neighborY) / (extremeBendPointX - neighborX);
		q = -extremeBendPointX * coefficienteAngolare + extremeBendPointY;
		
		/*
		 * use this to maintain proportions after stretching
		 * double total_distance = CanvasUtils.distance(extremeBendPoint.getCenterX(), extremeBendPoint.getCenterY(), neighbor.getCenterX(), neighbor.getCenterY());
		 * double parallel_offset = total_distance*ratio;
		 */
		

		// Orizzontale
		if (extremeBendPointY == neighborY) {

			double angolo;
			
			anchorY = extremeBendPointY;
			anchorX = extremeBendPointX;

			if (parallel_offset != 0) {
				if (neighborX < extremeBendPointX) {
					anchorX = extremeBendPointX + parallel_offset;
					angolo = 0;
				} else {
					anchorX = extremeBendPointX - parallel_offset;
					angolo = 180;
				}
			} else if (orthogonal_offset != 0) {
				if (neighborX < extremeBendPointX) {
					anchorY = extremeBendPointY - orthogonal_offset;
					angolo = 0;
				} else {
					anchorY = extremeBendPointY - orthogonal_offset;
					angolo = 180;
				}
			}

			circle.setCenterX(anchorX);
			circle.setCenterY(anchorY);

			// Apply rotation
//			node.getTransforms().clear();
//			node.getTransforms().add(new Rotate(angolo));

			return;
		}

		// Verticale
		if (extremeBendPointX == neighborX) {

			double angolo;
			
			anchorX = extremeBendPointX;
			anchorY = extremeBendPointY;

			if (parallel_offset != 0) {
				if (neighborY > extremeBendPointY) {
					anchorY = extremeBendPointY - parallel_offset;
					angolo = 90;
				} else {
					anchorY = extremeBendPointY + parallel_offset;
					angolo = 270;
				}
			} else if (orthogonal_offset != 0) {
				if (neighborY > extremeBendPointY) {
					anchorX = extremeBendPointX + orthogonal_offset;
					angolo = 90;
				} else {
					anchorX = extremeBendPointX + orthogonal_offset;
					angolo = 270;
				}
			}

			circle.setCenterX(anchorX);
			circle.setCenterY(anchorY);

			// Apply rotation
//			node.getTransforms().clear();
//			node.getTransforms().add(new Rotate(angolo));

			return;
		}

		// Obliquo
		double angolo;

		if (parallel_offset != 0) {
			double x = 0;
			if (neighborY > extremeBendPointY) {
				if (coefficienteAngolare > 0) {
					angolo = Math.atan(coefficienteAngolare);
					x = (-1) * (parallel_offset * Math.cos(Math.abs(angolo)));
				} else {
					angolo = Math.atan(coefficienteAngolare);
					x = parallel_offset * Math.cos(angolo);
				}
			} else {
				if (coefficienteAngolare > 0) {
					angolo = Math.atan(coefficienteAngolare);
					x = parallel_offset * Math.cos(Math.abs(angolo));
				} else {
					angolo = Math.atan(coefficienteAngolare);
					x = (-1) * (parallel_offset * Math.cos(angolo));
				}
			}
			
			anchorX = extremeBendPointX + x;
			anchorY = coefficienteAngolare * anchorX + q;
			
		} else if (orthogonal_offset != 0) {
			if (coefficienteAngolare == 0) {
				anchorX = extremeBendPointX;
				anchorY = extremeBendPointY + orthogonal_offset;
			} else {
				double anti_reciproco = (-1)*(1/coefficienteAngolare);
				
				double angle = Math.atan(anti_reciproco);
				double cateto = orthogonal_offset * Math.cos(angle);
				
				anchorX = extremeBendPointX + cateto;
				anchorY = anti_reciproco * (anchorX - extremeBendPointX) + extremeBendPointY;
			}
			
			
		} else {
			anchorX = extremeBendPointX;
			anchorY = extremeBendPointY;
		}
		

		// Apply rotation
//		angolo = Math.toDegrees(angolo);
//		node.getTransforms().clear();
//		node.getTransforms().add(new Rotate(angolo));
		
		circle.setCenterX(anchorX);
		circle.setCenterY(anchorY);

	}

	/**
	 * Updates the coordinates of a node that is attached to a bend point which is not
	 * the first or last neither the second or the second last.
	 * 
	 * @param bendPoint
	 */
	public static void updatePosition(BendPoint bendPoint) {

		double zoomFactor = LayoutScene.getInstance().getContainerCanvas().ZOOM_FACTOR;
		double zoomLevel = LayoutScene.getInstance().getContainerCanvas().zoomLevel;

		for (Node node : bendPoint.attachedNodes.keySet()) {
			double nodeCenterX = getNodeCenterX(node);
			double nodeCenterY = getNodeCenterY(node);

			double bendPointCenterX = getNodeCenterX(bendPoint);
			double bendPointCenterY = getNodeCenterY(bendPoint);

			double distanceX = nodeCenterX - bendPointCenterX;
			double distanceY = nodeCenterY - bendPointCenterY;

			node.setLayoutX(node.getLayoutX() - (distanceX / (Math.pow(zoomFactor, zoomLevel))));
			node.setLayoutY(node.getLayoutY() - (distanceY / (Math.pow(zoomFactor, zoomLevel))));
		}

	}

	public static double getNodeCenterX(Node node) {
		Bounds boundsInLocal;
		Bounds boundsInScene;

		boundsInLocal = node.getBoundsInLocal();
		boundsInScene = node.localToScene(boundsInLocal);
		
		return (boundsInScene.getMinX() + boundsInScene.getMaxX()) / 2;
	}

	public static double getNodeCenterY(Node node) {
		Bounds boundsInLocal;
		Bounds boundsInScene;

		boundsInLocal = node.getBoundsInLocal();
		boundsInScene = node.localToScene(boundsInLocal);
		
		return (boundsInScene.getMinY() + boundsInScene.getMaxY()) / 2;
	}
	
	/**
	 * Get all dNode contained into container
	 * 
	 * @param container
	 * @param classes
	 * @return
	 */
	public static List<DraggableNode> getAlldNodeContained(Ente container, List<Class<?>> classes) {

		List<DraggableNode> result = new ArrayList<>();

		LineWrapper containerPolygon = (LineWrapper) container.lookup("CustomPolygon");
		if(containerPolygon ==  null) {
			containerPolygon = (LineWrapper) container.lookup("CustomRectangle");
		}

		for (Node node : LayoutScene.getInstance().getCanvas().getChildren()) {
			if (node != container.getDraggableNode()) {

				DraggableNode dnode = (DraggableNode) node;

				// Check if node is a polyline
				CustomPolyline lineW = (CustomPolyline) dnode.getEnte().lookup("CustomPolyline");

				if (lineW != null) {
					// Current dnode is a polyline
					var inters = javafx.scene.shape.Shape.intersect(containerPolygon.getLineShape(), lineW.getLineShape());

					if (inters.getBoundsInLocal().isEmpty() == false) {

						// Found a intersection between container and current dNode (polyline)

						if (classes.contains(dnode.getEnte().getClass())) {
							// dnode found
							result.add(dnode);
						}
					}
				} else {
					// Current dnode isn't a polyline

					var h = dnode.localToScene(dnode.getBoundsInLocal());
					var t = containerPolygon.getLineShape().sceneToLocal(h);

					if (containerPolygon.getLineShape().contains(t.getCenterX(), t.getCenterY())) {
						// Container contains the current dnode

						if (classes.contains(dnode.getEnte().getClass())) {
							// dnode found
							result.add(dnode);
						}
					}
				}
			}
		}

		return result;
	}
}
