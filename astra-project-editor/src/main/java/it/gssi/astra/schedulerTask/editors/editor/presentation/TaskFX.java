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
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.magnete.MagneteUtils;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import javafx.scene.control.Label;
/* protected region import end */


/*
*@Generated
*/
public class TaskFX extends Ente {

	@FXML
	public AnchorPoint tick_0_0_Connectable;
	
	@FXML
	public AnchorPoint tick_0_1_Connectable;
	
	@FXML
	public AnchorPoint tick_1_0_Connectable;
	
	@FXML
	public AnchorPoint tick_1_1_Connectable;
	
	@FXML
	public AnchorPoint tick_2_0_Connectable;
	
	@FXML
	public AnchorPoint tick_2_1_Connectable;
	
	@FXML
	public AnchorPoint tick_3_0_Connectable;
	
	@FXML
	public AnchorPoint tick_3_1_Connectable;
	
	@FXML
	public AnchorPoint tick_4_0_Connectable;
	
	@FXML
	public AnchorPoint tick_4_1_Connectable;
	
	@FXML
	public AnchorPoint tick_5_0_Connectable;
	
	@FXML
	public AnchorPoint tick_5_1_Connectable;
	
	@FXML
	public AnchorPoint tick_6_0_Connectable;
	
	@FXML
	public AnchorPoint tick_6_1_Connectable;
	
	@FXML
	public AnchorPoint tick_7_0_Connectable;
	
	@FXML
	public AnchorPoint tick_7_1_Connectable;
	
	@FXML
	public AnchorPoint tick_8_0_Connectable;
	
	@FXML
	public AnchorPoint tick_8_1_Connectable;
	
	@FXML
	public AnchorPoint tick_9_0_Connectable;
	
	@FXML
	public AnchorPoint tick_9_1_Connectable;
	
	@FXML
	public AnchorPoint tick_10_0_Connectable;
	
	@FXML
	public AnchorPoint tick_10_1_Connectable;
	
	@FXML
	public AnchorPoint tick_11_0_Connectable;
	
	@FXML
	public AnchorPoint tick_11_1_Connectable;
	
	@FXML
	public AnchorPoint tick_12_0_Connectable;
	
	@FXML
	public AnchorPoint tick_12_1_Connectable;
	
	@FXML
	public AnchorPoint tick_13_0_Connectable;
	
	@FXML
	public AnchorPoint tick_13_1_Connectable;
	
	@FXML
	public AnchorPoint tick_14_0_Connectable;
	
	@FXML
	public AnchorPoint tick_14_1_Connectable;
	
	@FXML
	public AnchorPoint tick_15_0_Connectable;
	
	@FXML
	public AnchorPoint tick_15_1_Connectable;
	
	@FXML
	public AnchorPoint tick_16_0_Connectable;
	
	
	private Task model = null;
	
	private BackedCustomPropertyItem name_item;
	private BackedCustomPropertyItem priority_item;
	private BackedCustomPropertyItem following_item;
	private BackedCustomPropertyItem duration_item;

	/* protected region declaration on begin */
	//Declaration Custom
	
	@FXML
	Label nameTask;
	
	@FXML
	Label priority;
	/* protected region declaration end */

	/*
	*@Generated
	*/
	public TaskFX(Task model, ElementPosition elementPosition, GraphicalElement graphicalElement) {

		super(String.valueOf(model.getName()));
		
		this.model = model;
		this.elementPosition = elementPosition;
		this.graphicalElement = graphicalElement;
		
		fxmlLoader = FXMLUtil.loadFXML(this, getFxmlPath());
		
		initializeAnchorPoints();
		
		this.allowedRotationPositions.addAll(this.graphicalElement.getRotationPositions());
		
		this.name_item = new BackedCustomPropertyItem(this.model, "Properties", "name", true);
		this.priority_item = new BackedCustomPropertyItem(this.model, "Properties", "priority", true);
		this.following_item = new BackedCustomPropertyItem(this.model, "Properties", "following", true);
		this.duration_item = new BackedCustomPropertyItem(this.model, "Properties", "duration", true);
		
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
		properties.add(this.priority_item);

		ObservableList<Option> allfollowing = FXCollections.observableArrayList();
		
		iterator = this.model.eResource().getAllContents();
		while (iterator.hasNext()) {
			EObject obj = (EObject) iterator.next();
		
			if(obj instanceof Task){
				allfollowing.add(new ReferencePropertyValue(((Task)obj).getName(),obj));
			}
		}
		
		this.following_item.setPayload(allfollowing);
		properties.add(this.following_item);
		
		properties.add(this.duration_item);

		
		/******* references (anchor points) *******/
		
		properties.add(magnetizable);
		
		/* protected region custom_properties on begin */
		//Custom properties
		this.setPinned(true);
		/* protected region custom_properties end */

		// Update PropertySheet view
		LayoutScene.getInstance().propertySheet.getItems().clear();
		LayoutScene.getInstance().propertySheet.getItems().addAll(properties);
	}
	
