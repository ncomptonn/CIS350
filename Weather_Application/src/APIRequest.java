//import org.json.JSONArray;
//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class APIRequest {
	
	static int getZipCode() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Zip Code: ");
		
		int zip_code = scan.nextInt();
		return zip_code;
	}
	
	static String getCountryCode() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Country Code (us or uk): ");
		
		String countryCode = scan.nextLine();
		return countryCode;
	}

	public static void main(String[] args) {
		
		int zipCode = getZipCode();
		String countryCode = getCountryCode();
		String urlToRequest = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "," + countryCode + "&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial";

		try {
			StringBuilder weather_info = new StringBuilder();
			URL url = new URL(urlToRequest);													// format desired url
			URLConnection url_conn = url.openConnection();										// open connection
			InputStreamReader is = new InputStreamReader(url_conn.getInputStream());			// create input stream from connection
			BufferedReader br = new BufferedReader(is);											// create buffer to read in entire input stream
			String line;
			while ((line = br.readLine()) != null) {											// While there are still lines of info to read, read them in
				weather_info.append(line);														// and add them all to a string called 'weather_info' (weather_info
			}																					// is a string builder to allow creation of one big string).
			br.close();																			// Once info is all taken, close the stream reader.	
			System.out.println(weather_info);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}






//JSONObject obj = new JSONObject(weather_info);
//System.out.println(obj);

//JSONArray weather = obj.getJSONArray("main");
//System.out.println(weather);

//http://api.openweathermap.org/data/2.5/weather?zip=48334,us&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial
//System.out.println(huc.getResponseCode());