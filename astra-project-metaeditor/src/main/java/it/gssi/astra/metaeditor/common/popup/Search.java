package it.gssi.astra.metaeditor.common.popup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class is used to manage the search of {@link DraggableNode} in the canvas
 */
public class Search {
	
	private static Stage primaryStage;
	
	private static ObservableList<String>  option = FXCollections.observableArrayList();
	
	public static void setPrimaryStage(Stage stage) {
		primaryStage = stage;
	}
	
	public static void show() {
		// Create the custom dialog.
		
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Ricerca Elemento");
		dialog.setHeaderText("Ricerca Elemento");
		dialog.getDialogPane().getStylesheets().add(LayoutScene.class.getResource("/common/stylesheets/application.css").toExternalForm());
		dialog.initOwner(primaryStage);
		// Set the icon (must be included in the project).
		//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

		// Set the button types.
		ButtonType saveButtonType = new ButtonType("Cerca", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

		// Create the data labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		ComboBox classe = new ComboBox();
		classe.setItems(option);
		
		TextField identificativo = new TextField();
		identificativo.setPromptText("Identificativo");

		grid.add(new Label("Nome Classe:"), 0, 0);
		grid.add(classe, 1, 0);
		grid.add(new Label("Nome istanza:"), 0, 1);
		grid.add(identificativo, 1, 1);

		// Enable/Disable login button depending on whether a data was entered.
		Node saveButton = dialog.getDialogPane().lookupButton(saveButtonType);
		saveButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		 classe.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {

			saveButton.setDisable(classe.getValue() == null || identificativo.getText().isBlank());
		});

		identificativo.textProperty().addListener((observable, oldValue, newValue) -> {
			
			saveButton.setDisable(classe.getValue() == null || identificativo.getText().isBlank());
		});

		dialog.getDialogPane().setContent(grid);


		Optional<ButtonType> result = dialog.showAndWait();

		if (result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE ) {
			List<DraggableNode> exist = search(classe.getValue().toString(), identificativo.getText(), Color.RED);
			if(exist.isEmpty()) {
				Popup.dialog("Elemento non trovato", "Spiacenti elemento non trovato!!!");
			}
			
		}
		
	}
	
	/**
	 * This function get the root and set in the options of search the name of all classes defined in the domain metamodel 
	 * @param rootClass is the root that contains all the objects within the canvas
	 */
	public static void  setOption(EClass rootClass) {
		
		EClass root_class = rootClass;
		
		
		for (EClassifier e : root_class.getEPackage().getEClassifiers()) {
			if (e instanceof EClass) {
				String name = e.getName();
				option.add(name);
			}
		}
		
		option = option.sorted(Comparator.<String>naturalOrder());

	}
	
	/**
	 * @param classname name of a category to search
	 * @param id represent the identifier of item in the searched category 
	 * @return a list of searched DraggableNode 
	 */
	public static List<DraggableNode> search(String classname, String id) {
		List<DraggableNode> element = new ArrayList<DraggableNode>();
		for (Node node : LayoutScene.getInstance().getCanvas().getChildren()) {
			if(node instanceof DraggableNode) {
				DraggableNode dNode = (DraggableNode) node;	
				if(dNode.getEnte().getMetaClassName().equals(classname) && dNode.getEnte().identifier.get().equals(id)) {
					SelectionModel.add(dNode);
					element.add(dNode);
				}
			}
		}
		return element;
	}
	
	/**
	 * @param classname name of a category to search
	 * @param id represent the identifier of item in the searched category 
	 * @param color represents the color which you want to highlight the searched objects
	 * @return a list of DraggableNodes found
	 */
	public static List<DraggableNode> search(String classname, String id, Color color) {
		List<DraggableNode> element = new ArrayList<DraggableNode>();
		for (Node node : LayoutScene.getInstance().getCanvas().getChildren()) {
			if(node instanceof DraggableNode) {
				DraggableNode dNode = (DraggableNode) node;	
				if(dNode.getEnte().getMetaClassName().equals(classname) && dNode.getEnte().identifier.get().equals(id)) {
					SelectionModel.add(dNode);
					dNode.boundary.setStroke(color);
					for (EObject child : ((EObject)dNode.getEnte().getModel()).eContents()) {
						Ente ente = LayoutScene.getViewModelMap().get(child);
						ente.getDraggableNode().boundary.setStroke(color);
					}
					element.add(dNode);
				}
			}
		}
		return element;
	}
	
	
	/**
	 * @param classname name of a category to search
	 * @param e
	 * @return  a list of searched DraggableNode 
	 * TODO: Da Rinominare
	 */
	public static List<DraggableNode> mySearch(String classname, Map<String,Color> e) {
		List<DraggableNode> element = new ArrayList<DraggableNode>();
		for (Node node : LayoutScene.getInstance().getCanvas().getChildren()) {
			if(node instanceof DraggableNode) {
				DraggableNode dNode = (DraggableNode) node;	
				String id = dNode.getEnte().identifier.get();
				if(dNode.getEnte().getMetaClassName().equals(classname) && e.containsKey(id)) {
					Color col = e.get(id);
					SelectionModel.add(dNode);
					dNode.boundary.setStroke(col);
					Stack<EObject> s = new Stack<>();
					s.addAll(((EObject)dNode.getEnte().getModel()).eContents());
					while(!s.isEmpty()) {
						EObject child = s.pop();
						Ente ente = LayoutScene.getViewModelMap().get(child);
						ente.getDraggableNode().boundary.setStroke(col);
						s.addAll(child.eContents());
					}
					element.add(dNode);
				}
			}
		}
		return element;
	}
	
	/**
	 * 
	 *@deprecated
	 */
	public static List<DraggableNode> search(String className, Map<String,Color> e){
		List<DraggableNode> elements = new ArrayList<DraggableNode>();
		
		for (TreeItem<String> et : LayoutScene.getInstance().treeView.getRoot().getChildren()) {
				if(et.getValue().equals(className)) {
					for (TreeItem<String> entry : et.getChildren()) {
						if (entry instanceof CustomTreeItem) {
							CustomTreeItem customItem = (CustomTreeItem) entry;
							Color obj = e.get(entry.getValue());
							if(obj != null) {
								LayoutScene.getInstance().treeView.getSelectionModel().select(entry);
								customItem.getDraggableNode().boundary.setStroke(obj);
								elements.add(customItem.getDraggableNode());
								for (EObject child : ((EObject)customItem.getDraggableNode().getEnte().getModel()).eContents()) {
									Ente ente = LayoutScene.getViewModelMap().get(child);
									ente.getDraggableNode().boundary.setStroke(obj);
									elements.add(ente.getDraggableNode());
								}
							}
						}
					}
				}
		}
		
		return elements;
	}
	
}