	public void createActs(){
	
		ElementPosition eacts = MetaEditorPersistenceFactory.eINSTANCE.createElementPosition();
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.add(LayoutScene.getInstance().getRootPersistence(), MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(), eacts);
		
		ACT acts = SchedulerFactory.eINSTANCE.createACT();			
		eacts.setElement(acts);
		
		LayoutScene.getAllElementPositions().put(acts, eacts);
		
		emfCommand.add(this.model, this.model.eClass().getEStructuralFeature("acts"), acts);
		
		eacts.setX((int)this.elementPosition.getX());
		eacts.setY((int)this.elementPosition.getY());
		eacts.setZ(0);
			
		ACTFX node_ACT = (ACTFX) LayoutScene.getViewModelMap().get(acts);
		IntStream.range(0,1).forEach(i -> node_ACT.createStart());
		IntStream.range(0,1).forEach(i -> node_ACT.createEnd());
			
		/* protected region actscustom_pos on begin */
		//Call behaviour custom
		eacts.setX(eacts.getX()+150);
		TaskTableFX padre = (TaskTableFX) LayoutScene.getViewModelMap().get(this.model.eContainer());
		if(padre.getModel().getTasks().size() == 1) {
			eacts.setY((int)padre.getDraggableNode().getLayoutY()+ 135);
		}else {
			Ente lastRow =  LayoutScene.getViewModelMap().get(padre.getModel().getTasks().get(padre.getModel().getTasks().size()-2));
			eacts.setY((int)(lastRow.getDraggableNode().getLayoutY()+ 45));
		}
//		nameTask.setText(eacts.getName());
		
//		LayoutScene.getViewModelMap().get(eacts).getDraggableNode().setSelected(true);
		/* protected region actscustom_pos end */
	}	
	
	public void createMenu() {
		this.contextMenu.getNewChild().setDisable(false);
		
		MenuItem menuActs = new MenuItem("Inserisci acts");  
		this.contextMenu.getNewChild().getItems().addAll(menuActs);
	
		/******* references (containment) ********/
		
		menuActs.setId("menuActs");
		menuActs.setOnAction((event) -> {
			EMFCommands emfCommand = new EMFCommands();
			emfCommand.begin();
			createActs();
			emfCommand.end();
		});
		
		this.contextMenu.getItems().remove(menuActs);

		/* protected region customizeMenu on begin */
		//Customize menu options
		/* protected region customizeMenu end */
	}
		
	@Override
	public void initialization() {
		
		super.initialization();
		
		EObject eObjectPadre = this.model.eContainer();
		Ente padreFX = LayoutScene.getViewModelMap().get(eObjectPadre);
			
		padreFX.getDraggableNode().selectedProperty().addListener(getDraggableNode().selectWithParentListener);

		/****** Generic attributes ******/
		
		onNameChanged(this.model.getName());
	
		onPriorityChanged(this.model.getPriority());
	
		onDurationChanged(this.model.getDuration());
	
		/* protected region init_custom on begin */
			//Call behaviour custom
		this.setAnchorPointVisibility(true);
		/* protected region init_custom end */
	}
		
	/****** Generic attributes ******/
	
