package it.gssi.astra.metaeditor.common.magnete;

import it.gssi.astra.metaeditor.common.canvas.CanvasUtils;
import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;

/**
 * <p>
 * It is a special {@code AnchorPoint} that is not meant to be added
 * in FXML, but it is automatically instantiated by the magnet when
 * a bendable element provide an {@code AnchorPoint} of type <italic>full</italic>
 * meaning another {@code AnchorPoint} can be attached to it in any
 * point along the lines that build up the node.
 * </p>
 * 
 * <p>
 * When the {@codeAnchorPointVirtual} is instantiated because it would
 * have been the nearest to the source anchor point, then it will displayed
 * with a dashed blue circle. Its life cycle ends when it is disconnected.
 * </p>
 * 
 * <p>
 * Take note that an {@code AnchorPointVirtual} is considered as an attached
 * node to both the bend points that are the ends of the segment that contain
 * this {@code AnchorPointVirtual} in order for its position to be updated
 * when one of the two bend points is dragged. That means that after the drag
 * is over the handler of {@code MouseEvent#MOUSE_RELEASED} will try to reconnect
 * the two anchor points but the connection will be lost if the distance between
 * source and target is greater or equal than {@value LayoutScene#RAGGIO_MAGNETE}.
 * </p>
 *
 *@see Magnete
 */
public class AnchorPointVirtual extends AnchorPoint {

	public AnchorPointVirtual() {
		super();
	}

	/**
	 * The bend points adjacent to {@code AnchorPointVirtual}
	 */
	private BendPoint first, second;
	
	public BendPoint getFirst() {
		return first;
	}
	
	public void setFirst(BendPoint first) {
		this.first = first;
	}
	
	public BendPoint getSecond() {
		return second;
	}
	
	public void setSecond(BendPoint second) {
		this.second = second;
	}
	
	/**
	 * Overrides the super to add call to {@link AnchorPointVirtual#destroyVirtual}
	 */
	@Override
	public void disconnect() {
		if (getTarget() != null) {
			AnchorPoint target = getTarget();
			eObjectTarget.set(null);
			target.eObjectTargetProperty().set(null);
		}
		destroyVirtual();
	}
	
	/**
	 * Overrides the super to add call to {@link AnchorPointVirtual#destroyVirtual}
	 */
	@Override
	public void autoDisconnect() {
		if (getTarget() != null) {
			AnchorPoint target = getTarget();
			this.target.setValue(null);
			target.autoDisconnect();
		}
		destroyVirtual();
	}
	
	/**
	 * Removes an {@code AnchorPointVirtual} to avoid memory leaks.
	 * You can check this method worked correctly by seeing the dashed
	 * blue circle disappear from the the visual representation of
	 * bendable element.
	 * 
	 */
	public void destroyVirtual() {
		if (first != null)
			first.attachedNodes.remove(this);
		if (second != null)
			second.attachedNodes.remove(this);
		getEntePadre().getChildren().remove(this);
	}
	
	/**
	 * Adds this {@code AnchorPointVirtual} to the list {@link BendPoint#attachedNodes}
	 * of both its bend points.
	 */
	public void attach() {
		/*
		 * use this to maintain proportions after stretching
		 * if (first != null && second != null) {
		 * double total_distance = CanvasUtils.distance(virtual.first.getCenterX(), virtual.first.getCenterY(), virtual.second.getCenterX(), virtual.second.getCenterY());
		 * double mid_distance = CanvasUtils.distance(virtual.first.getCenterX(), virtual.first.getCenterY(), virtual.getCenterX(), virtual.getCenterY());
		 * virtual.first.attachedNodes.put(virtual, new Double[] {mid_distance/total_distance, 0D});
		 * virtual.second.attachedNodes.put(virtual, new Double[] {(total_distance - mid_distance)/total_distance, 0D});
		 * }
		 */
		
		if (first != null) {
			double left_distance = CanvasUtils.distance(this.first.getCenterX(), this.first.getCenterY(), this.getCenterX(), this.getCenterY());
			this.first.attachedNodes.put(this, new Double[] {(-1) * left_distance, 0D});
		}
		if (second != null) {
			double right_distance = CanvasUtils.distance(this.second.getCenterX(), this.second.getCenterY(), this.getCenterX(), this.getCenterY());
			this.second.attachedNodes.put(this, new Double[] {(-1) * right_distance, 0D});
		}
		
	}
}
