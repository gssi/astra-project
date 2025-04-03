package it.gssi.astra.metaeditor.common.grid;

import java.util.LinkedList;
import java.util.List;

import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

/*
 * Class used to generate the canvas grid.
 * It creates a grid made up of javafx.scene.shape.Line
 * 
 * @see javafx.scene.shape.Line
 * */
public class CanvasGrid extends Pane {
	
	private final int CELL_SIZE = 15;
	
	public CanvasGrid(MetaEditorPersistence rootPersistence) {
		
		JFX2EMF.bindValues(Contexts.CANVAS, rootPersistence, "canvasWidth", this, "gridWidth", Converters.NONE);
		JFX2EMF.bindValues(Contexts.CANVAS, rootPersistence, "canvasHeight", this, "gridHeight", Converters.NONE);

		this.setStyle("-fx-background-color:#f5f5f5");

		this.setWidth(getGridWidth());
		this.setHeight(getGridHeight());
	}
	
	public CanvasGrid(MetaEditorPersistence rootPersistence, int width, int height) {
		
		JFX2EMF.bindValues(Contexts.CANVAS, rootPersistence, "canvasWidth", this, "gridWidth", Converters.NONE);
		JFX2EMF.bindValues(Contexts.CANVAS, rootPersistence, "canvasHeight", this, "gridHeight", Converters.NONE);
		
		setGridWidth(width);
		setGridHeight(height);

		this.setStyle("-fx-background-color:#f5f5f5");

		this.setWidth(getGridWidth());
		this.setHeight(getGridHeight());
	}

	private IntegerProperty gridWidthProperty;

	public Integer getGridWidth() {
		return gridWidthProperty.get();
	}

	public void setGridWidth(Integer value) {
		gridWidthProperty().set(value);
	}

	public IntegerProperty gridWidthProperty() {
		if (gridWidthProperty == null) {
			gridWidthProperty = new IntegerPropertyBase() {
				
				@Override
				protected void invalidated() {
					List<Line> lines = createGridLines();
					CanvasGrid.this.getChildren().clear();
					CanvasGrid.this.getChildren().addAll(lines);
					CanvasGrid.this.setWidth(get());
				}

				@Override
				public Object getBean() {
					return CanvasGrid.this;
				}

				@Override
				public String getName() {
					return "gridWidthProperty";
				}};
		}
		
		return gridWidthProperty;
	}
	
	private IntegerProperty gridHeightProperty;

	public Integer getGridHeight() {
			return gridHeightProperty.get();
	}

	public void setGridHeight(Integer value) {
		gridHeightProperty().set(value);
	}

	public IntegerProperty gridHeightProperty() {
		if (gridHeightProperty == null) {
			gridHeightProperty = new IntegerPropertyBase() {
				
				@Override
				protected void invalidated() {
					List<Line> lines = createGridLines();
					CanvasGrid.this.getChildren().clear();
					CanvasGrid.this.getChildren().addAll(lines);
					CanvasGrid.this.setHeight(get());
				}

				@Override
				public Object getBean() {
					return CanvasGrid.this;
				}

				@Override
				public String getName() {
					return "gridWidthProperty";
				}};
		}
		
		return gridHeightProperty;
	}

	private List<Line> createGridLines() {
		
		List<Line> lines = new LinkedList<>();
		
		if (gridWidthProperty != null && gridHeightProperty != null) {
			
			Color COLOR_ODD = Color.LIGHTGRAY;
			Color COLOR_EVEN = Color.DARKGRAY;
			
			int SPACING = CELL_SIZE * 2;
			
			double STROKE_ODD = 0.3;
			double STROKE_EVEN = 0.5;		
			
			// Odd lines
			// Vertical lines	
			for(int i=0; i < getGridHeight(); i=i+CELL_SIZE) {

				Line linea = new Line();

				if(i%SPACING!=0) {
					linea.setStroke(COLOR_ODD);
					linea.setStrokeWidth(STROKE_ODD);
					linea.setStrokeLineCap(StrokeLineCap.BUTT);
					linea.setEndX(getGridWidth());
					linea.setStartY(i);
					linea.setEndY(i);		
					
					
					lines.add(linea);
				}
			}
			// Horizontal lines
			for(int i=0; i < getGridWidth(); i=i+CELL_SIZE) {

				Line linea = new Line();

				if(i%SPACING!=0) {
					linea.setStroke(COLOR_ODD);
					linea.setStrokeWidth(STROKE_ODD);
					linea.setStrokeLineCap(StrokeLineCap.BUTT);
					
					linea.setEndY(getGridHeight());
					linea.setStartX(i);
					linea.setEndX(i);			

					lines.add(linea);
				}
			}
			
			// Even lines
			// Vertical lines		
			for(int i=0; i < getGridHeight(); i=i+CELL_SIZE) {

				Line linea = new Line();

				if(i%SPACING==0) {
					linea.setStroke(COLOR_EVEN);
					linea.setStrokeWidth(STROKE_EVEN);
					linea.setStrokeLineCap(StrokeLineCap.BUTT);
					
					linea.setEndX(getGridWidth());
					linea.setStartY(i);
					linea.setEndY(i);			
					
					lines.add(linea);
				}
			}
			// Horizontal lines
			for(int i=0; i < getGridWidth(); i=i+CELL_SIZE) {

				Line linea = new Line();

				if(i%SPACING==0) {
					linea.setStroke(COLOR_EVEN);
					linea.setStrokeWidth(STROKE_EVEN);
					linea.setStrokeLineCap(StrokeLineCap.BUTT);
					
					linea.setEndY(getGridHeight());
					linea.setStartX(i);
					linea.setEndX(i);			

					lines.add(linea);
				}
			}
			
		}
		
		return lines;
	}
}
