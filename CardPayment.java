import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CardPayment {
    private String cardNumber;
    private double amount;
    private int installments;

    public CardPayment(String cardNumber, double amount, int installments) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.installments = installments;
    }

public boolean isVisa() {
        return cardNumber.startsWith("4");
    }

    public boolean isMastercard() {
        return cardNumber.startsWith("5");
    }

    public boolean isAmericanExpress() {
        return cardNumber.startsWith("3");
    }

    public double processVisaPayment() {
        double commission = amount * 0.05;
        double ivacCommission = commission * 0.12;
        double totalAmount = amount + commission - ivacCommission;
        return totalAmount;
    }

    public String formatVisaPayment() {
        // Formatear la informacion en XML
        String xmlData = "<visa_payment>\n";
        xmlData += "  <card_number>" + cardNumber + "</card_number>\n";
        xmlData += "  <amount>" + amount + "</amount>\n";
        xmlData += "  <commission>" + (amount * 0.05) + "</commission>\n";
        xmlData += "  <ivac_commission>" + ((amount * 0.05) * 0.12) + "</ivac_commission>\n";
        xmlData += "</visa_payment>\n";
        return xmlData;
    }

    public double processMastercardPayment() {
        // Procesar pago de Mastercard para que pueda hacer el proceso 
        return amount;
    }

    public String formatMastercardPayment() {
        // Formatear la información en JSON
        String jsonData = "{\n";
        jsonData += "  \"card_number\":\"" + cardNumber + "\",\n";
        jsonData += "  \"amount\":" + amount + "\n";
        jsonData += "}\n";
        return jsonData;
    }

    public double processAmericanExpressPayment() {
        double serviceFee = amount * 0.07;
        if (installments > 0) {
            serviceFee += serviceFee * 0.15;
        }
        return amount + serviceFee;
    }

    public String formatAmericanExpressPayment() {
        // Formatear la información en CSV
        String csvData = cardNumber + "," + amount + "," + installments + ",";
        String hash = calculateMD5Hash(csvData);
        return csvData + hash;
    }

    private String calculateMD5Hash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
