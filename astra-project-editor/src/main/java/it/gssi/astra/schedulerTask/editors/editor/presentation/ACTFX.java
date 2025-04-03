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
import it.gssi.astra.metaeditor.common.ente.EnteBendable;
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
import javafx.scene.paint.Color;
import it.gssi.astra.metaeditor.common.magnete.Magnete;
import javafx.collections.ListChangeListener;
import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
/* protected region import end */


/*
*@Generated
*/
public class ACTFX extends EnteBendable {

	@FXML
	public AnchorPoint task_sx_Connectable;
	
	@FXML
	public AnchorPoint task_dx_Connectable;
	
	
	private ACT model = null;
	
	private BackedCustomPropertyItem name_item;
	private BackedCustomPropertyItem period_item;

	/* protected region declaration on begin */
	//Declaration Custom
	/* protected region declaration end */

	/*
	*@Generated
	*/
	public ACTFX(ACT model, ElementPosition elementPosition, GraphicalElement graphicalElement) {

		super(String.valueOf(model.getName()));
		
		this.model = model;
		this.elementPosition = elementPosition;
		this.graphicalElement = graphicalElement;
		
		fxmlLoader = FXMLUtil.loadFXML(this, getFxmlPath());
		
		initializeAnchorPoints();
		
		this.allowedRotationPositions.addAll(this.graphicalElement.getRotationPositions());
		
		this.name_item = new BackedCustomPropertyItem(this.model, "Properties", "name", true);
		this.period_item = new BackedCustomPropertyItem(this.model, "Properties", "period", true);
		
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
		properties.add(this.period_item);

		
		/******* references (anchor points) *******/
		
		properties.add(magnetizable);
		
		/* protected region custom_properties on begin */
		//Custom properties
		/* protected region custom_properties end */

		// Update PropertySheet view
		LayoutScene.getInstance().propertySheet.getItems().clear();
		LayoutScene.getInstance().propertySheet.getItems().addAll(properties);
	}
	
	public void createStart(){
	
		ElementPosition estart = MetaEditorPersistenceFactory.eINSTANCE.createElementPosition();
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.add(LayoutScene.getInstance().getRootPersistence(), MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(), estart);
		
		Tick start = SchedulerFactory.eINSTANCE.createTick();			
		estart.setElement(start);
		
		LayoutScene.getAllElementPositions().put(start, estart);
		
		emfCommand.set(this.model, this.model.eClass().getEStructuralFeature("start"), start);
		
		estart.setX((int)this.elementPosition.getX());
		estart.setY((int)this.elementPosition.getY());
		estart.setZ(0);
			
		/* protected region startcustom_pos on begin */
		//Call behaviour custom
		/* protected region startcustom_pos end */
	}	
	public void createEnd(){
	
		ElementPosition eend = MetaEditorPersistenceFactory.eINSTANCE.createElementPosition();
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.add(LayoutScene.getInstance().getRootPersistence(), MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(), eend);
		
		Tick end = SchedulerFactory.eINSTANCE.createTick();			
		eend.setElement(end);
		
		LayoutScene.getAllElementPositions().put(end, eend);
		
		emfCommand.set(this.model, this.model.eClass().getEStructuralFeature("end"), end);
		
		eend.setX((int)this.elementPosition.getX());
		eend.setY((int)this.elementPosition.getY());
		eend.setZ(0);
			
		/* protected region endcustom_pos on begin */
		//Call behaviour custom
		/* protected region endcustom_pos end */
	}	
	
	public void createMenu() {
		this.contextMenu.getNewChild().setDisable(false);
		
		MenuItem menuStart = new MenuItem("Inserisci start");  
		this.contextMenu.getNewChild().getItems().addAll(menuStart);
		MenuItem menuEnd = new MenuItem("Inserisci end");  
		this.contextMenu.getNewChild().getItems().addAll(menuEnd);
	
		/******* references (containment) ********/
		
		menuStart.setId("menuStart");
		menuStart.setOnAction((event) -> {
			EMFCommands emfCommand = new EMFCommands();
			emfCommand.begin();
			createStart();
			emfCommand.end();
		});
		if(this.model.getStart() != null){
			menuStart.setDisable(true);
		}else{
			menuStart.setDisable(false);
		}
		
		menuEnd.setId("menuEnd");
		menuEnd.setOnAction((event) -> {
			EMFCommands emfCommand = new EMFCommands();
			emfCommand.begin();
			createEnd();
			emfCommand.end();
		});
		if(this.model.getEnd() != null){
			menuEnd.setDisable(true);
		}else{
			menuEnd.setDisable(false);
		}
		
		this.contextMenu.getItems().remove(menuStart);
		this.contextMenu.getItems().remove(menuEnd);

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
	
		onPeriodChanged(this.model.getPeriod());
	
		/* protected region init_custom on begin */
		//Call behaviour custom
		customLine.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
		validate_TopBottom_ConstraintBendPoint();
		disableVertivalDragged();
		disableHorizzontalDragged();
		getTargetAnchorPointSetTick();

		Magnete.connect(this.getDraggableNode());
		/* protected region init_custom end */
	}
		
