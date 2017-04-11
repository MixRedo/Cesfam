/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Daniel
 */
public final class PropertyReader {
	public String getPropValuesByName(String valueName) throws IOException {
            String result = "";
            InputStream inputStream = null;
            
		try {
			Properties prop = new Properties();
			String propFileName = "resources/Config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Archivo de propiedades '" + propFileName + "' No encontrado");
			}

			result = prop.getProperty(valueName);
 
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}
