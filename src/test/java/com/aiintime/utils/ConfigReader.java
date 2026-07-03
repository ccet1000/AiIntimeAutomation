package com.aiintime.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = new Properties();
	static {
		loadConfig();
	}
	private static void loadConfig() {
		try {
			FileInputStream fis = new FileInputStream(
	                "src/test/resources/config.properties"
					);
			prop.load(fis);
		} catch(IOException e) {
			throw new RuntimeException("Failed to load config.properties file",e);
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
