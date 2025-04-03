package it.gssi.astra.metaeditor.common.splashScreen;

import java.io.IOException;

//import org.scenicview.ScenicView;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class SplashScreenController {

	private static final String SPLASHSCREEN_PATH = "/common/SplashScreen.fxml";
	private Stage stage;
	
	@FXML
	ProgressBar progress;
	
    
    private final Font defaultFont = Font.font(30);
	
	
	/**
	 *  Creates and shows the splash screen 
	 */
	public SplashScreenController(String name){
		try {

			// Load the FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource((SPLASHSCREEN_PATH)));

			// Set this class as controller
			loader.setController(this);
			
			
			Scene scene = new Scene(loader.load());

			JMetro jMetro = new JMetro(Style.DARK);
			jMetro.setScene(scene);
			
			// Create a new stage for the splashscreen
			stage = new Stage();
			
			stage.setScene(scene);
			stage.initStyle(StageStyle.TRANSPARENT);
			
			PauseTransition delay = new PauseTransition(Duration.seconds(3));
			delay.setOnFinished( event -> stage.close() );
			delay.play();
			
			// Wait until the stage is closed
			stage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
