public class PaymentProcessor {
    public void processPayment(CardPayment cardPayment) {
        if (cardPayment.isVisa()) {
            // Procesar pago Visa
        } else if (cardPayment.isMastercard()) {
            // Procesar pago Mastercard
        } else if (cardPayment.isAmericanExpress()) {
            // Procesar pago American Express
        } else {
            System.out.println("Tarjeta no válida.");
        }
    }
}
