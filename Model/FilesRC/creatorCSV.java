package Model.FilesRC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class creatorCSV {
    public static void CreateFilesCSV(int N, ArrayList<String> newT) {
        String path = "AmericanExpress"+N+".csv";    
        try (FileWriter writer = new FileWriter(path)){
            for (String word : newT) {
                writer.write(word);
                writer.write(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
