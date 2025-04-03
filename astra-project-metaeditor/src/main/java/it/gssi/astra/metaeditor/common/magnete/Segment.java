package it.gssi.astra.metaeditor.common.magnete;

import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;

/**
 * Represents one of the segments which build up a bendable element.
 * It is defined by its left end and last end.
 */
public class Segment {

	private Ente padre;

	private BendPoint firstBendPoint;
	private BendPoint secondBendPoint;

	public Segment(Ente padre) {
		this.padre = padre;
	}

	/**
	 * Constructor for vertical rects
	 * 
	 * @param padre
	 * @param x
	 */
	public Segment(Ente padre, double x) {
		this.padre = padre;
	}

	public Ente getPadre() {
		return padre;
	}

	public void setPadre(Ente padre) {
		this.padre = padre;
	}

	public BendPoint getFirstBendPoint() {
		return firstBendPoint;
	}

	public void setFirstBendPoint(BendPoint firstBendPoint) {
		this.firstBendPoint = firstBendPoint;
	}

	public BendPoint getSecondBendPoint() {
		return secondBendPoint;
	}

	public void setSecondBendPoint(BendPoint secondBendPoint) {
		this.secondBendPoint = secondBendPoint;
	}

}
