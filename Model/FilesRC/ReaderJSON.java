package Model.FilesRC;

import java.io.*;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReaderJSON {


    public static ArrayList<ArrayList<String>> readFilesJSON(String path){ //This class will read Json Files
        ArrayList<ArrayList<String>> newT = new ArrayList<ArrayList<String>>();

        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonuser = (JSONArray) jsonObject.get("usuario");
            JSONArray jsonid = (JSONArray) jsonObject.get("id");
            JSONArray jsonpk = (JSONArray) jsonObject.get("public_key");
            JSONArray jsonmonto = (JSONArray) jsonObject.get("monto");
            JSONArray jsoncuotas = (JSONArray) jsonObject.get("cuotas");
            JSONArray jsonnt = (JSONArray) jsonObject.get("numero_tarjeta");
            JSONArray jsonfv = (JSONArray) jsonObject.get("fecha_vencimiento");
            JSONArray jsoncvv = (JSONArray) jsonObject.get("cvv");


            for (int i = 0; i < jsonuser.size(); i++) {
                arrayList.add(jsonuser.get(i).toString());
                arrayList.add(jsonid.get(i).toString());
                arrayList.add(jsonpk.get(i).toString());
                arrayList.add(jsonmonto.get(i).toString());
                arrayList.add(jsoncuotas.get(i).toString());
                arrayList.add(jsonnt.get(i).toString());
                arrayList.add(jsonfv.get(i).toString());
                arrayList.add(jsoncvv.get(i).toString());
                newT.add(arrayList);
                arrayList = new ArrayList<>();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return newT;


    }

    

    

    
    





}