	/****** Generic attributes ******/
	
	public void onNameChanged(Object value) {
		
		setIdentifier(this.model.getName());

		/* protected region namecall_behaviour on begin */
		//Call behaviour custom
		Task parentTask = (Task) this.model.eContainer();
		if(this.model.getName() == null || this.model.getName().equals(0)) {
			this.model.setName(String.valueOf(parentTask.getActs().size()));
		}
		/* protected region namecall_behaviour end */
	}
		
	
	public void onPeriodChanged(Object value) {
		
		/* protected region periodcall_behaviour on begin */
		//Call behaviour custom
		/* protected region periodcall_behaviour end */
	}
		
	
	
		
	/****** references (upperBound=1) ******/
	
	public void onStartChanged(Object value) {
	
		/* protected region startcall_behaviour on begin */
		//Call behaviour custom
		/* protected region startcall_behaviour end */
	}		
	public void onEndChanged(Object value) {
	
		/* protected region endcall_behaviour on begin */
		//Call behaviour custom
		/* protected region endcall_behaviour end */
	}		
			
	/******* references (upperBound=-1) ********/
	
		
	
	public ACT getModel() {
		return model;
	}
	
	@Override
	public List<AnchorPoint> getAnchorPoints() {

		List<AnchorPoint> data = new ArrayList<AnchorPoint>();

		if (task_sx_Connectable != null) {
			data.add(task_sx_Connectable);
		}
		
		if (task_dx_Connectable != null) {
			data.add(task_dx_Connectable);
		}
		
		return data;
	}

