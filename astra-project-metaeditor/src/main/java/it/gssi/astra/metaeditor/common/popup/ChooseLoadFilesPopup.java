package it.gssi.astra.metaeditor.common.popup;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.controlsfx.control.CheckListView;

import it.gssi.astra.metaeditor.common.dataManager.fileManager.FileManagerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

/**
 * This class is a UI component formed by a {@link Dialog} and it is use to
 * select files to load. The dialog consists mainly of a list of files and
 * buttons to select or deselect all items in the list.
 *
 */
public class ChooseLoadFilesPopup {

	public static List<File> showDialog(List<File> files) {

		List<File> selectedFiles = new LinkedList<>();

		// Create the custom dialog.
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Carica files "+ FileManagerImpl.getInstance().getFileExtention());
		dialog.setHeaderText("Carica files "+ FileManagerImpl.getInstance().getFileExtention());

		// Set the button types.
		ButtonType saveButtonType = new ButtonType("Carica", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

		// Create the data to show in the CheckListView
		final ObservableList<String> strings = FXCollections.observableArrayList();

		for (File f : files) {
			strings.add(f.getName());
		}

		// Create the CheckListView with the data
		final CheckListView<String> checkListView = new CheckListView<>(strings);
		checkListView.setMaxHeight(150);
		
		// Select all button
		Button selectAll = new Button("Seleziona tutti");
		selectAll.setOnAction(e->{
			checkListView.getCheckModel().checkAll();
		});
		
		// Deselect all button
		Button deselectAll = new Button("Deseleziona tutti");
		deselectAll.setOnAction(e->{
			checkListView.getCheckModel().clearChecks();
		});
		
		// Add contents
		BorderPane bpane = new BorderPane();
		BorderPane topPane = new BorderPane();
		topPane.setLeft(selectAll);
		topPane.setRight(deselectAll);
		
		BorderPane.setMargin(topPane, new Insets(0, 0, 10, 0));


		bpane.setCenter(checkListView);
		bpane.setTop(topPane);
		
		dialog.getDialogPane().setContent(bpane);

		Optional<ButtonType> result = dialog.showAndWait();

		checkListView.getCheckModel().getCheckedIndices().forEach(index ->{			
			selectedFiles.add(files.get(index));
		});


		if (result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE) {
			return selectedFiles;
		} else {
			return new LinkedList<File>();
		}
	}
}
