/*
*@Generated
*/
package it.gssi.astra.schedulerTask.editors.editor.presentation;

import Scheduler.*;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.property.BackedCustomPropertyItem;
import it.gssi.astra.metaeditor.common.root.RootFX;

import org.controlsfx.control.PropertySheet.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

/* protected region import on begin */
//Import Custom
import java.util.ArrayList;
import java.util.List;
/* protected region import end */

public class _SchedulerModel extends RootFX {
	
	static SchedulerModel root;
	
	public void populatePropertyView() {
	
		super.populatePropertyView();
	
		root = (SchedulerModel) LayoutScene.getInstance().getResource().getAllContents().next();
		TreeIterator<?> iterator;
		
		ObservableList<Item> properties = FXCollections.observableArrayList();
		


	
		/* protected region custom_properties on begin */
		//Custom properties
		/* protected region custom_properties end */
	
		// Update PropertySheet view
		LayoutScene.getInstance().propertySheet.getItems().clear();
		LayoutScene.getInstance().propertySheet.getItems().addAll(properties);

	}

	/****** Generic attributes ******/
	
	
	
		
	/****** Specific attributes ******/
	
		
		
	/****** references (upperBound=1) ******/
	
		
		
		
	/******* references (upperBound=-1) ********/
	
	
	/* protected region behavior on begin */
	//Behavior Custom
	/* protected region behavior end */	
}
