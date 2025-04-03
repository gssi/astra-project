package it.gssi.astra.metaeditor.common;

import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.SystemUtils;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.PropertySheet.Mode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.canvas.Canvas;
import it.gssi.astra.metaeditor.common.canvas.CanvasManagementImpl;
import it.gssi.astra.metaeditor.common.canvas.ContainerCanvas;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.canvas.Workspace;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.interfaces.IPalette;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;
import it.gssi.astra.metaeditor.common.palette.PaletteGesture;
import it.gssi.astra.metaeditor.common.property.BackedCustomPropertyItem;
import it.gssi.astra.metaeditor.common.property.CustomPropertyEditorFactory;
import it.gssi.astra.metaeditor.common.property.CustomPropertySheetSkin;
import it.gssi.astra.metaeditor.common.root.RootFX;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeCell;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeView;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * This class is the main javaFX controller.
 * The main components are Canvas, Palette, Property, Top menu, TreeView.
 * This class in implemented with a Singleton pattern 
 * 
 */
public class LayoutScene extends BorderPane {

	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String FILE_NAME_FXML = EditorProperties.get("layout.fxml");

	@FXML
	private Workspace workspace;

	@FXML
	public VBox palette;
	
	@FXML
	public CustomMenu customMenu;

	@FXML
	private SplitPane properties;

	@FXML
	public PropertySheet propertySheet;

	@FXML
	public CustomTreeView treeView;

	@FXML
	public TitledPane layout, hierarchy;
	
	public EPackage domainEPackage;
	public String srcBasePath;

	public IPalette paletteInterface;

	public RootFX rootFX;

	private ResourceSet resourceSet = null;
	
	public MetaEditorConfiguration confInstanceRoot = null;
	public Table<EClass, EReference, GraphicalElement> graphicalElementMap = HashBasedTable.create();
			
	public PaletteGesture paletteGesture;
	
	public Stage primaryStage;

	KeyCombination zoomIN_MacOS = new KeyCharacterCombination("+", KeyCombination.SHORTCUT_DOWN);
	KeyCombination zoomOUT_MacOS = new KeyCharacterCombination("-", KeyCombination.SHORTCUT_DOWN);
	KeyCombination zoomIN_Windows = new KeyCodeCombination(KeyCode.PLUS, KeyCombination.SHORTCUT_DOWN);
	KeyCombination zoomOUT_Windows = new KeyCodeCombination(KeyCode.MINUS, KeyCombination.SHORTCUT_DOWN);
	
	private static LayoutScene instance;
	
	public static LayoutScene getInstance() {

		if (instance == null) {
			instance = new LayoutScene();
		}

		return instance;
	}
	
	public Resource createRootElement(Resource resource) {
		EClass rootEClass = (EClass) this.domainEPackage.getEClassifier(this.confInstanceRoot.getRootElement().getName());
		EObject rootEObject = EcoreUtil.create(rootEClass);
		resource.getContents().add(rootEObject);
		return resource;
	}