	@Override
	public Map<AnchorPoint, List<AnchorPoint>> getTargetAnchorPointsSet() {

		Map<AnchorPoint, List<AnchorPoint>> data = new HashMap<>();

		if (task_sx_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class};
			data.put(task_sx_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, task_sx_Connectable.getCompatibleTargets()));
		}
		
		if (task_dx_Connectable != null) {
			Class<?>[] targetModels = new Class<?>[] {Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class, Task.class};
			data.put(task_dx_Connectable, MagneteUtils.getAnchorPointTargets(this, targetModels, task_dx_Connectable.getCompatibleTargets()));
		}
		
		return data;
	}

	@Override
	public AnchorPoint getAnchorPointByTarget(Ente enteTarget) {

		return null;
	}

	
	private void initializeAnchorPoints() {
		try {
			if (task_sx_Connectable != null) {
				task_sx_Connectable.setType("task_sx_connectable");
				task_sx_Connectable.setCompatibleTargets(Arrays.asList(
                                      "tick_0_0_connectable",
                                      "tick_0_1_connectable",
                                      "tick_1_0_connectable",
                                      "tick_1_1_connectable",
                                      "tick_2_0_connectable",
                                      "tick_2_1_connectable",
                                      "tick_3_0_connectable",
                                      "tick_3_1_connectable",
                                      "tick_4_0_connectable",
                                      "tick_4_1_connectable",
                                      "tick_5_0_connectable",
                                      "tick_5_1_connectable",
                                      "tick_6_0_connectable",
                                      "tick_6_1_connectable",
                                      "tick_7_0_connectable",
                                      "tick_7_1_connectable",
                                      "tick_8_0_connectable",
                                      "tick_8_1_connectable",
                                      "tick_9_0_connectable",
                                      "tick_9_1_connectable",
                                      "tick_10_0_connectable",
                                      "tick_10_1_connectable",
                                      "tick_11_0_connectable",
                                      "tick_11_1_connectable",
                                      "tick_12_0_connectable",
                                      "tick_12_1_connectable",
                                      "tick_13_0_connectable",
                                      "tick_13_1_connectable",
                                      "tick_14_0_connectable",
                                      "tick_14_1_connectable",
                                      "tick_15_0_connectable",
                                      "tick_15_1_connectable"
                                      ));
			}
			
			if (task_dx_Connectable != null) {
				task_dx_Connectable.setType("task_dx_connectable");
				task_dx_Connectable.setCompatibleTargets(Arrays.asList(
                                      "tick_0_0_connectable",
                                      "tick_0_1_connectable",
                                      "tick_1_0_connectable",
                                      "tick_1_1_connectable",
                                      "tick_2_0_connectable",
                                      "tick_2_1_connectable",
                                      "tick_3_0_connectable",
                                      "tick_3_1_connectable",
                                      "tick_4_0_connectable",
                                      "tick_4_1_connectable",
                                      "tick_5_0_connectable",
                                      "tick_5_1_connectable",
                                      "tick_6_0_connectable",
                                      "tick_6_1_connectable",
                                      "tick_7_0_connectable",
                                      "tick_7_1_connectable",
                                      "tick_8_0_connectable",
                                      "tick_8_1_connectable",
                                      "tick_9_0_connectable",
                                      "tick_9_1_connectable",
                                      "tick_10_0_connectable",
                                      "tick_10_1_connectable",
                                      "tick_11_0_connectable",
                                      "tick_11_1_connectable",
                                      "tick_12_0_connectable",
                                      "tick_12_1_connectable",
                                      "tick_13_0_connectable",
                                      "tick_13_1_connectable",
                                      "tick_14_0_connectable",
                                      "tick_14_1_connectable",
                                      "tick_15_0_connectable",
                                      "tick_15_1_connectable",
                                      "tick_16_0_connectable"
                                      ));
			}
			
		} catch(NullPointerException e) {
			System.err.println("ACTFX: initializeAnchorPoints() error.");
		}
	}
	
	@Override
	public void synchronizeAnchorPoints() {
		try {
			// L'anchorPoint task_sx_Connectable non ha una ref associata e quindi non si fa nessun binding
			// L'anchorPoint task_dx_Connectable non ha una ref associata e quindi non si fa nessun binding
		} catch(NullPointerException e) {
			System.err.println("ACTFX: AnchorPoint not found on FXML.");
		}
	}
	
	/* protected region behavior on begin */
	//Behavior Custom
	private void validate_TopBottom_ConstraintBendPoint() {
		customLine.getPuntiPolilinea().addListener(new ListChangeListener<BendPoint>() {

			@Override
			public void onChanged(Change<? extends BendPoint> c) {
				while (c.next()) {
					if (c.wasUpdated()) {
						BendPoint b = customLine.getPuntiPolilinea().get(c.getFrom());

						b.disableDraggingVertical();

						Ente padre = LayoutScene.getViewModelMap().get(getModel().eContainer());

						int xPadreFinale = (int) padre.pivot.getCoordinatesRelativeToCanvas()[0] + 1750;

						int xFiglioFinale = (int) (ACTFX.this.pivot.getCoordinatesRelativeToCanvas()[0]
								+ b.getNewValueX().doubleValue());

						if (xPadreFinale < xFiglioFinale
								|| xFiglioFinale < (ACTFX.this.pivot.getCoordinatesRelativeToCanvas()[0] + 25)) {

							b.disableDraggingHorizontal();
						} else {
							b.enableDraggingHorizontal();
						}

					}

				}
			}
		});
	}

	private void disableVertivalDragged() {
		this.getDraggableNode().translateYProperty().addListener((observable, oldValue, newValue) -> {

			if (SelectionModel.getSelection().size() == 1 && newValue.doubleValue() != 0) {
				this.getDraggableNode().setTranslateY(oldValue.doubleValue());
			}
		});
	}

	private void disableHorizzontalDragged() {
		this.getDraggableNode().translateXProperty().addListener((observable, oldValue, newValue) -> {

			Ente padre = LayoutScene.getViewModelMap().get(getModel().eContainer());
			int xPadreIniziale = (int) padre.pivot.getCoordinatesRelativeToCanvas()[0] + 150;
			int xPadreFinale = (int) padre.pivot.getCoordinatesRelativeToCanvas()[0] + 1750;
			int xFiglioIniziale = (int) (ACTFX.this.getDraggableNode().getLayoutX() + newValue.doubleValue());

			BendPoint b = customLine.getPuntiPolilinea().get(1);

			int xFiglioFinale = (int) (b.getCoordinatesRelativeToCanvas()[0]);

			if (xFiglioIniziale < xPadreIniziale || xFiglioFinale > xPadreFinale) {
				this.getDraggableNode().setTranslateX(oldValue.doubleValue());
			}

//			for (Task task : getModel().getFollowing()) {
//
//				SchemaFX taskEnte = (SchemaFX) LayoutScene.getViewModelMap().get(task);
//				if (xFiglioIniziale < taskEnte.customLine.getPuntiPolilinea().get(1)
//						.getCoordinatesRelativeToCanvas()[0]) {
//					this.getDraggableNode().setTranslateX(oldValue.doubleValue());
//				}
//
//			}

		});

	}

	public void getTargetAnchorPointSetTick() {

		task_dx_Connectable.targetProperty().addListener(e -> {

			AnchorPoint target = (AnchorPoint) ((SimpleObjectProperty) e).getValue();
			if (target != null) {
				String[] targetAnchorName = target.getId().split("_");
				setTick("dx", Integer.valueOf(targetAnchorName[2]), Integer.valueOf(targetAnchorName[1]));
			}

		});

		task_sx_Connectable.targetProperty().addListener(e -> {

			AnchorPoint target = (AnchorPoint) ((SimpleObjectProperty) e).getValue();
			if (target != null) {
				String[] targetAnchorName = target.getId().split("_");

				setTick("sx", Integer.valueOf(targetAnchorName[2]), Integer.valueOf(targetAnchorName[1]));
			}

		});

	}
	
	
	private void setTick(String string, Integer idTick, Integer value) {
		if(string.equals("sx")) {
			Tick tick = this.model.getStart();
			tick.setName("tickStart_"+idTick);
			tick.setValue(value);
		}else {
			Tick tick = this.model.getEnd();
			tick.setName("tickEnd_"+idTick);
			tick.setValue(value);
		}
		
	}
	
	/* protected region behavior end */

}
