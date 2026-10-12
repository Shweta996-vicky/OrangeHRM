package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class LocatorLoader {
	
	private static Properties props = new Properties();
	
	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/locators.properties");
			props.load(fis);
		} catch(Exception e) {
			throw new RuntimeException("Could not load locator.propertirsfile!, e");
		}
	}
	//this method now simply reads the raw texts from the file
	
	public static String getValue(String key) {
		return props.getProperty(key);
	}

}
