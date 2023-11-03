package Controller;


import java.util.Scanner;


import View.PaymentProcessor;

public class MainApp {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el path del archivo JSON: ");
        String path = scanner.nextLine();
        paymentProcessor.AssignBrandCard(path);

        if (paymentProcessor.anyErrors()) {
            System.out.println("Se encontraron errores en los siguientes registros: ");
            System.out.println(paymentProcessor.getErrors());
        } else {
            System.out.println("Archivo procesado correctamente.");
        }
        

        scanner.close();
    }
}