	public void onNameChanged(Object value) {
		
		setIdentifier(this.model.getName());

		/* protected region namecall_behaviour on begin */
		//Call behaviour custom
		this.model.setName(String.valueOf(value));
		nameTask.setText(this.model.getName());
		/* protected region namecall_behaviour end */
	}
		
	
	public void onPriorityChanged(Object value) {
		

		/* protected region prioritycall_behaviour on begin */
		//Call behaviour custom
		this.model.setPriority((int) value);
		priority.setText(String.valueOf(value));
		/* protected region prioritycall_behaviour end */
	}
		
	
	public void onDurationChanged(Object value) {
		

		/* protected region durationcall_behaviour on begin */
		//Call behaviour custom
		/* protected region durationcall_behaviour end */
	}
		
	
	
		
	/****** references (upperBound=1) ******/
	
			
	/******* references (upperBound=-1) ********/
	
	public void onFollowingChanged(Object value) {
	
		/* protected region followingcall_behaviour on begin */
		//Call behaviour custom
		/* protected region followingcall_behaviour end */
	}
	public void onActsChanged(Object value) {
	
		/* protected region actscall_behaviour on begin */
		//Call behaviour custom
		/* protected region actscall_behaviour end */
	}
		
	
	public Task getModel() {
		return model;
	}
	
	@Override
	public List<AnchorPoint> getAnchorPoints() {

		List<AnchorPoint> data = new ArrayList<AnchorPoint>();

		if (tick_0_0_Connectable != null) {
			data.add(tick_0_0_Connectable);
		}
		
		if (tick_0_1_Connectable != null) {
			data.add(tick_0_1_Connectable);
		}
		
		if (tick_1_0_Connectable != null) {
			data.add(tick_1_0_Connectable);
		}
		
		if (tick_1_1_Connectable != null) {
			data.add(tick_1_1_Connectable);
		}
		
		if (tick_2_0_Connectable != null) {
			data.add(tick_2_0_Connectable);
		}
		
		if (tick_2_1_Connectable != null) {
			data.add(tick_2_1_Connectable);
		}
		
		if (tick_3_0_Connectable != null) {
			data.add(tick_3_0_Connectable);
		}
		
		if (tick_3_1_Connectable != null) {
			data.add(tick_3_1_Connectable);
		}
		
		if (tick_4_0_Connectable != null) {
			data.add(tick_4_0_Connectable);
		}
		
		if (tick_4_1_Connectable != null) {
			data.add(tick_4_1_Connectable);
		}
		
		if (tick_5_0_Connectable != null) {
			data.add(tick_5_0_Connectable);
		}
		
		if (tick_5_1_Connectable != null) {
			data.add(tick_5_1_Connectable);
		}
		
		if (tick_6_0_Connectable != null) {
			data.add(tick_6_0_Connectable);
		}
		
		if (tick_6_1_Connectable != null) {
			data.add(tick_6_1_Connectable);
		}
		
		if (tick_7_0_Connectable != null) {
			data.add(tick_7_0_Connectable);
		}
		
		if (tick_7_1_Connectable != null) {
			data.add(tick_7_1_Connectable);
		}
		
		if (tick_8_0_Connectable != null) {
			data.add(tick_8_0_Connectable);
		}
		
		if (tick_8_1_Connectable != null) {
			data.add(tick_8_1_Connectable);
		}
		
		if (tick_9_0_Connectable != null) {
			data.add(tick_9_0_Connectable);
		}
		
		if (tick_9_1_Connectable != null) {
			data.add(tick_9_1_Connectable);
		}
		
		if (tick_10_0_Connectable != null) {
			data.add(tick_10_0_Connectable);
		}
		
		if (tick_10_1_Connectable != null) {
			data.add(tick_10_1_Connectable);
		}
		
		if (tick_11_0_Connectable != null) {
			data.add(tick_11_0_Connectable);
		}
		
		if (tick_11_1_Connectable != null) {
			data.add(tick_11_1_Connectable);
		}
		
		if (tick_12_0_Connectable != null) {
			data.add(tick_12_0_Connectable);
		}
		
		if (tick_12_1_Connectable != null) {
			data.add(tick_12_1_Connectable);
		}
		
		if (tick_13_0_Connectable != null) {
			data.add(tick_13_0_Connectable);
		}
		
		if (tick_13_1_Connectable != null) {
			data.add(tick_13_1_Connectable);
		}
		
		if (tick_14_0_Connectable != null) {
			data.add(tick_14_0_Connectable);
		}
		
		if (tick_14_1_Connectable != null) {
			data.add(tick_14_1_Connectable);
		}
		
		if (tick_15_0_Connectable != null) {
			data.add(tick_15_0_Connectable);
		}
		
		if (tick_15_1_Connectable != null) {
			data.add(tick_15_1_Connectable);
		}
		
		if (tick_16_0_Connectable != null) {
			data.add(tick_16_0_Connectable);
		}
		
		return data;
	}

