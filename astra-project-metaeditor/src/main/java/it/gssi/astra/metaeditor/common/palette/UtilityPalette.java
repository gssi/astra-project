package it.gssi.astra.metaeditor.common.palette;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;

/**
 *  This class contains utilities that handle the palette as the style of a single object within
 *
 */
public class UtilityPalette {

	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String PATH_PNG = BASE_PATH_FXML + EditorProperties.get("element.png");

	//This function adds a single object inside the palette, in particular it is given a style and added a listener which then allows the user to insert the object inside the canvas
	public static void addElementPalette(GraphicalElement graphicalElement, PaletteGesture paletteGesture, VBox palette) {
		
		PaletteElement paletteElement = new PaletteElement(graphicalElement);
		String iconPath = graphicalElement.getIconPath();

		Tooltip tooltip = new Tooltip(paletteElement.getMetaclassName());
		Tooltip.install(paletteElement, tooltip);
		
		Image image = null;
		if (iconPath == " " || iconPath == "") {
			iconPath = PATH_PNG;
		}
		
		try {
			image = new Image(UtilityPalette.class.getResource(iconPath).toExternalForm());

		} catch (Exception e) {
			System.err.println("NOT FOUND" + iconPath);
			image = new Image(UtilityPalette.class.getResource(PATH_PNG).toExternalForm());
		}
		ImageView iv1 = new ImageView();
		iv1.setScaleX(0.8);
		iv1.setScaleY(0.8);
		iv1.setImage(image);

		
		paletteElement.setStyle("-fx-background-color: rgb(71,71,71); -fx-border-color: transparent;");
		paletteElement.setCenter(iv1);
		paletteElement.setMinWidth(30);
		paletteElement.setMinHeight(30);
		paletteElement.prefHeight(30);
		paletteElement.prefWidth(30);

		paletteElement.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				paletteElement.setStyle("-fx-background-color: rgb(128,128,128); -fx-border-color: rgb(83,87,88);");
			}
		});

		paletteElement.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				paletteElement.setStyle("-fx-background-color: rgb(71,71,71); -fx-border-color: transparent;");

			}
		});

		paletteElement.setOnDragDetected(PaletteGesture.DragDetected);
		paletteElement.setOnDragDone(PaletteGesture.OnDragDone);
		
		palette.getChildren().add(paletteElement);
	}

}

