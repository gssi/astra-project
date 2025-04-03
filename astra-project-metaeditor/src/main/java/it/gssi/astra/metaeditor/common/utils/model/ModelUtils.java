package  it.gssi.astra.metaeditor.common.utils.model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class ModelUtils {

	final static private ResourceSet resourceSet = new ResourceSetImpl();

	public static Resource createResource(String modelPath) {
		File f = new File(modelPath);
		return resourceSet.createResource(URI.createURI(f.toURI().toString()));
	}

	/**
	 * Carica un modello esiste dato il suo percorso.
	 *
	 * @param modelPath il percorso del modello
	 * @return la risorsa caricata
	 */
	public static Resource loadModel(String modelPath) {
		URI uri = URI.createFileURI(modelPath);
		Resource resource = resourceSet.getResource(uri, true);
		
		return resource;
	}
	
	/**
	 * Carica un modello esiste dato il suo percorso. (Versione 2)
	 *
	 * @param modelPath il percorso del modello
	 * @return la risorsa caricata
	 */
	public static Resource loadModel2(String modelPath) {
		URI modelUri = URI.createFileURI(new File(modelPath).getAbsolutePath());
		Resource resource = resourceSet.getResource(modelUri, true);		
		
		return resource;
	}
	
	public static void registerPack(EPackage pack) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(pack.getNsURI(), pack);
	}

	public static void saveModelOnNewResource(Resource resource, String modelPath) {
		URI oldUriResource = resource.getURI();
		URI newUriResource = URI.createFileURI(modelPath);

		resource.setURI(newUriResource);
		//Resource out = ModelUtils.createResource(modelPath);
		//out.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
		
		ModelUtils.save(resource);
		//ModelUtils.save(out);
		//ModelUtils.unload(out);
		

		resource.setURI(oldUriResource);
			
	}
	
	public static void packageRegistering(List<EPackage> packages) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		for (EPackage pack : packages) {
			resourceSet.getPackageRegistry().put(pack.getNsURI(), pack);
		}

	}

	public static void save(Resource resourceOut) {
		Map<Object, Object> saveOptions = ((XMIResource)resourceOut).getDefaultSaveOptions();
		saveOptions.put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.FALSE);
		// now save the content.
		try {
			resourceOut.save(saveOptions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void unload(Resource resourceOut) {
		resourceOut.unload();
		//resourceSet.getResources().remove(resourceOut);
	}
	
	public static void unloadAll() {
		while(!resourceSet.getResources().isEmpty()) {
			resourceSet.getResources().clear();
		}
	}
	
	public static boolean validate(Resource resource) {
		EObject eo = resource.getContents().get(0);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eo);
		if (diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
			System.err.println(diagnostic.getMessage());
			for (Iterator<Diagnostic> i = diagnostic.getChildren().iterator(); i.hasNext();) {
				Diagnostic childDiagnostic = i.next();
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					System.err.println("\t" + childDiagnostic.getMessage());
				}
			}
		}
		return diagnostic.getSeverity() != Diagnostic.ERROR;
	}
	

}
