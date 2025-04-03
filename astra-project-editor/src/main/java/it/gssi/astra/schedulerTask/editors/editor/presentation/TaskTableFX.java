/*
*@Generated
*/
package it.gssi.astra.schedulerTask.editors.editor.presentation;

import java.util.stream.IntStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.common.util.TreeIterator;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;

import it.gssi.astra.metaeditor.common.property.ReferencePropertyValue;
import it.gssi.astra.metaeditor.common.property.UnbackedCustomPropertyItem;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeItem;
import it.gssi.astra.metaeditor.common.property.BackedCustomPropertyItem;
import it.gssi.astra.metaeditor.common.property.EnumeratorPropertyValue;
import it.gssi.astra.metaeditor.common.property.Option;

import Scheduler.*;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.property.PropertyViewUtils;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import it.gssi.astra.metaeditor.common.ente.Pivot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.RotationPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.AddCommand;
import it.gssi.astra.metaeditor.common.canvas.Canvas;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;

/* protected region import on begin */
//Import Custom
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/* protected region import end */


/*
*@Generated
*/
public class TaskTableFX extends Ente {

	
	private TableTask model = null;
	
	private BackedCustomPropertyItem name_item;

	/* protected region declaration on begin */
	//Declaration Custom
	@FXML
	Label core;
	/* protected region declaration end */

	/*
	*@Generated
	*/
	public TaskTableFX(TableTask model, ElementPosition elementPosition, GraphicalElement graphicalElement) {

		super(String.valueOf(model.getName()));
		
		this.model = model;
		this.elementPosition = elementPosition;
		this.graphicalElement = graphicalElement;
		
		fxmlLoader = FXMLUtil.loadFXML(this, getFxmlPath());
		
		
		this.allowedRotationPositions.addAll(this.graphicalElement.getRotationPositions());
		
		this.name_item = new BackedCustomPropertyItem(this.model, "Properties", "name", true);
		
		/* protected region initializations on begin */
		//Initializations Custom
		/* protected region initializations end */	
	}
	
	/*
	*@Generated
	*/
	@Override
	public void populatePropertyView() {
		
		super.populatePropertyView();
	
		TreeIterator<?> iterator;
		
		
		properties.add(this.name_item);

		
		/* protected region custom_properties on begin */
		//Custom properties
		/* protected region custom_properties end */

		// Update PropertySheet view
		LayoutScene.getInstance().propertySheet.getItems().clear();
		LayoutScene.getInstance().propertySheet.getItems().addAll(properties);
	}
	
	public void createTasks(){
	
		ElementPosition etasks = MetaEditorPersistenceFactory.eINSTANCE.createElementPosition();
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.add(LayoutScene.getInstance().getRootPersistence(), MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(), etasks);
		
		Task tasks = SchedulerFactory.eINSTANCE.createTask();			
		etasks.setElement(tasks);
		
		LayoutScene.getAllElementPositions().put(tasks, etasks);
		
		emfCommand.add(this.model, this.model.eClass().getEStructuralFeature("tasks"), tasks);
		
		etasks.setX((int)this.elementPosition.getX());
		etasks.setY((int)this.elementPosition.getY());
		etasks.setZ(0);
			
		TaskFX node_Task = (TaskFX) LayoutScene.getViewModelMap().get(tasks);
		IntStream.range(0,1).forEach(i -> node_Task.createActs());
			
		/* protected region taskscustom_pos on begin */
		//Call behaviour custom
		if(this.model.getTasks().size() == 1) {
			node_Task.getDraggableNode().setLayoutY(this.getDraggableNode().getLayoutY()+120);
		}else {
			Ente lastRow =  LayoutScene.getViewModelMap().get(this.model.getTasks().get(this.model.getTasks().size()-2));
			node_Task.getDraggableNode().setLayoutY(lastRow.getDraggableNode().getLayoutY()+ 30);
		}
		node_Task.getDraggableNode().setSelected(true);
		/* protected region taskscustom_pos end */
	}	
	
	public void createMenu() {
		this.contextMenu.getNewChild().setDisable(false);
		
		MenuItem menuTasks = new MenuItem("Inserisci tasks");  
		this.contextMenu.getNewChild().getItems().addAll(menuTasks);
	
		/******* references (containment) ********/
		
		menuTasks.setId("menuTasks");
		menuTasks.setOnAction((event) -> {
			EMFCommands emfCommand = new EMFCommands();
			emfCommand.begin();
			createTasks();
			emfCommand.end();
		});
		
		this.contextMenu.getItems().remove(menuTasks);

		/* protected region customizeMenu on begin */
		//Customize menu options
		/* protected region customizeMenu end */
	}
		
	@Override
	public void initialization() {
		
		super.initialization();
		

		/****** Generic attributes ******/
		
		onNameChanged(this.model.getName());
	
		/* protected region init_custom on begin */
			//Call behaviour custom
		
		SchedulerModel padre = (SchedulerModel) LayoutScene.getInstance().getResource().getAllContents().next();
		
		core.setText("Core: "+ (String.valueOf(padre.getTableTask().indexOf(this.getModel()))));
		
		EventHandler<MouseEvent> nodeClicked = new EventHandler<MouseEvent>(){
	        @Override
	        public void handle(MouseEvent event) {
	            for (EObject  e : model.getTasks()) {
	            	Ente ente = LayoutScene.getViewModelMap().get(e);
	            	ente.setPinned(false);
				}
	        }
		};
		this.getDraggableNode().setOnMouseClicked(nodeClicked);
		/* protected region init_custom end */
	}
		
	/****** Generic attributes ******/
	
	public void onNameChanged(Object value) {
		
		setIdentifier(this.model.getName());

		/* protected region namecall_behaviour on begin */
		//Call behaviour custom
		/* protected region namecall_behaviour end */
	}
		
	
	
		
	/****** references (upperBound=1) ******/
	
			
	/******* references (upperBound=-1) ********/
	
	public void onTasksChanged(Object value) {
	
		/* protected region taskscall_behaviour on begin */
		//Call behaviour custom
		/* protected region taskscall_behaviour end */
	}
		
	
	public TableTask getModel() {
		return model;
	}
	
	
	
	
	/* protected region behavior on begin */
	//Behavior Custom
	/* protected region behavior end */
}
