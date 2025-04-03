package it.gssi.astra.metaeditor.common.canvas;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration;
import MetaEditor.MetaEditorConfiguration.RotationPosition;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.interfaces.ICanvasManagement;
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeItem;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeView;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

public class CanvasManagementImpl implements ICanvasManagement {
	
	private static CanvasManagementImpl instance;
	
	public static void setInstance(CanvasManagementImpl instance) {
		CanvasManagementImpl.instance = instance;
	}

	public static CanvasManagementImpl getInstance() {

		if (instance == null) {
			instance = new CanvasManagementImpl();
		}

		return instance;
	}

	/**
	 * Instantiate FX presentation of a graphical element and adds it to Canvas
	 *
	 *@param The EObject of the domain element
	 *@param The EObject of the parent of the domain element
	 *@param The containment reference from parent to child
	 *
	 */
	public void addElement(EObject model, EObject parent, EReference domainContainmentRef) {
		LayoutScene layoutSceneInstance = LayoutScene.getInstance();
		Map<EObject, ElementPosition> map = layoutSceneInstance.getAllElementPositions();
		AnchorPane canvas = layoutSceneInstance.getCanvas();
		MetaEditorConfiguration confInstanceRoot = layoutSceneInstance.confInstanceRoot;
		
		GraphicalElement graphicalElement = layoutSceneInstance.graphicalElementMap.get(model.eClass(), domainContainmentRef);
		
		if (graphicalElement != null) {
			
			List<String > listaContainmentRefNames = new ArrayList<String>();
			for (EReference eRef : graphicalElement.getContainmentRef()) {
				listaContainmentRefNames.add(eRef.getName());
			}
			
			if (listaContainmentRefNames.contains(domainContainmentRef.getName())) {
				
				ElementPosition elementPosition = map.get(model);
				if(elementPosition == null) {
					elementPosition = MetaEditorPersistenceFactory.eINSTANCE.createElementPosition();
					elementPosition.setElement(model);
					layoutSceneInstance.getRootPersistence().getElementPositions().add(elementPosition);
				}
				
				Ente newEnte = null;
				try {
					Class<?> cl = Class.forName(layoutSceneInstance.srcBasePath +"."
												+  StringUtils.uncapitalize(confInstanceRoot.getName()) 
												+ ".presentation." + graphicalElement.getName() + "FX");
					 
					Class<?>[] type = { model.getClass().getInterfaces()[0], ElementPosition.class, GraphicalElement.class };
					Constructor<?> cons = cl.getConstructor(type);
					Object[] obj = { model, elementPosition, graphicalElement };
					newEnte = (Ente) cons.newInstance(obj);
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				DraggableNode dnode = new DraggableNode(newEnte);
				canvas.getChildren().add(dnode);
				newEnte.initialization();
				
				dnode.synchronizePosition(newEnte, elementPosition);
				
				newEnte.postInit();
				
				if (domainContainmentRef.getEContainingClass().getName().equals(confInstanceRoot.getRootElement().getName())) {
					CustomTreeView.addElementInTreeView(dnode, domainContainmentRef.getEType().getName());
				}
				else {
					Ente enteParentFX = LayoutScene.getViewModelMap().get(parent);
					CustomTreeItem treeItem = new CustomTreeItem();
					treeItem.setDraggableNode(dnode);
					enteParentFX.treeItem.getChildren().add(treeItem);
				}
				
				//serve per resettare l'attributo rotazione se il graphical element non è ruotabile
				if (newEnte.allowedRotationPositions.size() == 0 && elementPosition.getRotationPosition() != RotationPosition.DEFAULT) {
					new EMFCommands().set(elementPosition, 
									MetaEditorPersistencePackage.eINSTANCE.getRotationPosition_RotationPosition(), 
									RotationPosition.DEFAULT);
				}
				
				return ;
			}
		}
		else {
			/*try {
				throw new Exception("La classe: " + model.eClass().getName() + " e la ref: " + domainContainmentRef.getName() + " non hanno un graphical element associato.");
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		}
	}

	/**
	 * Deletes all selected nodes of {@link SelectionModel}. It uses {@code RemoveCommand} instead of {@code DeleteCommand}
	 * because the last one had some problem (TODO: check again to improve this doc).
	 * 
	 * It's important to respect the order of node deletion to be able to recreate the children hierarchy in case of CTRL-Z.
	 */
	@Override
	public void deleteSelectedItems() {

		AdapterFactoryEditingDomain editingDomain = LayoutScene.getInstance().getEditingDomain();

		List<DraggableNode> removedDNodes = new ArrayList<DraggableNode>();
		List<DraggableNode> addedDNodes = new ArrayList<DraggableNode>();

		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();

		// Removes leafs first, but cycle until all selected nodes are removed
		while (SelectionModel.size() > 0) {
			for (DraggableNode dNode : SelectionModel.getSelection()) {

				EObject model = (EObject) dNode.getEnte().getModel();

				if (!(model.eContents().size() > 0)) {

					dNode.getEnte().dropOldConnections();

					for (AnchorPoint ap : dNode.getEnte().getAnchorPoints()) {
						ap.dispose();
					}

					EObject eContainer = model.eContainer();
					EStructuralFeature feature = model.eContainmentFeature();

					if (feature.isMany()) {
						emfCommand.remove(eContainer, feature, model);
					} else {
						emfCommand.set(eContainer, feature, null);
					}
					
					removeCrossReferences(editingDomain, model);

					removedDNodes.add(dNode);
				}
				// Select children if not selected
				else {
					for (EObject eo : model.eContents()) {

						DraggableNode childNode = LayoutScene.getViewModelMap().get(eo).getDraggableNode();
						addedDNodes.add(childNode);
					}
				}
			}

			SelectionModel.getSelection().addAll(addedDNodes);
			addedDNodes.clear();
			SelectionModel.getSelection().removeAll(removedDNodes);
			removedDNodes.clear();
		}

		emfCommand.end();
		
		Platform.runLater(() -> {
			SelectionModel.clear(true);
		});
	}
	
	/**
	 * Called by {@link LayoutScene#deleteSelectedItems()}.
	 * This methods removes any dangling reference of the EObject being removed.
	 * 
	 * @param editingDomain
	 * @param model The instance of domain meta-model class
	 */
	private static void removeCrossReferences(AdapterFactoryEditingDomain editingDomain, EObject model) {
		Collection<EObject> eObjects = new ArrayList<EObject>();
		eObjects.add(model);
		Map<EObject, Collection<EStructuralFeature.Setting>> usages = findReferences(eObjects);

		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages.entrySet()) {
			EObject eObject = entry.getKey();
			if (eObject.eResource() == null) {
				Collection<EStructuralFeature.Setting> settings = entry.getValue();
				for (EStructuralFeature.Setting setting : settings) {
					EObject referencingEObject = setting.getEObject();
					if (!eObjects.contains(referencingEObject)) {
						EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
						if (eStructuralFeature.isChangeable()) {
							EMFCommands emfCommand = new EMFCommands();
							if (eStructuralFeature.isMany()) {
								emfCommand.remove(referencingEObject, eStructuralFeature, eObject);
							} else {
								emfCommand.set(referencingEObject, eStructuralFeature, SetCommand.UNSET_VALUE);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Returns the references to the objects in the given collection that are to be
	 * cleared. The default implementation uses {@link UsageCrossReferencer} to find
	 * all incoming cross references.
	 * 
	 * @see UsageCrossReferencer
	 */
	protected static Map<EObject, Collection<EStructuralFeature.Setting>> findReferences(Collection<EObject> eObjects) {
		return EcoreUtil.UsageCrossReferencer.findAll(eObjects,
				LayoutScene.getInstance().getEditingDomain().getResourceSet());
	}


}
