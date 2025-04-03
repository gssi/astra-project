package it.gssi.astra.metaeditor.common.palette;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import javafx.scene.layout.BorderPane;

/**
 * This class represent the controller of Palette
 * 
 */
public class PaletteElement extends BorderPane {

	private String metaclassName;
	private GraphicalElement graphicalElement;
	private int upperBound;

	public GraphicalElement getGraphicalElement() {
		return graphicalElement;
	}

	public String getMetaclassName() {
		return metaclassName;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public PaletteElement(GraphicalElement graphicalElement) {
		super();
		this.graphicalElement = graphicalElement;
		this.metaclassName = graphicalElement.getElement().getName();
	}
}
