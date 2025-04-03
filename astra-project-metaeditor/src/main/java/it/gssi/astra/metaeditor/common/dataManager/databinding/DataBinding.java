package it.gssi.astra.metaeditor.common.dataManager.databinding;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.fx.core.databinding.JFXRealm;

public class DataBinding {
	
	private static DataBinding instance;
	
	public static DataBinding getInstance() {

		if (instance == null) {
			instance = new DataBinding();
		}

		return instance;
	}
	

	/**
	 * Required by eclipse data-binding. It corresponds to JavaFX application thread.
	 * 
	 */
	private JFXRealm realm;
	
	public JFXRealm getRealm() {
		if (realm == null) {
			realm = new JFXRealm();
		}
		
		return this.realm;
	}

	private EMFDataBindingContext propertyViewDatabindingContext;
	
	public EMFDataBindingContext getPropertyViewContext() {
		if (propertyViewDatabindingContext == null) {
			propertyViewDatabindingContext = new EMFDataBindingContext(getRealm());
		}
		
		return this.propertyViewDatabindingContext;
	}

	private EMFDataBindingContext persistenceDatabindingContext;
	
	public EMFDataBindingContext getPersistenceContext() {
		if (persistenceDatabindingContext == null) {
			persistenceDatabindingContext = new EMFDataBindingContext(getRealm());
		}
		
		return this.persistenceDatabindingContext;
	}

	private EMFDataBindingContext anchorPointsDatabindingContext;
	
	public EMFDataBindingContext getAnchorPointsContext() {
		if (anchorPointsDatabindingContext == null) {
			anchorPointsDatabindingContext = new EMFDataBindingContext(getRealm());
		}
		
		return this.anchorPointsDatabindingContext;
	}

	private EMFDataBindingContext bendpointsPositionDatabindingContext;
	
	public EMFDataBindingContext getBendpointPositionsContext() {
		if (bendpointsPositionDatabindingContext == null) {
			bendpointsPositionDatabindingContext = new EMFDataBindingContext(getRealm());
		}
		
		return this.bendpointsPositionDatabindingContext;
	}

	private EMFDataBindingContext canvasDatabindingContext;
	
	public EMFDataBindingContext getCanvasContext() {
		if (canvasDatabindingContext == null) {
			canvasDatabindingContext = new EMFDataBindingContext(getRealm());
		}
		
		return this.canvasDatabindingContext;
	}
}
