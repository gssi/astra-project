package it.gssi.astra.metaeditor.common.palette;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.interfaces.IPalette;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;

/**
 * This Class manage the gesture of Palette 
 *
 */
public class PaletteGesture {

	public static IPalette paletteInterface;
	
	public static LayoutScene root;

	public PaletteGesture(IPalette palette, LayoutScene root) {

		PaletteGesture.paletteInterface = palette;
		PaletteGesture.root = root;

	}

	public static EventHandler<MouseEvent> DragDetected = new EventHandler<MouseEvent>() {

		public void handle(MouseEvent event) {
			/* drag was detected, start drag-and-drop gesture */

			PaletteElement pe = (PaletteElement) event.getSource();
			/* allow any transfer mode */
			Dragboard db = ((Node) event.getSource()).startDragAndDrop(TransferMode.ANY);

			/* put a string on dragboard */
			ClipboardContent content = new ClipboardContent();
			content.putString(pe.getMetaclassName());
			db.setContent(content);

			event.consume();
		}

	};

	public static EventHandler<DragEvent> OnDragDone = new EventHandler<DragEvent>() {

		public void handle(DragEvent event) {
			/* the drag-and-drop gesture ended */
//		                System.out.println("onDragDone");
			/* if the data was successfully moved, clear it */
			if (event.getTransferMode() == TransferMode.MOVE) {
//		                    source.setText("");
			}

			event.consume();

		}

	};

}
