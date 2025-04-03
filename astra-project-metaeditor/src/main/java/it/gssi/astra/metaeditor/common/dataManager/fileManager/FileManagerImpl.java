package it.gssi.astra.metaeditor.common.dataManager.fileManager;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.ContainerCanvas;
import it.gssi.astra.metaeditor.common.dataManager.commands.CustomCommandStack;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.EnteBendable;
import it.gssi.astra.metaeditor.common.ente.customNode.BendPoint;
import it.gssi.astra.metaeditor.common.interfaces.IFileManager;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;
import it.gssi.astra.metaeditor.common.popup.ChooseLoadFilesPopup;
import it.gssi.astra.metaeditor.common.popup.Popup;
import javafx.concurrent.Task;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;

public class FileManagerImpl implements IFileManager {

	static FileManagerImpl instance;

	public static void setInstance(FileManagerImpl instance) {
		FileManagerImpl.instance = instance;
	}

	public static FileManagerImpl getInstance() {

		if (instance == null) {
			instance = new FileManagerImpl();
		}

		return instance;
	}

	private String file_Extension = "xmi";

	public String getFileExtention() {
		return this.file_Extension;
	}
	
	public void setFile_Extension(String file_Extension) {
		this.file_Extension = file_Extension;
	}

	private String file_Extension_Persistence = "layout";

	public String getFileExtentionPersistence() {
		return this.file_Extension_Persistence;
	}
	
	public void setFile_Extension_Persistence(String file_Extension_Persistence) {
		this.file_Extension_Persistence = file_Extension_Persistence;
	}

	private String loadPath = "";


