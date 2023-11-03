package Model;

import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FilesManager {


    public static void writeFilesCSV(String path, ArrayList<String> newT) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String word : newT) {
                writer.write(word);
                writer.write(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<ArrayList<String>> readFilesJSON(String path){ //This class will read Json Files
        ArrayList<ArrayList<String>> newT = new ArrayList<ArrayList<String>>();

        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonHoras = (JSONArray) jsonObject.get("Horas");
            JSONArray jsonDia = (JSONArray) jsonObject.get("Dia");
            JSONArray jsonPriori = (JSONArray) jsonObject.get("Prioridad");
            for (int i = 0; i < jsonHoras.size(); i++) {
                arrayList.add(jsonHoras.get(i).toString());
                arrayList.add(jsonDia.get(i).toString());
                arrayList.add(jsonPriori.get(i).toString());
                newT.add(arrayList);
                arrayList = new ArrayList<>();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return newT;


    }

    public static void createCSVfile(){

    }

    public static void createJSONfile(){

    }

    public static void createXMLfile(){

    }
    





}
