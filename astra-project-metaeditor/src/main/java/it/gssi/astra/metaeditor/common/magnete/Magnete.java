package it.gssi.astra.metaeditor.common.magnete;

import java.util.List;
import java.util.Map;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;

import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.EnteBendable;
import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;
import it.gssi.astra.metaeditor.common.ente.customNode.LineWrapper;
import javafx.geometry.Bounds;
import javafx.scene.Node;

/**
 * <p>
 * The {@code Magnet} class contains the methods that allow to visually connect
 * two or more {@link DraggableNode} on the canvas through their anchor points.
 * </p>
 * 
 * <p>
 * In order to use the magnet you need to drag a {@code DraggableNode} near
 * another drag-able node and, if they are semantically connect-able, you will
 * see the dragged node, which will be called {@code source} move towards the
 * second node, which will be called {@code target} and position itself such
 * that the two anchor points have the same coordinates on the canvas. </>
 * 
 * <p>
 * It works by checking the distance between the two anchor points when the drag
 * of the first is over and if the distance is less than
 * {@value LayoutScene.RAGGIO_MAGNETE} then the connection will happen.
 * </p>
 * 
 * <p>
 * There exist a specific magnet for {@link BendPoint} that allows to stretch a
 * bendable element so that one of its ends will connect to a {@code target}
 * anchor point but the core algorithm of connection feasibility is the same of
 * main connection method and is implemented by
 * {@link Magnete#find_nearest_connector(AnchorPoint, List, double)} and
 * {@link Magnete#find_nearest_between(SimpleEntry, SimpleEntry)}.
 * </p>
 *
 * @see AnchorPoint
 */
public class Magnete {

	/**
	 * It is the default value for magnet radius. Meaning the connection between
	 * anchor points will succeed only if the distance between them is lower than
	 * {@value RAGGIO_MAGNETE}.
	 */
	public static final double MAGNET_RADIUS = 50;

	/**
	 * Main connection method which tries to connect a {@code DraggableNode} using
	 * any of its anchor points
	 * 
	 * @param node The DraggableNode that contains the Ente to connect
	 */
	public static void connect(DraggableNode node) {

		if (node.getEnte().elementPosition.isMagnetizable()) {

			if (!(nodeIsConnected(node))) {

				AnchorPoint source_connector = null;
				SimpleEntry<?, ?> target_connector = null;

				// Map each anchor point to a list of compatible target found on Canvas
				Map<AnchorPoint, List<AnchorPoint>> associations = node.getEnte().getTargetAnchorPointsSet();

				// Filter each association by discarding those which have a distance greater
				// than MAGNET_RADIUS
				Map<AnchorPoint, List<AnchorPoint>> filteredAssociations = filter_by_radius(associations,
						MAGNET_RADIUS);

				Map<AnchorPoint, SimpleEntry<?, ?>> connectionsSpace = new HashMap<>();

				// Search the nearest target of each anchor point of this node
				for (AnchorPoint sourceAnchor : filteredAssociations.keySet()) {

					List<AnchorPoint> targets = filteredAssociations.get(sourceAnchor);

					if (!targets.isEmpty()) {
						SimpleEntry<?, ?> nearest_target = find_nearest_connector(sourceAnchor, targets);
						connectionsSpace.put(sourceAnchor, nearest_target);
					}

				}

				// Search shortest connection between all the nearest targets
				for (AnchorPoint anchor : connectionsSpace.keySet()) {
					SimpleEntry<?, ?> candidate = connectionsSpace.get(anchor);

					target_connector = find_nearest_between(candidate, target_connector);
	
					if (target_connector == candidate)
						source_connector = anchor;
				}

				// Enable connection between the two anchor points and update the position of
				// this node
				if (target_connector != null) {
					double[] distance = (double[]) target_connector.getValue();

					if (connectAnchorPoints(source_connector, (AnchorPoint) target_connector.getKey())) {

						updatePositionOnCanvas(node, distance);

						if (target_connector.getKey() instanceof AnchorPointVirtual) {
							AnchorPointVirtual virtual = (AnchorPointVirtual) target_connector.getKey();

							virtual.attach();
						}

						// Remove the anchor just connected
						filteredAssociations.remove(source_connector);

						// Check other anchor points overlapping recalculating the distances after
						// after the previous call to updatePositionOnCanvas()
						for (AnchorPoint sourceAnchor : filteredAssociations.keySet()) {

							List<AnchorPoint> targets = filteredAssociations.get(sourceAnchor);

							if (!targets.isEmpty()) {
								SimpleEntry<?, ?> nearest_target = find_nearest_connector(sourceAnchor, targets);
								AnchorPoint candidate = (AnchorPoint) nearest_target.getKey();
								double[] candidateDistance = (double[]) nearest_target.getValue();

								// The disance should be less than one also considering approximations
								// and inaccurate positions of anchor points
								if ((Math.abs(candidateDistance[0]) < 1) && (Math.abs(candidateDistance[1]) < 1)) {
									connectAnchorPoints(sourceAnchor, candidate);
								}
							}

						}
					}
				}

				removeUnusedVirtualAnchorpoints(associations);
			}

			if (node.getEnte() instanceof EnteBendable) {
				EnteBendable ente = (EnteBendable) node.getEnte();
				stretchPolyline(ente.getCustomLine());
			}
		}
	}

