package it.gssi.astra.metaeditor.common.canvas;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.Node;

public class HighlightModel {
	
	private static ObservableSet<DraggableNode> highlight = FXCollections.observableSet(new HashSet<>());
	
	public static Set<DraggableNode> get() {
		return highlight;
	}
	
	public static void add(DraggableNode node, boolean critique) {
		if(node.visibleProperty().get()) {
			highlight.add(node);
			if(!node.getEnte().getVisibility()) {
				node.getEnte().setVisibility(true);
			}
			node.addErrorFrame(critique);
		}
	}
	
	public static void addMultiple(Set<EObject> results) {
		
		for (EObject eobjectDiagnostic : results) {
			Ente e = LayoutScene.getViewModelMap().get(eobjectDiagnostic);
			
			if(e != null) {
				/*if(!e.getVisibility()) {
					e.setVisibility(true);
				}*/
				add(e.getDraggableNode(), true);
			}
			
		}
		
	}

	/**
	 * Remove from the selection set
	 * 
	 */
	public static void remove(DraggableNode node) {
		highlight.remove(node);
		node.removeErrorFrame();
	}

	/**
	 * Clear selection
	 * 
	 */
	public static void clear() {
		while(!highlight.isEmpty()) {
			remove(highlight.iterator().next());
		}
	}

	public static boolean contains( Node node) {
		
		return highlight.contains(node);
	}

	public static int size() {
		
		return highlight.size();
	}
}
