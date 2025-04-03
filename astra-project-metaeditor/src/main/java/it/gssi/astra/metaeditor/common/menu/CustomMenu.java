package it.gssi.astra.metaeditor.common.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.command.Command;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.HighlightModel;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.dataManager.cloneManager.CloneImpl;
import it.gssi.astra.metaeditor.common.dataManager.commands.BeginAtomicSequenceCommand;
import it.gssi.astra.metaeditor.common.dataManager.commands.CustomCommandStack;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.dataManager.commands.EndAtomicSequenceCommand;
import it.gssi.astra.metaeditor.common.dataManager.fileManager.FileManagerImpl;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.popup.Popup;
import it.gssi.astra.metaeditor.common.popup.PreferencesPopup;
import it.gssi.astra.metaeditor.common.popup.Search;
import it.gssi.astra.metaeditor.common.treeView.CategoryTreeItem;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import it.gssi.astra.metaeditor.common.utility.Export;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import it.gssi.astra.metaeditor.common.utility.Validate;
import it.gssi.astra.metaeditor.common.utils.epsilon.EOLStandalone;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.PrintResolution;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.transform.Scale;

public class CustomMenu extends MenuBar{
	
	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String FILE_NAME_FXML = EditorProperties.get("menu.fxml");
	
	@FXML
	public Menu menuFile;
	
	@FXML
	public Menu menuVisualizza;
	
	@FXML
	public Menu menuModifica;
	
	@FXML
	public Menu menuStrumenti;
	
	@FXML
	private RadioMenuItem lockMenu;

	@FXML
	private RadioMenuItem menuShowCanvasSection;
	
	@FXML
	public MenuItem menuItemZoomPlus;
	
	@FXML
	public MenuItem menuItemZoomMinus;
	
	@FXML
	public MenuItem menuItemZoomReset;
	
	private static CustomMenu instance;
	
	public static CustomMenu getInstance() {

		if (instance == null) {
			instance = new CustomMenu();
		}

		return instance;
	}
	
	KeyCombination zoomIN_MacOS = new KeyCharacterCombination("+", KeyCombination.SHORTCUT_DOWN);
	KeyCombination zoomOUT_MacOS = new KeyCharacterCombination("-", KeyCombination.SHORTCUT_DOWN);
	KeyCombination zoomIN_Windows = new KeyCodeCombination(KeyCode.PLUS, KeyCombination.SHORTCUT_DOWN);
	KeyCombination zoomOUT_Windows = new KeyCodeCombination(KeyCode.MINUS, KeyCombination.SHORTCUT_DOWN);
	
	
	
	public CustomMenu () {
		FXMLUtil.loadFXML(this, BASE_PATH_FXML + FILE_NAME_FXML);
		setKeyCodeZoom();
		instance = this;
	}
	
	public void disableMenu(Boolean disable) {
		menuFile.getItems().forEach(item -> item.setDisable(disable));
		menuVisualizza.getItems().forEach(item -> item.setDisable(disable));
		menuModifica.getItems().forEach(item -> item.setDisable(disable));
		menuStrumenti.getItems().forEach(item -> item.setDisable(disable));
	}
	
	public void setKeyCodeZoom() {
		if(System.getProperty("os.name").contains("Mac")) {
			// Mac keyboard
			menuItemZoomPlus.setAccelerator(zoomIN_MacOS);
			menuItemZoomMinus.setAccelerator(zoomOUT_MacOS);
		}else {
			// Windows/Linux keyboard
			menuItemZoomPlus.setAccelerator(zoomIN_Windows);
			menuItemZoomMinus.setAccelerator(zoomOUT_Windows);
		}
	}
	

	public void setLocked(boolean value) {
		lockMenu.selectedProperty().set(value);
	}

	public boolean isLocked() {
		return lockMenu.isSelected();
	}
	
	@FXML
	public void create() {

		List<String> paths = Popup.saveDialog(this, FileManagerImpl.getInstance().getFileExtention());
		
		if (FileManagerImpl.getInstance().create(paths)) {
			
			LayoutScene.getInstance().palette.setVisible(true);

			disableMenu(false);
		}
	}
	
	
	/**
	 * This function start the loading of model 
	 */
	@FXML
	public void load() {
		List<String> paths = Popup.openDialog(LayoutScene.getInstance(), FileManagerImpl.getInstance().getFileExtention());
		
		if(FileManagerImpl.getInstance().load(paths) != null) {

			LayoutScene.getInstance().palette.setVisible(true);
			disableMenu(false);	
		}
			
	}
	