	/**
	 * Connection method that tries to connect the {@code DraggableNode} using a
	 * specific anchor point.
	 * 
	 * @param node         The DraggableNode that contains the Ente to connect
	 * @param sourceAnchor The specific AnchorPoint to use as source of the
	 *                     connection
	 */
	public static void connect(DraggableNode node, AnchorPoint sourceAnchor) {

		if (node.getEnte().elementPosition.isMagnetizable()) {

			AnchorPoint source_connector = null;
			SimpleEntry<?, ?> target_connector = null;

			// Search for nearest anchorpoint
			Map<AnchorPoint, List<AnchorPoint>> associations = node.getEnte().getTargetAnchorPointsSet();

			// Filter each association by discarding those which have a distance greater
			// than MAGNET_RADIUS
			Map<AnchorPoint, List<AnchorPoint>> filteredAssociations = filter_by_radius(associations, MAGNET_RADIUS);

			List<AnchorPoint> targets = filteredAssociations.get(sourceAnchor);
			SimpleEntry<?, ?> temp = find_nearest_connector(sourceAnchor, targets);
			target_connector = find_nearest_between(temp, target_connector);

			if (target_connector == temp)
				source_connector = sourceAnchor;

			if (target_connector != null) {
				double[] distance = (double[]) target_connector.getValue();

				if (connectAnchorPoints(source_connector, (AnchorPoint) target_connector.getKey())) {

					updatePositionOnCanvas(node, distance);

					if (target_connector.getKey() instanceof AnchorPointVirtual) {
						AnchorPointVirtual virtual = (AnchorPointVirtual) target_connector.getKey();

						virtual.attach();
					}

				}
			}

			removeUnusedVirtualAnchorpoints(associations);
		}
	}

	/**
	 * Connection method that tries to connect the {@code DraggableNode} using a
	 * specific anchor point and a specific target anchor point.
	 * 
	 * @param node         The DraggableNode that contains the Ente to connect
	 * @param sourceAnchor The specific AnchorPoint to use as source of the
	 *                     connection
	 * @param target       The specific AnchorPoint to use as target of the
	 *                     connection
	 */
	public static void connect(DraggableNode node, AnchorPoint sourceAnchor, AnchorPoint target) {

		if (node.getEnte().elementPosition.isMagnetizable()) {

			double[] sourceAnchor_pos = sourceAnchor.getCoordinatesRelativeToCanvas();

			double[] target_pos = target.getCoordinatesRelativeToCanvas();

			double distanceX = sourceAnchor_pos[0] - target_pos[0];
			double distanceY = sourceAnchor_pos[1] - target_pos[1];

			connectAnchorPoints(sourceAnchor, target);

			updatePositionOnCanvas(node, new double[] { distanceX, distanceY });

		}
	}

