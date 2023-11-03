package View;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.CardPayment;
import Model.FilesRC.ReaderJSON;

public class PaymentProcessor {

    private String cardNumber;
    private ArrayList<ArrayList<String>> Error;

    public void AssignBrandCard(String path){
        ReaderJSON readerJSON = new ReaderJSON();
//        ArrayList<placeholder> cards = new ArrayList<placeholder>();
        ArrayList<ArrayList<String>> extracted = readerJSON.readFilesJSON(path);
        
    }



    public void processPayment(ArrayList<ArrayList<String>> extracted) {
        
        for (int i = 0; i < extracted.size(); i++) {
            cardNumber = extracted.get(i).get(5);
            if (cardNumber.startsWith("4")) {
                double monto = CardPayment.processVisaPayment(Double.parseDouble(extracted.get(i).get(3)));
                // Procesar pago Visa
            } else if (cardNumber.startsWith("5")) {
                // Procesar pago Mastercard
            } else if (cardNumber.startsWith("3")) {
                // Procesar pago American Express
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
