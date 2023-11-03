package Model.FilesRC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class creatorXML {
    public static void CreateFilesXML(int N,ArrayList<String> newT){
        XStream xstream = new XStream();
        xstream.alias("newT", ArrayList.class);
        String xml = xstream.toXML(newT);
        String path = "Visa"+N+".xml";
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(xml);
            fileWriter.close();
        
            System.out.println("ArrayList was saved to XML file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*public String formatVisaPayment() {
        // Formatear la informacion en XML
        String xmlData = "<visa_payment>\n";
        xmlData += "  <card_number>" + cardNumber + "</card_number>\n";
        xmlData += "  <amount>" + amount + "</amount>\n";
        xmlData += "  <commission>" + (amount * 0.05) + "</commission>\n";
        xmlData += "  <ivac_commission>" + ((amount * 0.05) * 0.12) + "</ivac_commission>\n";
        xmlData += "</visa_payment>\n";
        return xmlData;
    } */