	/**
	 * Tries to connect both the ends of {@code LineWrapper} instance which should
	 * be a bendable element with anchor points.
	 * 
	 * @param polyline The selected line
	 */
	public static void stretchPolyline(LineWrapper polyline) {

		EnteBendable ente = (EnteBendable) polyline.parent;

		if (ente.elementPosition.isMagnetizable()) {

			// Search for nearest anchorpoint
			Map<AnchorPoint, List<AnchorPoint>> associations = ente.getTargetAnchorPointsSet();

			// Filter each association by discarding those which have a distance greater
			// than MAGNET_RADIUS
			Map<AnchorPoint, List<AnchorPoint>> filteredAssociations = filter_by_radius(associations, MAGNET_RADIUS);

			for (AnchorPoint sourceAnchor : filteredAssociations.keySet()) {

				if (!sourceAnchor.isConnectedAtLeastOnce()) {

					List<AnchorPoint> targets = filteredAssociations.get(sourceAnchor);

					// Filter out targets of the same polyline if it has only 2 bend point
					targets.removeIf(ap -> {
						if (ap.getParent().equals(sourceAnchor.getParent()))
							return polyline.getPuntiPolilinea().size() <= 2;
						else
							return false;
					});

					SimpleEntry<?, ?> nearest_target = find_nearest_connector(sourceAnchor, targets);

					if (nearest_target != null) {

						if (connectAnchorPoints(sourceAnchor, (AnchorPoint) nearest_target.getKey())) {
							updateBendpointPosition(polyline, sourceAnchor, nearest_target);
							ente.updateDraggableNodePosition();
						}
					}
				}
			}

			removeUnusedVirtualAnchorpoints(associations);
		}
	}

	/**
	 * Tries to connect one of the ends of {@code LineWrapper} instance which should
	 * a bendable element with anchor points.
	 * 
	 * @param polyline The {@code LineWrapper} that you want to stretch.
	 * @param head     The specific AnchorPoint to use as source of the connection
	 */
	public static void stretchPolyline(LineWrapper polyline, AnchorPoint head) {

		EnteBendable ente = (EnteBendable) polyline.parent;

		if (ente.elementPosition.isMagnetizable()) {

			AnchorPoint source_connector = null;
			SimpleEntry<?, ?> target_connector = null;

			// Search for nearest anchorpoint
			Map<AnchorPoint, List<AnchorPoint>> associations = ente.getTargetAnchorPointsSet();

			// Filter each association by discarding those which have a distance greater
			// than MAGNET_RADIUS
			Map<AnchorPoint, List<AnchorPoint>> filteredAssociations = filter_by_radius(associations, MAGNET_RADIUS);

			AnchorPoint sourceAnchor = head;

			List<AnchorPoint> targets = filteredAssociations.get(sourceAnchor);

			// Filter out targets of the same polyline if it has only 2 bend point
			targets.removeIf(ap -> {
				if (ap.getParent().equals(sourceAnchor.getParent()))
					return polyline.getPuntiPolilinea().size() <= 2;
				else
					return false;
			});

			SimpleEntry<?, ?> temp = find_nearest_connector(sourceAnchor, targets);
			target_connector = find_nearest_between(temp, target_connector);

			if (target_connector == temp)
				source_connector = sourceAnchor;

			if (target_connector != null) {

				if (connectAnchorPoints(source_connector, (AnchorPoint) target_connector.getKey())) {
					updateBendpointPosition(polyline, source_connector, target_connector);
					ente.updateDraggableNodePosition();
				}
			}

			removeUnusedVirtualAnchorpoints(associations);
		}
	}

