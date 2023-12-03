	package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public String getTestData(String key) {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resource/org/config/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
// prop is used for get data from properties file
		
			return prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
