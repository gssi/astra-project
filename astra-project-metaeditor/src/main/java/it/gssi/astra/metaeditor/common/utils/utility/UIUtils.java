package  it.gssi.astra.metaeditor.common.utils.utility;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class UIUtils {
	
	public static void switchScene(Parent fromController, Parent toController) {
		
		Stage stage = (Stage) fromController.getScene().getWindow();
		
		Scene toScene = new Scene(toController);
		
		//JMetro style
		JMetro jMetro = new JMetro(Style.LIGHT);
		jMetro.setScene(toScene);
		
		stage.setScene(toScene);
	}

}
