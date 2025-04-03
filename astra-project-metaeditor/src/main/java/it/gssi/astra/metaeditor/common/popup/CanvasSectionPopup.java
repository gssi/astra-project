package it.gssi.astra.metaeditor.common.popup;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;

import MetaEditor.MetaEditorPersistence.CanvasSection;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.section.CanvasSectionFX;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This class is a UI component formed by a {@link Dialog} and it is use to edit
 * sections on the selected canvas. The dialog consists of 3 fields: height,
 * width and number. Each field is required and is validated before being
 * entered.
 *
 */
public class CanvasSectionPopup {
	
	

	public static List<CanvasSectionFX> show() {
		
		
		EList<CanvasSection> canvasSections = LayoutScene.getInstance().getContainerCanvas().getSectionLayer().getSections();
		
		String canvasWidht = String.valueOf(canvasSections.get(0).getSectionWidth());
		String canvasHeight = String.valueOf(canvasSections.get(0).getSectionHeight());
		String canvasSize = String.valueOf(canvasSections.size());
		

		// Create the custom dialog.
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Sezioni");


		dialog.getDialogPane().getStylesheets().add(LayoutScene.class.getResource("/common/stylesheets/application.css").toExternalForm());

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

		//Larghezza
		TextField width = new TextField(canvasWidht);


		grid.add(new Label("Larghezza:"), 0, 0);
		grid.add(width, 1, 0);

		//Altezza
		TextField height = new TextField(canvasHeight);

		grid.add(new Label("Altezza:"), 0, 1);
		grid.add(height, 1, 1);

		//Numero monitor
		TextField number = new TextField(canvasSize);

		grid.add(new Label("N. Monitor:"), 0, 2);
		grid.add(number, 1, 2);


		// Enable/Disable login button depending on whether a username was entered.
		Node saveButton = dialog.getDialogPane().lookupButton(saveButtonType);
		saveButton.setDisable(true);

		// Validation, only numbers
		width.textProperty().addListener((observable, oldValue, newValue) -> {


			if (!newValue.matches("\\d*")) {
				width.setText(newValue.replaceAll("[^\\d]", ""));
			}

			saveButton.setDisable(
					width.getText().isBlank()
					|| height.getText().isBlank()
					|| number.getText().isBlank()
					);
		});

		// Validation, only numbers
		height.textProperty().addListener((observable, oldValue, newValue) -> {

			if (!newValue.matches("\\d*")) {
				height.setText(newValue.replaceAll("[^\\d]", ""));
			}

			saveButton.setDisable(width.getText().isBlank()
					|| height.getText().isBlank()
					||number.getText().isBlank()
					);
		});

		// Validation, only numbers
		number.textProperty().addListener((observable, oldValue, newValue) -> {

			if (!newValue.matches("\\d*")) {
				number.setText(newValue.replaceAll("[^\\d]", ""));
			}

			saveButton.setDisable(
					width.getText().isBlank()
					|| height.getText().isBlank()
					|| number.getText().isBlank()
					);
		});

		dialog.getDialogPane().setContent(grid);


		Optional<ButtonType> result = dialog.showAndWait();

		if (result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE ) {

			List<CanvasSectionFX> canvasSectionList = new LinkedList<>();

			for(int i=0;i<Integer.valueOf(number.getText());i++) {
				canvasSectionList.add(new CanvasSectionFX(
						"canvas"+i,
						Integer.valueOf(width.getText()),
						Integer.valueOf(height.getText()),
						i* Integer.valueOf(width.getText())
						));
			}
			
			return canvasSectionList;
		}

		return null;
	}
}
