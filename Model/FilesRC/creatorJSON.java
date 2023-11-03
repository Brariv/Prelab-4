package Model.FilesRC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class creatorJSON {
    public static void CreateFilesJSON(int N,ArrayList<String> newT){
        Gson gson = new Gson();
        String json = gson.toJson(newT);
        String path = "MasterCard"+N+".json";

        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
