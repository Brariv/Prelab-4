package Controller;

import java.util.Scanner;

import Model.CardPayment;
import View.PaymentProcessor;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número de tarjeta: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Monto: ");
        double amount = scanner.nextDouble();
        System.out.print("Cuotas (opcional): ");
        int installments = scanner.nextInt();

        CardPayment cardPayment = new CardPayment(cardNumber, amount, installments);
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment(cardPayment);

        scanner.close();
    }
}

