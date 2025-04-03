package it.gssi.astra.metaeditor.common.treeView;


import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeItem;

/**
 * This class is used to manage a single item of {@link CustomTreeView}
 *
 */
public class CustomTreeItem extends CheckBoxTreeItem<String> {
	
	private DraggableNode dNode;
	
	public CheckBox checkBox = new CheckBox();

	public DraggableNode getDraggableNode() {
		return dNode;
	}

	/**
	 * In this function we set the Draggable node associate 
	 * @param dNode {@link DraggableNode} associated
	 */
	public void setDraggableNode(DraggableNode dNode) {
		this.dNode = dNode;
		checkBox.setSelected(dNode.getEnte().getVisibility());
		this.setValue(dNode.getEnte().identifier.getValue());
		ChangeListener<String> nameListener = (obs, oldName, newName) -> {
			this.setValue(newName);
		};
		dNode.getEnte().identifierProperty().addListener(nameListener);
		dNode.getEnte().setTreeItem(this);
	}

	/**
	 * In this constructor we define the layout and we define the listener checkBox associated 
	 * 
	 */
	public CustomTreeItem() {
		
		this.setGraphic(checkBox);
	
		checkBox.setOnAction(e ->{
			this.dNode.getEnte().setVisibility(checkBox.isSelected());
			//commentato perche' ora è il setVisibility che si occupa di aggiornare la selezione del parent
			/*if(this.getParent()instanceof CategoryTreeItem) {
				CategoryTreeItem parent = (CategoryTreeItem) this.getParent();
					parent.checkBox.setSelected(checkUnsettedItem(parent));
			}*/
		});
	}
	
	public boolean checkUnsettedItem(CategoryTreeItem parent) {
		
		for (TreeItem<String> ctItem : parent.getChildren()) {
			CustomTreeItem customTreeItem = (CustomTreeItem) ctItem;
			if(!customTreeItem.checkBox.isSelected()) {
				return false;
			}
		}
		return true;
	}

//	@Override
//	public String toString() {
//		return ente.name;
//		
//	}

}