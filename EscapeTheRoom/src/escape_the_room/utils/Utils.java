package escape_the_room.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		// Loads file as string
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	// Changes string variable into integer
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}