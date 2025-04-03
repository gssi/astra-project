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
/* protected region import end */


/*
*@Generated
*/
public class TickFX extends Ente {

	
	private Tick model = null;
	
	private BackedCustomPropertyItem name_item;
	private BackedCustomPropertyItem Value_item;

	/* protected region declaration on begin */
	//Declaration Custom
	/* protected region declaration end */

	/*
	*@Generated
	*/
	public TickFX(Tick model, ElementPosition elementPosition, GraphicalElement graphicalElement) {

		super(String.valueOf(model.getName()));
		
		this.model = model;
		this.elementPosition = elementPosition;
		this.graphicalElement = graphicalElement;
		
//		fxmlLoader = FXMLUtil.loadFXML(this, getFxmlPath());
		
		
		this.allowedRotationPositions.addAll(this.graphicalElement.getRotationPositions());
		
		this.name_item = new BackedCustomPropertyItem(this.model, "Properties", "name", true);
		this.Value_item = new BackedCustomPropertyItem(this.model, "Properties", "Value", true);
		
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
		properties.add(this.Value_item);

		
		/* protected region custom_properties on begin */
		//Custom properties
		/* protected region custom_properties end */

		// Update PropertySheet view
		LayoutScene.getInstance().propertySheet.getItems().clear();
		LayoutScene.getInstance().propertySheet.getItems().addAll(properties);
	}
	
	
	public void createMenu() {
		
	
		/******* references (containment) ********/
		

		/* protected region customizeMenu on begin */
		//Customize menu options
		/* protected region customizeMenu end */
	}
		
	@Override
	public void initialization() {
		
		super.initialization();
		
		EObject eObjectPadre = this.model.eContainer();
		Ente padreFX = LayoutScene.getViewModelMap().get(eObjectPadre);

		/****** Generic attributes ******/
		
		onNameChanged(this.model.getName());
	
		onValueChanged(this.model.getValue());
	
		/* protected region init_custom on begin */
			//Call behaviour custom
		/* protected region init_custom end */
	}
		
	/****** Generic attributes ******/
	
	public void onNameChanged(Object value) {
		
		setIdentifier(this.model.getName());

		/* protected region namecall_behaviour on begin */
		//Call behaviour custom
		/* protected region namecall_behaviour end */
	}
		
	
	public void onValueChanged(Object value) {
		

		/* protected region Valuecall_behaviour on begin */
		//Call behaviour custom
		/* protected region Valuecall_behaviour end */
	}
		
	
	
		
	/****** references (upperBound=1) ******/
	
			
	/******* references (upperBound=-1) ********/
	
		
	
	public Tick getModel() {
		return model;
	}
	
	
	
	
	/* protected region behavior on begin */
	//Behavior Custom
	/* protected region behavior end */
}
