package Zen.Test.Utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlConfig {
	
	public static Map<String,String> Yamlconfig=new HashMap<String,String>();
	public static Yaml yamlfile=new Yaml();
	public static InputStream qa_input;

	
	public static Map<String,String> Readyaml(){
		try {
			InputStream test_data=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Zen/Test/Resources/TestData.yaml");
			Yamlconfig=yamlfile.load(test_data);
			
		}catch(Exception e) {

		}
		
		return Yamlconfig;

	}
	public static Map<String,String> getConfig(){
			Yamlconfig=Readyaml();
		return Yamlconfig;
	}

	public static String getbrowser(){
		return getConfig().get("browser");
	}
	public static String geturl(){
		return getConfig().get("url");
	}
	public static String getEmail(){
		return getConfig().get("username");
	}

	public static String getPassword(){
		return getConfig().get("password");
	}
	public static String ticketurl(){
		return getConfig().get("ticketurl");
	}
	public static  String getLevelGroupUrl(){
		return getConfig().get("levelgroupurl");
	}
	public static String getAnytimeFitnessUrl(){
		return getConfig().get("anytimefitnessurl");
	}
	public static  String getMODUrl(){
		return getConfig().get("modurl");
	}

		
}

