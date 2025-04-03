package it.gssi.astra.metaeditor.common.ente;

import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;
import it.gssi.astra.metaeditor.common.ente.customNode.CustomLine;
import it.gssi.astra.metaeditor.common.ente.customNode.CustomPolygon;
import it.gssi.astra.metaeditor.common.ente.customNode.CustomPolyline;
import it.gssi.astra.metaeditor.common.ente.customNode.CustomRectangle;
import it.gssi.astra.metaeditor.common.ente.customNode.LineWrapper;
import it.gssi.astra.metaeditor.common.property.UnbackedCustomPropertyItem;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.FXML;


/**
 * 
 * This class extends {@link Ente} with a new component {@link LineWrapper}
 * Is important to add the component into {@link FXML} otherwise the {@link EnteBendable#customLine} is null
 * 
 */
public abstract class EnteBendable extends Ente {

	@FXML
	public LineWrapper customLine;

	public LineWrapper getCustomLine() {
		return customLine;
	}

	public EnteBendable(String name) {
		super(name);
	}

	@Override
	public void initialization() {

		super.initialization();

		customLine.parent = this;
		customLine.addModel(this.elementPosition);

		customLine.showBendPoints(false);
		
		this.pinnedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				for (BendPoint bendPoint : customLine.getPuntiPolilinea()) {
					bendPoint.disableDrag();
				}
			} else {
				for (BendPoint bendPoint : customLine.getPuntiPolilinea()) {
					bendPoint.enableDrag();
				}
			}
		});

		// Check again pinned property because bend points hadn't be loaded at
		// super.initialization() yet.
		if (getPinned()) {
			for (BendPoint bendPoint : customLine.getPuntiPolilinea()) {
				bendPoint.disableDrag();
			}
		} else {
			for (BendPoint bendPoint : customLine.getPuntiPolilinea()) {
				bendPoint.enableDrag();
			}
		}
	}

	public void populatePropertyView() {

		super.populatePropertyView();

		UnbackedCustomPropertyItem visible_BendPoint = new UnbackedCustomPropertyItem(((val) -> customLine.showBendPoints((boolean) val)), "Basic#VisibleBendPoint", customLine.getBendPointsVisibility(), true);
		properties.add(visible_BendPoint);
		
	}

	/**
	 * This function is used to refresh the coordinate of {@link BendPoint}
	 */
	public void updateDraggableNodePosition() {
		
		if (this.customLine.getPuntiPolilinea().size() > 1) {

			double minX = 999999;
			double minY = 999999;
	
			for (BendPoint bendPoint : this.customLine.getPuntiPolilinea()) {
	
				if (bendPoint.getCenterX() < minX)
					minX = bendPoint.getCenterX();
	
				if (bendPoint.getCenterY() < minY)
					minY = bendPoint.getCenterY();
			}
	
			if (minX != 0 || minY != 0) {
	
				this.getDraggableNode().setLayoutX((int) Math.round(this.getDraggableNode().getLayoutX() + minX));
				this.getDraggableNode().setLayoutY((int) Math.round(this.getDraggableNode().getLayoutY() + minY));
	
				for (BendPoint bendPoint : this.getCustomLine().getPuntiPolilinea()) {
					bendPoint.setCenterX((int) Math.round(bendPoint.getCenterX() - minX));
					bendPoint.setCenterY((int) Math.round(bendPoint.getCenterY() - minY));
				}
			}
		}
	}
	
	
	/**
	 * This method is used to control the {@link BendPoint} drag of {@link CustomLine } or {@link CustomPolyline} for 
	 * not reverse all {@link BendPoint}
	 */
	public void validate_LeftRight_Constraint() {

		customLine.getPuntiPolilinea().addListener(new ListChangeListener<BendPoint>() {

			@Override
			public void onChanged(Change<? extends BendPoint> c) {
				while (c.next()) {
					if (c.wasUpdated()) {
						BendPoint b = customLine.getPuntiPolilinea().get(c.getFrom());
							
							if(b.getPreviousBendPoint() != null && b.getNextBendPoint() != null) {
								
								if(b.getNewValueX().get() < b.getPreviousBendPoint().getCenterX()) {
									
									b.disableDraggingHorizontal();

									b.setTranslateX(b.getPreviousBendPoint().getCenterX() - b.getCenterX());
									b.setX_Property(b.getPreviousBendPoint().getCenterX());

								}
								
								if(b.getNewValueX().get() > b.getNextBendPoint().getCenterX()) {
									
									b.disableDraggingHorizontal();

									b.setTranslateX(b.getNextBendPoint().getCenterX() - b.getCenterX());
									b.setX_Property(b.getNextBendPoint().getCenterX());

								}
								
								if (b.getNewValueX().get() > b.getPreviousBendPoint().getCenterX() && b.getNewValueX().get() < b.getNextBendPoint().getCenterX()) {
									b.enableDraggingHorizontal();
								}
								
							} else if (b.getPreviousBendPoint() != null) {
								
								if(b.getNewValueX().get() < b.getPreviousBendPoint().getCenterX()) {
									
									b.disableDraggingHorizontal();

									b.setTranslateX(b.getPreviousBendPoint().getCenterX() - b.getCenterX());
									b.setX_Property(b.getPreviousBendPoint().getCenterX());

								} else {
									b.enableDraggingHorizontal();
								}
								
							} else if (b.getNextBendPoint() != null) {
								
								if(b.getNewValueX().get() > b.getNextBendPoint().getCenterX()) {
									
									b.disableDraggingHorizontal();

									b.setTranslateX(b.getNextBendPoint().getCenterX() - b.getCenterX());
									b.setX_Property(b.getNextBendPoint().getCenterX());

								} else {
									b.enableDraggingHorizontal();
								}
							}

						}
						
					}
				}
		});
	}
}
