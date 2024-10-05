package utility;

import java.io.FileReader;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

public class DataUtils {
	
	
	 public static final String CONFIG_PATH = "./Resources/";
	public static final String LOGIN_DATA_JSON_PATH = "./Resources/";

    public String userName;
    public String password;
    
    public static String getJsonValue(String jsonfilename , String field) {
		try {
			FileReader reader = new FileReader(LOGIN_DATA_JSON_PATH+jsonfilename+".json");
			
			Object jsonData = new Gson().fromJson(reader, Object.class);
			
			return JsonPath.read(jsonData, "$."+ field);
			
		}catch(Exception e) {
		return"	";
		}
		
	}
    
}
