package it.gssi.astra.metaeditor.common.utils.epsilon;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;



public class EVLStandalone extends EpsilonStandalone{
	private String source;
	private List<IModel> models;
	
	public void run() throws Exception {
		this.execute();
	}
	
	
	@Override
	public IEolModule createModule() {
		return new EvlModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {	return models; }
	
	public List<IModel> addModel(String name, String modelPath, String metaModelURI, boolean readOnLoad, boolean storeOnDisposal) throws Exception {
		if(models == null) models = new ArrayList<IModel>();
 		models.add(createEmfModelByURI(name, modelPath, metaModelURI, readOnLoad, storeOnDisposal));
		return models;
	}
	
	public List<IModel> addModel(String name, Resource model, String metaModelURI, boolean readOnLoad, boolean storeOnDisposal) throws Exception {
		if(models == null) models = new ArrayList<IModel>();
		IModel iModel = new InMemoryEmfModel(name, model);
 		models.add(iModel);
		return models;
	}
	

	@Override
	public String getSource() throws Exception { return source; }
	public void setSource(String sourcePath) { source = sourcePath; }

	@Override
	public void postProcess() {

	}

}
