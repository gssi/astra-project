package it.gssi.astra.metaeditor.common.dataManager.cloneManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.ente.DraggableNode;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.interfaces.IClone;
import it.gssi.astra.metaeditor.common.popup.Popup;

public class CloneImpl implements IClone {

	private static CloneImpl instance;

	public static void setInstance(CloneImpl instance) {
		CloneImpl.instance = instance;
	}

	public static CloneImpl getInstance() {

		if (instance == null) {
			instance = new CloneImpl();
		}

		return instance;
	}

	public int clickedX, clickedY;

	private List<Ente> oldEnti = new ArrayList<>();
	private List<EObject> oldEObjects = new ArrayList<>();

	@Override
	public void copy() {
		oldEnti.clear();
		oldEObjects.clear();

		for (DraggableNode dNode : SelectionModel.getSelection()) {

			Ente ente = dNode.getEnte();
			EObject model = (EObject) ente.getModel();

			// Inizialmente inseriamo solo i padri
			if (model.eContainer() == LayoutScene.getInstance().getDomainRoot()) {
				oldEnti.add(ente);
			}

		}

		for (Ente e : oldEnti) {
			oldEObjects.add((EObject) e.getModel());
		}

		// La 'CopyToClipboardCommand' copia i model di tutti gli enti della lista
		// 'oldEnti' ma anche i model dei figli
		CopyToClipboardCommand copyCommand = (CopyToClipboardCommand) CopyToClipboardCommand
				.create(LayoutScene.getInstance().getEditingDomain(), oldEObjects);
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(copyCommand);

		// Completiamo la lista 'oldEnti' aggiungendo tutti i figli dei padri
		// selezionati
		for (EObject modelPadre : oldEObjects) {

			TreeIterator<EObject> iterator = modelPadre.eAllContents();

			while (iterator.hasNext()) {
				oldEnti.add(LayoutScene.getViewModelMap().get(iterator.next()));
			}
		}
	}

	/**
	 * 
	 * Called by context menu or CTRL-V
	 * 
	 * @param offset False if you want to paste objects at the same position of
	 *               cursor. True in order to paste with an offset relative to
	 *               original objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void paste(boolean offset) {
		// Clone the clipboard to allow multiple paste

		Command copyClipboard = CopyCommand.create(LayoutScene.getInstance().getEditingDomain(),
				LayoutScene.getInstance().getEditingDomain().getClipboard());
		try {
			copyClipboard.execute();
		} catch (java.lang.UnsupportedOperationException e) {
			//voglio incollare qualcosa copiato al di fuori dell'editor
			//e che quindi è impossibile incollare
			return;
		}
		Collection<Object> copiedClipboard = new ArrayList<Object>(copyClipboard.getResult());

		Iterator<Object> clipboardIterator = copiedClipboard.iterator();

		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();

		// Find min coords
		int[] minCoords = LayoutScene.getInstance().getMinCoordinate(oldEnti);

		List<EObject> oldObjects = oldEObjects;

		List<EObject> listElementiCopia = new ArrayList<>();

		for (EObject padre_originale : oldObjects) {

			EObject padre_copiato = ((EObject) clipboardIterator.next());

			// Associate original object to copied ones
			Map<EObject, EObject> coppie = new HashMap<EObject, EObject>();

			TreeIterator<EObject> figli_originali = padre_originale.eAllContents();
			TreeIterator<EObject> figli_copiati = padre_copiato.eAllContents();

			figli_originali.forEachRemaining((child) -> {
				coppie.put((EObject) child, figli_copiati.next());
			});
			coppie.put(padre_originale, padre_copiato);

			for (EObject oggetto_originale : coppie.keySet()) {

				EObject oggetto_copiato = coppie.get(oggetto_originale);

				listElementiCopia.add(oggetto_copiato);

				// Clone the element position too and put it in persistence
				if (offset) {
					copyElementPositionWithOffset(oggetto_originale, oggetto_copiato);
				} else {
					copyElementPositionOnCursor(oggetto_originale, oggetto_copiato, minCoords);
				}

				// Set to null the references which point to an object not contained by the
				// clipboard
				for (EReference ref : oggetto_originale.eClass().getEAllReferences()) {
					if (!ref.isContainment()) {

						if (ref.getUpperBound() == 1) {
							
							EObject valore_originale_della_ref = (EObject) oggetto_originale.eGet(ref);
							EObject valore_copiato_della_ref = (EObject) oggetto_copiato.eGet(ref);

							// If the objects are the same, it means it was not cloned
							if (valore_originale_della_ref == valore_copiato_della_ref) {
								oggetto_copiato.eSet(ref, null);
							}
							
						} else {
							if (!ref.isDerived()) {

								EList<EObject> lista_originale = (EList<EObject>) oggetto_originale.eGet(ref);
								EList<EObject> lista_dopo_la_copia = (EList<EObject>) oggetto_copiato.eGet(ref);

								EList<EObject> lista_modificata = new BasicEList<EObject>();
								lista_modificata.addAll(lista_dopo_la_copia);

								// Remove any object from the new list that was in the old list too, meaning it was not selected,
								// hence not copied and the reference is to the old object.
								// Remember that copyToClipboard copies also children even if not selected
								for (EObject value : lista_dopo_la_copia) {

									if (lista_originale.contains(value)) {
										lista_modificata.remove(value);
									}
								}

								oggetto_copiato.eSet(ref, lista_modificata);
							}
						}
					}
				}
			}

			EStructuralFeature feature = padre_originale.eContainmentFeature();
			emfCommand.insert(LayoutScene.getInstance().getDomainRoot(), feature, padre_copiato);
		}

		emfCommand.end();

		// Check if some objects are outside of canvas
		int[] maxCoords = LayoutScene.getInstance().getMaxCoordinate();

		if (maxCoords[0] > LayoutScene.getInstance().getContainerCanvas().getGrid().getGridWidth()
				|| maxCoords[1] > LayoutScene.getInstance().getContainerCanvas().getGrid().getGridHeight()) {
			Popup.dialog("Attenzione", "Ci sono elementi fuori dal canvas");
		}

		// Select the copied elements
		SelectionModel.clear(false);
		List<DraggableNode> addToSelectionModel = new ArrayList<DraggableNode>();
		for (EObject oggettoCopia : listElementiCopia) {
			Ente oEnte = LayoutScene.getViewModelMap().get(oggettoCopia);
			if (oEnte != null) {
				addToSelectionModel.add(oEnte.getDraggableNode());
			}
		}
		SelectionModel.add(addToSelectionModel);
	}

	/**
	 * Incolla in funzione del mouse
	 * 
	 * @param oldModel
	 * @param newModel
	 * @param minCoords
	 */
	private void copyElementPositionOnCursor(EObject oldModel, EObject newModel, int[] minCoords) {

		Ente enteOriginale = LayoutScene.getViewModelMap().get(oldModel);
		if (enteOriginale == null) {
			enteOriginale = getEnteOriginale(oldModel, enteOriginale);
		}

		ElementPosition newElementPosition = EcoreUtil.copy((ElementPosition) enteOriginale.elementPosition);

		newElementPosition.setElement(newModel);

		if (newElementPosition.getX() == minCoords[0] && newElementPosition.getY() == minCoords[1]) {
			newElementPosition.setX(clickedX);
			newElementPosition.setY(clickedY);
		} else {
			newElementPosition.setX(clickedX + (newElementPosition.getX() - minCoords[0]));
			newElementPosition.setY(clickedY + (newElementPosition.getY() - minCoords[1]));
		}

		if (LayoutScene.getInstance().getRootPersistence().getCanvasWidth() < newElementPosition.getX()
				+ enteOriginale.getDraggableNode().getBoundsInParent().getWidth()) {
			LayoutScene.getInstance().getContainerCanvas().updateGrid(
					(int) (newElementPosition.getX() + enteOriginale.getDraggableNode().getBoundsInParent().getWidth()),
					LayoutScene.getInstance().getRootPersistence().getCanvasHeight());
		}

		if (LayoutScene.getInstance().getRootPersistence().getCanvasHeight() < newElementPosition.getY()
				+ enteOriginale.getDraggableNode().getBoundsInParent().getHeight()) {
			LayoutScene.getInstance().getContainerCanvas().updateGrid(
					LayoutScene.getInstance().getRootPersistence().getCanvasWidth(), (int) (newElementPosition.getY()
							+ enteOriginale.getDraggableNode().getBoundsInParent().getHeight()));
		}

		new EMFCommands().add(LayoutScene.getInstance().getRootPersistence(),
				MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(),
				newElementPosition);

		LayoutScene.getAllElementPositions().put(newModel, newElementPosition);
	}

