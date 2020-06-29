import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.*;
import com.google.gson.reflect.*;


public class APIRequest {
	
	Object curr_temp;
	Object curr_temp_feel;
	Object temp_min;
	Object temp_max;
	Object humidity;
	Object wind_speed;
	Object cloud_coverage;
	
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(
				str, new TypeToken<HashMap<String, Object>>() {}.getType()
		);
		return map;
	}
	
	public void getWeatherCurr(String zipCode, String countryCode){
		
		String urlToRequest = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "," + countryCode + "&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial";
		StringBuilder weatherInfoJson = new StringBuilder();
		
		try {
			URL url = new URL(urlToRequest);													// format desired url
			URLConnection url_conn = url.openConnection();										// open connection
			InputStreamReader is = new InputStreamReader(url_conn.getInputStream());			// create input stream from connection
			BufferedReader br = new BufferedReader(is);											// create buffer to read in entire input stream
			String line;
			while ((line = br.readLine()) != null) {											// While there are still lines of info to read, read them in
				weatherInfoJson.append(line);														// and add them all to a string called 'weather_info' (weather_info
			}																					// is a string builder to allow creation of one big string).
			br.close();																			// Once info is all taken, close the stream reader.	
			
			Map<String, Object> weatherInfoMap = jsonToMap(weatherInfoJson.toString());					// map info from json file
			Map<String, Object> mainMap = jsonToMap(weatherInfoMap.get("main").toString());				// sub map for 'main'
			Map<String, Object> windMap = jsonToMap(weatherInfoMap.get("wind").toString()); 			// sub map for 'wind'
			Map<String, Object> cloudsMap = jsonToMap(weatherInfoMap.get("clouds").toString());          // sub map for 'clouds'
			
			
			curr_temp = mainMap.get("temp");
			curr_temp_feel = mainMap.get("feels_like");
			temp_min = mainMap.get("temp_min");
			temp_max = mainMap.get("temp_max");
			humidity = mainMap.get("humidity");
			wind_speed = windMap.get("speed");
			cloud_coverage = cloudsMap.get("all");
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}




