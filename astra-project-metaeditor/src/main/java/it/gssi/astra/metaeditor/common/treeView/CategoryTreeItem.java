package it.gssi.astra.metaeditor.common.treeView;

import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeItem;

/**
 * This class manages the {@link CheckBox} of parent that have a list of {@link CustomTreeItem} which
 *  are used to display or hide the associated {@link DraggableNode} 
 * 
 */
public class CategoryTreeItem extends TreeItem<String> {


	public CheckBox checkBox = new CheckBox();
	
	/**
	 * In this constructor we set the layout and is defined the listener for check/uncheck
	 * the checkBox
	 * @param name name of CustomTree Item
	 */
	public CategoryTreeItem(String name) {
		super(name);
		this.setGraphic(checkBox);
		checkBox.setSelected(true);
		checkBox.setOnAction(e ->{
			
			EMFCommands emfCommand = new EMFCommands();
			emfCommand.begin();
			
			for (TreeItem<String> treeItem : this.getChildren()) {
				if(treeItem instanceof CustomTreeItem) {
					CustomTreeItem treeItemC  = (CustomTreeItem) treeItem;
					//treeItemC.checkBox.setSelected(checkBox.isSelected());
					treeItemC.getDraggableNode().getEnte().setVisibilityNoParent(checkBox.isSelected());
				}
			}
			
			emfCommand.end();
		});
	}

}