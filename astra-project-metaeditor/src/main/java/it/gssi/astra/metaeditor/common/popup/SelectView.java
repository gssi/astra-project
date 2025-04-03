package it.gssi.astra.metaeditor.common.popup;

import it.gssi.astra.metaeditor.common.property.ReferencePropertyValue;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;


/**
 * 
 * Manage a multiple select view is currently unused
 *
 */
public class SelectView extends Pane{
	
	
	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String ENTE_NAME_FXML = EditorProperties.get("selectView.fxml");

    @FXML
    private ListView<ReferencePropertyValue> choices;

    @FXML
    private ListView<ReferencePropertyValue> feature;
    
    ObservableList<ReferencePropertyValue> choicesItem;
    ObservableList<ReferencePropertyValue> featureItem;
    
    private Stage newWindow;
    
    private Scene secondScene;
    
	public SelectView(ObservableList<ReferencePropertyValue> listOpition , ObservableList<ReferencePropertyValue> listOpitionSelected) {
	
		FXMLUtil.loadFXML(this, BASE_PATH_FXML + ENTE_NAME_FXML);
		choicesItem = choices.getSelectionModel().getSelectedItems();
		featureItem = feature.getSelectionModel().getSelectedItems();
		
		choices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		feature.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		choices.getItems().addAll(listOpition);
		feature.getItems().addAll(listOpitionSelected);
		secondScene = new Scene(this);
         // New window (Stage)
        newWindow = new Stage();
        newWindow.setTitle("Choice");
        newWindow.setScene(secondScene);
         // Set position of second window, related to primary window.
        newWindow.setX(200);
        newWindow.setY(100);
        newWindow.setResizable(false);
        newWindow.showAndWait();
	}
	
	public void ShowView() {
		
		choicesItem = choices.getSelectionModel().getSelectedItems();
		featureItem = feature.getSelectionModel().getSelectedItems();
		
		choices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		feature.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         // New window (Stage)
        newWindow = new Stage();
        newWindow.setTitle("Choice");
        newWindow.setScene(secondScene);
         // Set position of second window, related to primary window.
        newWindow.setX(200);
        newWindow.setY(100);
        newWindow.setResizable(false);
        newWindow.showAndWait();
	}
	
    @FXML
    void add(ActionEvent event) {
    	feature.getItems().addAll(choicesItem);
    	choices.getItems().removeAll(choicesItem);
    }
    
   
	public ObservableList<ReferencePropertyValue> getFeatureItem() {
		return feature.getItems();
	}
    
    @FXML
    void remove(ActionEvent event) {
    	choices.getItems().addAll(featureItem);
    	feature.getItems().removeAll(featureItem);	
    }
    @FXML
    void select(ActionEvent event) {
    	newWindow.close();
    }
	

}