	/**
	 * This function start the loading of all model from directory
	 */
	@FXML
	public void loadFolder() {
		FileManagerImpl.getInstance().loadFolder();
	}
	
	/**
	 * This function start the loading of all model selected by User
	 */
	@FXML
	public void loadSelection() {
		FileManagerImpl.getInstance().loadSelection();
	}
	
	/**
	 * Save the model opened and the user can be rename the name
	 */
	@FXML
	public void saveAs() {

		List<String> paths = Popup.saveDialog(this, FileManagerImpl.getInstance().getFileExtention());
		
		FileManagerImpl.getInstance().saveAs(paths);
		
	}

	/**
	 * Save the model opened
	 */
	@FXML
	public void save() {
		FileManagerImpl.getInstance().save();
	}


	/**
	 * Save all model opened
	 */
	@FXML
	public void saveAll() {
		FileManagerImpl.getInstance().saveAll();
	}

	/**
	 * This function export the canvas into PNG, PDF and SVG format
	 */
	@FXML
	public void export() {
		Export.getInstance().export();
	}
	
	/**
	 * This function open the printer task to print the model opened
	 */
	@FXML
	public void print() {

		PrinterJob job = PrinterJob.createPrinterJob();

		if (job != null && job.showPrintDialog( LayoutScene.getInstance().getCanvas().getScene().getWindow())) {
			Printer printer = job.getPrinter();
			PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE,
					Printer.MarginType.HARDWARE_MINIMUM);

			double width =  LayoutScene.getInstance().getCanvas().getWidth();
			double height =  LayoutScene.getInstance().getCanvas().getHeight();

			PrintResolution resolution = job.getJobSettings().getPrintResolution();

			width /= resolution.getFeedResolution();

			height /= resolution.getCrossFeedResolution();

			double scaleX = pageLayout.getPrintableWidth() / width / 300;
			double scaleY = pageLayout.getPrintableHeight() / height / 300;

			Scale scale = new Scale(scaleX, scaleY);

			 LayoutScene.getInstance().getCanvas().getTransforms().add(scale);

			boolean success = job.printPage(pageLayout,  LayoutScene.getInstance().getCanvas());
			if (success) {
				job.endJob();
			}
			 LayoutScene.getInstance().getCanvas().getTransforms().remove(scale);
		}

	}

	/**
	 * This function validate and save the model opened
	 * @return true if the model is valid false otherwise
	 */
	@FXML
	public void validate() {
		Validate.getInstance().validate();
	}


	@FXML
	public void openPreferences() {
		PreferencesPopup.show();
	}

	@FXML
	public void hideProperies() {
		FXMLUtil.nodeVisibility( LayoutScene.getInstance().getRight(), !LayoutScene.getInstance().getRight().isVisible());
	}

	/**
	 * Executes the {@code undo} of all commands in the stack until a command with label '<italic>Begin</italic>' is found.
	 */
	@FXML
	public void undo() {
		
		CustomCommandStack commandStack = (CustomCommandStack) LayoutScene.getInstance().getEditingDomain().getCommandStack();
		
		if (commandStack.canUndo()) {
			commandStack.setReadOnly(true);
			
			//serve per l'highlighting degli oggetti interessati dall'undo
			Collection<Object> affectedObjects = new HashSet<Object>();
			Command singleUndoCommand;
			
			if ((singleUndoCommand = commandStack.getUndoCommand()) instanceof EndAtomicSequenceCommand) {
				
				Command undoCommand;
				
				while (!((undoCommand = commandStack.getUndoCommand()) instanceof BeginAtomicSequenceCommand)) {
					
					if (undoCommand.getResult() != null)
						affectedObjects.addAll(undoCommand.getResult());
					
					commandStack.undo();
				}

				commandStack.undo();

			} else {
				if (singleUndoCommand.getResult() != null)
					affectedObjects.addAll(singleUndoCommand.getResult());
				
				commandStack.undo();
			}
			
			commandStack.setReadOnly(false);
			
			addToSelectionModel(affectedObjects);
		}
	}

	/**
	 * Executes the {@code redo} of all commands in the stack until a command with label '<italic>End</italic>' is found.
	 */
	@FXML
	public void redo() {
		
		CustomCommandStack commandStack = (CustomCommandStack) LayoutScene.getInstance().getEditingDomain().getCommandStack();
		Command singleRedoCommand;
		
		if (commandStack.canRedo()) {
			commandStack.setReadOnly(true);
			
			//serve per l'highlighting degli oggetti interessati dal redo
			Collection<Object> affectedObjects = new HashSet<Object>();
			
			if ((singleRedoCommand = commandStack.getRedoCommand()) instanceof BeginAtomicSequenceCommand) {
				
				Command redoCommand;

				while (!((redoCommand = commandStack.getRedoCommand()) instanceof EndAtomicSequenceCommand)) {
					
					commandStack.redo();
					
					if (redoCommand.getResult() != null)
						affectedObjects.addAll(redoCommand.getResult());
				}

				commandStack.redo();

			} else {
				commandStack.redo();
				
				if (singleRedoCommand.getResult() != null)
					affectedObjects.addAll(singleRedoCommand.getResult());
			}
			
			commandStack.setReadOnly(false);
			
			addToSelectionModel(affectedObjects);
		}
	}
	
	private void addToSelectionModel (Collection<Object> affectedObjects) {
		Platform.runLater(() -> {
			SelectionModel.clear(false);
			
			List<DraggableNode> addToSelectionModel = new ArrayList<DraggableNode>();
			for (Object ob : affectedObjects) {
					Ente ente = null;
					if (ob instanceof ElementPosition)
						ente = LayoutScene.getViewModelMap().get(((ElementPosition)ob).getElement());
					else
						ente = LayoutScene.getViewModelMap().get(ob);
					
					if (ente != null && ente.getDraggableNode() != null) {
						addToSelectionModel.add(ente.getDraggableNode());
					}
			}
			SelectionModel.add(addToSelectionModel);
		});
	}
	
	/**
	 * Show all hidden object
	 */
	@FXML
	public void showEnti() {

		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();
		
		for (Node dNode : LayoutScene.getInstance().getCanvas().getChildren()) {
			((DraggableNode) dNode).getEnte().setVisibility(true);
			LayoutScene.getInstance().treeView.getRoot().getChildren().forEach(e -> {
				CategoryTreeItem category = (CategoryTreeItem) e;
				category.checkBox.setSelected(true);
			});
		}
		
		emfCommand.end();
	}

	@FXML
	public void hideError() {
		HighlightModel.clear();
	}
	
	@FXML
	public void find() {
		Search.show();
	}

	@FXML
	public void zoomPlus() {
		LayoutScene.getInstance().getWorkspace().getContainerCanvas().zoomPlus();
	}
	
	@FXML
	public void zoomMinus() {
		LayoutScene.getInstance().getWorkspace().getContainerCanvas().zoomMinus();
	}
	
	@FXML
	public void zoomReset() {
		LayoutScene.getInstance().getWorkspace().getContainerCanvas().zoom100();
	}
	
	@FXML
	public void editMonitor() {
		LayoutScene.getInstance().getContainerCanvas().getSectionLayer().edit();
	}
	
	@FXML
	public void showCanvasSection() {
		LayoutScene.getInstance().getContainerCanvas().getSectionLayer().setVisible(menuShowCanvasSection.isSelected());
	}
	
	@FXML
	public void copy() {
		CloneImpl.getInstance().copy();
	}

	@FXML
	public void paste() {
		CloneImpl.getInstance().paste(true);
	}
	
	/**
	 * Run eol code
	 */
	@FXML
	public void autoSetting() {
		EOLStandalone eolModule = new EOLStandalone();
		
		try {
			eolModule.addModel(FileManagerImpl.getInstance().getFileExtention(), LayoutScene.getInstance().getResource(), LayoutScene.getInstance().domainEPackage.getNsURI(), true, false);
			eolModule.setSource("/epsilon/" + FileManagerImpl.getInstance().getFileExtention() + "Setting.eol");		
			eolModule.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void zIndexReset() {

		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();
		
		for (Node node : LayoutScene.getInstance().getCanvas().getChildren()) {
			DraggableNode dNode = (DraggableNode) node;
			
			dNode.setViewOrder(dNode.getEnte().graphicalElement.getZIndexDefault());
		}
		
		emfCommand.end();
	}
}
