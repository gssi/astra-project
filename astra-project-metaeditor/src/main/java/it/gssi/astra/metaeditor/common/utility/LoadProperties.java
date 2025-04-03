package it.gssi.astra.metaeditor.common.utility;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadProperties {

	private static Logger log = LoggerFactory.getLogger(LoadProperties.class.getSimpleName());
	
	private static Properties properties;

	private static final String PATH = "cad/ql/enti/enti.properties"; 
    
    public static void init() {
        if(properties == null) {
            try {
                properties = new Properties();
                properties.load(LoadProperties.class.getClassLoader().getResourceAsStream(PATH));
            } catch (Exception ioe) {
            	log.error("CONFIGURATION FILE NOT FOUND");
            }
        }
    }
    
    public static String get(String key){
    	
    	String result = properties.getProperty(key);
    	
    	if(result == null) {
    		log.error("CONFIGURATION ERROR - KEY: '"+ key +"' NOT FOUND IN FILE: '"+ PATH+"'");
    	}
    		
        return result;
    }
}
