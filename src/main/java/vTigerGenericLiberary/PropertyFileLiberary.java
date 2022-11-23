package vTigerGenericLiberary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains generic methods related to properties file 
 * @author Rahim
 *
 */
public class PropertyFileLiberary {
	/**
	 * this method will read the value from property file for the key given by the user
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertiesFile(String Key) throws IOException {
		
		FileInputStream fis =new FileInputStream(IconstantsLiberary.propertyFilePath);
		Properties pobj =new Properties();
		pobj.load(fis);
	   String value =  pobj.getProperty(Key);	
	   return value;
	}
	
}