	/**
	 * Removes all virtual anchor points created by {@code Magnet} but discarded
	 * because they were too far.
	 * 
	 * @param associations The map of all possible connections
	 */
	private static void removeUnusedVirtualAnchorpoints(Map<AnchorPoint, List<AnchorPoint>> associations) {
		for (AnchorPoint anchor : associations.keySet()) {
			List<AnchorPoint> targetlist = associations.get(anchor);
			for (AnchorPoint targetAnchor : targetlist) {
				if (targetAnchor.isVirtual()) {
					if (!targetAnchor.isConnectedAtLeastOnce())
						((AnchorPointVirtual) targetAnchor).destroyVirtual();
				}
			}
		}
	}

	/**
	 * Updates coordinates of bend points of {@code LineWrapper} to apply the result
	 * of {@link Magnete#stretchPolyline(LineWrapper)}.
	 * 
	 * @param polyline
	 * @param source_connector
	 * @param target_connector
	 */
	private static void updateBendpointPosition(LineWrapper polyline, AnchorPoint source_connector,
			SimpleEntry<?, ?> target_connector) {

		if (target_connector.getKey() instanceof AnchorPointVirtual) {
			AnchorPointVirtual virtual = (AnchorPointVirtual) target_connector.getKey();

			virtual.attach();
		}

		BendPoint host = polyline.getBendPointAssociated(source_connector);

		double parallel_offset = host.attachedNodes.get(source_connector)[0];
		double orthogonal_offset = host.attachedNodes.get(source_connector)[1];

		// The following 2 lines don't work because when the offset is different from 0
		// the distance between the source connector and the target connector is
		// different from the distance between the bendpoint associated to the source
		// connector and the new position that it should assume after being magnetized,
		// for trigonometry problem.
//			associated.setCenterX(associated.getCenterX() - distance[0]);
//			associated.setCenterY(associated.getCenterY() - distance[1]);

		// So we find the rect passing for the target connector and the neighbor of the
		// associated bendpoint, which instead will remain fixed.
		BendPoint neighbor = host.getExtremeNeighbor();

		if (host != null) {

			double newAssociatedX;
			double newAssociatedY;

			Bounds boundsInLocal;
			Bounds boundsInScene;

			AnchorPoint target = (AnchorPoint) target_connector.getKey();
			boundsInLocal = target.getBoundsInLocal();
			boundsInScene = target.localToScene(boundsInLocal);

			Bounds sc = polyline.parent.sceneToLocal(boundsInScene);

			double targetX = sc.getCenterX();
			double targetY = sc.getCenterY();

			AnchorPoint neighborAP = neighbor.getExtremeAnchorPointAssociated();

			double neighborX;
			double neighborY;

			if (neighborAP != null) {
				neighborX = neighborAP.getCenterX();
				neighborY = neighborAP.getCenterY();
			} else {
				neighborX = neighbor.getCenterX();
				neighborY = neighbor.getCenterY();
			}

			double coefficienteAngolare;
			double q;

			coefficienteAngolare = (targetY - neighborY) / (targetX - neighborX);
			q = -targetX * coefficienteAngolare + targetY;

			// Orizzontale
			if (targetY == neighborY) {

				newAssociatedX = targetX;
				newAssociatedY = targetY;

				if (parallel_offset != 0) {
					if (neighborX < targetX)
						newAssociatedX = targetX - parallel_offset;
					else
						newAssociatedX = targetX + parallel_offset;
				} else if (orthogonal_offset != 0) {
					newAssociatedY = targetY + orthogonal_offset;
				}

				host.setCenterX((int) Math.round(newAssociatedX));
				host.setCenterY((int) Math.round(newAssociatedY));

				return;
			}

			// Verticale
			if (targetX == neighborX) {

				newAssociatedX = targetX;
				newAssociatedY = targetY;

				if (parallel_offset != 0) {
					if (neighborY > targetY)
						newAssociatedY = targetY + parallel_offset;
					else
						newAssociatedY = targetY - parallel_offset;
				} else if (orthogonal_offset != 0) {
					newAssociatedX = targetX - orthogonal_offset;
				}

				host.setCenterX((int) Math.round(newAssociatedX));
				host.setCenterY((int) Math.round(newAssociatedY));

				return;
			}

			// Obliquo
			double angolo;

			if (parallel_offset != 0) {
				double x = 0;

				if (neighborY > targetY) {
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

				newAssociatedX = targetX - x;
				newAssociatedY = coefficienteAngolare * newAssociatedX + q;
			} else if (orthogonal_offset != 0) {

				double anti_reciproco = (-1) * (1 / coefficienteAngolare);

				double angle = Math.atan(anti_reciproco);
				double cateto = orthogonal_offset * Math.cos(angle);

				newAssociatedX = targetX - cateto;
				newAssociatedY = anti_reciproco * (newAssociatedX - targetX) + targetY;

			} else {
				newAssociatedX = targetX;
				newAssociatedY = targetY;
			}

			host.setCenterX((int) Math.round(newAssociatedX));
			host.setCenterY((int) Math.round(newAssociatedY));
		}
	}

	/**
	 * Sets the value of {@link AnchorPoint#targetProperty()} of the two anchor
	 * points being connected.
	 * 
	 * @param source_anchor
	 * @param target_anchor
	 * @return true if the connection was successful, false otherwise.
	 */
	private static boolean connectAnchorPoints(AnchorPoint source_anchor, AnchorPoint target_anchor) {
		// If the first setting fails, we don't do the second.
		if (source_anchor.setTarget(target_anchor) && target_anchor.setTarget(source_anchor)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Update the coordinates of {@code DraggableNode} by subtracting the distance
	 * calculated by the magnet in order to move the source anchor point in the
	 * correct position.
	 * 
	 * @param node     The {@code DraggableNode} to move
	 * @param distance An array of two double with format (x, y)
	 */
	private static void updatePositionOnCanvas(DraggableNode node, double[] distance) {
		node.setLayoutX((int) Math.round(node.getLayoutX() - distance[0]));
		node.setLayoutY((int) Math.round(node.getLayoutY() - distance[1]));
	}

	/**
	 * For each target {@code AnchorPoint} filter out those which are outside the
	 * magnet radius
	 * 
	 * @param associations   The original map between each anchor point to their
	 *                       list of compatible target found on Canvas
	 * @param raggio_magnete
	 * @return A map between each anchor point to their list of target in the radius
	 *         MAGNET_RADIUS
	 */
	public static Map<AnchorPoint, List<AnchorPoint>> filter_by_radius(Map<AnchorPoint, List<AnchorPoint>> associations,
			double raggio_magnete) {

		Map<AnchorPoint, List<AnchorPoint>> result = new HashMap<>();

		for (AnchorPoint sourceAnchor : associations.keySet()) {

			double[] my_connector_pos = sourceAnchor.getCoordinatesRelativeToCanvas();

			List<AnchorPoint> original_list_of_targets = associations.get(sourceAnchor);

			List<AnchorPoint> filtered_list_of_targets = new ArrayList<>();

			for (AnchorPoint entry : original_list_of_targets) {

				if (entry != sourceAnchor) {
					if (entry.hasFreeConnections()) {

						double[] other_connector_pos = entry.getCoordinatesRelativeToCanvas();

						double distance = Math.sqrt(Math.pow((my_connector_pos[0] - other_connector_pos[0]), 2)
								+ Math.pow((my_connector_pos[1] - other_connector_pos[1]), 2));

						if (distance < raggio_magnete) {

							filtered_list_of_targets.add(entry);

						} else {
							if (entry.isVirtual())
								((AnchorPointVirtual) entry).destroyVirtual();
						}
					}
				}
			}

			result.put(sourceAnchor, filtered_list_of_targets);
		}

		return result;
	}

	/**
	 * Called on each {@code AnchorPoint} of the node to find its nearest compatible
	 * {@code AnchorPoint}.
	 * 
	 * @param my_connector     The candidate source {@code AnchorPoint} for the
	 *                         connection
	 * @param other_connectors All the candidate target for {@code my_connector}
	 * @return A pair containing the candidate target and the distance from it
	 */
	public static SimpleEntry<AnchorPoint, double[]> find_nearest_connector(AnchorPoint my_connector,
			List<AnchorPoint> other_connectors) {

		boolean connector_found = false;

		double distance = 9999999;

		double[] my_connector_pos = my_connector.getCoordinatesRelativeToCanvas();

		SimpleEntry<AnchorPoint, double[]> result = null;

		for (AnchorPoint entry : other_connectors) {

			double[] other_connector_pos = entry.getCoordinatesRelativeToCanvas();

			double new_distance = Math.sqrt(Math.pow((my_connector_pos[0] - other_connector_pos[0]), 2)
					+ Math.pow((my_connector_pos[1] - other_connector_pos[1]), 2));

			// Check distance
			if (new_distance < distance) {
				distance = new_distance;
				double distanceX = my_connector_pos[0] - other_connector_pos[0];
				double distanceY = my_connector_pos[1] - other_connector_pos[1];
				connector_found = true;
				if (result != null) {
					AnchorPoint old = result.getKey();
					if (old.isVirtual())
						((AnchorPointVirtual) old).destroyVirtual();
				}
				result = new SimpleEntry<AnchorPoint, double[]>(entry, new double[] { distanceX, distanceY });
			} else {
				if (entry.isVirtual())
					((AnchorPointVirtual) entry).destroyVirtual();
			}
		}

		if (connector_found) {
			return (SimpleEntry<AnchorPoint, double[]>) result;
		}

		return null;
	}

	/**
	 * Search for the winner {@code AnchorPoint} that will be target of the
	 * connection between the finalists found with the
	 * {@link Magnete#find_nearest_connector(AnchorPoint, List, double)}.
	 * 
	 * @param first_connector
	 * @param second_connector
	 * @return A pair containing the winner target and the distance from it
	 */
	public static SimpleEntry<?, ?> find_nearest_between(SimpleEntry<?, ?> first_connector,
			SimpleEntry<?, ?> second_connector) {

		if (first_connector != null) {
			if (second_connector != null) {
				double[] first_distance = (double[]) first_connector.getValue();
				double[] second_distance = (double[]) second_connector.getValue();

				if ((Math.abs(first_distance[0]) + Math.abs(first_distance[1])) > (Math.abs(second_distance[0])
						+ Math.abs(second_distance[1]))) {
					AnchorPoint ap = (AnchorPoint) first_connector.getKey();
					if (ap.isVirtual())
						((AnchorPointVirtual) ap).destroyVirtual();
					return second_connector;
				} else {
					AnchorPoint ap = (AnchorPoint) second_connector.getKey();
					if (ap.isVirtual())
						((AnchorPointVirtual) ap).destroyVirtual();
					return first_connector;
				}
			}

			return first_connector;
		}

		if (second_connector != null)
			return second_connector;

		return null;
	}

	/**
	 * Checks if a {@code DraggableNode} is already connected which means that at
	 * least one of its anchor points is connected at least once.
	 * 
	 * @param dnode The {@code DraggableNode}
	 * @return true if the node is already connected, false otherwise.
	 */
	private static boolean nodeIsConnected(DraggableNode dnode) {
		for (Node node : dnode.getEnte().lookupAll("AnchorPoint")) {
			AnchorPoint anchorPoint = (AnchorPoint) node;
			if (anchorPoint.isConnectedAtLeastOnce())
				return true;
		}

		return false;
	}
}
