package it.gssi.astra.metaeditor.common.treeView;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.TextFieldTreeCell;

/**
 * This class is used for managing the layout and behavior of a {@link CustomTreeItem}
 */
public class CustomTreeCell extends TextFieldTreeCell<String> {
	
    private ContextMenu categoryContextMenu;

    /**
     * The constructor defines the various submenus of a specific {@link CustomTreeItem} such as
     * "Visualizza/Nascondi AnchorPoints" and z-index operations
     */
    public CustomTreeCell() {

    	categoryContextMenu = new ContextMenu();
		
		MenuItem visualizzaAnch = new MenuItem("Visualizza AnchorPoints");
		MenuItem nascondiAnch = new MenuItem("Nascondi AnchorPoints");
		
		MenuItem portaInPrimoPiano = new MenuItem("Porta in primo piano");
		MenuItem portaInSecondoPiano = new MenuItem("Porta in secondo piano");
		MenuItem portaAvanti = new MenuItem("Porta Avanti");
		MenuItem portaIndietro = new MenuItem("Porta Indietro");
		MenuItem resetZIndex = new MenuItem("Reset Z-Index");
		
		portaAvanti.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						DraggableNode dNode = ((CustomTreeItem) element).getDraggableNode();
						dNode.setViewOrder(dNode.getViewOrder() - 1);
					}
				});
			} else if (getTreeItem() instanceof CustomTreeItem) {
				DraggableNode dNode = ((CustomTreeItem) getTreeItem()).getDraggableNode();
				dNode.setViewOrder(dNode.getViewOrder() - 1);
			}
			
			event.consume();
			
		});
		
		
		resetZIndex.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
		
				EMFCommands emfCommand = new EMFCommands();
				emfCommand.begin();
				
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						DraggableNode dNode = ((CustomTreeItem) element).getDraggableNode();
						dNode.setViewOrder(dNode.getEnte().graphicalElement.getZIndexDefault());
					}
				});
				
				emfCommand.end();
				
			} else if (getTreeItem() instanceof CustomTreeItem) {
				
				DraggableNode dNode = ((CustomTreeItem) getTreeItem()).getDraggableNode();
				dNode.setViewOrder(dNode.getEnte().graphicalElement.getZIndexDefault());

			}
			
			event.consume();
			
		});


		
		portaInPrimoPiano.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
				double foregroundViewOrder = LayoutScene.getInstance().getCanvas().getForegroundViewOrder();
				
				EMFCommands emfCommand = new EMFCommands();
				emfCommand.begin();
				
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						DraggableNode dNode = ((CustomTreeItem) element).getDraggableNode();
						if (dNode.getViewOrder() > foregroundViewOrder)
							dNode.setViewOrder(foregroundViewOrder - 1);
					}
				});
				
				emfCommand.end();
				
			} else if (getTreeItem() instanceof CustomTreeItem) {
				double foregroundViewOrder = LayoutScene.getInstance().getCanvas().getForegroundViewOrder();
				DraggableNode dNode = ((CustomTreeItem) getTreeItem()).getDraggableNode();
				if (dNode.getViewOrder() > foregroundViewOrder)
					dNode.setViewOrder(foregroundViewOrder - 1);
			}
			
			event.consume();
			
		});
		
		portaInSecondoPiano.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
				double backgroundViewOrder = LayoutScene.getInstance().getCanvas().getBackgroundViewOrder();						
				
				EMFCommands emfCommand = new EMFCommands();
				emfCommand.begin();
				
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						DraggableNode dNode = ((CustomTreeItem) element).getDraggableNode();
						if (dNode.getViewOrder() < backgroundViewOrder)
							dNode.setViewOrder(backgroundViewOrder + 1);
					}
				});
				
				emfCommand.end();
				
			} else if (getTreeItem() instanceof CustomTreeItem) {
				double backgroundViewOrder = LayoutScene.getInstance().getCanvas().getBackgroundViewOrder();
				DraggableNode dNode = ((CustomTreeItem) getTreeItem()).getDraggableNode();
				if (dNode.getViewOrder() < backgroundViewOrder)
					dNode.setViewOrder(backgroundViewOrder + 1);
			}
			
			event.consume();
			
		});
		
		portaIndietro.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						DraggableNode dNode = ((CustomTreeItem) element).getDraggableNode();
						dNode.setViewOrder(dNode.getViewOrder() + 1);
					}
				});
			} else if (getTreeItem() instanceof CustomTreeItem) {
				DraggableNode dNode = ((CustomTreeItem) getTreeItem()).getDraggableNode();
				dNode.setViewOrder(dNode.getViewOrder() + 1);
			}
			
			event.consume();
			
		});
		
		

		visualizzaAnch.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						((CustomTreeItem) element).getDraggableNode().getEnte().setAnchorPointVisibility(true);
					}
				});
			} else if (getTreeItem() instanceof CustomTreeItem) {
				((CustomTreeItem) getTreeItem()).getDraggableNode().getEnte().setAnchorPointVisibility(true);
			}
			
			event.consume();

		});
		nascondiAnch.setOnAction((event) -> {
			if (getTreeItem() instanceof CategoryTreeItem) {
				
				getTreeItem().getChildren().forEach(element->{
					if (element instanceof CustomTreeItem) {
						((CustomTreeItem) element).getDraggableNode().getEnte().setAnchorPointVisibility(false);
					}
				});
				
			} else if (getTreeItem() instanceof CustomTreeItem) {
				((CustomTreeItem) getTreeItem()).getDraggableNode().getEnte().setAnchorPointVisibility(false);
			}
			
			event.consume();
		});

		
		categoryContextMenu.getItems().addAll(visualizzaAnch, nascondiAnch, portaInPrimoPiano, portaInSecondoPiano, portaAvanti, portaIndietro,resetZIndex);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        // if the item is not empty and is a category of elements...
        if (!empty && LayoutScene.getInstance().getContainerCanvas() != null &&
        		getTreeItem().getParent() == LayoutScene.getInstance().getContainerCanvas().treeRoot && getTreeItem() instanceof CategoryTreeItem) {
            setContextMenu(categoryContextMenu);
        }
    }

}
