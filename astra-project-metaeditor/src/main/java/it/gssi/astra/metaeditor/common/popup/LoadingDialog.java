package it.gssi.astra.metaeditor.common.popup;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.JMetroStyleClass;
import jfxtras.styles.jmetro.Style;

public class LoadingDialog {

	private final Stage dialogStage;

	private final ProgressBar progressBar = new ProgressBar(-1);
	private final Text label = new Text();

	public LoadingDialog() {

		dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.UTILITY);
		dialogStage.setResizable(false);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.setTitle("Caricamento");

		label.setText("Caricamento...");

		final VBox hb = new VBox();
		hb.getStyleClass().add(JMetroStyleClass.BACKGROUND);
		hb.maxWidth(300);
		hb.setPrefWidth(300);
		hb.setMinHeight(450);
		hb.setSpacing(5);
		hb.setAlignment(Pos.CENTER);

		final HBox hbP = new HBox();
		hb.maxWidth(150);
		hb.setPrefWidth(150);

		hbP.getChildren().add(label);
		hbP.setAlignment(Pos.CENTER_LEFT); 
		hbP.setPrefHeight(50);
		hbP.setPadding(new Insets(0,0,0,10));
		
		hb.getChildren().addAll(hbP, progressBar);
		Scene scene = new Scene(hb,300,100);

		dialogStage.setScene(scene);
		
		JMetro jMetro = new JMetro(Style.DARK);
		jMetro.setScene(scene);
	}
	
	public void show() {
		dialogStage.show();
	}
	
	public void hide() {
		dialogStage.hide();
	}
}