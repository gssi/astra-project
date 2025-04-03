package it.gssi.astra.metaeditor.common.utility;

import java.io.File;
import java.nio.file.Path;

public class UtilityEgl {
	
	public UtilityEgl() {
	}
	
	
	public void existFile() {
		System.out.println("Eccoloooo");
		File file = new File("src/main/java/it/univaq/disim/ermes/editor_piazzale/cad/ps/exstension/SquareFX_Extend.java");
	
		System.out.println(file.exists());
	}
}
