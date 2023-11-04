package Model.FilesRC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class creatorJSON {
    public static void CreateFilesJSON(int N,ArrayList<String> newT){
        String path = "MasterCard"+N+".json";
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(formatMastercardPayment(newT));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatMastercardPayment(ArrayList<String> newT) {
        // Formatear la información en JSON
        String jsonData = "{\n";
        jsonData += "  \"user\":\"" + newT.get(0) + "\",\n";
        jsonData += "  \"id\":" + newT.get(1) + ",\n";
        jsonData += "  \"public_key\":\"" + newT.get(2) + "\",\n";
        jsonData += "  \"amount\":" + newT.get(3) + ",\n";
        jsonData += "  \"payments\":" + newT.get(4) + ",\n";
        jsonData += "  \"card_number\":\"" + newT.get(5) + "\",\n";
        jsonData += "  \"expiration_date\":\"" + newT.get(6) + "\",\n";
        jsonData += "  \"cvv\":\"" + newT.get(7) + "\"\n";
        jsonData += "}\n";
        return jsonData;
    }

    
}
