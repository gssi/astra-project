package it.gssi.astra.metaeditor.common.grid;

import it.gssi.astra.metaeditor.common.ente.Ente;

public class GridUtils {

	/**
	 * It is the default value for snap to grid step resolution from the point of
	 * view of
	 * {@code DraggableNode#snapToGrid(it.univaq.disim.ermes.metaeditor.common.ente.Pivot)}.
	 * Meaning the {@code DraggableNode} will snap to grid with steps of 5 pixel. It
	 * can be customized by each {@code Ente} overriding the method
	 * {@link Ente#getRisoluzione_griglia()}.
	 * 
	 */
	public static final int DRAGGING_STEP_LENGTH = 5;

	public static double snapToGrid(double position, int risoluzione_griglia) {

		if (risoluzione_griglia > 0) {

			double g = risoluzione_griglia;
			double h = risoluzione_griglia / 2d;

			double module = position % g;
			position = module >= h ? position + g - module : position - module;
		}

		return position;
	}

	public static double[] snapToGrid(double[] pivot, int risoluzione_griglia) {

		double g = risoluzione_griglia;
		double h = risoluzione_griglia / 2d;

		double module = pivot[0] % g;
		double offsetX = (module >= h ? pivot[0] + g - module : pivot[0] - module) - pivot[0];

		module = pivot[1] % g;
		double offsetY = (module >= h ? pivot[1] + g - module : pivot[1] - module) - pivot[1];

		return new double[] { offsetX, offsetY };

	}
}
