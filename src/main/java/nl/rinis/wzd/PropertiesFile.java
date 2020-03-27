package nl.rinis.wzd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	private static Properties properties = new Properties();

	static {
		String fileName = "settings.properties";
		InputStream inStr = PropertiesFile.class.getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(inStr);
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static String getStringProperty(String key) {
		return properties.getProperty(key);
	}

	public static int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
}
