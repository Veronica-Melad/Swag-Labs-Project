package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigerLoader extends E2E_Logger {

    public static String CONFIG_PATH = "./Resources/";

    public static String getConfigValue(String fileName, String key) {
        
        try {
        	Properties properties = new Properties();
            properties.load(new FileInputStream(CONFIG_PATH + fileName + ".properties"));
            return properties.getProperty(key);
        } catch (Exception e) {
            return"";
        }
        
    }
}