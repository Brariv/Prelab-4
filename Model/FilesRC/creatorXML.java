package Model.FilesRC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class creatorXML {
    public static void CreateFilesXML(int N,ArrayList<String> newT){

        String path = "Visa"+N+".xml";
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(formatVisaPayment(newT));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String formatVisaPayment(ArrayList<String> newT) {
        // Formatear la informacion en XML
        String xmlData = "<visa_payment>\n";
        xmlData += "  <user>" + newT.get(0) + "</user>\n";
        xmlData += "  <id>" + newT.get(1) + "</id>\n";
        xmlData += "  <public_key>" + newT.get(2) + "</public_key>\n";
        xmlData += "  <amount>" + newT.get(3) + "</amount>\n";
        xmlData += "  <payments>" + newT.get(4) + "</payments>\n";
        xmlData += "  <card_number>" + newT.get(5) + "</card_number>\n";
        xmlData += "  <expiration_date>" + newT.get(6) + "</expiration_date>\n";
        xmlData += "  <cvv>" + newT.get(7) + "</cvv>\n";
        xmlData += "</visa_payment>\n";
        return xmlData;
    } 

}