	/**
	 * This method initialize the layout of application.
	 * 
	 */
	public LayoutScene() {

		instance = this;
		
		FXMLUtil.loadFXML(this, BASE_PATH_FXML + FILE_NAME_FXML);
		
		/**
		 *  this code allow customize tree view cells
		 *  
		 */
		treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
			@Override
			public TreeCell<String> call(TreeView<String> p) {
				return new CustomTreeCell();
			}
		});

		/**
		 * <a href="file:../resources/common/LayoutScene.fxml"> /LayoutScene.fxml</a>
		 */
		palette.setVisible(false);

		this.setOnKeyPressed(event -> {
					
			if (!(zoomIN_MacOS.match(event) || zoomOUT_MacOS.match(event) || zoomIN_Windows.match(event)
					|| zoomOUT_Windows.match(event)
					|| event.getCode().equals(KeyCode.DELETE) || event.getCode().equals(KeyCode.BACK_SPACE)
					|| event.getCode().equals(KeyCode.ESCAPE)))
				return;
			
			if (event.getCode().equals(KeyCode.DELETE) || event.getCode().equals(KeyCode.BACK_SPACE)) {
				CanvasManagementImpl.getInstance().deleteSelectedItems();
			}
			
			if (event.getCode().equals(KeyCode.ESCAPE)) {
				SelectionModel.clear(true);
			}
		

		});

		propertySheet.setSkin(new CustomPropertySheetSkin(propertySheet));
		propertySheet.setPropertyEditorFactory(new CustomPropertyEditorFactory());

		// Group properties by category
		propertySheet.setMode(Mode.CATEGORY);
		
		//Zoom init shortcut
		
	}
	

	/***********************************
	 *
	 * Canvas management
	 *
	 ***********************************/

	public Canvas getCanvas() {
		return getContainerCanvas().getCanvas();
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public ContainerCanvas getContainerCanvas() {
		return workspace.getContainerCanvas();
	}

	public void setIcon(Stage stage, String path) {

		URL imageResource = null;
		if (path == null || path == " " || path == "") {
			try {
				imageResource = new URL(LayoutScene.class.getResource("/common/img/Logo3.png").toExternalForm());
			} catch (MalformedURLException e) {
			}
		} else {
			try {
				imageResource = new URL(LayoutScene.class.getResource(path).toExternalForm());
			} catch (MalformedURLException e) {
			}

		}

		if (SystemUtils.IS_OS_MAC) {
			Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
			Image image = defaultToolkit.getImage(imageResource);
			Taskbar taskbar = Taskbar.getTaskbar();
			taskbar.setIconImage(image);
		}

		stage.getIcons().add(new javafx.scene.image.Image(imageResource.toExternalForm()));
	}
	
	public void setConfInstanceRoot (String confPlatformPath, String confBaseFolder) {
		
		int lastIndexOf = confPlatformPath.lastIndexOf(confBaseFolder);
		String path = confPlatformPath.substring(lastIndexOf + confBaseFolder.length());
		
		URL url = null;
		try {
			url = new URL(LayoutScene.class.getResource(path).toExternalForm());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		Resource resource = this.getResourceSet().getResource(URI.createURI(url.toString()), true);
		EcoreUtil.resolveAll(this.getResourceSet());
		
		this.confInstanceRoot = (MetaEditorConfiguration) resource.getContents().get(0);
		
		for (GraphicalElement graphicalElementTemp : confInstanceRoot.getGraphicalElements()) {
			//mi serve fare una copia perchè il graphicalElementTemp punta alla resource xmi, invece voglio la resource del genmodel
			GraphicalElement graphicalElement = EcoreUtil.copy(graphicalElementTemp);
			graphicalElement.getContainmentRef().clear();
			
			EClass graphicalElementEClass = (EClass)this.getEPackage(graphicalElementTemp.getElement().getEPackage().getNsURI()).getEClassifier(graphicalElementTemp.getElement().getName());
			graphicalElement.setElement(graphicalElementEClass);
			
			for (EReference eRefTemp : graphicalElementTemp.getContainmentRef()) {
				EReference eRef = (EReference)((EClass)this.getEPackage(((EClass)eRefTemp.eContainer()).getEPackage().getNsURI()).getEClassifier(((EClass)eRefTemp.eContainer()).getName())).getEStructuralFeature(eRefTemp.getName());
				graphicalElement.getContainmentRef().add(eRef);
				
				try {
					if (this.graphicalElementMap.put(graphicalElementEClass, eRef, graphicalElement) != null)
						throw new Exception("Puo' esistere una sola coppia (graphicalElement, containmentRef) associata ad una stessa metaclasse di dominio.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}



	/***********************************
	 *
	 * Model resourceset management
	 *
	 ***********************************/
	
	public ResourceSet getResourceSet() {
		if (this.resourceSet == null) {
			this.resourceSet = new ResourceSetImpl();
			this.resourceSet.getPackageRegistry().put(MetaEditorConfigurationPackage.eINSTANCE.getNsURI(), MetaEditorConfigurationPackage.eINSTANCE);
			this.resourceSet.getPackageRegistry().put(MetaEditorPersistencePackage.eINSTANCE.getNsURI(), MetaEditorPersistencePackage.eINSTANCE);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		}
		
		return this.resourceSet;
	}
	
	public EPackage getEPackage(String ePackageNSURI) {
		return this.getResourceSet().getPackageRegistry().getEPackage(ePackageNSURI);
	}

	public Resource getResource() {
		if (this.workspace.getContainerCanvas() != null)
			return this.workspace.getContainerCanvas().getResource();
		else 
			return null;
	}

	public EObject getDomainRoot() {
		return LayoutScene.getInstance().getResource().getAllContents().next();
	}

	public Resource getResourcePersistance() {
		return this.workspace.getContainerCanvas().getResourcePersistance();
	}

	public AdapterFactoryEditingDomain getEditingDomain() {
		return this.workspace.getContainerCanvas().getEditingDomain();
	}

	public MetaEditorPersistence getRootPersistence() {
		return this.workspace.getContainerCanvas().getRootPersistence();
	}

	public static BiMap<EObject, Ente> getViewModelMap() {
		return getInstance().getContainerCanvas().getViewModelMap();
	}

	public static Map<EObject, ElementPosition> getAllElementPositions() {
		return getInstance().getContainerCanvas().getAllElementPositions();
	}

	/**
	 * @return the minimum coordinates of persistence elements
	 */
	public int[] getMinCoordinate() {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		for (ElementPosition elemetPosition : getRootPersistence().getElementPositions()) {
			if (elemetPosition.getX() < minX) {
				minX = elemetPosition.getX();
			}

			if (elemetPosition.getY() < minY) {
				minY = elemetPosition.getY();
			}
		}

		return new int[] { minX, minY };
	}

	/**
	 * @param enti list of enti into canvas
	 * @return the minimum coordinates of persistence elements
	 */
	public int[] getMinCoordinate(List<Ente> enti) {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		List<ElementPosition> elementPositions = new ArrayList<>();
		for (Ente e : enti) {
			elementPositions.add((ElementPosition) e.elementPosition);
		}
		for (ElementPosition elemetPosition : elementPositions) {
			if (elemetPosition.getX() < minX) {
				minX = elemetPosition.getX();
			}

			if (elemetPosition.getY() < minY) {
				minY = elemetPosition.getY();
			}
		}

		return new int[] { minX, minY };
	}

	/** 
	 * @return the minimum coordinates of persistence elements
	 */
	public int[] getMaxCoordinate() {
		int maxX = 0;
		int maxY = 0;
		for (Node node : getCanvas().getChildren()) {
			DraggableNode dNode = (DraggableNode) node;
			if (dNode.getBoundsInParent().getMaxX() > maxX) {
				maxX = (int) dNode.getBoundsInParent().getMaxX();
			}

			if (dNode.getBoundsInParent().getMaxY() > maxY) {
				maxY = (int) dNode.getBoundsInParent().getMaxY();
			}
		}

		return new int[] { maxX, maxY };
	}
	
	
	/**
	 * 
	 * @param list of all object class that will be hide into canvas
	 */
	@SuppressWarnings("rawtypes")
	public void hideEnti(List<Class> list) {
		for (ContainerCanvas containerCanvas : LayoutScene.getInstance().getWorkspace().getAllContainerCanvas()) {
			containerCanvas.getCanvas().getChildren().forEach(node -> {
				if (node instanceof DraggableNode) {
					DraggableNode dNode = (DraggableNode) node;
					if (list.contains(dNode.getEnte().getClass())) {
						Platform.runLater(new Runnable() {
							public void run() {
								FXMLUtil.nodeVisibility(dNode.getEnte(), false);
							}
						});
					}
				}
			});
		}

	}
	
	public VBox getPalette() {
		return palette;
	}

	/**
	 * Show the domain root properties 
	 */
	public void showRootProperties() {
		if (LayoutScene.getInstance().getResource() != null) {
			rootFX.populatePropertyView();
		}
	}

	/**
	 * 
	 * @param itemName the name of an eStructuralFeature of a metaclass defined in the domain metamodel
	 * @return CustomPropertyItem 
	 */
	public static BackedCustomPropertyItem findPropertyField(String itemName) {
		return ((CustomPropertyEditorFactory) getInstance().propertySheet.getPropertyEditorFactory()).getItems()
				.get(itemName);
	}
	
	public void setWelcomeUI() {
		ObservableList<MenuItem> fileItems = CustomMenu.getInstance().menuFile.getItems();
		for (MenuItem item : fileItems.subList(4, fileItems.size())) {
			item.setDisable(true);
		}
		CustomMenu.getInstance().menuVisualizza.getItems().forEach(item -> item.setDisable(true));
		CustomMenu.getInstance().menuModifica.getItems().forEach(item -> item.setDisable(true));
		CustomMenu.getInstance().menuStrumenti.getItems().forEach(item -> item.setDisable(true));
		LayoutScene.getInstance().treeView.setRoot(null);
		LayoutScene.getInstance().propertySheet.getItems().clear();
		LayoutScene.getInstance().palette.setVisible(false);
	}
	
	public void closeApp() {
		Platform.exit();
		System.exit(0);
	}
}
