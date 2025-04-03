package it.gssi.astra.metaeditor.common.treeView;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EClassImpl;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.root.RootFX;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

/**
 * This class represent the controller of TreeView
 * The tree view uses a combination of indents and icons to represent the nested 
 * relationship between parent and child nodes. Collapsed nodes use an expanding 
 * arrow pointing to the right, while expanded nodes use an expanding arrow pointing down.
 * 
 */
public class CustomTreeView extends TreeView<String> {

	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String FILE_NAME_FXML = EditorProperties.get("metaTreeView.fxml");
	public static boolean press = true;
	CustomTreeView thiz;

	/**
	 * The {@link FXML} is loaded in the constructor and some listeners are defined
	 *  which are used to manage gestures such as clicking on a single item or right mouse click
	 */
	public CustomTreeView() {
		
		thiz = this;

		FXMLUtil.loadFXML(this, BASE_PATH_FXML + FILE_NAME_FXML);

		this.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		//vecchio codice per tenere sincronizzati treeview, canvas e property view a livello di elementi selezionati.
		//codice ora superato dalla nuova gestione centralizzata in SelectionModel
		/*this.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<TreeItem<String>>() {
			@Override
			public void onChanged(Change<? extends TreeItem<String>> change) {
				change.next();
				/*
				List<? extends TreeItem<String>> removedItems = change.getRemoved();

				for (TreeItem<String> treeItem : removedItems) {
					
					if (treeItem instanceof CustomTreeItem) {
						CustomTreeItem customItem = (CustomTreeItem) treeItem;
						if(customItem.getDraggableNode().getSelected()) {
							SelectionModel.remove(customItem.getDraggableNode());
							removeChildrenNodeFromSelection(customItem);
						}
					} else if (treeItem instanceof CategoryTreeItem) {
						// Case a category has been deselected
						removeChildrenNodeFromSelection(treeItem);
					}
				}
				
				List<? extends TreeItem<String>> addedItems = change.getAddedSubList();
				
				for (TreeItem<String> treeItem : addedItems) {
					
					if (treeItem instanceof CustomTreeItem) {
						SelectionModel.add(((CustomTreeItem) treeItem).getDraggableNode());
					} 
					else if (treeItem instanceof CategoryTreeItem) {
						// Case a category has been selected
						treeItem.getChildren().forEach(element -> {
							if (element instanceof CustomTreeItem) {
								SelectionModel.add(((CustomTreeItem) element).getDraggableNode());
							}
						});
					}
				}
				
				if(change.getList().size() == 1 && change.getList().get(0) instanceof CustomTreeItem) {
					CustomTreeItem item = (CustomTreeItem)change.getList().get(0);
					item.getDraggableNode().getEnte().populatePropertyView();
				}
				else {
					LayoutScene.getInstance().showRootProperties();
				}
			}
		});*/
		
		
		/*
		 *  This listener manages item selection and scroll to item in canvas
		 *  for example when an item is selected, the relative {@link Property} is showed
		 */
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>()
	    {
	        @Override
	        public void handle(MouseEvent mouseEvent)
	        {           
	            var item = ((CustomTreeView)mouseEvent.getSource()).getSelectionModel().getSelectedItem();
	            if(item != null && item instanceof CustomTreeItem) {
	                CustomTreeItem customTreeItem = (CustomTreeItem)item;
	                DraggableNode dNode =  customTreeItem.getDraggableNode();
	                dNode.ownCanvas.getScrollHandler().computeHvalue(dNode);
	                dNode.ownCanvas.getScrollHandler().computeVvalue(dNode);
	            }
	            
	            SelectionModel.fromTreeViewClear();
	            List<DraggableNode> nodesToAdd = new ArrayList<DraggableNode>();
	            
	            for (TreeItem<String> treeItem : thiz.getSelectionModel().getSelectedItems()) {
	            	if (treeItem instanceof CustomTreeItem) {
	            		nodesToAdd.add(((CustomTreeItem) treeItem).getDraggableNode());
		            }
		            else if (treeItem instanceof CategoryTreeItem) {
		            	treeItem.getChildren().forEach(element -> {
							if (element instanceof CustomTreeItem) {
								nodesToAdd.add(((CustomTreeItem) element).getDraggableNode());
							}
						});
		            } 
	            }
	            
	            SelectionModel.fromTreeViewAdd(nodesToAdd);
	        }
	    });
		
		
	}

	/**
	 * This method is used to initialize the treeView with the various
	 * categories of objects defined within the domain metamodel
	 * @param rootClass Root of metamodel 
	 * @param treeRoot root of TreeView
	 */
	public static void createTreeView(EClass rootClass, TreeItem<String> treeRoot) {

		EClass root_class = rootClass;

		for (EReference e : root_class.getEAllReferences()) {
			if (e.getEType() instanceof EClassImpl) {
				String name = e.getEType().getName();
				CategoryTreeItem category = new CategoryTreeItem(name);
				treeRoot.getChildren().add(category);
			}
		}
	}

	public void expandAll() {
		expandAllFrom(LayoutScene.getInstance().getContainerCanvas().treeRoot);
	}

	public static void expandAllFrom(TreeItem<String> item) {
		if (item != null && !item.isLeaf()) {
			item.setExpanded(true);
			for (TreeItem<String> child : item.getChildren()) {
				expandAllFrom(child);
			}
		}
	}

	public static void addElementInTreeView(DraggableNode dNode, String classe) {
		for (TreeItem<String> item : LayoutScene.getInstance().getContainerCanvas().treeRoot.getChildren()) {
			if (item.getValue().toString().equals(classe)) {
				if(!dNode.getEnte().getVisibility()) {
					CategoryTreeItem clasParent  = (CategoryTreeItem) item;
					clasParent.checkBox.setSelected(false);
				}
				CustomTreeItem obj = new CustomTreeItem();
				obj.setDraggableNode(dNode);
				item.getChildren().add(obj);
				
				return;
			}
		}
		
	}
	
	public void removeChildrenNodeFromSelection(TreeItem<String> treeItem) {
		
		treeItem.getChildren().forEach(e -> {
			if (e instanceof CustomTreeItem) {
				CustomTreeItem customItem = (CustomTreeItem) e;
					if(customItem.getDraggableNode().getSelected()) {
						SelectionModel.remove(customItem.getDraggableNode());
				}
				removeChildrenNodeFromSelection(customItem);
			}
		});
	}

	public static void expanded(CustomTreeItem item) {
		TreeItem<String> root = item.getParent();
		while (root != null) {
			root.setExpanded(true);
			root = root.getParent();
		}
	}
	
	public void deselectItem(TreeItem<String> item) {
		int index = this.getRow(item);
		
		if (index != -1) {
			this.getSelectionModel().clearSelection(index);
		}
	}
	
	public void scrollToItem (TreeItem<String> item) {
		this.scrollTo(this.getRow(item));
	}
	
	public void scrollToItem (Ente ente) {
		this.scrollTo(this.getRow(ente.getTreeItem()));
	}

	public static TreeItem<String> existElementTree(String name, TreeItem<String> list) {
		for (TreeItem<String> item : list.getChildren()) {
			if (item.getValue().equals(name)) {
				return item;
			}
		}
		return null;

	}

}