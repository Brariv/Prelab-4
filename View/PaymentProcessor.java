package View;


import java.util.ArrayList;

import Model.CardPayment;
import Model.FilesRC.ReaderJSON;
import Model.FilesRC.creatorCSV;
import Model.FilesRC.creatorXML;
import Model.FilesRC.creatorJSON;
import Model.Coders.hashcoder;
import Model.Coders.emperadorcoder;

public class PaymentProcessor {

    private String cardNumber;
    private ArrayList<ArrayList<String>> Error = new ArrayList<ArrayList<String>>();

    public void AssignBrandCard(String path){
        ReaderJSON readerJSON = new ReaderJSON();
//        ArrayList<placeholder> cards = new ArrayList<placeholder>();
        ArrayList<ArrayList<String>> extracted = readerJSON.readFilesJSON(path);
        processPayment(extracted);
    }



    public void processPayment(ArrayList<ArrayList<String>> extracted) { //cambiar el tipo de dato que devuelve
        //ArrayList<placeholder> cards = new ArrayList<placeholder>();
        for (int i = 0; i < extracted.size(); i++) {
            cardNumber = extracted.get(i).get(5);
            ArrayList<String> saveData = new ArrayList<>();
            for (int j = 0; j < extracted.get(i).size(); j++) {
                saveData.add(extracted.get(i).get(j));
                }
            if (cardNumber.startsWith("4")) {
                double monto = CardPayment.processVisaPayment(Double.parseDouble(extracted.get(i).get(3)));
                // Procesar pago Visa
                saveData.set(4, String.valueOf(monto));
                creatorXML.CreateFilesXML(i, saveData);

            } else if (cardNumber.startsWith("5")) {
                double monto = CardPayment.processMastercardPayment(Double.parseDouble(extracted.get(i).get(3)));
                // Procesar pago Mastercard
                String newcard1 = emperadorcoder.encodeEmperadorString(extracted.get(i).get(5));
                String newcard = hashcoder.encodeMD5String(newcard1);
                saveData.set(5, newcard);
                saveData.set(4, String.valueOf(monto));
                creatorJSON.CreateFilesJSON(i, saveData);
            } else if (cardNumber.startsWith("3")) {
                double monto = CardPayment.processAmericanExpressPayment(Double.parseDouble(extracted.get(i).get(3)), Integer.parseInt(extracted.get(i).get(4)));
                // Procesar pago American Express
                String newcvv = hashcoder.encodeMD5String(extracted.get(i).get(7));
                saveData.set(7, newcvv);
                saveData.set(4, String.valueOf(monto));
                creatorCSV.CreateFilesCSV(i, saveData);
            } else {
                Error.add(extracted.get(i));
            }
        }
    }

    public Boolean anyErrors() {
        if (Error.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<ArrayList<String>> getErrors() {
        return Error;
    }

    /*CardPayment cardPayment = new CardPayment(cardNumber, amount, installments);
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment(cardPayment); */
}
