package it.gssi.astra.metaeditor.common.utility;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.HighlightModel;
import it.gssi.astra.metaeditor.common.dataManager.fileManager.FileManagerImpl;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.interfaces.IValidate;
import it.gssi.astra.metaeditor.common.menu.CustomMenu;
import it.gssi.astra.metaeditor.common.popup.Popup;
import it.gssi.astra.metaeditor.common.utils.epsilon.EVLStandalone;
import it.gssi.astra.metaeditor.common.utils.utility.ModelUtility;

public class Validate implements IValidate{
	
	static Validate instance;
	
	public static void setInstance(Validate instance) {
		Validate.instance = instance;
	}

	public static Validate getInstance() {

		if (instance == null) {
			instance = new Validate();
		}

		return instance;
	}

	@Override
	public boolean validate() {
		HighlightModel.clear();
		Diagnostic diagnostic = null;
		
		if ( LayoutScene.getInstance().getResourcePersistance() != null) {
			
			EObject eo =  LayoutScene.getInstance().getResource().getContents().get(0);
		    
			Diagnostician diagnostician = new Diagnostician()
		      {
		        @Override
		        public String getObjectLabel(EObject eObject)
		        {
		          Ente e = LayoutScene.getViewModelMap().get(eObject);
		          
		          if (e != null) {
		        	  return e.getMetaClassName() + " " + e.getIdentifier();
		          }

		          return eObject.eClass().getName().toString();
		        }
		      };
		      
		    diagnostic = diagnostician.validate(eo);
		    
		    Map<EObject, String> results = ModelUtility.getDiagResults(diagnostic);
			
			HighlightModel.addMultiple(results.keySet());
			
			StringBuilder error = manageResultValidate(results);
			
			String evlOutput = evlValidate();
			error.append(evlOutput);
			
			if(!error.toString().isBlank()) {
				Popup.showErrorNotModal("Error Validate:",error);
				return false;
			} else {
				Popup.showError("Modello Valido.", "Validazione eseguita con successo.");
			}
			
		} else {
			Popup.dialog("Errore di Validazione", "Non è stato caricato nessun xmi ...");
			return false;
		}
		
		return diagnostic.getSeverity() != Diagnostic.ERROR;
	}
	
	
	/**
	 * This function format the validate string 
	 * @param map
	 * @return StringBuilder
	 */
	public StringBuilder manageResultValidate(Map<EObject, String> map) {
		
		StringBuilder stringResult = new StringBuilder();
		for (var entry : map.entrySet()) {
			stringResult.append(entry.getValue()).append("\n");
		}		
		return stringResult;

	}
	
	
	/**
	 *  Run evl validation code 
	 * @return the output of evlModule and highlights the element not valid 
	 */
	public String evlValidate() {
		
		String output = " ";
		EVLStandalone module = new EVLStandalone();

		try {
			// Add Resource Model and metamodel to evl module
			module.addModel( FileManagerImpl.getInstance().getFileExtention(),  LayoutScene.getInstance().getResource(),  LayoutScene.getInstance().domainEPackage.getNsURI(), true, false);
			//load evl file 
			module.setSource("/epsilon/evl/_"+ FileManagerImpl.getInstance().getFileExtention() + "Main.evl");
			// run evl module
			module.run();

			EvlModule moduleEvl = (EvlModule) module.module;
			Collection<UnsatisfiedConstraint> unsatisfied = moduleEvl.getContext().getUnsatisfiedConstraints();
			
			if (unsatisfied.size() > 0) {
				output += unsatisfied.size() + " constraint(s) non sono stati soddisfatti: \n";
				for (UnsatisfiedConstraint uc : unsatisfied) {
					output += "\n "+ uc.getMessage();
					if( LayoutScene.getInstance().getViewModelMap().get(uc.getInstance()) != null ) {
						HighlightModel.add( LayoutScene.getInstance().getViewModelMap().get(uc.getInstance()).getDraggableNode(), uc.getConstraint().isCritique());
					}
				}
			}
			/*else {
				output =  "Tutti i constraints sono stati soddisfatti.";
			}*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}

}
