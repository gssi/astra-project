package  it.gssi.astra.metaeditor.common.utils.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUtils {
	
	/**
	 * Questa funzione legge un file testuale dalle risorse e ne ritorna il contenuto come stringa 
	 *  Di default utilizza una codifica UTF-8
	 * @param fileName
	 * @return
	 */
	public static String getTextFileAsStringFromResources(String fileName) {
		InputStream res = new FileUtils().getClass().getResourceAsStream(fileName);
		return readFileFromInputStream(res);
	}

	public static String getTextFileAsStringFromOrdinaryFile(String filename) {
		try {
			InputStream res = new FileInputStream(new File(filename));
			return readFileFromInputStream(res);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String readFileFromInputStream(InputStream res) {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		 byte[] buffer = new byte[1024];
		 try {
			for (int length; (length = res.read(buffer)) != -1; ) {
			     result.write(buffer, 0, length);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // StandardCharsets.UTF_8.name() > JDK 7
		 try {
			return result.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	
	
	/**
	 * Questa funzione dovrebbe ritornare un file dalle risorse 
	 * ALTAMENTE SCONSIGLIATO: infatti se il modulo viene a far parte di un jar-with-dependencies 
	 * non è possibile accedere al file utilizzando la classe FILE
	 * UNTESTED 
	 * @param fileName
	 * @return
	 */
	@Deprecated
	public static File getFileFromResources(String fileName) {
		ClassLoader classLoader = new FileUtils().getClass().getClassLoader();
		System.out.println(fileName);
		URL res = classLoader.getResource(fileName);
		if(res == null) {
			System.out.println("il loader ha fallito miseramente Ritento con un altro approccio 1");
			classLoader = FileUtils.class.getClass().getClassLoader();
			if(classLoader != null)
			res = classLoader.getResource(fileName);
					
		}
		if(res == null) {
			System.out.println("il loader ha fallito miseramente Ritento con un altro approccio 2");
			res = FileUtils.class.getClass().getResource(fileName);
		}
		if(res == null) {
			System.out.println("il loader ha fallito miseramente Ritento con un altro approccio 3");
			res = new FileUtils().getClass().getResource(fileName);
		}
		System.out.println(res.getPath());
		System.out.println(res.getQuery());
		System.out.println(res.getFile());
		
		try {
			System.out.println(res.toURI().getPath());
			System.out.println(res.toURI().getQuery());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File resultFile = null;
		try {
			resultFile = new File(res.toURI());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultFile == null) {
			resultFile = new File(res.toExternalForm());
		}
		
		return resultFile;
	}
	
	/**
	 * Semplice funzione che ritorna un oggetto File a partire da un Path da directory ordinaria 
	 * (NON Resources vedi getFileFromResources)
	 * @param fileName
	 * @return
	 */
	public static File getFileFromOrdinaryDirectories(String fileName) {
		return new File(fileName);
	}
	
	/**
	 * Funzione che ritorna una URI di un file contenuto in directory ordinaria 
	 * (NON Resources vedi getURIFromResources)
	 * @param fileName 
	 * @return URI associata al file
	 */
	public static URI getURIFromOrdinaryDirectories(String fileName) {
		File file = new File(fileName);
		if(file.exists()) {
			return file.toURI();
		}
		return null;
	}
	
	/**
	 * Funzione che ritorna una URI di un file contenuto nelle Resources
	 * @param fileName
	 * @return URI associata al file
	 */
	public static URI getURIFromResources(String fileName) {
		try {
			return new FileUtils().getClass().getResource(fileName).toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Salva stringa su file
	 * @param text
	 * @param outputFilePath
	 */
	public static void saveStringToFile(String text, String outputFilePath) {
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
	 * Create file, also if it not exist. And create also parents directories if non exist.
	 * @param model
	 * @return
	 */
	public static File createFile(String model) {
		File file = new File(model);
		FileOutputStream oFile = null;
		try {
			file.getParentFile().mkdirs(); //Create all parent folders
			file.createNewFile();
			oFile = new FileOutputStream(file, false);
			oFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // if file already exists will do nothing 
		return file;
	}
	
}
