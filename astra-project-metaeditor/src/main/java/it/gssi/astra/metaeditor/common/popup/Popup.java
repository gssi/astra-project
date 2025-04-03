package it.gssi.astra.metaeditor.common.popup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.gssi.astra.metaeditor.common.LayoutScene;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.FlatAlert;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

/**
 *In this class we find the various methods that are used to create popup such as the popup to view errors
 */
public class Popup {
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage stage) {
		primaryStage = stage;
	}
	
    private static boolean dialog(String title, String subtitle, Alert.AlertType type) {
        
        Alert alert = new Alert(type);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);
        alert.setHeaderText("\n"+title);
        alert.setContentText(subtitle);

        alert.getDialogPane().getStylesheets().add(LayoutScene.class.getResource("/common/stylesheets/application.css").toExternalForm());

        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           return true;
        }  
        return false;
    }
	
    public static boolean dialog(String title, String subtitle) {
        
    	return dialog(title, subtitle,Alert.AlertType.INFORMATION);    	
    }
    
    
    public static boolean warning(String title, String subtitle) {
    	return dialog(title, subtitle,Alert.AlertType.WARNING);
    }
    
    
    public static void showError(String title, String subtitle) {
  	  JMetro jMetro = new JMetro(Style.DARK);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);
        alert.setHeaderText("\n"+title);
  
        TextArea area = new TextArea(subtitle);
        area.setEditable(false);
        area.setWrapText(true);
        jMetro.setScene(alert.getDialogPane().getScene());
        alert.getDialogPane().setContent(area);
        alert.setResizable(true);

        alert.showAndWait();
  }
    
    public static void showErrorNotModal(String title, StringBuilder subtitle) {
    	  JMetro jMetro = new JMetro(Style.DARK);
          
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.initModality(Modality.NONE);
          alert.initOwner(primaryStage);
          alert.setHeaderText("\n"+title);
    
          TextArea area = new TextArea(subtitle.toString());
          area.setEditable(false);
          area.setWrapText(true);
          jMetro.setScene(alert.getDialogPane().getScene());
          alert.getDialogPane().setContent(area);
          alert.setResizable(true);

          alert.showAndWait();
    }

	public static List<String> saveDialog(Node canvas, String extension) {
		FileChooser fileChooser = new FileChooser();
		List<String> paths = new ArrayList<String>();
		Stage stage = (Stage)canvas.getScene().getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		ExtensionFilter extensionFilter = null;
		if (extension != null)
			extensionFilter = new FileChooser.ExtensionFilter("Model", "*."+extension , "*.xmi");
		else 
			extensionFilter = new FileChooser.ExtensionFilter("Model", "*.xmi");
		
		fileChooser.getExtensionFilters().addAll(extensionFilter);
		File  file = fileChooser.showSaveDialog(stage);
		
		if(file != null) {
			paths.add(file.getParentFile().toString());
			paths.add(file.getName());
			return paths;
		}
		return null;
	} 
	
	public static List<String> export(Node node) {
		FileChooser fileChooser = new FileChooser();
		List<String> paths = new ArrayList<String>();
		Stage stage = (Stage)node.getScene().getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		File  file = fileChooser.showSaveDialog(stage);
		if(file != null) {
			paths.add(file.getParentFile().toString());
			paths.add(file.getName());
			return paths; 
			
		}	
		return null;
	}
	
	public static List<String> getEolFile(Node canvas) {
		FileChooser fileChooser = new FileChooser();
		List<String> paths = new ArrayList<String>();
		Stage stage = (Stage)canvas.getScene().getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		ExtensionFilter t = new FileChooser.ExtensionFilter("EOL","*.eol");
		fileChooser.getExtensionFilters().addAll(t);
		File  file = fileChooser.showOpenDialog(stage);
		
		if(file != null) {
			paths.add(file.getParentFile().toString());
			paths.add(file.getName());
			return paths;
		}
		return null;
	} 
		

	public static String chooseDirectory(Node node) {
		
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("Seleziona cartella");
		File selectedDirectory = chooser.showDialog(primaryStage);
		if(selectedDirectory != null) {
			return selectedDirectory.getAbsolutePath();
		}
		return null;
	}
	
	public static List<String> openDialog(Node node, String extension) {
		FileChooser fileChooser = new FileChooser();
		List<String> paths = new ArrayList<String>();
		Stage stage = (Stage)node.getScene().getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		ExtensionFilter t = new FileChooser.ExtensionFilter("Model", "*."+extension);
		fileChooser.getExtensionFilters().addAll(t);
		File  file = fileChooser.showOpenDialog(stage);

		if(file != null) {
			paths.add(file.getParentFile().toString());
			paths.add(file.getName());
			return paths; 
			
		}	
		return null;
	}
	
	public static String openDialogEcore(Node node) {
		FileChooser fileChooser = new FileChooser();
		Stage stage = (Stage)node.getScene().getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ecore Model", "*.ecore"));
		File  file = fileChooser.showOpenDialog(stage);

		if(file != null) {
	
			return file.getParentFile().toString()+File.separator+file.getName(); 
			
		}	
		return null;
	}
	
	public static String openDialogFXML(Scene scene) {
		FileChooser fileChooser = new FileChooser();
		Stage stage = (Stage)scene.getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("FXML File", "*.fxml"));
		File  file = fileChooser.showOpenDialog(stage);

		if(file != null) {
	
			return file.getParentFile().toString()+File.separator+file.getName(); 
			
		}	
		return null;
	}
	
	public static String openDialogImage(Scene scene) {
		FileChooser fileChooser = new FileChooser();
		Stage stage = (Stage)scene.getWindow();
		//fileChooser.setInitialDirectory(new File("model/"));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Icon", "*.png"));
		File  file = fileChooser.showOpenDialog(stage);

		if(file != null) {
	
			return file.getParentFile().toString()+File.separator+file.getName(); 
			
		}	
		return null;
	}

	public static Alert loading() {
        JMetro jMetro = new JMetro(Style.DARK);
        FlatAlert alert = new FlatAlert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);
        alert.setHeaderText("\n"+"Caricamento");
        alert.setContentText("...");

        jMetro.setScene(alert.getDialogPane().getScene());
        
        alert.show();
        
        return alert;
	}
	
	public static Boolean question(String title, String subtitle) {
       
		return question(title, subtitle, true);
	}
	
	public static Boolean question(String title, String subtitle, boolean isCancelable) {
	       
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.getDialogPane().getStylesheets().add(LayoutScene.class.getResource("/common/stylesheets/application.css").toExternalForm());

		dialog.setTitle(title);
		dialog.setHeaderText(subtitle);
		
		ButtonType confirmButtonType = new ButtonType("Si", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(confirmButtonType);
		
		if(isCancelable) {
			ButtonType cancelButtonType = new ButtonType("Annulla", ButtonData.LEFT);
			dialog.getDialogPane().getButtonTypes().add(cancelButtonType);
		}
		
		ButtonType noButtonType = new ButtonType("No", ButtonData.NO);
		dialog.getDialogPane().getButtonTypes().add(noButtonType);
			
        dialog.initOwner(primaryStage);
		
		Optional<ButtonType> result = dialog.showAndWait();

		if (result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE ) {
			return true;
		}else if (result.isPresent() && result.get().getButtonData() == ButtonData.NO ) {
			return false;
		}
		
        return null;
	}
}
