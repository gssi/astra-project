package it.gssi.astra.metaeditor.common.interfaces;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.palette.PaletteGesture;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.VBox;

public interface IPalette {

	void createElement(DragEvent event, LayoutScene scene);
	void populatePalette(PaletteGesture paletteGesture, VBox palette);

}
