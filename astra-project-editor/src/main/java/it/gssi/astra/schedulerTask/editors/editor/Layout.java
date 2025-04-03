/*
*@Generated
*/
package it.gssi.astra.schedulerTask.editors.editor;

import Scheduler.SchedulerPackage;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.palette.PaletteGesture;
import it.gssi.astra.metaeditor.common.palette.PaletteImpl;
import it.gssi.astra.schedulerTask.editors.editor.presentation._SchedulerModel;
import it.gssi.astra.metaeditor.common.splashScreen.*;
import it.gssi.astra.metaeditor.common.utility.Validate;
import javafx.stage.Stage;
import it.gssi.astra.metaeditor.common.dataManager.commands.CustomCommandStack;
import it.gssi.astra.metaeditor.common.popup.Search;
import it.gssi.astra.metaeditor.common.popup.Popup;
import it.gssi.astra.metaeditor.common.canvas.ContainerCanvas;
import it.gssi.astra.metaeditor.common.dataManager.fileManager.FileManagerImpl;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;

/* protected region import on begin */
//Import Custom
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import it.gssi.astra.AstraSolver;
/* protected region import end */

public class Layout extends LayoutScene {
	
	private static Layout layoutInstance;
	
	public static Layout getInstance () {
		return layoutInstance;
	}
	
	public Layout(Stage primaryStage) {
	
		this.primaryStage = primaryStage;
		layoutInstance = this;
		this.domainEPackage = SchedulerPackage.eINSTANCE;
		this.srcBasePath = "it.gssi.astra.schedulerTask.editors";
		this.getResourceSet().getPackageRegistry().put(this.domainEPackage.getNsURI(), this.domainEPackage);
		
		final String confPlatformPath = "platform:/resource/astra-project/astra-project-metamodel/model/schedulerConfiguration.xmi";
		final String confBaseFolder = "/model";
		this.setConfInstanceRoot(confPlatformPath, confBaseFolder);
		FileManagerImpl.getInstance().setFile_Extension(this.confInstanceRoot.getModelFileExtension());
		this.setIcon(primaryStage, this.confInstanceRoot.getEditorIconPath());
		
		this.paletteInterface = new PaletteImpl();
		LayoutScene.getInstance().rootFX = new _SchedulerModel();
		this.paletteGesture = new PaletteGesture(this.paletteInterface, this);
		this.paletteInterface.populatePalette(this.paletteGesture,this.getPalette());
		
		Search.setOption(SchedulerPackage.eINSTANCE.getSchedulerModel());
		
		primaryStage.setOnCloseRequest(e -> {
		
			// Chiudere l'editor se non ci sono tab aperte
			if(LayoutScene.getInstance().getWorkspace().getTabs().size()==0) {
				return;
			}
			
			//Controlla se qualche tab non è stata salvata
			boolean saveNeeded = false;
			for(ContainerCanvas canvas: LayoutScene.getInstance().getWorkspace().getAllContainerCanvas()) {
				if(((CustomCommandStack) canvas.getEditingDomain().getCommandStack()).isSaveNeeded()) {
					saveNeeded = true;
					continue;
				}
			}
			
			if(saveNeeded) {
				Boolean result = Popup.question("Salvataggio", "Vuoi salvare prima di chiudere l'editor?");
					
				if(result == null) {
					//Annulla
					e.consume();
					return;
				}
				
				if(result){
					// Si, salva e chiudi
					FileManagerImpl.getInstance().saveAll();
				}
			}
		});
		
	/* protected region init on begin */
	//Init Custom
	SplashScreenController splash = new SplashScreenController("SchedulerModel");
	primaryStage.show();
	
	
	MenuItem solver = new MenuItem();
	solver.setText("Solver");
	solver.setDisable(true);
	solver.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			
			customMenu.saveAll();
			AstraSolver astraSolver = new AstraSolver();
			
			//prendo la root del modello in memoria
			Scheduler.SchedulerModel root = (Scheduler.SchedulerModel)Layout.getInstance().getDomainRoot();
			//
			
			if(astraSolver.solver(root)) {
				Popup.dialog("Solver", "The Scheduler is valid!");
			}else {
				Popup.dialog("Solver", "The Scheduler is not valid!");
			}
			
		}
	});
	
	CustomMenu.getInstance().menuStrumenti.getItems().add(solver);
	/* protected region init end */
		
	}
	
	/* protected region function on begin */
	//Function Custom
	
	
	
	
	
	/* protected region function end */

}
