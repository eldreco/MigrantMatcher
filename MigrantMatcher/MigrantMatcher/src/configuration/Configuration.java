package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Configuration {
	
	// Passo 1 - instancia estática
	private static Configuration INSTANCE = new Configuration();
	
	// Passo 3: 
	public static Configuration getInstance() {
		return INSTANCE;
	}
	
	private Properties props = new Properties();
	
	// Passo 2 - Constructor private
	private Configuration() {
		try {
			props.load(new FileInputStream("configuration.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getInt(String key, int defaultValue) {
		try {
			return Integer.parseInt(props.getProperty(key));
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public String getString(String key, String defaultValue) {

		return props.getProperty(key, defaultValue);
	}
	public <T> T getInstanceOfClass(String key, T defaultValue) {
		String klassName = (String) props.get(key);
		if (klassName == null) {
			return defaultValue;
		}
		
		try {
			@SuppressWarnings("unchecked")
			Class<T> klass = (Class<T>) Class.forName(klassName);
			Constructor<T> c = klass.getConstructor();
			return c.newInstance();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return defaultValue;
	}
	
}