package  it.gssi.astra.metaeditor.common.utils.epsilon;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;

public class EGXStandalone extends EpsilonStandalone{
	private String source;
	private List<IModel> models;
	private String outputPath = null;
	
	public void setOutputPath(String p) {outputPath = p;}
	
	public void run() throws Exception {
		this.execute();
	}
	
	public void addVariable(Variable e) {
		this.parameters.add(e);
	}

	@Override
	public IEolModule createModule() {
		if(outputPath == null)
		return new EgxModule(new EglFileGeneratingTemplateFactory());
		else
			return createModule(outputPath);
	}
	
	public IEolModule createModule(String path) {
		EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
		try {
			factory.setOutputRoot(path);
		} catch (EglRuntimeException e) {
			e.printStackTrace();
			return null;
		}
		return new EgxModule(factory);
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
