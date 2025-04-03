package it.gssi.astra.metaeditor.common.canvas;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.gssi.astra.metaeditor.common.magnete.Segment;
import javafx.geometry.Point2D;

/**
 *
 */
public class CanvasUtils {

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}

	public static double distanzaPuntoRetta(double coefficienteAngolare, double q, double pointX, double pointY) {
		return Math.abs(pointY - (coefficienteAngolare * pointX + q))
				/ Math.sqrt(1 + Math.pow(coefficienteAngolare, 2));
	}

	/**
	 * Checks if a point can be projected over a segment.
	 * 
	 * @param start_x First coordinate x of the segment
	 * @param start_y First coordinate y of the segment
	 * @param end_x   Second coordinate x of the segment
	 * @param end_y	  Second coordinate y of the segment
	 * @param point_x The coordinate x of the point
	 * @param point_y The coordinate y of the point
	 * @return true if the point projects on the segment, false otherwise
	 */
	public static boolean isProjectedPointOnSegment(double start_x, double start_y, double end_x, double end_y,
			double point_x, double point_y) {
		// get dot product |line| * |line|
		Point2D e1 = new Point2D(end_x - start_x, end_y - start_y);

		double recArea = dotProduct(e1, e1);

		// dot product of |line| * |testline|
		Point2D e2 = new Point2D(point_x - start_x, point_y - start_y);

		double val = dotProduct(e1, e2);

		return (val > 0 && val < recArea);
	}

	/**
	 * Get projected point P' of P on line AB.
	 * 
	 * @return projected point p.
	 */
	public static Point2D getProjectedPointOnSegment(Segment segment, double point_x, double point_y) {
		double start_x = segment.getFirstBendPoint().getCoordinatesRelativeToCanvas()[0];
		double start_y = segment.getFirstBendPoint().getCoordinatesRelativeToCanvas()[1];
		double end_x = segment.getSecondBendPoint().getCoordinatesRelativeToCanvas()[0];
		double end_y = segment.getSecondBendPoint().getCoordinatesRelativeToCanvas()[1];

		Point2D e1 = new Point2D(end_x - start_x, end_y - start_y);
		Point2D e2 = new Point2D(point_x - start_x, point_y - start_y);

		double val = dotProduct(e1, e2);

		double len2 = e1.getX() * e1.getX() + e1.getY() * e1.getY();

		Point2D p = new Point2D((int) (start_x + val * e1.getX() / len2), (int) (start_y + val * e1.getY() / len2));

		return p;
	}

	/**
	 * Calculates the dot product of two 2D vectors / points.
	 * 
	 * @param p1 first point used as vector
	 * @param p2 second point used as vector
	 * @return dotProduct of vectors
	 */
	private static double dotProduct(Point2D p1, Point2D p2) {
		return (p1.getX() * p2.getX() + p1.getY() * p2.getY());
	}
}
