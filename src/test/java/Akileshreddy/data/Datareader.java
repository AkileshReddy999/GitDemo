package Akileshreddy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		
		//READ JSON TO STRING
		//for below fileutils we have to get dependencies from commons from MVN
		
	String jsonContent = 	FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "\\SeleniumFrameworkDesign\\src\\test\\java\\Akileshreddy\\data\\AkileshOrder.json")
			);
	
	
	
	//READT STRING TO HASHMAP
	//for below step we have to get dependencies from Jackson Databind (Hahmap) from MVN repository
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference
			<List<HashMap<String,String>>>(){});
	return data;
	
	
	}
	
	
	
}
