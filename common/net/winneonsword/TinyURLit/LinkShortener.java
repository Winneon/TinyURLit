package net.winneonsword.TinyURLit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkShortener {
	
	public static String shorten(String URL){
		
		String link = "";
		
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
			
			throw new RuntimeException("Failed to shorten link. Check tinyurl.com for errors or contact the developer.");
			
		}
		
		return link;
		
	}
	
}
