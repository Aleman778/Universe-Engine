package universe.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class FileUtils {
    
    private FileUtils() {}
    
    public static String loadAsString(String filepath) {
        StringBuilder result = new StringBuilder();
        try {
            InputStreamReader reader = new InputStreamReader(
                    FileUtils.class.getResourceAsStream("/" + filepath));
            
            BufferedReader br = new BufferedReader(reader);
            String line; 
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n\r");
            }
            
            reader.close();
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return result.toString();
    }
    
}
