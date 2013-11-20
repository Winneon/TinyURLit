package net.winneonsword.TinyURLit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkShortener {
	
	public static String shorten(String URL){
		
		String link = "";
		
		if (!(URL.startsWith("http"))){
			
			URL = "http://" + URL;
			
		}
		
		try {
			
			URL url = new URL("http://www.tinyurl.com/api-create.php?url=" + URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			if (connection.getResponseCode() != 200){
				
				throw new RuntimeException("Failed to shorten link. HTTP error code: " + connection.getResponseCode());
				
			} else {
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				link = reader.readLine();
				
			}
			
			connection.disconnect();
			
		} catch (Exception e){
			
			link = "Failed to shorten link. Check tinyurl.com for errors or contact the developer.";
			
		}
		
		return link;
		
	}
	
	public static boolean checkLink(String URL){
		
		boolean validate = false;
		
		try {
			
			URL url = new URL("http://" + URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			if (connection.getResponseCode() == 404){
				
				validate = false;
				
			} else {
				
				validate = true;
				
			}
			
			connection.disconnect();
			
		} catch (Exception e){
			
			validate = false;
			
		}
		
		return validate;
		
	}
	
}
