package it.gssi.astra.metaeditor.common.popup;

import java.util.Optional;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This class is a UI component formed by a {@link Dialog} and it is use to
 * edit the canvas dimensions.
 *
 */
public class PreferencesPopup {

	public static void show() {
		int[] result = PreferencesPopup.result();
		
		//Ignore the empty value
		if(result[0] == 0 && result[1] == 0) { return ;}
		
		var canvas = LayoutScene.getInstance().getContainerCanvas().getCanvas();
		
		boolean exist = false;
		for (Node dNode : canvas.getChildren()) {
			if (dNode.getLayoutX() > result[0] || dNode.getLayoutY() > result[1]) {
				exist = true;
			}
		}
		if (exist) {
			Popup.dialog("Attenzione:", "Alcuni elementi si trovano fuori dalle dimensioni inserite");
		} else {

			
			
			var sections = LayoutScene.getInstance().getContainerCanvas().getSectionLayer().getSections();
			
			if(result[1] < sections.get(0).getSectionHeight() || result[0] < sections.get(0).getSectionWidth()*sections.size() ) {
				Popup.dialog("Attenzione:", "Le dimensioni inserite sono minori delle sezioni presenti sul canvas");
			}else {
				
				EMFCommands emfCommand = new EMFCommands();
				emfCommand.begin();
				
				LayoutScene.getInstance().getContainerCanvas().updateGrid(result[0], result[1]);
				
				emfCommand.end();
			}
		}
	}
	
	public static int[] result() {
		
		
		var canvasWidth = LayoutScene.getInstance().getContainerCanvas().getRootPersistence().getCanvasWidth();
		var canvasHeight = LayoutScene.getInstance().getContainerCanvas().getRootPersistence().getCanvasHeight();
		
		// Create the custom dialog.
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Preferenze");
		dialog.setHeaderText("Dimensioni canvas");

		// Set the icon (must be included in the project).
		//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

		// Set the button types.
		ButtonType saveButtonType = new ButtonType("Salva", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField width = new TextField();
		width.setPromptText("Larghezza");
		width.setText(String.valueOf(canvasWidth));
		
		TextField height = new TextField();
		height.setPromptText("Altezza");
		height.setText(String.valueOf(canvasHeight));
		
		grid.add(new Label("Larghezza canvas:"), 0, 0);
		grid.add(width, 1, 0);
		grid.add(new Label("Altezza canvas:"), 0, 1);
		grid.add(height, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node saveButton = dialog.getDialogPane().lookupButton(saveButtonType);
		saveButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		width.textProperty().addListener((observable, oldValue, newValue) -> {


			if (!newValue.matches("\\d*")) {
				width.setText(newValue.replaceAll("[^\\d]", ""));
			}

			saveButton.setDisable(width.getText().isBlank() || height.getText().isBlank());
		});

		height.textProperty().addListener((observable, oldValue, newValue) -> {
			
			if (!newValue.matches("\\d*")) {
				width.setText(newValue.replaceAll("[^\\d]", ""));
			}
			
			saveButton.setDisable(width.getText().isBlank() || height.getText().isBlank());
		});

		dialog.getDialogPane().setContent(grid);


		Optional<ButtonType> result = dialog.showAndWait();

		if (result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE ) {
			return new int[] {Integer.valueOf(width.getText()),Integer.valueOf(height.getText())};
		}

		return new int[] {LayoutScene.getInstance().getRootPersistence().getCanvasWidth(),LayoutScene.getInstance().getRootPersistence().getCanvasHeight()};
	}
}
