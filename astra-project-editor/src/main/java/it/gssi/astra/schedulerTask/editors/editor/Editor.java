package it.gssi.astra.schedulerTask.editors.editor;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.utility.*;
import it.gssi.astra.metaeditor.common.popup.Popup;
import it.gssi.astra.metaeditor.common.popup.Search;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Editor extends Application {

	Stage primaryStage;

	public LayoutScene root;

	@Override
	public void start(Stage primaryStage) {
		EditorProperties.init();
		primaryStage.setTitle("Editor");
		
		/* protected region main on begin */
		//Init main
		root = new Layout(primaryStage);
		/* protected region main end */
	
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
        Popup.setPrimaryStage(primaryStage);
		Search.setPrimaryStage(primaryStage);       
	}

	public static void main(String[] args) {
		launch(args);
	}
}