	/**
	 * Incolla senza prendere la posizione originale del mouse
	 * 
	 * @param oldModel
	 * @param newModel
	 */
	private void copyElementPositionWithOffset(EObject oldModel, EObject newModel) {

		Ente enteOriginale = LayoutScene.getViewModelMap().get(oldModel);

		if (enteOriginale == null) {
			enteOriginale = getEnteOriginale(oldModel, enteOriginale);
		}

		ElementPosition newElementPosition = EcoreUtil.copy((ElementPosition) enteOriginale.elementPosition);

		newElementPosition.setElement(newModel);

		newElementPosition.setX(newElementPosition.getX() + 50);
		newElementPosition.setY(newElementPosition.getY() + 50);

		if (LayoutScene.getInstance().getRootPersistence().getCanvasWidth() < newElementPosition.getX()
				+ enteOriginale.getDraggableNode().getBoundsInParent().getWidth()) {
			LayoutScene.getInstance().getContainerCanvas().updateGrid(
					(int) (newElementPosition.getX() + enteOriginale.getDraggableNode().getBoundsInParent().getWidth()),
					LayoutScene.getInstance().getRootPersistence().getCanvasHeight());
		}

		if (LayoutScene.getInstance().getRootPersistence().getCanvasHeight() < newElementPosition.getY()
				+ enteOriginale.getDraggableNode().getBoundsInParent().getHeight()) {
			LayoutScene.getInstance().getContainerCanvas().updateGrid(
					LayoutScene.getInstance().getRootPersistence().getCanvasWidth(), (int) (newElementPosition.getY()
							+ enteOriginale.getDraggableNode().getBoundsInParent().getHeight()));
		}

		new EMFCommands().add(LayoutScene.getInstance().getRootPersistence(),
				MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(),
				newElementPosition);

		LayoutScene.getAllElementPositions().put(newModel, newElementPosition);
	}

	private Ente getEnteOriginale(EObject oldModel, Ente enteOriginale) {

		for (Ente ente : oldEnti) {

			if (oldModel.equals(ente.getModel())) {
				return ente;
			}
		}
		return null;
	}

}
