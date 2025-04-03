package it.gssi.astra.metaeditor.common.canvas.section;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import MetaEditor.MetaEditorPersistence.CanvasSection;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.popup.CanvasSectionPopup;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 * This class is a UI component that extends the {@link Pane} and is used as a separate
 * layer from the canvas to manage the sections. By default the component has
 * the same dimensions as the {@link Canvas} and is formed by a single {@link CanvasSectionFX}. The
 * class provides methods to create, edit, or load existing sections.
 *
 */
public class CanvasSectionLayer extends Pane {

	private LayoutScene layout;

	public CanvasSectionLayer() {
		this.layout = LayoutScene.getInstance();
	}
	
	public ObjectProperty<ObservableList<CanvasSectionFX>> sezioni;

	public void setSezioni(ObservableList<CanvasSectionFX> value) {
		sezioniProperty().set(value);
	}

	public ObservableList<CanvasSectionFX> getSezioni() {
		return sezioni == null ? null : sezioni.get();
	}

	public ObjectProperty<ObservableList<CanvasSectionFX>> sezioniProperty() {
		if (sezioni == null) {
			sezioni = new SimpleObjectProperty<>() {
				@Override
				protected void invalidated() {

					CanvasSectionLayer.this.getChildren().clear();
					CanvasSectionLayer.this.getChildren().addAll(get());
					
					// Update canvas if sections are larger

					ObservableList<CanvasSectionFX> i = get();
					
					if (i.size() > 0) {
						int sectionWidth = (int) get().get(0).getWidth() * get().size();
						int sectionHeight = (int) get().get(0).getHeight();
				
						int canvasWidth = LayoutScene.getInstance().getRootPersistence().getCanvasWidth();
						int canvasHeight = LayoutScene.getInstance().getRootPersistence().getCanvasHeight();
				
						if (sectionWidth > canvasWidth) {
							canvasWidth = sectionWidth;
						}
				
						if (sectionHeight > canvasHeight) {
							canvasHeight = sectionHeight;
						}
				
						layout.getContainerCanvas().updateGrid(canvasWidth, canvasHeight);
					}
					
					
				}

				@Override
				public Object getBean() {
					return CanvasSectionLayer.this;
				}

				@Override
				public String getName() {
					return "sezioni";
				}
			};
		}
		return sezioni;
	}
	
	public void edit() {

		List<CanvasSectionFX> result = CanvasSectionPopup.show();
		
		//Return if the popup is closed
		if(result == null || result.isEmpty()) return;
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();
		
		setSezioni(FXCollections.observableList(result));
		
		emfCommand.end();
		
	}

	public void generateDefault() {
		var width = layout.getContainerCanvas().getGrid().getGridWidth();
		var height = layout.getContainerCanvas().getGrid().getGridHeight();

		ObservableList<CanvasSectionFX> list = FXCollections.observableArrayList();
		list.add(new CanvasSectionFX("default", width, height, 0));
		setSezioni(list);

	}
	
	public EList<CanvasSection> getSections() {
		return LayoutScene.getInstance().getRootPersistence().getCanvasSections();		
	}

}