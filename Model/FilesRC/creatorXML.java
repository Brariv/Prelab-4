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
