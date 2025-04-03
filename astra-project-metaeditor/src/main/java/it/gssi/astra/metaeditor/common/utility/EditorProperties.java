package it.gssi.astra.metaeditor.common.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditorProperties {

	private static Logger log = LoggerFactory.getLogger(EditorProperties.class.getSimpleName());

	private static Properties properties;

	private static final String PATH = "common/editor.properties";

	public static void init() {
		if (properties == null) {
			try {
				properties = new Properties();
				properties.load(LoadProperties.class.getClassLoader().getResourceAsStream(PATH));
				//properties.load(EntiProperties.class.getClassLoader().getResourceAsStream(specificPath));
			} catch (Exception ioe) {
				log.error("CONFIGURATION FILE NOT FOUND");
			}
		}
	}

	public static List<String> getPropertyList(String key) {

		List<String> result = Arrays.asList(properties.getProperty(key).split(", "));

		if (result == null) {
			log.error("CONFIGURATION ERROR - KEY: '" + key + "' NOT FOUND IN FILE: '" + PATH + "'");
		}

		return result;
	}
	
	public static String get(String key) {

		String result = properties.getProperty(key);

		if (result == null) {
			log.error("CONFIGURATION ERROR - KEY: '" + key + "' NOT FOUND IN FILE: '" + PATH + "'");
		}

		return result;
	}

	public static void set(String key, String value) {
		properties.setProperty(key, value);
	}
}
