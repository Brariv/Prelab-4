package Model;

public class CardPayment {
    

    public static double processVisaPayment(double amount) {
        double commission = amount * 0.05;
        double ivacCommission = commission * 0.12;
        double totalAmount = amount + commission - ivacCommission;
        return totalAmount;
    }

    public static double processMastercardPayment(double amount) {
        double totalAmount = amount * 7.97;
        return totalAmount;
    }

    public static double processAmericanExpressPayment(double amount, int cuotas) {
        double serviceFee = amount * 0.07;
        if (cuotas > 0) {
            serviceFee += serviceFee * 0.15;
        }
        return amount + serviceFee;
    }
    
}