	@Override
	public Map<AnchorPoint, List<AnchorPoint>> getTargetAnchorPointsSet() {

		Map<AnchorPoint, List<AnchorPoint>> data = new HashMap<>();

		if (tick_0_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_0_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_0_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_0_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_0_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_0_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_1_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_1_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_1_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_1_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_1_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_1_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_2_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_2_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_2_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_2_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_2_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_2_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_3_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_3_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_3_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_3_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_3_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_3_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_4_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_4_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_4_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_4_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_4_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_4_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_5_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_5_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_5_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_5_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_5_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_5_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_6_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_6_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_6_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_6_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_6_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_6_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_7_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_7_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_7_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_7_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_7_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_7_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_8_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_8_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_8_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_8_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_8_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_8_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_9_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_9_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_9_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_9_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_9_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_9_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_10_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_10_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_10_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_10_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_10_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_10_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_11_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_11_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_11_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_11_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_11_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_11_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_12_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_12_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_12_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_12_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_12_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_12_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_13_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_13_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_13_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_13_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_13_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_13_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_14_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_14_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_14_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_14_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_14_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_14_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_15_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_15_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_15_0_Connectable.getCompatibleTargets()));
		}
		
		if (tick_15_1_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_15_1_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_15_1_Connectable.getCompatibleTargets()));
		}
		
		if (tick_16_0_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {};
			data.put(tick_16_0_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, tick_16_0_Connectable.getCompatibleTargets()));
		}
		
		return data;
	}

	@Override
	public AnchorPoint getAnchorPointByTarget(Ente enteTarget) {

		if (tick_0_0_Connectable != null)
			if (tick_0_0_Connectable.getTarget() == null)
				return tick_0_0_Connectable;
				
		if (tick_0_1_Connectable != null)
			if (tick_0_1_Connectable.getTarget() == null)
				return tick_0_1_Connectable;
				
		if (tick_1_0_Connectable != null)
			if (tick_1_0_Connectable.getTarget() == null)
				return tick_1_0_Connectable;
				
		if (tick_1_1_Connectable != null)
			if (tick_1_1_Connectable.getTarget() == null)
				return tick_1_1_Connectable;
				
		if (tick_2_0_Connectable != null)
			if (tick_2_0_Connectable.getTarget() == null)
				return tick_2_0_Connectable;
				
		if (tick_2_1_Connectable != null)
			if (tick_2_1_Connectable.getTarget() == null)
				return tick_2_1_Connectable;
				
		if (tick_3_0_Connectable != null)
			if (tick_3_0_Connectable.getTarget() == null)
				return tick_3_0_Connectable;
				
		if (tick_3_1_Connectable != null)
			if (tick_3_1_Connectable.getTarget() == null)
				return tick_3_1_Connectable;
				
		if (tick_4_0_Connectable != null)
			if (tick_4_0_Connectable.getTarget() == null)
				return tick_4_0_Connectable;
				
		if (tick_4_1_Connectable != null)
			if (tick_4_1_Connectable.getTarget() == null)
				return tick_4_1_Connectable;
				
		if (tick_5_0_Connectable != null)
			if (tick_5_0_Connectable.getTarget() == null)
				return tick_5_0_Connectable;
				
		if (tick_5_1_Connectable != null)
			if (tick_5_1_Connectable.getTarget() == null)
				return tick_5_1_Connectable;
				
		if (tick_6_0_Connectable != null)
			if (tick_6_0_Connectable.getTarget() == null)
				return tick_6_0_Connectable;
				
		if (tick_6_1_Connectable != null)
			if (tick_6_1_Connectable.getTarget() == null)
				return tick_6_1_Connectable;
				
		if (tick_7_0_Connectable != null)
			if (tick_7_0_Connectable.getTarget() == null)
				return tick_7_0_Connectable;
				
		if (tick_7_1_Connectable != null)
			if (tick_7_1_Connectable.getTarget() == null)
				return tick_7_1_Connectable;
				
		if (tick_8_0_Connectable != null)
			if (tick_8_0_Connectable.getTarget() == null)
				return tick_8_0_Connectable;
				
		if (tick_8_1_Connectable != null)
			if (tick_8_1_Connectable.getTarget() == null)
				return tick_8_1_Connectable;
				
		if (tick_9_0_Connectable != null)
			if (tick_9_0_Connectable.getTarget() == null)
				return tick_9_0_Connectable;
				
		if (tick_9_1_Connectable != null)
			if (tick_9_1_Connectable.getTarget() == null)
				return tick_9_1_Connectable;
				
		if (tick_10_0_Connectable != null)
			if (tick_10_0_Connectable.getTarget() == null)
				return tick_10_0_Connectable;
				
		if (tick_10_1_Connectable != null)
			if (tick_10_1_Connectable.getTarget() == null)
				return tick_10_1_Connectable;
				
		if (tick_11_0_Connectable != null)
			if (tick_11_0_Connectable.getTarget() == null)
				return tick_11_0_Connectable;
				
		if (tick_11_1_Connectable != null)
			if (tick_11_1_Connectable.getTarget() == null)
				return tick_11_1_Connectable;
				
		if (tick_12_0_Connectable != null)
			if (tick_12_0_Connectable.getTarget() == null)
				return tick_12_0_Connectable;
				
		if (tick_12_1_Connectable != null)
			if (tick_12_1_Connectable.getTarget() == null)
				return tick_12_1_Connectable;
				
		if (tick_13_0_Connectable != null)
			if (tick_13_0_Connectable.getTarget() == null)
				return tick_13_0_Connectable;
				
		if (tick_13_1_Connectable != null)
			if (tick_13_1_Connectable.getTarget() == null)
				return tick_13_1_Connectable;
				
		if (tick_14_0_Connectable != null)
			if (tick_14_0_Connectable.getTarget() == null)
				return tick_14_0_Connectable;
				
		if (tick_14_1_Connectable != null)
			if (tick_14_1_Connectable.getTarget() == null)
				return tick_14_1_Connectable;
				
		if (tick_15_0_Connectable != null)
			if (tick_15_0_Connectable.getTarget() == null)
				return tick_15_0_Connectable;
				
		if (tick_15_1_Connectable != null)
			if (tick_15_1_Connectable.getTarget() == null)
				return tick_15_1_Connectable;
				
		if (tick_16_0_Connectable != null)
			if (tick_16_0_Connectable.getTarget() == null)
				return tick_16_0_Connectable;
				
		return null;
	}

	
	private void initializeAnchorPoints() {
		try {
			if (tick_0_0_Connectable != null) {
				tick_0_0_Connectable.setType("tick_0_0_connectable");
				tick_0_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_0_1_Connectable != null) {
				tick_0_1_Connectable.setType("tick_0_1_connectable");
				tick_0_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_1_0_Connectable != null) {
				tick_1_0_Connectable.setType("tick_1_0_connectable");
				tick_1_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_1_1_Connectable != null) {
				tick_1_1_Connectable.setType("tick_1_1_connectable");
				tick_1_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_2_0_Connectable != null) {
				tick_2_0_Connectable.setType("tick_2_0_connectable");
				tick_2_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_2_1_Connectable != null) {
				tick_2_1_Connectable.setType("tick_2_1_connectable");
				tick_2_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_3_0_Connectable != null) {
				tick_3_0_Connectable.setType("tick_3_0_connectable");
				tick_3_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_3_1_Connectable != null) {
				tick_3_1_Connectable.setType("tick_3_1_connectable");
				tick_3_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_4_0_Connectable != null) {
				tick_4_0_Connectable.setType("tick_4_0_connectable");
				tick_4_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_4_1_Connectable != null) {
				tick_4_1_Connectable.setType("tick_4_1_connectable");
				tick_4_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_5_0_Connectable != null) {
				tick_5_0_Connectable.setType("tick_5_0_connectable");
				tick_5_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_5_1_Connectable != null) {
				tick_5_1_Connectable.setType("tick_5_1_connectable");
				tick_5_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_6_0_Connectable != null) {
				tick_6_0_Connectable.setType("tick_6_0_connectable");
				tick_6_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_6_1_Connectable != null) {
				tick_6_1_Connectable.setType("tick_6_1_connectable");
				tick_6_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_7_0_Connectable != null) {
				tick_7_0_Connectable.setType("tick_7_0_connectable");
				tick_7_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_7_1_Connectable != null) {
				tick_7_1_Connectable.setType("tick_7_1_connectable");
				tick_7_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_8_0_Connectable != null) {
				tick_8_0_Connectable.setType("tick_8_0_connectable");
				tick_8_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_8_1_Connectable != null) {
				tick_8_1_Connectable.setType("tick_8_1_connectable");
				tick_8_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_9_0_Connectable != null) {
				tick_9_0_Connectable.setType("tick_9_0_connectable");
				tick_9_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_9_1_Connectable != null) {
				tick_9_1_Connectable.setType("tick_9_1_connectable");
				tick_9_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_10_0_Connectable != null) {
				tick_10_0_Connectable.setType("tick_10_0_connectable");
				tick_10_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_10_1_Connectable != null) {
				tick_10_1_Connectable.setType("tick_10_1_connectable");
				tick_10_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_11_0_Connectable != null) {
				tick_11_0_Connectable.setType("tick_11_0_connectable");
				tick_11_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_11_1_Connectable != null) {
				tick_11_1_Connectable.setType("tick_11_1_connectable");
				tick_11_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_12_0_Connectable != null) {
				tick_12_0_Connectable.setType("tick_12_0_connectable");
				tick_12_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_12_1_Connectable != null) {
				tick_12_1_Connectable.setType("tick_12_1_connectable");
				tick_12_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_13_0_Connectable != null) {
				tick_13_0_Connectable.setType("tick_13_0_connectable");
				tick_13_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_13_1_Connectable != null) {
				tick_13_1_Connectable.setType("tick_13_1_connectable");
				tick_13_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_14_0_Connectable != null) {
				tick_14_0_Connectable.setType("tick_14_0_connectable");
				tick_14_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_14_1_Connectable != null) {
				tick_14_1_Connectable.setType("tick_14_1_connectable");
				tick_14_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_15_0_Connectable != null) {
				tick_15_0_Connectable.setType("tick_15_0_connectable");
				tick_15_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_15_1_Connectable != null) {
				tick_15_1_Connectable.setType("tick_15_1_connectable");
				tick_15_1_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
			if (tick_16_0_Connectable != null) {
				tick_16_0_Connectable.setType("tick_16_0_connectable");
				tick_16_0_Connectable.setCompatibleTargets(Arrays.asList(
                                      ));
			}
			
		} catch(NullPointerException e) {
			System.err.println("TaskFX: initializeAnchorPoints() error.");
		}
	}
	
	@Override
	public void synchronizeAnchorPoints() {
		try {
			// L'anchorPoint tick_0_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_0_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_1_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_1_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_2_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_2_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_3_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_3_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_4_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_4_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_5_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_5_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_6_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_6_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_7_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_7_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_8_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_8_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_9_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_9_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_10_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_10_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_11_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_11_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_12_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_12_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_13_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_13_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_14_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_14_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_15_0_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_15_1_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint tick_16_0_Connectable non ha una ref associata e quindi non si fa nessun binding
		} catch(NullPointerException e) {
			System.err.println("TaskFX: AnchorPoint not found on FXML.");
		}
	}
	
	/* protected region behavior on begin */
	//Behavior Custom
	/* protected region behavior end */
}
