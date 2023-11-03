package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.CardPayment;
import Model.FilesRC.ReaderJSON;
import View.PaymentProcessor;

public class MainApp {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el path del archivo JSON: ");
        String path = scanner.nextLine();


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

