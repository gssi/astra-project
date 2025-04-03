package it.gssi.astra.metaeditor.common.canvas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.Node;

/**
 * This class contains a collection of {@link DraggableNode} and is used to
 * store the selected nodes on the {@link Canvas}. The class offers only static
 * methods in fact each canvas on the editor uses the same data model
 * 
 */
public class SelectionModel {
	
	private static ObservableSet<DraggableNode> selection = FXCollections.observableSet(new HashSet<>());
	
	public static Set<DraggableNode> getSelection() {
		return selection;
	}
	
	//Clear and then add
	public static void clearAdd(DraggableNode node) {
		clear(false);
		
		add(node);
	}
	
	public static void add(DraggableNode node) {
		List<DraggableNode> singleAdd = new ArrayList<DraggableNode>();
		singleAdd.add(node);
		add(singleAdd);
	}
	
	public static void add(List<DraggableNode> nodes) {
		Iterator<DraggableNode> nodesIterator = nodes.iterator();
		while (nodesIterator.hasNext()) {
			DraggableNode node = nodesIterator.next();
			if(node.visibleProperty().get()) {
				selection.add(node);
				node.setSelected(true);
				
				CustomTreeItem treeItem = node.getEnte().treeItem;
				LayoutScene.getInstance().treeView.getSelectionModel().select(treeItem);
			}
		}
		
		try {
			if (selection.size() == 1) {
				DraggableNode dNode = (DraggableNode)selection.toArray()[0];
				dNode.getEnte().populatePropertyView();
				LayoutScene.getInstance().treeView.scrollToItem(dNode.getEnte().treeItem);
			}
			else if (nodes.size() == 1) {
				nodes.get(0).getEnte().populatePropertyView();
				LayoutScene.getInstance().treeView.scrollToItem(nodes.get(0).getEnte().treeItem);
			}
			else {
				LayoutScene.getInstance().showRootProperties();
				LayoutScene.getInstance().treeView.scrollTo(0);
				
				if (selection.size() == 0) {
					LayoutScene.getInstance().treeView.getSelectionModel().select(LayoutScene.getInstance().treeView.getRoot());
				}
			}
		}
		catch (NullPointerException e) {
			LayoutScene.getInstance().showRootProperties();
			LayoutScene.getInstance().treeView.scrollTo(0);
			LayoutScene.getInstance().treeView.getSelectionModel().select(LayoutScene.getInstance().treeView.getRoot());
		}
	}

	/**
	 * Remove from the selection set
	 * 
	 */
	public static void remove(DraggableNode node) {
		List<DraggableNode> singleRemove = new ArrayList<DraggableNode>();
		singleRemove.add(node);
		remove(singleRemove);
	}
	
	public static void remove(List<DraggableNode> nodes) {
		Iterator<DraggableNode> nodesIterator = nodes.iterator();
		while (nodesIterator.hasNext()) {
			DraggableNode node = nodesIterator.next();
			selection.remove(node);
			node.setSelected(false);
			
			LayoutScene.getInstance().treeView.deselectItem(node.getEnte().treeItem);
		}
		
		if (selection.size() == 1) {
			DraggableNode dNode = (DraggableNode)selection.toArray()[0];
			dNode.getEnte().populatePropertyView();
			LayoutScene.getInstance().treeView.scrollToItem(dNode.getEnte().treeItem);
		}
	}

	/**
	 * Clear selection
	 * 
	 */
	public static void clear(boolean showRoot) {
		
		LayoutScene.getInstance().treeView.getSelectionModel().clearSelection();
		
		while(!selection.isEmpty()) {
			remove(new ArrayList<>(selection));
		}
		
		if (showRoot) {
			LayoutScene.getInstance().showRootProperties();
			LayoutScene.getInstance().treeView.getSelectionModel().select(LayoutScene.getInstance().treeView.getRoot());
			LayoutScene.getInstance().treeView.scrollTo(0);
		}
	}
	
	public static void clear() {
		clear(false);
	}
	
	public static void fromTreeViewClear() {
		Iterator<DraggableNode> nodesIterator = selection.iterator();
		while(nodesIterator.hasNext()) {
			DraggableNode node = nodesIterator.next();
			node.setSelected(false);
		}
		selection.clear();
	}
	
	public static void fromTreeViewAdd(List<DraggableNode> nodes) {
		Iterator<DraggableNode> nodesIterator = nodes.iterator();
		while (nodesIterator.hasNext()) {
			DraggableNode node = nodesIterator.next();
			if(node.visibleProperty().get()) {
				selection.add(node);
				node.setSelected(true);
			}
		}
		
		if (selection.size() == 1) {
			DraggableNode dNode = (DraggableNode)selection.toArray()[0];
			dNode.getEnte().populatePropertyView();
		}
		else if (nodes.size() == 1) {
			nodes.get(0).getEnte().populatePropertyView();
		}
		else {
			LayoutScene.getInstance().showRootProperties();
		}
	}

	public static boolean contains( Node node) {
		
		return selection.contains(node);
	}

	public static int size() {
		
		return selection.size();
	}
}
