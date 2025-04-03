package it.gssi.astra.metaeditor.common.palette;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.dataManager.commands.BeginAtomicSequenceCommand;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.dataManager.commands.EndAtomicSequenceCommand;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.interfaces.IPalette;
import it.gssi.astra.metaeditor.common.popup.Popup;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.VBox;

public class PaletteImpl implements IPalette {

	@Override
	public void populatePalette(PaletteGesture paletteGesture, VBox palette) {
		for (GraphicalElement graphicalElement : LayoutScene.getInstance().graphicalElementMap.values()) {
			if (getRootContainmentRef(graphicalElement) != null) {
				UtilityPalette.addElementPalette(graphicalElement, paletteGesture, palette);
			}
		}
	}
	
	@Override
	public void createElement(DragEvent event, LayoutScene scene) {
		
		GraphicalElement graphicalElement = ((PaletteElement)event.getGestureSource()).getGraphicalElement();
		//per ora viene assunto che rootContainmentRef esista (diverso da null) e che sia univoca
		EReference rootContainmentRef = getRootContainmentRef(graphicalElement);
		
		LayoutScene layoutSceneInstance = LayoutScene.getInstance();
		EObject root  = layoutSceneInstance.getDomainRoot(); 
		EClass elementEClass = graphicalElement.getElement();
		
		Collection<EObject> coll = EcoreUtil.getObjectsByType(root.eContents(), elementEClass);
		
		if (rootContainmentRef.getUpperBound() != -1 && coll.size() >= rootContainmentRef.getUpperBound()) {
			Popup.dialog("Attenzione", "Non \u00E8 possibile inserire altri elementi di tipo " + elementEClass.getName());
			return;
		}
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();

		EObject element = EcoreUtil.create(elementEClass);		
		ElementPosition elementPosition = MetaEditorPersistenceFactory.eINSTANCE.createElementPosition();
		elementPosition.setElement(element);
		LayoutScene.getAllElementPositions().put(element, elementPosition);
		
		emfCommand.add(layoutSceneInstance.getRootPersistence(), 
						MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(), elementPosition);
		
		emfCommand.insert(root, rootContainmentRef, element);
		
		elementPosition.setX((int) Math.ceil(event.getX()));
		elementPosition.setY((int) Math.ceil(event.getY()));
		elementPosition.setZ(graphicalElement.getZIndexDefault());
		
		Ente enteFX = LayoutScene.getViewModelMap().get(element);
		enteFX.getDraggableNode().snapToGrid(enteFX.pivot);
		
		//create children
		for (EReference localRef : elementEClass.getEAllReferences()) {
			if (localRef.isContainment() && localRef.getLowerBound() > 0) { 
				Method method = null;
				
				try {
					method = enteFX.getClass().getDeclaredMethod("create"+StringUtils.capitalize(localRef.getName()));
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
				for (int i=0; i<localRef.getLowerBound(); i++) {
					try {
						method.invoke(enteFX, (Object[])null);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if (!graphicalElement.isSelectWithParent()) {
			SelectionModel.clearAdd(enteFX.getDraggableNode());
		}
		
		emfCommand.end();
	}
	
	private EReference getRootContainmentRef (GraphicalElement graphicalElement) {
		for (EReference ref : graphicalElement.getContainmentRef()) {
			if (ref.getEContainingClass().getName().equals(LayoutScene.getInstance().confInstanceRoot.getRootElement().getName())) {
				return ref;
			}
		}
		return null;
	}

}
