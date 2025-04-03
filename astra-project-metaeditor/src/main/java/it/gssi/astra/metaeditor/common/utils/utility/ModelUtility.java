package  it.gssi.astra.metaeditor.common.utils.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;



/**
 * Class QLEcoreUtility.
 */

public class ModelUtility {
	
	final static private ResourceSet resourceSet = new ResourceSetImpl();
	
	
	public ResourceSet getResourceset() {
		return resourceSet;
	}



	public ModelUtility() {

	}
	
	
	
	public ModelUtility(EPackage pack) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(pack.getNsURI(), pack);
	}
	
	public static ModelUtility Build() {
		return new ModelUtility();
	}
	
	/**
	 * Registrazione degli EPackages.
	 *
	 * @param packages la lista degli EPackages
	 */
	public void packageRegistering(List<EPackage> packages) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		for (EPackage pack : packages) {
			resourceSet.getPackageRegistry().put(pack.getNsURI(), pack);
		}
	}
	
		
	
	/**
	 * Crea un'instanza del modello sul percorso dato.
	 *
	 * @param modelPath il percorso del modello
	 * @return la risorsa creata
	 */
	public static Resource createModel(String modelPath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(modelPath);
		Resource resource = resourceSet.createResource(uri);
		EcoreUtil.resolveAll(resourceSet);
		return resource;
	}
	
	/**
	 * Carica un modello esistente dato il suo percorso.
	 *
	 * @param modelPath il percorso del modello
	 * @return la risorsa caricata
	 */
	public Resource loadModel(String modelPath) {		
		ResourceSet resourceSet = new ResourceSetImpl();		
		File e = new File(modelPath);
		if(e.exists()) {
			URI uri = URI.createFileURI(e.getAbsolutePath());
			Resource resource = resourceSet.getResource(uri, true);
			EcoreUtil.resolveAll(resourceSet);
			return resource;
		}
		return null;
	}
	
	/**
	 * Salva un modello.
	 *
	 * @param outputRes resource da salvare
	 */
	public static void saveModel(Resource outputRes) {
		try {
			Map<Object, Object> saveOptions = ((XMLResource)outputRes).getDefaultSaveOptions();
			saveOptions.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
			
			outputRes.save(saveOptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets all the EObjects with their message from an EMF Diagnostic
	 *
	 * @param diagnostic The Diagnostic object
	 * @return A mapping from EObjects to their message
	 */
	public static Map<EObject, String> getDiagResults(Diagnostic diagnostic) {
		
		Map<EObject, String> results = new HashMap<EObject, String>();
		
		if (diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
    
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					EObject eobjectDiagnostic = (EObject) childDiagnostic.getData().get(0);
					
					results.put(eobjectDiagnostic, childDiagnostic.getMessage());
				}
			}
		}
		
		return results;
	}
	
	
	private File getFileFromResource(String fileName) {
//		File resultFile = null;
//		URL url = ModelUtil.class.getClass().getResource(File.separator + fileName);
//		try {
//			 resultFile = new File(url.toURI());
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return resultFile;

		ClassLoader classLoader = this.getClass().getClassLoader();
		File resultFile = new File(fileName);
		return resultFile;
		
	}

	private static java.net.URI getURIFromResource(String fileName) {
		ClassLoader classLoader = new ModelUtility().getClass().getClassLoader();
		File resultFile = new File(classLoader.getResource(fileName).getFile());
		return resultFile.toURI();
	}

	private static void saveStringToFile(String text, String outputFilePath) {
		File fileToSave = createFile(outputFilePath);
		FileWriter fooWriter;
		try {
			fooWriter = new FileWriter(fileToSave, false);
			fooWriter.write(text);
			fooWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // true to append
	}

	/**
	 * Create file, also if it not exist. And create also parent's directory if not exist.
	 * @param model
	 * @return the created file
	 */
	private static File createFile(String model) {
		File file = new File(model);
		FileOutputStream oFile = null;
		try {
			file.getParentFile().mkdirs(); //Create all parent folders
			file.createNewFile();
			oFile = new FileOutputStream(file, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // if file already exists will do nothing 
		return file;
	}
	
	
}
