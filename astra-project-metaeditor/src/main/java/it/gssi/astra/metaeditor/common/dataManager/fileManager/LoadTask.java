package it.gssi.astra.metaeditor.common.dataManager.fileManager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.CanvasManagementImpl;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.popup.LoadingDialog;
import it.gssi.astra.metaeditor.common.popup.Popup;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;

public class LoadTask {

	public Task<Void> loadObjects(EObject root) {
		
		Task<Void> task = new LoadRunnable(root);
		LoadingDialog loadingDialog = new LoadingDialog();

		task.addEventHandler(WorkerStateEvent.WORKER_STATE_FAILED, e->{
			Popup.dialog("Attenzione", "Errore caricamento: " + e);
			LayoutScene.getInstance().getContainerCanvas().getRootCanvas().setVisible(false);
			loadingDialog.hide();
		});
		
		
		task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, e->{
			LayoutScene.getInstance().getContainerCanvas().getRootCanvas().setVisible(true);
			loadingDialog.hide();
			
			Platform.runLater( ()->{
				double changeX = LayoutScene.getInstance().getMinCoordinate()[0] / LayoutScene.getInstance().getContainerCanvas().getContent().getBoundsInLocal().getWidth();
				double changeY = LayoutScene.getInstance().getMinCoordinate()[1] / LayoutScene.getInstance().getContainerCanvas().getContent().getBoundsInLocal().getHeight();

				// Scroll to min coordinate
				LayoutScene.getInstance().getContainerCanvas().setHvalue(LayoutScene.getInstance().getContainerCanvas().getHvalue() + changeX);
				LayoutScene.getInstance().getContainerCanvas().setVvalue(LayoutScene.getInstance().getContainerCanvas().getVvalue() + changeY);
				
				// This will restore the target of all anchor points getting the value from
				// model. If it fails the value in the model is reset to null.
				for (Ente ente : LayoutScene.getViewModelMap().values()) {
					ente.synchronizeAnchorPoints();
					
					Map<String, Boolean> OK = new HashMap<String, Boolean>();
					
					for (AnchorPoint ap : ente.getAnchorPoints()) {
						if (ap.targetValid()) {
							OK.put(ap.featureName, true);
						} else {
							OK.putIfAbsent(ap.featureName, false);
						}
					}
					
					for (String featureName : OK.keySet()) {
						
						if (OK.get(featureName)) {
							continue;
						} else {
							EObject model = (EObject) ente.getModel();
							EStructuralFeature feature = model.eClass().getEStructuralFeature(featureName);
							model.eSet(feature, null);
						}
					}
					
				}
				
			});
		});


		loadingDialog.show();
		new Thread(task).start();
		
		return task;
		
	}

}

class LoadRunnable extends Task<Void> {
	
	EObject root;

	public LoadRunnable(EObject root) {
		this.root = root;
	}
	
	@Override
	protected Void call() throws Exception {
		
		for (EObject child : root.eContents()) {
			loadEObject(child);
		}
		
		return null;
	}
	
	public void loadEObject(EObject eobject) {

		Platform.runLater(() -> {
			CanvasManagementImpl.getInstance().addElement(eobject, eobject.eContainer(),
					eobject.eContainmentFeature());
		});

		for (EObject child : eobject.eContents()) {
			loadEObject(child);
		}

	}
	
}