	@Override
	public boolean create(List<String> paths) {

		if (paths != null) {

			String title = paths.get(1).replace("." + file_Extension, "");
			title = title.replace(".xmi", "");
			String path = paths.get(0) + File.separator + paths.get(1);
			String pathPersistence = paths.get(1).replace("." + file_Extension, "");
			pathPersistence = pathPersistence.replace(".xmi", "");
			String pathPers = paths.get(0) + File.separator + pathPersistence + "." + file_Extension
					+ file_Extension_Persistence;

			try {

				AdapterFactoryEditingDomain editingDomain;

				CustomCommandStack commandStack;
				ComposedAdapterFactory adapterFactory;

				// This is the one adapter factory used for providing views of the model (it
				// works with Eclipse Plug in Development framework).
				adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

				// Create the command stack that will notify this editor as commands are
				// executed.
				commandStack = new CustomCommandStack();

				// Add a listener to set the most recent command's affected objects to be the
				// selection of the viewer with focus.
				commandStack.addCommandStackListener(new CommandStackListener() {
					@Override
					public void commandStackChanged(final EventObject event) {
						if (((CustomCommandStack) (CommandStack) event.getSource()).isSaveNeeded()) {
							LayoutScene.getInstance().getWorkspace().enableAsterisk();
						} else {
							LayoutScene.getInstance().getWorkspace().disableAsterisk();
						}

						Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							// Do something...
							// databindingContext.updateTargets();
//							System.out.println(mostRecentCommand);
						}
					}
				});

				// This keeps track of the editing domain that is used to track all changes to
				// the model.
				editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, LayoutScene.getInstance().getResourceSet());

				URI uri = URI.createFileURI(path);
				Resource resource = editingDomain.getResourceSet().createResource(uri);

				URI uriPers = URI.createFileURI(pathPers);
				Resource resourcePersistence = editingDomain.getResourceSet().createResource(uriPers);

				EcoreUtil.resolveAll(editingDomain.getResourceSet());

				// Resource resource = ModelUtility.createModel(path);
				// Resource resourcePersistence = ModelUtility.createModel(pathPers);

				MetaEditorPersistence rootPersistence = MetaEditorPersistenceFactory.eINSTANCE
						.createMetaEditorPersistence();
				resourcePersistence.getContents().add(rootPersistence);
				resource = LayoutScene.getInstance().createRootElement(resource);
				
				resource.setTrackingModification(true);
				resourcePersistence.setTrackingModification(true);

				LayoutScene.getInstance().getWorkspace().createCanvas(title, resource, resourcePersistence,
						rootPersistence, editingDomain);

				saveModel(resource);
				saveModel(resourcePersistence);

				File newFile = new File(path);
				File newFileP = new File(pathPers);
				newFileP.createNewFile();
				newFile.createNewFile();

				return true;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public void saveAs(List<String> paths) {
		
		if (paths != null) {

			String title = paths.get(1).replace("." + file_Extension, "").replace(".xmi", "");

			String path = paths.get(0) + File.separator + paths.get(1);

			String pathPers = paths.get(0) + File.separator + title + "." + file_Extension + file_Extension_Persistence;

			try {
				// Update uri resource
				URI uri = URI.createFileURI(path);
				LayoutScene.getInstance().getWorkspace().getContainerCanvas().getResource().setURI(uri);

				// Update uri persistance
				URI uriPers = URI.createFileURI(pathPers);
				LayoutScene.getInstance().getWorkspace().getContainerCanvas().getResourcePersistance().setURI(uriPers);

				File newFile = new File(path);
				File newFileP = new File(pathPers);
				newFileP.createNewFile();
				newFile.createNewFile();

				save();

				// Update title and tooltip
				LayoutScene.getInstance().getWorkspace().getSelectedTab().setText(title);
				LayoutScene.getInstance().getWorkspace().getSelectedTab().setTooltip(new Tooltip(path));

			} catch (IOException e) {
				Popup.dialog("Errore", "Impossibile salvare");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void save() {
		
		if (LayoutScene.getInstance().getResourcePersistance() != null) {

			// Check if some objects are outside of canvas
			int[] minCoords = LayoutScene.getInstance().getMinCoordinate();
			int[] maxCoords = LayoutScene.getInstance().getMaxCoordinate();

			if (maxCoords[0] > LayoutScene.getInstance().getContainerCanvas().getGrid().getGridWidth()
					|| maxCoords[1] > LayoutScene.getInstance().getContainerCanvas().getGrid().getGridHeight()
					|| minCoords[0] < 0 || minCoords[1] < 0) {
				Popup.dialog("Attenzione", "Ci sono elementi fuori dal canvas");
				return;
			} else {
				save(LayoutScene.getInstance().getWorkspace().getContainerCanvas());
				//Popup.dialog("Salvataggio", "Salvataggio effettuato con successo.");
			}

		} else {
			Popup.warning("Errore di Salvataggio", "Non è stato caricato nessun xmi ...");
		}
	}
	

	private void save(ContainerCanvas canvas) {

		int canvasWidth = LayoutScene.getInstance().getWorkspace().getContainerCanvas().getGrid().getGridWidth();
		int canvasHeight = LayoutScene.getInstance().getWorkspace().getContainerCanvas().getGrid().getGridHeight();

		LayoutScene.getInstance().getRootPersistence().setCanvasWidth(canvasWidth);
		LayoutScene.getInstance().getRootPersistence().setCanvasHeight(canvasHeight);

		
		
		/************************************************************
		 * START REGION - Model custom low level checks before saving
		 ************************************************************/
		
		canvas.getCanvas().getChildren().forEach(node -> {

			if (node instanceof DraggableNode) {
				DraggableNode dNode = (DraggableNode) node;

				if (dNode.getEnte() instanceof EnteBendable) {
					EnteBendable eb = (EnteBendable) dNode.getEnte();

					if (eb.customLine.getPuntiPolilinea().size() > 1) {
						double minX = 999999;
						double minY = 999999;

						for (BendPoint bendPoint : eb.customLine.getPuntiPolilinea()) {

							if (bendPoint.getCenterX() < minX)
								minX = bendPoint.getCenterX();

							if (bendPoint.getCenterY() < minY)
								minY = bendPoint.getCenterY();
						}

						if (minX != 0 || minY != 0) {
							System.out.println("Bendable element - " + eb.getMetaClassName() + ": " + eb
									+ " automatic correction of coordinates");

							dNode.setLayoutX((int) Math.round(dNode.getLayoutX() + minX));
							dNode.setLayoutY((int) Math.round(dNode.getLayoutY() + minY));

							for (BendPoint bendPoint : eb.getCustomLine().getPuntiPolilinea()) {
								bendPoint.setCenterX((int) Math.round(bendPoint.getCenterX() - minX));
								bendPoint.setCenterY((int) Math.round(bendPoint.getCenterY() - minY));
							}
						}
					}
				}
			}
		});
		
		// Find and remove from persistence model all objects with dangling references
		MetaEditorPersistence persistence = canvas.getRootPersistence();
		
		Map<EObject, Collection<Setting>> proxies = EcoreUtil.UnresolvedProxyCrossReferencer.find(persistence);

		for (Entry<EObject, Collection<Setting>> entry : proxies.entrySet()) {
			
			for (Setting sett : entry.getValue()) {
				EcoreUtil.remove(sett.getEObject());
			}
		}
		
		/**********************************************************
		 * END REGION - Model custom low level checks before saving
		 **********************************************************/

		saveModel(canvas.getResourcePersistance());
		saveModel(canvas.getResource());
		((CustomCommandStack) canvas.getEditingDomain().getCommandStack()).saveIsDone();

		Tab currentTab = null;

		for (Tab tab :  LayoutScene.getInstance().getWorkspace().getTabs()) {
			if (tab.getContent() == canvas) {
				currentTab = tab;
				continue;
			}
		}

		 LayoutScene.getInstance().getWorkspace().getTabs().get( LayoutScene.getInstance().getWorkspace().getTabs().indexOf(currentTab)).setGraphic(null);
	}

	@Override
	public void saveAll() {
		if ( LayoutScene.getInstance().getResourcePersistance() != null) {
			 LayoutScene.getInstance().getWorkspace().getAllContainerCanvas().forEach(canvas -> {
				save(canvas);
			});
			//Popup.dialog("Salvataggio", "Salvataggio effettuato con successo.");
		} else {
			Popup.warning("Errore di Salvataggio", "Non è stato caricato nessun xmi ...");
		}
	}

	/**
	 * 
	 * Load files from folder
	 * 
	 */
	@Override
	public void loadFolder() {
		try {
			String pathDirectory = Popup.chooseDirectory(LayoutScene.getInstance());
			if (pathDirectory == null)
				return;

			// Search for files with extension in the folder
			List<File> files = findFilesInDirectory(pathDirectory, FileManagerImpl.getInstance().getFileExtention());

			// Load files in sequence
			if (files != null && files.size() >= 1) {
				loadFiles(files);
			} else {
				Popup.warning("Errore carimento",
						"Non sono trovati files con estensione [." + FileManagerImpl.getInstance().getFileExtention() + "]");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Load files from a folder and into subfolders ( search is only at the first
	 * level of subfolders )
	 * 
	 */
	@Override
	public void loadSelection() {
		try {
			String pathDirectory = Popup.chooseDirectory(LayoutScene.getInstance());
			if (pathDirectory == null)
				return;

			List<File> filesFound = new LinkedList<>();

			// Search files in current directory and add files
			List<File> filesInCurrentDir = findFilesInDirectory(pathDirectory, FileManagerImpl.getInstance().getFileExtention());
			filesFound.addAll(filesInCurrentDir);

			// Search in sub directories and add to files
			File[] directories = new File(pathDirectory)
					.listFiles((File current, String name) -> new File(current, name).isDirectory());

			for (File dir : directories) {
				// Search for files with extension in the folder
				filesFound.addAll(findFilesInDirectory(dir.getAbsolutePath(), FileManagerImpl.getInstance().getFileExtention()));
			}

			// Load files in sequence
			if (filesFound.size() >= 1) {

				List<File> fileSelected = ChooseLoadFilesPopup.showDialog(filesFound);

				loadFiles(fileSelected);
			} else {
				Popup.warning("Errore carimento",
						"Non sono trovati files con estensione [." + FileManagerImpl.getInstance().getFileExtention() + "]");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Load files in sequence
	 * 
	 * @param files
	 */
	@Override
	public void loadFiles(List<File> files) {
		loadFilesRecursive(0, files);
	}

	/**
	 * 
	 * Load file recursively. At the end of the task of loading one file, load the
	 * next one
	 * 
	 * 
	 * @param index
	 * @param files
	 */
	@Override
	public void loadFilesRecursive(int index, List<File> files) {
		if (files.isEmpty())
			return;

		File currFile = files.get(index);

		Task<Void> loadTask = this.load(Arrays.asList(currFile.getParentFile().getPath(), currFile.getName()));
		int next = index + 1;

		if (index < files.size() - 1) {
			loadTask.setOnSucceeded(e -> loadFilesRecursive(next, files));
		}
	}

	@Override
	public Task<Void> load(List<String> paths) {
		
		if (paths != null) {

			String title = paths.get(1).replace("." + FileManagerImpl.getInstance().getFileExtention(), "");
			title = title.replace(".xmi", "");
			loadPath = paths.get(0) + File.separator + paths.get(1);

			String pathPersistence = paths.get(1).replace("." + FileManagerImpl.getInstance().getFileExtention(), "");
			pathPersistence = pathPersistence.replace(".xmi", "");
			String loadPathPersistence = paths.get(0) + File.separator + pathPersistence + "."
					+ FileManagerImpl.getInstance().getFileExtention() + FileManagerImpl.getInstance().getFileExtentionPersistence();

			AdapterFactoryEditingDomain editingDomain;

			CustomCommandStack commandStack;
			ComposedAdapterFactory adapterFactory;

			// layoutScene is the one adapter factory used for providing views of the model
			// (it works with Eclipse Plug in Development framework).
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

			// Create the command stack that will notify layoutScene editor as commands are
			// executed.
			commandStack = new CustomCommandStack();

			// Add a listener to set the most recent command's affected objects to be the
			// selection of the viewer with focus.
			commandStack.addCommandStackListener(new CommandStackListener() {
				@Override
				public void commandStackChanged(final EventObject event) {
					if (((CustomCommandStack) (CommandStack) event.getSource()).isSaveNeeded()) {
						LayoutScene.getInstance().getWorkspace().enableAsterisk();
					} else {
						LayoutScene.getInstance().getWorkspace().disableAsterisk();
					}
					Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
					if (mostRecentCommand != null) {
						// Do something...
						// databindingContext.updateTargets();

					}
				}
			});

			// layoutScene keeps track of the editing domain that is used to track all
			// changes to the model.
			editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, LayoutScene.getInstance().getResourceSet());

			URI uriPers = URI.createFileURI(loadPathPersistence);
			Resource resourcePersistence;

			try {
				resourcePersistence = editingDomain.getResourceSet().getResource(uriPers, true);
				// Exists Resource and Resource Persistence
				URI uri = URI.createFileURI(loadPath);
				Resource resource = editingDomain.getResourceSet().getResource(uri, true);
				EcoreUtil.resolveAll(editingDomain.getResourceSet());
				
				resource.setTrackingModification(true);
				resourcePersistence.setTrackingModification(true);
				
				MetaEditorPersistence rootPersistence = (MetaEditorPersistence) resourcePersistence.getContents()
						.get(0);

				if (rootPersistence.eContents().isEmpty()) {
					LayoutScene.getInstance().getWorkspace().createCanvas(title, resource, resourcePersistence, rootPersistence,
							editingDomain);
				} else {
					LayoutScene.getInstance().getWorkspace().loadCanvas(title, resource, resourcePersistence, rootPersistence,
							editingDomain);
				}

				LayoutScene.getInstance().palette.setVisible(true);

				CustomMenu.getInstance().disableMenu(false);

				EObject root = resource.getContents().get(0);

				LoadTask l = new LoadTask();
				return l.loadObjects(root);

			} catch (Exception e) {
				try {

					// Exists Resource but not exists Resource Persistence

					URI uri = URI.createFileURI(loadPath);
					Resource resource = editingDomain.getResourceSet().getResource(uri, true);
					resourcePersistence = editingDomain.getResourceSet().createResource(uriPers);
					EcoreUtil.resolveAll(editingDomain.getResourceSet());
					MetaEditorPersistence rootPersistence;
					File newFileP = new File(loadPathPersistence);
					if (!newFileP.exists()) {
						resourcePersistence = editingDomain.getResourceSet().createResource(uriPers);
						EcoreUtil.resolveAll(editingDomain.getResourceSet());
						rootPersistence = MetaEditorPersistenceFactory.eINSTANCE.createMetaEditorPersistence();
						resourcePersistence.getContents().add(rootPersistence);
						saveModel(resourcePersistence);
						newFileP.createNewFile();
					} else {
						rootPersistence = (MetaEditorPersistence) resourcePersistence.getContents().get(0);
					}
					LayoutScene.getInstance().getWorkspace().createCanvas(title, resource, resourcePersistence, rootPersistence,
							editingDomain);

					LayoutScene.getInstance().palette.setVisible(true);

					CustomMenu.getInstance().disableMenu(false);

					EObject root = resource.getContents().get(0);

					LoadTask l = new LoadTask();
					return l.loadObjects(root);

				} catch (Exception e1) {
					// TODO: handle exception
					Popup.dialog("Attenzione", "Errore caricamento: " + e.getMessage());
				}
			}

		}

		return null;
	}
	
	public static List<File> findFilesInDirectory(String pathDirectory, String fileExtension) {

		File dir = new File(pathDirectory);

		File[] files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(fileExtension);
			}
		});

		List<File> paths = new ArrayList<>();
		for (File xmlfile : files) {
			paths.add(xmlfile);
		}

		return paths;
	}
	
	//impostato per salvare nell'xmi esplicitamente anche i valori di default
	public void saveModel (Resource resource) {
		Map<Object, Object> saveOptionsResource = ((XMLResource)resource).getDefaultSaveOptions();
		saveOptionsResource.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		
		try {
			resource.save(saveOptionsResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
