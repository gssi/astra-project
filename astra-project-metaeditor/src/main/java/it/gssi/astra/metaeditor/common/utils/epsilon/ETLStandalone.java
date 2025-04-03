package  it.gssi.astra.metaeditor.common.utils.epsilon;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;



public class ETLStandalone extends EpsilonStandalone{
	private String source;
	private List<IModel> models;
	
	public void run() throws Exception {
		this.execute();
	}
	
	
	@Override
	public IEolModule createModule() {
		return new EtlModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {	return models; }
	
	public List<IModel> addModel(String name, String modelPath, String metaModelURI, boolean readOnLoad, boolean storeOnDisposal) throws Exception {
		if(models == null) models = new ArrayList<IModel>();
 		models.add(createEmfModelByURI(name, modelPath, metaModelURI, readOnLoad, storeOnDisposal));
		return models;
	}
	

	@Override
	public String getSource() throws Exception { return source; }
	public void setSource(String sourcePath) { source = sourcePath; }

	@Override
	public void postProcess() {
		
	}
	
	
}
